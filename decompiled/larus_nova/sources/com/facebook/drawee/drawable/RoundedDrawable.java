package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    final RectF mBitmapBounds;
    protected int mBorderColor;
    protected final Path mBorderPath;
    final float[] mBorderRadii;
    protected float mBorderWidth;
    final Matrix mBoundsTransform;
    private final float[] mCornerRadii;
    protected final Drawable mDelegate;
    final RectF mDrawableBounds;
    RectF mInsideBorderBounds;
    float[] mInsideBorderRadii;
    Matrix mInsideBorderTransform;
    final Matrix mInverseParentTransform;
    protected boolean mIsCircle;
    private boolean mIsPathDirty;
    protected boolean mIsShaderTransformDirty;
    private float mPadding;
    final Matrix mParentTransform;
    protected final Path mPath;
    final Matrix mPrevBoundsTransform;
    Matrix mPrevInsideBorderTransform;
    final Matrix mPrevParentTransform;
    final RectF mPrevRootBounds;
    protected boolean mRadiiNonZero;
    final RectF mRootBounds;
    private boolean mScaleDownInsideBorders;
    final Matrix mTransform;
    private TransformCallback mTransformCallback;

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mDelegate.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mDelegate.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mDelegate.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDelegate.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDelegate.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDelegate.getOpacity();
    }

    public boolean shouldRound() {
        if (this.mIsCircle == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mRadiiNonZero == true) goto L10;
        if (this.mBorderWidth > 0.0f) goto L10;
        return false;
    }

    public void updatePath() {
        if (this.mIsPathDirty == false) goto L34;
        this.mBorderPath.reset();
        RectF r100 = this.mRootBounds;
        float r101 = this.mBorderWidth;
        r100.inset(r101 / 2.0f, r101 / 2.0f);
        if (this.mIsCircle == false) goto L7;
        float r102 = Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f;
        this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), r102, Path.Direction.CW);
    L12:
        RectF r103 = this.mRootBounds;
        float r104 = this.mBorderWidth;
        r103.inset((-r104) / 2.0f, (-r104) / 2.0f);
        this.mPath.reset();
        float r105 = this.mPadding;
        if (this.mScaleDownInsideBorders == false) goto L15;
        float r106 = this.mBorderWidth;
    L16:
        float r107 = r105 + r106;
        this.mRootBounds.inset(r107, r107);
        if (this.mIsCircle == false) goto L20;
        this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
    L30:
        float r108 = -r107;
        this.mRootBounds.inset(r108, r108);
        this.mPath.setFillType(Path.FillType.WINDING);
        this.mIsPathDirty = false;
        return;
    L20:
        if (this.mScaleDownInsideBorders == true) goto L22;
        this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
        goto L30
    L22:
        if (this.mInsideBorderRadii != null) goto L24;
        this.mInsideBorderRadii = new float[8];
    L24:
        int r109 = 0;
    L26:
        if (r109 >= this.mBorderRadii.length) goto L28;
        this.mInsideBorderRadii[r109] = this.mCornerRadii[r109] - this.mBorderWidth;
        r109 = r109 + 1;
        goto L26
    L28:
        this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
        goto L30
    L15:
        r106 = 0.0f;
        goto L16
    L7:
        int r110 = 0;
    L8:
        float[] r111 = this.mBorderRadii;
        if (r110 >= r111.length) goto L11;
        r111[r110] = (this.mCornerRadii[r110] + this.mPadding) - (this.mBorderWidth / 2.0f);
        r110 = r110 + 1;
        goto L8
    L11:
        this.mBorderPath.addRoundRect(this.mRootBounds, r111, Path.Direction.CW);
        goto L12
    }

    public void updateTransform() {
        TransformCallback r100 = this.mTransformCallback;
        if (r100 == null) goto L5;
        r100.getTransform(this.mParentTransform);
        this.mTransformCallback.getRootBounds(this.mRootBounds);
    L6:
        Drawable r101 = this.mDelegate;
        if ((r101 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r102 = (BitmapDrawable) r101;
        this.mBitmapBounds.set(0.0f, 0.0f, r102.getBitmap().getWidth(), r102.getBitmap().getHeight());
        this.mDrawableBounds.set(r102.getBounds());
    L10:
        this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
        if (this.mScaleDownInsideBorders == false) goto L20;
        RectF r103 = this.mInsideBorderBounds;
        if (r103 != null) goto L15;
        this.mInsideBorderBounds = new RectF(this.mRootBounds);
    L16:
        RectF r104 = this.mInsideBorderBounds;
        float r105 = this.mBorderWidth;
        r104.inset(r105, r105);
        if (this.mInsideBorderTransform != null) goto L19;
        this.mInsideBorderTransform = new Matrix();
    L19:
        this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
    L24:
        if (this.mParentTransform.equals(this.mPrevParentTransform) == true) goto L26;
    L31:
        this.mIsShaderTransformDirty = true;
        this.mParentTransform.invert(this.mInverseParentTransform);
        this.mTransform.set(this.mParentTransform);
        if (this.mScaleDownInsideBorders == false) goto L34;
        this.mTransform.postConcat(this.mInsideBorderTransform);
    L34:
        this.mTransform.preConcat(this.mBoundsTransform);
        this.mPrevParentTransform.set(this.mParentTransform);
        this.mPrevBoundsTransform.set(this.mBoundsTransform);
        if (this.mScaleDownInsideBorders == false) goto L40;
        Matrix r106 = this.mPrevInsideBorderTransform;
        if (r106 != null) goto L39;
        this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
    L44:
        if (this.mRootBounds.equals(this.mPrevRootBounds) == true) goto L47;
        this.mIsPathDirty = true;
        this.mPrevRootBounds.set(this.mRootBounds);
        return;
    L47:
        return;
    L39:
        r106.set(this.mInsideBorderTransform);
        goto L44
    L40:
        Matrix r107 = this.mPrevInsideBorderTransform;
        if (r107 == null) goto L44;
        r107.reset();
        goto L44
    L26:
        if (this.mBoundsTransform.equals(this.mPrevBoundsTransform) == false) goto L31;
        Matrix r108 = this.mInsideBorderTransform;
        if (r108 == null) goto L44;
        if (r108.equals(this.mPrevInsideBorderTransform) == true) goto L44;
    L15:
        r103.set(this.mRootBounds);
        goto L16
    L20:
        Matrix r109 = this.mInsideBorderTransform;
        if (r109 == null) goto L24;
        r109.reset();
        goto L24
    L9:
        this.mBitmapBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mDrawableBounds.set(this.mDelegate.getBounds());
        goto L10
    L5:
        this.mParentTransform.reset();
        this.mRootBounds.set(getBounds());
        goto L6
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mCornerRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    public RoundedDrawable(Drawable r100) {
        this.mIsCircle = false;
        this.mRadiiNonZero = false;
        this.mBorderWidth = 0.0f;
        this.mPath = new Path();
        this.mIsShaderTransformDirty = true;
        this.mBorderColor = 0;
        this.mBorderPath = new Path();
        this.mCornerRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mRootBounds = new RectF();
        this.mPrevRootBounds = new RectF();
        this.mBitmapBounds = new RectF();
        this.mDrawableBounds = new RectF();
        this.mBoundsTransform = new Matrix();
        this.mPrevBoundsTransform = new Matrix();
        this.mParentTransform = new Matrix();
        this.mPrevParentTransform = new Matrix();
        this.mInverseParentTransform = new Matrix();
        this.mTransform = new Matrix();
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mIsPathDirty = true;
        this.mDelegate = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("RoundedDrawable#draw");
    L5:
        this.mDelegate.draw(r100);
        if (FrescoSystrace.isTracing() == false) goto L9;
        FrescoSystrace.endSection();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        this.mDelegate.setBounds(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mDelegate.setAlpha(r100);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean r100) {
        this.mIsCircle = r100;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mDelegate.setColorFilter(r100);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float r100) {
        if (this.mPadding == r100) goto L6;
        this.mPadding = r100;
        this.mIsPathDirty = true;
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] r100) {
        if (r100 != null) goto L6;
        Arrays.fill(this.mCornerRadii, 0.0f);
        this.mRadiiNonZero = false;
    L16:
        this.mIsPathDirty = true;
        invalidateSelf();
        return;
    L6:
        if (r100.length != 8) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkArgument(r101, "radii should have exactly 8 values");
        System.arraycopy(r100, 0, this.mCornerRadii, 0, 8);
        this.mRadiiNonZero = false;
        int r102 = 0;
    L10:
        if (r102 >= 8) goto L16;
        boolean r103 = this.mRadiiNonZero;
        if (r100[r102] <= 0.0f) goto L14;
        boolean r104 = true;
    L15:
        this.mRadiiNonZero = r103 | r104;
        r102 = r102 + 1;
        goto L10
    L14:
        r104 = false;
        goto L15
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float r100) {
        boolean r101 = false;
        if (r100 < 0.0f) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102);
        Arrays.fill(this.mCornerRadii, r100);
        if (r100 == 0.0f) goto L9;
        r101 = true;
    L9:
        this.mRadiiNonZero = r101;
        this.mIsPathDirty = true;
        invalidateSelf();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean r100) {
        if (this.mScaleDownInsideBorders == r100) goto L6;
        this.mScaleDownInsideBorders = r100;
        this.mIsPathDirty = true;
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback r100) {
        this.mTransformCallback = r100;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int r100, float r101) {
        if (this.mBorderColor == r100) goto L5;
    L6:
        this.mBorderColor = r100;
        this.mBorderWidth = r101;
        this.mIsPathDirty = true;
        invalidateSelf();
        return;
    L5:
        if (this.mBorderWidth != r101) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r100, PorterDuff.Mode r101) {
        this.mDelegate.setColorFilter(r100, r101);
    }
}
