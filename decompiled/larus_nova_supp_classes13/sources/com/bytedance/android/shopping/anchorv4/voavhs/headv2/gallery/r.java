package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Function1 a;

    public r(Function1 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Function1 r0 = this.a;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r0.invoke((Float) r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
