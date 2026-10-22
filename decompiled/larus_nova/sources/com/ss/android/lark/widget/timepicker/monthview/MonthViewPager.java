package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectTimeType;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import vec.g;
import vec.l;
import vec.m;
import xec.d;

/* JADX INFO: loaded from: classes38.dex */
public class MonthViewPager extends InfiniteViewPager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public xec.b f449041h;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f449042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonthViewPager f449043b;

        public a(MonthViewPager r100, int r101) {
            this.f449043b = r100;
            this.f449042a = r101;
        }
    }

    public g getCenterView() {
        return (g) ((MonthCalendarViewAdapter) getAdapter()).g(1);
    }

    public g getLeftView() {
        return (g) ((MonthCalendarViewAdapter) getAdapter()).g(0);
    }

    public g getRightView() {
        return (g) ((MonthCalendarViewAdapter) getAdapter()).g(2);
    }

    public int getRowNum() {
        return getCenterView().getRowNum();
    }

    public MonthViewPager(Context r100) {
        this(r100, null);
    }

    public final void k(CalendarDate r100) {
        g r101 = getCenterView();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.monthDiff(r101.getShownDate());
        if (r102 <= 0) goto L8;
        getRightView().d();
        l(r102);
        return;
    L8:
        if (r102 >= 0) goto L10;
        getLeftView().d();
        l(r102);
        return;
    L10:
        getCenterView().d();
    }

    public final void l(int r100) {
        if (r100 <= 0) goto L5;
        int r101 = 2;
    L6:
        this.f449013e = true;
        this.f449010b = false;
        setCurrentItem(r101, true);
        setOnSmoothScrollFinishListener(new a(this, r100));
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public void setViewPageListener(xec.b r100) {
        this.f449041h = r100;
    }

    public MonthViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        setWillNotDraw(false);
        setOffscreenPageLimit(3);
        l r102 = new l(this);
        if (this.f449011c != null) goto L5;
        this.f449011c = new ArrayList();
    L5:
        ((ArrayList) this.f449011c).add(r102);
    }

    public static void i(MonthViewPager r100, int r101) {
        MonthCalendarViewAdapter r102 = (MonthCalendarViewAdapter) r100.getAdapter();
        if (r102 == null) goto L26;
        if (r101 != 0) goto L7;
        g r103 = (g) r102.g(0);
        CalendarDate r104 = r102.j();
        CalendarDate r105 = r102.i();
        if (r103 == null) goto L25;
        r103.setSeedDate(r105);
        r103.setStartDate(yec.a.b(r105));
        r103.setEndDate(yec.a.a(r105));
        r103.setShownData(r104);
        r103.d();
        return;
    L25:
        return;
    L7:
        if (r101 != 1) goto L9;
        g r106 = (g) r102.g(1);
        CalendarDate r107 = r102.j();
        CalendarDate r108 = r102.j();
        if (r106 == null) goto L23;
        r106.setSeedDate(r108);
        r106.setStartDate(yec.a.b(r108));
        r106.setEndDate(yec.a.a(r108));
        r106.setShownData(r107);
        r106.d();
        return;
    L23:
        return;
    L9:
        if (r101 != 2) goto L27;
        g r109 = (g) r102.g(2);
        CalendarDate r110 = r102.j();
        CalendarDate r111 = r102.h();
        if (r109 == null) goto L21;
        r109.setSeedDate(r111);
        r109.setStartDate(yec.a.b(r111));
        r109.setEndDate(yec.a.a(r111));
        r109.setShownData(r110);
        r109.d();
        return;
    L21:
        return;
    L27:
        return;
    }

    public static void j(g r100, CalendarDate r101, boolean r102, CalendarDate r103, boolean r104, MonthViewAttr$SelectTimeType r105) {
        if ((r100 instanceof m) == false) goto L5;
        m r106 = (m) r100;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r101, DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter(r103, "endTime");
        Intrinsics.checkNotNullParameter(r105, "selectTimeType");
        r106.f554560t = r102;
        r106.f554561u = r104;
        r106.f554553p = r101;
        r106.f554554q = r103;
        r106.f554555r = r105;
        r106.c();
        r106.invalidate();
        return;
    L5:
        r100.f554553p = r101;
        r100.f554554q = r103;
        r100.f554555r = r105;
        r100.c();
        r100.invalidate();
    }
}
