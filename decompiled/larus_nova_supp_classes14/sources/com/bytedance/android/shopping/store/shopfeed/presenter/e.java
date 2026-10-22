package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ ECShopMomentFlowGuidePresenter a;

    public e(ECShopMomentFlowGuidePresenter r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LottieAnimationView r3 = this.a.h;
        if (r3 == null) goto L6;
        r3.playAnimation();
        return;
    }
}
