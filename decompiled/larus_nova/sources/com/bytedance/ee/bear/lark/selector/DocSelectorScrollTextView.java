package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes16.dex */
public class DocSelectorScrollTextView extends AppCompatTextView {
    public DocSelectorScrollTextView(Context r100) {
        super(r100);
    }

    public DocSelectorScrollTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 0), r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        HorizontalScrollView r104 = DocsItemLinearView.a(this);
        if (r104 == null) goto L6;
        setMeasuredDimension(Math.max(r104.getMeasuredWidth() + r104.getScrollX(), r102), r103);
        return;
    }
}
