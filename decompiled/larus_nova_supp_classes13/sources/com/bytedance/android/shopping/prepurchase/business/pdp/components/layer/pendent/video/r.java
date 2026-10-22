package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ n a;

    public r(n r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        a0 r3 = this.a.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L5:
        ECDraweeView r4 = r3.getIvCover();
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    }
}
