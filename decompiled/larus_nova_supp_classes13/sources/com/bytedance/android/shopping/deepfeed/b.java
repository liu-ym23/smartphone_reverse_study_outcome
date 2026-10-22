package com.bytedance.android.shopping.deepfeed;

import android.animation.Animator;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ Map a;
    public final /* synthetic */ c b;
    public final /* synthetic */ he3.l c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        DeepFeedProductFragment r4 = this.b.a;
        AbsDeepFeedProductVH r0 = r4.v;
        if (r0 == null) goto L6;
        r0.y4(this.c, r4.aa0());
        return;
    }

    public b(Map r1, c r2, he3.l r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
