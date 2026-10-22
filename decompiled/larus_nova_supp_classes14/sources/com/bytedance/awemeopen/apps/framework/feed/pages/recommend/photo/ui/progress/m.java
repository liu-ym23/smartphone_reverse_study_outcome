package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements Animator.AnimatorListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ StoryListProgressBar c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        int r4 = this.a - 1;
        if (this.b > r4) goto L10;
    L4:
        View r0 = this.c.getChildAt(r4);
        if (r0 == null) goto L8;
        this.c.removeView(r0);
    L8:
        if (r4 == this.b) goto L12;
        r4 = r4 - 1;
        goto L4
    L12:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        int r4 = this.a - 1;
        if (this.b > r4) goto L10;
    L4:
        View r0 = this.c.getChildAt(r4);
        if (r0 == null) goto L8;
        this.c.removeView(r0);
    L8:
        if (r4 == this.b) goto L12;
        r4 = r4 - 1;
        goto L4
    L12:
        return;
    }

    public m(int r1, int r2, StoryListProgressBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
