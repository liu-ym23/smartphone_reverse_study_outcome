package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.j;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SemaphoreImpl implements c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    public static final /* synthetic */ AtomicLongFieldUpdater d = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    public static final /* synthetic */ AtomicLongFieldUpdater f = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ int _availablePermits$volatile;
    public final int a;
    public final Function1<Throwable, Unit> b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head$volatile");
        d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail$volatile");
        f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits$volatile");
    }

    @Override // kotlinx.coroutines.sync.c
    public final void release() {
    L3:
        int r1 = g.getAndIncrement(this);
        if (r1 >= this.a) goto L69;
        if (r1 >= 0) goto L6;
        AtomicReferenceFieldUpdater r2 = c;
        e r3 = (e) r2.get(this);
        long r4 = d.getAndIncrement(this);
        long r5 = r4 / ((long) d.f);
        tryResumeNextFromQueue.createNewSegment.1 r7 = tryResumeNextFromQueue.createNewSegment.1.INSTANCE;
    L8:
        Object r8 = kotlinx.coroutines.internal.d.a(r3, r5, r7);
        if (z.b(r8) == true) goto L33;
        y r9 = z.a(r8);
    L11:
        y r12 = (y) r2.get(this);
        if (r12.c >= r9.c) goto L27;
        if (r9.j() == false) goto L16;
    L18:
        if (r2.compareAndSet(this, r12, r9) == true) goto L19;
        if (r2.get(this) == r12) goto L18;
        boolean r10 = false;
    L23:
        if (r10 == true) goto L25;
        if (r9.f() == false) goto L11;
        r9.e();
        goto L11
    L25:
        if (r12.f() == false) goto L27;
        r12.e();
        goto L27
    L19:
        r10 = true;
        goto L23
    L16:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L8;
    L27:
        r11 = true;
    L33:
        e r6 = (e) z.a(r8);
        r6.b();
        if (r6.c > r5) goto L61;
        int r13 = (int) (r4 % ((long) d.f));
        Object r14 = r6.e.getAndSet(r13, d.b);
        if (r14 != null) goto L53;
        int r15 = d.a;
        int r16 = 0;
    L39:
        if (r16 >= r15) goto L44;
        if (r6.e.get(r13) == d.c) goto L60;
        r16 = r16 + 1;
    L60:
        boolean r17 = true;
    L65:
        if (r17 == false) goto L3;
        return;
    L44:
        b0 r18 = d.b;
        b0 r19 = d.d;
        AtomicReferenceArray r20 = r6.e;
    L46:
        if (r20.compareAndSet(r13, r18, r19) == true) goto L47;
        if (r20.get(r13) == r18) goto L46;
        boolean r21 = true;
        boolean r110 = false;
    L51:
        r17 = r110 ^ r21;
        goto L65
    L47:
        r21 = true;
        r110 = true;
        goto L51
    L53:
        if (r14 == d.e) goto L61;
        if ((r14 instanceof i) == false) goto L63;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        i r22 = (i) r14;
        b0 r23 = r22.b(Unit.INSTANCE, this.b);
        if (r23 == null) goto L61;
        r22.d(r23);
        goto L60
    L63:
        if ((r14 instanceof l) == false) goto L68;
        r17 = ((l) r14).f(this, Unit.INSTANCE);
        goto L65
    L68:
        throw new IllegalStateException(("unexpected: " + r14).toString());
    L61:
        r17 = false;
        goto L65
    L6:
        return;
    L69:
        AtomicIntegerFieldUpdater r24 = g;
        int r25 = r24.get(this);
        int r26 = this.a;
        if (r25 <= r26) goto L75;
        if (r24.compareAndSet(this, r25, r26) == false) goto L69;
    L75:
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.a).toString());
    }

    public final Object c(Continuation<? super Unit> r3) {
    L2:
        int r0 = g.getAndDecrement(this);
        if (r0 > this.a) goto L2;
        if (r0 > 0) goto L29;
        j r1 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r3));
    L22:
        th = move-exception;
        r1.H();
        throw th;
    L8:
        if (e(r1) == true) goto L10;
        d(r1);     // Catch: Throwable -> L22
    L10:
        Object r2 = r1.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L14:
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        Object r4 = r2;
    L18:
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r4;
    L21:
        return Unit.INSTANCE;
    L16:
        r4 = Unit.INSTANCE;
        goto L18
    L29:
        return Unit.INSTANCE;
    }

    public final void d(i<? super Unit> r3) {
    L2:
        int r0 = g.getAndDecrement(this);
        if (r0 > this.a) goto L2;
        if (r0 > 0) goto L5;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (e((d2) r3) == false) goto L2;
        return;
    L5:
        r3.h(Unit.INSTANCE, this.b);
    }

    public final boolean e(d2 r18) {
        AtomicReferenceFieldUpdater r2 = e;
        e r3 = (e) r2.get(this);
        long r4 = f.getAndIncrement(this);
        addAcquireToQueue.createNewSegment.1 r6 = addAcquireToQueue.createNewSegment.1.INSTANCE;
        long r7 = r4 / ((long) d.f);
    L3:
        Object r9 = kotlinx.coroutines.internal.d.a(r3, r7, r6);
        if (z.b(r9) == true) goto L28;
        y r10 = z.a(r9);
    L6:
        y r13 = (y) r2.get(this);
        if (r13.c >= r10.c) goto L22;
        if (r10.j() == false) goto L11;
    L13:
        if (r2.compareAndSet(this, r13, r10) == true) goto L14;
        if (r2.get(this) == r13) goto L13;
        boolean r11 = false;
    L18:
        if (r11 == true) goto L20;
        if (r10.f() == false) goto L6;
        r10.e();
        goto L6
    L20:
        if (r13.f() == false) goto L22;
        r13.e();
        goto L22
    L14:
        r11 = true;
        goto L18
    L11:
        boolean r12 = false;
    L23:
        if (r12 == false) goto L3;
    L22:
        r12 = true;
    L28:
        e r5 = (e) z.a(r9);
        int r8 = (int) (r4 % ((long) d.f));
        AtomicReferenceArray r14 = r5.e;
    L30:
        if (r14.compareAndSet(r8, null, r18) == true) goto L31;
        if (r14.get(r8) == null) goto L30;
        boolean r15 = false;
    L35:
        if (r15 == false) goto L38;
        r18.e(r5, r8);
        return true;
    L38:
        b0 r16 = d.b;
        b0 r17 = d.c;
        AtomicReferenceArray r19 = r5.e;
    L40:
        if (r19.compareAndSet(r8, r16, r17) == true) goto L41;
        if (r19.get(r8) == r16) goto L40;
        boolean r20 = false;
    L45:
        if (r20 == true) goto L47;
        return false;
    L47:
        if ((r18 instanceof i) == false) goto L50;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((i) r18).h(Unit.INSTANCE, this.b);
        return true;
    L50:
        if ((r18 instanceof l) == false) goto L55;
        ((l) r18).c(Unit.INSTANCE);
        return true;
    L55:
        throw new IllegalStateException(("unexpected: " + r18).toString());
    L41:
        r20 = true;
        goto L45
    L31:
        r15 = true;
        goto L35
    }

    public SemaphoreImpl(int r6, int r7) {
        this.a = r6;
        boolean r0 = true;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r7 < 0) goto L10;
        if (r7 > r6) goto L10;
    L11:
        if (r0 == false) goto L15;
        e r1 = new e(0, null, 2);
        this.head$volatile = r1;
        this.tail$volatile = r1;
        this._availablePermits$volatile = r6 - r7;
        this.b = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r6).toString());
    L10:
        r0 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }
}
