package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AutoWrapRtlViewPager extends RtlViewPager {
    public AutoWrapRtlViewPager(Context r1) {
        super(r1);
    }

    public AutoWrapRtlViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        View r2 = getChildAt(r0);
        r2.measure(r5, View.MeasureSpec.makeMeasureSpec(r2.getLayoutParams().height, r6));
        int r3 = r2.getMeasuredHeight();
        if (r3 <= r1) goto L8;
        r1 = r3;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(r1, 1073741824));
    }
}
