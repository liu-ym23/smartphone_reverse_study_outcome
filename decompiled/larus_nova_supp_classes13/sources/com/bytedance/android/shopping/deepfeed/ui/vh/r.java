package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DeepFeedProductSlcWithAnimVH a;

    public r(DeepFeedProductSlcWithAnimVH r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        float r5 = ((Float) r4).floatValue();
        DeepFeedProductSlcWithAnimVH r0 = this.a;
        int r1 = DeepFeedProductSlcWithAnimVH.H0;
        r0.K4(r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
