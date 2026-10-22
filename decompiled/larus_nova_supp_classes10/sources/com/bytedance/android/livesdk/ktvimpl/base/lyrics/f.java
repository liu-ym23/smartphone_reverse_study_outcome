package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MvLyricViewV2 a;

    public f(MvLyricViewV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Paint r0 = this.a.getConfig().i;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L9;
        r0.setAlpha(((Integer) r3).intValue());
        MvLyricViewV2 r4 = this.a;
        if (r4.s == true) goto L10;
        r4.invalidate();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
