package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes6.dex */
public final class q<T> implements Continuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Continuation<T> f504896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f504897b;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r100 = this.f504896a;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f504897b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        this.f504896a.resumeWith(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(Continuation<? super T> r100, CoroutineContext r101) {
        this.f504896a = r100;
        this.f504897b = r101;
    }
}
