package com.haibin.calendarview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class CalendarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f276090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MonthViewPager f276091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeekViewPager f276092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f276093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public YearViewPager f276094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f276095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarLayout f276096g;

    public interface a {
        boolean a();
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
    }

    public int getCurDay() {
        return this.f276090a.f276165e0.getDay();
    }

    public int getCurMonth() {
        return this.f276090a.f276165e0.getMonth();
    }

    public int getCurYear() {
        return this.f276090a.f276165e0.getYear();
    }

    public List<Calendar> getCurrentMonthCalendars() {
        return this.f276091b.getCurrentMonthCalendars();
    }

    public List<Calendar> getCurrentWeekCalendars() {
        return this.f276092c.getCurrentWeekCalendars();
    }

    public final int getMaxMultiSelectSize() {
        return this.f276090a.f276189q0;
    }

    public Calendar getMaxRangeCalendar() {
        return this.f276090a.d();
    }

    public final int getMaxSelectRange() {
        return this.f276090a.f276197u0;
    }

    public Calendar getMinRangeCalendar() {
        return this.f276090a.e();
    }

    public final int getMinSelectRange() {
        return this.f276090a.f276195t0;
    }

    public final List<Calendar> getMultiSelectCalendars() {
        ArrayList r100 = new ArrayList();
        if (((HashMap) this.f276090a.f276187p0).size() != 0) goto L5;
        return r100;
    L5:
        r100.addAll(((HashMap) this.f276090a.f276187p0).values());
        Collections.sort(r100);
        return r100;
    }

    public final List<Calendar> getSelectCalendarRange() {
        l r100 = this.f276090a;
        if (r100.f276160c == 2) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        if (r100.f276191r0 == null) goto L16;
        if (r100.f276193s0 == null) goto L16;
        java.util.Calendar r102 = java.util.Calendar.getInstance();
        r102.set(r100.f276191r0.getYear(), r100.f276191r0.getMonth() - 1, r100.f276191r0.getDay());
        long r103 = r102.getTimeInMillis();
        r102.set(r100.f276193s0.getYear(), r100.f276193s0.getMonth() - 1, r100.f276193s0.getDay());
        long r104 = r102.getTimeInMillis();
    L12:
        if (r103 > r104) goto L14;
        r102.setTimeInMillis(r103);
        Calendar r105 = new Calendar();
        r105.setYear(r102.get(1));
        r105.setMonth(r102.get(2) + 1);
        r105.setDay(r102.get(5));
        p.c(r105);
        r101.add(r105);
        r103 = r103 + 86400000;
        goto L12
    L14:
        r100.b(r101);
    L16:
        return r101;
    }

    public Calendar getSelectedCalendar() {
        return this.f276090a.f276183n0;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        if (this.f276090a == null) goto L5;
        Bundle r100 = new Bundle();
        r100.putParcelable("super", super.onSaveInstanceState());
        r100.putSerializable("selected_calendar", this.f276090a.f276183n0);
        r100.putSerializable("index_calendar", this.f276090a.f276185o0);
        return r100;
    L5:
        return super.onSaveInstanceState();
    }

    public final void update() {
        this.f276095f.onWeekStartChange(this.f276090a.f276156a);
        this.f276094e.update();
        MonthViewPager r100 = this.f276091b;
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.getChildCount()) goto L6;
        ((com.haibin.calendarview.a) r100.getChildAt(r102)).update();
        r102 = r102 + 1;
        goto L4
    L6:
        WeekViewPager r103 = this.f276092c;
    L8:
        if (r101 >= r103.getChildCount()) goto L10;
        ((com.haibin.calendarview.c) r103.getChildAt(r101)).update();
        r101 = r101 + 1;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof CalendarLayout) == false) goto L19;
        CalendarLayout r100 = (CalendarLayout) getParent();
        this.f276096g = r100;
        this.f276091b.f276103g = r100;
        this.f276092c.f276111d = r100;
        r100.getClass();
        this.f276096g.setup(this.f276090a);
        CalendarLayout r101 = this.f276096g;
        if (r101.f276070g != null) goto L10;
        return;
    L10:
        if (r101.f276065b == 1) goto L14;
        if (r101.f276072i == 1) goto L14;
    L16:
        r101.f276083t.getClass();
        return;
    L14:
        if (r101.f276072i == 2) goto L16;
        r101.post(new com.haibin.calendarview.e(r101));
        return;
    }

    public MonthViewPager getMonthViewPager() {
        return this.f276091b;
    }

    public WeekViewPager getWeekViewPager() {
        return this.f276092c;
    }

    public CalendarView(Context r100) {
        this(r100, null);
    }

    private void setShowMode(int r100) {
        if (r100 != 0) goto L4;
    L8:
        l r101 = this.f276090a;
        if (r101.f276158b != r100) goto L11;
        return;
    L11:
        r101.f276158b = r100;
        WeekViewPager r102 = this.f276092c;
        int r103 = 0;
        int r104 = 0;
    L13:
        if (r104 >= r102.getChildCount()) goto L15;
        ((com.haibin.calendarview.c) r102.getChildAt(r104)).invalidate();
        r104 = r104 + 1;
        goto L13
    L15:
        MonthViewPager r105 = this.f276091b;
    L17:
        if (r103 >= r105.getChildCount()) goto L19;
        com.haibin.calendarview.a r106 = (com.haibin.calendarview.a) r105.getChildAt(r103);
        r106.updateShowMode();
        r106.requestLayout();
        r103 = r103 + 1;
        goto L17
    L19:
        l r107 = r105.f276099c;
        if (r107.f276158b != 0) goto L22;
        int r108 = r107.f276159b0 * 6;
        r105.f276102f = r108;
        r105.f276100d = r108;
        r105.f276101e = r108;
    L23:
        ViewGroup.LayoutParams r109 = r105.getLayoutParams();
        r109.height = r105.f276102f;
        r105.setLayoutParams(r109);
        CalendarLayout r110 = r105.f276103g;
        if (r110 == null) goto L26;
        r110.f();
    L26:
        WeekViewPager r111 = this.f276092c;
        l r112 = r111.f276110c;
        r111.f276109b = com.haibin.calendarview.f.h(r112.T, r112.V, r112.X, r112.U, r112.W, r112.Y, r112.f276156a);
        r111.getAdapter().notifyDataSetChanged();
        return;
    L22:
        r105.h(r107.f276183n0.getYear(), r105.f276099c.f276183n0.getMonth());
        goto L23
    L4:
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
    }

    private void setWeekStart(int r110) {
        if (r110 != 1) goto L5;
    L9:
        l r100 = this.f276090a;
        if (r110 != r100.f276156a) goto L12;
        return;
    L12:
        r100.f276156a = r110;
        this.f276095f.onWeekStartChange(r110);
        int r101 = 0;
        this.f276095f.onDateSelected(this.f276090a.f276183n0, r110, false);
        WeekViewPager r111 = this.f276092c;
        int r102 = r111.getAdapter().getCount();
        l r103 = r111.f276110c;
        int r104 = com.haibin.calendarview.f.h(r103.T, r103.V, r103.X, r103.U, r103.W, r103.Y, r103.f276156a);
        r111.f276109b = r104;
        if (r102 == r104) goto L15;
        r111.f276108a = true;
        r111.getAdapter().notifyDataSetChanged();
    L15:
        int r105 = 0;
    L17:
        if (r105 >= r111.getChildCount()) goto L19;
        com.haibin.calendarview.c r106 = (com.haibin.calendarview.c) r111.getChildAt(r105);
        int r107 = ((Integer) r106.getTag()).intValue();
        l r108 = r106.mDelegate;
        Calendar r109 = com.haibin.calendarview.f.b(r108.T, r108.V, r108.X, r107 + 1, r108.f276156a);
        r106.setSelectedCalendar(r106.mDelegate.f276183n0);
        r106.setup(r109);
        r105 = r105 + 1;
        goto L17
    L19:
        r111.f276108a = false;
        r111.h(r111.f276110c.f276183n0);
        MonthViewPager r112 = this.f276091b;
        int r113 = 0;
    L21:
        if (r113 >= r112.getChildCount()) goto L23;
        com.haibin.calendarview.a r114 = (com.haibin.calendarview.a) r112.getChildAt(r113);
        r114.updateWeekStart();
        r114.requestLayout();
        r113 = r113 + 1;
        goto L21
    L23:
        r112.h(r112.f276099c.f276183n0.getYear(), r112.f276099c.f276183n0.getMonth());
        ViewGroup.LayoutParams r115 = r112.getLayoutParams();
        r115.height = r112.f276102f;
        r112.setLayoutParams(r115);
        if (r112.f276103g == null) goto L26;
        l r116 = r112.f276099c;
        int r117 = com.haibin.calendarview.f.j(r116.f276183n0, r116.f276156a);
        r112.f276103g.h(r117);
    L26:
        r112.i();
        YearViewPager r118 = this.f276094e;
    L28:
        if (r101 >= r118.getChildCount()) goto L34;
        YearRecyclerView r119 = (YearRecyclerView) r118.getChildAt(r101);
        Iterator r120 = ((ArrayList) r119.f276115b.f276142a).iterator();
    L31:
        if (r120.hasNext() == false) goto L33;
        Month r121 = (Month) r120.next();
        r121.setDiff(com.haibin.calendarview.f.f(r121.getYear(), r121.getMonth(), r119.f276114a.f276156a));
        goto L31
    L33:
        r119.getAdapter().notifyDataSetChanged();
        r101 = r101 + 1;
        goto L28
    L34:
        return;
    L5:
        if (r110 == 2) goto L9;
        if (r110 == 7) goto L9;
    }

    public final boolean a(Calendar r100) {
        l r101 = this.f276090a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (com.haibin.calendarview.f.o(r100, r101) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Bundle r101 = (Bundle) r100;
        Parcelable r102 = r101.getParcelable("super");
        l r103 = this.f276090a;
        r103.f276183n0 = (Calendar) r101.getSerializable("selected_calendar");
        l r104 = this.f276090a;
        r104.f276185o0 = (Calendar) r101.getSerializable("index_calendar");
        l r105 = this.f276090a;
        e r106 = r105.f276177k0;
        if (r106 == null) goto L5;
        ql5.t r107 = (ql5.t) r106;
        r107.a(r105.f276183n0, false);
    L5:
        Calendar r108 = this.f276090a.f276185o0;
        if (r108 == null) goto L8;
        b(r108.getYear(), this.f276090a.f276185o0.getMonth(), this.f276090a.f276185o0.getDay());
    L8:
        update();
        super.onRestoreInstanceState(r102);
    }

    public final void setCalendarItemHeight(int r100) {
        l r101 = this.f276090a;
        if (r101.f276159b0 != r100) goto L5;
        return;
    L5:
        r101.f276159b0 = r100;
        MonthViewPager r102 = this.f276091b;
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r102.getChildCount()) goto L9;
        com.haibin.calendarview.a r105 = (com.haibin.calendarview.a) r102.getChildAt(r104);
        r105.updateItemHeight();
        r105.requestLayout();
        r104 = r104 + 1;
        goto L7
    L9:
        int r106 = r102.f276099c.f276185o0.getYear();
        int r107 = r102.f276099c.f276185o0.getMonth();
        l r108 = r102.f276099c;
        r102.f276102f = com.haibin.calendarview.f.e(r106, r107, r108.f276159b0, r108.f276156a);
        if (r107 != 1) goto L12;
        l r109 = r102.f276099c;
        r102.f276101e = com.haibin.calendarview.f.e(r106 - 1, 12, r109.f276159b0, r109.f276156a);
        l r110 = r102.f276099c;
        r102.f276100d = com.haibin.calendarview.f.e(r106, 2, r110.f276159b0, r110.f276156a);
    L16:
        ViewGroup.LayoutParams r111 = r102.getLayoutParams();
        r111.height = r102.f276102f;
        r102.setLayoutParams(r111);
        WeekViewPager r112 = this.f276092c;
    L18:
        if (r103 >= r112.getChildCount()) goto L20;
        com.haibin.calendarview.c r113 = (com.haibin.calendarview.c) r112.getChildAt(r103);
        r113.updateItemHeight();
        r113.requestLayout();
        r103 = r103 + 1;
        goto L18
    L20:
        CalendarLayout r114 = this.f276096g;
        if (r114 != null) goto L23;
        return;
    L23:
        l r115 = r114.f276083t;
        r114.f276082s = r115.f276159b0;
        if (r114.f276070g == null) goto L37;
        Calendar r116 = r115.f276185o0;
        r114.h(com.haibin.calendarview.f.j(r116, r115.f276156a));
        if (r114.f276083t.f276158b != 0) goto L29;
        r114.f276074k = r114.f276082s * 5;
    L30:
        r114.e();
        if (r114.f276068e.getVisibility() != 0) goto L36;
        r114.f276070g.setTranslationY(-r114.f276074k);
        return;
    L36:
        return;
    L29:
        r114.f276074k = com.haibin.calendarview.f.e(r116.getYear(), r116.getMonth(), r114.f276082s, r114.f276083t.f276156a) - r114.f276082s;
        goto L30
    L37:
        return;
    L12:
        l r117 = r102.f276099c;
        r102.f276101e = com.haibin.calendarview.f.e(r106, r107 - 1, r117.f276159b0, r117.f276156a);
        if (r107 != 12) goto L15;
        l r118 = r102.f276099c;
        r102.f276100d = com.haibin.calendarview.f.e(r106 + 1, 1, r118.f276159b0, r118.f276156a);
        goto L16
    L15:
        l r119 = r102.f276099c;
        r102.f276100d = com.haibin.calendarview.f.e(r106, r107 + 1, r119.f276159b0, r119.f276156a);
        goto L16
    }

    public final void setMaxMultiSelectSize(int r100) {
        this.f276090a.f276189q0 = r100;
    }

    public final void setMonthView(Class<?> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f276090a.L.equals(r100) == false) goto L7;
        return;
    L7:
        this.f276090a.L = r100;
        MonthViewPager r101 = this.f276091b;
        r101.f276097a = true;
        r101.getAdapter().notifyDataSetChanged();
        r101.f276097a = false;
    }

    public final void setMonthViewScrollable(boolean r100) {
        this.f276090a.f276167f0 = r100;
    }

    public final void setOnCalendarInterceptListener(a r100) {
        if (r100 != null) goto L4;
        this.f276090a.getClass();
    L4:
        if (r100 == null) goto L13;
        l r101 = this.f276090a;
        if (r101.f276160c == 0) goto L14;
        Calendar r102 = r101.f276183n0;
        if (r100.a() == true) goto L11;
        return;
    L11:
        l r103 = this.f276090a;
        r103.f276183n0 = new Calendar();
        return;
    L14:
        return;
    }

    public void setOnCalendarLongClickListener(b r100) {
        this.f276090a.getClass();
    }

    public final void setOnCalendarMultiSelectListener(c r100) {
        this.f276090a.getClass();
    }

    public final void setOnCalendarRangeSelectListener(d r100) {
        this.f276090a.getClass();
    }

    public void setOnCalendarSelectListener(e r100) {
        l r101 = this.f276090a;
        r101.f276177k0 = r100;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101.f276160c == 0) goto L9;
        return;
    L9:
        if (a(r101.f276183n0) == true) goto L11;
        return;
    L11:
        this.f276090a.f();
    }

    public void setOnMonthChangeListener(f r100) {
        this.f276090a.f276181m0 = r100;
    }

    public void setOnViewChangeListener(g r100) {
        this.f276090a.getClass();
    }

    public void setOnWeekChangeListener(h r100) {
        this.f276090a.getClass();
    }

    public void setOnYearChangeListener(i r100) {
        this.f276090a.getClass();
    }

    public void setOnYearViewChangeListener(j r100) {
        this.f276090a.getClass();
    }

    public final void setSchemeDate(Map<String, Calendar> r100) {
        l r101 = this.f276090a;
        r101.f276175j0 = r100;
        r101.f();
        this.f276094e.update();
        MonthViewPager r102 = this.f276091b;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102.getChildCount()) goto L6;
        ((com.haibin.calendarview.a) r102.getChildAt(r104)).update();
        r104 = r104 + 1;
        goto L4
    L6:
        WeekViewPager r105 = this.f276092c;
    L8:
        if (r103 >= r105.getChildCount()) goto L10;
        ((com.haibin.calendarview.c) r105.getChildAt(r103)).update();
        r103 = r103 + 1;
        goto L8
    }

    public final void setSelectEndCalendar(Calendar r100) {
        l r101 = this.f276090a;
        int r102 = r101.f276160c;
        if (r102 == 2) goto L5;
        return;
    L5:
        Calendar r103 = r101.f276191r0;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r102 != 2) goto L37;
        if (r100 == null) goto L38;
        r101.getClass();
        this.f276090a.getClass();
        int r104 = r100.differ(r103);
        if (r104 >= 0) goto L16;
        return;
    L16:
        if (a(r103) == true) goto L18;
        return;
    L18:
        if (a(r100) == false) goto L40;
        l r105 = this.f276090a;
        int r106 = r105.f276195t0;
        if (r106 != (-1)) goto L23;
    L25:
        int r107 = r105.f276197u0;
        if (r107 != (-1)) goto L28;
    L30:
        if (r106 != (-1)) goto L33;
        if (r104 != 0) goto L33;
        r105.f276191r0 = r103;
        r105.f276193s0 = null;
        b(r103.getYear(), r103.getMonth(), r103.getDay());
        return;
    L33:
        r105.f276191r0 = r103;
        r105.f276193s0 = r100;
        b(r103.getYear(), r103.getMonth(), r103.getDay());
        return;
    L28:
        if (r107 >= (r104 + 1)) goto L30;
        return;
    L23:
        if (r106 <= (r104 + 1)) goto L25;
        return;
    L40:
        return;
    L38:
        return;
    }

    public final void setSelectStartCalendar(Calendar r100) {
        if (this.f276090a.f276160c == 2) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        return;
    L8:
        if (a(r100) == true) goto L11;
        this.f276090a.getClass();
        return;
    L11:
        this.f276090a.getClass();
        l r101 = this.f276090a;
        r101.f276193s0 = null;
        r101.f276191r0 = r100;
        b(r100.getYear(), r100.getMonth(), r100.getDay());
    }

    public final void setWeekBar(Class<?> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f276090a.R.equals(r100) == false) goto L7;
        return;
    L7:
        this.f276090a.R = r100;
        FrameLayout r101 = (FrameLayout) findViewById(R.id.frameContent);
        r101.removeView(this.f276095f);
        this.f276095f = (w) r100.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});     // Catch: Exception -> L10
    L12:
        r101.addView(this.f276095f, 2);
        this.f276095f.setup(this.f276090a);
        this.f276095f.onWeekStartChange(this.f276090a.f276156a);
        MonthViewPager r102 = this.f276091b;
        w r103 = this.f276095f;
        r102.f276105i = r103;
        l r104 = this.f276090a;
        r103.onDateSelected(r104.f276183n0, r104.f276156a, false);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final void setWeekView(Class<?> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f276090a.R.equals(r100) == false) goto L7;
        return;
    L7:
        this.f276090a.N = r100;
        WeekViewPager r101 = this.f276092c;
        r101.f276108a = true;
        r101.getAdapter().notifyDataSetChanged();
        r101.f276108a = false;
    }

    public final void setWeekViewScrollable(boolean r100) {
        this.f276090a.f276169g0 = r100;
    }

    public final void setYearViewScrollable(boolean r100) {
        this.f276090a.f276171h0 = r100;
    }

    public CalendarView(Context r100, AttributeSet r101) {
        super(r100, r101);
        l r102 = new l(r100, r101);
        this.f276090a = r102;
        LayoutInflater.from(r100).inflate(R.layout.cv_layout_calendar_view, this, true);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.frameContent);
        WeekViewPager r104 = (WeekViewPager) findViewById(R.id.vp_week);
        this.f276092c = r104;
        r104.setup(r102);
        this.f276095f = (w) r102.R.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});     // Catch: Exception -> L5
    L7:
        r103.addView(this.f276095f, 2);
        this.f276095f.setup(this.f276090a);
        this.f276095f.onWeekStartChange(this.f276090a.f276156a);
        View r105 = findViewById(R.id.line);
        this.f276093d = r105;
        r105.setBackgroundColor(this.f276090a.D);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) this.f276093d.getLayoutParams();
        l r107 = this.f276090a;
        int r108 = r107.G;
        r106.setMargins(r108, r107.f276163d0, r108, 0);
        this.f276093d.setLayoutParams(r106);
        MonthViewPager r109 = (MonthViewPager) findViewById(R.id.vp_month);
        this.f276091b = r109;
        r109.f276104h = this.f276092c;
        r109.f276105i = this.f276095f;
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109.getLayoutParams();
        r110.setMargins(0, this.f276090a.f276163d0 + com.haibin.calendarview.f.a(r100, 1.0f), 0, 0);
        this.f276092c.setLayoutParams(r110);
        YearViewPager r111 = (YearViewPager) findViewById(R.id.selectLayout);
        this.f276094e = r111;
        r111.setBackgroundColor(this.f276090a.E);
        this.f276094e.addOnPageChangeListener(new com.haibin.calendarview.g(this));
        l r112 = this.f276090a;
        r112.f276179l0 = new com.haibin.calendarview.h(this);
        if (r112.f276160c == 0) goto L10;
        r112.f276183n0 = new Calendar();
    L14:
        l r113 = this.f276090a;
        Calendar r114 = r113.f276183n0;
        r113.f276185o0 = r114;
        this.f276095f.onDateSelected(r114, r113.f276156a, false);
        this.f276091b.setup(this.f276090a);
        this.f276091b.setCurrentItem(this.f276090a.f276173i0);
        this.f276094e.setOnMonthSelectedListener(new com.haibin.calendarview.i(this));
        this.f276094e.setup(this.f276090a);
        this.f276092c.h(this.f276090a.c());
        return;
    L10:
        if (a(r112.f276165e0) == false) goto L12;
        l r115 = this.f276090a;
        r115.f276183n0 = r115.c();
        goto L14
    L12:
        l r116 = this.f276090a;
        r116.f276183n0 = r116.e();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        l r103 = this.f276090a;
        if (r103 != null) goto L5;
    L9:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (r103.f276161c0 == false) goto L9;
        setCalendarItemHeight((r102 - r103.f276163d0) / 6);
        super.onMeasure(r100, r101);
    }

    public final void b(int r100, int r101, int r102) {
        Calendar r103 = new Calendar();
        r103.setYear(r100);
        r103.setMonth(r101);
        r103.setDay(r102);
        if (r103.isAvailable() == true) goto L6;
        return;
    L6:
        if (a(r103) == false) goto L38;
        this.f276090a.getClass();
        if (this.f276092c.getVisibility() != 0) goto L17;
        WeekViewPager r104 = this.f276092c;
        r104.f276112e = true;
        Calendar r105 = new Calendar();
        r105.setYear(r100);
        r105.setMonth(r101);
        r105.setDay(r102);
        r105.setCurrentDay(r105.equals(r104.f276110c.f276165e0));
        p.c(r105);
        l r106 = r104.f276110c;
        r106.f276185o0 = r105;
        r106.f276183n0 = r105;
        r106.f();
        r104.h(r105);
        com.haibin.calendarview.h r107 = r104.f276110c.f276179l0;
        if (r107 == null) goto L13;
        r107.b(r105, false);
    L13:
        e r108 = r104.f276110c.f276177k0;
        if (r108 == null) goto L16;
        ((ql5.t) r108).a(r105, false);
    L16:
        int r109 = com.haibin.calendarview.f.j(r105, r104.f276110c.f276156a);
        r104.f276111d.h(r109);
        return;
    L17:
        MonthViewPager r110 = this.f276091b;
        r110.f276106j = true;
        Calendar r111 = new Calendar();
        r111.setYear(r100);
        r111.setMonth(r101);
        r111.setDay(r102);
        r111.setCurrentDay(r111.equals(r110.f276099c.f276165e0));
        p.c(r111);
        l r112 = r110.f276099c;
        r112.f276185o0 = r111;
        r112.f276183n0 = r111;
        r112.f();
        int r113 = (((r111.getYear() - r110.f276099c.T) * 12) + r111.getMonth()) - r110.f276099c.V;
        if (r110.getCurrentItem() != r113) goto L20;
        r110.f276106j = false;
    L20:
        r110.setCurrentItem(r113, false);
        com.haibin.calendarview.a r114 = (com.haibin.calendarview.a) r110.findViewWithTag(Integer.valueOf(r113));
        if (r114 == null) goto L26;
        r114.setSelectedCalendar(r110.f276099c.f276185o0);
        r114.invalidate();
        CalendarLayout r115 = r110.f276103g;
        if (r115 == null) goto L26;
        r115.g(r114.getSelectedIndex(r110.f276099c.f276185o0));
    L26:
        if (r110.f276103g == null) goto L28;
        int r116 = com.haibin.calendarview.f.j(r111, r110.f276099c.f276156a);
        r110.f276103g.h(r116);
    L28:
        e r117 = r110.f276099c.f276177k0;
        if (r117 == null) goto L31;
        ((ql5.t) r117).a(r111, false);
    L31:
        com.haibin.calendarview.h r118 = r110.f276099c.f276179l0;
        if (r118 == null) goto L34;
        r118.a(r111, false);
    L34:
        r110.i();
        return;
    }
}
