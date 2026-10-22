package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.util.CalendarDate;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements p08.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDatePicker f501265a;

    @Override // p08.b
    public final CalendarDate a() {
        return new CalendarDate();
    }

    @Override // p08.b
    public final MonthShowMode b() {
        return this.f501265a.f284774e;
    }

    @Override // p08.b
    public final CalendarDate.DayOfWeek c() {
        return this.f501265a.f284775f;
    }

    @Override // p08.b
    public final CalendarDate getSelectedDate() {
        return this.f501265a.f284772c;
    }

    public b(UDDatePicker r100) {
        this.f501265a = r100;
    }
}
