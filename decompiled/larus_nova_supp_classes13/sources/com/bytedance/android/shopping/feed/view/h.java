package com.bytedance.android.shopping.feed.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ InflowFeedCouponUrgeView a;

    public h(InflowFeedCouponUrgeView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setVisibility(8);
        this.a.setAlpha(1.0f);
    }
}
