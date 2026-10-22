package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes.dex */
public final class i<T> extends kotlinx.coroutines.i0<T> implements CoroutineStackFrame, Continuation<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504951h = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f504952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation<T> f504953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f504954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f504955g;

    static {
        f504951h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    @Override // kotlinx.coroutines.i0
    public final Continuation<T> c() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f504953e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r100 = this.f504953e;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    @Override // kotlinx.coroutines.i0
    public final Object s() {
        Object r100 = this.f504954f;
        this.f504954f = j.f504960a;
        return r100;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("DispatchedContinuation[");
        r100.append(this.f504952d);
        r100.append(", ");
        Continuation<T> r101 = this.f504953e;
        if ((r101 instanceof i) == false) goto L17;
        String r102 = r101.toString();
    L15:
        r100.append(r102);
        r100.append(']');
        return r100.toString();
    L17:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(r101 + '@' + kotlinx.coroutines.b0.a(r101));     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L14;
        r104 = r101.getClass().getName() + '@' + kotlinx.coroutines.b0.a(r101);
    L14:
        r102 = (String) r104;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        CoroutineContext r101 = this.f504953e.getContext();
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 != null) goto L5;
        Object r103 = r100;
    L7:
        if (this.f504952d.isDispatchNeeded(r101) == false) goto L9;
        this.f504954f = r103;
        this.f504922c = 0;
        this.f504952d.dispatch(r101, this);
        return;
    L9:
        q0 r104 = v1.a();
        if (r104.l() == false) goto L12;
        this.f504954f = r103;
        this.f504922c = 0;
        r104.h(this);
        return;
    L12:
        r104.i(true);
        CoroutineContext r105 = getContext();     // Catch: Throwable -> L22
        Object r106 = ThreadContextKt.c(r105, this.f504955g);     // Catch: Throwable -> L22
        this.f504953e.resumeWith(r100);     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        ThreadContextKt.a(r105, r106);     // Catch: Throwable -> L22
    L17:
        if (r104.n() == true) goto L17;
    L25:
        r104.d(true);
        return;
    L19:
        th = move-exception;
        ThreadContextKt.a(r105, r106);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        o(th, null);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r104.d(true);
        throw th;
    L5:
        r103 = new kotlinx.coroutines.t(r102, false);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(CoroutineDispatcher r100, Continuation<? super T> r101) {
        super(-1);
        this.f504952d = r100;
        this.f504953e = r101;
        this.f504954f = j.f504960a;
        this.f504955g = ThreadContextKt.b(getContext());
    }

    @Override // kotlinx.coroutines.i0
    public final void a(Object r100, Throwable r101) {
        if ((r100 instanceof kotlinx.coroutines.u) == false) goto L6;
        ((kotlinx.coroutines.u) r100).f505152b.invoke(r101);
        return;
    }
}
