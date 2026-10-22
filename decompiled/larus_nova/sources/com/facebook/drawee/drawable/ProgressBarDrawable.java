package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes23.dex */
public class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    private int mBackgroundColor;
    private int mBarWidth;
    private int mColor;
    private boolean mHideWhenZero;
    private boolean mIsVertical;
    private int mLevel;
    private int mPadding;
    private final Paint mPaint;
    private final Path mPath;
    private int mRadius;
    private final RectF mRect;

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public Drawable cloneDrawable() {
        ProgressBarDrawable r100 = new ProgressBarDrawable();
        r100.mBackgroundColor = this.mBackgroundColor;
        r100.mColor = this.mColor;
        r100.mPadding = this.mPadding;
        r100.mBarWidth = this.mBarWidth;
        r100.mLevel = this.mLevel;
        r100.mRadius = this.mRadius;
        r100.mHideWhenZero = this.mHideWhenZero;
        r100.mIsVertical = this.mIsVertical;
        return r100;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
    }

    public ProgressBarDrawable() {
        this.mPaint = new Paint(1);
        this.mPath = new Path();
        this.mRect = new RectF();
        this.mBackgroundColor = Integer.MIN_VALUE;
        this.mColor = -2147450625;
        this.mPadding = 10;
        this.mBarWidth = 20;
        this.mLevel = 0;
        this.mRadius = 0;
        this.mHideWhenZero = false;
        this.mIsVertical = false;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBarWidth() {
        return this.mBarWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    public boolean getHideWhenZero() {
        return this.mHideWhenZero;
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    public int getRadius() {
        return this.mRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.mHideWhenZero == false) goto L8;
        if (this.mLevel != 0) goto L8;
        return;
    L8:
        if (this.mIsVertical == false) goto L10;
        drawVerticalBar(r100, 10000, this.mBackgroundColor);
        drawVerticalBar(r100, this.mLevel, this.mColor);
        return;
    L10:
        drawHorizontalBar(r100, 10000, this.mBackgroundColor);
        drawHorizontalBar(r100, this.mLevel, this.mColor);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        int r101 = this.mPadding;
        r100.set(r101, r101, r101, r101);
        if (this.mPadding == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        this.mLevel = r100;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mPaint.setAlpha(r100);
    }

    public void setBackgroundColor(int r100) {
        if (this.mBackgroundColor == r100) goto L6;
        this.mBackgroundColor = r100;
        invalidateSelf();
        return;
    }

    public void setBarWidth(int r100) {
        if (this.mBarWidth == r100) goto L6;
        this.mBarWidth = r100;
        invalidateSelf();
        return;
    }

    public void setColor(int r100) {
        if (this.mColor == r100) goto L6;
        this.mColor = r100;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
    }

    public void setHideWhenZero(boolean r100) {
        this.mHideWhenZero = r100;
    }

    public void setIsVertical(boolean r100) {
        if (this.mIsVertical == r100) goto L6;
        this.mIsVertical = r100;
        invalidateSelf();
        return;
    }

    public void setPadding(int r100) {
        if (this.mPadding == r100) goto L6;
        this.mPadding = r100;
        invalidateSelf();
        return;
    }

    public void setRadius(int r100) {
        if (this.mRadius == r100) goto L6;
        this.mRadius = r100;
        invalidateSelf();
        return;
    }

    private void drawBar(Canvas r100, int r101) {
        this.mPaint.setColor(r101);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPath.reset();
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        this.mPath.addRoundRect(this.mRect, Math.min(this.mRadius, this.mBarWidth / 2), Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
        r100.drawPath(this.mPath, this.mPaint);
    }

    private void drawHorizontalBar(Canvas r100, int r101, int r102) {
        Rect r103 = getBounds();
        int r104 = r103.width();
        int r105 = this.mPadding;
        int r106 = ((r104 - (r105 * 2)) * r101) / 10000;
        int r107 = r103.left + r105;
        int r108 = r103.bottom - r105;
        int r109 = this.mBarWidth;
        int r110 = r108 - r109;
        this.mRect.set(r107, r110, r107 + r106, r110 + r109);
        drawBar(r100, r102);
    }

    private void drawVerticalBar(Canvas r100, int r101, int r102) {
        Rect r103 = getBounds();
        int r104 = r103.height();
        int r105 = this.mPadding;
        int r106 = ((r104 - (r105 * 2)) * r101) / 10000;
        int r107 = r103.left + r105;
        int r108 = r103.top + r105;
        this.mRect.set(r107, r108, r107 + this.mBarWidth, r108 + r106);
        drawBar(r100, r102);
    }
}
