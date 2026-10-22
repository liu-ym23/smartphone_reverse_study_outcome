package kotlinx.coroutines.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l extends CoroutineDispatcher implements f0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    public final CoroutineDispatcher a;
    public final int b;
    public final /* synthetic */ f0 c;
    public final p<Runnable> d;
    public final Object e;
    private volatile /* synthetic */ int runningWorkers$volatile;

    public final class a implements Runnable {
        public Runnable a;
        public final /* synthetic */ l b;

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = 0;
        L23:
            this.a.run();     // Catch: Throwable -> L5
        L21:
            Runnable r1 = this.b.d();     // Catch: Throwable -> L16
            if (r1 == null) goto L19;
            this.a = r1;     // Catch: Throwable -> L16
            r0 = r0 + 1;     // Catch: Throwable -> L16
            if (r0 < 16) goto L23;
            l r2 = this.b;     // Catch: Throwable -> L16
            if (r2.a.isDispatchNeeded(r2) == false) goto L23;
            l r3 = this.b;     // Catch: Throwable -> L16
            r3.a.dispatch(r3, this);     // Catch: Throwable -> L16
            return;
        L19:
            return;
        L5:
            th = move-exception;
            kotlinx.coroutines.y.a(EmptyCoroutineContext.INSTANCE, th);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L31;
            throw th;
        }

        public a(l r1, Runnable r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers$volatile");
    }

    @Override // kotlinx.coroutines.f0
    public final m0 invokeOnTimeout(long r2, Runnable r4, CoroutineContext r5) {
        return this.c.invokeOnTimeout(r2, r4, r5);
    }

    @Override // kotlinx.coroutines.f0
    public final void scheduleResumeAfterDelay(long r2, kotlinx.coroutines.i<? super Unit> r4) {
        this.c.scheduleResumeAfterDelay(r2, r4);
    }

    public final Runnable d() {
    L2:
        Runnable r0 = this.d.d();
        if (r0 != null) goto L17;
        Object r1 = this.e;
        monitor-enter(r1);
        AtomicIntegerFieldUpdater r2 = f;     // Catch: Throwable -> L14
        r2.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.d.c() == 0) goto L8;
        r2.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r1);
        goto L2
    L8:
        monitor-exit(r1);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r2) {
        m.a(r2);
        if (r2 < this.b) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(CoroutineDispatcher r1, int r2) {
        this.a = r1;
        this.b = r2;
        if ((r1 instanceof f0) == false) goto L5;
        f0 r3 = (f0) r1;
    L6:
        if (r3 != null) goto L8;
        r3 = kotlinx.coroutines.d0.a;
    L8:
        this.c = r3;
        this.d = new p();
        this.e = new Object();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r3, Runnable r4) {
        this.d.a(r4);
        AtomicIntegerFieldUpdater r5 = f;
        if (r5.get(this) >= this.b) goto L21;
        Object r6 = this.e;
        monitor-enter(r6);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r5.get(this) < this.b) goto L10;
        monitor-exit(r6);
        boolean r7 = false;
    L13:
        if (r7 == false) goto L24;
        Runnable r8 = d();
        if (r8 == null) goto L26;
        a r9 = new a(this, r8);
        this.a.dispatch(this, r9);
        return;
    L26:
        return;
    L24:
        return;
    L10:
        r5.incrementAndGet(this);     // Catch: Throwable -> L18
        monitor-exit(r6);
        r7 = true;
        goto L13
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r3, Runnable r4) {
        this.d.a(r4);
        AtomicIntegerFieldUpdater r5 = f;
        if (r5.get(this) >= this.b) goto L21;
        Object r6 = this.e;
        monitor-enter(r6);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r5.get(this) < this.b) goto L10;
        monitor-exit(r6);
        boolean r7 = false;
    L13:
        if (r7 == false) goto L24;
        Runnable r8 = d();
        if (r8 == null) goto L26;
        a r9 = new a(this, r8);
        this.a.dispatchYield(this, r9);
        return;
    L26:
        return;
    L24:
        return;
    L10:
        r5.incrementAndGet(this);     // Catch: Throwable -> L18
        monitor-exit(r6);
        r7 = true;
        goto L13
    }
}
