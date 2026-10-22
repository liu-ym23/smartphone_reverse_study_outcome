package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f548965a;

    public c(LynxBaseUI r100) {
        this.f548965a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L6;
        int r102 = ((Integer) r101).intValue();
        this.f548965a.getLynxBackground().n(r102);
        this.f548965a.invalidate();
        return;
    }
}
