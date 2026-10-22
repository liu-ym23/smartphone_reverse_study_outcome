package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f430554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f430555b;

    public m0(View r100, float r101) {
        this.f430554a = r100;
        this.f430555b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "fraction");
        this.f430554a.setTranslationY(this.f430555b * r100.getAnimatedFraction());
        this.f430554a.setAlpha(1 - r100.getAnimatedFraction());
    }
}
