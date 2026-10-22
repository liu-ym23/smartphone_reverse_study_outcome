package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends AnimatorListenerAdapter {
    public final /* synthetic */ DeepFeedProductSlcWithAnimVH a;

    public s(DeepFeedProductSlcWithAnimVH r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.p0 = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        DeepFeedProductSlcWithAnimVH r3 = this.a;
        int r0 = DeepFeedProductSlcWithAnimVH.H0;
        r3.K4(0.0f);
        this.a.p0 = null;
    }
}
