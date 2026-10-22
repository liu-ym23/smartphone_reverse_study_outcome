package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f430578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f430579b;

    public p0(View r100, float r101) {
        this.f430578a = r100;
        this.f430579b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "fraction");
        View r101 = this.f430578a;
        float r102 = this.f430579b;
        r101.setTranslationY(r102 - (r100.getAnimatedFraction() * r102));
        this.f430578a.setAlpha(r100.getAnimatedFraction());
    }
}
