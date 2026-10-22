package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public class CommonIconFrontTextView extends AppCompatTextView {
    private int drawableLeftHeight;
    private int drawableLeftWidth;
    private boolean isAlignCenter;

    public CommonIconFrontTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public CommonIconFrontTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CommonIconFrontTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.isAlignCenter = true;
        initView(r100, r101, r102);
    }

    private void initView(Context r100, AttributeSet r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.drawableLeftHeight, R.attr.drawableLeftWidth, R.attr.isAlignCenter});
        this.drawableLeftWidth = r103.getDimensionPixelSize(1, 0);
        this.drawableLeftHeight = r103.getDimensionPixelSize(0, 0);
        this.isAlignCenter = r103.getBoolean(2, true);
        r103.recycle();
    }

    private void setDrawable(Drawable r100, int r101, int r102) {
        if (r101 != 0) goto L4;
        r101 = r100.getIntrinsicWidth();
    L4:
        if (r102 != 0) goto L6;
        r102 = r100.getIntrinsicHeight();
    L6:
        int r103 = (int) ((((((getBottom() - getTop()) - getCompoundPaddingBottom()) - getCompoundPaddingTop()) * (1.0f - (1.0f / Math.min(getLineCount(), getMaxLines())))) * (-1.0f)) / 2.0f);
        if (this.isAlignCenter == false) goto L9;
        r103 = 0;
    L9:
        r100.setBounds(0, r103, r101, r102 + r103);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 == null) goto L4;
        setDrawable(r100, this.drawableLeftWidth, this.drawableLeftHeight);
    L4:
        super.setCompoundDrawables(r100, r101, r102, r103);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Drawable[] r105 = getCompoundDrawables();
        setCompoundDrawables(r105[0], r105[1], r105[2], r105[3]);
    }
}
