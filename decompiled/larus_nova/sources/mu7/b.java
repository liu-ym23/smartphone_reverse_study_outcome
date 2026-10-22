package mu7;

import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f515777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f515778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f515779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f515780d;

    public b() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f515778b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        if (this.f515780d == false) goto L6;
        long r100 = this.f515778b - this.f515777a;     // Catch: Throwable -> L13
    L10:
        this.f515779c = r100;     // Catch: Throwable -> L13
        this.f515780d = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        Lazy r101 = ku7.c.f506221a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("duration calculate has wrong, startTime should greater than 0, you should call start at first", "msg");     // Catch: Throwable -> L13
        ku7.a r102 = ku7.a.f506216a;     // Catch: Throwable -> L13
        ju7.b r103 = ku7.a.f506218c;     // Catch: Throwable -> L13
        if (r103 != null) goto L9;
        r103 = (ju7.b) ku7.c.f506221a.getValue();     // Catch: Throwable -> L13
    L9:
        r103.w("duration calculate has wrong, startTime should greater than 0, you should call start at first");     // Catch: Throwable -> L13
        r100 = 0;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f515780d = true;     // Catch: Throwable -> L7
        this.f515777a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.f515779c = 0;     // Catch: Throwable -> L7
        this.f515778b = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
