package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends AnimatorListenerAdapter {
    public final /* synthetic */ ECStockProgressLayout a;

    public k(ECStockProgressLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LottieAnimationView r3 = this.a.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L5:
        r3.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LottieAnimationView r3 = this.a.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L5:
        r3.setVisibility(0);
    }
}
