package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import vec.c;
import vec.e;
import vec.f;
import vec.g;
import vec.j;
import vec.m;

/* JADX INFO: loaded from: classes38.dex */
public class MonthCalendarViewAdapter extends InfinitePagerAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f449019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vec.b f449020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f449021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public xec.a f449022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f449023i;

    @Override // com.ss.android.lark.widget.timepicker.monthview.InfinitePagerAdapter
    public final void f() {
    }

    public final CalendarDate j() {
        return this.f449020f.c();
    }

    public final CalendarDate h() {
        CalendarDate r100 = j().modifyMonth(1);
        r100.setMonthDay(1);
        return r100.moveToDayStart();
    }

    public final CalendarDate i() {
        CalendarDate r100 = j().modifyMonth(-1);
        r100.setMonthDay(1);
        return r100.moveToDayStart();
    }

    public final View k(int r100) {
        if (this.f449023i == false) goto L5;
        g r101 = new m(this.f449019e, this.f449021g);
    L6:
        CalendarDate r102 = this.f449020f.b();
        if (r100 <= 0) goto L9;
        int r103 = r100 - 1;
    L10:
        CalendarDate r104 = r102.modifyMonth(r103);
        r104.setMonthDay(1);
        r101.setSeedDate(r104);
        r101.setStartDate(yec.a.b(r104));
        r101.setEndDate(yec.a.a(r104));
        r101.setSelectDate(this.f449020f.b());
        r101.setCurrentDate(this.f449020f.a());
        r101.setOnMonthDayViewSelectListener(new f(this));
        r101.d();
        return r101;
    L9:
        r103 = -1;
        goto L10
    L5:
        r101 = new g(this.f449019e, this.f449021g);
        goto L6
    }

    public final void l(boolean r100) {
        if (this.f449008d == true) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= getCount()) goto L13;
        g r102 = (g) g(r101);
        if (r100 == false) goto L11;
        r102.setSelectDate(this.f449020f.b());
    L12:
        r102.d();
        r101 = r101 + 1;
        goto L7
    L11:
        r102.setShownData(j());
        goto L12
    }

    public MonthCalendarViewAdapter(Context r100, j r101, boolean r102) {
        super(r100);
        this.f449023i = false;
        this.f449019e = r100;
        this.f449023i = r102;
        if (r102 == false) goto L5;
        this.f449021g = new ListNoLimitMonthDayView(r100);
    L6:
        this.f449021g.setTypeFace(h18.e.a(r100));
        this.f449020f = r101;
        c r103 = new c(this.f449005a);
        this.f449006b[0] = r103;
        r103.a(k(0));
        c r104 = new c(this.f449005a);
        this.f449006b[1] = r104;
        r104.a(k(1));
        c r105 = new c(this.f449005a);
        this.f449006b[2] = r105;
        r105.a(k(2));
        return;
    L5:
        this.f449021g = new e(r100);
        goto L6
    }
}
