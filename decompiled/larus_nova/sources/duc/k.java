package duc;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f470070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f470071b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f470072c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f470073d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f470074e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f470075f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f470076g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f470077h = null;

    static {
        int r100 = d0.f504940a;
        String r101 = System.getProperty("kotlinx.coroutines.scheduler.default.name");     // Catch: SecurityException -> L5
    L6:
        if (r101 != null) goto L8;
        r101 = "DefaultDispatcher";
    L8:
        f470070a = r101;
        f470071b = c0.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);
        f470072c = c0.b("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(d0.f504940a, 2), 1, 0, 8);
        f470073d = c0.b("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f470074e = TimeUnit.SECONDS.toNanos(c0.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 1, Long.MAX_VALUE));
        f470075f = d.f470064a;
        f470076g = new i(0);
        f470077h = new i(1);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
