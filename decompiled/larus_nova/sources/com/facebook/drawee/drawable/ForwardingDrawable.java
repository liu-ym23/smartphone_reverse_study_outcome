package com.facebook.drawee.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {
    private static final Matrix sTempTransform = null;
    private Drawable mCurrentDelegate;
    private final DrawableProperties mDrawableProperties;
    private boolean mStopDrawUntilSetDrawable;
    protected TransformCallback mTransformCallback;

    public void stopDrawUntilSetDrawable() {
        this.mStopDrawUntilSetDrawable = true;
    }

    static {
        sTempTransform = new Matrix();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 != null) goto L7;
        return super.getConstantState();
    L7:
        return r100.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 != null) goto L7;
        return super.getIntrinsicHeight();
    L7:
        return r100.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 != null) goto L7;
        return super.getIntrinsicWidth();
    L7:
        return r100.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r100 = this.mCurrentDelegate;
        if (r100 == null) goto L5;
        r100.mutate();
    L5:
        return this;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable getDrawable() {
        return getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mCurrentDelegate;
    }

    public ForwardingDrawable(Drawable r100) {
        this.mDrawableProperties = new DrawableProperties();
        this.mStopDrawUntilSetDrawable = false;
        this.mCurrentDelegate = r100;
        DrawableUtils.setCallbacks(r100, this, this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.mStopDrawUntilSetDrawable == false) goto L5;
        return;
    L5:
        Drawable r101 = this.mCurrentDelegate;
        if (r101 != null) goto L8;
        return;
    L8:
        if ((r101 instanceof RoundedBitmapDrawable) == false) goto L14;
        Bitmap r102 = ((RoundedBitmapDrawable) r101).getBitmap();
        if (r102 == null) goto L14;
        if (r102.isRecycled() == false) goto L14;
        return;
    L14:
        this.mCurrentDelegate.draw(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        Drawable r101 = this.mCurrentDelegate;
        if (r101 != null) goto L7;
        return super.getPadding(r100);
    L7:
        return r101.getPadding(r100);
    }

    public void getParentTransform(Matrix r100) {
        TransformCallback r101 = this.mTransformCallback;
        if (r101 == null) goto L5;
        r101.getTransform(r100);
        return;
    L5:
        r100.reset();
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(RectF r100) {
        TransformCallback r101 = this.mTransformCallback;
        if (r101 == null) goto L5;
        r101.getRootBounds(r100);
        return;
    L5:
        r100.set(getBounds());
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix r100) {
        getParentTransform(r100);
    }

    public void getTransformedBounds(RectF r100) {
        Matrix r101 = sTempTransform;
        getParentTransform(r101);
        r100.set(getBounds());
        r101.mapRect(r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = this.mCurrentDelegate;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        Drawable r101 = this.mCurrentDelegate;
        if (r101 != null) goto L7;
        return super.onLevelChange(r100);
    L7:
        return r101.setLevel(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        Drawable r101 = this.mCurrentDelegate;
        if (r101 != null) goto L7;
        return super.onStateChange(r100);
    L7:
        return r101.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mDrawableProperties.setAlpha(r100);
        Drawable r101 = this.mCurrentDelegate;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mDrawableProperties.setColorFilter(r100);
        Drawable r101 = this.mCurrentDelegate;
        if (r101 == null) goto L6;
        r101.setColorFilter(r100);
        return;
    }

    public Drawable setCurrent(Drawable r100) {
        Drawable r101 = setCurrentWithoutInvalidate(r100);
        invalidateSelf();
        return r101;
    }

    public Drawable setCurrentWithoutInvalidate(Drawable r100) {
        Drawable r101 = this.mCurrentDelegate;
        DrawableUtils.setCallbacks(r101, null, null);
        DrawableUtils.setCallbacks(r100, null, null);
        DrawableUtils.setDrawableProperties(r100, this.mDrawableProperties);
        DrawableUtils.copyProperties(r100, this);
        DrawableUtils.setCallbacks(r100, this, this);
        this.mCurrentDelegate = r100;
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        this.mDrawableProperties.setDither(r100);
        Drawable r101 = this.mCurrentDelegate;
        if (r101 == null) goto L6;
        r101.setDither(r100);
        return;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable setDrawable(Drawable r100) {
        Drawable r101 = setCurrent(r100);
        this.mStopDrawUntilSetDrawable = false;
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        this.mDrawableProperties.setFilterBitmap(r100);
        Drawable r101 = this.mCurrentDelegate;
        if (r101 == null) goto L6;
        r101.setFilterBitmap(r100);
        return;
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback r100) {
        this.mTransformCallback = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        Drawable r102 = this.mCurrentDelegate;
        if (r102 == null) goto L6;
        r102.setHotspot(r100, r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        Drawable r103 = this.mCurrentDelegate;
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.setVisible(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r100, Runnable r101) {
        unscheduleSelf(r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        scheduleSelf(r101, r102);
    }
}
