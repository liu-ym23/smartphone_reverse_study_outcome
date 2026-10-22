package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes.dex */
public class x<T> extends kotlinx.coroutines.a<T> implements CoroutineStackFrame {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation<T> f504982d;

    @Override // kotlinx.coroutines.JobSupport
    public final boolean T() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r100 = this.f504982d;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    @Override // kotlinx.coroutines.a
    public void k0(Object r100) {
        this.f504982d.resumeWith(kotlinx.coroutines.v.a(r100));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void o(Object r100) {
        j.a(IntrinsicsKt.intercepted(this.f504982d), kotlinx.coroutines.v.a(r100), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(CoroutineContext r100, Continuation<? super T> r101) {
        super(r100, true, true);
        this.f504982d = r101;
    }
}
