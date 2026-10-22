package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes23.dex */
public class CircularBorderDrawable extends Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    private ColorStateList borderTint;
    float borderWidth;
    private int bottomInnerStrokeColor;
    private int bottomOuterStrokeColor;
    private int currentBorderTintColor;
    private boolean invalidateShader;
    final Paint paint;
    final Rect rect;
    final RectF rectF;
    private float rotation;
    final CircularBorderState state;
    private int topInnerStrokeColor;
    private int topOuterStrokeColor;

    /* JADX INFO: renamed from: com.google.android.material.internal.CircularBorderDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CircularBorderState extends Drawable.ConstantState {
        final /* synthetic */ CircularBorderDrawable this$0;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return this.this$0;
        }

        private CircularBorderState(CircularBorderDrawable r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ CircularBorderState(CircularBorderDrawable r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private Shader createGradientShader() {
        Rect r100 = this.rect;
        copyBounds(r100);
        float r101 = this.borderWidth / r100.height();
        return new LinearGradient(0.0f, r100.top, 0.0f, r100.bottom, new int[]{ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, r101, 0.5f, 0.5f, 1.0f - r101, 1.0f}, Shader.TileMode.CLAMP);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.borderWidth <= 0.0f) goto L5;
        return -3;
    L5:
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r100 = this.borderTint;
        if (r100 == null) goto L7;
        if (r100.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    public CircularBorderDrawable() {
        this.rect = new Rect();
        this.rectF = new RectF();
        this.state = new CircularBorderState(this, null);
        this.invalidateShader = true;
        Paint r100 = new Paint(1);
        this.paint = r100;
        r100.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.invalidateShader == false) goto L5;
        this.paint.setShader(createGradientShader());
        this.invalidateShader = false;
    L5:
        float r101 = this.paint.getStrokeWidth() / 2.0f;
        RectF r102 = this.rectF;
        copyBounds(this.rect);
        r102.set(this.rect);
        r102.left += r101;
        r102.top += r101;
        r102.right -= r101;
        r102.bottom -= r101;
        r100.save();
        r100.rotate(this.rotation, r102.centerX(), r102.centerY());
        r100.drawOval(r102, this.paint);
        r100.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        int r101 = Math.round(this.borderWidth);
        r100.set(r101, r101, r101, r101);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        this.invalidateShader = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        ColorStateList r101 = this.borderTint;
        if (r101 == null) goto L8;
        int r102 = r101.getColorForState(r100, this.currentBorderTintColor);
        if (r102 == this.currentBorderTintColor) goto L8;
        this.invalidateShader = true;
        this.currentBorderTintColor = r102;
    L8:
        if (this.invalidateShader == false) goto L11;
        invalidateSelf();
    L11:
        return this.invalidateShader;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.paint.setAlpha(r100);
        invalidateSelf();
    }

    public void setBorderTint(ColorStateList r100) {
        if (r100 == null) goto L4;
        this.currentBorderTintColor = r100.getColorForState(getState(), this.currentBorderTintColor);
    L4:
        this.borderTint = r100;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setBorderWidth(float r100) {
        if (this.borderWidth == r100) goto L6;
        this.borderWidth = r100;
        this.paint.setStrokeWidth(r100 * DRAW_STROKE_WIDTH_MULTIPLE);
        this.invalidateShader = true;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.paint.setColorFilter(r100);
        invalidateSelf();
    }

    public final void setRotation(float r100) {
        if (r100 == this.rotation) goto L6;
        this.rotation = r100;
        invalidateSelf();
        return;
    }

    public void setGradientColors(int r100, int r101, int r102, int r103) {
        this.topOuterStrokeColor = r100;
        this.topInnerStrokeColor = r101;
        this.bottomOuterStrokeColor = r102;
        this.bottomInnerStrokeColor = r103;
    }
}
