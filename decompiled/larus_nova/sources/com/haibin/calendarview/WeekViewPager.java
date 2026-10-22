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
public final class WeekViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f276108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f276109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f276110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CalendarLayout f276111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f276112e;

    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeekViewPager f276113a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f276113a.f276109b;
        }

        public a(WeekViewPager r100) {
            this.f276113a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            if (this.f276113a.f276108a == false) goto L6;
            return -2;
        L6:
            return super.getItemPosition(r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            l r102 = this.f276113a.f276110c;
            Calendar r103 = f.b(r102.T, r102.V, r102.X, r101 + 1, r102.f276156a);
            c r104 = (c) this.f276113a.f276110c.N.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f276113a.getContext()});     // Catch: Exception -> L6
            WeekViewPager r105 = this.f276113a;
            r104.mParentLayout = r105.f276111d;
            r104.setup(r105.f276110c);
            r104.setup(r103);
            r104.setTag(Integer.valueOf(r101));
            r104.setSelectedCalendar(this.f276113a.f276110c.f276183n0);
            r100.addView(r104);
            return r104;
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
            c r103 = (c) r102;
            if (r103 != null) goto L5;
            return;
        L5:
            r100.removeView(r103);
        }
    }

    public List<Calendar> getCurrentWeekCalendars() {
        l r100 = this.f276110c;
        Calendar r101 = r100.f276185o0;
        long r102 = r101.getTimeInMillis();
        java.util.Calendar r103 = java.util.Calendar.getInstance();
        r103.set(r101.getYear(), r101.getMonth() - 1, r101.getDay());
        int r104 = r103.get(7);
        int r105 = r100.f276156a;
        if (r105 != 1) goto L5;
        r104 = r104 - 1;
    L11:
        java.util.Calendar r106 = java.util.Calendar.getInstance();
        r106.setTimeInMillis(r102 - (((long) r104) * 86400000));
        Calendar r107 = new Calendar();
        r107.setYear(r106.get(1));
        r107.setMonth(r106.get(2) + 1);
        r107.setDay(r106.get(5));
        List<Calendar> r108 = f.n(r107, r100, r100.f276156a);
        this.f276110c.b(r108);
        return r108;
    L5:
        if (r105 != 2) goto L9;
        if (r104 != 1) goto L8;
        r104 = 6;
        goto L11
    L8:
        r104 = r104 - r105;
        goto L11
    L9:
        if (r104 != 7) goto L11;
        r104 = 0;
        goto L11
    }

    public WeekViewPager(Context r100) {
        this(r100, null);
    }

    public final void h(Calendar r100) {
        l r101 = this.f276110c;
        int r102 = r101.T;
        int r103 = r101.V;
        int r104 = r101.X;
        int r105 = r101.f276156a;
        java.util.Calendar r106 = java.util.Calendar.getInstance();
        r106.set(r102, r103 - 1, r104);
        long r107 = r106.getTimeInMillis();
        int r108 = f.l(r102, r103, r104, r105);
        int r109 = f.l(r100.getYear(), r100.getMonth(), r100.getDay(), r105);
        int r110 = r100.getYear();
        int r111 = r100.getMonth() - 1;
        boolean r112 = true;
        if (r109 != 0) goto L5;
        int r113 = r100.getDay() + 1;
    L6:
        r106.set(r110, r111, r113);
        int r114 = (((r108 + ((int) ((r106.getTimeInMillis() - r107) / 86400000))) / 7) + 1) - 1;
        if (getCurrentItem() != r114) goto L10;
        r112 = false;
    L10:
        this.f276112e = r112;
        setCurrentItem(r114, false);
        c r115 = (c) findViewWithTag(Integer.valueOf(r114));
        if (r115 == null) goto L14;
        r115.setSelectedCalendar(r100);
        r115.invalidate();
        return;
    L14:
        return;
    L5:
        r113 = r100.getDay();
        goto L6
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f276110c.f276169g0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f276110c.f276169g0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    public void setup(l r100) {
        this.f276110c = r100;
        this.f276109b = f.h(r100.T, r100.V, r100.X, r100.U, r100.W, r100.Y, r100.f276156a);
        setAdapter(new a(this));
        addOnPageChangeListener(new y(this));
    }

    public WeekViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f276112e = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f276110c.f276159b0, 1073741824));
    }
}
