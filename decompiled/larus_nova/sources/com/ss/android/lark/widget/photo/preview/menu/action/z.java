package com.ss.android.lark.widget.photo.preview.menu.action;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f446932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f446933b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) this.f446932a.getLayoutParams();
        r101.topMargin = (int) (((Float) r100.getAnimatedValue()).floatValue() * this.f446933b);
        this.f446932a.setLayoutParams(r101);
    }

    public z(View r100, int r101) {
        this.f446932a = r100;
        this.f446933b = r101;
    }
}
