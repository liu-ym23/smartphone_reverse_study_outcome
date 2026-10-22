package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ m b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.setAlpha(0.0f);
        ViewGroup r4 = this.b.k();
        ViewGroup.LayoutParams r0 = this.b.k().getLayoutParams();
        r0.height = -2;
        r4.setLayoutParams(r0);
        this.b.k().requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.getVisibility() == 0) goto L5;
        return;
    L5:
        this.a.setAlpha(1.0f);
        ViewGroup r4 = this.b.k();
        ViewGroup.LayoutParams r0 = this.b.k().getLayoutParams();
        r0.height = -2;
        r4.setLayoutParams(r0);
        this.b.k().requestLayout();
        this.a.requestLayout();
    }

    public n(ViewGroup r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
