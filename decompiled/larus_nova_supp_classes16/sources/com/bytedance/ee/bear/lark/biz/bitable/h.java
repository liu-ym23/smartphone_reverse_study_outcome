package com.bytedance.ee.bear.lark.biz.bitable;

import android.animation.Animator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ BitableTabFragmentV2 a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public h(BitableTabFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r3 = null;
    L5:
        r3.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r3 = null;
    L5:
        r3.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("homeLoadingTextView");
        r3 = null;
    L5:
        r3.setVisibility(0);
    }
}
