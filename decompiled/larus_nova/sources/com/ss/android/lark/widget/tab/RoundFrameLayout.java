package com.ss.android.lark.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes38.dex */
public class RoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f448882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f448883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f448884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f448885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f448886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f448887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f448888g;

    public RoundFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        boolean r101 = this.f448888g;
        if (r101 == true) goto L5;
        r100.save();
        r100.clipPath(this.f448883b);
    L5:
        super.draw(r100);
        if (r101 == false) goto L8;
        return;
    L8:
        if (this.f448887f <= 0) goto L11;
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.STROKE);
        r102.setXfermode(null);
        r102.setColor(this.f448886e);
        r102.setStrokeWidth(this.f448887f * 2);
        r100.drawPath(this.f448883b, r102);
    L11:
        r100.restore();
    }

    public void setBorderWidth(int r100) {
        this.f448887f = r100;
        invalidate();
    }

    public void setDisablePathClip(boolean r100) {
        this.f448888g = r100;
    }

    public void setRadius(int r100) {
        float[] r101 = this.f448882a;
        float r102 = r100;
        r101[0] = r102;
        r101[1] = r102;
        r101[2] = r102;
        r101[3] = r102;
        r101[4] = r102;
        r101[5] = r102;
        r101[6] = r102;
        r101[7] = r102;
        invalidate();
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundFrameLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f448882a = new float[8];
        this.f448883b = new Path();
        this.f448884c = new RectF();
        int r113 = UIUtils.dp2px(LarkContext.getApplication(), 8.0f);
        this.f448885d = r113;
        this.f448886e = 0;
        this.f448887f = 0;
        this.f448888g = false;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bg_color, R.attr.bg_colorOrientation, R.attr.bg_cornerRadius, R.attr.bg_cornerRadius_BL, R.attr.bg_cornerRadius_BR, R.attr.bg_cornerRadius_TL, R.attr.bg_cornerRadius_TR, R.attr.bg_endColor, R.attr.bg_startColor, R.attr.bg_strokeColor, R.attr.bg_strokeWidth, R.attr.border_color, R.attr.border_width, R.attr.bottom_left_radius, R.attr.bottom_right_radius, R.attr.radius, R.attr.rv_needClip, R.attr.top_left_radius, R.attr.top_right_radius});
        boolean r100 = r114.hasValue(15);
        boolean r101 = r114.hasValue(17);
        boolean r102 = r114.hasValue(18);
        boolean r103 = r114.hasValue(13);
        boolean r104 = r114.hasValue(14);
        if (r100 == false) goto L5;
        r113 = r114.getDimensionPixelOffset(15, r113);
    L5:
        float r115 = r113;
        int r116 = 0;
    L6:
        float[] r105 = this.f448882a;
        if (r116 >= r105.length) goto L9;
        r105[r116] = r115;
        r116 = r116 + 1;
        goto L6
    L9:
        if (r101 == false) goto L11;
        r105[0] = r114.getDimensionPixelSize(17, this.f448885d);
        this.f448882a[1] = r114.getDimensionPixelSize(17, this.f448885d);
    L11:
        if (r102 == false) goto L13;
        this.f448882a[2] = r114.getDimensionPixelSize(18, this.f448885d);
        this.f448882a[3] = r114.getDimensionPixelSize(18, this.f448885d);
    L13:
        if (r104 == false) goto L15;
        this.f448882a[4] = r114.getDimensionPixelSize(14, this.f448885d);
        this.f448882a[5] = r114.getDimensionPixelSize(14, this.f448885d);
    L15:
        if (r103 == false) goto L17;
        this.f448882a[6] = r114.getDimensionPixelSize(13, this.f448885d);
        this.f448882a[7] = r114.getDimensionPixelSize(13, this.f448885d);
    L17:
        this.f448886e = r114.getColor(11, this.f448886e);
        this.f448887f = r114.getDimensionPixelSize(12, this.f448887f);
        r114.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        RectF r105 = this.f448884c;
        r105.left = 0.0f;
        r105.top = 0.0f;
        r105.right = getWidth();
        this.f448884c.bottom = getHeight();
        this.f448883b.rewind();
        this.f448883b.addRoundRect(this.f448884c, this.f448882a, Path.Direction.CW);
    }
}
