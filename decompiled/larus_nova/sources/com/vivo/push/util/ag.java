package com.vivo.push.util;

import java.util.Calendar;

/* JADX INFO: loaded from: classes41.dex */
public final class ag {
    public static long a() {
        Calendar r100 = Calendar.getInstance();     // Catch: Exception -> L4
        r100.set(11, 0);     // Catch: Exception -> L4
        r100.set(12, 0);     // Catch: Exception -> L4
        r100.set(13, 0);     // Catch: Exception -> L4
        return r100.getTimeInMillis();
    L4:
        e = move-exception;
        t.a("TimeUtils", "getTodayStartTime error", e);
        return 0;
    }
}
