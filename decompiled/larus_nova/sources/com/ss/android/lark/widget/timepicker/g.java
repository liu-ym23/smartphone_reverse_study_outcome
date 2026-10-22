package com.ss.android.lark.widget.timepicker;

import android.widget.CheckBox;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewContainer;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements MonthViewContainer.MonthViewChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeSelectFragment f448996a;

    public g(TimeSelectFragment r100) {
        this.f448996a = r100;
    }

    @Override // com.ss.android.lark.widget.timepicker.monthview.MonthViewContainer.MonthViewChangeListener
    public final void a(CalendarDate r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        TimeSelectFragment r102 = this.f448996a;
        int r103 = TimeSelectFragment.B;
        r102.ea0();
        this.f448996a.ca0();
        boolean r104 = false;
        if (this.f448996a.f448959d == true) goto L11;
        int r105 = r100.getJulianDay();
        CalendarDate r106 = this.f448996a.f448977v;
        if (r106 == null) goto L7;
        int r107 = r106.getJulianDay();
    L8:
        if (r105 <= r107) goto L11;
        return;
    L7:
        r107 = 0;
    L11:
        if (r101 != 1) goto L36;
        TimeSelectFragment r108 = this.f448996a;
        if (r108.f448959d == false) goto L24;
        CheckBox r109 = r108.f448973r;
        if (r109 != null) goto L17;
    L19:
        if (r104 == false) goto L34;
        CheckBox r110 = this.f448996a.f448973r;
        if (r110 == null) goto L34;
        r110.toggle();
    L34:
        TimeSelectFragment r111 = this.f448996a;
        r111.f448978w = r100;
        r111.ga0(r100.getDate());
        return;
    L17:
        if (r109.isChecked() != true) goto L19;
        r104 = true;
        goto L19
    L24:
        if (r108.f448981z != 1) goto L34;
        CheckBox r112 = r108.f448973r;
        if (r112 != null) goto L28;
    L30:
        if (r104 == false) goto L34;
        CheckBox r113 = this.f448996a.f448973r;
        if (r113 == null) goto L34;
        r113.toggle();
        goto L34
    L28:
        if (r112.isChecked() != true) goto L30;
        r104 = true;
        goto L30
    }
}
