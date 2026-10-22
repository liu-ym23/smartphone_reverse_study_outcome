package com.larus.dora.impl.onboarding;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class v {
    public static ValueAnimator a(final float r100, final long r101, final Function1 r102, Function0 r103) {
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r100, 0.0f});
        r104.setInterpolator(new LinearInterpolator());
        r104.setDuration(r101);
        r104.addUpdateListener(new t(r101, r100, r102));
        r104.addListener(new u(null, r103));
        return r104;
    }
}
