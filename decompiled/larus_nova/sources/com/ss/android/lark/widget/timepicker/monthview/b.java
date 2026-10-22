package com.ss.android.lark.widget.timepicker.monthview;

import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements xec.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthViewContainer f449046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f449047b;

    @Override // xec.b
    public final void a() {
        MonthViewContainer r100 = this.f449046a;
        int r101 = Math.min(r100.f449029f * 6, r100.f449028e);
        MonthViewContainer r102 = this.f449046a;
        int r103 = r101 - Math.min(r102.f449029f * 6, r102.f449028e);
        if (r103 == 0) goto L6;
        MonthViewContainer.a(this.f449046a, r103);
        return;
    }

    @Override // xec.b
    public final void b() {
        MonthViewContainer r100 = this.f449046a;
        int r101 = Math.min(r100.f449029f * 6, r100.f449028e);
        MonthViewContainer r102 = this.f449046a;
        int r103 = r101 - Math.min(r102.f449029f * 6, r102.f449028e);
        if (r103 == 0) goto L6;
        MonthViewContainer.a(this.f449046a, r103);
        return;
    }

    @Override // xec.b
    public final void c(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "shownDate");
        MonthViewContainer r101 = this.f449046a;
        r101.f449033j = r100;
        r101.getLookWeekIndicatorFromXml().a(this.f449047b.element, yec.a.d(this.f449046a.f449031h, r100));
        MonthViewContainer.MonthViewChangeListener r102 = this.f449046a.f449027d;
        if (r102 == null) goto L6;
        r102.a(r100, 0);
        return;
    }

    public b(MonthViewContainer r100, Ref.IntRef r101) {
        this.f449046a = r100;
        this.f449047b = r101;
    }
}
