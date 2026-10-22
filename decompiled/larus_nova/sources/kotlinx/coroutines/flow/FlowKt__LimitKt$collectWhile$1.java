package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {133}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        FlowKt__LimitKt$collectWhile$1<T> r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        FlowKt__LimitKt$collectWhile$collector$1 r105 = (FlowKt__LimitKt$collectWhile$collector$1) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: AbortFlowException -> L12
    L25:
        return Unit.INSTANCE;
    L12:
        AbortFlowException e100 = e;
    L23:
        if (e100.owner == r105) goto L25;
        throw e100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        FlowKt__LimitKt$collectWhile$collector$1 r106 = new FlowKt__LimitKt$collectWhile$collector$1();
        r102.L$0 = r106;     // Catch: AbortFlowException -> L20
        r102.label = 1;     // Catch: AbortFlowException -> L20
        throw null;
    L20:
        e = move-exception;
        e100 = e;
        r105 = r106;
        goto L23
    L5:
        r102 = new FlowKt__LimitKt$collectWhile$1(this);
        goto L6
    }
}
