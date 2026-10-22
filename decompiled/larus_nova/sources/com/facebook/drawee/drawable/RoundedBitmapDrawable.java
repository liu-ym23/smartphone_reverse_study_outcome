package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedBitmapDrawable extends RoundedDrawable {

    @Nullable
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private WeakReference<Bitmap> mLastBitmap;
    private final Paint mPaint;

    private void updatePaint() {
        WeakReference<Bitmap> r100 = this.mLastBitmap;
        if (r100 != null) goto L5;
    L6:
        Bitmap r101 = this.mBitmap;
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        BitmapShader r103 = new BitmapShader(r101, r102, r102);
        this.mLastBitmap = new WeakReference(this.mBitmap);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setShader(r103);
        this.mIsShaderTransformDirty = true;
    L8:
        if (this.mIsShaderTransformDirty == false) goto L11;
        this.mPaint.getShader().setLocalMatrix(this.mTransform);
        this.mIsShaderTransformDirty = false;
        return;
    L11:
        return;
    L5:
        if (r100.get() == this.mBitmap) goto L8;
        goto L6
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap r100 = this.mBitmap;
        if (r100 == null) goto L7;
        return r100.getHeight();
    L7:
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap r100 = this.mBitmap;
        if (r100 == null) goto L7;
        return r100.getWidth();
    L7:
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable
    public boolean shouldRound() {
        if (super.shouldRound() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mBitmap == null) goto L7;
        return true;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("RoundedBitmapDrawable#draw");
    L6:
        if (shouldRound() == true) goto L11;
        super.draw(r100);
        if (FrescoSystrace.isTracing() == false) goto L18;
        FrescoSystrace.endSection();
        return;
    L18:
        return;
    L11:
        updateTransform();
        updatePath();
        updatePaint();
        int r101 = r100.save();
        r100.concat(this.mInverseParentTransform);
        r100.drawPath(this.mPath, this.mPaint);
        float r102 = this.mBorderWidth;
        if (r102 <= 0.0f) goto L14;
        this.mBorderPaint.setStrokeWidth(r102);
        this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
        r100.drawPath(this.mBorderPath, this.mBorderPaint);
    L14:
        r100.restoreToCount(r101);
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
        return;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        super.setAlpha(r100);
        if (r100 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r100);
        super.setAlpha(r100);
        invalidateSelf();
        return;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        super.setColorFilter(r100);
        this.mPaint.setColorFilter(r100);
    }

    public RoundedBitmapDrawable(Resources r100, Bitmap r101) {
        this(r100, r101, null);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources r100, BitmapDrawable r101) {
        return new RoundedBitmapDrawable(r100, r101.getBitmap(), r101.getPaint());
    }

    public RoundedBitmapDrawable(Resources r100, @Nullable Bitmap r101, @Nullable Paint r102) {
        super(new BitmapDrawable(r100, r101));
        Paint r103 = new Paint();
        this.mPaint = r103;
        Paint r104 = new Paint(1);
        this.mBorderPaint = r104;
        this.mBitmap = r101;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L10:
        if (r102 == null) goto L12;
        r103.set(r102);
    L12:
        r103.setFlags(1);
        r104.setStyle(Paint.Style.STROKE);
        return;
    L5:
        if ((this.mDelegate instanceof BitmapDrawable) == false) goto L10;
        if (r101 == null) goto L10;
        int r105 = r101.getDensity();
        int r106 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (r105 != r106) goto L10;
        ((BitmapDrawable) this.mDelegate).setTargetDensity(r106);
        goto L10
    }
}
