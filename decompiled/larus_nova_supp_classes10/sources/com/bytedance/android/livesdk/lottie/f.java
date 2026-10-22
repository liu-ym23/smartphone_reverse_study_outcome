package com.bytedance.android.livesdk.lottie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        g r3 = this.a;
        CommonLottieAnimationWidget.wq(r3.a, r3.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2);
        ((LottieService.a) this.a.b.c).a.onNext(1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2, r3);
        g r4 = this.a;
        CommonLottieAnimationWidget.wq(r4.a, r4.b);
    }
}
