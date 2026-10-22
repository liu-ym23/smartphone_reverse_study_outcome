package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public class WrapContentViewPager extends SSViewPager {
    public WrapContentViewPager(Context r100) {
        super(r100);
    }

    public WrapContentViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getLayoutParams().height != (-2)) goto L12;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= getChildCount()) goto L11;
        View r104 = getChildAt(r102);
        r104.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r105 = r104.getMeasuredHeight();
        if (r105 <= r103) goto L10;
        r103 = r105;
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L12:
        super.onMeasure(r100, r101);
    }
}
