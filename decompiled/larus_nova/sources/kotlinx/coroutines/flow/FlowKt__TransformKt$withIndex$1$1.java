package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__TransformKt$withIndex$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<IndexedValue<? extends T>> f504803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f504804b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$withIndex$1$1(FlowCollector<? super IndexedValue<? extends T>> r100, Ref.IntRef r101) {
        this.f504803a = r100;
        this.f504804b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowKt__TransformKt$withIndex$1$1$emit$1) == false) goto L7;
        FlowKt__TransformKt$withIndex$1$1$emit$1 r102 = (FlowKt__TransformKt$withIndex$1$1$emit$1) r101;
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
        FlowCollector<IndexedValue<? extends T>> r107 = this.f504803a;
        Ref.IntRef r108 = this.f504804b;
        int r109 = r108.element;
        r108.element = r109 + 1;
        if (r109 < 0) goto L22;
        IndexedValue<? extends T> r110 = new IndexedValue(r109, r100);
        r102.label = 1;
        if (r107.emit(r110, r102) != r105) goto L20;
        return r105;
    L22:
        throw new ArithmeticException("Index overflow has happened");
    L7:
        r102 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, r101);
        goto L8
    }
}
