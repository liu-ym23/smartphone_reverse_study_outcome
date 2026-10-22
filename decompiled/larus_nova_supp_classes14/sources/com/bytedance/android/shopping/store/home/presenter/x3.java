package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ECStoreAwemeFeedVideoZoomController a;

    public x3(ECStoreAwemeFeedVideoZoomController r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        ECStoreAwemeFeedVideoZoomController r0 = this.a;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        ECStoreAwemeFeedVideoZoomController.a(r0, ((Integer) r3).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
