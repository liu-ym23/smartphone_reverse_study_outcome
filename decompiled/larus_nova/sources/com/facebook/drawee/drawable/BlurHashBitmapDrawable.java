package com.facebook.drawee.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes23.dex */
public class BlurHashBitmapDrawable extends BitmapDrawable {
    private Bitmap bitmap;
    private Paint myPaint;
    private ScalingUtils.ScaleType scaleType;
    private int targetHeight;
    private int targetWidth;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        if (this.targetWidth > 0) goto L5;
    L13:
        super.draw(r110);
        return;
    L5:
        if (this.targetHeight <= 0) goto L13;
        if (this.scaleType != ScalingUtils.ScaleType.FIT_CENTER) goto L10;
        double r100 = Math.min((((double) r110.getWidth()) * 1.0d) / ((double) this.targetWidth), (((double) r110.getHeight()) * 1.0d) / ((double) this.targetHeight));
    L11:
        double r101 = ((double) this.targetWidth) * r100;
        double r102 = ((double) this.targetHeight) * r100;
        double r103 = (((double) r110.getWidth()) - r101) / 2.0d;
        double r104 = (((double) r110.getHeight()) - r102) / 2.0d;
        r110.drawBitmap(this.bitmap, null, new Rect((int) r103, (int) r104, (int) (r103 + r101), (int) (r104 + r102)), this.myPaint);
        return;
    L10:
        r100 = Math.max((((double) r110.getWidth()) * 1.0d) / ((double) this.targetWidth), (((double) r110.getHeight()) * 1.0d) / ((double) this.targetHeight));
        goto L11
    }

    public BlurHashBitmapDrawable(Bitmap r100, int r101, int r102, ScalingUtils.ScaleType r103) {
        super(r100);
        Paint r104 = new Paint();
        this.myPaint = r104;
        this.bitmap = r100;
        this.targetWidth = r101;
        this.targetHeight = r102;
        this.scaleType = r103;
        r104.setAntiAlias(true);
    }
}
