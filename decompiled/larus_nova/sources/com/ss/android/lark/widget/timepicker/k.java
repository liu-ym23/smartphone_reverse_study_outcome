package com.ss.android.lark.widget.timepicker;

import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements YearMonthPicker.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeSelectFragment f449002a;

    public k(TimeSelectFragment r100) {
        this.f449002a = r100;
    }

    @Override // com.ss.android.lark.widget.timepicker.YearMonthPicker.a
    public final void a(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDate");
        TimeSelectFragment r101 = this.f449002a;
        if (r101.f448981z == 2) goto L5;
    L12:
        this.f449002a.da0(r100.getDate());
        TimeSelectFragment r102 = this.f449002a;
        Date r103 = r100.getDate();
        if (r102.f448981z != 1) goto L18;
        if (r102.f448979x == null) goto L21;
        r102.ga0(r103);
        return;
    L21:
        return;
    L18:
        if (r102.f448980y == null) goto L23;
        r102.ga0(r103);
        return;
    L23:
        return;
    L5:
        if (r101.f448959d == true) goto L12;
        int r104 = r100.getJulianDay();
        com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate r105 = this.f449002a.f448977v;
        if (r105 == null) goto L9;
        int r106 = r105.getJulianDay();
    L10:
        if (r104 <= r106) goto L12;
        return;
    L9:
        r106 = 0;
        goto L10
    }
}
