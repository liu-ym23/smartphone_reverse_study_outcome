package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FixedRatioFrameLayout extends FrameLayout {
    public int a;
    public float b;

    public int getMode() {
        return this.a;
    }

    public float getWhRatio() {
        return this.b;
    }

    public FixedRatioFrameLayout(Context r2) {
        this(r2, null);
    }

    public void setMode(int r2) {
        if (r2 == 0) goto L9;
        if (r2 == 1) goto L9;
        throw new IllegalArgumentException("mode must be either FIXED_HEIGHT or FIXED_WIDTH");
    L9:
        if (this.a == r2) goto L12;
        this.a = r2;
        requestLayout();
        return;
    }

    public void setWhRatio(float r2) {
        if (r2 < 0.0f) goto L9;
        if (this.b == r2) goto L10;
        this.b = r2;
        requestLayout();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("whRatio must be positive.");
    }

    public FixedRatioFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = (View.MeasureSpec.getSize(r6) - getPaddingLeft()) - getPaddingRight();
        int r1 = (View.MeasureSpec.getSize(r7) - getPaddingBottom()) - getPaddingTop();
        if (this.a != 0) goto L5;
        r6 = View.MeasureSpec.makeMeasureSpec((int) ((r1 * this.b) + 0.5f), 1073741824);
    L6:
        super.onMeasure(r6, r7);
        return;
    L5:
        r7 = View.MeasureSpec.makeMeasureSpec((int) ((r0 / this.b) + 0.5f), 1073741824);
        goto L6
    }

    public FixedRatioFrameLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130970152, 2130975085}, r5, 0);
        this.a = r6.getInteger(0, 1);
        this.b = r6.getFloat(1, 1.0f);
        r6.recycle();
    }
}
