package gg5;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ i0 a;

    public /* synthetic */ w(i0 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        i0 r0 = this.a;
        r0.getClass();
        r0.d.setTranslationX(-((Integer) r2.getAnimatedValue()).intValue());
    }
}
