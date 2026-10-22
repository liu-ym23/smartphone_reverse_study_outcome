package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class x<T> extends kotlinx.coroutines.a<T> implements CoroutineStackFrame {
    public final Continuation<T> d;

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
        Continuation<T> r0 = this.d;
        if ((r0 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r0;
    }

    @Override // kotlinx.coroutines.a
    public void k0(Object r2) {
        this.d.resumeWith(kotlinx.coroutines.v.a(r2));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void o(Object r3) {
        j.a(IntrinsicsKt.intercepted(this.d), kotlinx.coroutines.v.a(r3), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(CoroutineContext r2, Continuation<? super T> r3) {
        super(r2, true, true);
        this.d = r3;
    }
}
