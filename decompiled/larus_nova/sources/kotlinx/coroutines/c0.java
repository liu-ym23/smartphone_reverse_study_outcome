package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c0 f504641h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f504642i = 0;

    public final synchronized void B() {
        monitor-enter(this);
        int r100 = debugStatus;     // Catch: Throwable -> L16
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L9;
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        debugStatus = 3;     // Catch: Throwable -> L16
        r0.f505009e.set(this, null);     // Catch: Throwable -> L16
        r0.f505010f.set(this, null);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L16
        notifyAll();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        r101 = true;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.r0, kotlinx.coroutines.q0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    static {
        c0 r100 = new c0();
        f504641h = r100;
        r100.i(false);
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        Long r102 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f504642i = r101.toNanos(r102.longValue());
        return;
    L5:
        r102 = 1000L;
        goto L6
    }

    public final void C() {
        v1.f505154a.set(this);
        monitor-enter(this);     // Catch: Throwable -> L51
        int r100 = debugStatus;     // Catch: Throwable -> L54
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L10;
        boolean r101 = false;
    L11:
        if (r101 == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L51
        boolean r102 = false;
    L17:
        if (r102 == true) goto L22;
        _thread = null;
        B();
        if (z() == true) goto L68;
        q();
        return;
    L68:
        return;
    L22:
        long r103 = Long.MAX_VALUE;
    L23:
        Thread.interrupted();     // Catch: Throwable -> L51
        long r110 = m();     // Catch: Throwable -> L51
        if (r110 != Long.MAX_VALUE) goto L36;
        long r111 = System.nanoTime();     // Catch: Throwable -> L51
        if (r103 == Long.MAX_VALUE) goto L28;
    L29:
        long r104 = r103 - r111;
        if (r104 <= 0) goto L31;
        r110 = RangesKt.coerceAtMost(r110, r104);     // Catch: Throwable -> L51
    L38:
        if (r110 <= 0) goto L23;
        int r105 = debugStatus;     // Catch: Throwable -> L51
        if (r105 == 2) goto L44;
        if (r105 == 3) goto L44;
        boolean r106 = false;
    L45:
        if (r106 == true) goto L46;
        LockSupport.parkNanos(this, r110);     // Catch: Throwable -> L51
        goto L23
    L46:
        _thread = null;
        B();
        if (z() == true) goto L70;
        q();
        return;
    L70:
        return;
    L44:
        r106 = true;
        goto L45
    L31:
        _thread = null;
        B();
        if (z() == true) goto L69;
        q();
        return;
    L69:
        return;
    L28:
        r103 = f504642i + r111;
        goto L29
    L36:
        r103 = Long.MAX_VALUE;
        goto L38
    L14:
        debugStatus = 1;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L54
        notifyAll();     // Catch: Throwable -> L54
        monitor-exit(this);     // Catch: Throwable -> L51
        r102 = true;
        goto L17
    L10:
        r101 = true;
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        _thread = null;
        B();
        if (z() == true) goto L60;
        q();
    L60:
        throw th;
    }

    @Override // kotlinx.coroutines.s0
    public final Thread q() {
        Thread r100 = _thread;
        if (r100 != null) goto L13;
        monitor-enter(this);
        r100 = _thread;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        r100 = new PthreadThreadV2(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L10
        _thread = r100;     // Catch: Throwable -> L10
        r100.setContextClassLoader(c0.class.getClassLoader());     // Catch: Throwable -> L10
        r100.setDaemon(true);     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c0() {
    }

    @Override // kotlinx.coroutines.r0
    public final void x(Runnable r100) {
        if (debugStatus != 4) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        super.x(r100);
        return;
    L10:
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.s0
    public final void u(long r100, r0.c r101) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.r0, kotlinx.coroutines.f0
    public final m0 invokeOnTimeout(long r100, Runnable r101, CoroutineContext r102) {
        long r103 = t0.a(r100);
        if (r103 >= 4611686018427387903L) goto L6;
        long r104 = System.nanoTime();
        r0.b r105 = new r0.b(r103 + r104, r101);
        A(r104, r105);
        return r105;
    L6:
        return l1.f504994a;
    }
}
