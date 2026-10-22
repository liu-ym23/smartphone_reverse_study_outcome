package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ t2 a;

    public v2(t2 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L9;
        float r4 = ((Float) r3).floatValue();
        ViewGroup r0 = this.a.y;
        if (r0 == null) goto L10;
        r0.setAlpha(r4);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
