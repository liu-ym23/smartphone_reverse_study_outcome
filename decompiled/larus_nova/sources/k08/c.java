package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements p08.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDatePicker f501266a;

    public c(UDDatePicker r100) {
        this.f501266a = r100;
    }

    @Override // p08.d
    public final void a(int r100) {
        this.f501266a.f284776g.f284784d.h(r100);
    }

    @Override // p08.d
    public final void b(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "selectDate");
        UDDatePicker r101 = this.f501266a;
        r101.f284772c = r100;
        r101.c();
        this.f501266a.b();
    }
}
