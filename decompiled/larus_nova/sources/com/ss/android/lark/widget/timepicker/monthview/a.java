package com.ss.android.lark.widget.timepicker.monthview;

import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements xec.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthViewContainer f449044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f449045b;

    @Override // xec.a
    public final void a(int r100) {
        this.f449044a.getLookMonthViewPagerFromXml().l(r100);
    }

    @Override // xec.a
    public final void b(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        this.f449044a.getLookWeekIndicatorFromXml().a(this.f449045b.element, yec.a.d(this.f449044a.f449031h, r100));
        MonthViewContainer r101 = this.f449044a;
        r101.f449032i = r100;
        r101.f449033j = r100;
        MonthViewContainer.MonthViewChangeListener r102 = r101.f449027d;
        if (r102 == null) goto L6;
        r102.a(r100, 1);
        return;
    }

    public a(MonthViewContainer r100, Ref.IntRef r101) {
        this.f449044a = r100;
        this.f449045b = r101;
    }
}
