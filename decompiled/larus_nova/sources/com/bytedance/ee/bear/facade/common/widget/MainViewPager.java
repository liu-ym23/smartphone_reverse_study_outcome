package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes16.dex */
public class MainViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f226502a;

    public MainViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f226502a == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f226502a == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100);
    }

    public void setCanScroll(boolean r100) {
        this.f226502a = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        super.setCurrentItem(r100, false);
    }

    public MainViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f226502a = false;
    }
}
