package com.suite.lark.platform.feature.forward.doubao;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoForwardConfirmFragment f461275a;

    public a(DoubaoForwardConfirmFragment r100) {
        this.f461275a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        DoubaoForwardConfirmFragment r101 = this.f461275a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        int r103 = ((Integer) r102).intValue();
        int r104 = DoubaoForwardConfirmFragment.f461206v;
        r101.Y90(r103);
    }
}
