package m08;

import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import p08.d;
import p08.e;
import q08.c;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthCalendarViewAdapter f511493a;

    @Override // p08.e
    public final void b() {
        MonthCalendarViewAdapter r100 = this.f511493a;
        int r101 = 0;
    L4:
        if (r101 >= 3) goto L10;
        c r102 = (c) r100.g(r101);
        if (r102 == null) goto L9;
        r102.setSelectDate(r100.f284791d.getSelectedDate());
        r102.a();
    L9:
        r101 = r101 + 1;
        goto L4
    L10:
        r100.getClass();
    }

    public a(MonthCalendarViewAdapter r100) {
        this.f511493a = r100;
    }

    @Override // p08.e
    public final void a(int r100) {
        d r101 = this.f511493a.f284792e;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // p08.e
    public final void c(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        d r101 = this.f511493a.f284792e;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
