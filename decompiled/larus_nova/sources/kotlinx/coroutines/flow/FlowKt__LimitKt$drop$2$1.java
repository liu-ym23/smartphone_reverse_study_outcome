package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$drop$2$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f504771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f504772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f504773c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1(Ref.IntRef r100, int r101, FlowCollector<? super T> r102) {
        this.f504771a = r100;
        this.f504772b = r101;
        this.f504773c = r102;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__LimitKt$drop$2$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$drop$2$1$emit$1 r102 = (FlowKt__LimitKt$drop$2$1$emit$1) r101;
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
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Ref.IntRef r107 = this.f504771a;
        int r108 = r107.element;
        if (r108 < this.f504772b) goto L21;
        FlowCollector<T> r109 = this.f504773c;
        r102.label = 1;
        if (r109.emit(r100, r102) != r105) goto L20;
        return r105;
    L21:
        r107.element = r108 + 1;
        return Unit.INSTANCE;
    L7:
        r102 = new FlowKt__LimitKt$drop$2$1$emit$1(this, r101);
        goto L8
    }
}
