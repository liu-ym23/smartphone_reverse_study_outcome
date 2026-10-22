package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes18.dex */
public class MaxSizeLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f240109a;

    public int getMaxHeight() {
        return this.f240109a.f240328c;
    }

    public int getMaxWidth() {
        return this.f240109a.f240327b;
    }

    public MaxSizeLinearLayout(Context r100) {
        super(r100);
        this.f240109a = new s(this, null);
    }

    public void setEnableMaxHeight(boolean r100) {
        s r101 = this.f240109a;
        if (r101.f240330e == r100) goto L6;
        r101.f240330e = r100;
        r101.f240326a.requestLayout();
        return;
    }

    public void setEnableMaxWidth(boolean r100) {
        s r101 = this.f240109a;
        if (r101.f240329d == r100) goto L6;
        r101.f240329d = r100;
        r101.f240326a.requestLayout();
        return;
    }

    public void setMaxHeight(int r100) {
        s r101 = this.f240109a;
        if (r101.f240328c == r100) goto L6;
        r101.f240328c = r100;
        r101.f240326a.requestLayout();
        return;
    }

    public void setMaxWidth(int r100) {
        s r101 = this.f240109a;
        if (r101.f240327b == r100) goto L6;
        r101.f240327b = r100;
        r101.f240326a.requestLayout();
        return;
    }

    public MaxSizeLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240109a = new s(this, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        s r102 = this.f240109a;
        int r103 = s.a(r100, r102.f240329d, r102.f240327b);
        s r104 = this.f240109a;
        super.onMeasure(r103, s.a(r101, r104.f240330e, r104.f240328c));
    }

    public MaxSizeLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240109a = new s(this, r101);
    }
}
