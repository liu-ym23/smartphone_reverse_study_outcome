package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f412089a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super Float, Unit> r100) {
        this.f412089a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Function1<Float, Unit> r101 = this.f412089a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r101.invoke((Float) r102);
    }
}
