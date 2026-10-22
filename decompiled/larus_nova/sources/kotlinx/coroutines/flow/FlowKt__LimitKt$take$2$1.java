package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f504779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f504780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f504781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f504782d;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$take$2$1(Ref.IntRef r100, int r101, FlowCollector<? super T> r102, Object r103) {
        this.f504779a = r100;
        this.f504780b = r101;
        this.f504781c = r102;
        this.f504782d = r103;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__LimitKt$take$2$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$take$2$1$emit$1 r102 = (FlowKt__LimitKt$take$2$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r104);
        Ref.IntRef r107 = this.f504779a;
        int r108 = r107.element + 1;
        r107.element = r108;
        if (r108 >= this.f504780b) goto L23;
        FlowCollector<T> r109 = this.f504781c;
        r102.label = 1;
        if (r109.emit(r100, r102) != r105) goto L22;
        return r105;
    L23:
        FlowCollector<T> r110 = this.f504781c;
        Object r111 = this.f504782d;
        r102.label = 2;
        if (x.a(r110, r100, r111, r102) != r105) goto L27;
        return r105;
    L7:
        r102 = new FlowKt__LimitKt$take$2$1$emit$1(this, r101);
        goto L8
    }
}
