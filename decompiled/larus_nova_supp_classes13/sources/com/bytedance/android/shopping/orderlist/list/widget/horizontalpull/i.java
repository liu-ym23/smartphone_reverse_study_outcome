package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ PageHorizontalPullLayout a;

    public i(PageHorizontalPullLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        PageHorizontalPullLayout r3 = this.a;
        int r0 = PageHorizontalPullLayout.s;
        r3.getClass();
        PageHorizontalPullLayout r4 = this.a;
        r4.i = 0.0f;
        r4.l = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        PageHorizontalPullLayout r3 = this.a;
        c r0 = r3.o;
        if (r0 == null) goto L5;
        r0.f(r3.m);
    L5:
        this.a.getClass();
        PageHorizontalPullLayout r4 = this.a;
        r4.i = 0.0f;
        r4.l = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        c r3 = this.a.o;
        if (r3 == null) goto L5;
        r3.e();
    L5:
        this.a.l = true;
    }
}
