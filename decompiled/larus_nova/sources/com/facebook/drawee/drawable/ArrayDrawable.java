package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {
    private final DrawableParent[] mDrawableParents;
    private final DrawableProperties mDrawableProperties;
    private boolean mIsMutated;
    private boolean mIsStateful;
    private boolean mIsStatefulCalculated;
    private final Drawable[] mLayers;
    private final Rect mTmpRect;
    private TransformCallback mTransformCallback;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int r100 = 0;
        int r101 = -1;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r100 >= r102.length) goto L9;
        Drawable r103 = r102[r100];
        if (r103 == null) goto L8;
        r101 = Math.max(r101, r103.getIntrinsicHeight());
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        if (r101 > 0) goto L11;
        return -1;
    L11:
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int r100 = 0;
        int r101 = -1;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r100 >= r102.length) goto L9;
        Drawable r103 = r102[r100];
        if (r103 == null) goto L8;
        r101 = Math.max(r101, r103.getIntrinsicWidth());
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        if (r101 > 0) goto L11;
        return -1;
    L11:
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int r100 = 0;
    L3:
        Drawable[] r101 = this.mLayers;
        if (r100 >= r101.length) goto L9;
        Drawable r102 = r101[r100];
        if (r102 == null) goto L8;
        r102.mutate();
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        this.mIsMutated = true;
        return this;
    }

    public int getNumberOfLayers() {
        return this.mLayers.length;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mLayers.length != 0) goto L6;
        return -2;
    L6:
        int r100 = 1;
        int r101 = -1;
    L7:
        Drawable[] r102 = this.mLayers;
        if (r100 >= r102.length) goto L13;
        Drawable r103 = r102[r100];
        if (r103 == null) goto L12;
        r101 = Drawable.resolveOpacity(r101, r103.getOpacity());
    L12:
        r100 = r100 + 1;
        goto L7
    L13:
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mIsStatefulCalculated == true) goto L16;
        this.mIsStateful = false;
        int r100 = 0;
    L5:
        Drawable[] r101 = this.mLayers;
        boolean r102 = true;
        if (r100 >= r101.length) goto L14;
        Drawable r103 = r101[r100];
        boolean r104 = this.mIsStateful;
        if (r103 != null) goto L10;
    L12:
        r102 = false;
    L13:
        this.mIsStateful = r104 | r102;
        r100 = r100 + 1;
        goto L5
    L10:
        if (r103.isStateful() == false) goto L12;
    L14:
        this.mIsStatefulCalculated = true;
    L16:
        return this.mIsStateful;
    }

    public ArrayDrawable(Drawable[] r100) {
        this.mDrawableProperties = new DrawableProperties();
        this.mTmpRect = new Rect();
        int r101 = 0;
        this.mIsStateful = false;
        this.mIsStatefulCalculated = false;
        this.mIsMutated = false;
        Preconditions.checkNotNull(r100);
        this.mLayers = r100;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L6;
        DrawableUtils.setCallbacks(r102[r101], this, this);
        r101 = r101 + 1;
        goto L3
    L6:
        this.mDrawableParents = new DrawableParent[r102.length];
    }

    private DrawableParent createDrawableParentForIndex(final int r100) {
        return new AnonymousClass1(this, r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.draw(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Nullable
    public Drawable getDrawable(int r100) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        if (r100 < this.mLayers.length) goto L10;
        r101 = false;
    L10:
        Preconditions.checkArgument(r101);
        return this.mLayers[r100];
    L5:
        r102 = false;
        goto L6
    }

    public DrawableParent getDrawableParentForIndex(int r100) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        if (r100 < this.mDrawableParents.length) goto L10;
        r101 = false;
    L10:
        Preconditions.checkArgument(r101);
        DrawableParent[] r103 = this.mDrawableParents;
        if (r103[r100] != null) goto L14;
        r103[r100] = createDrawableParentForIndex(r100);
    L14:
        return this.mDrawableParents[r100];
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        int r101 = 0;
        r100.left = 0;
        r100.top = 0;
        r100.right = 0;
        r100.bottom = 0;
        Rect r102 = this.mTmpRect;
    L3:
        Drawable[] r103 = this.mLayers;
        if (r101 >= r103.length) goto L9;
        Drawable r104 = r103[r101];
        if (r104 == null) goto L8;
        r104.getPadding(r102);
        r100.left = Math.max(r100.left, r102.left);
        r100.top = Math.max(r100.top, r102.top);
        r100.right = Math.max(r100.right, r102.right);
        r100.bottom = Math.max(r100.bottom, r102.bottom);
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        return true;
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
        TransformCallback r101 = this.mTransformCallback;
        if (r101 == null) goto L5;
        r101.getTransform(r100);
        return;
    L5:
        r100.reset();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.setBounds(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        int r101 = 0;
        boolean r102 = false;
    L3:
        Drawable[] r103 = this.mLayers;
        if (r101 >= r103.length) goto L11;
        Drawable r104 = r103[r101];
        if (r104 == null) goto L10;
        if (r104.setLevel(r100) == false) goto L10;
        r102 = true;
    L10:
        r101 = r101 + 1;
        goto L3
    L11:
        return r102;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        int r101 = 0;
        boolean r102 = false;
    L3:
        Drawable[] r103 = this.mLayers;
        if (r101 >= r103.length) goto L11;
        Drawable r104 = r103[r101];
        if (r104 == null) goto L10;
        if (r104.setState(r100) == false) goto L10;
        r102 = true;
    L10:
        r101 = r101 + 1;
        goto L3
    L11:
        return r102;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mDrawableProperties.setAlpha(r100);
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.setAlpha(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mDrawableProperties.setColorFilter(r100);
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.setColorFilter(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        this.mDrawableProperties.setDither(r100);
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.setDither(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r100) {
        this.mDrawableProperties.setFilterBitmap(r100);
        int r101 = 0;
    L3:
        Drawable[] r102 = this.mLayers;
        if (r101 >= r102.length) goto L9;
        Drawable r103 = r102[r101];
        if (r103 == null) goto L8;
        r103.setFilterBitmap(r100);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback r100) {
        this.mTransformCallback = r100;
    }

    @Nullable
    public Drawable setDrawable(int r100, @Nullable Drawable r101) {
        boolean r102 = true;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r100 < this.mLayers.length) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102);
        Drawable r104 = this.mLayers[r100];
        if (r101 == r104) goto L17;
        if (r101 != null) goto L14;
    L16:
        DrawableUtils.setCallbacks(this.mLayers[r100], null, null);
        DrawableUtils.setCallbacks(r101, null, null);
        DrawableUtils.setDrawableProperties(r101, this.mDrawableProperties);
        DrawableUtils.copyProperties(r101, this);
        DrawableUtils.setCallbacks(r101, this, this);
        this.mIsStatefulCalculated = false;
        this.mLayers[r100] = r101;
        invalidateSelf();
        goto L17
    L14:
        if (this.mIsMutated == false) goto L16;
        r101.mutate();
    L17:
        return r104;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        int r102 = 0;
    L3:
        Drawable[] r103 = this.mLayers;
        if (r102 >= r103.length) goto L9;
        Drawable r104 = r103[r102];
        if (r104 == null) goto L8;
        r104.setHotspot(r100, r101);
    L8:
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        int r103 = 0;
    L3:
        Drawable[] r104 = this.mLayers;
        if (r103 >= r104.length) goto L9;
        Drawable r105 = r104[r103];
        if (r105 == null) goto L8;
        r105.setVisible(r100, r101);
    L8:
        r103 = r103 + 1;
        goto L3
    L9:
        return r102;
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
