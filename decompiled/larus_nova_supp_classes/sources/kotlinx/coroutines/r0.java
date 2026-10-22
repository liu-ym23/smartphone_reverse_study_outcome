package kotlinx.coroutines;

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
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class r0 extends s0 implements f0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue$volatile");
        f = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(r0.class, "_isCompleted$volatile");
    }

    @Override // kotlinx.coroutines.q0
    public void shutdown() {
        ThreadLocal<q0> r0 = v1.a;
        v1.a.set(null);
        g.set(this, 1);
        AtomicReferenceFieldUpdater r1 = e;
    L3:
        Object r3 = r1.get(this);
        if (r3 == null) goto L5;
        if ((r3 instanceof kotlinx.coroutines.internal.q) == true) goto L16;
        if (r3 == t0.b) goto L29;
        kotlinx.coroutines.internal.q r5 = new kotlinx.coroutines.internal.q(8, true);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r5.a((Runnable) r3);
        AtomicReferenceFieldUpdater r6 = e;
    L22:
        if (r6.compareAndSet(this, r3, r5) == true) goto L23;
        if (r6.get(this) == r3) goto L22;
        boolean r4 = false;
    L27:
        if (r4 == false) goto L3;
    L23:
        r4 = true;
    L29:
        if (m() <= 0) goto L29;
        long r2 = System.nanoTime();
    L31:
        d r7 = (d) f.get(this);
        if (r7 == null) goto L47;
        monitor-enter(r7);
    L44:
        th = move-exception;
        throw th;
    L35:
        if (r7.b() <= 0) goto L38;
        h0 r8 = r7.e(0);     // Catch: Throwable -> L44
    L39:
        monitor-exit(r7);
        c r9 = (c) r8;
        if (r9 == null) goto L70;
        u(r2, r9);
        goto L31
    L70:
        return;
    L38:
        r8 = null;
        goto L39
    L47:
        return;
    L16:
        ((kotlinx.coroutines.internal.q) r3).b();
        goto L29
    L5:
        AtomicReferenceFieldUpdater r10 = e;
        b0 r11 = t0.b;
    L7:
        if (r10.compareAndSet(this, null, r11) == true) goto L8;
        if (r10.get(this) == null) goto L7;
        boolean r12 = false;
    L12:
        if (r12 == false) goto L3;
    L8:
        r12 = true;
        goto L12
    }

    public final boolean z() {
        ArrayDeque<i0<?>> r0 = this.c;
        if (r0 == null) goto L5;
        boolean r1 = r0.isEmpty();
    L7:
        if (r1 == true) goto L9;
        return false;
    L9:
        d r2 = (d) f.get(this);
        if (r2 != null) goto L12;
    L17:
        Object r3 = e.get(this);
        if (r3 != null) goto L21;
        return true;
    L21:
        if ((r3 instanceof kotlinx.coroutines.internal.q) == false) goto L26;
        AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.q.f;
        long r5 = r4.get((kotlinx.coroutines.internal.q) r3);
        if (((int) ((1073741823 & r5) >> 0)) == ((int) ((r5 & 1152921503533105152L) >> 30))) goto L31;
    L28:
        return false;
    L31:
        return true;
    L26:
        if (r3 != t0.b) goto L28;
        return true;
    L12:
        if (r2.b() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        return false;
    L14:
        r6 = false;
        goto L15
    L5:
        r1 = true;
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
        d r0 = (d) f.get(this);
        Runnable r3 = null;
        boolean r4 = true;
        if (r0 != null) goto L8;
    L40:
        AtomicReferenceFieldUpdater r1 = e;
    L41:
        Object r6 = r1.get(this);
        if (r6 == null) goto L68;
        if ((r6 instanceof kotlinx.coroutines.internal.q) == true) goto L46;
        if (r6 == t0.b) goto L68;
        AtomicReferenceFieldUpdater r7 = e;
    L61:
        if (r7.compareAndSet(this, r6, null) == true) goto L62;
        if (r7.get(this) == r6) goto L61;
        boolean r8 = false;
    L66:
        if (r8 == false) goto L41;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r3 = (Runnable) r6;
        goto L68
    L62:
        r8 = true;
        goto L66
    L46:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r9 = (kotlinx.coroutines.internal.q) r6;
        Object r10 = r9.d();
        if (r10 != kotlinx.coroutines.internal.q.g) goto L48;
        AtomicReferenceFieldUpdater r11 = e;
        kotlinx.coroutines.internal.q r12 = r9.c();
    L51:
        if (r11.compareAndSet(this, r6, r12) == true) goto L41;
        if (r11.get(this) == r6) goto L51;
    L48:
        r3 = (Runnable) r10;
    L68:
        if (r3 == null) goto L71;
        r3.run();
        return 0;
    L71:
        ArrayDeque<i0<?>> r2 = this.c;
        if (r2 != null) goto L75;
    L76:
        long r13 = Long.MAX_VALUE;
    L79:
        if (r13 == 0) goto L122;
        Object r5 = e.get(this);
        if (r5 != null) goto L84;
    L94:
        d r14 = (d) f.get(this);
        if (r14 == null) goto L101;
        c r15 = r14.c();
        if (r15 == null) goto L101;
        return RangesKt.coerceAtLeast(r15.a - System.nanoTime(), 0);
    L101:
        return Long.MAX_VALUE;
    L84:
        if ((r5 instanceof kotlinx.coroutines.internal.q) == false) goto L92;
        long r16 = kotlinx.coroutines.internal.q.f.get((kotlinx.coroutines.internal.q) r5);
        if (((int) ((1073741823 & r16) >> 0)) == ((int) ((r16 & 1152921503533105152L) >> 30))) goto L89;
        r4 = false;
    L89:
        if (r4 == true) goto L94;
        return 0;
    L92:
        if (r5 == t0.b) goto L101;
        return 0;
    L122:
        return 0;
    L75:
        if (r2.isEmpty() == true) goto L76;
        r13 = 0;
        goto L79
    L8:
        if (r0.b() != 0) goto L10;
        boolean r17 = true;
    L11:
        if (r17 == true) goto L40;
        long r18 = System.nanoTime();
    L13:
        monitor-enter(r0);
        c[] r19 = ((g0) r0).a;     // Catch: Throwable -> L37
        if (r19 == null) goto L18;
        c r20 = r19[0];     // Catch: Throwable -> L37
    L19:
        if (r20 != null) goto L22;
        monitor-exit(r0);
        c r21 = null;
    L35:
        if (r21 != null) goto L13;
    L22:
        c r22 = r20;     // Catch: Throwable -> L37
        if ((r18 - r22.a) < 0) goto L25;
        boolean r23 = true;
    L26:
        if (r23 == false) goto L28;
        boolean r24 = y(r22);     // Catch: Throwable -> L37
    L29:
        if (r24 == false) goto L32;
        r21 = r0.e(0);     // Catch: Throwable -> L37
    L33:
        monitor-exit(r0);
        goto L35
    L32:
        r21 = null;
        goto L33
    L28:
        r24 = false;
        goto L29
    L25:
        r23 = false;
        goto L26
    L18:
        r20 = null;
    L37:
        th = move-exception;
        throw th;
    L10:
        r17 = false;
        goto L11
    }

    public static final boolean w(r0 r1) {
        r1.getClass();
        if (g.get(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void x(Runnable r2) {
        if (y(r2) == false) goto L7;
        Thread r3 = q();
        if (ThreadMethodProxy.currentThread() == r3) goto L9;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r3));
        return;
    L9:
        return;
    L7:
        c0.h.x(r2);
    }

    public final boolean y(Runnable r8) {
        AtomicReferenceFieldUpdater r0 = e;
    L3:
        Object r1 = r0.get(this);
        boolean r3 = false;
        if (g.get(this) == 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L8;
        if (r1 == null) goto L10;
        if ((r1 instanceof kotlinx.coroutines.internal.q) == true) goto L20;
        if (r1 == t0.b) goto L37;
        kotlinx.coroutines.internal.q r4 = new kotlinx.coroutines.internal.q(8, true);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r4.a((Runnable) r1);
        r4.a(r8);
        AtomicReferenceFieldUpdater r5 = e;
    L40:
        if (r5.compareAndSet(this, r1, r4) == true) goto L41;
        if (r5.get(this) == r1) goto L40;
    L44:
        if (r3 == false) goto L3;
        return true;
    L41:
        r3 = true;
        goto L44
    L37:
        return false;
    L20:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r6 = (kotlinx.coroutines.internal.q) r1;
        int r7 = r6.a(r8);
        if (r7 == 0) goto L34;
        if (r7 != 1) goto L24;
        AtomicReferenceFieldUpdater r9 = e;
        kotlinx.coroutines.internal.q r10 = r6.c();
    L29:
        if (r9.compareAndSet(this, r1, r10) == true) goto L3;
        if (r9.get(this) == r1) goto L29;
    L24:
        if (r7 != 2) goto L3;
        return false;
    L34:
        return true;
    L10:
        AtomicReferenceFieldUpdater r11 = e;
    L12:
        if (r11.compareAndSet(this, null, r8) == true) goto L13;
        if (r11.get(this) == null) goto L12;
    L16:
        if (r3 == false) goto L3;
        return true;
    L13:
        r3 = true;
        goto L16
    L8:
        return false;
    L6:
        r2 = false;
        goto L7
    }

    public final void A(long r7, c r9) {
        boolean r1 = false;
        if (g.get(this) == 0) goto L5;
        boolean r0 = true;
    L6:
        c r3 = null;
        if (r0 == false) goto L9;
        int r2 = 1;
    L19:
        if (r2 == 0) goto L27;
        if (r2 != 1) goto L22;
        u(r7, r9);
        return;
    L22:
        if (r2 != 2) goto L25;
        return;
    L25:
        throw new IllegalStateException("unexpected result".toString());
    L27:
        d r8 = (d) f.get(this);
        if (r8 == null) goto L30;
        r3 = (c) r8.c();
    L30:
        if (r3 != r9) goto L32;
        r1 = true;
    L32:
        if (r1 == false) goto L41;
        Thread r10 = q();
        if (ThreadMethodProxy.currentThread() == r10) goto L42;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r10));
        return;
    L42:
        return;
    L41:
        return;
    L9:
        AtomicReferenceFieldUpdater r4 = f;
        d r5 = (d) r4.get(this);
        if (r5 != null) goto L18;
        d r6 = new d(r7);
    L13:
        if (r4.compareAndSet(this, null, r6) == true) goto L17;
        if (r4.get(this) == null) goto L13;
    L17:
        Object r11 = f.get(this);
        Intrinsics.checkNotNull(r11);
        r5 = (d) r11;
    L18:
        r2 = r9.d(r7, r5, this);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r1, Runnable r2) {
        x(r2);
    }

    @Override // kotlinx.coroutines.f0
    public final void scheduleResumeAfterDelay(long r4, i<? super Unit> r6) {
        long r5 = t0.a(r4);
        if (r5 >= 4611686018427387903L) goto L6;
        long r0 = System.nanoTime();
        j r7 = (j) r6;
        a r2 = new a(this, r5 + r0, r7);
        A(r0, r2);
        l.b(r7, new n0(r2));
        return;
    }

    public m0 invokeOnTimeout(long r2, Runnable r4, CoroutineContext r5) {
        return d0.a.invokeOnTimeout(r2, r4, r5);
    }
}
