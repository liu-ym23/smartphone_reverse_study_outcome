package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class MatrixDrawable extends ForwardingDrawable {
    private Matrix mDrawMatrix;
    private Matrix mMatrix;
    private int mUnderlyingHeight;
    private int mUnderlyingWidth;

    private void configureBoundsIfUnderlyingChanged() {
        if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth()) goto L5;
    L6:
        configureBounds();
        return;
    L5:
        if (this.mUnderlyingHeight != getCurrent().getIntrinsicHeight()) goto L6;
    }

    private void configureBounds() {
        Drawable r100 = getCurrent();
        Rect r101 = getBounds();
        int r102 = r100.getIntrinsicWidth();
        this.mUnderlyingWidth = r102;
        int r103 = r100.getIntrinsicHeight();
        this.mUnderlyingHeight = r103;
        if (r102 <= 0) goto L7;
        if (r103 <= 0) goto L7;
        r100.setBounds(0, 0, r102, r103);
        this.mDrawMatrix = this.mMatrix;
        return;
    L7:
        r100.setBounds(r101);
        this.mDrawMatrix = null;
    }

    public Matrix getMatrix() {
        return this.mMatrix;
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
        super.getTransform(r100);
        Matrix r101 = this.mDrawMatrix;
        if (r101 == null) goto L6;
        r100.preConcat(r101);
        return;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        configureBounds();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable r100) {
        Drawable r101 = super.setCurrent(r100);
        configureBounds();
        return r101;
    }

    public void setMatrix(Matrix r100) {
        this.mMatrix = r100;
        configureBounds();
        invalidateSelf();
    }

    public MatrixDrawable(Drawable r100, Matrix r101) {
        super((Drawable) Preconditions.checkNotNull(r100));
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mMatrix = r101;
    }
}
