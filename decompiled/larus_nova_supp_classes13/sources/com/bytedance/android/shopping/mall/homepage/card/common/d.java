package com.bytedance.android.shopping.mall.homepage.card.common;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Animator.AnimatorListener {
    public final /* synthetic */ ECLynxCardMonitorHolder a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public d(ECLynxCardMonitorHolder r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ECLynxCardMonitorHolder r3 = this.a;
        int r0 = ECLynxCardMonitorHolder.g2;
        r3.I4();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ECLynxCardMonitorHolder r3 = this.a;
        int r0 = ECLynxCardMonitorHolder.g2;
        r3.I4();
    }
}
