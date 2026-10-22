package io.ktor.util.pipeline;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements Continuation<Unit>, CoroutineStackFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f491979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g<Object, Object> f491980b;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        if (this.f491979a != Integer.MIN_VALUE) goto L5;
        this.f491979a = this.f491980b.f491985f;
    L5:
        int r100 = this.f491979a;
        if (r100 >= 0) goto L19;
        this.f491979a = Integer.MIN_VALUE;
        Continuation<Object> r101 = null;
    L15:
        if ((r101 instanceof CoroutineStackFrame) == true) goto L17;
        return null;
    L17:
        return (CoroutineStackFrame) r101;
    L19:
        r101 = this.f491980b.f491984e[r100];     // Catch: Throwable -> L13
        if (r101 != null) goto L11;
        r101 = e.f491978a;     // Catch: Throwable -> L13
    L18:
        goto L15
    L11:
        this.f491979a = r100 - 1;     // Catch: Throwable -> L13
    L13:
        r101 = e.f491978a;
        goto L15
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        g<Object, Object> r100 = this.f491980b;
        Continuation<Object>[] r101 = r100.f491984e;
        int r102 = r100.f491985f;
        Continuation<Object> r103 = r101[r102];
        if (r103 == this) goto L7;
        if (r103 == null) goto L7;
        return r103.getContext();
    L7:
        int r104 = r102 - 1;
    L8:
        if (r104 < 0) goto L16;
        int r105 = r104 - 1;
        Continuation<Object> r106 = this.f491980b.f491984e[r104];
        if (r106 == this) goto L14;
        if (r106 == null) goto L14;
        return r106.getContext();
    L14:
        r104 = r105;
        goto L8
    L16:
        throw new IllegalStateException("Not started".toString());
    }

    public f(g<Object, Object> r100) {
        this.f491980b = r100;
        this.f491979a = Integer.MIN_VALUE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        if (Result.m9455isFailureimpl(r100) == false) goto L6;
        g<Object, Object> r101 = this.f491980b;
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        Intrinsics.checkNotNull(r102);
        r101.g(Result.m9449constructorimpl(ResultKt.createFailure(r102)));
        return;
    L6:
        this.f491980b.f(false);
    }
}
