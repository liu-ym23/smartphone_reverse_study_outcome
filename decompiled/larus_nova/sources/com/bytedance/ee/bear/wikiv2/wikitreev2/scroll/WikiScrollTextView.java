package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes18.dex */
public class WikiScrollTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f241666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f241667b;

    public WikiScrollTextView(Context r100) {
        super(r100);
        this.f241666a = 0;
        this.f241667b = 0;
    }

    public WikiScrollTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f241666a = 0;
        this.f241667b = 0;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 0), r101);
        int r102 = getMeasuredWidth() + this.f241667b;
        int r103 = getMeasuredHeight();
        int r104 = a.f241670f;
        HorizontalScrollView r105 = a.C3461a.b(this);
        if (r105 == null) goto L6;
        setMeasuredDimension(Math.max((r105.getMeasuredWidth() + r105.getScrollX()) - this.f241666a, r102), r103);
        return;
    }
}
