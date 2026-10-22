package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ ECShopMomentFlowGuidePresenter a;

    public f(ECShopMomentFlowGuidePresenter r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.i;
        if (r3 == null) goto L6;
        r3.setVisibility(4);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.i;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }
}
