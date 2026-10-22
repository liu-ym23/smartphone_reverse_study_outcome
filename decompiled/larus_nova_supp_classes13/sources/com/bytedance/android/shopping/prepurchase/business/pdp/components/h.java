package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LastPageVideoZoomer a;
    public final /* synthetic */ View b;

    public h(LastPageVideoZoomer r1, CompatFrameLayout r2) {
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
