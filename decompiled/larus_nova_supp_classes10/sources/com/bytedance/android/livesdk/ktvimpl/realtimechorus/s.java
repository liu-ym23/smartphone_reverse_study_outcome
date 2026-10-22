package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements ValueAnimator.AnimatorUpdateListener {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        if (r0 == null) goto L9;
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L8;
        r0.m(((Float) r4).floatValue(), false, false);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
