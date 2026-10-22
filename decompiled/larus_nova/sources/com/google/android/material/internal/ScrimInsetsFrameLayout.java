package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public void onInsetsChanged(WindowInsetsCompat r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r100 = this.insetForeground;
        if (r100 == null) goto L6;
        r100.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r100 = this.insetForeground;
        if (r100 == null) goto L6;
        r100.setCallback(null);
        return;
    }

    public ScrimInsetsFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        if (this.insets != null) goto L5;
        return;
    L5:
        if (this.insetForeground == null) goto L9;
        int r103 = r100.save();
        r100.translate(getScrollX(), getScrollY());
        this.tempRect.set(0, 0, r101, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r100);
        this.tempRect.set(0, r102 - this.insets.bottom, r101, r102);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r100);
        Rect r104 = this.tempRect;
        Rect r105 = this.insets;
        r104.set(0, r105.top, r105.left, r102 - r105.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r100);
        Rect r106 = this.tempRect;
        Rect r107 = this.insets;
        r106.set(r101 - r107.right, r107.top, r101, r102 - r107.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r100);
        r100.restoreToCount(r103);
        return;
    }

    public ScrimInsetsFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ScrimInsetsFrameLayout(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.tempRect = new Rect();
        TypedArray r101 = ThemeEnforcement.obtainStyledAttributes(r100, r110, new int[]{R.attr.insetForeground}, r111, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = r101.getDrawable(0);
        r101.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }
}
