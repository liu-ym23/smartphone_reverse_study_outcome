package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class j<T> extends i0<T> implements i<T>, CoroutineStackFrame, d2 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final Continuation<T> d;
    public final CoroutineContext e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(j.class, "_decisionAndIndex$volatile");
        g = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_state$volatile");
        h = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_parentHandle$volatile");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final String toString() {
        return "CancellableContinuation";
    }

    public final boolean F() {
        if (this.c != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        Continuation<T> r1 = this.d;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.i) r1;
        r2.getClass();
        if (kotlinx.coroutines.internal.i.h.get(r2) == null) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return true;
    L10:
        r3 = false;
    L13:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final void H() {
        Continuation<T> r0 = this.d;
        Throwable r2 = null;
        if ((r0 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.i) r0;
    L6:
        if (r1 == null) goto L38;
        AtomicReferenceFieldUpdater r3 = kotlinx.coroutines.internal.i.h;
    L8:
        Object r4 = r3.get(r1);
        b0 r5 = kotlinx.coroutines.internal.j.b;
        boolean r6 = true;
        if (r4 != r5) goto L20;
        AtomicReferenceFieldUpdater r7 = kotlinx.coroutines.internal.i.h;
    L12:
        if (r7.compareAndSet(r1, r5, this) == true) goto L17;
        if (r7.get(r1) == r5) goto L12;
        r6 = false;
    L17:
        if (r6 == false) goto L8;
    L30:
        if (r2 == null) goto L49;
        y();
        cancel(r2);
        return;
    L49:
        return;
    L20:
        if ((r4 instanceof Throwable) == false) goto L37;
        AtomicReferenceFieldUpdater r8 = kotlinx.coroutines.internal.i.h;
    L23:
        if (r8.compareAndSet(r1, r4, null) == true) goto L28;
        if (r8.get(r1) == r4) goto L23;
        r6 = false;
    L28:
        if (r6 == false) goto L35;
        r2 = (Throwable) r4;
        goto L30
    L35:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L37:
        throw new IllegalStateException(("Inconsistent state " + r4).toString());
    L38:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r0 = this.d;
        if ((r0 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r0;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isActive() {
        return g.get(this) instanceof m1;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isCancelled() {
        return g.get(this) instanceof m;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isCompleted() {
        return !(g.get(this) instanceof m1);
    }

    @Override // kotlinx.coroutines.i0
    public final Object s() {
        return g.get(this);
    }

    public final void y() {
        AtomicReferenceFieldUpdater r0 = h;
        m0 r1 = (m0) r0.get(this);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.dispose();
        r0.set(this, l1.a);
    }

    public final Object B() {
        boolean r0 = F();
        AtomicIntegerFieldUpdater r1 = f;
    L3:
        int r2 = r1.get(this);
        int r3 = r2 >> 29;
        boolean r4 = false;
        if (r3 != 0) goto L5;
        if (f.compareAndSet(this, r2, (536870911 & r2) + 536870912) == false) goto L3;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        if (r0 == false) goto L22;
        H();
    L22:
        Object r6 = g.get(this);
        if ((r6 instanceof t) == true) goto L39;
        int r7 = this.c;
        if (r7 == 1) goto L27;
        if (r7 == 2) goto L27;
    L28:
        if (r4 == false) goto L37;
        Job r8 = (Job) getContext().get(Job.Key);
        if (r8 == null) goto L37;
        if (r8.isActive() == true) goto L37;
        CancellationException r9 = r8.getCancellationException();
        a(r6, r9);
        throw r9;
    L37:
        return n(r6);
    L27:
        r4 = true;
        goto L28
    L39:
        throw ((t) r6).a;
    L14:
        if (((m0) h.get(this)) != null) goto L16;
        D();
    L16:
        if (r0 == false) goto L19;
        H();
    L19:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        if (r3 != 2) goto L8;
        r5 = false;
        goto L12
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    public final void C() {
        m0 r0 = D();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isCompleted() == false) goto L9;
        r0.dispose();
        h.set(this, l1.a);
        return;
    }

    public final m0 D() {
        Job r1 = (Job) getContext().get(Job.Key);
        if (r1 != null) goto L5;
        return null;
    L5:
        m0 r2 = JobKt.invokeOnCompletion$default(r1, true, false, new n(this), 2, null);
        AtomicReferenceFieldUpdater r3 = h;
    L7:
        if (r3.compareAndSet(this, null, r2) == true) goto L11;
        if (r3.get(this) == null) goto L7;
    L11:
        return r2;
    }

    @Override // kotlinx.coroutines.i0
    public final Continuation<T> c() {
        return this.d;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.e;
    }

    public Throwable A(JobSupport r1) {
        return r1.getCancellationException();
    }

    public final void E(Object r13) {
        AtomicReferenceFieldUpdater r0 = g;
    L3:
        Object r8 = r0.get(this);
        boolean r9 = false;
        if ((r8 instanceof b) == true) goto L5;
        if ((r8 instanceof h) == false) goto L16;
        boolean r1 = true;
    L17:
        Throwable r2 = null;
        if (r1 == true) goto L72;
        boolean r3 = r8 instanceof t;
        if (r3 == true) goto L21;
        if ((r8 instanceof s) == true) goto L39;
        if ((r13 instanceof y) == true) goto L63;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        s r11 = new s(r8, (h) r13, null, null, null, 28);
        AtomicReferenceFieldUpdater r4 = g;
    L66:
        if (r4.compareAndSet(this, r8, r11) == true) goto L67;
        if (r4.get(this) == r8) goto L66;
    L70:
        if (r9 == false) goto L3;
        return;
    L67:
        r9 = true;
        goto L70
    L63:
        return;
    L39:
        s r5 = (s) r8;
        if (r5.b != null) goto L59;
        if ((r13 instanceof y) == true) goto L43;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        h r6 = (h) r13;
        Throwable r7 = r5.e;
        if (r7 == null) goto L47;
        boolean r10 = true;
    L48:
        if (r10 == true) goto L49;
        s r12 = s.a(r5, r6, null, 29);
        AtomicReferenceFieldUpdater r14 = g;
    L53:
        if (r14.compareAndSet(this, r8, r12) == true) goto L54;
        if (r14.get(this) == r8) goto L53;
    L57:
        if (r9 == false) goto L3;
        return;
    L54:
        r9 = true;
        goto L57
    L49:
        u(r6, r7);
        return;
    L47:
        r10 = false;
        goto L48
    L43:
        return;
    L59:
        G(r13, r8);
        throw null;
    L21:
        t r15 = (t) r8;
        r15.getClass();
        if (t.b.compareAndSet(r15, 0, 1) == true) goto L24;
        G(r13, r8);
        throw null;
    L24:
        if ((r8 instanceof m) == false) goto L100;
        if (r3 == true) goto L28;
        r15 = null;
    L28:
        if (r15 == null) goto L31;
        r2 = r15.a;
    L31:
        if ((r13 instanceof h) == false) goto L33;
        u((h) r13, r2);
        return;
    L33:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        x((y) r13, r2);
        return;
    L100:
        return;
    L72:
        G(r13, r8);
        throw null;
    L16:
        r1 = r8 instanceof y;
        goto L17
    L5:
        AtomicReferenceFieldUpdater r16 = g;
    L7:
        if (r16.compareAndSet(this, r8, r13) == true) goto L8;
        if (r16.get(this) == r8) goto L7;
    L11:
        if (r9 == false) goto L3;
        return;
    L8:
        r9 = true;
        goto L11
    }

    @Override // kotlinx.coroutines.i
    public final boolean cancel(Throwable r8) {
        AtomicReferenceFieldUpdater r0 = g;
    L3:
        Object r1 = r0.get(this);
        boolean r3 = false;
        if ((r1 instanceof m1) == false) goto L5;
        if ((r1 instanceof h) == false) goto L9;
    L12:
        boolean r4 = true;
    L13:
        m r2 = new m(this, r8, r4);
        AtomicReferenceFieldUpdater r5 = g;
    L15:
        if (r5.compareAndSet(this, r1, r2) == true) goto L16;
        if (r5.get(this) == r1) goto L15;
    L19:
        if (r3 == false) goto L3;
        m1 r6 = (m1) r1;
        if ((r6 instanceof h) == false) goto L24;
        u((h) r1, r8);
    L27:
        if (F() == true) goto L29;
        y();
    L29:
        z(this.c);
        return true;
    L24:
        if ((r6 instanceof y) == false) goto L27;
        x((y) r1, r8);
        goto L27
    L16:
        r3 = true;
        goto L19
    L9:
        if ((r1 instanceof y) == true) goto L12;
        r4 = false;
        goto L13
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.i
    public final void d(Object r1) {
        z(this.c);
    }

    @Override // kotlinx.coroutines.i0
    public final Throwable g(Object r1) {
        Throwable r2 = super.g(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2;
    }

    @Override // kotlinx.coroutines.i
    public final void i(Function1<? super Throwable, Unit> r2) {
        l.b(this, new h.a(r2));
    }

    @Override // kotlinx.coroutines.i
    public final b0 m(Throwable r3) {
        return N(new t(r3, false), null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.i0
    public final <T> T n(Object r2) {
        if ((r2 instanceof s) == true) goto L5;
        return r2;
    L5:
        return (T) ((s) r2).a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r3) {
        Throwable r0 = Result.m52exceptionOrNullimpl(r3);
        if (r0 == null) goto L6;
        r3 = new t(r0, false);
    L6:
        I(r3, this.c, null);
    }

    public final void z(int r8) {
        AtomicIntegerFieldUpdater r0 = f;
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        boolean r3 = false;
        if (r2 != 0) goto L5;
        if (f.compareAndSet(this, r1, (536870911 & r1) + 1073741824) == false) goto L3;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        return;
    L14:
        Continuation<T> r5 = this.d;
        if (r8 != 4) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
    L50:
        j0.a(this, r5, r6);
        return;
    L20:
        if ((r5 instanceof kotlinx.coroutines.internal.i) == false) goto L50;
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L26;
        boolean r9 = false;
    L27:
        int r7 = this.c;
        if (r7 == 1) goto L30;
        if (r7 == 2) goto L30;
    L31:
        if (r9 != r3) goto L50;
        CoroutineDispatcher r10 = ((kotlinx.coroutines.internal.i) r5).d;
        CoroutineContext r11 = r5.getContext();
        if (r10.isDispatchNeeded(r11) == false) goto L35;
        r10.dispatch(r11, this);
        return;
    L35:
        q0 r12 = v1.a();
        if (r12.l() == false) goto L38;
        r12.h(this);
        return;
    L38:
        r12.i(true);
        j0.a(this, this.d, true);     // Catch: Throwable -> L43
    L40:
        if (r12.n() == true) goto L40;
    L46:
        r12.d(true);
        return;
    L43:
        th = move-exception;
        o(th, null);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r12.d(true);
        throw th;
    L30:
        r3 = true;
    L26:
        r9 = true;
        goto L27
    L17:
        r6 = false;
        goto L18
    L5:
        if (r2 != 1) goto L8;
        r4 = false;
        goto L12
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Continuation<? super T> r1, int r2) {
        super(r2);
        this.d = r1;
        this.e = r1.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.a;
    }

    public static void G(Object r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    public final void J(CoroutineDispatcher r5, Throwable r6) {
        Continuation<T> r0 = this.d;
        if ((r0 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.i) r0;
    L6:
        t r2 = new t(r6, false);
        if (r1 == null) goto L9;
        CoroutineDispatcher r7 = r1.d;
    L10:
        if (r7 != r5) goto L12;
        int r8 = 4;
    L13:
        I(r2, r8, null);
        return;
    L12:
        r8 = this.c;
        goto L13
    L9:
        r7 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.i0
    public final void a(Object r13, Throwable r14) {
        AtomicReferenceFieldUpdater r15 = g;
    L3:
        Object r7 = r15.get(this);
        if ((r7 instanceof m1) == true) goto L41;
        if ((r7 instanceof t) == true) goto L7;
        boolean r8 = false;
        if ((r7 instanceof s) == true) goto L10;
        AtomicReferenceFieldUpdater r10 = g;
        s r11 = new s(r7, null, null, null, r14, 14);
    L34:
        if (r10.compareAndSet(this, r7, r11) == true) goto L35;
        if (r10.get(this) == r7) goto L34;
    L38:
        if (r8 == false) goto L3;
        return;
    L35:
        r8 = true;
        goto L38
    L10:
        s r0 = (s) r7;
        if (r0.e == null) goto L13;
        boolean r1 = true;
    L15:
        if ((!r1) == false) goto L31;
        s r2 = s.a(r0, null, r14, 15);
        AtomicReferenceFieldUpdater r3 = g;
    L18:
        if (r3.compareAndSet(this, r7, r2) == true) goto L19;
        if (r3.get(this) == r7) goto L18;
    L22:
        if (r8 == false) goto L3;
        h r16 = r0.b;
        if (r16 == null) goto L26;
        u(r16, r14);
    L26:
        Function1<Throwable, Unit> r17 = r0.c;
        if (r17 == null) goto L58;
        w(r17, r14);
        return;
    L58:
        return;
    L19:
        r8 = true;
        goto L22
    L31:
        throw new IllegalStateException("Must be called at most once".toString());
    L13:
        r1 = false;
        goto L15
    L7:
        return;
    L41:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.i
    public final b0 b(Object r2, Function1 r3) {
        return N(r2, null, r3);
    }

    @Override // kotlinx.coroutines.d2
    public final void e(y<?> r5, int r6) {
        AtomicIntegerFieldUpdater r0 = f;
    L3:
        int r1 = r0.get(this);
        if ((r1 & 536870911) != 536870911) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L13;
        if (r0.compareAndSet(this, r1, ((r1 >> 29) << 29) + r6) == false) goto L3;
        E(r5);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r2 = false;
        goto L7
    }

    @Override // kotlinx.coroutines.i
    public final void f(CoroutineDispatcher r4, T r5) {
        Continuation<T> r0 = this.d;
        if ((r0 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.i) r0;
    L6:
        if (r1 == null) goto L8;
        CoroutineDispatcher r2 = r1.d;
    L9:
        if (r2 != r4) goto L11;
        int r6 = 4;
    L12:
        I(r5, r6, null);
        return;
    L11:
        r6 = this.c;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.i
    public final void h(T r2, Function1<? super Throwable, Unit> r3) {
        I(r2, this.c, r3);
    }

    @Override // kotlinx.coroutines.i
    public final b0 l(Object r2, Object r3) {
        return N(r2, r3, null);
    }

    public final void u(h r4, Throwable r5) {
        r4.a(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void w(Function1<? super Throwable, Unit> r4, Throwable r5) {
        r4.invoke(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    public final void x(y<?> r4, Throwable r5) {
        int r6 = f.get(this) & 536870911;
        if (r6 == 536870911) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        r4.h(r6, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final void I(Object r8, int r9, Function1<? super Throwable, Unit> r10) {
        AtomicReferenceFieldUpdater r0 = g;
    L3:
        Object r1 = r0.get(this);
        boolean r3 = true;
        if ((r1 instanceof m1) == false) goto L19;
        Object r2 = M((m1) r1, r8, r9, r10, null);
        AtomicReferenceFieldUpdater r5 = g;
    L7:
        if (r5.compareAndSet(this, r1, r2) == true) goto L12;
        if (r5.get(this) == r1) goto L7;
        r3 = false;
    L12:
        if (r3 == false) goto L3;
        if (F() == true) goto L16;
        y();
    L16:
        z(r9);
        return;
    L19:
        if ((r1 instanceof m) == false) goto L26;
        m r4 = (m) r1;
        r4.getClass();
        if (m.c.compareAndSet(r4, 0, 1) == false) goto L26;
        if (r10 == null) goto L34;
        w(r10, r4.a);
        return;
    L34:
        return;
    L26:
        throw new IllegalStateException(("Already resumed, but proposed with update " + r8).toString());
    }

    public final b0 N(Object r6, Object r7, Function1<? super Throwable, Unit> r8) {
        AtomicReferenceFieldUpdater r0 = g;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof m1) == false) goto L19;
        Object r2 = M((m1) r1, r6, this.c, r8, r7);
        AtomicReferenceFieldUpdater r3 = g;
    L7:
        if (r3.compareAndSet(this, r1, r2) == true) goto L8;
        if (r3.get(this) == r1) goto L7;
        boolean r4 = false;
    L12:
        if (r4 == false) goto L3;
        if (F() == true) goto L17;
        y();
    L17:
        return k.a;
    L8:
        r4 = true;
        goto L12
    L19:
        if ((r1 instanceof s) == false) goto L24;
        if (r7 == null) goto L24;
        if (((s) r1).d != r7) goto L24;
        return k.a;
    L24:
        return null;
    }

    public static Object M(m1 r7, Object r8, int r9, Function1 r10, Object r11) {
        if ((r8 instanceof t) == true) goto L25;
        boolean r0 = true;
        if (r9 != 1) goto L8;
    L11:
        if (r0 == true) goto L14;
        if (r11 != null) goto L14;
        return r8;
    L14:
        if (r10 != null) goto L19;
        if ((r7 instanceof h) == true) goto L19;
        if (r11 != null) goto L19;
        return r8;
    L19:
        if ((r7 instanceof h) == false) goto L21;
        h r12 = (h) r7;
    L23:
        return new s(r8, r12, r10, r11, null, 16);
    L21:
        r12 = null;
        goto L23
    L8:
        if (r9 == 2) goto L11;
        r0 = false;
        goto L11
    L25:
        return r8;
    }
}
