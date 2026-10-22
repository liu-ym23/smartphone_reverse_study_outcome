package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUI f548983a;

    public h(LynxUI r100) {
        this.f548983a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L6;
        this.f548983a.getView().setAlpha(((Float) r101).floatValue());
        return;
    }
}
