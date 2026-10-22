package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> f504770a;

    public FlowKt__LimitKt$collectWhile$collector$1() {
        this.f504770a = null;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 r102 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        FlowKt__LimitKt$collectWhile$collector$1 r107 = (FlowKt__LimitKt$collectWhile$collector$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        if (((Boolean) r104).booleanValue() == false) goto L23;
        return Unit.INSTANCE;
    L23:
        throw new AbortFlowException(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Function2<Object, Continuation<? super Boolean>, Object> r108 = this.f504770a;
        r102.L$0 = this;
        r102.label = 1;
        r104 = r108.invoke(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L17:
        r107 = this;
    L7:
        r102 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r101);
        goto L8
    }
}
