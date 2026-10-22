package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements Animator.AnimatorListener {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public y(ECShopFloatCartEntryPresenterV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ECShopFloatCartEntryPresenterV2.T(this.a).setVisibility(8);
        ECShopFloatCartEntryPresenterV2.S(this.a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ECShopFloatCartEntryPresenterV2.T(this.a).setVisibility(8);
        ECShopFloatCartEntryPresenterV2.S(this.a);
    }
}
