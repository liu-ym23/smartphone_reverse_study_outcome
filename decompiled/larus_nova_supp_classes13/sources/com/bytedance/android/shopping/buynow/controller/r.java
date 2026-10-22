package com.bytedance.android.shopping.buynow.controller;

import android.animation.ValueAnimator;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Window a;

    public r(Window r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        this.a.setDimAmount(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
