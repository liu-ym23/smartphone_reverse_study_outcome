package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

    public x(ECShopFloatCartEntryPresenterV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L7;
        float r6 = ((Float) r5).floatValue();
        ViewGroup.LayoutParams r0 = ECShopFloatCartEntryPresenterV2.T(this.a).getLayoutParams();
        ECShopFloatCartEntryPresenterV2 r1 = this.a;
        r0.width = (int) (r1.v * r6);
        ECShopFloatCartEntryPresenterV2.T(r1).setLayoutParams(r0);
        ECShopFloatCartEntryPresenterV2.T(this.a).setAlpha(r6);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
