package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public class AutoWrapRtlViewPager extends RtlViewPager {
    public AutoWrapRtlViewPager(Context r100) {
        super(r100);
    }

    public AutoWrapRtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= getChildCount()) goto L9;
        View r104 = getChildAt(r102);
        r104.measure(r100, View.MeasureSpec.makeMeasureSpec(r104.getLayoutParams().height, r101));
        int r105 = r104.getMeasuredHeight();
        if (r105 <= r103) goto L8;
        r103 = r105;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
    }
}
