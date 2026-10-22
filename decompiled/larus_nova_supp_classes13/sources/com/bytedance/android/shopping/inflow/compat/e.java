package com.bytedance.android.shopping.inflow.compat;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VideoZoomableToggleBottomSheetFragment a;

    public e(VideoZoomableToggleBottomSheetFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        this.a.Z90(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
