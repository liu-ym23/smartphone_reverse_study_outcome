package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DrawableWrapper extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public DrawableWrapper(Drawable r1) {
        setWrappedDrawable(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        this.mDrawable.draw(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r2) {
        return this.mDrawable.getPadding(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        this.mDrawable.setBounds(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r2) {
        return this.mDrawable.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        DrawableCompat.setAutoMirrored(this.mDrawable, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int r2) {
        this.mDrawable.setChangingConfigurations(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mDrawable.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r2) {
        this.mDrawable.setDither(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r2) {
        this.mDrawable.setFilterBitmap(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r2) {
        return this.mDrawable.setState(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r2) {
        DrawableCompat.setTint(this.mDrawable, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r2) {
        DrawableCompat.setTintList(this.mDrawable, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r2) {
        DrawableCompat.setTintMode(this.mDrawable, r2);
    }

    public void setWrappedDrawable(Drawable r3) {
        Drawable r0 = this.mDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mDrawable = r3;
        if (r3 == null) goto L9;
        r3.setCallback(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r2, float r3) {
        DrawableCompat.setHotspot(this.mDrawable, r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        if (super.setVisible(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawable.setVisible(r2, r3) == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r2, int r3, int r4, int r5) {
        DrawableCompat.setHotspotBounds(this.mDrawable, r2, r3, r4, r5);
    }
}
