package com.ss.android.lark.biz.im.extension.panel.drag;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f410534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f410535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DragPanel f410536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f410537d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(float r100, float r101, DragPanel r102, Function1<? super Float, Unit> r103) {
        this.f410534a = r100;
        this.f410535b = r101;
        this.f410536c = r102;
        this.f410537d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Float r101 = (Float) r100.getAnimatedValue();
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
    L6:
        float r103 = r102 / 1000.0f;
        float r104 = this.f410534a + (this.f410535b * r103);
        this.f410536c.f410512j.setTranslationY(r104);
        this.f410537d.invoke(Float.valueOf(r103));
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }
}
