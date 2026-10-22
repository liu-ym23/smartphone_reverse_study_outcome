package com.larksuite.component.universe_design.datepicker.impl;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.datepicker.impl.infinite.InfinitePagerAdapter;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m08.a;
import p08.b;
import p08.d;
import q08.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/MonthCalendarViewAdapter;", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "monthViewDataFetcher", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewDataFetcher;", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewDataFetcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "monthViewStateChangeListener", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewStateChangeListener;", "onInstantiateItem", "Landroid/view/View;", "position", "", "initMonthViewDate", "", "monthView", "Lcom/larksuite/component/universe_design/datepicker/impl/monthview/MonthView;", "setMonthViewStateChangeListener", "afterInstantiateItem", "refreshPage", "pageIndex", "updateSelectState", "updateAllViews", "getSelectedDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", "getPreviousStartDate", "getFollowingStartDate", "setTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthDateTextSize", "textSize", "", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonthCalendarViewAdapter extends InfinitePagerAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f284790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f284791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f284792e;

    @Override // com.larksuite.component.universe_design.datepicker.impl.infinite.InfinitePagerAdapter
    public final void f() {
    }

    public final void i() {
        int r100 = 0;
    L4:
        if (r100 >= 3) goto L17;
        c r101 = (c) g(r100);
        if (r101 == null) goto L16;
        CalendarDate r102 = this.f284791d.getSelectedDate();
        if (r100 <= 0) goto L11;
        int r103 = r100 - 1;
    L12:
        CalendarDate r104 = r102.modifyMonth(r103);
        if (r104 == null) goto L16;
        r104.setMonthDay(1);
        r101.setSeedDate(r104);
        r101.setSelectDate(this.f284791d.getSelectedDate());
        r101.setCurrentDate(this.f284791d.a());
        r101.setFirstWeekDay(this.f284791d.c());
        r101.setMonthShowMode(this.f284791d.b());
        r101.a();
        goto L16
    L11:
        r103 = -1;
    L16:
        r100 = r100 + 1;
        goto L4
    }

    public final Context getContext() {
        return this.f284790c;
    }

    public final View h(int r100) {
        c r101 = new c(this.f284790c);
        CalendarDate r102 = this.f284791d.getSelectedDate();
        if (r100 <= 0) goto L5;
        int r103 = r100 - 1;
    L6:
        CalendarDate r104 = r102.modifyMonth(r103);
        r104.setMonthDay(1);
        Intrinsics.checkNotNull(r104);
        r101.setSeedDate(r104);
        r101.setSelectDate(this.f284791d.getSelectedDate());
        r101.setCurrentDate(this.f284791d.a());
        r101.setFirstWeekDay(this.f284791d.c());
        r101.setMonthShowMode(this.f284791d.b());
        r101.setOnMonthDayViewSelectListener(new a(this));
        r101.a();
        return r101;
    L5:
        r103 = -1;
        goto L6
    }

    public MonthCalendarViewAdapter(Context r100, k08.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "monthViewDataFetcher");
        super(r100);
        this.f284790c = r100;
        this.f284791d = r101;
        this.f284813b = new o08.a[]{new o08.a(this.f284812a, h(0)), new o08.a(this.f284812a, h(1)), new o08.a(this.f284812a, h(2))};
    }
}
