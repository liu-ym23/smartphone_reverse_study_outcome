package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class StyleEdgeTransparentView2 extends FrameLayout {
    public Paint a;
    public int b;
    public float c;
    public float d;
    public float e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public final int[] m;
    public final float[] n;

    public StyleEdgeTransparentView2(Context r2) {
        this(r2, null);
    }

    public void setDrawSize(float r1) {
        this.c = r1;
        invalidate();
    }

    public void setLeftDrawSize(float r1) {
        this.d = r1;
        invalidate();
    }

    public void setRightDrawSize(float r1) {
        this.e = r1;
        invalidate();
    }

    public StyleEdgeTransparentView2(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public StyleEdgeTransparentView2(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.f = 1;
        this.g = 1 << 1;
        this.h = 1 << 2;
        this.i = 1 << 3;
        this.j = 1 << 4;
        this.m = new int[]{-1, 0};
        this.n = new float[]{0.0f, 1.0f};
        Paint r0 = new Paint(1);
        this.a = r0;
        r0.setStyle(Paint.Style.FILL);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130974316, 2130974317});
        this.b = r8.getInt(0, 0);
        this.c = r8.getDimension(1, n0.a(getContext(), 0.0f));
        r8.recycle();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r22, View r23, long r24) {
        if ((this.b & this.j) != 0) goto L5;
        int r8 = r22.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean r9 = super.drawChild(r22, r23, r24);
        int r1 = this.b;
        if (r1 != 0) goto L9;
    L10:
        r22.drawRect(0.0f, -3.0f, this.k, this.c, this.a);
    L11:
        int r2 = this.b;
        if (r2 != 0) goto L14;
    L15:
        int r10 = r22.save();
        r22.rotate(180.0f, this.k / 2, this.l / 2);
        r22.drawRect(0.0f, -3.0f, this.k, this.c, this.a);
        r22.restoreToCount(r10);
    L16:
        int r11 = (this.l - this.k) / 2;
        int r3 = this.b;
        if (r3 != 0) goto L19;
    L20:
        int r12 = r22.save();
        r22.rotate(90.0f, this.k / 2, this.l / 2);
        r22.translate(0.0f, r11);
        float r4 = this.c;
        float r5 = this.e;
        if (r5 <= 0.0f) goto L23;
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r5, this.m, this.n, Shader.TileMode.CLAMP));
        float r6 = r5;
    L24:
        r22.drawRect(0 - r11, -3.0f, this.k + r11, r6, this.a);
        r22.restoreToCount(r12);
    L25:
        int r7 = this.b;
        if (r7 != 0) goto L28;
    L29:
        int r13 = r22.save();
        r22.rotate(270.0f, this.k / 2, this.l / 2);
        r22.translate(0.0f, r11);
        float r14 = this.c;
        float r15 = this.d;
        if (r15 <= 0.0f) goto L32;
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r15, this.m, this.n, Shader.TileMode.CLAMP));
        float r16 = r15;
    L33:
        r22.drawRect(0 - r11, -3.0f, this.k + r11, r16, this.a);
        r22.restoreToCount(r13);
    L34:
        r22.restoreToCount(r8);
        return r9;
    L32:
        r16 = r14;
        goto L33
    L28:
        if ((r7 & this.i) == 0) goto L34;
    L23:
        r6 = r4;
        goto L24
    L19:
        if ((r3 & this.h) == 0) goto L25;
    L14:
        if ((r2 & this.g) == 0) goto L16;
    L9:
        if ((r1 & this.f) == 0) goto L11;
    L5:
        return super.drawChild(r22, r23, r24);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.c, this.m, this.n, Shader.TileMode.CLAMP));
        this.k = getWidth();
        this.l = getHeight();
    }
}
