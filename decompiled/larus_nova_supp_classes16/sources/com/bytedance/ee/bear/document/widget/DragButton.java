package com.bytedance.ee.bear.document.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import xo5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DragButton extends View {
    public Path a;
    public Paint b;
    public int c;
    public int d;
    public volatile float e;
    public float f;

    public DragButton(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        r9.save();
        r9.translate(getPaddingLeft(), getPaddingTop());
        this.a.reset();
        double r0 = Math.sqrt(Math.pow(((double) this.d) / 2.0d, 2.0d) + Math.pow(this.e, 0.0d));
        double r4 = ((double) (this.c * this.e)) / r0;
        float r2 = (float) (((((double) this.d) / 2.0d) * r4) / r0);
        float r1 = (float) ((((double) this.e) * r4) / r0);
        this.a.moveTo(r2, r1);
        this.a.lineTo(this.d / 2, this.e);
        this.a.lineTo(this.d - r2, r1 + 0.0f);
        this.a.lineTo(this.d, this.c);
        this.a.lineTo(this.d / 2, this.e + this.c);
        this.a.lineTo(0.0f, this.c);
        this.a.close();
        r9.drawPath(this.a, this.b);
        this.a.reset();
        this.a.moveTo(r2, r1);
        Path r3 = this.a;
        int r5 = this.c;
        r3.quadTo((-r5) / 2.0f, r5 / 2.0f, 0.0f, r5);
        this.a.close();
        r9.drawPath(this.a, this.b);
        this.a.reset();
        this.a.moveTo(this.d - r2, r1);
        Path r6 = this.a;
        int r7 = this.d;
        int r8 = this.c;
        r6.quadTo(r7 + (r8 / 2.0f), r8 / 2.0f, r7, r8);
        this.a.close();
        r9.drawPath(this.a, this.b);
        r9.restore();
    }

    public void setDragOffset(float r3) {
        if (r3 <= 1.0f) goto L5;
        r3 = 1.0f;
    L5:
        this.e = (1.0f - r3) * this.f;
        postInvalidate();
    }

    public DragButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public DragButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = a.a(6.0f);
        float r4 = a.a(3.5f);
        this.f = r4;
        this.e = r4;
        this.a = new Path();
        this.b = new Paint();
        new RectF();
        this.b.setColor(getResources().getColor(2131103453));
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d = (r1 - getPaddingLeft()) - getPaddingRight();
        getPaddingBottom();
        getPaddingTop();
    }
}
