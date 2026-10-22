package dg5;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class u implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a0 a;

    public /* synthetic */ u(a0 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        a0 r0 = this.a;
        r0.getClass();
        r0.c.setTranslationY(((Integer) r2.getAnimatedValue()).intValue());
    }
}
