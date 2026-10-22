package com.bytedance.ee.bear.list.homepage.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes18.dex */
public class HomeViewPager extends ViewPager {
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public HomeViewPager(Context r100) {
        super(r100);
    }

    public HomeViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
