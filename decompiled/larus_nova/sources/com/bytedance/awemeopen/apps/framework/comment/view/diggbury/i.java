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
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f194257a;

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

    public i(h r100) {
        this.f194257a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        h r101 = this.f194257a;
        boolean r102 = true;
        if (r101.f194249b.p() == true) goto L6;
        r102 = false;
    L6:
        r101.f194254g = r102;
        this.f194257a.b();
        Iterator r103 = ((ArrayList) this.f194257a.f194251d).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        View r104 = (View) r103.next();
        r104.setAlpha(1.0f);
        x54.b.a(r104);
        goto L8
    L10:
        DuxTextView r105 = this.f194257a.f194252e;
        if (r105 == null) goto L14;
        r105.setAlpha(1.0f);
    L14:
        h r106 = this.f194257a;
        d r107 = r106.f194250c;
        BuryView2 r108 = null;
        if (r107 == null) goto L17;
        DiggNewView2 r109 = r107.f194239e;
    L18:
        if (r109 == null) goto L21;
        r109.setAlpha(1.0f);
    L21:
        d r110 = r106.f194250c;
        if (r110 == null) goto L24;
        r108 = r110.f194240f;
    L24:
        if (r108 == null) goto L27;
        r108.setAlpha(1.0f);
    L27:
        this.f194257a.f194253f = false;
        return;
    L17:
        r109 = null;
        goto L18
    }
}
