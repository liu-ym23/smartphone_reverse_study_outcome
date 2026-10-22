package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Float) == true) goto L5;
        r3 = null;
    L5:
        Float r4 = (Float) r3;
        if (r4 == null) goto L9;
        float r5 = r4.floatValue();
        this.a.a.y().setAlpha(r5);
        return;
    }
}
