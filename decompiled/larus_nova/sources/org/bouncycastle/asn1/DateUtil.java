package org.bouncycastle.asn1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
class DateUtil {
    static Locale EN_Locale;
    private static Long ZERO;
    private static final Map localeCache = null;

    static {
        ZERO = longValueOf(0);
        localeCache = new HashMap();
        EN_Locale = forEN();
    }

    public DateUtil() {
    }

    public static Date epochAdjust(Date r100) throws ParseException {
        Locale r101 = Locale.getDefault();
        if (r101 != null) goto L5;
        return r100;
    L5:
        Map r102 = localeCache;
        monitor-enter(r102);
        Long r103 = (Long) r102.get(r101);     // Catch: Throwable -> L21
        if (r103 != null) goto L15;
        long r104 = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();     // Catch: Throwable -> L21
        if (r104 != 0) goto L12;
        r103 = ZERO;     // Catch: Throwable -> L21
    L13:
        r102.put(r101, r103);     // Catch: Throwable -> L21
        goto L15
    L12:
        r103 = longValueOf(r104);     // Catch: Throwable -> L21
    L15:
        if (r103 == ZERO) goto L19;
        Date r105 = new Date(r100.getTime() - r103.longValue());     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r105;
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r100;
    L21:
        th = move-exception;
        throw th;
    }

    private static Locale forEN() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage()) == true) goto L5;
        Locale[] r100 = Locale.getAvailableLocales();
        int r101 = 0;
    L8:
        if (r101 == r100.length) goto L15;
        if ("en".equalsIgnoreCase(r100[r101].getLanguage()) == true) goto L12;
        r101 = r101 + 1;
        goto L8
    L12:
        return r100[r101];
    L15:
        return Locale.getDefault();
    L5:
        return Locale.getDefault();
    }

    private static Long longValueOf(long r100) {
        return Long.valueOf(r100);
    }
}
