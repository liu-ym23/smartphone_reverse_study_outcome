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

/* JADX INFO: loaded from: classes.dex */
public class j<T> extends i0<T> implements i<T>, CoroutineStackFrame, d2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504985f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504986g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504987h = null;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation<T> f504988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineContext f504989e;

    static {
        f504985f = AtomicIntegerFieldUpdater.newUpdater(j.class, "_decisionAndIndex$volatile");
        f504986g = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_state$volatile");
        f504987h = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_parentHandle$volatile");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final String toString() {
        return "CancellableContinuation";
    }

    public final boolean F() {
        if (this.f504922c != 2) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L13;
        Continuation<T> r101 = this.f504988d;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.i r102 = (kotlinx.coroutines.internal.i) r101;
        r102.getClass();
        if (kotlinx.coroutines.internal.i.f504951h.get(r102) == null) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return true;
    L10:
        r103 = false;
    L13:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public final void H() {
        Continuation<T> r100 = this.f504988d;
        Throwable r101 = null;
        if ((r100 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r102 = (kotlinx.coroutines.internal.i) r100;
    L6:
        if (r102 == null) goto L38;
        AtomicReferenceFieldUpdater r103 = kotlinx.coroutines.internal.i.f504951h;
    L8:
        Object r104 = r103.get(r102);
        kotlinx.coroutines.internal.b0 r105 = kotlinx.coroutines.internal.j.f504961b;
        boolean r106 = true;
        if (r104 != r105) goto L20;
        AtomicReferenceFieldUpdater r107 = kotlinx.coroutines.internal.i.f504951h;
    L12:
        if (r107.compareAndSet(r102, r105, this) == true) goto L17;
        if (r107.get(r102) == r105) goto L12;
        r106 = false;
    L17:
        if (r106 == false) goto L8;
    L30:
        if (r101 == null) goto L49;
        y();
        cancel(r101);
        return;
    L49:
        return;
    L20:
        if ((r104 instanceof Throwable) == false) goto L37;
        AtomicReferenceFieldUpdater r108 = kotlinx.coroutines.internal.i.f504951h;
    L23:
        if (r108.compareAndSet(r102, r104, null) == true) goto L28;
        if (r108.get(r102) == r104) goto L23;
        r106 = false;
    L28:
        if (r106 == false) goto L35;
        r101 = (Throwable) r104;
        goto L30
    L35:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L37:
        throw new IllegalStateException(("Inconsistent state " + r104).toString());
    L38:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r100 = this.f504988d;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isActive() {
        return f504986g.get(this) instanceof m1;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isCancelled() {
        return f504986g.get(this) instanceof m;
    }

    @Override // kotlinx.coroutines.i
    public final boolean isCompleted() {
        return !(f504986g.get(this) instanceof m1);
    }

    @Override // kotlinx.coroutines.i0
    public final Object s() {
        return f504986g.get(this);
    }

    public final void y() {
        AtomicReferenceFieldUpdater r100 = f504987h;
        m0 r101 = (m0) r100.get(this);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.dispose();
        r100.set(this, l1.f504994a);
    }

    public final Object B() {
        boolean r100 = F();
        AtomicIntegerFieldUpdater r101 = f504985f;
    L3:
        int r102 = r101.get(this);
        int r103 = r102 >> 29;
        boolean r104 = false;
        if (r103 != 0) goto L5;
        if (f504985f.compareAndSet(this, r102, (536870911 & r102) + 536870912) == false) goto L3;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        if (r100 == false) goto L22;
        H();
    L22:
        Object r106 = f504986g.get(this);
        if ((r106 instanceof t) == true) goto L39;
        int r107 = this.f504922c;
        if (r107 == 1) goto L27;
        if (r107 == 2) goto L27;
    L28:
        if (r104 == false) goto L37;
        Job r108 = (Job) getContext().get(Job.Key);
        if (r108 == null) goto L37;
        if (r108.isActive() == true) goto L37;
        CancellationException r109 = r108.getCancellationException();
        a(r106, r109);
        throw r109;
    L37:
        return n(r106);
    L27:
        r104 = true;
        goto L28
    L39:
        throw ((t) r106).f505148a;
    L14:
        if (((m0) f504987h.get(this)) != null) goto L16;
        D();
    L16:
        if (r100 == false) goto L19;
        H();
    L19:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        if (r103 != 2) goto L8;
        r105 = false;
        goto L12
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    public final void C() {
        m0 r100 = D();
        if (r100 != null) goto L6;
        return;
    L6:
        if (isCompleted() == false) goto L9;
        r100.dispose();
        f504987h.set(this, l1.f504994a);
        return;
    }

    public final m0 D() {
        Job r100 = (Job) getContext().get(Job.Key);
        if (r100 != null) goto L5;
        return null;
    L5:
        m0 r101 = JobKt.invokeOnCompletion$default(r100, true, false, new n(this), 2, null);
        AtomicReferenceFieldUpdater r102 = f504987h;
    L7:
        if (r102.compareAndSet(this, null, r101) == true) goto L11;
        if (r102.get(this) == null) goto L7;
    L11:
        return r101;
    }

    @Override // kotlinx.coroutines.i0
    public final Continuation<T> c() {
        return this.f504988d;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f504989e;
    }

    public Throwable A(JobSupport r100) {
        return r100.getCancellationException();
    }

    public final void E(Object r110) {
        AtomicReferenceFieldUpdater r100 = f504986g;
    L3:
        Object r101 = r100.get(this);
        boolean r102 = false;
        if ((r101 instanceof b) == true) goto L5;
        if ((r101 instanceof h) == false) goto L16;
        boolean r103 = true;
    L17:
        Throwable r104 = null;
        if (r103 == true) goto L72;
        boolean r105 = r101 instanceof t;
        if (r105 == true) goto L21;
        if ((r101 instanceof s) == true) goto L39;
        if ((r110 instanceof kotlinx.coroutines.internal.y) == true) goto L63;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        s r111 = new s(r101, (h) r110, null, null, null, 28);
        AtomicReferenceFieldUpdater r106 = f504986g;
    L66:
        if (r106.compareAndSet(this, r101, r111) == true) goto L67;
        if (r106.get(this) == r101) goto L66;
    L70:
        if (r102 == false) goto L3;
        return;
    L67:
        r102 = true;
        goto L70
    L63:
        return;
    L39:
        s r107 = (s) r101;
        if (r107.f505056b != null) goto L59;
        if ((r110 instanceof kotlinx.coroutines.internal.y) == true) goto L43;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        h r108 = (h) r110;
        Throwable r109 = r107.f505059e;
        if (r109 == null) goto L47;
        boolean r112 = true;
    L48:
        if (r112 == true) goto L49;
        s r113 = s.a(r107, r108, null, 29);
        AtomicReferenceFieldUpdater r114 = f504986g;
    L53:
        if (r114.compareAndSet(this, r101, r113) == true) goto L54;
        if (r114.get(this) == r101) goto L53;
    L57:
        if (r102 == false) goto L3;
        return;
    L54:
        r102 = true;
        goto L57
    L49:
        u(r108, r109);
        return;
    L47:
        r112 = false;
        goto L48
    L43:
        return;
    L59:
        G(r110, r101);
        throw null;
    L21:
        t r115 = (t) r101;
        r115.getClass();
        if (t.f505147b.compareAndSet(r115, 0, 1) == true) goto L24;
        G(r110, r101);
        throw null;
    L24:
        if ((r101 instanceof m) == false) goto L100;
        if (r105 == true) goto L28;
        r115 = null;
    L28:
        if (r115 == null) goto L31;
        r104 = r115.f505148a;
    L31:
        if ((r110 instanceof h) == false) goto L33;
        u((h) r110, r104);
        return;
    L33:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        x((kotlinx.coroutines.internal.y) r110, r104);
        return;
    L100:
        return;
    L72:
        G(r110, r101);
        throw null;
    L16:
        r103 = r101 instanceof kotlinx.coroutines.internal.y;
        goto L17
    L5:
        AtomicReferenceFieldUpdater r116 = f504986g;
    L7:
        if (r116.compareAndSet(this, r101, r110) == true) goto L8;
        if (r116.get(this) == r101) goto L7;
    L11:
        if (r102 == false) goto L3;
        return;
    L8:
        r102 = true;
        goto L11
    }

    @Override // kotlinx.coroutines.i
    public final boolean cancel(Throwable r100) {
        AtomicReferenceFieldUpdater r101 = f504986g;
    L3:
        Object r102 = r101.get(this);
        boolean r103 = false;
        if ((r102 instanceof m1) == false) goto L5;
        if ((r102 instanceof h) == false) goto L9;
    L12:
        boolean r104 = true;
    L13:
        m r105 = new m(this, r100, r104);
        AtomicReferenceFieldUpdater r106 = f504986g;
    L15:
        if (r106.compareAndSet(this, r102, r105) == true) goto L16;
        if (r106.get(this) == r102) goto L15;
    L19:
        if (r103 == false) goto L3;
        m1 r107 = (m1) r102;
        if ((r107 instanceof h) == false) goto L24;
        u((h) r102, r100);
    L27:
        if (F() == true) goto L29;
        y();
    L29:
        z(this.f504922c);
        return true;
    L24:
        if ((r107 instanceof kotlinx.coroutines.internal.y) == false) goto L27;
        x((kotlinx.coroutines.internal.y) r102, r100);
        goto L27
    L16:
        r103 = true;
        goto L19
    L9:
        if ((r102 instanceof kotlinx.coroutines.internal.y) == true) goto L12;
        r104 = false;
        goto L13
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.i
    public final void d(Object r100) {
        z(this.f504922c);
    }

    @Override // kotlinx.coroutines.i0
    public final Throwable g(Object r100) {
        Throwable r101 = super.g(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101;
    }

    @Override // kotlinx.coroutines.i
    public final void i(Function1<? super Throwable, Unit> r100) {
        l.b(this, new h.a(r100));
    }

    @Override // kotlinx.coroutines.i
    public final kotlinx.coroutines.internal.b0 m(Throwable r100) {
        return N(new t(r100, false), null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.i0
    public final <T> T n(Object r100) {
        if ((r100 instanceof s) == true) goto L5;
        return r100;
    L5:
        return (T) ((s) r100).f505055a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        Throwable r101 = Result.m9452exceptionOrNullimpl(r100);
        if (r101 == null) goto L6;
        r100 = new t(r101, false);
    L6:
        I(r100, this.f504922c, null);
    }

    public final void z(int r100) {
        AtomicIntegerFieldUpdater r101 = f504985f;
    L3:
        int r102 = r101.get(this);
        int r103 = r102 >> 29;
        boolean r104 = false;
        if (r103 != 0) goto L5;
        if (f504985f.compareAndSet(this, r102, (536870911 & r102) + 1073741824) == false) goto L3;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return;
    L14:
        Continuation<T> r106 = this.f504988d;
        if (r100 != 4) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
    L50:
        j0.a(this, r106, r107);
        return;
    L20:
        if ((r106 instanceof kotlinx.coroutines.internal.i) == false) goto L50;
        if (r100 == 1) goto L26;
        if (r100 == 2) goto L26;
        boolean r108 = false;
    L27:
        int r109 = this.f504922c;
        if (r109 == 1) goto L30;
        if (r109 == 2) goto L30;
    L31:
        if (r108 != r104) goto L50;
        CoroutineDispatcher r110 = ((kotlinx.coroutines.internal.i) r106).f504952d;
        CoroutineContext r111 = r106.getContext();
        if (r110.isDispatchNeeded(r111) == false) goto L35;
        r110.dispatch(r111, this);
        return;
    L35:
        q0 r112 = v1.a();
        if (r112.l() == false) goto L38;
        r112.h(this);
        return;
    L38:
        r112.i(true);
        j0.a(this, this.f504988d, true);     // Catch: Throwable -> L43
    L40:
        if (r112.n() == true) goto L40;
    L46:
        r112.d(true);
        return;
    L43:
        th = move-exception;
        o(th, null);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r112.d(true);
        throw th;
    L30:
        r104 = true;
    L26:
        r108 = true;
        goto L27
    L17:
        r107 = false;
        goto L18
    L5:
        if (r103 != 1) goto L8;
        r105 = false;
        goto L12
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Continuation<? super T> r100, int r101) {
        super(r101);
        this.f504988d = r100;
        this.f504989e = r100.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f504630a;
    }

    public static void G(Object r100, Object r101) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r100 + ", already has " + r101).toString());
    }

    public final void J(CoroutineDispatcher r100, Throwable r101) {
        Continuation<T> r102 = this.f504988d;
        if ((r102 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r103 = (kotlinx.coroutines.internal.i) r102;
    L6:
        t r104 = new t(r101, false);
        if (r103 == null) goto L9;
        CoroutineDispatcher r105 = r103.f504952d;
    L10:
        if (r105 != r100) goto L12;
        int r106 = 4;
    L13:
        I(r104, r106, null);
        return;
    L12:
        r106 = this.f504922c;
        goto L13
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.i0
    public final void a(Object r110, Throwable r111) {
        AtomicReferenceFieldUpdater r112 = f504986g;
    L3:
        Object r100 = r112.get(this);
        if ((r100 instanceof m1) == true) goto L41;
        if ((r100 instanceof t) == true) goto L7;
        boolean r101 = false;
        if ((r100 instanceof s) == true) goto L10;
        AtomicReferenceFieldUpdater r113 = f504986g;
        s r114 = new s(r100, null, null, null, r111, 14);
    L34:
        if (r113.compareAndSet(this, r100, r114) == true) goto L35;
        if (r113.get(this) == r100) goto L34;
    L38:
        if (r101 == false) goto L3;
        return;
    L35:
        r101 = true;
        goto L38
    L10:
        s r102 = (s) r100;
        if (r102.f505059e == null) goto L13;
        boolean r103 = true;
    L15:
        if ((!r103) == false) goto L31;
        s r104 = s.a(r102, null, r111, 15);
        AtomicReferenceFieldUpdater r105 = f504986g;
    L18:
        if (r105.compareAndSet(this, r100, r104) == true) goto L19;
        if (r105.get(this) == r100) goto L18;
    L22:
        if (r101 == false) goto L3;
        h r115 = r102.f505056b;
        if (r115 == null) goto L26;
        u(r115, r111);
    L26:
        Function1<Throwable, Unit> r116 = r102.f505057c;
        if (r116 == null) goto L58;
        w(r116, r111);
        return;
    L58:
        return;
    L19:
        r101 = true;
        goto L22
    L31:
        throw new IllegalStateException("Must be called at most once".toString());
    L13:
        r103 = false;
        goto L15
    L7:
        return;
    L41:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.i
    public final kotlinx.coroutines.internal.b0 b(Object r100, Function1 r101) {
        return N(r100, null, r101);
    }

    @Override // kotlinx.coroutines.d2
    public final void e(kotlinx.coroutines.internal.y<?> r100, int r101) {
        AtomicIntegerFieldUpdater r102 = f504985f;
    L3:
        int r103 = r102.get(this);
        if ((r103 & 536870911) != 536870911) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L13;
        if (r102.compareAndSet(this, r103, ((r103 >> 29) << 29) + r101) == false) goto L3;
        E(r100);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r104 = false;
        goto L7
    }

    @Override // kotlinx.coroutines.i
    public final void f(CoroutineDispatcher r100, T r101) {
        Continuation<T> r102 = this.f504988d;
        if ((r102 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r103 = (kotlinx.coroutines.internal.i) r102;
    L6:
        if (r103 == null) goto L8;
        CoroutineDispatcher r104 = r103.f504952d;
    L9:
        if (r104 != r100) goto L11;
        int r105 = 4;
    L12:
        I(r101, r105, null);
        return;
    L11:
        r105 = this.f504922c;
        goto L12
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.i
    public final void h(T r100, Function1<? super Throwable, Unit> r101) {
        I(r100, this.f504922c, r101);
    }

    @Override // kotlinx.coroutines.i
    public final kotlinx.coroutines.internal.b0 l(Object r100, Object r101) {
        return N(r100, r101, null);
    }

    public final void u(h r100, Throwable r101) {
        r100.a(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void w(Function1<? super Throwable, Unit> r100, Throwable r101) {
        r100.invoke(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    public final void x(kotlinx.coroutines.internal.y<?> r100, Throwable r101) {
        int r102 = f504985f.get(this) & 536870911;
        if (r102 == 536870911) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L13;
        r100.h(r102, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        y.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r103 = false;
        goto L6
    }

    public final void I(Object r100, int r101, Function1<? super Throwable, Unit> r110) {
        AtomicReferenceFieldUpdater r102 = f504986g;
    L3:
        Object r103 = r102.get(this);
        boolean r104 = true;
        if ((r103 instanceof m1) == false) goto L19;
        Object r105 = M((m1) r103, r100, r101, r110, null);
        AtomicReferenceFieldUpdater r106 = f504986g;
    L7:
        if (r106.compareAndSet(this, r103, r105) == true) goto L12;
        if (r106.get(this) == r103) goto L7;
        r104 = false;
    L12:
        if (r104 == false) goto L3;
        if (F() == true) goto L16;
        y();
    L16:
        z(r101);
        return;
    L19:
        if ((r103 instanceof m) == false) goto L26;
        m r107 = (m) r103;
        r107.getClass();
        if (m.f504995c.compareAndSet(r107, 0, 1) == false) goto L26;
        if (r110 == null) goto L34;
        w(r110, r107.f505148a);
        return;
    L34:
        return;
    L26:
        throw new IllegalStateException(("Already resumed, but proposed with update " + r100).toString());
    }

    public final kotlinx.coroutines.internal.b0 N(Object r100, Object r101, Function1<? super Throwable, Unit> r102) {
        AtomicReferenceFieldUpdater r103 = f504986g;
    L3:
        Object r104 = r103.get(this);
        if ((r104 instanceof m1) == false) goto L19;
        Object r105 = M((m1) r104, r100, this.f504922c, r102, r101);
        AtomicReferenceFieldUpdater r106 = f504986g;
    L7:
        if (r106.compareAndSet(this, r104, r105) == true) goto L8;
        if (r106.get(this) == r104) goto L7;
        boolean r107 = false;
    L12:
        if (r107 == false) goto L3;
        if (F() == true) goto L17;
        y();
    L17:
        return k.f504990a;
    L8:
        r107 = true;
        goto L12
    L19:
        if ((r104 instanceof s) == false) goto L24;
        if (r101 == null) goto L24;
        if (((s) r104).f505058d != r101) goto L24;
        return k.f504990a;
    L24:
        return null;
    }

    public static Object M(m1 r100, Object r101, int r102, Function1 r110, Object r111) {
        if ((r101 instanceof t) == true) goto L25;
        boolean r103 = true;
        if (r102 != 1) goto L8;
    L11:
        if (r103 == true) goto L14;
        if (r111 != null) goto L14;
        return r101;
    L14:
        if (r110 != null) goto L19;
        if ((r100 instanceof h) == true) goto L19;
        if (r111 != null) goto L19;
        return r101;
    L19:
        if ((r100 instanceof h) == false) goto L21;
        h r104 = (h) r100;
    L23:
        return new s(r101, r104, r110, r111, null, 16);
    L21:
        r104 = null;
        goto L23
    L8:
        if (r102 == 2) goto L11;
        r103 = false;
        goto L11
    L25:
        return r101;
    }
}
