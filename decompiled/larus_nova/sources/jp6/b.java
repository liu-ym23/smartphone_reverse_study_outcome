package jp6;

import com.bytedance.locallife.cube.d;
import fp6.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends AbstractExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f499987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f499988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f499989c;

    public final void a() {
        Object r100 = this.f499987a;
        monitor-enter(r100);
        int r101 = this.f499988b - 1;     // Catch: Throwable -> L10
        this.f499988b = r101;     // Catch: Throwable -> L10
        if (r101 != 0) goto L7;
        this.f499987a.notifyAll();     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        Object r100 = this.f499987a;
        monitor-enter(r100);
        boolean r101 = this.f499989c;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        Object r100 = this.f499987a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f499989c == false) goto L9;
        if (this.f499988b != 0) goto L9;
        boolean r101 = true;
    L10:
        monitor-exit(r100);
        return r101;
    L9:
        r101 = false;
        goto L10
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        Object r100 = this.f499987a;
        monitor-enter(r100);
        this.f499989c = true;     // Catch: Throwable -> L11
        if (this.f499988b != 0) goto L8;
        this.f499987a.notifyAll();     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f499987a = new Object();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        shutdown();
        return new ArrayList();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        Object r101 = this.f499987a;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f499989c == false) goto L9;
        j r102 = d.f257194a;     // Catch: Throwable -> L19
        d.b("Executor already shutdown, running tasks " + this.f499988b);     // Catch: Throwable -> L19
        monitor-exit(r101);
    L11:
        if (r100 != null) goto L23;
    L17:
        a();
        return;
    L23:
        r100.run();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a();
        throw th;
    L9:
        this.f499988b++;     // Catch: Throwable -> L19
        monitor-exit(r101);
        goto L11
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r100, TimeUnit r101) {
        Intrinsics.checkNotNull(r101);
        long r102 = r101.toNanos(r100);
        Object r103 = this.f499987a;
        monitor-enter(r103);
    L21:
        if (this.f499989c == false) goto L12;
        if (this.f499988b != 0) goto L12;
        monitor-exit(r103);
        return true;
    L12:
        if (r102 <= 0) goto L13;
        long r104 = System.nanoTime();     // Catch: Throwable -> L18
        TimeUnit.NANOSECONDS.timedWait(this.f499987a, r102);     // Catch: Throwable -> L18
        r102 = r102 - (System.nanoTime() - r104);
        goto L21
    L13:
        monitor-exit(r103);
        return false;
    L18:
        th = move-exception;
        throw th;
    }
}
