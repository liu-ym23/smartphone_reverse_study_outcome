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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CircleProgressBar extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public float d;
    public final RectF e;
    public float f;
    public int g;
    public int h;
    public float i;
    public float j;
    public boolean k;
    public float l;
    public int m;
    public float n;
    public String o;
    public String p;
    public String q;
    public final int r;

    public float getProgressPercentage() {
        return (this.f / getMaxValue()) * 100.0f;
    }

    public float getBackgroundWidth() {
        return this.j;
    }

    public float getMaxValue() {
        return this.l;
    }

    public String getPrefix() {
        return this.q;
    }

    public float getProgress() {
        return this.f;
    }

    public float getStrokeWidth() {
        return this.i;
    }

    public String getSuffix() {
        return this.p;
    }

    public String getText() {
        return this.o;
    }

    public int getTextColor() {
        return this.m;
    }

    public CircleProgressBar(Context r1) {
        super(r1);
        this.e = new RectF();
        this.f = 0.0f;
        this.m = -16777216;
        this.n = n.G(14);
        this.o = "";
        this.p = "";
        this.q = "";
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        super.onDraw(r19);
        float r1 = this.d;
        float r2 = r1 / 5.0f;
        this.e.set(r2, r2, (r1 * 2.0f) - r2, (r1 * 2.0f) - r2);
        r19.drawArc(this.e, 0.0f, 360.0f, false, this.b);
        r19.drawArc(this.e, 270.0f, (this.f / getMaxValue()) * 360.0f, false, this.a);
        if (TextUtils.isEmpty(this.p) == false) goto L6;
        this.p = "";
    L6:
        if (TextUtils.isEmpty(this.q) == false) goto L8;
        this.q = "";
    L8:
        String r3 = this.q + this.o + this.p;
        if (TextUtils.isEmpty(this.o) == true) goto L12;
        r19.drawText(r3, (getWidth() - this.c.measureText(r3)) / 2.0f, (getWidth() - (this.c.descent() + this.c.ascent())) / 2.0f, this.c);
        return;
    }

    public void setBackgroundColor(String r2) {
        this.b.setColor(ColorProtector.parseColor(r2));
        invalidate();
    }

    public void setBackgroundWidth(float r1) {
        this.j = r1;
        invalidate();
    }

    public void setMaxValue(float r1) {
        this.l = r1;
        invalidate();
    }

    public void setPrefix(String r1) {
        this.q = r1;
        invalidate();
    }

    public void setProgress(float r1) {
        this.f = r1;
        invalidate();
    }

    public void setProgressColor(String r2) {
        this.a.setColor(ColorProtector.parseColor(r2));
        invalidate();
    }

    public void setStrokeWidth(float r1) {
        this.i = r1;
        invalidate();
    }

    public void setSuffix(String r1) {
        this.p = r1;
        invalidate();
    }

    public void setText(String r1) {
        this.o = r1;
        invalidate();
    }

    public void setTextColor(String r2) {
        this.c.setColor(ColorProtector.parseColor(r2));
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        this.h = r2;
        this.b.setColor(r2);
        invalidate();
    }

    public void setProgressColor(int r2) {
        this.g = r2;
        this.a.setColor(r2);
        invalidate();
    }

    public void setTextColor(int r2) {
        this.m = r2;
        this.c.setColor(r2);
        invalidate();
    }

    public CircleProgressBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
        a(r2, r3);
    }

    public final void a(Context r5, AttributeSet r6) {
        if (r6 == null) goto L5;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130968909, 2130968910, 2130969654, 2130973588, 2130973625, 2130973626, 2130973627, 2130973850, 2130974313, 2130974335, 2130974548}, this.r, 0);
        this.g = r7.getColor(4, -1);
        this.h = r7.getColor(0, getResources().getColor(2131100556));
        this.i = r7.getDimensionPixelSize(8, 0);
        this.j = r7.getDimensionPixelSize(1, 0);
        this.k = r7.getBoolean(7, false);
        this.l = r7.getFloat(2, 0.0f);
        this.m = r7.getColor(6, -1);
        this.n = r7.getDimension(10, 0.0f);
        this.p = r7.getString(9);
        this.q = r7.getString(3);
        this.o = r7.getString(5);
        r7.recycle();
    L5:
        Paint r8 = new Paint(1);
        this.a = r8;
        r8.setStyle(Paint.Style.FILL);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.i);
        if (this.k == false) goto L8;
        this.a.setStrokeCap(Paint.Cap.ROUND);
    L9:
        this.a.setColor(this.g);
        Paint r9 = new Paint(1);
        this.b = r9;
        r9.setStyle(Paint.Style.FILL);
        this.b.setColor(this.h);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.j);
        this.b.setStrokeCap(Paint.Cap.SQUARE);
        TextPaint r10 = new TextPaint();
        this.c = r10;
        r10.setColor(this.m);
        this.c.setTextSize(this.n);
        this.c.setAntiAlias(true);
        return;
    L8:
        this.a.setStrokeCap(Paint.Cap.BUTT);
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        int r3 = Math.min(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
        setMeasuredDimension(r3, r3);
    }

    public CircleProgressBar(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.e = new RectF();
        this.f = 0.0f;
        this.m = -16777216;
        this.n = n.G(14);
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = r4;
        a(r2, r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d = Math.min(r1, r2) / 2.0f;
    }
}
