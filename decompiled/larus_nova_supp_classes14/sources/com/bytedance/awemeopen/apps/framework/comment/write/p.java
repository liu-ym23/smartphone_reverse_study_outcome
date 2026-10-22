package com.bytedance.awemeopen.apps.framework.comment.write;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements Animator.AnimatorListener {
    public final /* synthetic */ n a;
    public final /* synthetic */ ObjectAnimator b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.c = false;
        this.b.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        boolean r0 = false;
        this.a.c = false;
        this.b.removeListener(this);
        n r6 = this.a;
        r6.b = 3;
        ViewGroup r1 = r6.d;
        if (r1 == null) goto L10;
        View r2 = r6.e;
        Intrinsics.checkNotNull(r2);
        if (r1.indexOfChild(r2) == (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 != true) goto L10;
        r0 = true;
        goto L10
    L7:
        r3 = false;
    L10:
        if (r0 == false) goto L18;
        ViewGroup r4 = r6.d;
        if (r4 == null) goto L14;
        r4.removeView(r6.f);
    L14:
        ViewGroup r7 = r6.d;
        if (r7 == null) goto L19;
        r7.removeView(r6.e);
        return;
    L19:
        return;
    }

    public p(n r1, ObjectAnimator r2) {
        this.a = r1;
        this.b = r2;
    }
}
