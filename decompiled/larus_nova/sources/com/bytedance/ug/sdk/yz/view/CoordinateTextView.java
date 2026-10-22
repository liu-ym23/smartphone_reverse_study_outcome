package com.bytedance.ug.sdk.yz.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.ScrollView;
import android.widget.TextView;
import ap7.a;

/* JADX INFO: loaded from: classes22.dex */
public class CoordinateTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f272368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f272369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f272370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewParent f272371d;

    public CoordinateTextView(Context r100) {
        this(r100, null);
    }

    public static ViewParent a(ViewParent r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ScrollView) == false) goto L9;
        return r100;
    L9:
        return a(r100.getParent());
    }

    public CoordinateTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getLayout().getHeight();
        int r103 = getPaddingTop();
        int r104 = getPaddingBottom();
        int r105 = (r102 + r103) + r104;
        this.f272368a = r105 - getMeasuredHeight();
    }

    public CoordinateTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f272369b = 0;
        setOnTouchListener(new a(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        this.f272369b = r101;
        if (r101 == this.f272368a) goto L6;
        if (r101 == 0) goto L6;
        return;
    L6:
        if (this.f272371d != null) goto L8;
        this.f272371d = a(getParent());
    L8:
        ViewParent r104 = this.f272371d;
        if (r104 == null) goto L13;
        r104.requestDisallowInterceptTouchEvent(false);
        return;
    }
}
