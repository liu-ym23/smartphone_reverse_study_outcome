package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f461175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f461176b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        FrameLayout r100 = this.f461175a;
        int r101 = this.f461176b;
        float r111 = ((Float) r110.getAnimatedValue()).floatValue();
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L35;
        int r104 = r102 - 1;
        int r105 = r104 - r103;
        View r106 = r100.getChildAt(r105);
        if (r106 == null) goto L44;
        jpc.a r107 = (jpc.a) r106.getTag();
        if (r107 == null) goto L45;
        int r108 = r107.f500013b;
        if (r105 >= r104) goto L13;
        int r112 = r104 - r105;
    L15:
        if (r112 < 3) goto L18;
        r112 = 3;
    L18:
        int r113 = 2;
        int r109 = (int) (r108 + ((((r112 * r101) * 2) - r108) * r111));
        int r114 = r107.f500014c;
        if (r105 >= r104) goto L21;
        int r115 = r105;
    L22:
        if (r115 >= 2) goto L24;
        r113 = r115;
    L24:
        r106.setPadding(r109, (int) (r114 + (((r113 * r101) - r114) * r111)), r109, 0);
        if (r105 != r104) goto L34;
        if (r107.f500012a <= r106.getHeight()) goto L30;
        r106.getLayoutParams().height = r106.getHeight() + ((int) ((r107.f500012a - r106.getHeight()) * r111));
        r106.requestLayout();
        goto L34
    L30:
        if (r107.f500012a != 0) goto L34;
        if (r106.getLayoutParams().height == (-2)) goto L34;
        r106.getLayoutParams().height = -2;
        r106.requestLayout();
    L34:
        r103 = r103 + 1;
        goto L3
    L21:
        r115 = r104;
        goto L22
    L13:
        r112 = 0;
        goto L15
    L45:
        return;
    L44:
        return;
    }

    public d(DialogAnimationLayout r100, int r101) {
        this.f461175a = r100;
        this.f461176b = r101;
    }
}
