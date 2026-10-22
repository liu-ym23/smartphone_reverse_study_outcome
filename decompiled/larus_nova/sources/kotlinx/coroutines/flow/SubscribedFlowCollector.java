package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowCollector<T> f504830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f504831b;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        return this.f504830a.emit(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof SubscribedFlowCollector$onSubscription$1) == false) goto L7;
        SubscribedFlowCollector$onSubscription$1 r101 = (SubscribedFlowCollector$onSubscription$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r106 = (SafeCollector) r101.L$1;
        SubscribedFlowCollector<T> r107 = (SubscribedFlowCollector) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L32
    L23:
        r106.releaseIntercepted();
        FlowCollector<T> r108 = r107.f504830a;
        r105 = r108 instanceof SubscribedFlowCollector;
        if (r105 == 0) goto L31;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (((SubscribedFlowCollector) r108).a(r101) != r104) goto L29;
        return r104;
    L31:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r103);
        r106 = new SafeCollector(this.f504830a, r101.getContext());
        Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> r109 = this.f504831b;     // Catch: Throwable -> L32
        r101.L$0 = this;     // Catch: Throwable -> L32
        r101.L$1 = r106;     // Catch: Throwable -> L32
        r101.label = 1;     // Catch: Throwable -> L32
        if (r109.invoke(r106, r101) != r104) goto L22;
        return r104;
    L22:
        r107 = this;
    L32:
        th = move-exception;
        r105.releaseIntercepted();
        throw th;
    L7:
        r101 = new SubscribedFlowCollector$onSubscription$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> r100, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r101) {
        this.f504830a = r100;
        this.f504831b = r101;
    }
}
