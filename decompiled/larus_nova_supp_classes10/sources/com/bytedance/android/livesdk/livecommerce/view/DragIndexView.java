package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DragIndexView extends View {
    public final Paint a;
    public int b;
    public int c;
    public String d;
    public float e;
    public float f;
    public float g;
    public final int h;
    public int i;
    public final Path j;
    public final Paint k;
    public float l;

    public interface a {
    }

    public void setOnClickIndexListener(a r1) {
    }

    public DragIndexView(Context r3) {
        super(r3);
        this.a = new Paint();
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.h = 2;
        this.i = 0;
        this.j = new Path();
        this.k = new Paint();
        a(r3);
    }

    public final void a(Context r3) {
        setClickable(true);
        Resources r4 = r3.getResources();
        this.f = w0.a(8.0f);
        this.g = w0.a(6.0f);
        this.l = w0.a(24.0f);
        this.b = r4.getColor(2131101568);
        r4.getColor(2131101644);
        this.e = w0.a(10.0f);
        this.a.setAntiAlias(true);
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        this.c = r4.getColor(2131101862);
        this.a.setTextSize(w0.a(16.0f));
        this.a.setColor(this.c);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        super.onDraw(r18);
        int r2 = getMeasuredWidth();
        int r3 = getMeasuredHeight();
        if (this.h != 2) goto L5;
        this.k.setAntiAlias(true);
        this.k.setColor(this.b);
        this.k.setStyle(Paint.Style.FILL);
        r18.save();
        r18.translate(0.0f, this.i);
        float r4 = getMeasuredWidth();
        float r7 = this.f;
        float r5 = (r4 - r7) / 2.0f;
        float r8 = this.g;
        float r9 = r5 + r7;
        float r10 = (r5 + r9) / 2.0f;
        float r11 = r8 - r8;
        float r12 = r7 * 0.25f;
        float r14 = r12 * 0.5f;
        float r13 = r8 - (r8 * 0.25f);
        this.j.moveTo(r14 + r5, r13);
        this.j.quadTo(r5, r8, r12 + r5, r8);
        this.j.lineTo(r9 - r12, r8);
        this.j.quadTo(r9, r8, r9 - r14, r13);
        float r6 = (this.g * 0.25f) + r11;
        this.j.lineTo(r10 + r14, r6);
        this.j.quadTo(r10, r11, r10 - r14, r6);
        this.j.close();
        r18.drawPath(this.j, this.k);
        r18.restore();
        r18.save();
        r18.translate(0.0f, -this.i);
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        float r17 = this.f;
        float r19 = (r15 - r17) / 2.0f;
        float r20 = r16;
        float r21 = this.g;
        float r22 = r20 - r21;
        float r110 = r19 + r17;
        float r111 = (r19 + r110) / 2.0f;
        float r23 = r17 * 0.25f;
        float r112 = r23 * 0.5f;
        float r24 = (r21 * 0.25f) + r22;
        this.j.moveTo(r112 + r19, r24);
        this.j.quadTo(r19, r22, r23 + r19, r22);
        this.j.lineTo(r110 - r23, r22);
        this.j.quadTo(r110, r22, r110 - r112, r24);
        float r25 = r20 - (this.g * 0.25f);
        this.j.lineTo(r111 + r112, r25);
        this.j.quadTo(r111, r20, r111 - r112, r25);
        this.j.close();
        r18.drawPath(this.j, this.k);
        r18.restore();
    L5:
        float r26 = (r2 - this.a.measureText(this.d)) / 2.0f;
        Paint.FontMetrics r27 = this.a.getFontMetrics();
        float r28 = r27.descent;
        r18.drawText(this.d, r26, ((r3 / 2.0f) + ((r28 - r27.ascent) / 2.0f)) - r28, this.a);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (this.h != 2) goto L11;
        getMeasuredHeight();
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L11;
        Handler r1 = k.a;
        System.currentTimeMillis();
        r3.getY();
        goto L11
    L9:
        r3.getY();
        Handler r2 = k.a;
        System.currentTimeMillis();
    L11:
        return super.onTouchEvent(r3);
    }

    public void setNum(int r1) {
        if (r1 <= 0) goto L5;
        this.d = String.valueOf(r1);
        requestLayout();
        return;
    }

    public void setNum(String r1) {
        if (r1 == null) goto L5;
        this.d = r1;
        requestLayout();
        return;
    }

    public DragIndexView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = new Paint();
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.h = 2;
        this.i = 0;
        this.j = new Path();
        this.k = new Paint();
        a(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        float r0 = this.a.measureText(this.d);
        int r1 = (int) (((this.g * 2.0f) + this.l) + (this.e * 2.0f));
        float r2 = this.f;
        if (r0 > r2) goto L6;
        r0 = r2;
    L6:
        int r3 = (int) r0;
        if (View.MeasureSpec.getMode(r5) != 1073741824) goto L12;
        int r7 = getMeasuredWidth();
        if (r7 <= r3) goto L12;
        r3 = r7;
    L12:
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L16;
        int r8 = getMeasuredHeight();
        if (r8 <= r1) goto L16;
        this.i = (int) ((r8 - r1) * 0.5f);
        r1 = r8;
    L16:
        setMeasuredDimension(r3, r1);
    }

    public DragIndexView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new Paint();
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.h = 2;
        this.i = 0;
        this.j = new Path();
        this.k = new Paint();
        a(r1);
    }
}
