package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.selects.m;

/* JADX INFO: loaded from: classes.dex */
public final class MutexImpl extends SemaphoreImpl implements kotlinx.coroutines.sync.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505124h = null;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: loaded from: classes5.dex */
    public final class a implements i<Unit>, d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j<Unit> f505125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f505126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MutexImpl f505127c;

        @Override // kotlinx.coroutines.i
        public final boolean cancel(Throwable r100) {
            return this.f505125a.cancel(r100);
        }

        @Override // kotlinx.coroutines.i
        public final void d(Object r100) {
            this.f505125a.d(r100);
        }

        @Override // kotlinx.coroutines.d2
        public final void e(y<?> r100, int r101) {
            this.f505125a.e(r100, r101);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f505125a.getContext();
        }

        @Override // kotlinx.coroutines.i
        public final void i(Function1<? super Throwable, Unit> r100) {
            this.f505125a.i(r100);
        }

        @Override // kotlinx.coroutines.i
        public final boolean isActive() {
            return this.f505125a.isActive();
        }

        @Override // kotlinx.coroutines.i
        public final boolean isCancelled() {
            return this.f505125a.isCancelled();
        }

        @Override // kotlinx.coroutines.i
        public final boolean isCompleted() {
            return this.f505125a.isCompleted();
        }

        @Override // kotlinx.coroutines.i
        public final b0 m(Throwable r100) {
            return this.f505125a.m(r100);
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            this.f505125a.resumeWith(r100);
        }

        @Override // kotlinx.coroutines.i
        public final b0 b(Object r100, Function1 r101) {
            final MutexImpl r102 = this.f505127c;
            j<Unit> r103 = this.f505125a;
            b0 r104 = r103.N((Unit) r100, null, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(r102, this));
            if (r104 == null) goto L5;
            MutexImpl r105 = this.f505127c;
            MutexImpl.f505124h.set(r105, this.f505126b);
        L5:
            return r104;
        }

        @Override // kotlinx.coroutines.i
        public final void f(CoroutineDispatcher r100, Unit r101) {
            j<Unit> r102 = this.f505125a;
            r102.f(r100, r101);
        }

        @Override // kotlinx.coroutines.i
        public final void h(Unit r100, Function1 r101) {
            MutexImpl r102 = this.f505127c;
            MutexImpl.f505124h.set(r102, this.f505126b);
            j<Unit> r103 = this.f505125a;
            final MutexImpl r104 = this.f505127c;
            r103.h(r100, new MutexImpl$CancellableContinuationWithOwner$resume$2(r104, this));
        }

        @Override // kotlinx.coroutines.i
        public final b0 l(Object r100, Object r101) {
            j<Unit> r102 = this.f505125a;
            return r102.N((Unit) r100, r101, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(MutexImpl r100, j<? super Unit> r101, Object r102) {
            this.f505127c = r100;
            this.f505125a = r101;
            this.f505126b = r102;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public final class b<Q> implements m<Q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m<Q> f505128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f505129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MutexImpl f505130c;

        @Override // kotlinx.coroutines.selects.l
        public final void b(m0 r100) {
            this.f505128a.b(r100);
        }

        @Override // kotlinx.coroutines.d2
        public final void e(y<?> r100, int r101) {
            this.f505128a.e(r100, r101);
        }

        @Override // kotlinx.coroutines.selects.m, kotlinx.coroutines.selects.l
        public CoroutineContext getContext() {
            return this.f505128a.getContext();
        }

        @Override // kotlinx.coroutines.selects.l
        public final void c(Object r100) {
            MutexImpl r101 = this.f505130c;
            MutexImpl.f505124h.set(r101, this.f505129b);
            this.f505128a.c(r100);
        }

        @Override // kotlinx.coroutines.selects.l
        public final boolean f(Object r100, Object r101) {
            boolean r102 = this.f505128a.f(r100, r101);
            MutexImpl r103 = this.f505130c;
            if (r102 == false) goto L5;
            MutexImpl.f505124h.set(r103, this.f505129b);
        L5:
            return r102;
        }

        public b(MutexImpl r100, m<Q> r101, Object r102) {
            this.f505130c = r100;
            this.f505128a = r101;
            this.f505129b = r102;
        }
    }

    static {
        f505124h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    }

    @Override // kotlinx.coroutines.sync.a
    public final boolean isLocked() {
        if (Math.max(SemaphoreImpl.f505135g.get(this), 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        return "Mutex@" + kotlinx.coroutines.b0.a(this) + "[isLocked=" + isLocked() + ",owner=" + f505124h.get(this) + ']';
    }

    public MutexImpl(boolean r100) {
        super(1, r100 ? 1 : 0);
        if (r100 == false) goto L5;
        b0 r101 = null;
    L6:
        this.owner$volatile = r101;
        new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
        return;
    L5:
        r101 = kotlinx.coroutines.sync.b.f505138a;
        goto L6
    }

    @Override // kotlinx.coroutines.sync.a
    public final boolean b(Object r100) {
    L2:
        AtomicIntegerFieldUpdater r101 = SemaphoreImpl.f505135g;
        int r102 = r101.get(this);
        if (r102 > this.f505136a) goto L4;
        if (r102 <= 0) goto L11;
        if (r101.compareAndSet(this, r102, r102 - 1) == false) goto L2;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L17;
        if (r100 == null) goto L31;
    L21:
        if (isLocked() == false) goto L22;
        Object r104 = f505124h.get(this);
        if (r104 == kotlinx.coroutines.sync.b.f505138a) goto L21;
        if (r104 != r100) goto L27;
        char r105 = 1;
    L28:
        if (r105 == 1) goto L32;
        if (r105 == 2) goto L31;
    L32:
        char r106 = 2;
    L33:
        if (r106 == 0) goto L40;
        if (r106 == 1) goto L59;
        if (r106 == 2) goto L39;
        throw new IllegalStateException("unexpected".toString());
    L39:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r100).toString());
    L59:
        return false;
    L40:
        return true;
    L27:
        r105 = 2;
        goto L28
    L22:
        r105 = 0;
    L31:
        r106 = 1;
        goto L33
    L17:
        f505124h.set(this, r100);
        r106 = 0;
        goto L33
    L11:
        r103 = false;
    L4:
        AtomicIntegerFieldUpdater r107 = SemaphoreImpl.f505135g;
        int r108 = r107.get(this);
        int r109 = this.f505136a;
        if (r108 <= r109) goto L2;
        if (r107.compareAndSet(this, r108, r109) == false) goto L4;
        goto L2
    }

    @Override // kotlinx.coroutines.sync.a
    public final void unlock(Object r100) {
    L3:
        if (isLocked() == false) goto L25;
        AtomicReferenceFieldUpdater r101 = f505124h;
        Object r102 = r101.get(this);
        b0 r103 = kotlinx.coroutines.sync.b.f505138a;
        if (r102 == r103) goto L3;
        boolean r104 = true;
        if (r102 == r100) goto L11;
        if (r100 == null) goto L11;
        boolean r105 = false;
    L12:
        if (r105 == false) goto L23;
    L14:
        if (r101.compareAndSet(this, r102, r103) == true) goto L19;
        if (r101.get(this) == r102) goto L14;
        r104 = false;
    L19:
        if (r104 == false) goto L3;
        release();
        return;
    L23:
        throw new IllegalStateException(("This mutex is locked by " + r102 + ", but " + r100 + " is expected").toString());
    L11:
        r105 = true;
        goto L12
    L25:
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public final Object a(Object r100, Continuation<? super Unit> r101) {
        if (b(r100) == true) goto L24;
        j r102 = l.a(IntrinsicsKt.intercepted(r101));
        d(new a(this, r102, r100));     // Catch: Throwable -> L19
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L11:
        if (r103 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r103 = Unit.INSTANCE;
    L15:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r103;
    L18:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        r102.H();
        throw th;
    L24:
        return Unit.INSTANCE;
    }
}
