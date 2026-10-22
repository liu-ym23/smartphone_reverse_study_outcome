package com.bytedance.ee.bear.bitable.superagent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ BitableSuperAgentGlowAnimationView b;

    public d(BitableSuperAgentGlowAnimationView r1) {
        this.b = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == false) goto L5;
        return;
    L5:
        BitableSuperAgentGlowAnimationView r3 = this.b;
        BitableSuperAgentGlowAnimationView.a(r3, r3.d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = false;
    }
}
