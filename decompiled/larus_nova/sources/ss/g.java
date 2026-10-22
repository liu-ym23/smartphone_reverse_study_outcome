package ss;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f543312a;

    public g(e r100) {
        this.f543312a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue("x")).intValue();
        int r102 = ((Integer) r100.getAnimatedValue("y")).intValue();
        this.f543312a.f543287a.a(r101, r102);
        this.f543312a.f543288b.getClass();
    }
}
