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
import com.larus.nova.R;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public class AutoFixTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f201929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f201930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f201931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f201932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f201933e;

    public AutoFixTextureView(Context r100) {
        this(r100, null);
    }

    public AutoFixTextureView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        this.f201929a = r100;
        this.f201930b = r101;
        Size r102 = new Size(r100, r101);
        if (((Activity) getContext()) != null) goto L5;
        return;
    L5:
        if (r102.getWidth() != 0) goto L7;
        return;
    L7:
        if (r102.getHeight() != 0) goto L9;
        return;
    L9:
        if ((Math.round(((r102.getWidth() * 1.0f) / r102.getHeight()) * 100.0f) / 100.0f) == (Math.round(((this.f201932d * 1.0f) / this.f201933e) * 100.0f) / 100.0f)) goto L15;
        Matrix r103 = new Matrix();
        RectF r104 = new RectF(0.0f, 0.0f, this.f201932d, this.f201933e);
        RectF r105 = new RectF(0.0f, 0.0f, r102.getWidth(), r102.getHeight());
        float r106 = r104.centerX();
        float r107 = r104.centerY();
        r105.offset(r106 - r105.centerX(), r107 - r105.centerY());
        r103.setRectToRect(r104, r105, Matrix.ScaleToFit.FILL);
        float r108 = (Math.min(this.f201932d, this.f201933e) * 1.0f) / Math.min(r102.getWidth(), r102.getHeight());
        float r109 = ((r102.getHeight() * r108) / 2.0f) - (this.f201933e / 2);
        float r110 = ((r102.getWidth() * r108) / 2.0f) - (this.f201932d / 2);
        int r111 = n.f532367a;
        r103.postScale(r108, r108, r106, r107);
        r103.postTranslate(r110, r109);
        setTransform(r103);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = this.f201930b;
        if (r104 == 0) goto L11;
        int r105 = this.f201929a;
        if (r105 == 0) goto L11;
        if (r102 >= ((r103 * r105) / r104)) goto L10;
        setMeasuredDimension(r102, (r104 * r102) / r105);
        return;
    L10:
        setMeasuredDimension((r105 * r103) / r104, r103);
        return;
    L11:
        float r106 = this.f201931c;
        if (r106 <= 0.0f) goto L17;
        if (r102 <= 0) goto L15;
        r103 = (int) (r102 / r106);
        goto L17
    L15:
        if (r103 <= 0) goto L17;
        r102 = (int) (r103 * r106);
    L17:
        setMeasuredDimension(r102, r103);
    }

    public AutoFixTextureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.wh_ratio});
        this.f201931c = r103.getFloat(0, 0.0f);
        r103.recycle();
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f201932d = r100;
        this.f201933e = r101;
    }
}
