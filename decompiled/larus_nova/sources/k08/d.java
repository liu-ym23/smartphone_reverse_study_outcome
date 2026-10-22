package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements p08.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDatePicker f501267a;

    @Override // p08.c
    public final void a() {
        UDDatePicker r100 = this.f501267a;
        int r101 = UDDatePicker.f284769h;
        r100.e();
    }

    @Override // p08.c
    public final void b() {
        UDDatePicker r100 = this.f501267a;
        int r101 = UDDatePicker.f284769h;
        r100.e();
    }

    public d(UDDatePicker r100) {
        this.f501267a = r100;
    }

    @Override // p08.c
    public final void c(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        UDDatePicker.a(this.f501267a, r100);
    }
}
