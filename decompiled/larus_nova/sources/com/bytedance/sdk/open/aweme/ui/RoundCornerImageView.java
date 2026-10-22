package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class RoundCornerImageView extends ImageView {
    private int defaultRadius;
    private float height;
    private int leftBottomRadius;
    private int leftTopRadius;
    private int radius;
    private int rightBottomRadius;
    private int rightTopRadius;
    private float width;

    public RoundCornerImageView(Context r100) {
        this(r100, null);
    }

    public RoundCornerImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundCornerImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.defaultRadius = 0;
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.left_bottom_radius, R.attr.left_top_radius, R.attr.radius, R.attr.right_bottom_radius, R.attr.right_top_radius});
        this.radius = r102.getDimensionPixelOffset(2, this.defaultRadius);
        this.leftTopRadius = r102.getDimensionPixelOffset(1, this.defaultRadius);
        this.rightTopRadius = r102.getDimensionPixelOffset(4, this.defaultRadius);
        this.rightBottomRadius = r102.getDimensionPixelOffset(3, this.defaultRadius);
        int r103 = r102.getDimensionPixelOffset(0, this.defaultRadius);
        this.leftBottomRadius = r103;
        int r104 = this.defaultRadius;
        if (r104 != this.leftTopRadius) goto L6;
        this.leftTopRadius = this.radius;
    L6:
        if (r104 != this.rightTopRadius) goto L9;
        this.rightTopRadius = this.radius;
    L9:
        if (r104 != this.rightBottomRadius) goto L11;
        this.rightBottomRadius = this.radius;
    L11:
        if (r104 != r103) goto L13;
        this.leftBottomRadius = this.radius;
    L13:
        r102.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        int r101 = Math.max(this.leftTopRadius, this.leftBottomRadius) + Math.max(this.rightTopRadius, this.rightBottomRadius);
        int r102 = Math.max(this.leftTopRadius, this.rightTopRadius) + Math.max(this.leftBottomRadius, this.rightBottomRadius);
        if (this.width >= r101) goto L5;
    L7:
        super.onDraw(r100);
        return;
    L5:
        if (this.height <= r102) goto L7;
        Path r103 = new Path();
        r103.moveTo(this.leftTopRadius, 0.0f);
        r103.lineTo(this.width - this.rightTopRadius, 0.0f);
        float r104 = this.width;
        r103.quadTo(r104, 0.0f, r104, this.rightTopRadius);
        r103.lineTo(this.width, this.height - this.rightBottomRadius);
        float r105 = this.width;
        float r106 = this.height;
        r103.quadTo(r105, r106, r105 - this.rightBottomRadius, r106);
        r103.lineTo(this.leftBottomRadius, this.height);
        float r107 = this.height;
        r103.quadTo(0.0f, r107, 0.0f, r107 - this.leftBottomRadius);
        r103.lineTo(0.0f, this.leftTopRadius);
        r103.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
        r100.clipPath(r103);
        goto L7
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.width = getWidth();
        this.height = getHeight();
    }

    public void setDefaultRadius(int r100) {
        this.defaultRadius = r100;
    }

    public void setLeftBottomRadius(int r100) {
        this.leftBottomRadius = r100;
    }

    public void setLeftTopRadius(int r100) {
        this.leftTopRadius = r100;
    }

    public void setRightBottomRadius(int r100) {
        this.rightBottomRadius = r100;
    }

    public void setRightTopRadius(int r100) {
        this.rightTopRadius = r100;
    }
}
