package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ LoadMoreFrameLayout a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public l(LoadMoreFrameLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        LoadMoreFrameLayout r4 = this.a;
        g r0 = r4.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.k != (-1)) goto L9;
        r0.onLoadMore();
        return;
    }
}
