package com.bytedance.ee.bear.imageviewer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;

/* JADX INFO: loaded from: classes16.dex */
public class ImageViewerSubsamplingScaleImageView extends SubsamplingScaleImageView {
    public Path I2;
    public final Matrix J2;
    public float K2;
    public float L2;
    public final Matrix M2;
    public final Matrix N2;
    public boolean O2;
    public final RectF P2;
    public final RectF Q2;
    public final Rect R2;
    public int S2;
    public int T2;

    private Path getViewClipPath() {
        if (this.I2 != null) goto L5;
        return null;
    L5:
        if (this.f426734z != null) goto L7;
        return null;
    L7:
        if (getSHeight() != 0) goto L9;
        return null;
    L9:
        if (getSWidth() == 0) goto L36;
        Path r100 = new Path(this.I2);
        this.J2.reset();
        this.J2.setScale(getSWidth() / 100.0f, getSHeight() / 100.0f);
        r100.transform(this.J2);
        this.J2.reset();
        int r101 = getRequiredRotation();
        if (r101 != 4) goto L15;
        this.J2.postScale(1.0f, -1.0f, getSWidth() / 2.0f, getSHeight() / 2.0f);
    L17:
        this.J2.postScale(getScale(), getScale());
        if (r101 == 90) goto L21;
        if (r101 == 180) goto L21;
        if (r101 == 270) goto L21;
    L22:
        Matrix r102 = this.J2;
        PointF r103 = this.f426734z;
        r102.postTranslate(r103.x, r103.y);
        if (r101 != 180) goto L26;
        this.J2.postTranslate(getScale() * getSWidth(), getScale() * getSHeight());
    L30:
        r100.transform(this.J2);
        return r100;
    L26:
        if (r101 != 90) goto L28;
        this.J2.postTranslate(getScale() * getSHeight(), 0.0f);
        goto L30
    L28:
        if (r101 != 270) goto L30;
        this.J2.postTranslate(0.0f, getScale() * getSWidth());
    L21:
        this.J2.postRotate(r101);
        goto L22
    L15:
        if (r101 != 2) goto L17;
        this.J2.postScale(-1.0f, 1.0f, getSWidth() / 2.0f, getSHeight() / 2.0f);
        goto L17
    L36:
        return null;
    }

    public final void T() {
        float r100 = this.K2;
        float r101 = this.L2;
        if (Math.abs(r100 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L24:
        this.O2 = false;
        this.M2.reset();
        this.N2.reset();
        return;
    L11:
        if (getSWidth() == 0) goto L24;
        if (getSHeight() == 0) goto L24;
        float r103 = getSWidth() / 2.0f;
        float r104 = getSHeight() / 2.0f;
        PointF r105 = new PointF();
        if (this.f426734z != null) goto L18;
        r105 = null;
    L19:
        if (r105 != null) goto L22;
        this.O2 = false;
        return;
    L22:
        this.M2.reset();
        this.M2.postScale(r100, r101, r105.x, r105.y);
        this.M2.invert(this.N2);
        this.O2 = true;
        return;
    L18:
        r105.set(O(r103), P(r104));
        goto L19
    L5:
        if (Math.abs(r101 - 1.0f) > 1.0E-4f) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public RectF getVisibleTileRectOnView() {
        T();
        this.Q2.set(0.0f, 0.0f, getWidth(), getHeight());
        if (this.O2 == false) goto L5;
        this.N2.mapRect(this.Q2);
        return this.Q2;
    L5:
        return this.Q2;
    }

    public ImageViewerSubsamplingScaleImageView(Context r100) {
        super(r100);
        this.J2 = new Matrix();
        this.K2 = 1.0f;
        this.L2 = 1.0f;
        this.M2 = new Matrix();
        this.N2 = new Matrix();
        this.O2 = false;
        this.P2 = new RectF();
        this.Q2 = new RectF();
        this.R2 = new Rect();
        this.S2 = -1;
        this.T2 = -1;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final void f(Canvas r100) {
        int r101 = this.T2;
        if (r101 == (-1)) goto L5;
        r100.restoreToCount(r101);
    L5:
        int r102 = this.S2;
        if (r102 == (-1)) goto L9;
        r100.restoreToCount(r102);
        return;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final void g(Canvas r100) {
        T();
        if (this.O2 == false) goto L5;
        this.S2 = r100.save();
        r100.concat(this.M2);
    L5:
        Path r101 = getViewClipPath();
        if (r101 == null) goto L9;
        this.T2 = r100.save();
        r100.clipPath(r101);
        return;
    }

    public final void setClipPath(Path r100) {
        this.I2 = r100;
        invalidate();
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final Rect t(SubsamplingScaleImageView.n r100) {
        if (this.O2 == false) goto L7;
        this.P2.set(r100.f426778f);
        this.M2.mapRect(this.P2);
        this.P2.roundOut(this.R2);
        return this.R2;
    L7:
        return r100.f426778f;
    }

    public ImageViewerSubsamplingScaleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.J2 = new Matrix();
        this.K2 = 1.0f;
        this.L2 = 1.0f;
        this.M2 = new Matrix();
        this.N2 = new Matrix();
        this.O2 = false;
        this.P2 = new RectF();
        this.Q2 = new RectF();
        this.R2 = new Rect();
        this.S2 = -1;
        this.T2 = -1;
    }

    public final void S(float r100, float r101) {
        float r102 = 1.0f;
        if (r100 != 0.0f) goto L5;
        float r103 = 1.0f;
    L7:
        if (r101 == 0.0f) goto L10;
        r102 = Math.abs(r101);
    L10:
        float r104 = Math.max(r103, r102);
        this.K2 = r103 / r104;
        this.L2 = r102 / r104;
        if (this.f426696b1 == false) goto L13;
        r(true);
        E(true);
    L13:
        invalidate();
        return;
    L5:
        r103 = Math.abs(r100);
        goto L7
    }
}
