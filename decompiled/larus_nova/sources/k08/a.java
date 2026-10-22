package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements MonthPickerDefaultHead.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDatePicker f501264a;

    @Override // com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead.a
    public final void a() {
        CalendarDate r100 = new CalendarDate(this.f501264a.f284772c);
        int[] r101 = com.larksuite.component.universe_design.util.a.f285486a;
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        CalendarDate r102 = r100.modifyMonth(-1);
        r102.setMonthDay(1);
        CalendarDate r103 = r102.moveToDayStart();
        UDDatePicker r104 = this.f501264a;
        r104.f284772c = r103;
        r104.c();
        this.f501264a.b();
        this.f501264a.f284776g.f284784d.h(-1);
    }

    @Override // com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead.a
    public final void b() {
        CalendarDate r100 = new CalendarDate(this.f501264a.f284772c);
        int[] r101 = com.larksuite.component.universe_design.util.a.f285486a;
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        CalendarDate r102 = r100.modifyMonth(1);
        r102.setMonthDay(1);
        CalendarDate r103 = r102.moveToDayStart();
        UDDatePicker r104 = this.f501264a;
        r104.f284772c = r103;
        r104.c();
        this.f501264a.b();
        this.f501264a.f284776g.f284784d.h(1);
    }

    public a(UDDatePicker r100) {
        this.f501264a = r100;
    }
}
