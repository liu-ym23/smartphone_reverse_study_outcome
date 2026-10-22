package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ l a;

    public m(l r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L12;
        int r5 = ((Integer) r4).intValue();
        int r0 = r5 % 100;
        int r1 = 100;
        if (r0 != 0) goto L8;
        if (r5 == 0) goto L8;
    L9:
        this.a.setProgress(Math.abs(r1));
        return;
    L8:
        r1 = (r0 + 100) % 100;
        goto L9
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
