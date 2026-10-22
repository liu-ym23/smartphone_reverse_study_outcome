package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleTypeDrawable extends ForwardingDrawable {
    Matrix mDrawMatrix;
    PointF mFocusPoint;
    ScalingUtils.ScaleType mScaleType;
    Object mScaleTypeState;
    private Matrix mTempMatrix;
    int mUnderlyingHeight;
    int mUnderlyingWidth;

    private void configureBoundsIfUnderlyingChanged() {
        ScalingUtils.ScaleType r100 = this.mScaleType;
        boolean r101 = true;
        if ((r100 instanceof ScalingUtils.StatefulScaleType) == false) goto L12;
        Object r102 = ((ScalingUtils.StatefulScaleType) r100).getState();
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        this.mScaleTypeState = r102;
    L14:
        if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth()) goto L16;
    L19:
        if (r101 == true) goto L21;
        if (r103 == true) goto L21;
        return;
    L21:
        configureBounds();
        return;
    L16:
        if (this.mUnderlyingHeight != getCurrent().getIntrinsicHeight()) goto L19;
        r101 = false;
        goto L19
    L7:
        if (r102.equals(this.mScaleTypeState) == false) goto L10;
        r103 = false;
        goto L11
    L12:
        r103 = false;
        goto L14
    }

    public void configureBounds() {
        Drawable r100 = getCurrent();
        Rect r101 = getBounds();
        int r102 = r101.width();
        int r103 = r101.height();
        int r104 = r100.getIntrinsicWidth();
        this.mUnderlyingWidth = r104;
        int r105 = r100.getIntrinsicHeight();
        this.mUnderlyingHeight = r105;
        if (r104 <= 0) goto L23;
        if (r105 <= 0) goto L23;
        if (r104 != r102) goto L11;
        if (r105 != r103) goto L11;
        r100.setBounds(r101);
        this.mDrawMatrix = null;
        return;
    L11:
        if (this.mScaleType != ScalingUtils.ScaleType.FIT_XY) goto L14;
        r100.setBounds(r101);
        this.mDrawMatrix = null;
        return;
    L14:
        r100.setBounds(0, 0, r104, r105);
        ScalingUtils.ScaleType r106 = this.mScaleType;
        Matrix r107 = this.mTempMatrix;
        PointF r108 = this.mFocusPoint;
        if (r108 == null) goto L17;
        float r109 = r108.x;
    L18:
        if (r108 == null) goto L20;
        float r110 = r108.y;
    L21:
        r106.getTransform(r107, r101, r104, r105, r109, r110);
        this.mDrawMatrix = this.mTempMatrix;
        return;
    L20:
        r110 = 0.5f;
        goto L21
    L17:
        r109 = 0.5f;
    L23:
        r100.setBounds(r101);
        this.mDrawMatrix = null;
    }

    public PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix == null) goto L5;
        int r101 = r100.save();
        r100.clipRect(getBounds());
        r100.concat(this.mDrawMatrix);
        super.draw(r100);
        r100.restoreToCount(r101);
        return;
    L5:
        super.draw(r100);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix r100) {
        getParentTransform(r100);
        configureBoundsIfUnderlyingChanged();
        Matrix r101 = this.mDrawMatrix;
        if (r101 == null) goto L6;
        r100.preConcat(r101);
        return;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        configureBounds();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable r100) {
        Drawable r101 = super.setCurrent(r100);
        configureBounds();
        return r101;
    }

    public void setFocusPoint(PointF r100) {
        if (Objects.equal(this.mFocusPoint, r100) == false) goto L6;
        return;
    L6:
        if (this.mFocusPoint != null) goto L8;
        this.mFocusPoint = new PointF();
    L8:
        this.mFocusPoint.set(r100);
        configureBounds();
        invalidateSelf();
    }

    public void setScaleType(ScalingUtils.ScaleType r100) {
        if (Objects.equal(this.mScaleType, r100) == false) goto L5;
        return;
    L5:
        this.mScaleType = r100;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    public ScaleTypeDrawable(Drawable r100, ScalingUtils.ScaleType r101) {
        super((Drawable) Preconditions.checkNotNull(r100));
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = r101;
    }

    public ScaleTypeDrawable(@Nullable Drawable r100, ScalingUtils.ScaleType r101, @Nullable PointF r102) {
        super(r100);
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = r101;
        this.mFocusPoint = r102;
    }
}
