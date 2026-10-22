package mu7;

import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public volatile long a;
    public volatile long b;
    public volatile long c;
    public volatile boolean d;

    public b() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        if (this.d == false) goto L6;
        long r0 = this.b - this.a;     // Catch: Throwable -> L13
    L10:
        this.c = r0;     // Catch: Throwable -> L13
        this.d = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        Lazy r1 = ku7.c.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("duration calculate has wrong, startTime should greater than 0, you should call start at first", "msg");     // Catch: Throwable -> L13
        ku7.a r2 = ku7.a.a;     // Catch: Throwable -> L13
        ju7.b r3 = ku7.a.c;     // Catch: Throwable -> L13
        if (r3 != null) goto L9;
        r3 = (ju7.b) ku7.c.a.getValue();     // Catch: Throwable -> L13
    L9:
        r3.w("duration calculate has wrong, startTime should greater than 0, you should call start at first");     // Catch: Throwable -> L13
        r0 = 0;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.d = true;     // Catch: Throwable -> L7
        this.a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.c = 0;     // Catch: Throwable -> L7
        this.b = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
