package com.bytedance.ee.bear.widgets.popupmenu;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PopupMenuView b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public b(PopupMenuView r2) {
        this.a = false;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == true) goto L5;
        this.b.setVisibility(8);
    L5:
        this.b.e = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == true) goto L5;
        this.b.setVisibility(8);
    L5:
        this.b.e = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == false) goto L5;
        PopupMenuView r3 = this.b;
        int r0 = PopupMenuView.g;
        r3.getClass();
        return;
    L5:
        PopupMenuView r4 = this.b;
        int r1 = PopupMenuView.g;
        r4.getClass();
    }
}
