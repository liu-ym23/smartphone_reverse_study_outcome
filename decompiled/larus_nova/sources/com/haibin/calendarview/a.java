package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a extends BaseView {
    protected int mHeight;
    protected int mLineCount;
    protected int mMonth;
    MonthViewPager mMonthViewPager;
    protected int mNextDiff;
    protected int mYear;

    @Override // com.haibin.calendarview.BaseView
    public void onDestroy() {
    }

    public void onLoopStart(int r100, int r101) {
    }

    @Override // com.haibin.calendarview.BaseView
    public void onPreviewHook() {
    }

    private void initCalendar() {
        int r100 = this.mYear;
        int r101 = this.mMonth;
        int r102 = this.mDelegate.f276156a;
        this.mNextDiff = f.d(r100, r101, f.c(r100, r101), r102);
        int r103 = f.f(this.mYear, this.mMonth, this.mDelegate.f276156a);
        int r104 = f.c(this.mYear, this.mMonth);
        int r105 = this.mYear;
        int r106 = this.mMonth;
        l r107 = this.mDelegate;
        List<Calendar> r108 = f.m(r105, r106, r107.f276165e0, r107.f276156a);
        this.mItems = r108;
        ArrayList r109 = (ArrayList) r108;
        if (r109.contains(this.mDelegate.f276165e0) == false) goto L5;
        this.mCurrentItem = this.mItems.indexOf(this.mDelegate.f276165e0);
    L7:
        if (this.mCurrentItem <= 0) goto L10;
        this.mDelegate.getClass();
    L10:
        if (this.mDelegate.f276158b != 0) goto L12;
        this.mLineCount = 6;
    L13:
        addSchemesFromMap();
        invalidate();
        return;
    L12:
        this.mLineCount = ((r103 + r104) + this.mNextDiff) / 7;
        goto L13
    L5:
        this.mCurrentItem = this.mItems.indexOf(this.mDelegate.f276183n0);
        goto L7
    }

    public Calendar getIndex() {
        int r100 = this.mItemWidth;
        if (r100 == 0) goto L16;
        int r101 = this.mItemHeight;
        if (r101 == 0) goto L16;
        int r102 = ((int) (this.mX - this.mDelegate.f276184o)) / r100;
        if (r102 < 7) goto L10;
        r102 = 6;
    L10:
        int r103 = ((((int) this.mY) / r101) * 7) + r102;
        if (r103 < 0) goto L16;
        if (r103 >= this.mItems.size()) goto L16;
        return (Calendar) ListProtector.get(this.mItems, r103);
    L16:
        return null;
    }

    @Override // com.haibin.calendarview.BaseView
    public void updateCurrentDate() {
        List<Calendar> r100 = this.mItems;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.contains(this.mDelegate.f276165e0) == false) goto L12;
        Iterator<Calendar> r101 = this.mItems.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        r101.next().setCurrentDay(false);
        goto L9
    L11:
        int r102 = this.mItems.indexOf(this.mDelegate.f276165e0);
        ((Calendar) ListProtector.get(this.mItems, r102)).setCurrentDay(true);
    L12:
        invalidate();
    }

    public final void updateShowMode() {
        l r100 = this.mDelegate;
        if (r100.f276158b != 0) goto L5;
        this.mLineCount = 6;
        this.mHeight = this.mItemHeight * 6;
    L6:
        invalidate();
        return;
    L5:
        this.mHeight = f.e(this.mYear, this.mMonth, this.mItemHeight, r100.f276156a);
        goto L6
    }

    @Override // com.haibin.calendarview.BaseView
    public void updateItemHeight() {
        super.updateItemHeight();
        l r100 = this.mDelegate;
        if (r100.f276158b != 0) goto L5;
        this.mHeight = this.mItemHeight * this.mLineCount;
        return;
    L5:
        this.mHeight = f.e(this.mYear, this.mMonth, this.mItemHeight, r100.f276156a);
    }

    public final void updateWeekStart() {
        initCalendar();
        l r100 = this.mDelegate;
        if (r100.f276158b != 0) goto L5;
        this.mHeight = this.mItemHeight * this.mLineCount;
        return;
    L5:
        this.mHeight = f.e(this.mYear, this.mMonth, this.mItemHeight, r100.f276156a);
    }

    public a(Context r100) {
        super(r100);
    }

    public final int getSelectedIndex(Calendar r100) {
        return this.mItems.indexOf(r100);
    }

    public final void setSelectedCalendar(Calendar r100) {
        this.mCurrentItem = this.mItems.indexOf(r100);
    }

    public final void initMonthWithDate(int r100, int r101) {
        this.mYear = r100;
        this.mMonth = r101;
        initCalendar();
        l r102 = this.mDelegate;
        if (r102.f276158b != 0) goto L5;
        this.mHeight = this.mItemHeight * this.mLineCount;
        return;
    L5:
        this.mHeight = f.e(r100, r101, this.mItemHeight, r102.f276156a);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mLineCount == 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
    L5:
        super.onMeasure(r100, r101);
    }
}
