package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.animation.Animator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ h a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    public l(h r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Iterator r4 = ((ArrayList) this.a.d).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        View r0 = (View) r4.next();
        r0.setAlpha(0.0f);
        x54.b.d(r0);
        goto L4
    }
}
