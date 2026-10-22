package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes23.dex */
public abstract class s extends a {
    public abstract void onDrawScheme(Canvas r100, Calendar r101, int r102, int r103);

    public abstract boolean onDrawSelected(Canvas r100, Calendar r101, int r102, int r103, boolean r104);

    public abstract void onDrawText(Canvas r100, Calendar r101, int r102, int r103, boolean r104, boolean r105);

    public s(Context r100) {
        super(r100);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (this.isClick == true) goto L5;
        return;
    L5:
        Calendar r101 = getIndex();
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.mDelegate.f276158b != 1) goto L14;
        if (r101.isCurrentMonth() == true) goto L14;
        return;
    L14:
        if (onCalendarIntercept(r101) == false) goto L16;
        this.mDelegate.getClass();
        throw null;
    L16:
        if (isInRange(r101) == true) goto L19;
        CalendarView.e r102 = this.mDelegate.f276177k0;
        return;
    L19:
        this.mCurrentItem = this.mItems.indexOf(r101);
        if (r101.isCurrentMonth() == true) goto L28;
        MonthViewPager r103 = this.mMonthViewPager;
        if (r103 == null) goto L28;
        int r104 = r103.getCurrentItem();
        if (this.mCurrentItem >= 7) goto L26;
        int r105 = r104 - 1;
    L27:
        this.mMonthViewPager.setCurrentItem(r105);
        goto L28
    L26:
        r105 = r104 + 1;
    L28:
        h r106 = this.mDelegate.f276179l0;
        if (r106 == null) goto L32;
        r106.a(r101, true);
    L32:
        if (this.mParentLayout != null) goto L34;
    L37:
        CalendarView.e r107 = this.mDelegate.f276177k0;
        if (r107 == null) goto L43;
        ((ql5.t) r107).a(r101, true);
        return;
    L43:
        return;
    L34:
        if (r101.isCurrentMonth() == false) goto L36;
        this.mParentLayout.g(this.mItems.indexOf(r101));
        goto L37
    L36:
        this.mParentLayout.h(f.j(r101, this.mDelegate.f276156a));
        goto L37
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        if (this.mLineCount != 0) goto L5;
        return;
    L5:
        this.mItemWidth = (getWidth() - (this.mDelegate.f276184o * 2)) / 7;
        onPreviewHook();
        int r100 = this.mLineCount * 7;
        int r101 = 0;
        int r111 = 0;
    L7:
        if (r111 >= this.mLineCount) goto L24;
        int r112 = r101;
        int r113 = 0;
    L9:
        if (r113 >= 7) goto L23;
        Calendar r102 = (Calendar) ListProtector.get(this.mItems, r112);
        int r103 = this.mDelegate.f276158b;
        if (r103 == 1) goto L13;
        if (r103 != 2) goto L21;
        if (r112 < r100) goto L21;
        return;
    L21:
        draw(r110, r102, r111, r113, r112);
    L22:
        r112 = r112 + 1;
        r113 = r113 + 1;
        goto L9
    L13:
        if (r112 > (this.mItems.size() - this.mNextDiff)) goto L14;
        if (r102.isCurrentMonth() == true) goto L21;
    L14:
        return;
    L23:
        r111 = r111 + 1;
        r101 = r112;
        goto L7
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r100) {
        this.mDelegate.getClass();
        return false;
    }

    private void draw(Canvas r100, Calendar r110, int r111, int r112, int r113) {
        int r114 = (r112 * this.mItemWidth) + this.mDelegate.f276184o;
        int r115 = r111 * this.mItemHeight;
        onLoopStart(r114, r115);
        boolean r101 = false;
        if (r113 != this.mCurrentItem) goto L5;
        boolean r102 = true;
    L6:
        boolean r116 = r110.hasScheme();
        if (r116 == false) goto L17;
        if (r102 == false) goto L10;
        r101 = onDrawSelected(r100, r110, r114, r115, true);
    L10:
        if (r101 == true) goto L12;
        if (r102 == false) goto L12;
    L19:
        onDrawText(r100, r110, r114, r115, r116, r102);
        return;
    L12:
        Paint r103 = this.mSchemePaint;
        if (r110.getSchemeColor() == 0) goto L15;
        int r104 = r110.getSchemeColor();
    L16:
        r103.setColor(r104);
        onDrawScheme(r100, r110, r114, r115);
        goto L19
    L15:
        r104 = this.mDelegate.I;
        goto L16
    L17:
        if (r102 == false) goto L19;
        onDrawSelected(r100, r110, r114, r115, false);
        goto L19
    L5:
        r102 = false;
        goto L6
    }
}
