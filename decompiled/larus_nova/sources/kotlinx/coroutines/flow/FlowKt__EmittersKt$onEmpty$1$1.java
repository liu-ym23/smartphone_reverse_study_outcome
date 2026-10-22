package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__EmittersKt$onEmpty$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f504758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f504759b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$onEmpty$1$1(Ref.BooleanRef r100, FlowCollector<? super T> r101) {
        this.f504758a = r100;
        this.f504759b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__EmittersKt$onEmpty$1$1$emit$1) == false) goto L7;
        FlowKt__EmittersKt$onEmpty$1$1$emit$1 r102 = (FlowKt__EmittersKt$onEmpty$1$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        this.f504758a.element = false;
        FlowCollector<T> r107 = this.f504759b;
        r102.label = 1;
        if (r107.emit(r100, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new FlowKt__EmittersKt$onEmpty$1$1$emit$1(this, r101);
        goto L8
    }
}
