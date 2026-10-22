package com.ss.android.lark.keyboard.widget;

import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoundedIconTextView f431050a;

    public j(RoundedIconTextView r100) {
        this.f431050a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        RoundedIconTextView r101 = this.f431050a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        float r103 = ((Float) r102).floatValue();
        PathInterpolator r104 = RoundedIconTextView.F;
        r101.b(r103);
    }
}
