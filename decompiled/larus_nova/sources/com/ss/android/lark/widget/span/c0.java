package com.ss.android.lark.widget.span;

import android.animation.ValueAnimator;
import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class c0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f448657a;

    public c0(b0 r100) {
        this.f448657a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        float r101 = this.f448657a.f448652c;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        int r103 = MathKt.roundToInt(r101 * ((Float) r102).floatValue());
        b0 r104 = this.f448657a;
        r104.f448651b.setColor(Color.argb(r103, r104.f448653d, r104.f448655f, r104.f448654e));
        this.f448657a.invalidateSelf();
    }
}
