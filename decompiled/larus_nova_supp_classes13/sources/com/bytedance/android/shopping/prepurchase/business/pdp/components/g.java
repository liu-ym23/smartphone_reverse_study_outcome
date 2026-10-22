package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LastPageVideoZoomer a;
    public final /* synthetic */ View b;

    public g(LastPageVideoZoomer r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        float r5 = ((Float) r4).floatValue();
        LastPageVideoZoomer.b(this.a, r5, this.b);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
