package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;

    public f(c r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        c r0 = this.a;
        if (r0.w == r4) goto L5;
        return;
    L5:
        r0.s = 1.0f;
        r0.t = Long.MAX_VALUE;
        r0.requestLayout();
        this.a.invalidate();
    }
}
