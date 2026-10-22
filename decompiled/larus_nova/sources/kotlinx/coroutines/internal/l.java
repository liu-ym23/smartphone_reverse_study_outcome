package kotlinx.coroutines.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes.dex */
public final class l extends CoroutineDispatcher implements kotlinx.coroutines.f0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504962f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f504963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f504964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.f0 f504965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p<Runnable> f504966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f504967e;
    private volatile /* synthetic */ int runningWorkers$volatile;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f504968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f504969b;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = 0;
        L23:
            this.f504968a.run();     // Catch: Throwable -> L5
        L21:
            Runnable r101 = this.f504969b.d();     // Catch: Throwable -> L16
            if (r101 == null) goto L19;
            this.f504968a = r101;     // Catch: Throwable -> L16
            r100 = r100 + 1;     // Catch: Throwable -> L16
            if (r100 < 16) goto L23;
            l r102 = this.f504969b;     // Catch: Throwable -> L16
            if (r102.f504963a.isDispatchNeeded(r102) == false) goto L23;
            l r103 = this.f504969b;     // Catch: Throwable -> L16
            r103.f504963a.dispatch(r103, this);     // Catch: Throwable -> L16
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

        public a(l r100, Runnable r101) {
            this.f504969b = r100;
            this.f504968a = r101;
        }
    }

    static {
        f504962f = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers$volatile");
    }

    @Override // kotlinx.coroutines.f0
    public final m0 invokeOnTimeout(long r100, Runnable r101, CoroutineContext r102) {
        return this.f504965c.invokeOnTimeout(r100, r101, r102);
    }

    @Override // kotlinx.coroutines.f0
    public final void scheduleResumeAfterDelay(long r100, kotlinx.coroutines.i<? super Unit> r101) {
        this.f504965c.scheduleResumeAfterDelay(r100, r101);
    }

    public final Runnable d() {
    L2:
        Runnable r100 = this.f504966d.d();
        if (r100 != null) goto L17;
        Object r101 = this.f504967e;
        monitor-enter(r101);
        AtomicIntegerFieldUpdater r102 = f504962f;     // Catch: Throwable -> L14
        r102.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.f504966d.c() == 0) goto L8;
        r102.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r101);
        goto L2
    L8:
        monitor-exit(r101);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r100;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r100) {
        m.a(r100);
        if (r100 < this.f504964b) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(CoroutineDispatcher r100, int r101) {
        this.f504963a = r100;
        this.f504964b = r101;
        if ((r100 instanceof kotlinx.coroutines.f0) == false) goto L5;
        kotlinx.coroutines.f0 r102 = (kotlinx.coroutines.f0) r100;
    L6:
        if (r102 != null) goto L8;
        r102 = kotlinx.coroutines.d0.f504706a;
    L8:
        this.f504965c = r102;
        this.f504966d = new p();
        this.f504967e = new Object();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        this.f504966d.a(r101);
        AtomicIntegerFieldUpdater r102 = f504962f;
        if (r102.get(this) >= this.f504964b) goto L21;
        Object r103 = this.f504967e;
        monitor-enter(r103);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r102.get(this) < this.f504964b) goto L10;
        monitor-exit(r103);
        boolean r104 = false;
    L13:
        if (r104 == false) goto L24;
        Runnable r105 = d();
        if (r105 == null) goto L26;
        a r106 = new a(this, r105);
        this.f504963a.dispatch(this, r106);
        return;
    L26:
        return;
    L24:
        return;
    L10:
        r102.incrementAndGet(this);     // Catch: Throwable -> L18
        monitor-exit(r103);
        r104 = true;
        goto L13
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r100, Runnable r101) {
        this.f504966d.a(r101);
        AtomicIntegerFieldUpdater r102 = f504962f;
        if (r102.get(this) >= this.f504964b) goto L21;
        Object r103 = this.f504967e;
        monitor-enter(r103);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r102.get(this) < this.f504964b) goto L10;
        monitor-exit(r103);
        boolean r104 = false;
    L13:
        if (r104 == false) goto L24;
        Runnable r105 = d();
        if (r105 == null) goto L26;
        a r106 = new a(this, r105);
        this.f504963a.dispatchYield(this, r106);
        return;
    L26:
        return;
    L24:
        return;
    L10:
        r102.incrementAndGet(this);     // Catch: Throwable -> L18
        monitor-exit(r103);
        r104 = true;
        goto L13
    }
}
