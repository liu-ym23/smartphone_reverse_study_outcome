package com.bytedance.ee.bear.debug;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoadingView extends View {
    public float a;
    public float b;
    public float c;
    public Paint d;
    public ValueAnimator e;

    public LoadingView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        this.d.setColor(Color.argb(100, 255, 255, 255));
        float r0 = this.a;
        r9.drawCircle(r0 / 2.0f, r0 / 2.0f, (r0 / 2.0f) - this.b, this.d);
        this.d.setColor(-1);
        float r1 = this.b;
        float r2 = this.a;
        r9.drawArc(new RectF(r1, r1, r2 - r1, r2 - r1), this.c, 100.0f, false, this.d);
    }

    public LoadingView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (getMeasuredWidth() <= getHeight()) goto L5;
        this.a = getMeasuredHeight();
    L6:
        this.b = 5.0f;
        return;
    L5:
        this.a = getMeasuredWidth();
        goto L6
    }

    public LoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        Paint r4 = new Paint();
        this.d = r4;
        r4.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(-1);
        this.d.setStrokeWidth(8.0f);
    }
}
