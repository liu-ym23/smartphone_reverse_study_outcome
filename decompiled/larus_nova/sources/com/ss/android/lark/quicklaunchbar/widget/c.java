package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QuickLaunchBar f439149a;

    public c(QuickLaunchBar r100) {
        this.f439149a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.LayoutParams r101 = this.f439149a.f439138d.f439127a.getLayoutParams();
        if (r101 == null) goto L5;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.height = ((Integer) r102).intValue();
    L5:
        this.f439149a.requestLayout();
    }
}
