package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedColorDrawable extends Drawable implements Rounded {
    private int mAlpha;
    private int mBorderColor;
    final Path mBorderPath;
    final float[] mBorderRadii;
    private float mBorderWidth;
    private int mColor;

    @Nullable
    float[] mInsideBorderRadii;
    private boolean mIsCircle;
    private float mPadding;
    final Paint mPaint;
    final Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final RectF mTempRect;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    private void updatePath() {
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRect.set(getBounds());
        RectF r100 = this.mTempRect;
        float r101 = this.mBorderWidth;
        r100.inset(r101 / 2.0f, r101 / 2.0f);
        int r102 = 0;
        if (this.mIsCircle == false) goto L5;
        float r103 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f;
        this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), r103, Path.Direction.CW);
    L10:
        RectF r104 = this.mTempRect;
        float r105 = this.mBorderWidth;
        r104.inset((-r105) / 2.0f, (-r105) / 2.0f);
        float r106 = this.mPadding;
        if (this.mScaleDownInsideBorders == false) goto L13;
        float r107 = this.mBorderWidth;
    L14:
        float r108 = r106 + r107;
        this.mTempRect.inset(r108, r108);
        if (this.mIsCircle == false) goto L18;
        float r109 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f;
        this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), r109, Path.Direction.CW);
    L27:
        float r110 = -r108;
        this.mTempRect.inset(r110, r110);
        return;
    L18:
        if (this.mScaleDownInsideBorders == true) goto L20;
        this.mPath.addRoundRect(this.mTempRect, this.mRadii, Path.Direction.CW);
        goto L27
    L20:
        if (this.mInsideBorderRadii != null) goto L22;
        this.mInsideBorderRadii = new float[8];
    L22:
        float[] r111 = this.mInsideBorderRadii;
        if (r102 >= r111.length) goto L25;
        r111[r102] = this.mRadii[r102] - this.mBorderWidth;
        r102 = r102 + 1;
        goto L22
    L25:
        this.mPath.addRoundRect(this.mTempRect, r111, Path.Direction.CW);
        goto L27
    L13:
        r107 = 0.0f;
        goto L14
    L5:
        int r112 = 0;
    L6:
        float[] r113 = this.mBorderRadii;
        if (r112 >= r113.length) goto L9;
        r113[r112] = (this.mRadii[r112] + this.mPadding) - (this.mBorderWidth / 2.0f);
        r112 = r112 + 1;
        goto L6
    L9:
        this.mBorderPath.addRoundRect(this.mTempRect, r113, Path.Direction.CW);
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    public RoundedColorDrawable(int r100) {
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mPadding = 0.0f;
        this.mBorderColor = 0;
        this.mScaleDownInsideBorders = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mColor = 0;
        this.mTempRect = new RectF();
        this.mAlpha = 255;
        setColor(r100);
    }

    public static RoundedColorDrawable fromColorDrawable(ColorDrawable r100) {
        return new RoundedColorDrawable(r100.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        r100.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth == 0.0f) goto L6;
        this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        r100.drawPath(this.mBorderPath, this.mPaint);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        updatePath();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (r100 == this.mAlpha) goto L6;
        this.mAlpha = r100;
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean r100) {
        this.mIsCircle = r100;
        updatePath();
        invalidateSelf();
    }

    public void setColor(int r100) {
        if (this.mColor == r100) goto L6;
        this.mColor = r100;
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float r100) {
        if (this.mPadding == r100) goto L6;
        this.mPadding = r100;
        updatePath();
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] r100) {
        if (r100 != null) goto L5;
        Arrays.fill(this.mRadii, 0.0f);
    L9:
        updatePath();
        invalidateSelf();
        return;
    L5:
        if (r100.length != 8) goto L7;
        boolean r101 = true;
    L8:
        Preconditions.checkArgument(r101, "radii should have exactly 8 values");
        System.arraycopy(r100, 0, this.mRadii, 0, 8);
        goto L9
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float r100) {
        if (r100 < 0.0f) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "radius should be non negative");
        Arrays.fill(this.mRadii, r100);
        updatePath();
        invalidateSelf();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean r100) {
        if (this.mScaleDownInsideBorders == r100) goto L6;
        this.mScaleDownInsideBorders = r100;
        updatePath();
        invalidateSelf();
        return;
    }

    public RoundedColorDrawable(float r100, int r101) {
        this(r101);
        setRadius(r100);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int r100, float r101) {
        if (this.mBorderColor == r100) goto L6;
        this.mBorderColor = r100;
        invalidateSelf();
    L6:
        if (this.mBorderWidth == r101) goto L9;
        this.mBorderWidth = r101;
        updatePath();
        invalidateSelf();
        return;
    }

    public RoundedColorDrawable(float[] r100, int r101) {
        this(r101);
        setRadii(r100);
    }
}
