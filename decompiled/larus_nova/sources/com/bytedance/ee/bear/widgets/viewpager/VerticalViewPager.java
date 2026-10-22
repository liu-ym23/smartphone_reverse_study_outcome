package com.bytedance.ee.bear.widgets.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import op5.e;

/* JADX INFO: loaded from: classes18.dex */
public class VerticalViewPager extends ViewPager2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f240423b;

    public int getBaseScrollX() {
        return this.f240422a;
    }

    public VerticalViewPager(Context r100) {
        super(r100);
        registerOnPageChangeCallback(new e(this));
        setOverScrollMode(0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    public void setBaseScrollX(int r100) {
        this.f240422a = r100;
    }

    public VerticalViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        registerOnPageChangeCallback(new e(this));
        setOverScrollMode(0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        tt5.a.b("VerticalViewPager", "onScrollChanged " + r100 + "," + r101 + "," + r102 + "," + r103);
        if (this.f240423b != 0) goto L6;
        this.f240422a = getScrollX();
        return;
    }
}
