package kotlinx.coroutines;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.selects.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, q, n1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = null;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    }

    public boolean G() {
        return true;
    }

    public boolean I() {
        return this instanceof r;
    }

    public boolean N(Throwable r1) {
        return false;
    }

    public boolean T() {
        return this instanceof d;
    }

    public void Z(Throwable r1) {
    }

    public void a0(Object r1) {
    }

    public void c0() {
    }

    public void o(Object r1) {
    }

    public String x() {
        return "Job was cancelled";
    }

    public final kotlinx.coroutines.selects.h H() {
        onAwaitInternal.1 r1 = onAwaitInternal.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        onAwaitInternal.2 r3 = onAwaitInternal.2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), null);
    }

    public final Object M() {
        AtomicReferenceFieldUpdater r0 = a;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof u) == false) goto L5;
        ((u) r1).a(this);
        goto L3
    L5:
        return r1;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new children.1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.selects.e getOnJoin() {
        onJoin.1 r1 = onJoin.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new f(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3));
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        o r0 = (o) b.get(this);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getParent();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(W() + '{' + g0(M()) + '}');
        r0.append('@');
        r0.append(b0.a(this));
        return r0.toString();
    }

    public final Object C() {
        Object r0 = M();
        if ((!(r0 instanceof x0)) == false) goto L11;
        if ((r0 instanceof t) == true) goto L9;
        return g1.a(r0);
    L9:
        throw ((t) r0).a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Throwable D() {
        Object r0 = M();
        if ((r0 instanceof c) == false) goto L10;
        Throwable r1 = ((c) r0).b();
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L10:
        if ((r0 instanceof x0) == true) goto L17;
        if ((r0 instanceof t) == true) goto L18;
        return null;
    L18:
        return ((t) r0).a;
    L17:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final boolean E() {
        Object r0 = M();
        if ((r0 instanceof t) == false) goto L11;
        t r1 = (t) r0;
        r1.getClass();
        if (t.b.get(r1) == 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = false;
        goto L8
    L11:
        return false;
    }

    public String W() {
        return getClass().getSimpleName();
    }

    @Override // kotlinx.coroutines.n1
    public final CancellationException e() {
        Object r0 = M();
        CancellationException r2 = null;
        if ((r0 instanceof c) == false) goto L6;
        Throwable r1 = ((c) r0).b();
    L12:
        if ((r1 instanceof CancellationException) == false) goto L14;
        r2 = (CancellationException) r1;
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return new JobCancellationException("Parent job is ".concat(g0(r0)), r1, this);
    L6:
        if ((r0 instanceof t) == false) goto L9;
        r1 = ((t) r0).a;
        goto L12
    L9:
        if ((r0 instanceof x0) == true) goto L18;
        r1 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r0).toString());
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object r0 = M();
        CancellationException r2 = null;
        if ((r0 instanceof c) == false) goto L17;
        Throwable r1 = ((c) r0).b();
        if (r1 == null) goto L15;
        String r3 = getClass().getSimpleName().concat(" is cancelling");
        if ((r1 instanceof CancellationException) == false) goto L9;
        r2 = (CancellationException) r1;
    L9:
        if (r2 == null) goto L11;
        return r2;
    L11:
        if (r3 != null) goto L26;
        r3 = x();
    L26:
        return new JobCancellationException(r3, r1, this);
    L15:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L17:
        if ((r0 instanceof x0) == true) goto L24;
        if ((r0 instanceof t) == false) goto L22;
        return h0(this, ((t) r0).a);
    L22:
        return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
    L24:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object r0 = M();
        if ((!(r0 instanceof x0)) == false) goto L12;
        if ((r0 instanceof t) == false) goto L7;
        t r1 = (t) r0;
    L8:
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.a;
    L7:
        r1 = null;
        goto L8
    L12:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r0 = M();
        if ((r0 instanceof x0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((x0) r0).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r0 = M();
        if ((r0 instanceof t) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r0 instanceof c) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) r0).c() == false) goto L9;
        goto L9
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(M() instanceof x0);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r0 = e0(M());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public JobSupport(boolean r1) {
        if (r1 == false) goto L5;
        p0 r2 = g1.g;
    L6:
        this._state$volatile = r2;
        return;
    L5:
        r2 = g1.f;
        goto L6
    }

    public static p X(LockFreeLinkedListNode r1) {
    L3:
        if (r1.h() == false) goto L5;
        r1 = r1.g();
    L5:
        r1 = r1.f();
        if (r1.h() == true) goto L5;
        if ((r1 instanceof p) == true) goto L10;
        if ((r1 instanceof j1) == false) goto L5;
        return null;
    L10:
        return (p) r1;
    }

    public static String g0(Object r1) {
        if ((r1 instanceof c) == false) goto L11;
        c r2 = (c) r1;
        if (r2.c() == false) goto L8;
        return "Cancelling";
    L8:
        if (r2.d() == false) goto L14;
        return "Completing";
    L14:
        return "Active";
    L11:
        if ((r1 instanceof x0) == false) goto L17;
        if (((x0) r1).isActive() == true) goto L14;
        return "New";
    L17:
        if ((r1 instanceof t) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public final Throwable A(Object r3) {
        if (r3 != null) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        Throwable r4 = (Throwable) r3;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return new JobCancellationException(x(), null, this);
    L9:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((n1) r3).e();
    L4:
        r0 = r3 instanceof Throwable;
        goto L5
    }

    public final j1 J(x0 r4) {
        j1 r0 = r4.getList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if ((r4 instanceof p0) == false) goto L8;
        return new j1();
    L8:
        if ((r4 instanceof f1) == false) goto L11;
        d0((f1) r4);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r4).toString());
    }

    public final void P(Job r3) {
        if (r3 != null) goto L5;
        l1 r4 = l1.a;
        b.set(this, r4);
        return;
    L5:
        r3.start();
        o r5 = r3.attachChild(this);
        AtomicReferenceFieldUpdater r0 = b;
        r0.set(this, r5);
        if (isCompleted() == false) goto L9;
        r5.dispose();
        r0.set(this, l1.a);
        return;
    }

    public final boolean U(Object r4) {
    L2:
        Object r0 = i0(M(), r4);
        if (r0 == g1.a) goto L4;
        if (r0 == g1.b) goto L8;
        if (r0 == g1.c) goto L2;
        o(r0);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object V(Object r5) {
    L2:
        Object r0 = i0(M(), r5);
        if (r0 == g1.a) goto L7;
        if (r0 == g1.c) goto L2;
        return r0;
    L7:
        String r1 = "Job " + this + " is already complete or completing, but is being completed with " + r5;
        Throwable r3 = null;
        if ((r5 instanceof t) == false) goto L10;
        t r6 = (t) r5;
    L11:
        if (r6 == null) goto L14;
        r3 = r6.a;
    L14:
        throw new IllegalStateException(r1, r3);
    L10:
        r6 = null;
        goto L11
    }

    @Override // kotlinx.coroutines.q
    public final void a(JobSupport r1) {
        s(r1);
    }

    @Override // kotlinx.coroutines.Job
    public final o attachChild(q r7) {
        m0 r8 = JobKt.invokeOnCompletion$default(this, true, false, new p(r7), 2, null);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (o) r8;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable r3) {
        if (r3 == null) goto L4;
        CancellationException r4 = h0(this, r3);
    L5:
        u(r4);
        return true;
    L4:
        r4 = new JobCancellationException(x(), null, this);
        goto L5
    }

    public final void d0(f1 r4) {
        j1 r0 = new j1();
        r4.getClass();
        LockFreeLinkedListNode.b.set(r0, r4);
        LockFreeLinkedListNode.a.set(r0, r4);
    L4:
        if (r4.e() != r4) goto L15;
        AtomicReferenceFieldUpdater r1 = LockFreeLinkedListNode.a;
    L8:
        if (r1.compareAndSet(r4, r4, r0) == true) goto L9;
        if (r1.get(r4) == r4) goto L8;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L4;
        r0.d(r4);
        goto L15
    L9:
        r2 = true;
    L15:
        LockFreeLinkedListNode r3 = r4.f();
        AtomicReferenceFieldUpdater r5 = a;
    L17:
        if (r5.compareAndSet(this, r4, r3) == true) goto L21;
        if (r5.get(this) == r4) goto L17;
        return;
    }

    public final int e0(Object r7) {
        boolean r3 = false;
        if ((r7 instanceof p0) == false) goto L18;
        if (((p0) r7).a == false) goto L7;
        return 0;
    L7:
        AtomicReferenceFieldUpdater r0 = a;
        p0 r4 = g1.g;
    L9:
        if (r0.compareAndSet(this, r7, r4) == true) goto L10;
        if (r0.get(this) == r7) goto L9;
    L13:
        if (r3 == true) goto L15;
        return -1;
    L15:
        c0();
        return 1;
    L10:
        r3 = true;
        goto L13
    L18:
        if ((r7 instanceof w0) == false) goto L29;
        AtomicReferenceFieldUpdater r1 = a;
        j1 r5 = ((w0) r7).a;
    L21:
        if (r1.compareAndSet(this, r7, r5) == true) goto L22;
        if (r1.get(this) == r7) goto L21;
    L25:
        if (r3 == true) goto L27;
        return -1;
    L27:
        c0();
        return 1;
    L22:
        r3 = true;
        goto L25
    L29:
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) Job.DefaultImpls.get(this, r1);
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(Function1<? super Throwable, Unit> r3) {
        return Q(false, true, new z0.a(r3));
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> r10) {
    L2:
        Object r0 = M();
        if ((r0 instanceof x0) == false) goto L4;
        if (e0(r0) < 0) goto L2;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        JobKt.ensureActive(r10.getContext());
        return Unit.INSTANCE;
    L11:
        j r2 = new j(IntrinsicsKt.intercepted(r10), 1);
        r2.C();
        l.b(r2, new n0(JobKt.invokeOnCompletion$default(this, false, false, new p1(r2), 3, null)));
        Object r3 = r2.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L15:
        if (r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r3 = Unit.INSTANCE;
    L19:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r3;
    L22:
        return Unit.INSTANCE;
    L4:
        r1 = false;
        goto L8
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return Job.DefaultImpls.minusKey(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r1) {
        return Job.DefaultImpls.plus(this, r1);
    }

    public final Object q(Continuation<Object> r9) {
    L2:
        Object r0 = M();
        if ((r0 instanceof x0) == false) goto L5;
        if (e0(r0) < 0) goto L2;
        a r1 = new a(IntrinsicsKt.intercepted(r9), this);
        r1.C();
        l.b(r1, new n0(JobKt.invokeOnCompletion$default(this, false, false, new o1(r1), 3, null)));
        Object r2 = r1.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L15:
        return r2;
    L5:
        if ((r0 instanceof t) == true) goto L9;
        return g1.a(r0);
    L9:
        throw ((t) r0).a;
    }

    public final boolean s(Object r10) {
        Object r0 = g1.a;
        if (I() == false) goto L19;
    L4:
        Object r1 = M();
        if ((r1 instanceof x0) == false) goto L14;
        if ((r1 instanceof c) == true) goto L9;
    L11:
        r0 = i0(r1, new t(A(r10), false));
        if (r0 == g1.c) goto L4;
    L16:
        if (r0 != g1.b) goto L19;
        return true;
    L9:
        if (((c) r1).d() == false) goto L11;
    L14:
        r0 = g1.a;
    L19:
        if (r0 != g1.a) goto L80;
        Throwable r2 = null;
        Throwable r3 = null;
    L21:
        Object r4 = M();
        if ((r4 instanceof c) == true) goto L23;
        if ((r4 instanceof x0) == false) goto L77;
        if (r3 != null) goto L53;
        r3 = A(r10);
    L53:
        x0 r5 = (x0) r4;
        if (r5.isActive() == true) goto L55;
        Object r6 = i0(r4, new t(r3, false));
        if (r6 == g1.a) goto L76;
        if (r6 == g1.c) goto L21;
        r0 = r6;
        goto L80
    L76:
        throw new IllegalStateException(("Cannot happen in " + r4).toString());
    L55:
        j1 r7 = J(r5);
        if (r7 == null) goto L66;
        c r8 = new c(r7, r3);
        AtomicReferenceFieldUpdater r9 = a;
    L60:
        if (r9.compareAndSet(this, r5, r8) == true) goto L61;
        if (r9.get(this) == r5) goto L60;
        boolean r11 = false;
    L65:
        if (r11 == false) goto L66;
        Y(r7, r3);
        boolean r12 = true;
    L68:
        if (r12 == false) goto L21;
        b0 r13 = g1.a;
    L78:
        r0 = r13;
        goto L80
    L61:
        r11 = true;
    L66:
        r12 = false;
        goto L68
    L77:
        r13 = g1.d;
        goto L78
    L23:
        monitor-enter(r4);
    L46:
        th = move-exception;
        throw th;
    L25:
        if (c.d.get((c) r4) != g1.e) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == false) goto L32;
        r13 = g1.d;     // Catch: Throwable -> L46
        monitor-exit(r4);
        goto L78
    L32:
        boolean r15 = ((c) r4).c();     // Catch: Throwable -> L46
        if (r10 != null) goto L35;
        if (r15 == false) goto L35;
    L38:
        Throwable r16 = ((c) r4).b();     // Catch: Throwable -> L46
        if ((!r15) == false) goto L42;
        r2 = r16;
    L42:
        monitor-exit(r4);
        if (r2 == null) goto L45;
        Y(((c) r4).a, r2);
    L45:
        r13 = g1.a;
    L35:
        if (r3 != null) goto L37;
        r3 = A(r10);     // Catch: Throwable -> L46
    L37:
        ((c) r4).a(r3);     // Catch: Throwable -> L46
        goto L38
    L27:
        r14 = false;
    L80:
        if (r0 != g1.a) goto L83;
    L89:
        return true;
    L83:
        if (r0 == g1.b) goto L89;
        if (r0 == g1.d) goto L109;
        o(r0);
        goto L89
    L109:
        return false;
    }

    public void u(Throwable r1) {
        s(r1);
    }

    public final boolean w(Throwable r5) {
        if (T() == false) goto L5;
        return true;
    L5:
        boolean r0 = r5 instanceof CancellationException;
        o r2 = (o) b.get(this);
        if (r2 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r2 == l1.a) goto L16;
        if (r2.b(r5) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    public boolean y(Throwable r3) {
        if ((r3 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (s(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (G() == false) goto L10;
        return true;
    }

    public void O(CompletionHandlerException r1) {
        throw r1;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException r3) {
        if (r3 != null) goto L4;
        r3 = new JobCancellationException(x(), null, this);
    L4:
        u(r3);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public final Job plus(Job r1) {
        return Job.DefaultImpls.plus(this, r1);
    }

    public static CancellationException h0(JobSupport r2, Throwable r3) {
        r2.getClass();
        if ((r3 instanceof CancellationException) == false) goto L5;
        CancellationException r0 = (CancellationException) r3;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new JobCancellationException(r2.x(), r3, r2);
    L5:
        r0 = null;
        goto L6
    }

    public final Object B(c r9, Object r10) {
        Throwable r1 = null;
        if ((r10 instanceof t) == false) goto L5;
        t r0 = (t) r10;
    L6:
        if (r0 == null) goto L8;
        r1 = r0.a;
    L8:
        monitor-enter(r9);
        boolean r2 = r9.c();     // Catch: Throwable -> L56
        List<? extends Throwable> r3 = r9.e(r1);     // Catch: Throwable -> L56
        Throwable r4 = F(r9, r3);     // Catch: Throwable -> L56
        if (r4 != null) goto L12;
    L26:
        monitor-exit(r9);
        if (r4 == null) goto L33;
        if (r4 == r1) goto L33;
        r10 = new t(r4, false);
    L33:
        if (r4 != null) goto L35;
    L43:
        if (r2 == true) goto L45;
        Z(r4);
    L45:
        a0(r10);
        AtomicReferenceFieldUpdater r5 = a;
        if ((r10 instanceof x0) == false) goto L48;
        Object r6 = new y0((x0) r10);
    L50:
        if (r5.compareAndSet(this, r9, r6) == true) goto L54;
        if (r5.get(this) == r9) goto L50;
    L54:
        z(r9, r10);
        return r10;
    L48:
        r6 = r10;
        goto L50
    L35:
        if (w(r4) == false) goto L37;
    L40:
        boolean r7 = true;
    L41:
        if (r7 == false) goto L43;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        t r8 = (t) r10;
        r8.getClass();
        t.b.compareAndSet(r8, 0, 1);
        goto L43
    L37:
        if (N(r4) == true) goto L40;
        r7 = false;
        goto L41
    L12:
        if (r3.size() <= 1) goto L26;
        Set r11 = Collections.newSetFromMap(new IdentityHashMap(r3.size()));     // Catch: Throwable -> L56
        Iterator<? extends Throwable> r12 = r3.iterator();     // Catch: Throwable -> L56
    L16:
        if (r12.hasNext() == false) goto L26;
        Throwable r13 = r12.next();     // Catch: Throwable -> L56
        if (r13 == r4) goto L16;
        if (r13 == r4) goto L16;
        if ((r13 instanceof CancellationException) == true) goto L16;
        if (r11.add(r13) == false) goto L16;
        ExceptionsKt.addSuppressed(r4, r13);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    public final Throwable F(c r6, List<? extends Throwable> r7) {
        Object r1 = null;
        if (r7.isEmpty() == true) goto L5;
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        Object r0 = r8.next();
        if ((!(((Throwable) r0) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r2 = (Throwable) r0;
        if (r2 == null) goto L19;
        return r2;
    L19:
        Throwable r3 = (Throwable) ListProtector.get(r7, 0);
        if ((r3 instanceof TimeoutCancellationException) == false) goto L35;
        Iterator<T> r9 = r7.iterator();
    L23:
        if (r9.hasNext() == false) goto L32;
        Object r4 = r9.next();
        Throwable r5 = (Throwable) r4;
        if (r5 != r3) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == false) goto L23;
        r1 = r4;
        goto L32
    L27:
        if ((r5 instanceof TimeoutCancellationException) == false) goto L29;
        r10 = true;
    L32:
        Throwable r11 = (Throwable) r1;
        if (r11 == null) goto L35;
        return r11;
    L35:
        return r3;
    L15:
        r0 = null;
        goto L16
    L5:
        if (r6.c() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(x(), null, this);
    }

    public final void Y(j1 r7, Throwable r8) {
        Z(r8);
        Object r0 = r7.e();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r7) == true) goto L15;
        if ((r1 instanceof d1) == false) goto L14;
        f1 r3 = (f1) r1;
        r3.a(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r2 == null) goto L13;
        ExceptionsKt.addSuppressed(r2, th);
        goto L14
    L13:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r4 = Unit.INSTANCE;
    L14:
        r1 = r1.f();
        goto L4
    L15:
        if (r2 == null) goto L17;
        O(r2);
    L17:
        w(r8);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
        return (R) Job.DefaultImpls.fold(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, java.lang.Throwable] */
    public final Object i0(Object r9, Object r10) {
        if ((r9 instanceof x0) == false) goto L5;
        boolean r1 = false;
        p r3 = null;
        if ((r9 instanceof p0) == true) goto L11;
        if ((r9 instanceof f1) == true) goto L11;
    L31:
        c r11 = (x0) r9;
        j1 r0 = J(r11);
        if (r0 != null) goto L35;
        return g1.c;
    L35:
        if ((r11 instanceof c) == false) goto L37;
        c r4 = r11;
    L38:
        if (r4 != null) goto L40;
        r4 = new c(r0, null);
    L40:
        Ref$ObjectRef r5 = new Ref$ObjectRef();
        monitor-enter(r4);
    L88:
        th = move-exception;
        throw th;
    L43:
        if (r4.d() == false) goto L47;
        b0 r12 = g1.a;     // Catch: Throwable -> L88
        monitor-exit(r4);
        return r12;
    L47:
        c.b.set(r4, 1);     // Catch: Throwable -> L88
        if (r4 == r11) goto L59;
        AtomicReferenceFieldUpdater r6 = a;     // Catch: Throwable -> L88
    L51:
        if (r6.compareAndSet(this, r11, r4) == true) goto L52;
        if (r6.get(this) == r11) goto L51;
    L55:
        if (r1 == true) goto L59;
        b0 r13 = g1.c;     // Catch: Throwable -> L88
        monitor-exit(r4);
        return r13;
    L52:
        r1 = true;
    L59:
        boolean r2 = r4.c();     // Catch: Throwable -> L88
        if ((r10 instanceof t) == false) goto L62;
        t r7 = (t) r10;     // Catch: Throwable -> L88
    L63:
        if (r7 == null) goto L65;
        r4.a(r7.a);     // Catch: Throwable -> L88
    L65:
        Throwable r8 = r4.b();     // Catch: Throwable -> L88
        if (Boolean.valueOf(!r2).booleanValue() == false) goto L68;
        ?? r14 = r8;
    L69:
        r5.element = r14;     // Catch: Throwable -> L88
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r4);
        if (r14 == 0) goto L74;
        Y(r0, r14);
    L74:
        if ((r11 instanceof p) == false) goto L76;
        p r16 = (p) r11;
    L77:
        if (r16 != null) goto L81;
        j1 r17 = r11.getList();
        if (r17 == null) goto L82;
        r3 = X(r17);
    L82:
        if (r3 == null) goto L87;
        if (j0(r4, r3, r10) == false) goto L87;
        return g1.b;
    L87:
        return B(r4, r10);
    L81:
        r3 = r16;
        goto L82
    L76:
        r16 = null;
        goto L77
    L68:
        r14 = 0;
        goto L69
    L62:
        r7 = null;
        goto L63
    L37:
        r4 = null;
    L11:
        if ((r9 instanceof p) == true) goto L31;
        if ((r10 instanceof t) == true) goto L31;
        x0 r18 = (x0) r9;
        AtomicReferenceFieldUpdater r19 = a;
        b0 r20 = g1.a;
        if ((r10 instanceof x0) == false) goto L17;
        Object r21 = new y0((x0) r10);
    L19:
        if (r19.compareAndSet(this, r18, r21) == true) goto L20;
        if (r19.get(this) == r18) goto L19;
        boolean r22 = false;
    L24:
        if (r22 == false) goto L27;
        Z(null);
        a0(r10);
        z(r18, r10);
        r1 = true;
    L27:
        if (r1 == false) goto L30;
        return r10;
    L30:
        return g1.c;
    L20:
        r22 = true;
        goto L24
    L17:
        r21 = r10;
        goto L19
    L5:
        return g1.a;
    }

    public final void z(x0 r8, Object r9) {
        AtomicReferenceFieldUpdater r0 = b;
        o r1 = (o) r0.get(this);
        if (r1 == null) goto L5;
        r1.dispose();
        r0.set(this, l1.a);
    L5:
        CompletionHandlerException r2 = null;
        if ((r9 instanceof t) == false) goto L8;
        t r10 = (t) r9;
    L9:
        if (r10 == null) goto L11;
        Throwable r11 = r10.a;
    L13:
        if ((r8 instanceof f1) == true) goto L36;
        j1 r12 = r8.getList();
        if (r12 == null) goto L46;
        Object r3 = r12.e();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r4 = (LockFreeLinkedListNode) r3;
    L22:
        if (Intrinsics.areEqual(r4, r12) == true) goto L33;
        if ((r4 instanceof f1) == false) goto L32;
        f1 r5 = (f1) r4;
        r5.a(r11);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r2 == null) goto L31;
        ExceptionsKt.addSuppressed(r2, th);
        goto L32
    L31:
        r2 = new CompletionHandlerException("Exception in completion handler " + r5 + " for " + this, th);
        Unit r6 = Unit.INSTANCE;
    L32:
        r4 = r4.f();
        goto L22
    L33:
        if (r2 == null) goto L47;
        O(r2);
        return;
    L47:
        return;
    L46:
        return;
    L36:
        ((f1) r8).a(r11);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        O(new CompletionHandlerException("Exception in completion handler " + r8 + " for " + this, th));
        return;
    L11:
        r11 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public final m0 Q(boolean r8, boolean r9, z0 r10) {
        Throwable r0 = null;
        if (r8 == false) goto L11;
        if ((r10 instanceof d1) == false) goto L7;
        b1 r1 = (d1) r10;
    L8:
        if (r1 != null) goto L17;
        r1 = new b1(r10);
    L17:
        r1.d = this;
    L18:
        Object r2 = M();
        if ((r2 instanceof p0) == true) goto L20;
        if ((r2 instanceof x0) == false) goto L80;
        j1 r3 = ((x0) r2).getList();
        if (r3 == null) goto L46;
        b1 r4 = l1.a;
        if (r8 == false) goto L72;
        if ((r2 instanceof c) == false) goto L72;
        monitor-enter(r2);
        Throwable r5 = ((c) r2).b();     // Catch: Throwable -> L69
        if (r5 == null) goto L59;
        if ((r10 instanceof p) == false) goto L66;
        if (((c) r2).d() == false) goto L59;
    L66:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(r2);
    L73:
        if (r5 != null) goto L74;
        if (n(r2, r3, r1) == false) goto L18;
        return r1;
    L74:
        if (r9 == false) goto L76;
        r10.a(r5);
    L76:
        return r4;
    L59:
        if (n(r2, r3, r1) == true) goto L62;
        monitor-exit(r2);
        goto L18
    L62:
        if (r5 == null) goto L63;
        r4 = r1;
        goto L66
    L63:
        monitor-exit(r2);
        return r1;
    L69:
        th = move-exception;
        throw th;
    L72:
        r5 = null;
        goto L73
    L46:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        d0((f1) r2);
        goto L18
    L80:
        if (r9 == false) goto L89;
        if ((r2 instanceof t) == false) goto L84;
        t r7 = (t) r2;
    L85:
        if (r7 == null) goto L87;
        r0 = r7.a;
    L87:
        r10.a(r0);
        goto L89
    L84:
        r7 = null;
    L89:
        return l1.a;
    L20:
        p0 r11 = (p0) r2;
        if (r11.a == true) goto L22;
        w0 r12 = new j1();
        if (r11.a == false) goto L34;
        w0 r13 = r12;
    L35:
        AtomicReferenceFieldUpdater r14 = a;
    L37:
        if (r14.compareAndSet(this, r11, r13) == true) goto L18;
        if (r14.get(this) == r11) goto L37;
    L34:
        r13 = new w0(r12);
        goto L35
    L22:
        AtomicReferenceFieldUpdater r15 = a;
    L24:
        if (r15.compareAndSet(this, r2, r1) == true) goto L25;
        if (r15.get(this) == r2) goto L24;
        boolean r16 = false;
    L29:
        if (r16 == false) goto L18;
        return r1;
    L25:
        r16 = true;
        goto L29
    L7:
        r1 = null;
        goto L8
    L11:
        if ((r10 instanceof f1) == false) goto L13;
        r1 = (f1) r10;
    L14:
        if (r1 != null) goto L17;
        r1 = new c1(r10);
        goto L17
    L13:
        r1 = null;
        goto L14
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(boolean r2, boolean r3, Function1<? super Throwable, Unit> r4) {
        return Q(r2, r3, new z0.a(r4));
    }

    public final boolean j0(c r7, p r8, Object r9) {
    L3:
        if (JobKt.invokeOnCompletion$default(r8.e, false, false, new b(this, r7, r8, r9), 1, null) != l1.a) goto L4;
        r8 = X(r8);
        if (r8 != null) goto L3;
        return false;
    L4:
        return true;
    }

    public final boolean n(Object r6, j1 r7, f1 r8) {
        f r0 = new f(r8, this, r6);
    L3:
        LockFreeLinkedListNode r9 = r7.g();
        LockFreeLinkedListNode.b.set(r8, r9);
        AtomicReferenceFieldUpdater r1 = LockFreeLinkedListNode.a;
        r1.set(r8, r7);
        ((LockFreeLinkedListNode.a) r0).c = r7;
    L5:
        if (r1.compareAndSet(r9, r7, r0) == true) goto L6;
        if (r1.get(r9) == r7) goto L5;
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        char r10 = 0;
    L17:
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L3;
        return false;
    L20:
        return true;
    L14:
        if (r0.a(r9) != null) goto L16;
        r10 = 1;
        goto L17
    L16:
        r10 = 2;
        goto L17
    L6:
        r2 = true;
        goto L11
    }
}
