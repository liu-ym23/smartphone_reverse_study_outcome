package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f461170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f461171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f461172c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        FrameLayout r100 = this.f461170a;
        int r101 = this.f461171b;
        int r102 = this.f461172c;
        float r111 = ((Float) r110.getAnimatedValue()).floatValue();
        int r103 = r100.getChildCount();
        int r104 = r103 - 1;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        int r106 = (int) (((((r104 - r105) - 1) * r101) * 2) + ((r101 * 2) * r111));
        View r107 = r100.getChildAt(r105);
        int r108 = r105 * r101;
        if (r103 <= 3) goto L7;
        r108 = (int) (r108 - (r101 * r111));
    L7:
        r107.setPadding(r106, r108, r106, 0);
        if (r107.getHeight() <= r102) goto L10;
        r107.getLayoutParams().height = r107.getHeight() + ((int) ((r102 - r107.getHeight()) * r111));
        r107.requestLayout();
    L10:
        r105 = r105 + 1;
        goto L3
    }

    public b(DialogAnimationLayout r100, int r101, int r102) {
        this.f461170a = r100;
        this.f461171b = r101;
        this.f461172c = r102;
    }
}
