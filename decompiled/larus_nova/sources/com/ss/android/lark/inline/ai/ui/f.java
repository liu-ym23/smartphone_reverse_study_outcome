package com.ss.android.lark.inline.ai.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f427494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f427495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f427497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f427498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f427499f;

    public f(int r100, int r101, InlineAIDragView r102, int r103, int r104, float r105) {
        this.f427494a = r100;
        this.f427495b = r101;
        this.f427496c = r102;
        this.f427497d = r103;
        this.f427498e = r104;
        this.f427499f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        int r103 = this.f427494a;
        float r104 = r103 + ((this.f427495b - r103) * r102);
        ViewGroup r105 = this.f427496c.f427356c;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (this.f427496c.f427362i != null) goto L5;
        int r107 = -2;
    L6:
        r106.height = r107;
        r105.setLayoutParams(r106);
        int r108 = this.f427497d;
        float r109 = r108 + ((this.f427498e - r108) * r102);
        ViewGroup r110 = this.f427496c.f427356c;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.bottomMargin = (int) r109;
        r110.setLayoutParams(r112);
        float r113 = this.f427499f;
        this.f427496c.f427356c.setTranslationY(r113 + ((0.0f - r113) * r102));
        return;
    L5:
        r107 = (int) r104;
        goto L6
    }
}
