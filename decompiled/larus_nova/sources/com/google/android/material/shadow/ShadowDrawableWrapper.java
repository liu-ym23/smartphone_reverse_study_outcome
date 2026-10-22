package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = 0.0d;
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;
    final RectF contentBounds;
    float cornerRadius;
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void buildShadowCorners() {
        float r100 = this.cornerRadius;
        RectF r101 = new RectF(-r100, -r100, r100, r100);
        RectF r102 = new RectF(r101);
        float r103 = this.shadowSize;
        r102.inset(-r103, -r103);
        Path r104 = this.cornerShadowPath;
        if (r104 != null) goto L5;
        this.cornerShadowPath = new Path();
    L6:
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(r102, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(r101, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float r110 = -r102.top;
        if (r110 <= 0.0f) goto L9;
        float r105 = this.cornerRadius / r110;
        this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, r110, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, r105, ((1.0f - r105) / 2.0f) + r105, 1.0f}, Shader.TileMode.CLAMP));
    L9:
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, r101.top, 0.0f, r102.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r104.reset();
        goto L6
    }

    public float getMinHeight() {
        float r100 = this.rawMaxShadowSize;
        return (Math.max(r100, this.cornerRadius + ((r100 * 1.5f) / 2.0f)) * 2.0f) + ((this.rawMaxShadowSize * 1.5f) * 2.0f);
    }

    public float getMinWidth() {
        float r100 = this.rawMaxShadowSize;
        return (Math.max(r100, this.cornerRadius + (r100 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    private void buildComponents(Rect r100) {
        float r101 = this.rawMaxShadowSize;
        float r102 = 1.5f * r101;
        this.contentBounds.set(r100.left + r101, r100.top + r102, r100.right - r101, r100.bottom - r102);
        Drawable r103 = getWrappedDrawable();
        RectF r104 = this.contentBounds;
        r103.setBounds((int) r104.left, (int) r104.top, (int) r104.right, (int) r104.bottom);
        buildShadowCorners();
    }

    private void drawShadow(Canvas r210) {
        int r100 = r210.save();
        r210.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float r101 = this.cornerRadius;
        float r110 = (-r101) - this.shadowSize;
        float r111 = r101 * 2.0f;
        if ((this.contentBounds.width() - r111) <= 0.0f) goto L5;
        boolean r112 = true;
    L7:
        if ((this.contentBounds.height() - r111) <= 0.0f) goto L9;
        boolean r113 = true;
    L10:
        float r102 = this.rawShadowSize;
        float r103 = r102 - (0.25f * r102);
        float r104 = r102 - (0.5f * r102);
        float r114 = r101 / (r104 + r101);
        float r105 = r101 / (r103 + r101);
        float r106 = r101 / ((r102 - (r102 * 1.0f)) + r101);
        int r107 = r210.save();
        RectF r108 = this.contentBounds;
        r210.translate(r108.left + r101, r108.top + r101);
        r210.scale(r114, r105);
        r210.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r112 == false) goto L14;
        r210.scale(1.0f / r114, 1.0f);
        r210.drawRect(0.0f, r110, this.contentBounds.width() - r111, -this.cornerRadius, this.edgeShadowPaint);
    L14:
        r210.restoreToCount(r107);
        int r115 = r210.save();
        RectF r109 = this.contentBounds;
        r210.translate(r109.right - r101, r109.bottom - r101);
        r210.scale(r114, r106);
        r210.rotate(180.0f);
        r210.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r112 == false) goto L18;
        r210.scale(1.0f / r114, 1.0f);
        r210.drawRect(0.0f, r110, this.contentBounds.width() - r111, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
    L18:
        r210.restoreToCount(r115);
        int r116 = r210.save();
        RectF r117 = this.contentBounds;
        r210.translate(r117.left + r101, r117.bottom - r101);
        r210.scale(r114, r6);
        r210.rotate(270.0f);
        r210.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r113 == false) goto L21;
        r210.scale(1.0f / r106, 1.0f);
        r210.drawRect(0.0f, r110, this.contentBounds.height() - r111, -this.cornerRadius, this.edgeShadowPaint);
    L21:
        r210.restoreToCount(r116);
        int r118 = r210.save();
        RectF r119 = this.contentBounds;
        r210.translate(r119.right - r101, r119.top + r101);
        r210.scale(r114, r105);
        r210.rotate(90.0f);
        r210.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r113 == false) goto L24;
        r210.scale(1.0f / r105, 1.0f);
        r210.drawRect(0.0f, r110, this.contentBounds.height() - r111, -this.cornerRadius, this.edgeShadowPaint);
    L24:
        r210.restoreToCount(r118);
        r210.restoreToCount(r100);
        return;
    L9:
        r113 = false;
        goto L10
    L5:
        r112 = false;
        goto L7
    }

    private static int toEven(float r100) {
        int r101 = Math.round(r100);
        if ((r101 % 2) == 1) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.dirty == false) goto L5;
        buildComponents(getBounds());
        this.dirty = false;
    L5:
        drawShadow(r100);
        super.draw(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        int r101 = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int r102 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        r100.set(r102, r101, r102, r101);
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean r100) {
        this.addPaddingForCorners = r100;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        super.setAlpha(r100);
        this.cornerShadowPaint.setAlpha(r100);
        this.edgeShadowPaint.setAlpha(r100);
    }

    public void setCornerRadius(float r100) {
        float r101 = Math.round(r100);
        if (this.cornerRadius != r101) goto L5;
        return;
    L5:
        this.cornerRadius = r101;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float r100) {
        setShadowSize(this.rawShadowSize, r100);
    }

    public final void setRotation(float r100) {
        if (this.rotation == r100) goto L6;
        this.rotation = r100;
        invalidateSelf();
        return;
    }

    public void setShadowSize(float r100) {
        setShadowSize(r100, this.rawMaxShadowSize);
    }

    public void setShadowSize(float r100, float r101) {
        if (r100 < 0.0f) goto L20;
        if (r101 < 0.0f) goto L20;
        float r102 = toEven(r100);
        float r103 = toEven(r101);
        if (r102 <= r103) goto L13;
        if (this.printedShadowClipWarning == true) goto L11;
        this.printedShadowClipWarning = true;
    L11:
        r102 = r103;
    L13:
        if (this.rawShadowSize == r102) goto L15;
    L17:
        this.rawShadowSize = r102;
        this.rawMaxShadowSize = r103;
        this.shadowSize = Math.round(r102 * 1.5f);
        this.maxShadowSize = r103;
        this.dirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.rawMaxShadowSize != r103) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("invalid shadow size");
    }

    public static float calculateHorizontalPadding(float r100, float r101, boolean r102) {
        if (r102 == true) goto L4;
        return r100;
    L4:
        return (float) (((double) r100) + ((1.0d - COS_45) * ((double) r101)));
    }

    public static float calculateVerticalPadding(float r100, float r101, boolean r102) {
        if (r102 == false) goto L7;
        return (float) (((double) (r100 * 1.5f)) + ((1.0d - COS_45) * ((double) r101)));
    L7:
        return r100 * 1.5f;
    }

    public ShadowDrawableWrapper(Context r100, Drawable r101, float r102, float r103, float r104) {
        super(r101);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(r100, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(r100, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(r100, R.color.design_fab_shadow_end_color);
        Paint r105 = new Paint(5);
        this.cornerShadowPaint = r105;
        r105.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(r102);
        this.contentBounds = new RectF();
        Paint r106 = new Paint(r105);
        this.edgeShadowPaint = r106;
        r106.setAntiAlias(false);
        setShadowSize(r103, r104);
    }
}
