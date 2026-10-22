package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes18.dex */
public class SwipeControlViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f240134a;

    public SwipeControlViewPager(Context r100) {
        super(r100);
        this.f240134a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f240134a == false) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public SwipeControlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240134a = false;
    }
}
