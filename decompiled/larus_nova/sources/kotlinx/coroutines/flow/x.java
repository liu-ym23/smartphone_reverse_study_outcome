package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class x {
    public static final Object a(FlowCollector r100, Object r101, Object r102, Continuation r103) {
        if ((r103 instanceof FlowKt__LimitKt$emitAbort$1) == false) goto L7;
        FlowKt__LimitKt$emitAbort$1 r104 = (FlowKt__LimitKt$emitAbort$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L12;
        r102 = r104.L$0;
        ResultKt.throwOnFailure(r106);
    L18:
        throw new AbortFlowException(r102);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r102;
        r104.label = 1;
        if (r100.emit(r101, r104) != r107) goto L18;
        return r107;
    L7:
        r104 = new FlowKt__LimitKt$emitAbort$1(r103);
        goto L8
    }
}
