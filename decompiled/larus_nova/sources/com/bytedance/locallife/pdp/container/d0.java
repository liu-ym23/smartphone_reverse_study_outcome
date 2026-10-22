package com.bytedance.locallife.pdp.container;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f261140a;

    public d0(a0 r100) {
        this.f261140a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        FrameLayout r101 = this.f261140a.f261115c;
        if (r101 == null) goto L6;
        float r102 = wo6.a.c(r101.getContext());
        Object r103 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
        r101.setTranslationX(r102 * ((Float) r103).floatValue());
        return;
    }
}
