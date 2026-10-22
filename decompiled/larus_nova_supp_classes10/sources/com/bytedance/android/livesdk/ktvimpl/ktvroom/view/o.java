package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ j a;

    public o(j r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        this.a.N.e = r4;
        this.a.M.e = r4;
        this.a.O.e = r4;
        this.a.P.e = r4;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
