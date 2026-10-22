package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSelectorScrollTextView extends AppCompatTextView {
    public DocSelectorScrollTextView(Context r1) {
        super(r1);
    }

    public DocSelectorScrollTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r3), 0), r4);
        int r5 = getMeasuredWidth();
        int r6 = getMeasuredHeight();
        HorizontalScrollView r0 = DocsItemLinearView.a(this);
        if (r0 == null) goto L6;
        setMeasuredDimension(Math.max(r0.getMeasuredWidth() + r0.getScrollX(), r5), r6);
        return;
    }
}
