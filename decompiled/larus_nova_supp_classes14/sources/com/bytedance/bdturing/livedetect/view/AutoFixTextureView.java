package com.bytedance.bdturing.livedetect.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AutoFixTextureView extends TextureView {
    public int a;
    public int b;
    public final float c;
    public int d;
    public int e;

    public AutoFixTextureView(Context r2) {
        this(r2, null);
    }

    public AutoFixTextureView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(int r8, int r9) {
        this.a = r8;
        this.b = r9;
        Size r0 = new Size(r8, r9);
        if (((Activity) getContext()) != null) goto L5;
        return;
    L5:
        if (r0.getWidth() != 0) goto L7;
        return;
    L7:
        if (r0.getHeight() != 0) goto L9;
        return;
    L9:
        if ((Math.round(((r0.getWidth() * 1.0f) / r0.getHeight()) * 100.0f) / 100.0f) == (Math.round(((this.d * 1.0f) / this.e) * 100.0f) / 100.0f)) goto L15;
        Matrix r10 = new Matrix();
        RectF r1 = new RectF(0.0f, 0.0f, this.d, this.e);
        RectF r2 = new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
        float r3 = r1.centerX();
        float r4 = r1.centerY();
        r2.offset(r3 - r2.centerX(), r4 - r2.centerY());
        r10.setRectToRect(r1, r2, Matrix.ScaleToFit.FILL);
        float r5 = (Math.min(this.d, this.e) * 1.0f) / Math.min(r0.getWidth(), r0.getHeight());
        float r11 = ((r0.getHeight() * r5) / 2.0f) - (this.e / 2);
        float r6 = ((r0.getWidth() * r5) / 2.0f) - (this.d / 2);
        int r7 = n.a;
        r10.postScale(r5, r5, r3, r4);
        r10.postTranslate(r6, r11);
        setTransform(r10);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = View.MeasureSpec.getSize(r4);
        int r7 = View.MeasureSpec.getSize(r5);
        int r0 = this.b;
        if (r0 == 0) goto L11;
        int r1 = this.a;
        if (r1 == 0) goto L11;
        if (r6 >= ((r7 * r1) / r0)) goto L10;
        setMeasuredDimension(r6, (r0 * r6) / r1);
        return;
    L10:
        setMeasuredDimension((r1 * r7) / r0, r7);
        return;
    L11:
        float r2 = this.c;
        if (r2 <= 0.0f) goto L17;
        if (r6 <= 0) goto L15;
        r7 = (int) (r6 / r2);
        goto L17
    L15:
        if (r7 <= 0) goto L17;
        r6 = (int) (r7 * r2);
    L17:
        setMeasuredDimension(r6, r7);
    }

    public AutoFixTextureView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130975086});
        this.c = r6.getFloat(0, 0.0f);
        r6.recycle();
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d = r1;
        this.e = r2;
    }
}
