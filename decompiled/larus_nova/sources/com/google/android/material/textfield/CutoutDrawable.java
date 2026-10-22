package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes23.dex */
class CutoutDrawable extends GradientDrawable {
    private final RectF cutoutBounds;
    private final Paint cutoutPaint;
    private int savedLayer;

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public CutoutDrawable() {
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    private void postDraw(Canvas r100) {
        if (useHardwareLayer(getCallback()) == true) goto L6;
        r100.restoreToCount(this.savedLayer);
        return;
    }

    private void preDraw(Canvas r100) {
        Drawable.Callback r101 = getCallback();
        if (useHardwareLayer(r101) == false) goto L5;
        ((View) r101).setLayerType(2, null);
        return;
    L5:
        saveCanvasLayer(r100);
    }

    private void saveCanvasLayer(Canvas r100) {
        this.savedLayer = r100.saveLayer(0.0f, 0.0f, r100.getWidth(), r100.getHeight(), null);
    }

    private boolean useHardwareLayer(Drawable.Callback r100) {
        return r100 instanceof View;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        preDraw(r100);
        super.draw(r100);
        r100.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(r100);
    }

    public void setCutout(RectF r100) {
        setCutout(r100.left, r100.top, r100.right, r100.bottom);
    }

    public void setCutout(float r100, float r101, float r102, float r103) {
        RectF r104 = this.cutoutBounds;
        if (r100 == r104.left) goto L5;
    L10:
        r104.set(r100, r101, r102, r103);
        invalidateSelf();
        return;
    L5:
        if (r101 != r104.top) goto L10;
        if (r102 != r104.right) goto L10;
        if (r103 != r104.bottom) goto L10;
    }
}
