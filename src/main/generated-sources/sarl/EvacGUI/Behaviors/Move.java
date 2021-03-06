package EvacGUI.Behaviors;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

@SarlSpecification("0.5")
@SarlElementType(17)
@SuppressWarnings("all")
public interface Move extends Capacity {
  public abstract void Escape();
  
  public abstract void Speed();
  
  public static class ContextAwareCapacityWrapper<C extends Move> extends Capacity.ContextAwareCapacityWrapper<C> implements Move {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void Escape() {
      try {
        ensureCallerInLocalThread();
        this.capacity.Escape();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void Speed() {
      try {
        ensureCallerInLocalThread();
        this.capacity.Speed();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
