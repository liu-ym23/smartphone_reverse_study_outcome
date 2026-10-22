package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0000\u001a,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0001j\u0002`\nH\u0002\"\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000f"}, d2 = {"CalendarLocale", "Ljava/util/Locale;", "toLocalString", "", "", "minDigits", "maxDigits", "isGroupingUsed", "", "locale", "Landroidx/compose/material3/CalendarLocale;", "cachedFormatters", "Ljava/util/WeakHashMap;", "Ljava/text/NumberFormat;", "getCachedDateTimeFormatter", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CalendarLocale_jvmKt {
    private static final WeakHashMap<String, NumberFormat> cachedFormatters = null;

    static {
        cachedFormatters = new WeakHashMap();
    }

    private static final NumberFormat getCachedDateTimeFormatter(int r3, int r4, boolean r5, Locale r6) {
        String r0 = r3 + '.' + r4 + '.' + r5 + '.' + r6.toLanguageTag();
        WeakHashMap<String, NumberFormat> r1 = cachedFormatters;
        NumberFormat r2 = r1.get(r0);
        if (r2 != null) goto L6;
        r2 = NumberFormat.getIntegerInstance(r6);
        r2.setGroupingUsed(r5);
        r2.setMinimumIntegerDigits(r3);
        r2.setMaximumIntegerDigits(r4);
        r1.put(r0, r2);
    L6:
        return r2;
    }

    public static final String toLocalString(int r0, int r1, int r2, boolean r3, Locale r4) {
        if (r4 != null) goto L5;
        r4 = Locale.getDefault();
    L5:
        return getCachedDateTimeFormatter(r1, r2, r3, r4).format(Integer.valueOf(r0));
    }

    public static /* synthetic */ String toLocalString$default(int r0, int r1, int r2, boolean r3, Locale r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 40;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = false;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = null;
    L15:
        return toLocalString(r0, r1, r2, r3, r4);
    }
}
