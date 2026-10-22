package com.ss.android.lark.keyboard.ime;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f429400a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super Float, Unit> r100) {
        this.f429400a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Function1<Float, Unit> r101 = this.f429400a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r101.invoke((Float) r102);
    }
}
