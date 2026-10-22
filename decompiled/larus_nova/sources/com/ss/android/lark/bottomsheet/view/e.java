package com.ss.android.lark.bottomsheet.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4773a f410759a;

    public e(com.ss.android.lark.bottomsheet.h r100) {
        this.f410759a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a.InterfaceC4773a r101 = this.f410759a;
        if (r101 == null) goto L6;
        r101.d(r100.getAnimatedFraction());
        return;
    }
}
