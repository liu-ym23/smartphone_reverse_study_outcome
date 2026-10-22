package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MarqueeView extends View {
    public TextPaint a;
    public final Paint.FontMetrics b;
    public String c;
    public int d;
    public final long e;
    public float f;
    public float g;
    public int h;
    public long i;
    public boolean j;
    public int k;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = this.h;
        if (r0 == 0) goto L5;
        return;
    L5:
        if (r0 == 2) goto L10;
        this.h = 2;
        this.f = 0.0f;
        this.i = 0;
        invalidate();
        return;
    }

    public MarqueeView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        super.onDraw(r11);
        if (TextUtils.isEmpty(this.c) == true) goto L36;
        float r1 = 0.0f;
        if (this.g == 0.0f) goto L38;
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.i;
        if (r4 <= 0) goto L15;
        float r5 = ((r2 - r4) * ((long) this.d)) / 1000.0f;
        float r6 = this.f;
        if (this.j == false) goto L12;
        int r7 = 1;
    L13:
        this.f = (r6 + (r5 * r7)) % this.g;
        goto L15
    L12:
        r7 = -1;
    L15:
        if (this.h != 0) goto L17;
        this.i = r2;
    L17:
        this.a.getFontMetrics(this.b);
        float r3 = getMeasuredWidth();
        float r8 = this.f;
        if (this.j == false) goto L20;
        int r9 = 1;
    L21:
        float r10 = r3 + (r8 * r9);
    L23:
        if (r1 >= r10) goto L30;
        String r12 = this.c;
        float r13 = this.f;
        if (this.j == false) goto L27;
        int r14 = -1;
    L28:
        r11.drawText(r12, r13 + (r14 * r1), -this.b.top, this.a);
        r1 = r1 + this.g;
        goto L23
    L27:
        r14 = 1;
        goto L28
    L30:
        if (this.h != 0) goto L37;
        postInvalidateDelayed(this.e);
        return;
    L37:
        return;
    L20:
        r9 = -1;
        goto L21
    L38:
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
    }

    public void setSpeed(int r1) {
        this.d = r1;
    }

    public void setText(String r3) {
        String r4 = r3 + "    ";
        this.c = r4;
        this.g = this.a.measureText(r4);
    L4:
        if (this.g >= this.k) goto L6;
        String r5 = this.c + this.c;
        this.c = r5;
        this.g = this.a.measureText(r5);
        goto L4
    L6:
        this.f = 0.0f;
        this.i = 0;
        requestLayout();
    }

    public void setTextColor(int r2) {
        TextPaint r0 = this.a;
        if (r0 == null) goto L6;
        r0.setColor(r2);
        return;
    }

    public void setTextShadow(int r3) {
        TextPaint r0 = this.a;
        if (r0 == null) goto L6;
        r0.setShadowLayer(1.0f, 1.0f, 1.0f, r3);
        return;
    }

    public void setTextSize(int r2) {
        TextPaint r0 = this.a;
        if (r0 == null) goto L6;
        r0.setTextSize(r2);
        this.a.getFontMetrics(this.b);
        return;
    }

    public void setText(int r2) {
        setText(getResources().getString(r2));
    }

    public MarqueeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        this.a.getFontMetrics(this.b);
        boolean r0 = false;
        if (TextUtils.isEmpty(this.c) == true) goto L5;
        int r6 = (int) this.a.measureText(this.c);
    L7:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        r0 = true;
    L9:
        this.j = r0;
        Paint.FontMetrics r1 = this.b;
        int r2 = (int) (r1.bottom - r1.top);
        if (View.MeasureSpec.getSize(r4) > r6) goto L13;
        r6 = View.MeasureSpec.getSize(r4);
    L13:
        setMeasuredDimension(r6, r2);
        return;
    L5:
        r6 = 0;
        goto L7
    }

    public MarqueeView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.b = new Paint.FontMetrics();
        this.d = 25;
        this.e = 16;
        this.k = 0;
        TextPaint r0 = new TextPaint();
        this.a = r0;
        r0.setAntiAlias(true);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130974122, 2130974815, 2130974816, 2130974817});
        this.d = r7.getDimensionPixelSize(0, this.d);
        int r1 = r7.getColor(1, 0);
        int r2 = r7.getDimensionPixelSize(3, 28);
        int r8 = r7.getColor(2, 0);
        r7.recycle();
        this.a.setTextSize(r2);
        this.a.setShadowLayer(1.0f, 1.0f, 1.0f, r8);
        this.a.setColor(r1);
        this.h = 2;
        this.k = r4.getResources().getDimensionPixelSize(2131165316);
    }
}
