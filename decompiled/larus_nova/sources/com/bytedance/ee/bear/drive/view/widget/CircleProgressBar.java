package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f225882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f225883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f225884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f225885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f225886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f225887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f225889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f225890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f225891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f225892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f225893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f225894m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f225895n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f225896o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f225897p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f225898q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f225899r;

    public float getProgressPercentage() {
        return (this.f225887f / getMaxValue()) * 100.0f;
    }

    public float getBackgroundWidth() {
        return this.f225891j;
    }

    public float getMaxValue() {
        return this.f225893l;
    }

    public String getPrefix() {
        return this.f225898q;
    }

    public float getProgress() {
        return this.f225887f;
    }

    public float getStrokeWidth() {
        return this.f225890i;
    }

    public String getSuffix() {
        return this.f225897p;
    }

    public String getText() {
        return this.f225896o;
    }

    public int getTextColor() {
        return this.f225894m;
    }

    public CircleProgressBar(Context r100) {
        super(r100);
        this.f225886e = new RectF();
        this.f225887f = 0.0f;
        this.f225894m = -16777216;
        this.f225895n = com.bytedance.ee.util.ui.n.G(14);
        this.f225896o = "";
        this.f225897p = "";
        this.f225898q = "";
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        float r100 = this.f225885d;
        float r101 = r100 / 3.0f;
        this.f225886e.set(r101, r101, (r100 * 2.0f) - r101, (r100 * 2.0f) - r101);
        r110.drawArc(this.f225886e, 0.0f, 360.0f, false, this.f225883b);
        r110.drawArc(this.f225886e, 270.0f, (this.f225887f / getMaxValue()) * 360.0f, false, this.f225882a);
        if (TextUtils.isEmpty(this.f225897p) == false) goto L6;
        this.f225897p = "";
    L6:
        if (TextUtils.isEmpty(this.f225898q) == false) goto L8;
        this.f225898q = "";
    L8:
        String r102 = this.f225898q + this.f225896o + this.f225897p;
        if (TextUtils.isEmpty(this.f225896o) == true) goto L12;
        r110.drawText(r102, (getWidth() - this.f225884c.measureText(r102)) / 2.0f, (getWidth() - (this.f225884c.descent() + this.f225884c.ascent())) / 2.0f, this.f225884c);
        return;
    }

    public void setBackgroundColor(String r100) {
        this.f225883b.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    public void setBackgroundWidth(float r100) {
        this.f225891j = r100;
        invalidate();
    }

    public void setMaxValue(float r100) {
        this.f225893l = r100;
        invalidate();
    }

    public void setPrefix(String r100) {
        this.f225898q = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f225887f = r100;
        invalidate();
    }

    public void setProgressColor(String r100) {
        this.f225882a.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    public void setStrokeWidth(float r100) {
        this.f225890i = r100;
        invalidate();
    }

    public void setSuffix(String r100) {
        this.f225897p = r100;
        invalidate();
    }

    public void setText(String r100) {
        this.f225896o = r100;
        invalidate();
    }

    public void setTextColor(String r100) {
        this.f225884c.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f225889h = r100;
        this.f225883b.setColor(r100);
        invalidate();
    }

    public void setProgressColor(int r100) {
        this.f225888g = r100;
        this.f225882a.setColor(r100);
        invalidate();
    }

    public void setTextColor(int r100) {
        this.f225894m = r100;
        this.f225884c.setColor(r100);
        invalidate();
    }

    public CircleProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.background_color, R.attr.background_width, R.attr.cpb_max_value, R.attr.prefix, R.attr.progress_color, R.attr.progress_text, R.attr.progress_text_color, R.attr.rounded_corners, R.attr.stroke_width, R.attr.suffix, R.attr.text_size}, this.f225899r, 0);
        this.f225888g = r102.getColor(4, -1);
        this.f225889h = r102.getColor(0, getResources().getColor(R.color.lkui_N200));
        this.f225890i = r102.getDimensionPixelSize(8, 0);
        this.f225891j = r102.getDimensionPixelSize(1, 0);
        this.f225892k = r102.getBoolean(7, false);
        this.f225893l = r102.getFloat(2, 0.0f);
        this.f225894m = r102.getColor(6, -1);
        this.f225895n = r102.getDimension(10, 0.0f);
        this.f225897p = r102.getString(9);
        this.f225898q = r102.getString(3);
        this.f225896o = r102.getString(5);
        r102.recycle();
    L5:
        Paint r103 = new Paint(1);
        this.f225882a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f225882a.setStyle(Paint.Style.STROKE);
        this.f225882a.setStrokeWidth(this.f225890i);
        if (this.f225892k == false) goto L8;
        this.f225882a.setStrokeCap(Paint.Cap.ROUND);
    L9:
        this.f225882a.setColor(this.f225888g);
        Paint r104 = new Paint(1);
        this.f225883b = r104;
        r104.setStyle(Paint.Style.FILL);
        this.f225883b.setColor(this.f225889h);
        this.f225883b.setStyle(Paint.Style.STROKE);
        this.f225883b.setStrokeWidth(this.f225891j);
        this.f225883b.setStrokeCap(Paint.Cap.SQUARE);
        TextPaint r105 = new TextPaint();
        this.f225884c = r105;
        r105.setColor(this.f225894m);
        this.f225884c.setTextSize(this.f225895n);
        this.f225884c.setAntiAlias(true);
        return;
    L8:
        this.f225882a.setStrokeCap(Paint.Cap.BUTT);
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        setMeasuredDimension(r102, r102);
    }

    public CircleProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225886e = new RectF();
        this.f225887f = 0.0f;
        this.f225894m = -16777216;
        this.f225895n = com.bytedance.ee.util.ui.n.G(14);
        this.f225896o = "";
        this.f225897p = "";
        this.f225898q = "";
        this.f225899r = r102;
        a(r100, r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f225885d = Math.min(r100, r101) / 2.0f;
    }
}
