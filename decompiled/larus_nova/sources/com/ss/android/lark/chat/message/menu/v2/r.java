package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f415903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f415904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f415905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f415906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f415907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function2<Float, a, Unit> f415908f;

    /* JADX WARN: Multi-variable type inference failed */
    public r(a r100, float r101, float r102, float r103, float r104, Function2<? super Float, ? super a, Unit> r105) {
        this.f415903a = r100;
        this.f415904b = r101;
        this.f415905c = r102;
        this.f415906d = r103;
        this.f415907e = r104;
        this.f415908f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Float r101 = (Float) r100.getAnimatedValue();
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
    L6:
        float r103 = r102 / 1000.0f;
        this.f415903a.f415668b.setTranslationY(this.f415904b + (this.f415905c * r103));
        float r104 = this.f415906d + (this.f415907e * r103);
        this.f415908f.invoke(Float.valueOf(r104), this.f415903a);
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }
}
