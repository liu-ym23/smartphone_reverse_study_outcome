package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.animation.Animator;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f194258a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    public j(h r100) {
        this.f194258a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        h r101 = this.f194258a;
        DuxTextView r102 = r101.f194252e;
        if (r102 == null) goto L6;
        r101.c(r102);
        r102.setAlpha(0.0f);
        x54.b.d(r102);
        return;
    }
}
