package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class r0 extends s0 implements f0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505009e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505010f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505011g = null;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: loaded from: classes5.dex */
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i<Unit> f505012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r0 f505013d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f505012c.f(this.f505013d, Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // kotlinx.coroutines.r0.c
        public final String toString() {
            return super.toString() + this.f505012c;
        }

        public a(r0 r100, long r101, j r102) {
            this.f505013d = r100;
            super(r101);
            this.f505012c = r102;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f505014c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f505014c.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // kotlinx.coroutines.r0.c
        public final String toString() {
            return super.toString() + this.f505014c;
        }

        public b(long r100, Runnable r101) {
            super(r100);
            this.f505014c = r101;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class c implements Runnable, Comparable<c>, m0, kotlinx.coroutines.internal.h0 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f505015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f505016b;

        @Override // kotlinx.coroutines.m0
        public final void dispose() {
            monitor-enter(this);
            Object r100 = this._heap;     // Catch: Throwable -> L16
            kotlinx.coroutines.internal.b0 r101 = t0.f505149a;     // Catch: Throwable -> L16
            if (r100 != r101) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r100 instanceof d) == false) goto L10;
            d r102 = (d) r100;     // Catch: Throwable -> L16
        L11:
            if (r102 == null) goto L13;
            r102.d(this);     // Catch: Throwable -> L16
        L13:
            this._heap = r101;     // Catch: Throwable -> L16
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L10:
            r102 = null;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // kotlinx.coroutines.internal.h0
        public final kotlinx.coroutines.internal.g0<?> a() {
            Object r100 = this._heap;
            if ((r100 instanceof kotlinx.coroutines.internal.g0) == true) goto L7;
            return null;
        L7:
            return (kotlinx.coroutines.internal.g0) r100;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f505015a + ']';
        }

        @Override // kotlinx.coroutines.internal.h0
        public final int getIndex() {
            return this.f505016b;
        }

        public c(long r100) {
            this.f505015a = r100;
            this.f505016b = -1;
        }

        @Override // kotlinx.coroutines.internal.h0
        public final void c(d r100) {
            if (this._heap == t0.f505149a) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this._heap = r100;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.lang.Comparable
        public final int compareTo(c r100) {
            long r101 = this.f505015a - r100.f505015a;
            if (r101 <= 0) goto L5;
            return 1;
        L5:
            if (r101 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        @Override // kotlinx.coroutines.internal.h0
        public final void setIndex(int r100) {
            this.f505016b = r100;
        }

        public final int d(long r100, d r110, r0 r111) {
            monitor-enter(this);
        L40:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != t0.f505149a) goto L8;
            monitor-exit(this);
            return 2;
        L8:
            monitor-enter(r110);     // Catch: Throwable -> L40
            Object[] r101 = r110.f504950a;     // Catch: Throwable -> L12
            if (r101 == null) goto L14;
            Object r102 = r101[0];     // Catch: Throwable -> L12
        L15:
            c r103 = (c) r102;     // Catch: Throwable -> L12
            if (r0.w(r111) == false) goto L22;
            monitor-exit(r110);     // Catch: Throwable -> L40
            monitor-exit(this);
            return 1;
        L22:
            if (r103 != null) goto L24;
            r110.f505017c = r100;     // Catch: Throwable -> L12
        L31:
            long r104 = this.f505015a;     // Catch: Throwable -> L12
            long r105 = r110.f505017c;     // Catch: Throwable -> L12
            if ((r104 - r105) >= 0) goto L34;
            this.f505015a = r105;     // Catch: Throwable -> L12
        L34:
            r110.a(this);     // Catch: Throwable -> L12
            monitor-exit(r110);     // Catch: Throwable -> L40
            monitor-exit(this);
            return 0;
        L24:
            long r106 = r103.f505015a;     // Catch: Throwable -> L12
            if ((r106 - r100) >= 0) goto L29;
            r100 = r106;
        L29:
            if ((r100 - r110.f505017c) <= 0) goto L31;
            r110.f505017c = r100;     // Catch: Throwable -> L12
            goto L31
        L14:
            r102 = null;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L40
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class d extends kotlinx.coroutines.internal.g0<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f505017c;

        public d(long r100) {
            this.f505017c = r100;
        }
    }

    static {
        f505009e = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue$volatile");
        f505010f = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed$volatile");
        f505011g = AtomicIntegerFieldUpdater.newUpdater(r0.class, "_isCompleted$volatile");
    }

    @Override // kotlinx.coroutines.q0
    public void shutdown() {
        ThreadLocal<q0> r100 = v1.f505154a;
        v1.f505154a.set(null);
        f505011g.set(this, 1);
        AtomicReferenceFieldUpdater r101 = f505009e;
    L3:
        Object r102 = r101.get(this);
        if (r102 == null) goto L5;
        if ((r102 instanceof kotlinx.coroutines.internal.q) == true) goto L16;
        if (r102 == t0.f505150b) goto L29;
        kotlinx.coroutines.internal.q r103 = new kotlinx.coroutines.internal.q(8, true);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r103.a((Runnable) r102);
        AtomicReferenceFieldUpdater r104 = f505009e;
    L22:
        if (r104.compareAndSet(this, r102, r103) == true) goto L23;
        if (r104.get(this) == r102) goto L22;
        boolean r105 = false;
    L27:
        if (r105 == false) goto L3;
    L23:
        r105 = true;
    L29:
        if (m() <= 0) goto L29;
        long r106 = System.nanoTime();
    L31:
        d r107 = (d) f505010f.get(this);
        if (r107 == null) goto L47;
        monitor-enter(r107);
    L44:
        th = move-exception;
        throw th;
    L35:
        if (r107.b() <= 0) goto L38;
        c r108 = r107.e(0);     // Catch: Throwable -> L44
    L39:
        monitor-exit(r107);
        c r109 = r108;
        if (r109 == null) goto L70;
        u(r106, r109);
        goto L31
    L70:
        return;
    L38:
        r108 = null;
        goto L39
    L47:
        return;
    L16:
        ((kotlinx.coroutines.internal.q) r102).b();
        goto L29
    L5:
        AtomicReferenceFieldUpdater r110 = f505009e;
        kotlinx.coroutines.internal.b0 r111 = t0.f505150b;
    L7:
        if (r110.compareAndSet(this, null, r111) == true) goto L8;
        if (r110.get(this) == null) goto L7;
        boolean r112 = false;
    L12:
        if (r112 == false) goto L3;
    L8:
        r112 = true;
        goto L12
    }

    public final boolean z() {
        ArrayDeque<i0<?>> r100 = this.f505006c;
        if (r100 == null) goto L5;
        boolean r101 = r100.isEmpty();
    L7:
        if (r101 == true) goto L9;
        return false;
    L9:
        d r102 = (d) f505010f.get(this);
        if (r102 != null) goto L12;
    L17:
        Object r103 = f505009e.get(this);
        if (r103 != null) goto L21;
        return true;
    L21:
        if ((r103 instanceof kotlinx.coroutines.internal.q) == false) goto L26;
        AtomicLongFieldUpdater r104 = kotlinx.coroutines.internal.q.f504973f;
        long r105 = r104.get((kotlinx.coroutines.internal.q) r103);
        if (((int) ((1073741823 & r105) >> 0)) == ((int) ((r105 & 1152921503533105152L) >> 30))) goto L31;
    L28:
        return false;
    L31:
        return true;
    L26:
        if (r103 != t0.f505150b) goto L28;
        return true;
    L12:
        if (r102.b() != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        return false;
    L14:
        r106 = false;
        goto L15
    L5:
        r101 = true;
        goto L7
    }

    public r0() {
        this._isCompleted$volatile = 0;
    }

    @Override // kotlinx.coroutines.q0
    public final long m() {
        if (n() == false) goto L5;
        return 0;
    L5:
        d r100 = (d) f505010f.get(this);
        Runnable r101 = null;
        boolean r102 = true;
        if (r100 != null) goto L8;
    L40:
        AtomicReferenceFieldUpdater r103 = f505009e;
    L41:
        Object r104 = r103.get(this);
        if (r104 == null) goto L68;
        if ((r104 instanceof kotlinx.coroutines.internal.q) == true) goto L46;
        if (r104 == t0.f505150b) goto L68;
        AtomicReferenceFieldUpdater r105 = f505009e;
    L61:
        if (r105.compareAndSet(this, r104, null) == true) goto L62;
        if (r105.get(this) == r104) goto L61;
        boolean r106 = false;
    L66:
        if (r106 == false) goto L41;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r101 = (Runnable) r104;
        goto L68
    L62:
        r106 = true;
        goto L66
    L46:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r107 = (kotlinx.coroutines.internal.q) r104;
        Object r108 = r107.d();
        if (r108 != kotlinx.coroutines.internal.q.f504974g) goto L48;
        AtomicReferenceFieldUpdater r109 = f505009e;
        kotlinx.coroutines.internal.q r110 = r107.c();
    L51:
        if (r109.compareAndSet(this, r104, r110) == true) goto L41;
        if (r109.get(this) == r104) goto L51;
    L48:
        r101 = (Runnable) r108;
    L68:
        if (r101 == null) goto L71;
        r101.run();
        return 0;
    L71:
        ArrayDeque<i0<?>> r111 = this.f505006c;
        if (r111 != null) goto L75;
    L76:
        long r112 = Long.MAX_VALUE;
    L79:
        if (r112 == 0) goto L122;
        Object r113 = f505009e.get(this);
        if (r113 != null) goto L84;
    L94:
        d r114 = (d) f505010f.get(this);
        if (r114 == null) goto L101;
        c r115 = r114.c();
        if (r115 == null) goto L101;
        return RangesKt.coerceAtLeast(r115.f505015a - System.nanoTime(), 0);
    L101:
        return Long.MAX_VALUE;
    L84:
        if ((r113 instanceof kotlinx.coroutines.internal.q) == false) goto L92;
        long r116 = kotlinx.coroutines.internal.q.f504973f.get((kotlinx.coroutines.internal.q) r113);
        if (((int) ((1073741823 & r116) >> 0)) == ((int) ((r116 & 1152921503533105152L) >> 30))) goto L89;
        r102 = false;
    L89:
        if (r102 == true) goto L94;
        return 0;
    L92:
        if (r113 == t0.f505150b) goto L101;
        return 0;
    L122:
        return 0;
    L75:
        if (r111.isEmpty() == true) goto L76;
        r112 = 0;
        goto L79
    L8:
        if (r100.b() != 0) goto L10;
        boolean r117 = true;
    L11:
        if (r117 == true) goto L40;
        long r118 = System.nanoTime();
    L13:
        monitor-enter(r100);
        Object[] r119 = r100.f504950a;     // Catch: Throwable -> L37
        if (r119 == null) goto L18;
        Object r120 = r119[0];     // Catch: Throwable -> L37
    L19:
        if (r120 != null) goto L22;
        monitor-exit(r100);
        c r121 = null;
    L35:
        if (r121 != null) goto L13;
    L22:
        c r122 = (c) r120;     // Catch: Throwable -> L37
        if ((r118 - r122.f505015a) < 0) goto L25;
        boolean r123 = true;
    L26:
        if (r123 == false) goto L28;
        boolean r124 = y(r122);     // Catch: Throwable -> L37
    L29:
        if (r124 == false) goto L32;
        r121 = r100.e(0);     // Catch: Throwable -> L37
    L33:
        monitor-exit(r100);
        goto L35
    L32:
        r121 = null;
        goto L33
    L28:
        r124 = false;
        goto L29
    L25:
        r123 = false;
        goto L26
    L18:
        r120 = null;
    L37:
        th = move-exception;
        throw th;
    L10:
        r117 = false;
        goto L11
    }

    public static final boolean w(r0 r100) {
        r100.getClass();
        if (f505011g.get(r100) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void x(Runnable r100) {
        if (y(r100) == false) goto L7;
        Thread r101 = q();
        if (ThreadMethodProxy.currentThread() == r101) goto L9;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r101));
        return;
    L9:
        return;
    L7:
        c0.f504641h.x(r100);
    }

    public final boolean y(Runnable r100) {
        AtomicReferenceFieldUpdater r101 = f505009e;
    L3:
        Object r102 = r101.get(this);
        boolean r103 = false;
        if (f505011g.get(this) == 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L8;
        if (r102 == null) goto L10;
        if ((r102 instanceof kotlinx.coroutines.internal.q) == true) goto L20;
        if (r102 == t0.f505150b) goto L37;
        kotlinx.coroutines.internal.q r105 = new kotlinx.coroutines.internal.q(8, true);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r105.a((Runnable) r102);
        r105.a(r100);
        AtomicReferenceFieldUpdater r106 = f505009e;
    L40:
        if (r106.compareAndSet(this, r102, r105) == true) goto L41;
        if (r106.get(this) == r102) goto L40;
    L44:
        if (r103 == false) goto L3;
        return true;
    L41:
        r103 = true;
        goto L44
    L37:
        return false;
    L20:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r107 = (kotlinx.coroutines.internal.q) r102;
        int r108 = r107.a(r100);
        if (r108 == 0) goto L34;
        if (r108 != 1) goto L24;
        AtomicReferenceFieldUpdater r109 = f505009e;
        kotlinx.coroutines.internal.q r110 = r107.c();
    L29:
        if (r109.compareAndSet(this, r102, r110) == true) goto L3;
        if (r109.get(this) == r102) goto L29;
    L24:
        if (r108 != 2) goto L3;
        return false;
    L34:
        return true;
    L10:
        AtomicReferenceFieldUpdater r111 = f505009e;
    L12:
        if (r111.compareAndSet(this, null, r100) == true) goto L13;
        if (r111.get(this) == null) goto L12;
    L16:
        if (r103 == false) goto L3;
        return true;
    L13:
        r103 = true;
        goto L16
    L8:
        return false;
    L6:
        r104 = false;
        goto L7
    }

    public final void A(long r100, c r101) {
        boolean r102 = false;
        if (f505011g.get(this) == 0) goto L5;
        boolean r103 = true;
    L6:
        c r104 = null;
        if (r103 == false) goto L9;
        int r105 = 1;
    L19:
        if (r105 == 0) goto L27;
        if (r105 != 1) goto L22;
        u(r100, r101);
        return;
    L22:
        if (r105 != 2) goto L25;
        return;
    L25:
        throw new IllegalStateException("unexpected result".toString());
    L27:
        d r106 = (d) f505010f.get(this);
        if (r106 == null) goto L30;
        r104 = r106.c();
    L30:
        if (r104 != r101) goto L32;
        r102 = true;
    L32:
        if (r102 == false) goto L41;
        Thread r107 = q();
        if (ThreadMethodProxy.currentThread() == r107) goto L42;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r107));
        return;
    L42:
        return;
    L41:
        return;
    L9:
        AtomicReferenceFieldUpdater r108 = f505010f;
        d r109 = (d) r108.get(this);
        if (r109 != null) goto L18;
        d r110 = new d(r100);
    L13:
        if (r108.compareAndSet(this, null, r110) == true) goto L17;
        if (r108.get(this) == null) goto L13;
    L17:
        Object r111 = f505010f.get(this);
        Intrinsics.checkNotNull(r111);
        r109 = (d) r111;
    L18:
        r105 = r101.d(r100, r109, this);
        goto L19
    L5:
        r103 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        x(r101);
    }

    @Override // kotlinx.coroutines.f0
    public final void scheduleResumeAfterDelay(long r100, i<? super Unit> r101) {
        long r102 = t0.a(r100);
        if (r102 >= 4611686018427387903L) goto L6;
        long r103 = System.nanoTime();
        j r104 = (j) r101;
        a r105 = new a(this, r102 + r103, r104);
        A(r103, r105);
        l.b(r104, new n0(r105));
        return;
    }

    public m0 invokeOnTimeout(long r100, Runnable r101, CoroutineContext r102) {
        return d0.f504706a.invokeOnTimeout(r100, r101, r102);
    }
}
