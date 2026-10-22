package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        c r0 = this.a;
        r0.x = true;
        Object r1 = r4.getAnimatedValue();
        if (r1 == null) goto L7;
        r0.s = ((Float) r1).floatValue();
        c r2 = this.a;
        r2.t = r4.getCurrentPlayTime();
        this.a.invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
