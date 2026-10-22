package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i<T> extends i0<T> implements CoroutineStackFrame, Continuation<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final CoroutineDispatcher d;
    public final Continuation<T> e;
    public Object f;
    public final Object g;

    static {
        h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    @Override // kotlinx.coroutines.i0
    public final Continuation<T> c() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r0 = this.e;
        if ((r0 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r0;
    }

    @Override // kotlinx.coroutines.i0
    public final Object s() {
        Object r0 = this.f;
        this.f = j.a;
        return r0;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("DispatchedContinuation[");
        r0.append(this.d);
        r0.append(", ");
        Continuation<T> r1 = this.e;
        if ((r1 instanceof i) == false) goto L17;
        String r2 = r1.toString();
    L15:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.m49constructorimpl(r1 + '@' + kotlinx.coroutines.b0.a(r1));     // Catch: Throwable -> L8
    L11:
        if (Result.m52exceptionOrNullimpl(r4) == null) goto L14;
        r4 = r1.getClass().getName() + '@' + kotlinx.coroutines.b0.a(r1);
    L14:
        r2 = (String) r4;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r6) {
        CoroutineContext r0 = this.e.getContext();
        Throwable r1 = Result.m52exceptionOrNullimpl(r6);
        if (r1 != null) goto L5;
        Object r3 = r6;
    L7:
        if (this.d.isDispatchNeeded(r0) == false) goto L9;
        this.f = r3;
        this.c = 0;
        this.d.dispatch(r0, this);
        return;
    L9:
        q0 r2 = v1.a();
        if (r2.l() == false) goto L12;
        this.f = r3;
        this.c = 0;
        r2.h(this);
        return;
    L12:
        r2.i(true);
        CoroutineContext r4 = getContext();     // Catch: Throwable -> L22
        Object r5 = ThreadContextKt.c(r4, this.g);     // Catch: Throwable -> L22
        this.e.resumeWith(r6);     // Catch: Throwable -> L19
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        ThreadContextKt.a(r4, r5);     // Catch: Throwable -> L22
    L17:
        if (r2.n() == true) goto L17;
    L25:
        r2.d(true);
        return;
    L19:
        th = move-exception;
        ThreadContextKt.a(r4, r5);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        o(th, null);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r2.d(true);
        throw th;
    L5:
        r3 = new kotlinx.coroutines.t(r1, false);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(CoroutineDispatcher r2, Continuation<? super T> r3) {
        super(-1);
        this.d = r2;
        this.e = r3;
        this.f = j.a;
        this.g = ThreadContextKt.b(getContext());
    }

    @Override // kotlinx.coroutines.i0
    public final void a(Object r2, Throwable r3) {
        if ((r2 instanceof kotlinx.coroutines.u) == false) goto L6;
        ((kotlinx.coroutines.u) r2).b.invoke(r3);
        return;
    }
}
