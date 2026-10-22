package duc;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class k {
    public static final String a = null;
    public static final long b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final long e = 0;
    public static final d f = null;
    public static final i g = null;
    public static final i h = null;

    static {
        int r1 = d0.a;
        String r0 = System.getProperty("kotlinx.coroutines.scheduler.default.name");     // Catch: SecurityException -> L5
    L6:
        if (r0 != null) goto L8;
        r0 = "DefaultDispatcher";
    L8:
        a = r0;
        b = c0.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);
        c = c0.b("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(d0.a, 2), 1, 0, 8);
        d = c0.b("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        e = TimeUnit.SECONDS.toNanos(c0.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 1, Long.MAX_VALUE));
        f = d.a;
        g = new i(0);
        h = new i(1);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
