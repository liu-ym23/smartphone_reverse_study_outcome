package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class u extends RecyclerView.u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f401956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.obric.oui.orecyclerview.base.e f401957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f401958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f401959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f401960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f401961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f401962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f401963p;

    public u(Context r100) {
        this.f401956i = new LinearInterpolator();
        this.f401957j = new com.obric.oui.orecyclerview.base.e();
        this.f401960m = false;
        this.f401962o = 0;
        this.f401963p = 0;
        Resources r101 = r100.getResources();
        this.f401959l = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
    }

    public float e(DisplayMetrics r100) {
        return 50.0f / r100.densityDpi;
    }

    public final int f(int r100) {
        float r101 = Math.abs(r100);
        if (this.f401960m == true) goto L6;
        this.f401961n = e(this.f401959l);
        this.f401960m = true;
    L6:
        return (int) Math.ceil(r101 * this.f401961n);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.u
    public void b(View r110, RecyclerView.u.a r111) {
        PointF r100 = this.f401958k;
        int r101 = 1;
        int r102 = 0;
        if (r100 == null) goto L10;
        float r103 = r100.x;
        if (r103 == 0.0f) goto L10;
        if (r103 <= 0.0f) goto L9;
        int r104 = 1;
    L11:
        RecyclerView.k r105 = this.f401694c;
        if (r105 != null) goto L14;
    L17:
        int r106 = 0;
    L18:
        PointF r107 = this.f401958k;
        if (r107 == null) goto L26;
        float r108 = r107.y;
        if (r108 == 0.0f) goto L26;
        if (r108 > 0.0f) goto L27;
        r101 = -1;
    L27:
        RecyclerView.k r109 = this.f401694c;
        if (r109 != null) goto L30;
    L33:
        int r112 = (int) Math.ceil(((double) f((int) Math.sqrt((r106 * r106) + (r102 * r102)))) / 0.2d);
        if (r112 <= 0) goto L37;
        r111.update(-r106, -r102, r112, this.f401957j);
        return;
    L37:
        return;
    L30:
        if (r109.d() == false) goto L33;
        RecyclerView.LayoutParams r113 = (RecyclerView.LayoutParams) r110.getLayoutParams();
        r102 = d((r110.getTop() - ((RecyclerView.LayoutParams) r110.getLayoutParams()).f401652b.top) - ((ViewGroup.MarginLayoutParams) r113).topMargin, (r110.getBottom() + ((RecyclerView.LayoutParams) r110.getLayoutParams()).f401652b.bottom) + ((ViewGroup.MarginLayoutParams) r113).bottomMargin, r109.E(), r109.f401673m - r109.B(), r101);
    L26:
        r101 = 0;
        goto L27
    L14:
        if (r105.c() == false) goto L17;
        RecyclerView.LayoutParams r114 = (RecyclerView.LayoutParams) r110.getLayoutParams();
        r106 = d((r110.getLeft() - ((RecyclerView.LayoutParams) r110.getLayoutParams()).f401652b.left) - ((ViewGroup.MarginLayoutParams) r114).leftMargin, (r110.getRight() + ((RecyclerView.LayoutParams) r110.getLayoutParams()).f401652b.right) + ((ViewGroup.MarginLayoutParams) r114).rightMargin, r105.C(), r105.f401672l - r105.D(), r104);
        goto L18
    L9:
        r104 = -1;
    L10:
        r104 = 0;
        goto L11
    }

    public static int d(int r100, int r101, int r102, int r103, int r104) {
        if (r104 == (-1)) goto L20;
        if (r104 != 0) goto L6;
        int r105 = r102 - r100;
        if (r105 <= 0) goto L14;
        return r105;
    L14:
        int r106 = r103 - r101;
        if (r106 >= 0) goto L17;
        return r106;
    L17:
        return 0;
    L6:
        if (r104 != 1) goto L10;
        return r103 - r101;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r102 - r100;
    }
}
