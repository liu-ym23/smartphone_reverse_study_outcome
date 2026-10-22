package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class MonthViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f276097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f276098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f276099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f276100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f276101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f276102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarLayout f276103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeekViewPager f276104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f276105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f276106j;

    public final class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthViewPager f276107a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f276107a.f276098b;
        }

        public a(MonthViewPager r100) {
            this.f276107a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            if (this.f276107a.f276097a == false) goto L6;
            return -2;
        L6:
            return super.getItemPosition(r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            l r102 = this.f276107a.f276099c;
            int r103 = r102.V;
            int r104 = (((r101 + r103) - 1) / 12) + r102.T;
            int r105 = (((r103 + r101) - 1) % 12) + 1;
            com.haibin.calendarview.a r106 = (com.haibin.calendarview.a) r102.L.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f276107a.getContext()});     // Catch: Exception -> L6
            MonthViewPager r107 = this.f276107a;
            r106.mMonthViewPager = r107;
            r106.mParentLayout = r107.f276103g;
            r106.setup(r107.f276099c);
            r106.setTag(Integer.valueOf(r101));
            r106.initMonthWithDate(r104, r105);
            r106.setSelectedCalendar(this.f276107a.f276099c.f276183n0);
            r100.addView(r106);
            return r106;
        L6:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            return r100.equals(r101);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            BaseView r103 = (BaseView) r102;
            if (r103 != null) goto L5;
            return;
        L5:
            r103.onDestroy();
            r100.removeView(r103);
        }
    }

    public final void i() {
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L6;
        com.haibin.calendarview.a r101 = (com.haibin.calendarview.a) getChildAt(r100);
        r101.setSelectedCalendar(this.f276099c.f276183n0);
        r101.invalidate();
        r100 = r100 + 1;
        goto L4
    }

    public List<Calendar> getCurrentMonthCalendars() {
        com.haibin.calendarview.a r100 = (com.haibin.calendarview.a) findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mItems;
    }

    public MonthViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f276099c.f276167f0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f276099c.f276167f0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        setCurrentItem(r100, true);
    }

    public void setup(l r100) {
        this.f276099c = r100;
        h(r100.f276165e0.getYear(), this.f276099c.f276165e0.getMonth());
        ViewGroup.LayoutParams r101 = getLayoutParams();
        r101.height = this.f276102f;
        setLayoutParams(r101);
        l r102 = this.f276099c;
        this.f276098b = ((((r102.U - r102.T) * 12) - r102.V) + 1) + r102.W;
        setAdapter(new a(this));
        addOnPageChangeListener(new t(this));
    }

    public MonthViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f276106j = false;
    }

    public final void h(int r100, int r101) {
        l r102 = this.f276099c;
        if (r102.f276158b != 0) goto L7;
        this.f276102f = r102.f276159b0 * 6;
        return;
    L7:
        if (this.f276103g != null) goto L9;
    L12:
        l r103 = this.f276099c;
        this.f276102f = f.e(r100, r101, r103.f276159b0, r103.f276156a);
        if (r101 != 1) goto L15;
        l r104 = this.f276099c;
        this.f276101e = f.e(r100 - 1, 12, r104.f276159b0, r104.f276156a);
        l r105 = this.f276099c;
        this.f276100d = f.e(r100, 2, r105.f276159b0, r105.f276156a);
        return;
    L15:
        l r106 = this.f276099c;
        this.f276101e = f.e(r100, r101 - 1, r106.f276159b0, r106.f276156a);
        if (r101 != 12) goto L18;
        l r107 = this.f276099c;
        this.f276100d = f.e(r100 + 1, 1, r107.f276159b0, r107.f276156a);
        return;
    L18:
        l r108 = this.f276099c;
        this.f276100d = f.e(r100, r101 + 1, r108.f276159b0, r108.f276156a);
        return;
    L9:
        if (getVisibility() == 0) goto L11;
        ViewGroup.LayoutParams r109 = getLayoutParams();
        l r110 = this.f276099c;
        r109.height = f.e(r100, r101, r110.f276159b0, r110.f276156a);
        setLayoutParams(r109);
    L11:
        this.f276103g.f();
        goto L12
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        if (Math.abs(getCurrentItem() - r100) <= 1) goto L5;
        super.setCurrentItem(r100, false);
        return;
    L5:
        super.setCurrentItem(r100, r101);
    }
}
