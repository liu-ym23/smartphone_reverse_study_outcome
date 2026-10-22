package fu;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import java.lang.reflect.Method;
import wu.w1;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends BaseControllerListener {
    public b() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        if ((r102 instanceof AnimatedDrawable2) == false) goto L15;
        Method r103 = c.f478831a;
        if (r103 == null) goto L16;
        w1 r104 = w1.f561409a;
        if (r104.getValue() != null) goto L9;
        return;
    L9:
        if (r104.getValue().booleanValue() == false) goto L18;
        r103.invoke(r102, new Object[]{new DropFramesFrameScheduler(((AnimatedDrawable2) r102).getAnimationBackend())});     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L18:
        return;
    L16:
        return;
    }
}
