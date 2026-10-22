package mla;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f514382b;

    public f(CharSequence[] r100) {
        if (r100 == null) goto L11;
        if (r100.length < 12) goto L9;
        this.f514382b = r100;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // mla.g
    public final CharSequence a(CalendarDay r100) {
        return new SpannableStringBuilder().append(this.f514382b[r100.c() - 1]).append(" ").append(String.valueOf(r100.d()));
    }
}
