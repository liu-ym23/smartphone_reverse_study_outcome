package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ y c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.setAlpha(0.0f);
        LinearLayout r4 = this.b;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.height = -2;
        r4.setLayoutParams(r0);
        this.b.requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.getVisibility() == 0) goto L5;
        return;
    L5:
        this.a.setAlpha(1.0f);
        LinearLayout r4 = this.b;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.height = -2;
        r4.setLayoutParams(r0);
        this.b.requestLayout();
        this.a.requestLayout();
        this.c.u = null;
    }

    public z(LinearLayout r1, LinearLayout r2, y r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
