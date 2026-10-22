package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
final class FlowKt__ReduceKt$singleOrNull$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public FlowKt__ReduceKt$singleOrNull$1(Continuation<? super FlowKt__ReduceKt$singleOrNull$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        FlowKt__ReduceKt$singleOrNull$1<T> r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        g0 r105 = (g0) r102.L$1;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: AbortFlowException -> L12
    L23:
        T r107 = r106.element;
        if (r107 != kotlinx.coroutines.flow.internal.o.f504892a) goto L27;
        return null;
    L27:
        return r107;
    L12:
        AbortFlowException e100 = e;
    L22:
        if (e100.owner == r105) goto L23;
        throw e100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r108 = new Ref.ObjectRef();
        r108.element = (T) kotlinx.coroutines.flow.internal.o.f504892a;
        r105 = new g0(r108);
        r102.L$0 = r108;     // Catch: AbortFlowException -> L19
        r102.L$1 = r105;     // Catch: AbortFlowException -> L19
        r102.label = 1;     // Catch: AbortFlowException -> L19
        throw null;
    L19:
        e = move-exception;
        e100 = e;
        r106 = r108;
        goto L22
    L5:
        r102 = new FlowKt__ReduceKt$singleOrNull$1(this);
        goto L6
    }
}
