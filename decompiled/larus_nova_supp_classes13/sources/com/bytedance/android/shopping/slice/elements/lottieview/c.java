package com.bytedance.android.shopping.slice.elements.lottieview;

import android.animation.Animator;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ d a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ECLottieAnimationView r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.setVisibility(4);
    L5:
        ECDraweeView r4 = this.a.d;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ECLottieAnimationView r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.setVisibility(4);
    L5:
        ECDraweeView r4 = this.a.d;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ECLottieAnimationView r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        ECDraweeView r4 = this.a.d;
        if (r4 == null) goto L9;
        r4.setVisibility(4);
        return;
    }
}
