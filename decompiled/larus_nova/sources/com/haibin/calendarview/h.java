package com.haibin.calendarview;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarView f276151a;

    public h(CalendarView r100) {
        this.f276151a = r100;
    }

    public final void a(Calendar r100, boolean r101) {
        if (r100.getYear() == this.f276151a.f276090a.f276165e0.getYear()) goto L5;
    L9:
        CalendarView r102 = this.f276151a;
        l r103 = r102.f276090a;
        r103.f276185o0 = r100;
        if (r103.f276160c == 0) goto L12;
        if (r101 == true) goto L12;
    L13:
        r102.f276092c.h(r100);
        this.f276151a.f276091b.i();
        CalendarView r104 = this.f276151a;
        w r105 = r104.f276095f;
        if (r105 == null) goto L20;
        l r106 = r104.f276090a;
        if (r106.f276160c == 0) goto L18;
        if (r101 == true) goto L18;
        return;
    L18:
        r105.onDateSelected(r100, r106.f276156a, r101);
        return;
    L20:
        return;
    L12:
        r103.f276183n0 = r100;
        goto L13
    L5:
        if (r100.getMonth() != this.f276151a.f276090a.f276165e0.getMonth()) goto L9;
        if (this.f276151a.f276091b.getCurrentItem() == this.f276151a.f276090a.f276173i0) goto L9;
    }

    public final void b(Calendar r100, boolean r101) {
        l r102 = this.f276151a.f276090a;
        r102.f276185o0 = r100;
        if (r102.f276160c == 0) goto L7;
        if (r101 == true) goto L7;
        if (r100.equals(r102.f276183n0) == true) goto L7;
    L8:
        int r103 = r100.getYear();
        l r104 = this.f276151a.f276090a;
        int r105 = ((r103 - r104.T) * 12) + r104.f276185o0.getMonth();
        CalendarView r106 = this.f276151a;
        int r107 = r105 - r106.f276090a.V;
        WeekViewPager r108 = r106.f276092c;
        if (r108.f276110c.f276160c == 0) goto L18;
        int r109 = 0;
    L13:
        if (r109 >= r108.getChildCount()) goto L18;
        c r110 = (c) r108.getChildAt(r109);
        if (r110.mItems.contains(r110.mDelegate.f276183n0) == true) goto L17;
        r110.mCurrentItem = -1;
        r110.invalidate();
    L17:
        r109 = r109 + 1;
    L18:
        this.f276151a.f276091b.setCurrentItem(r107, false);
        this.f276151a.f276091b.i();
        CalendarView r111 = this.f276151a;
        if (r111.f276095f == null) goto L30;
        l r112 = r111.f276090a;
        if (r112.f276160c == 0) goto L25;
        if (r101 == true) goto L25;
        if (r112.f276185o0.equals(r112.f276183n0) == true) goto L25;
        return;
    L25:
        CalendarView r113 = this.f276151a;
        r113.f276095f.onDateSelected(r100, r113.f276090a.f276156a, r101);
        return;
    L30:
        return;
    L7:
        this.f276151a.f276090a.f276183n0 = r100;
        goto L8
    }
}
