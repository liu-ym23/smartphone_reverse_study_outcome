package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes23.dex */
public abstract class x extends c {
    public abstract void a(Canvas r100, Calendar r101, int r102);

    public abstract void b(Canvas r100, int r101);

    public abstract void c(Canvas r100, Calendar r101, int r102, boolean r103, boolean r104);

    public x(Context r100) {
        super(r100);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.isClick == true) goto L5;
        return;
    L5:
        Calendar r101 = getIndex();
        if (r101 != null) goto L9;
        return;
    L9:
        if (onCalendarIntercept(r101) == false) goto L11;
        this.mDelegate.getClass();
        throw null;
    L11:
        if (isInRange(r101) == true) goto L14;
        CalendarView.e r102 = this.mDelegate.f276177k0;
        return;
    L14:
        this.mCurrentItem = this.mItems.indexOf(r101);
        h r103 = this.mDelegate.f276179l0;
        if (r103 == null) goto L18;
        r103.b(r101, true);
    L18:
        if (this.mParentLayout == null) goto L20;
        int r104 = f.j(r101, this.mDelegate.f276156a);
        this.mParentLayout.h(r104);
    L20:
        CalendarView.e r105 = this.mDelegate.f276177k0;
        if (r105 == null) goto L23;
        ((ql5.t) r105).a(r101, true);
    L23:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.mItems.size() != 0) goto L5;
        return;
    L5:
        this.mItemWidth = (getWidth() - (this.mDelegate.f276184o * 2)) / 7;
        int r100 = 0;
    L6:
        if (r100 >= 7) goto L26;
        int r101 = (this.mItemWidth * r100) + this.mDelegate.f276184o;
        Calendar r102 = (Calendar) ListProtector.get(this.mItems, r100);
        boolean r103 = true;
        if (r100 != this.mCurrentItem) goto L10;
        boolean r111 = true;
    L11:
        boolean r104 = r102.hasScheme();
        if (r104 == false) goto L23;
        if (r111 == false) goto L15;
        b(r110, r101);
    L16:
        if (r103 == true) goto L18;
        if (r111 == false) goto L18;
    L25:
        c(r110, r102, r101, r104, r111);
        r100 = r100 + 1;
    L18:
        Paint r105 = this.mSchemePaint;
        if (r102.getSchemeColor() == 0) goto L21;
        int r106 = r102.getSchemeColor();
    L22:
        r105.setColor(r106);
        a(r110, r102, r101);
        goto L25
    L21:
        r106 = this.mDelegate.I;
        goto L22
    L15:
        r103 = false;
        goto L16
    L23:
        if (r111 == false) goto L25;
        b(r110, r101);
        goto L25
    L10:
        r111 = false;
        goto L11
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.mDelegate.getClass();
        return false;
    }
}
