package com.ss.android.lark.cameraview;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f410868a;

    public b0(w r100) {
        this.f410868a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        w r101 = this.f410868a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r101.f411037n = ((Float) r102).floatValue();
        w r103 = this.f410868a;
        float r104 = r103.f411037n - (r103.f411031h / 2);
        RectF r105 = r103.f411046w;
        float r106 = r103.f411034k;
        float r107 = r103.f411035l;
        r105.set(r106 - r104, r107 - r104, r106 + r104, r107 + r104);
        this.f410868a.invalidate();
    }
}
