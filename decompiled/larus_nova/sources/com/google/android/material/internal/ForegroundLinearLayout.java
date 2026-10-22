package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes23.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.foreground;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        this.foreground.setState(getDrawableState());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.foreground;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.foreground;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    public ForegroundLinearLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        Drawable r101 = this.foreground;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.foregroundBoundsChanged == false) goto L11;
        this.foregroundBoundsChanged = false;
        Rect r102 = this.selfBounds;
        Rect r103 = this.overlayBounds;
        int r104 = getRight() - getLeft();
        int r105 = getBottom() - getTop();
        if (this.mForegroundInPadding == false) goto L9;
        r102.set(0, 0, r104, r105);
    L10:
        Gravity.apply(this.foregroundGravity, r101.getIntrinsicWidth(), r101.getIntrinsicHeight(), r102, r103);
        r101.setBounds(r103);
        goto L11
    L9:
        r102.set(getPaddingLeft(), getPaddingTop(), r104 - getPaddingRight(), r105 - getPaddingBottom());
    L11:
        r101.draw(r100);
    }

    @Override // android.view.View
    public void setForeground(Drawable r100) {
        Drawable r101 = this.foreground;
        if (r101 == r100) goto L17;
        if (r101 == null) goto L6;
        r101.setCallback(null);
        unscheduleDrawable(this.foreground);
    L6:
        this.foreground = r100;
        if (r100 == null) goto L14;
        setWillNotDraw(false);
        r100.setCallback(this);
        if (r100.isStateful() == false) goto L12;
        r100.setState(getDrawableState());
    L12:
        if (this.foregroundGravity != 119) goto L15;
        r100.getPadding(new Rect());
    L15:
        requestLayout();
        invalidate();
        return;
    L14:
        setWillNotDraw(true);
        goto L15
    }

    @Override // android.view.View
    public void setForegroundGravity(int r100) {
        if (this.foregroundGravity != r100) goto L5;
        return;
    L5:
        if ((8388615 & r100) != 0) goto L8;
        r100 = r100 | GravityCompat.START;
    L8:
        if ((r100 & 112) != 0) goto L10;
        r100 = r100 | 48;
    L10:
        this.foregroundGravity = r100;
        if (r100 == 119) goto L13;
    L15:
        requestLayout();
        return;
    L13:
        if (this.foreground == null) goto L15;
        Rect r101 = new Rect();
        this.foreground.getPadding(r101);
        goto L15
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.foreground) goto L8;
        return false;
    }

    public ForegroundLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.foreground;
        if (r102 == null) goto L6;
        r102.setHotspot(r100, r101);
        return;
    }

    public ForegroundLinearLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.selfBounds = new Rect();
        this.overlayBounds = new Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        TypedArray r113 = ThemeEnforcement.obtainStyledAttributes(r110, r111, new int[]{R.attr.foreground, R.attr.foregroundGravity, com.larus.nova.R.attr.foregroundInsidePadding}, r112, 0, new int[0]);
        this.foregroundGravity = r113.getInt(1, this.foregroundGravity);
        Drawable r114 = r113.getDrawable(0);
        if (r114 == null) goto L5;
        setForeground(r114);
    L5:
        this.mForegroundInPadding = r113.getBoolean(2, true);
        r113.recycle();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.foregroundBoundsChanged = true;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.foregroundBoundsChanged = r100 | this.foregroundBoundsChanged;
    }
}
