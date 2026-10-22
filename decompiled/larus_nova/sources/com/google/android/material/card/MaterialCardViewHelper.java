package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes23.dex */
class MaterialCardViewHelper {
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final MaterialCardView materialCardView;
    private int strokeColor;
    private int strokeWidth;

    private void adjustContentPadding() {
        int r100 = this.materialCardView.getContentPaddingLeft() + this.strokeWidth;
        int r101 = this.materialCardView.getContentPaddingTop() + this.strokeWidth;
        int r102 = this.materialCardView.getContentPaddingRight() + this.strokeWidth;
        int r103 = this.materialCardView.getContentPaddingBottom() + this.strokeWidth;
        this.materialCardView.setContentPadding(r100, r101, r102, r103);
    }

    private Drawable createForegroundDrawable() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setCornerRadius(this.materialCardView.getRadius());
        int r101 = this.strokeColor;
        if (r101 == (-1)) goto L5;
        r100.setStroke(this.strokeWidth, r101);
    L5:
        return r100;
    }

    public void updateForeground() {
        this.materialCardView.setForeground(createForegroundDrawable());
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public MaterialCardViewHelper(MaterialCardView r100) {
        this.materialCardView = r100;
    }

    public void loadFromAttributes(TypedArray r100) {
        this.strokeColor = r100.getColor(0, -1);
        this.strokeWidth = r100.getDimensionPixelSize(1, 0);
        updateForeground();
        adjustContentPadding();
    }

    public void setStrokeColor(int r100) {
        this.strokeColor = r100;
        updateForeground();
    }

    public void setStrokeWidth(int r100) {
        this.strokeWidth = r100;
        updateForeground();
        adjustContentPadding();
    }
}
