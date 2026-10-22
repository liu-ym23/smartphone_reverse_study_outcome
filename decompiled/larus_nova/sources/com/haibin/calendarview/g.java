package com.haibin.calendarview;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes23.dex */
public final class g implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarView f276150a;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    public g(CalendarView r100) {
        this.f276150a = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        if (this.f276150a.f276092c.getVisibility() != 0) goto L5;
        return;
    L5:
        this.f276150a.f276090a.getClass();
    }
}
