package com.ss.android.lark.inline.ai.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f427500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f427501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f427503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f427504e;

    public g(int r100, int r101, InlineAIDragView r102, float r103, float r104) {
        this.f427500a = r100;
        this.f427501b = r101;
        this.f427502c = r102;
        this.f427503d = r103;
        this.f427504e = r104;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        int r103 = this.f427500a;
        float r104 = r103 + ((this.f427501b - r103) * r102);
        ViewGroup r105 = this.f427502c.f427356c;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (this.f427502c.f427362i != null) goto L5;
        int r107 = -2;
    L6:
        r106.height = r107;
        r105.setLayoutParams(r106);
        float r108 = this.f427503d;
        this.f427502c.f427356c.setTranslationY(r108 + ((this.f427504e - r108) * r102));
        return;
    L5:
        r107 = (int) r104;
        goto L6
    }
}
