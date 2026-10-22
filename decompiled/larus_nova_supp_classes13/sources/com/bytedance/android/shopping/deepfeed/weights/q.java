package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DeepFeedProductInfoMarqueeView a;

    public q(DeepFeedProductInfoMarqueeView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L20;
        float r5 = ((Float) r4).floatValue();
        DeepFeedProductInfoMarqueeView r0 = this.a;
        if (r0.j == false) goto L12;
        View r1 = r0.a;
        if (r1 == null) goto L9;
        r1.setTranslationY(r5);
    L9:
        DeepFeedProductInfoMarqueeView r2 = this.a;
        View r6 = r2.b;
        if (r6 == null) goto L21;
        r6.setTranslationY(r2.c + r5);
        return;
    L21:
        return;
    L12:
        View r7 = r0.a;
        if (r7 == null) goto L15;
        r7.setTranslationY(r0.c + r5);
    L15:
        View r8 = this.a.b;
        if (r8 == null) goto L23;
        r8.setTranslationY(r5);
        return;
    L23:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
