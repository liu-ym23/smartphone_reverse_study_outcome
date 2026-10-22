package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class c extends BaseView {
    @Override // com.haibin.calendarview.BaseView
    public final void onDestroy() {
    }

    @Override // com.haibin.calendarview.BaseView
    public final void onPreviewHook() {
    }

    public Calendar getIndex() {
        int r100 = ((int) (this.mX - this.mDelegate.f276184o)) / this.mItemWidth;
        if (r100 < 7) goto L5;
        r100 = 6;
    L5:
        int r101 = ((((int) this.mY) / this.mItemHeight) * 7) + r100;
        if (r101 >= 0) goto L8;
        return null;
    L8:
        if (r101 < this.mItems.size()) goto L10;
        return null;
    L10:
        return (Calendar) ListProtector.get(this.mItems, r101);
    }

    @Override // com.haibin.calendarview.BaseView
    public final void updateCurrentDate() {
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

    public c(Context r100) {
        super(r100);
    }

    public final void setSelectedCalendar(Calendar r100) {
        l r101 = this.mDelegate;
        if (r101.f276160c == 1) goto L5;
    L7:
        this.mCurrentItem = this.mItems.indexOf(r100);
        return;
    L5:
        if (r100.equals(r101.f276183n0) == true) goto L7;
    }

    public final void setup(Calendar r100) {
        l r101 = this.mDelegate;
        this.mItems = f.n(r100, r101, r101.f276156a);
        addSchemesFromMap();
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
    }
}
