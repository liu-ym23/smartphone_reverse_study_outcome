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

/* JADX INFO: loaded from: classes.dex */
public class SemaphoreImpl implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505131c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505132d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505133e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505134f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505135g = null;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f505136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f505137b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        f505131c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head$volatile");
        f505132d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx$volatile");
        f505133e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail$volatile");
        f505134f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx$volatile");
        f505135g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits$volatile");
    }

    @Override // kotlinx.coroutines.sync.c
    public final void release() {
    L3:
        int r100 = f505135g.getAndIncrement(this);
        if (r100 >= this.f505136a) goto L69;
        if (r100 >= 0) goto L6;
        AtomicReferenceFieldUpdater r101 = f505131c;
        e r102 = (e) r101.get(this);
        long r103 = f505132d.getAndIncrement(this);
        long r104 = r103 / ((long) d.f505145f);
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r105 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
    L8:
        Object r106 = kotlinx.coroutines.internal.d.a(r102, r104, r105);
        if (z.b(r106) == true) goto L33;
        y r107 = z.a(r106);
    L11:
        y r110 = (y) r101.get(this);
        if (r110.f504984c >= r107.f504984c) goto L27;
        if (r107.j() == false) goto L16;
    L18:
        if (r101.compareAndSet(this, r110, r107) == true) goto L19;
        if (r101.get(this) == r110) goto L18;
        boolean r111 = false;
    L23:
        if (r111 == true) goto L25;
        if (r107.f() == false) goto L11;
        r107.e();
        goto L11
    L25:
        if (r110.f() == false) goto L27;
        r110.e();
        goto L27
    L19:
        r111 = true;
        goto L23
    L16:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L8;
    L27:
        r108 = true;
    L33:
        e r109 = (e) z.a(r106);
        r109.b();
        if (r109.f504984c > r104) goto L61;
        int r112 = (int) (r103 % ((long) d.f505145f));
        Object r113 = r109.f505146e.getAndSet(r112, d.f505141b);
        if (r113 != null) goto L53;
        int r114 = d.f505140a;
        int r115 = 0;
    L39:
        if (r115 >= r114) goto L44;
        if (r109.f505146e.get(r112) == d.f505142c) goto L60;
        r115 = r115 + 1;
    L60:
        boolean r116 = true;
    L65:
        if (r116 == false) goto L3;
        return;
    L44:
        b0 r117 = d.f505141b;
        b0 r118 = d.f505143d;
        AtomicReferenceArray r119 = r109.f505146e;
    L46:
        if (r119.compareAndSet(r112, r117, r118) == true) goto L47;
        if (r119.get(r112) == r117) goto L46;
        boolean r120 = true;
        boolean r121 = false;
    L51:
        r116 = r121 ^ r120;
        goto L65
    L47:
        r120 = true;
        r121 = true;
        goto L51
    L53:
        if (r113 == d.f505144e) goto L61;
        if ((r113 instanceof i) == false) goto L63;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        i r122 = (i) r113;
        b0 r123 = r122.b(Unit.INSTANCE, this.f505137b);
        if (r123 == null) goto L61;
        r122.d(r123);
        goto L60
    L63:
        if ((r113 instanceof l) == false) goto L68;
        r116 = ((l) r113).f(this, Unit.INSTANCE);
        goto L65
    L68:
        throw new IllegalStateException(("unexpected: " + r113).toString());
    L61:
        r116 = false;
        goto L65
    L6:
        return;
    L69:
        AtomicIntegerFieldUpdater r124 = f505135g;
        int r125 = r124.get(this);
        int r126 = this.f505136a;
        if (r125 <= r126) goto L75;
        if (r124.compareAndSet(this, r125, r126) == false) goto L69;
    L75:
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f505136a).toString());
    }

    public final Object c(Continuation<? super Unit> r100) {
    L2:
        int r101 = f505135g.getAndDecrement(this);
        if (r101 > this.f505136a) goto L2;
        if (r101 > 0) goto L29;
        j r102 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r100));
    L22:
        th = move-exception;
        r102.H();
        throw th;
    L8:
        if (e(r102) == true) goto L10;
        d(r102);     // Catch: Throwable -> L22
    L10:
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L14:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        Object r104 = r103;
    L18:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r104;
    L21:
        return Unit.INSTANCE;
    L16:
        r104 = Unit.INSTANCE;
        goto L18
    L29:
        return Unit.INSTANCE;
    }

    public final void d(i<? super Unit> r100) {
    L2:
        int r101 = f505135g.getAndDecrement(this);
        if (r101 > this.f505136a) goto L2;
        if (r101 > 0) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (e((d2) r100) == false) goto L2;
        return;
    L5:
        r100.h(Unit.INSTANCE, this.f505137b);
    }

    public final boolean e(d2 r110) {
        AtomicReferenceFieldUpdater r100 = f505133e;
        e r101 = (e) r100.get(this);
        long r102 = f505134f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r103 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long r104 = r102 / ((long) d.f505145f);
    L3:
        Object r105 = kotlinx.coroutines.internal.d.a(r101, r104, r103);
        if (z.b(r105) == true) goto L28;
        y r111 = z.a(r105);
    L6:
        y r112 = (y) r100.get(this);
        if (r112.f504984c >= r111.f504984c) goto L22;
        if (r111.j() == false) goto L11;
    L13:
        if (r100.compareAndSet(this, r112, r111) == true) goto L14;
        if (r100.get(this) == r112) goto L13;
        boolean r113 = false;
    L18:
        if (r113 == true) goto L20;
        if (r111.f() == false) goto L6;
        r111.e();
        goto L6
    L20:
        if (r112.f() == false) goto L22;
        r112.e();
        goto L22
    L14:
        r113 = true;
        goto L18
    L11:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L3;
    L22:
        r114 = true;
    L28:
        e r106 = (e) z.a(r105);
        int r107 = (int) (r102 % ((long) d.f505145f));
        AtomicReferenceArray r108 = r106.f505146e;
    L30:
        if (r108.compareAndSet(r107, null, r110) == true) goto L31;
        if (r108.get(r107) == null) goto L30;
        boolean r109 = false;
    L35:
        if (r109 == false) goto L38;
        r110.e(r106, r107);
        return true;
    L38:
        b0 r115 = d.f505141b;
        b0 r116 = d.f505142c;
        AtomicReferenceArray r117 = r106.f505146e;
    L40:
        if (r117.compareAndSet(r107, r115, r116) == true) goto L41;
        if (r117.get(r107) == r115) goto L40;
        boolean r118 = false;
    L45:
        if (r118 == true) goto L47;
        return false;
    L47:
        if ((r110 instanceof i) == false) goto L50;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((i) r110).h(Unit.INSTANCE, this.f505137b);
        return true;
    L50:
        if ((r110 instanceof l) == false) goto L55;
        ((l) r110).c(Unit.INSTANCE);
        return true;
    L55:
        throw new IllegalStateException(("unexpected: " + r110).toString());
    L41:
        r118 = true;
        goto L45
    L31:
        r109 = true;
        goto L35
    }

    public SemaphoreImpl(int r100, int r101) {
        this.f505136a = r100;
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L17;
        if (r101 < 0) goto L10;
        if (r101 > r100) goto L10;
    L11:
        if (r102 == false) goto L15;
        e r104 = new e(0, null, 2);
        this.head$volatile = r104;
        this.tail$volatile = r104;
        this._availablePermits$volatile = r100 - r101;
        this.f505137b = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r100).toString());
    L10:
        r102 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r100).toString());
    L5:
        r103 = false;
        goto L6
    }
}
