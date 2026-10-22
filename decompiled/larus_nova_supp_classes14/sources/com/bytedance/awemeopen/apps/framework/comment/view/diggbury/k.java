package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.animation.Animator;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements Animator.AnimatorListener {
    public final /* synthetic */ h a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    public k(h r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [android.view.View, com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView] */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r9) {
        Intrinsics.checkNotNullParameter(r9, "animator");
        h r10 = this.a;
        if (r10.b.p() != true) goto L5;
        boolean r0 = true;
    L6:
        r10.g = r0;
        this.a.b();
        ?? r11 = this.a.e;
        if (r11 == 0) goto L9;
        r11.setAlpha(1.0f);
        x54.b.a(r11);
    L9:
        Iterator r12 = ((ArrayList) this.a.d).iterator();
        BuryView2 r3 = null;
        Boolean r4 = null;
    L11:
        if (r12.hasNext() == false) goto L21;
        View r5 = (View) r12.next();
        if (r4 != null) goto L20;
        if (r5.getAlpha() != 0.0f) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        r4 = Boolean.TRUE;
        goto L20
    L17:
        r6 = false;
    L20:
        r5.setAlpha(1.0f);
        goto L11
    L21:
        d r13 = this.a.c;
        if (r13 == null) goto L24;
        DiggNewView2 r14 = r13.e;
    L25:
        if (r14 == null) goto L28;
        r14.setAlpha(1.0f);
    L28:
        d r15 = this.a.c;
        if (r15 == null) goto L31;
        r3 = r15.f;
    L31:
        if (r3 == null) goto L34;
        r3.setAlpha(1.0f);
    L34:
        this.a.f = false;
        return;
    L24:
        r14 = null;
        goto L25
    L5:
        r0 = false;
        goto L6
    }
}
