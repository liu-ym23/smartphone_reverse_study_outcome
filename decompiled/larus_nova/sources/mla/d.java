package mla;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f514380b;

    public d() {
        DateTimeFormatter r100 = DateTimeFormatter.f526328h;
        DateTimeFormatterBuilder r101 = new DateTimeFormatterBuilder();
        r101.g("LLLL yyyy");
        this.f514380b = r101.p();
    }

    @Override // mla.g
    public final CharSequence a(CalendarDay r100) {
        return this.f514380b.a(r100.f399162a);
    }
}
