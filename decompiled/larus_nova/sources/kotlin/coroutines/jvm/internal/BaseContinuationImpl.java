package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001b\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public abstract Object invokeSuspend(Object r100);

    public void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> r100 = this.completion;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Continuation at ");
        Object r101 = getStackTraceElement();
        if (r101 != null) goto L6;
        r101 = getClass().getName();
    L6:
        r100.append(r101);
        return r100.toString();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public BaseContinuationImpl(Continuation<Object> r100) {
        this.completion = r100;
    }

    public Continuation<Unit> create(Continuation<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        Continuation<Object> r101 = this;
    L3:
        DebugProbesKt.probeCoroutineResumed(r101);
        BaseContinuationImpl r102 = (BaseContinuationImpl) r101;
        Continuation<Object> r103 = r102.completion;
        Intrinsics.checkNotNull(r103);
        Object r104 = r102.invokeSuspend(r100);     // Catch: Throwable -> L9
        if (r104 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        r100 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        r102.releaseIntercepted();
        if ((r103 instanceof BaseContinuationImpl) == false) goto L14;
        r101 = r103;
        goto L3
    L14:
        r103.resumeWith(r100);
        return;
    L6:
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r100 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
