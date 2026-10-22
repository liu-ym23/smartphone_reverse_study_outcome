package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class RoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f226529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f226530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f226531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f226532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f226533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f226534f;

    public RoundFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        if (this.f226533e == false) goto L5;
        r100.save();
        r100.clipPath(this.f226530b);
    L5:
        super.dispatchDraw(r100);
        if (this.f226533e == false) goto L9;
        r100.restore();
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        if (this.f226534f == false) goto L5;
        r100.save();
        r100.clipPath(this.f226530b);
    L5:
        super.draw(r100);
        if (this.f226534f == false) goto L9;
        r100.restore();
        return;
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundFrameLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f226529a = new float[8];
        this.f226530b = new Path();
        this.f226531c = new RectF();
        int r113 = com.bytedance.ee.util.ui.n.d(8);
        this.f226532d = r113;
        this.f226533e = false;
        this.f226534f = true;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bg_color, R.attr.bg_colorOrientation, R.attr.bg_cornerRadius, R.attr.bg_cornerRadius_BL, R.attr.bg_cornerRadius_BR, R.attr.bg_cornerRadius_TL, R.attr.bg_cornerRadius_TR, R.attr.bg_endColor, R.attr.bg_startColor, R.attr.bg_strokeColor, R.attr.bg_strokeWidth, R.attr.border_color, R.attr.border_width, R.attr.bottom_left_radius, R.attr.bottom_right_radius, R.attr.radius, R.attr.rv_needClip, R.attr.top_left_radius, R.attr.top_right_radius});
        boolean r100 = r114.hasValue(15);
        boolean r101 = r114.hasValue(17);
        boolean r102 = r114.hasValue(18);
        boolean r103 = r114.hasValue(13);
        boolean r115 = r114.hasValue(14);
        if (r100 == false) goto L5;
        r113 = r114.getDimensionPixelOffset(15, r113);
    L5:
        float r116 = r113;
        int r117 = 0;
    L6:
        float[] r104 = this.f226529a;
        if (r117 >= r104.length) goto L9;
        r104[r117] = r116;
        r117 = r117 + 1;
        goto L6
    L9:
        if (r101 == false) goto L11;
        r104[0] = r114.getDimensionPixelSize(17, this.f226532d);
        this.f226529a[1] = r114.getDimensionPixelSize(17, this.f226532d);
    L11:
        if (r102 == false) goto L13;
        this.f226529a[2] = r114.getDimensionPixelSize(18, this.f226532d);
        this.f226529a[3] = r114.getDimensionPixelSize(18, this.f226532d);
    L13:
        if (r115 == false) goto L15;
        this.f226529a[4] = r114.getDimensionPixelSize(14, this.f226532d);
        this.f226529a[5] = r114.getDimensionPixelSize(14, this.f226532d);
    L15:
        if (r103 == false) goto L17;
        this.f226529a[6] = r114.getDimensionPixelSize(13, this.f226532d);
        this.f226529a[7] = r114.getDimensionPixelSize(13, this.f226532d);
    L17:
        r114.recycle();
    }

    public final void a(int r100, int r101, int r102, int r103) {
        float[] r104 = this.f226529a;
        float r105 = r100;
        r104[0] = r105;
        r104[1] = r105;
        float r106 = r101;
        r104[2] = r106;
        r104[3] = r106;
        float r107 = r102;
        r104[4] = r107;
        r104[5] = r107;
        float r108 = r103;
        r104[6] = r108;
        r104[7] = r108;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        RectF r105 = this.f226531c;
        r105.left = 0.0f;
        r105.top = 0.0f;
        r105.right = getWidth();
        this.f226531c.bottom = getHeight();
        this.f226530b.rewind();
        this.f226530b.addRoundRect(this.f226531c, this.f226529a, Path.Direction.CW);
    }
}
