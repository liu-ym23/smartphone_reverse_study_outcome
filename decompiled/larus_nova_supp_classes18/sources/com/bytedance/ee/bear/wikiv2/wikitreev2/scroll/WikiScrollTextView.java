package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiScrollTextView extends AppCompatTextView {
    public int a;
    public int b;

    public WikiScrollTextView(Context r1) {
        super(r1);
        this.a = 0;
        this.b = 0;
    }

    public WikiScrollTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 0;
        this.b = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r3), 0), r4);
        int r5 = getMeasuredWidth() + this.b;
        int r6 = getMeasuredHeight();
        int r0 = a.f;
        HorizontalScrollView r1 = a.C0214a.b(this);
        if (r1 == null) goto L6;
        setMeasuredDimension(Math.max((r1.getMeasuredWidth() + r1.getScrollX()) - this.a, r5), r6);
        return;
    }
}
