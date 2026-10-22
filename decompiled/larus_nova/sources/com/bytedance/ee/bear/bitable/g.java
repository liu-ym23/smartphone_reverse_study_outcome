package com.bytedance.ee.bear.bitable;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f212143a;

    public g(View r100) {
        this.f212143a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        ViewGroup.LayoutParams r103 = this.f212143a.getLayoutParams();
        r103.height = r102;
        this.f212143a.setLayoutParams(r103);
    }
}
