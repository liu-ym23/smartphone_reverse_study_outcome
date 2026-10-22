package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RoundColorView extends View {
    public int a;
    public int b;
    public float c;
    public boolean d;
    public boolean e;
    public Paint f;
    public RectF g;

    private RectF getBounds() {
        if (this.g != null) goto L5;
        this.g = new RectF();
    L5:
        this.g.set(0.0f, 0.0f, getWidth(), getHeight());
        return this.g;
    }

    private float getOffset() {
        if (this.c != (-1.0f)) goto L6;
        double r0 = getWidth();
        this.c = (float) (((double) ((float) ((Math.sqrt(Math.pow(r0, 2.0d) * 2.0d) - r0) / 2.0d))) / Math.sqrt(2.0d));
    L6:
        return this.c;
    }

    private Paint getPaint() {
        if (this.f != null) goto L6;
        this.f = new Paint(1);
    L6:
        return this.f;
    }

    public int getColor() {
        return this.a;
    }

    public int getInnerBorderColor() {
        return this.b;
    }

    public RoundColorView(Context r1) {
        super(r1);
        this.c = -1.0f;
        this.d = false;
        this.e = false;
    }

    private void setBorderColor(String r8) {
        if (TextUtils.equals(r8, "#f5f5f5") == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.e = r0;
        if (r0 == false) goto L20;
        int r1 = getContext().getResources().getColor(2131103453);
        int r2 = ColorUtils.a;
        Intrinsics.checkNotNullParameter(r8, "solidColor");
        float[] r3 = new float[3];     // Catch: Exception -> L14
        Color.colorToHSV(Color.parseColor(r8), r3);     // Catch: Exception -> L14
        r3[2] = (float) (((double) r3[2]) * 0.9d);     // Catch: Exception -> L14
        r1 = Color.HSVToColor(r3);     // Catch: Exception -> L14
    L16:
        setInnerBorderColor(r1);
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        tt5.a.d("ColorUtils", "Bad color :" + r8);
        goto L16
    L20:
        return;
    L5:
        if (TextUtils.equals(r8, "#ffffff") == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void a(AttributeSet r4) {
        if (r4 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130969557, 2130970353}, 0, 0);
        int r0 = r5.getColor(0, this.a);
        this.a = r0;
        this.b = r5.getColor(1, r0);
        r5.recycle();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        float r0 = getWidth();
        float r1 = getHeight();
        Paint r7 = getPaint();
        r7.setStyle(Paint.Style.FILL);
        r7.setColor(this.a);
        float r4 = r0 / 2.0f;
        float r5 = r1 / 2.0f;
        r9.drawRoundRect(getBounds(), r4, r5, r7);
        int r2 = com.bytedance.ee.util.ui.n.d(1);
        if (this.e == false) goto L6;
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(this.b);
        float r6 = r2;
        r7.setStrokeWidth(r6);
        r9.drawCircle(r4, r5, r4 - (r6 / 2.0f), r7);
    L6:
        if (this.d == false) goto L9;
        r7.setColor(-65536);
        float r8 = getOffset() + (r2 / 2.0f);
        r9.drawLine(r8, r8, r0 - r8, r1 - r8, r7);
        return;
    }

    public void setClear(boolean r1) {
        this.d = r1;
    }

    public void setColor(String r3) {
        setBorderColor(r3);
        setColor(Color.parseColor(r3));     // Catch: Exception -> L5
        return;
    L5:
        tt5.a.d("RoundColorView", "Bad color :" + r3);
    }

    public void setInnerBorderColor(int r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        invalidate();
        return;
    }

    public void setNeedBorder(boolean r1) {
        this.e = r1;
    }

    public void setColor(int r2) {
        if (this.a == r2) goto L6;
        this.a = r2;
        invalidate();
        return;
    }

    public RoundColorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = -1.0f;
        this.d = false;
        this.e = false;
        a(r2);
    }

    public RoundColorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = -1.0f;
        this.d = false;
        this.e = false;
        a(r2);
    }
}
