package kotlinx.coroutines;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, q, n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504600b = null;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a<T> extends j<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final JobSupport f504601i;

        @Override // kotlinx.coroutines.j
        public final Throwable A(JobSupport r100) {
            Object r101 = this.f504601i.M();
            if ((r101 instanceof c) == false) goto L8;
            Throwable r102 = ((c) r101).b();
            if (r102 == null) goto L8;
            return r102;
        L8:
            if ((r101 instanceof t) == false) goto L12;
            return ((t) r101).f505148a;
        L12:
            return r100.getCancellationException();
        }

        public a(Continuation<? super T> r100, JobSupport r101) {
            super(r100, 1);
            this.f504601i = r101;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class b extends f1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobSupport f504602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f504603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final p f504604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f504605h;

        @Override // kotlinx.coroutines.z0
        public final void a(Throwable r100) {
            JobSupport r101 = this.f504602e;
            c r102 = this.f504603f;
            p r103 = this.f504604g;
            Object r104 = this.f504605h;
            AtomicReferenceFieldUpdater r105 = JobSupport.f504599a;
            r101.getClass();
            p r106 = JobSupport.X(r103);
            if (r106 != null) goto L5;
        L7:
            r101.o(r101.B(r102, r104));
            return;
        L5:
            if (r101.j0(r102, r106, r104) == false) goto L7;
        }

        public b(JobSupport r100, c r101, p r102, Object r103) {
            this.f504602e = r100;
            this.f504603f = r101;
            this.f504604g = r102;
            this.f504605h = r103;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class c implements x0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f504606b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f504607c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f504608d = null;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j1 f504609a;

        static {
            f504606b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
            f504607c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
            f504608d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        }

        public final Throwable b() {
            return (Throwable) f504607c.get(this);
        }

        public final boolean d() {
            if (f504606b.get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final String toString() {
            return "Finishing[cancelling=" + c() + ", completing=" + d() + ", rootCause=" + b() + ", exceptions=" + f504608d.get(this) + ", list=" + this.f504609a + ']';
        }

        public final boolean c() {
            if (b() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.x0
        public final boolean isActive() {
            if (b() != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.x0
        public final j1 getList() {
            return this.f504609a;
        }

        public final void a(Throwable r100) {
            Throwable r101 = b();
            if (r101 != null) goto L6;
            f504607c.set(this, r100);
            return;
        L6:
            if (r100 != r101) goto L8;
            return;
        L8:
            AtomicReferenceFieldUpdater r102 = f504608d;
            Object r103 = r102.get(this);
            if (r103 != null) goto L12;
            r102.set(this, r100);
            return;
        L12:
            if ((r103 instanceof Throwable) == false) goto L17;
            if (r100 != r103) goto L15;
            return;
        L15:
            ArrayList r104 = new ArrayList(4);
            r104.add(r103);
            r104.add(r100);
            r102.set(this, r104);
            return;
        L17:
            if ((r103 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r103).add(r100);
            return;
        L21:
            throw new IllegalStateException(("State is " + r103).toString());
        }

        public final List<Throwable> e(Throwable r100) {
            AtomicReferenceFieldUpdater r101 = f504608d;
            Object r102 = r101.get(this);
            if (r102 != null) goto L6;
            ArrayList r103 = new ArrayList(4);
        L11:
            Throwable r104 = b();
            if (r104 == null) goto L14;
            ListProtector.add(r103, 0, r104);
        L14:
            if (r100 != null) goto L16;
        L18:
            r101.set(this, g1.f504916e);
            return r103;
        L16:
            if (Intrinsics.areEqual(r100, r104) == true) goto L18;
            r103.add(r100);
            goto L18
        L6:
            if ((r102 instanceof Throwable) == false) goto L9;
            ArrayList r105 = new ArrayList(4);
            r105.add(r102);
            r103 = r105;
            goto L11
        L9:
            if ((r102 instanceof ArrayList) == false) goto L21;
            r103 = (ArrayList) r102;
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r102).toString());
        }

        public c(j1 r100, Throwable r101) {
            this.f504609a = r100;
            this._isCompleting$volatile = 0;
            this._rootCause$volatile = r101;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public final class d extends f1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final kotlinx.coroutines.selects.l<?> f504610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JobSupport f504611f;

        @Override // kotlinx.coroutines.z0
        public final void a(Throwable r100) {
            Object r101 = this.f504611f.M();
            if ((r101 instanceof t) == true) goto L6;
            r101 = g1.a(r101);
        L6:
            this.f504610e.f(this.f504611f, r101);
        }

        public d(JobSupport r100, kotlinx.coroutines.selects.l<?> r101) {
            this.f504611f = r100;
            this.f504610e = r101;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public final class e extends f1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final kotlinx.coroutines.selects.l<?> f504612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JobSupport f504613f;

        @Override // kotlinx.coroutines.z0
        public final void a(Throwable r100) {
            this.f504612e.f(this.f504613f, Unit.INSTANCE);
        }

        public e(JobSupport r100, kotlinx.coroutines.selects.l<?> r101) {
            this.f504613f = r100;
            this.f504612e = r101;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class f extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JobSupport f504614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f504615e;

        @Override // kotlinx.coroutines.internal.b
        public final kotlinx.coroutines.internal.b0 c(Object r100) {
            LockFreeLinkedListNode r101 = (LockFreeLinkedListNode) r100;
            if (this.f504614d.M() != this.f504615e) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return null;
        L9:
            return kotlinx.coroutines.internal.o.f504970a;
        L5:
            r102 = false;
            goto L6
        }

        public f(LockFreeLinkedListNode r100, JobSupport r101, Object r102) {
            this.f504614d = r101;
            this.f504615e = r102;
            super(r100);
        }
    }

    static {
        f504599a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
        f504600b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    }

    public boolean G() {
        return true;
    }

    public boolean I() {
        return this instanceof r;
    }

    public boolean N(Throwable r100) {
        return false;
    }

    public boolean T() {
        return this instanceof kotlinx.coroutines.d;
    }

    public void Z(Throwable r100) {
    }

    public void a0(Object r100) {
    }

    public void c0() {
    }

    public void o(Object r100) {
    }

    public String x() {
        return "Job was cancelled";
    }

    public final kotlinx.coroutines.selects.h H() {
        JobSupport$onAwaitInternal$1 r100 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        JobSupport$onAwaitInternal$2 r102 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3), null);
    }

    public final Object M() {
        AtomicReferenceFieldUpdater r100 = f504599a;
    L3:
        Object r101 = r100.get(this);
        if ((r101 instanceof kotlinx.coroutines.internal.u) == false) goto L5;
        ((kotlinx.coroutines.internal.u) r101).a(this);
        goto L3
    L5:
        return r101;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.selects.e getOnJoin() {
        JobSupport$onJoin$1 r100 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.f(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3));
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        o r100 = (o) f504600b.get(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getParent();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(W() + '{' + g0(M()) + '}');
        r100.append('@');
        r100.append(b0.a(this));
        return r100.toString();
    }

    public final Object C() {
        Object r100 = M();
        if ((!(r100 instanceof x0)) == false) goto L11;
        if ((r100 instanceof t) == true) goto L9;
        return g1.a(r100);
    L9:
        throw ((t) r100).f505148a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Throwable D() {
        Object r100 = M();
        if ((r100 instanceof c) == false) goto L10;
        Throwable r101 = ((c) r100).b();
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L10:
        if ((r100 instanceof x0) == true) goto L17;
        if ((r100 instanceof t) == true) goto L18;
        return null;
    L18:
        return ((t) r100).f505148a;
    L17:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final boolean E() {
        Object r100 = M();
        if ((r100 instanceof t) == false) goto L11;
        t r101 = (t) r100;
        r101.getClass();
        if (t.f505147b.get(r101) == 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = false;
        goto L8
    L11:
        return false;
    }

    public String W() {
        return getClass().getSimpleName();
    }

    @Override // kotlinx.coroutines.n1
    public final CancellationException e() {
        Object r100 = M();
        CancellationException r101 = null;
        if ((r100 instanceof c) == false) goto L6;
        Throwable r102 = ((c) r100).b();
    L12:
        if ((r102 instanceof CancellationException) == false) goto L14;
        r101 = (CancellationException) r102;
    L14:
        if (r101 == null) goto L16;
        return r101;
    L16:
        return new JobCancellationException("Parent job is ".concat(g0(r100)), r102, this);
    L6:
        if ((r100 instanceof t) == false) goto L9;
        r102 = ((t) r100).f505148a;
        goto L12
    L9:
        if ((r100 instanceof x0) == true) goto L18;
        r102 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r100).toString());
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object r100 = M();
        CancellationException r101 = null;
        if ((r100 instanceof c) == false) goto L17;
        Throwable r102 = ((c) r100).b();
        if (r102 == null) goto L15;
        String r103 = getClass().getSimpleName().concat(" is cancelling");
        if ((r102 instanceof CancellationException) == false) goto L9;
        r101 = (CancellationException) r102;
    L9:
        if (r101 == null) goto L11;
        return r101;
    L11:
        if (r103 != null) goto L26;
        r103 = x();
    L26:
        return new JobCancellationException(r103, r102, this);
    L15:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L17:
        if ((r100 instanceof x0) == true) goto L24;
        if ((r100 instanceof t) == false) goto L22;
        return h0(this, ((t) r100).f505148a);
    L22:
        return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
    L24:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object r100 = M();
        if ((!(r100 instanceof x0)) == false) goto L12;
        if ((r100 instanceof t) == false) goto L7;
        t r101 = (t) r100;
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.f505148a;
    L7:
        r101 = null;
        goto L8
    L12:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r100 = M();
        if ((r100 instanceof x0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((x0) r100).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r100 = M();
        if ((r100 instanceof t) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof c) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) r100).c() == false) goto L9;
        goto L9
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(M() instanceof x0);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r100 = e0(M());
        if (r100 == 0) goto L8;
        if (r100 != 1) goto L2;
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

    public JobSupport(boolean r100) {
        if (r100 == false) goto L5;
        p0 r101 = g1.f504918g;
    L6:
        this._state$volatile = r101;
        return;
    L5:
        r101 = g1.f504917f;
        goto L6
    }

    public static p X(LockFreeLinkedListNode r100) {
    L3:
        if (r100.h() == false) goto L5;
        r100 = r100.g();
    L5:
        r100 = r100.f();
        if (r100.h() == true) goto L5;
        if ((r100 instanceof p) == true) goto L10;
        if ((r100 instanceof j1) == false) goto L5;
        return null;
    L10:
        return (p) r100;
    }

    public static String g0(Object r100) {
        if ((r100 instanceof c) == false) goto L11;
        c r101 = (c) r100;
        if (r101.c() == false) goto L8;
        return "Cancelling";
    L8:
        if (r101.d() == false) goto L14;
        return "Completing";
    L14:
        return "Active";
    L11:
        if ((r100 instanceof x0) == false) goto L17;
        if (((x0) r100).isActive() == true) goto L14;
        return "New";
    L17:
        if ((r100 instanceof t) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public final Throwable A(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L9;
        Throwable r102 = (Throwable) r100;
        if (r102 == null) goto L12;
        return r102;
    L12:
        return new JobCancellationException(x(), null, this);
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((n1) r100).e();
    L4:
        r101 = r100 instanceof Throwable;
        goto L5
    }

    public final j1 J(x0 r100) {
        j1 r101 = r100.getList();
        if (r101 == null) goto L5;
        return r101;
    L5:
        if ((r100 instanceof p0) == false) goto L8;
        return new j1();
    L8:
        if ((r100 instanceof f1) == false) goto L11;
        d0((f1) r100);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r100).toString());
    }

    public final void P(Job r100) {
        if (r100 != null) goto L5;
        l1 r101 = l1.f504994a;
        f504600b.set(this, r101);
        return;
    L5:
        r100.start();
        o r102 = r100.attachChild(this);
        AtomicReferenceFieldUpdater r103 = f504600b;
        r103.set(this, r102);
        if (isCompleted() == false) goto L9;
        r102.dispose();
        r103.set(this, l1.f504994a);
        return;
    }

    public final boolean U(Object r100) {
    L2:
        Object r101 = i0(M(), r100);
        if (r101 == g1.f504912a) goto L4;
        if (r101 == g1.f504913b) goto L8;
        if (r101 == g1.f504914c) goto L2;
        o(r101);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object V(Object r100) {
    L2:
        Object r101 = i0(M(), r100);
        if (r101 == g1.f504912a) goto L7;
        if (r101 == g1.f504914c) goto L2;
        return r101;
    L7:
        String r102 = "Job " + this + " is already complete or completing, but is being completed with " + r100;
        Throwable r103 = null;
        if ((r100 instanceof t) == false) goto L10;
        t r104 = (t) r100;
    L11:
        if (r104 == null) goto L14;
        r103 = r104.f505148a;
    L14:
        throw new IllegalStateException(r102, r103);
    L10:
        r104 = null;
        goto L11
    }

    @Override // kotlinx.coroutines.q
    public final void a(JobSupport r100) {
        s(r100);
    }

    @Override // kotlinx.coroutines.Job
    public final o attachChild(q r100) {
        m0 r101 = JobKt.invokeOnCompletion$default(this, true, false, new p(r100), 2, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (o) r101;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable r100) {
        if (r100 == null) goto L4;
        Throwable r101 = h0(this, r100);
    L5:
        u(r101);
        return true;
    L4:
        r101 = new JobCancellationException(x(), null, this);
        goto L5
    }

    public final void d0(f1 r100) {
        j1 r101 = new j1();
        r100.getClass();
        LockFreeLinkedListNode.f504926b.set(r101, r100);
        LockFreeLinkedListNode.f504925a.set(r101, r100);
    L4:
        if (r100.e() != r100) goto L15;
        AtomicReferenceFieldUpdater r102 = LockFreeLinkedListNode.f504925a;
    L8:
        if (r102.compareAndSet(r100, r100, r101) == true) goto L9;
        if (r102.get(r100) == r100) goto L8;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L4;
        r101.d(r100);
        goto L15
    L9:
        r103 = true;
    L15:
        LockFreeLinkedListNode r104 = r100.f();
        AtomicReferenceFieldUpdater r105 = f504599a;
    L17:
        if (r105.compareAndSet(this, r100, r104) == true) goto L21;
        if (r105.get(this) == r100) goto L17;
        return;
    }

    public final int e0(Object r100) {
        boolean r101 = false;
        if ((r100 instanceof p0) == false) goto L18;
        if (((p0) r100).f505001a == false) goto L7;
        return 0;
    L7:
        AtomicReferenceFieldUpdater r102 = f504599a;
        p0 r103 = g1.f504918g;
    L9:
        if (r102.compareAndSet(this, r100, r103) == true) goto L10;
        if (r102.get(this) == r100) goto L9;
    L13:
        if (r101 == true) goto L15;
        return -1;
    L15:
        c0();
        return 1;
    L10:
        r101 = true;
        goto L13
    L18:
        if ((r100 instanceof w0) == false) goto L29;
        AtomicReferenceFieldUpdater r104 = f504599a;
        j1 r105 = ((w0) r100).f505155a;
    L21:
        if (r104.compareAndSet(this, r100, r105) == true) goto L22;
        if (r104.get(this) == r100) goto L21;
    L25:
        if (r101 == true) goto L27;
        return -1;
    L27:
        c0();
        return 1;
    L22:
        r101 = true;
        goto L25
    L29:
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) Job.DefaultImpls.get(this, r100);
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(Function1<? super Throwable, Unit> r100) {
        return Q(false, true, new z0.a(r100));
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> r110) {
    L2:
        Object r100 = M();
        if ((r100 instanceof x0) == false) goto L4;
        if (e0(r100) < 0) goto L2;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        JobKt.ensureActive(r110.getContext());
        return Unit.INSTANCE;
    L11:
        j r102 = new j(IntrinsicsKt.intercepted(r110), 1);
        r102.C();
        l.b(r102, new n0(JobKt.invokeOnCompletion$default(this, false, false, new p1(r102), 3, null)));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L15:
        if (r103 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r103 = Unit.INSTANCE;
    L19:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r103;
    L22:
        return Unit.INSTANCE;
    L4:
        r101 = false;
        goto L8
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return Job.DefaultImpls.minusKey(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        return Job.DefaultImpls.plus(this, r100);
    }

    public final Object q(Continuation<Object> r100) {
    L2:
        Object r101 = M();
        if ((r101 instanceof x0) == false) goto L5;
        if (e0(r101) < 0) goto L2;
        a r102 = new a(IntrinsicsKt.intercepted(r100), this);
        r102.C();
        l.b(r102, new n0(JobKt.invokeOnCompletion$default(this, false, false, new o1(r102), 3, null)));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L15:
        return r103;
    L5:
        if ((r101 instanceof t) == true) goto L9;
        return g1.a(r101);
    L9:
        throw ((t) r101).f505148a;
    }

    public final boolean s(Object r110) {
        Object r100 = g1.f504912a;
        if (I() == false) goto L19;
    L4:
        Object r101 = M();
        if ((r101 instanceof x0) == false) goto L14;
        if ((r101 instanceof c) == true) goto L9;
    L11:
        r100 = i0(r101, new t(A(r110), false));
        if (r100 == g1.f504914c) goto L4;
    L16:
        if (r100 != g1.f504913b) goto L19;
        return true;
    L9:
        if (((c) r101).d() == false) goto L11;
    L14:
        r100 = g1.f504912a;
    L19:
        if (r100 != g1.f504912a) goto L80;
        Throwable r102 = null;
        Throwable r103 = null;
    L21:
        Object r104 = M();
        if ((r104 instanceof c) == true) goto L23;
        if ((r104 instanceof x0) == false) goto L77;
        if (r103 != null) goto L53;
        r103 = A(r110);
    L53:
        x0 r105 = (x0) r104;
        if (r105.isActive() == true) goto L55;
        Object r106 = i0(r104, new t(r103, false));
        if (r106 == g1.f504912a) goto L76;
        if (r106 == g1.f504914c) goto L21;
        r100 = r106;
        goto L80
    L76:
        throw new IllegalStateException(("Cannot happen in " + r104).toString());
    L55:
        j1 r107 = J(r105);
        if (r107 == null) goto L66;
        c r108 = new c(r107, r103);
        AtomicReferenceFieldUpdater r109 = f504599a;
    L60:
        if (r109.compareAndSet(this, r105, r108) == true) goto L61;
        if (r109.get(this) == r105) goto L60;
        boolean r111 = false;
    L65:
        if (r111 == false) goto L66;
        Y(r107, r103);
        boolean r112 = true;
    L68:
        if (r112 == false) goto L21;
        kotlinx.coroutines.internal.b0 r113 = g1.f504912a;
    L78:
        r100 = r113;
        goto L80
    L61:
        r111 = true;
    L66:
        r112 = false;
        goto L68
    L77:
        r113 = g1.f504915d;
        goto L78
    L23:
        monitor-enter(r104);
    L46:
        th = move-exception;
        throw th;
    L25:
        if (c.f504608d.get((c) r104) != g1.f504916e) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L32;
        r113 = g1.f504915d;     // Catch: Throwable -> L46
        monitor-exit(r104);
        goto L78
    L32:
        boolean r115 = ((c) r104).c();     // Catch: Throwable -> L46
        if (r110 != null) goto L35;
        if (r115 == false) goto L35;
    L38:
        Throwable r116 = ((c) r104).b();     // Catch: Throwable -> L46
        if ((!r115) == false) goto L42;
        r102 = r116;
    L42:
        monitor-exit(r104);
        if (r102 == null) goto L45;
        Y(((c) r104).f504609a, r102);
    L45:
        r113 = g1.f504912a;
    L35:
        if (r103 != null) goto L37;
        r103 = A(r110);     // Catch: Throwable -> L46
    L37:
        ((c) r104).a(r103);     // Catch: Throwable -> L46
        goto L38
    L27:
        r114 = false;
    L80:
        if (r100 != g1.f504912a) goto L83;
    L89:
        return true;
    L83:
        if (r100 == g1.f504913b) goto L89;
        if (r100 == g1.f504915d) goto L109;
        o(r100);
        goto L89
    L109:
        return false;
    }

    public void u(Throwable r100) {
        s(r100);
    }

    public final boolean w(Throwable r100) {
        if (T() == false) goto L5;
        return true;
    L5:
        boolean r101 = r100 instanceof CancellationException;
        o r102 = (o) f504600b.get(this);
        if (r102 != null) goto L8;
    L16:
        return r101;
    L8:
        if (r102 == l1.f504994a) goto L16;
        if (r102.b(r100) == true) goto L17;
        if (r101 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    public boolean y(Throwable r100) {
        if ((r100 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (s(r100) == true) goto L8;
    L10:
        return false;
    L8:
        if (G() == false) goto L10;
        return true;
    }

    public void O(CompletionHandlerException r100) {
        throw r100;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException r100) {
        if (r100 != null) goto L4;
        r100 = new JobCancellationException(x(), null, this);
    L4:
        u(r100);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public final Job plus(Job r100) {
        return Job.DefaultImpls.plus(this, r100);
    }

    public static CancellationException h0(JobSupport r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof CancellationException) == false) goto L5;
        CancellationException r102 = (CancellationException) r101;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return new JobCancellationException(r100.x(), r101, r100);
    L5:
        r102 = null;
        goto L6
    }

    public final Object B(c r100, Object r110) {
        Throwable r101 = null;
        if ((r110 instanceof t) == false) goto L5;
        t r102 = (t) r110;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.f505148a;
    L8:
        monitor-enter(r100);
        boolean r103 = r100.c();     // Catch: Throwable -> L56
        List<Throwable> r104 = r100.e(r101);     // Catch: Throwable -> L56
        Throwable r105 = F(r100, r104);     // Catch: Throwable -> L56
        if (r105 != null) goto L12;
    L26:
        monitor-exit(r100);
        if (r105 == null) goto L33;
        if (r105 == r101) goto L33;
        r110 = new t(r105, false);
    L33:
        if (r105 != null) goto L35;
    L43:
        if (r103 == true) goto L45;
        Z(r105);
    L45:
        a0(r110);
        AtomicReferenceFieldUpdater r106 = f504599a;
        if ((r110 instanceof x0) == false) goto L48;
        Object r107 = new y0((x0) r110);
    L50:
        if (r106.compareAndSet(this, r100, r107) == true) goto L54;
        if (r106.get(this) == r100) goto L50;
    L54:
        z(r100, r110);
        return r110;
    L48:
        r107 = r110;
        goto L50
    L35:
        if (w(r105) == false) goto L37;
    L40:
        boolean r108 = true;
    L41:
        if (r108 == false) goto L43;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        t r109 = (t) r110;
        r109.getClass();
        t.f505147b.compareAndSet(r109, 0, 1);
        goto L43
    L37:
        if (N(r105) == true) goto L40;
        r108 = false;
        goto L41
    L12:
        if (r104.size() <= 1) goto L26;
        Set r111 = Collections.newSetFromMap(new IdentityHashMap(r104.size()));     // Catch: Throwable -> L56
        Iterator<Throwable> r112 = r104.iterator();     // Catch: Throwable -> L56
    L16:
        if (r112.hasNext() == false) goto L26;
        Throwable r113 = r112.next();     // Catch: Throwable -> L56
        if (r113 == r105) goto L16;
        if (r113 == r105) goto L16;
        if ((r113 instanceof CancellationException) == true) goto L16;
        if (r111.add(r113) == false) goto L16;
        ExceptionsKt.addSuppressed(r105, r113);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    public final Throwable F(c r100, List<? extends Throwable> r101) {
        Object r102 = null;
        if (r101.isEmpty() == true) goto L5;
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if ((!(((Throwable) r104) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r105 = (Throwable) r104;
        if (r105 == null) goto L19;
        return r105;
    L19:
        Throwable r106 = (Throwable) ListProtector.get(r101, 0);
        if ((r106 instanceof TimeoutCancellationException) == false) goto L35;
        Iterator<T> r107 = r101.iterator();
    L23:
        if (r107.hasNext() == false) goto L32;
        Object r108 = r107.next();
        Throwable r109 = (Throwable) r108;
        if (r109 != r106) goto L27;
    L29:
        boolean r110 = false;
    L30:
        if (r110 == false) goto L23;
        r102 = r108;
        goto L32
    L27:
        if ((r109 instanceof TimeoutCancellationException) == false) goto L29;
        r110 = true;
    L32:
        Throwable r111 = (Throwable) r102;
        if (r111 == null) goto L35;
        return r111;
    L35:
        return r106;
    L15:
        r104 = null;
        goto L16
    L5:
        if (r100.c() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(x(), null, this);
    }

    public final void Y(j1 r100, Throwable r101) {
        Z(r101);
        Object r102 = r100.e();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r103 = (LockFreeLinkedListNode) r102;
        CompletionHandlerException r104 = null;
    L4:
        if (Intrinsics.areEqual(r103, r100) == true) goto L15;
        if ((r103 instanceof d1) == false) goto L14;
        f1 r105 = (f1) r103;
        r105.a(r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r104 == null) goto L13;
        ExceptionsKt.addSuppressed(r104, th);
        goto L14
    L13:
        r104 = new CompletionHandlerException("Exception in completion handler " + r105 + " for " + this, th);
        Unit r106 = Unit.INSTANCE;
    L14:
        r103 = r103.f();
        goto L4
    L15:
        if (r104 == null) goto L17;
        O(r104);
    L17:
        w(r101);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) Job.DefaultImpls.fold(this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, java.lang.Throwable] */
    public final Object i0(Object r100, Object r110) {
        if ((r100 instanceof x0) == false) goto L5;
        boolean r101 = false;
        p r102 = null;
        if ((r100 instanceof p0) == true) goto L11;
        if ((r100 instanceof f1) == true) goto L11;
    L31:
        x0 r103 = (x0) r100;
        j1 r104 = J(r103);
        if (r104 != null) goto L35;
        return g1.f504914c;
    L35:
        if ((r103 instanceof c) == false) goto L37;
        c r105 = (c) r103;
    L38:
        if (r105 != null) goto L40;
        r105 = new c(r104, null);
    L40:
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        monitor-enter(r105);
    L88:
        th = move-exception;
        throw th;
    L43:
        if (r105.d() == false) goto L47;
        kotlinx.coroutines.internal.b0 r107 = g1.f504912a;     // Catch: Throwable -> L88
        monitor-exit(r105);
        return r107;
    L47:
        c.f504606b.set(r105, 1);     // Catch: Throwable -> L88
        if (r105 == r103) goto L59;
        AtomicReferenceFieldUpdater r108 = f504599a;     // Catch: Throwable -> L88
    L51:
        if (r108.compareAndSet(this, r103, r105) == true) goto L52;
        if (r108.get(this) == r103) goto L51;
    L55:
        if (r101 == true) goto L59;
        kotlinx.coroutines.internal.b0 r109 = g1.f504914c;     // Catch: Throwable -> L88
        monitor-exit(r105);
        return r109;
    L52:
        r101 = true;
    L59:
        boolean r111 = r105.c();     // Catch: Throwable -> L88
        if ((r110 instanceof t) == false) goto L62;
        t r112 = (t) r110;     // Catch: Throwable -> L88
    L63:
        if (r112 == null) goto L65;
        r105.a(r112.f505148a);     // Catch: Throwable -> L88
    L65:
        Throwable r113 = r105.b();     // Catch: Throwable -> L88
        if (Boolean.valueOf(!r111).booleanValue() == false) goto L68;
        ?? r114 = r113;
    L69:
        r106.element = r114;     // Catch: Throwable -> L88
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r105);
        if (r114 == 0) goto L74;
        Y(r104, r114);
    L74:
        if ((r103 instanceof p) == false) goto L76;
        p r116 = (p) r103;
    L77:
        if (r116 != null) goto L81;
        j1 r117 = r103.getList();
        if (r117 == null) goto L82;
        r102 = X(r117);
    L82:
        if (r102 == null) goto L87;
        if (j0(r105, r102, r110) == false) goto L87;
        return g1.f504913b;
    L87:
        return B(r105, r110);
    L81:
        r102 = r116;
        goto L82
    L76:
        r116 = null;
        goto L77
    L68:
        r114 = 0;
        goto L69
    L62:
        r112 = null;
        goto L63
    L37:
        r105 = null;
    L11:
        if ((r100 instanceof p) == true) goto L31;
        if ((r110 instanceof t) == true) goto L31;
        x0 r118 = (x0) r100;
        AtomicReferenceFieldUpdater r119 = f504599a;
        kotlinx.coroutines.internal.b0 r120 = g1.f504912a;
        if ((r110 instanceof x0) == false) goto L17;
        Object r121 = new y0((x0) r110);
    L19:
        if (r119.compareAndSet(this, r118, r121) == true) goto L20;
        if (r119.get(this) == r118) goto L19;
        boolean r122 = false;
    L24:
        if (r122 == false) goto L27;
        Z(null);
        a0(r110);
        z(r118, r110);
        r101 = true;
    L27:
        if (r101 == false) goto L30;
        return r110;
    L30:
        return g1.f504914c;
    L20:
        r122 = true;
        goto L24
    L17:
        r121 = r110;
        goto L19
    L5:
        return g1.f504912a;
    }

    public final void z(x0 r100, Object r101) {
        AtomicReferenceFieldUpdater r102 = f504600b;
        o r103 = (o) r102.get(this);
        if (r103 == null) goto L5;
        r103.dispose();
        r102.set(this, l1.f504994a);
    L5:
        CompletionHandlerException r104 = null;
        if ((r101 instanceof t) == false) goto L8;
        t r105 = (t) r101;
    L9:
        if (r105 == null) goto L11;
        Throwable r106 = r105.f505148a;
    L13:
        if ((r100 instanceof f1) == true) goto L36;
        j1 r107 = r100.getList();
        if (r107 == null) goto L46;
        Object r108 = r107.e();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r109 = (LockFreeLinkedListNode) r108;
    L22:
        if (Intrinsics.areEqual(r109, r107) == true) goto L33;
        if ((r109 instanceof f1) == false) goto L32;
        f1 r110 = (f1) r109;
        r110.a(r106);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r104 == null) goto L31;
        ExceptionsKt.addSuppressed(r104, th);
        goto L32
    L31:
        r104 = new CompletionHandlerException("Exception in completion handler " + r110 + " for " + this, th);
        Unit r111 = Unit.INSTANCE;
    L32:
        r109 = r109.f();
        goto L22
    L33:
        if (r104 == null) goto L47;
        O(r104);
        return;
    L47:
        return;
    L46:
        return;
    L36:
        ((f1) r100).a(r106);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        O(new CompletionHandlerException("Exception in completion handler " + r100 + " for " + this, th));
        return;
    L11:
        r106 = null;
        goto L13
    L8:
        r105 = null;
        goto L9
    }

    public final m0 Q(boolean r100, boolean r101, z0 r110) {
        Throwable r102 = null;
        if (r100 == false) goto L11;
        if ((r110 instanceof d1) == false) goto L7;
        f1 r103 = (d1) r110;
    L8:
        if (r103 != null) goto L17;
        r103 = new b1(r110);
    L17:
        r103.f504740d = this;
    L18:
        Object r104 = M();
        if ((r104 instanceof p0) == true) goto L20;
        if ((r104 instanceof x0) == false) goto L80;
        j1 r105 = ((x0) r104).getList();
        if (r105 == null) goto L46;
        m0 r106 = l1.f504994a;
        if (r100 == false) goto L72;
        if ((r104 instanceof c) == false) goto L72;
        monitor-enter(r104);
        Throwable r107 = ((c) r104).b();     // Catch: Throwable -> L69
        if (r107 == null) goto L59;
        if ((r110 instanceof p) == false) goto L66;
        if (((c) r104).d() == false) goto L59;
    L66:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(r104);
    L73:
        if (r107 != null) goto L74;
        if (n(r104, r105, r103) == false) goto L18;
        return r103;
    L74:
        if (r101 == false) goto L76;
        r110.a(r107);
    L76:
        return r106;
    L59:
        if (n(r104, r105, r103) == true) goto L62;
        monitor-exit(r104);
        goto L18
    L62:
        if (r107 == null) goto L63;
        r106 = r103;
        goto L66
    L63:
        monitor-exit(r104);
        return r103;
    L69:
        th = move-exception;
        throw th;
    L72:
        r107 = null;
        goto L73
    L46:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        d0((f1) r104);
        goto L18
    L80:
        if (r101 == false) goto L89;
        if ((r104 instanceof t) == false) goto L84;
        t r109 = (t) r104;
    L85:
        if (r109 == null) goto L87;
        r102 = r109.f505148a;
    L87:
        r110.a(r102);
        goto L89
    L84:
        r109 = null;
    L89:
        return l1.f504994a;
    L20:
        p0 r111 = (p0) r104;
        if (r111.f505001a == true) goto L22;
        j1 r112 = new j1();
        if (r111.f505001a == false) goto L34;
        x0 r113 = r112;
    L35:
        AtomicReferenceFieldUpdater r114 = f504599a;
    L37:
        if (r114.compareAndSet(this, r111, r113) == true) goto L18;
        if (r114.get(this) == r111) goto L37;
    L34:
        r113 = new w0(r112);
        goto L35
    L22:
        AtomicReferenceFieldUpdater r115 = f504599a;
    L24:
        if (r115.compareAndSet(this, r104, r103) == true) goto L25;
        if (r115.get(this) == r104) goto L24;
        boolean r116 = false;
    L29:
        if (r116 == false) goto L18;
        return r103;
    L25:
        r116 = true;
        goto L29
    L7:
        r103 = null;
        goto L8
    L11:
        if ((r110 instanceof f1) == false) goto L13;
        r103 = (f1) r110;
    L14:
        if (r103 != null) goto L17;
        r103 = new c1(r110);
        goto L17
    L13:
        r103 = null;
        goto L14
    }

    @Override // kotlinx.coroutines.Job
    public final m0 invokeOnCompletion(boolean r100, boolean r101, Function1<? super Throwable, Unit> r102) {
        return Q(r100, r101, new z0.a(r102));
    }

    public final boolean j0(c r100, p r101, Object r102) {
    L3:
        if (JobKt.invokeOnCompletion$default(r101.f505000e, false, false, new b(this, r100, r101, r102), 1, null) != l1.f504994a) goto L4;
        r101 = X(r101);
        if (r101 != null) goto L3;
        return false;
    L4:
        return true;
    }

    public final boolean n(Object r100, j1 r101, f1 r102) {
        f r103 = new f(r102, this, r100);
    L3:
        LockFreeLinkedListNode r104 = r101.g();
        LockFreeLinkedListNode.f504926b.set(r102, r104);
        AtomicReferenceFieldUpdater r105 = LockFreeLinkedListNode.f504925a;
        r105.set(r102, r101);
        r103.f504929c = r101;
    L5:
        if (r105.compareAndSet(r104, r101, r103) == true) goto L6;
        if (r105.get(r104) == r101) goto L5;
        boolean r106 = false;
    L11:
        if (r106 == true) goto L14;
        char r107 = 0;
    L17:
        if (r107 == 1) goto L20;
        if (r107 != 2) goto L3;
        return false;
    L20:
        return true;
    L14:
        if (r103.a(r104) != null) goto L16;
        r107 = 1;
        goto L17
    L16:
        r107 = 2;
        goto L17
    L6:
        r106 = true;
        goto L11
    }
}
