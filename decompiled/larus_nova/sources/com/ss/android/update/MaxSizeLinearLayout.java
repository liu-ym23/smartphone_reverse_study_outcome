package com.ss.android.update;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class MaxSizeLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f455211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f455212b;

    public MaxSizeLinearLayout(Context r100) {
        super(r100);
        this.f455211a = 0;
        this.f455212b = 0;
    }

    public MaxSizeLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f455211a = 0;
        this.f455212b = 0;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.maxWidth}, 0, 0);
        this.f455211a = r102.getDimensionPixelSize(1, 0);
        this.f455212b = r102.getDimensionPixelSize(0, 0);
        r102.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = this.f455211a;
        if (r104 <= 0) goto L6;
        if (r104 >= r102) goto L6;
        int r105 = View.MeasureSpec.getMode(r100);
        r100 = View.MeasureSpec.makeMeasureSpec(this.f455211a, r105);
    L6:
        int r106 = this.f455212b;
        if (r106 <= 0) goto L10;
        if (r106 >= r103) goto L10;
        int r107 = View.MeasureSpec.getMode(r101);
        r101 = View.MeasureSpec.makeMeasureSpec(this.f455212b, r107);
    L10:
        super.onMeasure(r100, r101);
    }
}
