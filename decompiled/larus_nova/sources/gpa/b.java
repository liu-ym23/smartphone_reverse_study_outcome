package gpa;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements h {
    public b() {
    }

    @Override // gpa.h
    public final CharSequence a(DayOfWeek r100) {
        return r100.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
