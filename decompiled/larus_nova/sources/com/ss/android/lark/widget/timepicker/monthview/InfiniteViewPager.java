package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vec.c;
import vec.n;
import xec.d;

/* JADX INFO: loaded from: classes38.dex */
public class InfiniteViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f449009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f449010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<n> f449011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f449012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f449013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f449014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449015g;

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InfiniteViewPager f449016a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public final boolean a() {
            InfiniteViewPager r100 = this.f449016a;
            if (r100.f449011c != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f449010b == false) goto L7;
            return true;
        }

        public a(InfiniteViewPager r100) {
            this.f449016a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            InfiniteViewPager r101 = this.f449016a;
            r101.f449015g = r100;
            if (r100 == 0) goto L5;
            return;
        L5:
            int r102 = r101.f449009a;
            if (r102 == 0) goto L10;
            if (r102 == 2) goto L9;
            int r103 = -999;
        L12:
            if (a() == false) goto L17;
            Iterator r104 = ((ArrayList) this.f449016a.f449011c).iterator();
        L15:
            if (r104.hasNext() == false) goto L17;
            ((n) r104.next()).c();
        L17:
            InfinitePagerAdapter r105 = (InfinitePagerAdapter) this.f449016a.getAdapter();
            if (r103 == 0) goto L22;
            if (r103 != 1) goto L24;
            r105.f449006b[2].b();
            c[] r106 = r105.f449006b;
            View r107 = r106[2].f554545b;
            r106[1].b();
            c[] r108 = r105.f449006b;
            r108[2].a(r108[1].f554545b);
            r105.f449006b[0].b();
            c[] r109 = r105.f449006b;
            r109[1].a(r109[0].f554545b);
            r105.f449006b[0].a(r107);
        L24:
            if (a() == false) goto L29;
            Iterator r110 = ((ArrayList) this.f449016a.f449011c).iterator();
        L27:
            if (r110.hasNext() == false) goto L29;
            ((n) r110.next()).b(r103);
        L29:
            this.f449016a.setCurrentItem(1, false);
            return;
        L22:
            r105.f449006b[0].b();
            c[] r111 = r105.f449006b;
            View r112 = r111[0].f554545b;
            r111[1].b();
            c[] r113 = r105.f449006b;
            r113[0].a(r113[1].f554545b);
            r105.f449006b[2].b();
            c[] r114 = r105.f449006b;
            r114[1].a(r114[2].f554545b);
            r105.f449006b[2].a(r112);
            goto L24
        L9:
            r103 = 0;
            goto L12
        L10:
            r103 = 1;
            goto L12
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            InfiniteViewPager r101 = this.f449016a;
            r101.f449009a = r100;
            InfinitePagerAdapter r102 = (InfinitePagerAdapter) r101.getAdapter();
            int r103 = this.f449016a.f449009a;
            if (r103 != 0) goto L11;
            if (a() == false) goto L39;
            Iterator r104 = ((ArrayList) this.f449016a.f449011c).iterator();
        L8:
            if (r104.hasNext() == false) goto L41;
            n r105 = (n) r104.next();
            r102.g(1);
            r102.g(0);
            r105.e();
            goto L8
        L41:
            return;
        L39:
            return;
        L11:
            if (r103 != 2) goto L19;
            if (a() == false) goto L40;
            Iterator r106 = ((ArrayList) this.f449016a.f449011c).iterator();
        L16:
            if (r106.hasNext() == false) goto L42;
            n r107 = (n) r106.next();
            r102.g(1);
            r102.g(2);
            r107.d();
            goto L16
        L42:
            return;
        L40:
            return;
        L19:
            if (a() == false) goto L24;
            Iterator r108 = ((ArrayList) this.f449016a.f449011c).iterator();
        L22:
            if (r108.hasNext() == false) goto L24;
            ((n) r108.next()).a();
        L24:
            InfiniteViewPager r109 = this.f449016a;
            if (r109.f449013e == false) goto L34;
            d r110 = r109.f449014f;
            if (r110 == null) goto L34;
            MonthViewPager.a r111 = (MonthViewPager.a) r110;
            MonthViewPager.i(r111.f449043b, 0);
            MonthViewPager.i(r111.f449043b, 1);
            MonthViewPager.i(r111.f449043b, 2);
            int r112 = r111.f449042a;
            if (r112 >= 0) goto L31;
            r111.f449043b.f449041h.b();
        L33:
            this.f449016a.f449013e = false;
            goto L34
        L31:
            if (r112 <= 0) goto L33;
            r111.f449043b.f449041h.a();
        L34:
            this.f449016a.f449010b = true;
        }
    }

    public int getScrollState() {
        return this.f449015g;
    }

    public InfiniteViewPager(Context r100) {
        super(r100);
        this.f449010b = true;
        this.f449013e = false;
        h(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f449012d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f449012d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r100) == false) goto L7;
        return true;
    }

    public final void h(Context r100) {
        addOnPageChangeListener(new a(this));
        this.f449012d = true;
        yec.b.a(this, "mLeftEdge", new yec.b.a(getContext()));
        yec.b.a(this, "mRightEdge", new yec.b.a(getContext()));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f449012d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449012d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        super.setAdapter(r100);
        setCurrentItem(1, false);
    }

    public void setOnSmoothScrollFinishListener(d r100) {
        this.f449014f = r100;
    }

    public void setPageEnabled(boolean r100) {
        this.f449012d = r100;
    }

    public InfiniteViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449010b = true;
        this.f449013e = false;
        h(r100);
    }
}
