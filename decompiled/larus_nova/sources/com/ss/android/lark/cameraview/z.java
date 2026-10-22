package com.ss.android.lark.cameraview;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class z implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f411060a;

    public z(w r100) {
        this.f411060a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        w r101 = this.f411060a;
        r101.f411045v = (int) r100.getCurrentPlayTime();
        w r102 = this.f411060a;
        Object r103 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
        r102.f411042s = ((Float) r103).floatValue();
        this.f411060a.invalidate();
    }
}
