package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f226632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f226633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f226634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f226635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f226636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f226637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f226638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f226639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f226640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f226641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f226642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f226643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f226644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f226645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f226646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f226647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f226648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f226649r;

    public float getProgressPercentage() {
        return (this.f226637f / getMaxValue()) * 100.0f;
    }

    public float getBackgroundWidth() {
        return this.f226641j;
    }

    public float getMaxValue() {
        return this.f226643l;
    }

    public String getPrefix() {
        return this.f226648q;
    }

    public float getProgress() {
        return this.f226637f;
    }

    public float getStrokeWidth() {
        return this.f226640i;
    }

    public String getSuffix() {
        return this.f226647p;
    }

    public String getText() {
        return this.f226646o;
    }

    public int getTextColor() {
        return this.f226644m;
    }

    public CircleProgressBar(Context r100) {
        super(r100);
        this.f226636e = new RectF();
        this.f226637f = 0.0f;
        this.f226644m = -16777216;
        this.f226645n = n.G(14);
        this.f226646o = "";
        this.f226647p = "";
        this.f226648q = "";
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        float r100 = this.f226635d;
        float r101 = r100 / 5.0f;
        this.f226636e.set(r101, r101, (r100 * 2.0f) - r101, (r100 * 2.0f) - r101);
        r110.drawArc(this.f226636e, 0.0f, 360.0f, false, this.f226633b);
        r110.drawArc(this.f226636e, 270.0f, (this.f226637f / getMaxValue()) * 360.0f, false, this.f226632a);
        if (TextUtils.isEmpty(this.f226647p) == false) goto L6;
        this.f226647p = "";
    L6:
        if (TextUtils.isEmpty(this.f226648q) == false) goto L8;
        this.f226648q = "";
    L8:
        String r102 = this.f226648q + this.f226646o + this.f226647p;
        if (TextUtils.isEmpty(this.f226646o) == true) goto L12;
        r110.drawText(r102, (getWidth() - this.f226634c.measureText(r102)) / 2.0f, (getWidth() - (this.f226634c.descent() + this.f226634c.ascent())) / 2.0f, this.f226634c);
        return;
    }

    public void setBackgroundColor(String r100) {
        this.f226633b.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    public void setBackgroundWidth(float r100) {
        this.f226641j = r100;
        invalidate();
    }

    public void setMaxValue(float r100) {
        this.f226643l = r100;
        invalidate();
    }

    public void setPrefix(String r100) {
        this.f226648q = r100;
        invalidate();
    }

    public void setProgress(float r100) {
        this.f226637f = r100;
        invalidate();
    }

    public void setProgressColor(String r100) {
        this.f226632a.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    public void setStrokeWidth(float r100) {
        this.f226640i = r100;
        invalidate();
    }

    public void setSuffix(String r100) {
        this.f226647p = r100;
        invalidate();
    }

    public void setText(String r100) {
        this.f226646o = r100;
        invalidate();
    }

    public void setTextColor(String r100) {
        this.f226634c.setColor(ColorProtector.parseColor(r100));
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f226639h = r100;
        this.f226633b.setColor(r100);
        invalidate();
    }

    public void setProgressColor(int r100) {
        this.f226638g = r100;
        this.f226632a.setColor(r100);
        invalidate();
    }

    public void setTextColor(int r100) {
        this.f226644m = r100;
        this.f226634c.setColor(r100);
        invalidate();
    }

    public CircleProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.background_color, R.attr.background_width, R.attr.cpb_max_value, R.attr.prefix, R.attr.progress_color, R.attr.progress_text, R.attr.progress_text_color, R.attr.rounded_corners, R.attr.stroke_width, R.attr.suffix, R.attr.text_size}, this.f226649r, 0);
        this.f226638g = r102.getColor(4, -1);
        this.f226639h = r102.getColor(0, getResources().getColor(R.color.bg_filler));
        this.f226640i = r102.getDimensionPixelSize(8, 0);
        this.f226641j = r102.getDimensionPixelSize(1, 0);
        this.f226642k = r102.getBoolean(7, false);
        this.f226643l = r102.getFloat(2, 0.0f);
        this.f226644m = r102.getColor(6, -1);
        this.f226645n = r102.getDimension(10, 0.0f);
        this.f226647p = r102.getString(9);
        this.f226648q = r102.getString(3);
        this.f226646o = r102.getString(5);
        r102.recycle();
    L5:
        Paint r103 = new Paint(1);
        this.f226632a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f226632a.setStyle(Paint.Style.STROKE);
        this.f226632a.setStrokeWidth(this.f226640i);
        if (this.f226642k == false) goto L8;
        this.f226632a.setStrokeCap(Paint.Cap.ROUND);
    L9:
        this.f226632a.setColor(this.f226638g);
        Paint r104 = new Paint(1);
        this.f226633b = r104;
        r104.setStyle(Paint.Style.FILL);
        this.f226633b.setColor(this.f226639h);
        this.f226633b.setStyle(Paint.Style.STROKE);
        this.f226633b.setStrokeWidth(this.f226641j);
        this.f226633b.setStrokeCap(Paint.Cap.SQUARE);
        TextPaint r105 = new TextPaint();
        this.f226634c = r105;
        r105.setColor(this.f226644m);
        this.f226634c.setTextSize(this.f226645n);
        this.f226634c.setAntiAlias(true);
        return;
    L8:
        this.f226632a.setStrokeCap(Paint.Cap.BUTT);
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
        this.f226636e = new RectF();
        this.f226637f = 0.0f;
        this.f226644m = -16777216;
        this.f226645n = n.G(14);
        this.f226646o = "";
        this.f226647p = "";
        this.f226648q = "";
        this.f226649r = r102;
        a(r100, r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f226635d = Math.min(r100, r101) / 2.0f;
    }
}
