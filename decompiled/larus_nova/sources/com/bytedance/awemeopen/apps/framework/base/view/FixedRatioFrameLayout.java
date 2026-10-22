package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class FixedRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f193158b;

    public int getMode() {
        return this.f193157a;
    }

    public float getWhRatio() {
        return this.f193158b;
    }

    public FixedRatioFrameLayout(Context r100) {
        this(r100, null);
    }

    public void setMode(int r100) {
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L9;
        throw new IllegalArgumentException("mode must be either FIXED_HEIGHT or FIXED_WIDTH");
    L9:
        if (this.f193157a == r100) goto L12;
        this.f193157a = r100;
        requestLayout();
        return;
    }

    public void setWhRatio(float r100) {
        if (r100 < 0.0f) goto L9;
        if (this.f193158b == r100) goto L10;
        this.f193158b = r100;
        requestLayout();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("whRatio must be positive.");
    }

    public FixedRatioFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = (View.MeasureSpec.getSize(r100) - getPaddingLeft()) - getPaddingRight();
        int r103 = (View.MeasureSpec.getSize(r101) - getPaddingBottom()) - getPaddingTop();
        if (this.f193157a != 0) goto L5;
        r100 = View.MeasureSpec.makeMeasureSpec((int) ((r103 * this.f193158b) + 0.5f), 1073741824);
    L6:
        super.onMeasure(r100, r101);
        return;
    L5:
        r101 = View.MeasureSpec.makeMeasureSpec((int) ((r102 / this.f193158b) + 0.5f), 1073741824);
        goto L6
    }

    public FixedRatioFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.frMode, R.attr.whRatio}, r102, 0);
        this.f193157a = r103.getInteger(0, 1);
        this.f193158b = r103.getFloat(1, 1.0f);
        r103.recycle();
    }
}
