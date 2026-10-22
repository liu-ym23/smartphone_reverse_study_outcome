package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__ErrorsKt$catchImpl$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f504766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f504767b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2(FlowCollector<? super T> r100, Ref.ObjectRef<Throwable> r101) {
        this.f504766a = r100;
        this.f504767b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$2$emit$1 r102 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        FlowKt__ErrorsKt$catchImpl$2<T> r107 = (FlowKt__ErrorsKt$catchImpl$2) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L23:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r6 = (T) th;
    L26:
        T r108 = (T) r6;
        r107.f504767b.element = r108;
        throw ((Throwable) r6);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        FlowCollector<T> r109 = this.f504766a;     // Catch: Throwable -> L24
        r102.L$0 = this;     // Catch: Throwable -> L24
        r102.label = 1;     // Catch: Throwable -> L24
        if (r109.emit(r100, r102) != r105) goto L23;
        return r105;
    L24:
        th = move-exception;
        r6 = (T) th;
        r107 = this;
    L7:
        r102 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, r101);
        goto L8
    }
}
