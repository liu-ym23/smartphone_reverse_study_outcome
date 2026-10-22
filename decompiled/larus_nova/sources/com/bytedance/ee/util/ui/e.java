package com.bytedance.ee.util.ui;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f243158a;

    public e(View r100) {
        this.f243158a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f243158a.setTranslationY(((Float) r100.getAnimatedValue()).floatValue());
    }
}
