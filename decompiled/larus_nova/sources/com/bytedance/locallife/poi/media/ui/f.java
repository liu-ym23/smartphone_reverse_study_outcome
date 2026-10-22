package com.bytedance.locallife.poi.media.ui;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerticalOverScrollLayout f262848a;

    public f(VerticalOverScrollLayout r100) {
        this.f262848a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        VerticalOverScrollLayout r101 = this.f262848a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        int r103 = ((Integer) r102).intValue();
        int r104 = VerticalOverScrollLayout.f262835i;
        r101.b(r103);
    }
}
