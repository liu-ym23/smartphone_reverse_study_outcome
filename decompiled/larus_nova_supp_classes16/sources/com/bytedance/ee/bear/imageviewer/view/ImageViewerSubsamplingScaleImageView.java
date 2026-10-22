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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        if (((SubsamplingScaleImageView) this).z != null) goto L7;
        return null;
    L7:
        if (getSHeight() != 0) goto L9;
        return null;
    L9:
        if (getSWidth() == 0) goto L36;
        Path r0 = new Path(this.I2);
        this.J2.reset();
        this.J2.setScale(getSWidth() / 100.0f, getSHeight() / 100.0f);
        r0.transform(this.J2);
        this.J2.reset();
        int r1 = getRequiredRotation();
        if (r1 != 4) goto L15;
        this.J2.postScale(1.0f, -1.0f, getSWidth() / 2.0f, getSHeight() / 2.0f);
    L17:
        this.J2.postScale(getScale(), getScale());
        if (r1 == 90) goto L21;
        if (r1 == 180) goto L21;
        if (r1 == 270) goto L21;
    L22:
        Matrix r5 = this.J2;
        PointF r6 = ((SubsamplingScaleImageView) this).z;
        r5.postTranslate(r6.x, r6.y);
        if (r1 != 180) goto L26;
        this.J2.postTranslate(getScale() * getSWidth(), getScale() * getSHeight());
    L30:
        r0.transform(this.J2);
        return r0;
    L26:
        if (r1 != 90) goto L28;
        this.J2.postTranslate(getScale() * getSHeight(), 0.0f);
        goto L30
    L28:
        if (r1 != 270) goto L30;
        this.J2.postTranslate(0.0f, getScale() * getSWidth());
    L21:
        this.J2.postRotate(r1);
        goto L22
    L15:
        if (r1 != 2) goto L17;
        this.J2.postScale(-1.0f, 1.0f, getSWidth() / 2.0f, getSHeight() / 2.0f);
        goto L17
    L36:
        return null;
    }

    public final void T() {
        float r0 = this.K2;
        float r1 = this.L2;
        if (Math.abs(r0 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
    L24:
        this.O2 = false;
        this.M2.reset();
        this.N2.reset();
        return;
    L11:
        if (getSWidth() == 0) goto L24;
        if (getSHeight() == 0) goto L24;
        float r3 = getSWidth() / 2.0f;
        float r6 = getSHeight() / 2.0f;
        PointF r4 = new PointF();
        if (((SubsamplingScaleImageView) this).z != null) goto L18;
        r4 = null;
    L19:
        if (r4 != null) goto L22;
        this.O2 = false;
        return;
    L22:
        this.M2.reset();
        this.M2.postScale(r0, r1, r4.x, r4.y);
        this.M2.invert(this.N2);
        this.O2 = true;
        return;
    L18:
        r4.set(O(r3), P(r6));
        goto L19
    L5:
        if (Math.abs(r1 - 1.0f) > 1.0E-4f) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RectF getVisibleTileRectOnView() {
        T();
        this.Q2.set(0.0f, 0.0f, getWidth(), getHeight());
        if (this.O2 == false) goto L5;
        this.N2.mapRect(this.Q2);
        return this.Q2;
    L5:
        return this.Q2;
    }

    public ImageViewerSubsamplingScaleImageView(Context r1) {
        super(r1);
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

    public final void f(Canvas r3) {
        int r0 = this.T2;
        if (r0 == (-1)) goto L5;
        r3.restoreToCount(r0);
    L5:
        int r1 = this.S2;
        if (r1 == (-1)) goto L9;
        r3.restoreToCount(r1);
        return;
    }

    public final void g(Canvas r3) {
        T();
        if (this.O2 == false) goto L5;
        this.S2 = r3.save();
        r3.concat(this.M2);
    L5:
        Path r0 = getViewClipPath();
        if (r0 == null) goto L9;
        this.T2 = r3.save();
        r3.clipPath(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setClipPath(Path r1) {
        this.I2 = r1;
        invalidate();
    }

    public final Rect t(SubsamplingScaleImageView.n r2) {
        if (this.O2 == false) goto L7;
        this.P2.set(r2.f);
        this.M2.mapRect(this.P2);
        this.P2.roundOut(this.R2);
        return this.R2;
    L7:
        return r2.f;
    }

    public ImageViewerSubsamplingScaleImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(float r4, float r5) {
        float r0 = 1.0f;
        if (r4 != 0.0f) goto L5;
        float r6 = 1.0f;
    L7:
        if (r5 == 0.0f) goto L10;
        r0 = Math.abs(r5);
    L10:
        float r7 = Math.max(r6, r0);
        this.K2 = r6 / r7;
        this.L2 = r0 / r7;
        if (((SubsamplingScaleImageView) this).b1 == false) goto L13;
        r(true);
        E(true);
    L13:
        invalidate();
        return;
    L5:
        r6 = Math.abs(r4);
        goto L7
    }
}
