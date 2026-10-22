package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.animation.Animator;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Animator.AnimatorListener {
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

    public i(h r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animator");
        h r6 = this.a;
        boolean r2 = true;
        if (r6.b.p() == true) goto L6;
        r2 = false;
    L6:
        r6.g = r2;
        this.a.b();
        Iterator r7 = ((ArrayList) this.a.d).iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        View r0 = (View) r7.next();
        r0.setAlpha(1.0f);
        x54.b.a(r0);
        goto L8
    L10:
        DuxTextView r8 = this.a.e;
        if (r8 == null) goto L14;
        r8.setAlpha(1.0f);
    L14:
        h r9 = this.a;
        d r1 = r9.c;
        BuryView2 r3 = null;
        if (r1 == null) goto L17;
        DiggNewView2 r4 = r1.e;
    L18:
        if (r4 == null) goto L21;
        r4.setAlpha(1.0f);
    L21:
        d r10 = r9.c;
        if (r10 == null) goto L24;
        r3 = r10.f;
    L24:
        if (r3 == null) goto L27;
        r3.setAlpha(1.0f);
    L27:
        this.a.f = false;
        return;
    L17:
        r4 = null;
        goto L18
    }
}
