package mla;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f514379b;

    public c() {
        Locale r100 = Locale.getDefault();
        DateTimeFormatter r101 = DateTimeFormatter.f526328h;
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        r102.g("d");
        this.f514379b = r102.q(r100);
    }
}
