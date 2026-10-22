package gpa;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f482136b;

    public d() {
        DateTimeFormatter r100 = DateTimeFormatter.f526328h;
        DateTimeFormatterBuilder r101 = new DateTimeFormatterBuilder();
        r101.g("LLLL yyyy");
        this.f482136b = r101.p();
    }

    @Override // gpa.g
    public final CharSequence a(CalendarDay r100) {
        return this.f482136b.a(r100.f404402a);
    }
}
