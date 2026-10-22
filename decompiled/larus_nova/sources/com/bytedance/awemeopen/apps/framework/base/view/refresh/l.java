package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadMoreFrameLayout f193435a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public l(LoadMoreFrameLayout r100) {
        this.f193435a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LoadMoreFrameLayout r101 = this.f193435a;
        g r102 = r101.f193353h;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.f193356k != (-1)) goto L9;
        r102.onLoadMore();
        return;
    }
}
