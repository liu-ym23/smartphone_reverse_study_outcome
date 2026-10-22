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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final c0 h = null;
    public static final long i = 0;

    public final synchronized void B() {
        monitor-enter(this);
        int r0 = debugStatus;     // Catch: Throwable -> L16
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        debugStatus = 3;     // Catch: Throwable -> L16
        r0.e.set(this, null);     // Catch: Throwable -> L16
        r0.f.set(this, null);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L16
        notifyAll();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        r1 = true;
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
        c0 r0 = new c0();
        h = r0;
        r0.i(false);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        i = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    public final void C() {
        v1.a.set(this);
        monitor-enter(this);     // Catch: Throwable -> L51
        int r0 = debugStatus;     // Catch: Throwable -> L54
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L51
        boolean r2 = false;
    L17:
        if (r2 == true) goto L22;
        _thread = null;
        B();
        if (z() == true) goto L68;
        q();
        return;
    L68:
        return;
    L22:
        long r9 = Long.MAX_VALUE;
    L23:
        Thread.interrupted();     // Catch: Throwable -> L51
        long r11 = m();     // Catch: Throwable -> L51
        if (r11 != Long.MAX_VALUE) goto L36;
        long r15 = System.nanoTime();     // Catch: Throwable -> L51
        if (r9 == Long.MAX_VALUE) goto L28;
    L29:
        long r5 = r9 - r15;
        if (r5 <= 0) goto L31;
        r11 = RangesKt.coerceAtMost(r11, r5);     // Catch: Throwable -> L51
    L38:
        if (r11 <= 0) goto L23;
        int r6 = debugStatus;     // Catch: Throwable -> L51
        if (r6 == 2) goto L44;
        if (r6 == 3) goto L44;
        boolean r7 = false;
    L45:
        if (r7 == true) goto L46;
        LockSupport.parkNanos(this, r11);     // Catch: Throwable -> L51
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
        r7 = true;
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
        r9 = i + r15;
        goto L29
    L36:
        r9 = Long.MAX_VALUE;
        goto L38
    L14:
        debugStatus = 1;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L54
        notifyAll();     // Catch: Throwable -> L54
        monitor-exit(this);     // Catch: Throwable -> L51
        r2 = true;
        goto L17
    L10:
        r1 = true;
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
        Thread r0 = _thread;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = _thread;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = new PthreadThreadV2(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L10
        _thread = r0;     // Catch: Throwable -> L10
        r0.setContextClassLoader(c0.class.getClassLoader());     // Catch: Throwable -> L10
        r0.setDaemon(true);     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
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
    public final void x(Runnable r3) {
        if (debugStatus != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        super.x(r3);
        return;
    L10:
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    L5:
        r0 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.s0
    public final void u(long r1, r0.c r3) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.r0, kotlinx.coroutines.f0
    public final m0 invokeOnTimeout(long r3, Runnable r5, CoroutineContext r6) {
        long r4 = t0.a(r3);
        if (r4 >= 4611686018427387903L) goto L6;
        long r0 = System.nanoTime();
        r0.b r7 = new r0.b(r4 + r0, r5);
        A(r0, r7);
        return r7;
    L6:
        return l1.a;
    }
}
