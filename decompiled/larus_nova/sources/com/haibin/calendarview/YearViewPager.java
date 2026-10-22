package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class YearViewPager extends ViewPager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f276137d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f276139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public YearRecyclerView.b f276140c;

    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ YearViewPager f276141a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f276141a.f276138a;
        }

        public a(YearViewPager r100) {
            this.f276141a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            YearViewPager r101 = this.f276141a;
            int r102 = YearViewPager.f276137d;
            r101.getClass();
            return super.getItemPosition(r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            YearRecyclerView r102 = new YearRecyclerView(this.f276141a.getContext());
            r100.addView(r102);
            r102.setup(this.f276141a.f276139b);
            r102.setOnMonthSelectedListener(this.f276141a.f276140c);
            int r103 = r101 + this.f276141a.f276139b.T;
            java.util.Calendar r104 = java.util.Calendar.getInstance();
            int r105 = 1;
        L4:
            if (r105 > 12) goto L6;
            r104.set(r103, r105 - 1, 1);
            int r106 = f.c(r103, r105);
            Month r107 = new Month();
            r107.setDiff(f.f(r103, r105, r102.f276114a.f276156a));
            r107.setCount(r106);
            r107.setMonth(r105);
            r107.setYear(r103);
            z r108 = r102.f276115b;
            ((ArrayList) r108.f276142a).add(r107);
            r108.notifyItemChanged(((ArrayList) r108.f276142a).size());
            r105 = r105 + 1;
            goto L4
        L6:
            return r102;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            r100.removeView((View) r102);
        }
    }

    public final void update() {
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L6;
        ((YearRecyclerView) getChildAt(r100)).getAdapter().notifyDataSetChanged();
        r100 = r100 + 1;
        goto L4
    }

    static {
    }

    public YearViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f276139b.f276171h0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f276139b.f276171h0 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        setCurrentItem(r100, false);
    }

    public final void setOnMonthSelectedListener(YearRecyclerView.b r100) {
        this.f276140c = r100;
    }

    public void setup(l r100) {
        this.f276139b = r100;
        this.f276138a = (r100.U - r100.T) + 1;
        setAdapter(new a(this));
        setCurrentItem(this.f276139b.f276165e0.getYear() - this.f276139b.T);
    }

    public YearViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = ((WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getHeight();
        int[] r103 = new int[2];
        getLocationInWindow(r103);
        getLocationOnScreen(r103);
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r102 - r103[1], 1073741824));
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
