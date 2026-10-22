package com.bytedance.ee.util.ui;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f243159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f243160b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ViewGroup.LayoutParams r101 = this.f243159a;
        r101.height = ((Integer) r100.getAnimatedValue()).intValue();
        this.f243160b.requestLayout();
    }

    public f(ViewGroup.LayoutParams r100, View r101) {
        this.f243159a = r100;
        this.f243160b = r101;
    }
}
