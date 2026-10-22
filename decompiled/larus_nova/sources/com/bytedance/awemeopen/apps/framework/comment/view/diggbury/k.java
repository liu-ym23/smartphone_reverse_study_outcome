package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.animation.Animator;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f194259a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    public k(h r100) {
        this.f194259a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        h r101 = this.f194259a;
        if (r101.f194249b.p() != true) goto L5;
        boolean r102 = true;
    L6:
        r101.f194254g = r102;
        this.f194259a.b();
        DuxTextView r103 = this.f194259a.f194252e;
        if (r103 == null) goto L9;
        r103.setAlpha(1.0f);
        x54.b.a(r103);
    L9:
        Iterator r104 = ((ArrayList) this.f194259a.f194251d).iterator();
        BuryView2 r105 = null;
        Boolean r106 = null;
    L11:
        if (r104.hasNext() == false) goto L21;
        View r107 = (View) r104.next();
        if (r106 != null) goto L20;
        if (r107.getAlpha() != 0.0f) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        r106 = Boolean.TRUE;
        goto L20
    L17:
        r108 = false;
    L20:
        r107.setAlpha(1.0f);
        goto L11
    L21:
        d r109 = this.f194259a.f194250c;
        if (r109 == null) goto L24;
        DiggNewView2 r110 = r109.f194239e;
    L25:
        if (r110 == null) goto L28;
        r110.setAlpha(1.0f);
    L28:
        d r111 = this.f194259a.f194250c;
        if (r111 == null) goto L31;
        r105 = r111.f194240f;
    L31:
        if (r105 == null) goto L34;
        r105.setAlpha(1.0f);
    L34:
        this.f194259a.f194253f = false;
        return;
    L24:
        r110 = null;
        goto L25
    L5:
        r102 = false;
        goto L6
    }
}
