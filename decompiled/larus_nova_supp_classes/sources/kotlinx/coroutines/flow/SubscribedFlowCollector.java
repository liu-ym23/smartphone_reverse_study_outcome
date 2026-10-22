package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    public final FlowCollector<T> a;
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> b;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r2, Continuation<? super Unit> r3) {
        return this.a.emit(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(Continuation<? super Unit> r7) {
        if ((r7 instanceof onSubscription.1) == false) goto L7;
        onSubscription.1 r0 = (onSubscription.1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        SafeCollector r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r4 = (SafeCollector) r0.L$1;
        SubscribedFlowCollector<T> r5 = (SubscribedFlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L32
    L23:
        r4.releaseIntercepted();
        FlowCollector<T> r9 = r5.a;
        r3 = r9 instanceof SubscribedFlowCollector;
        if (r3 == 0) goto L31;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (((SubscribedFlowCollector) r9).a(r0) != r2) goto L29;
        return r2;
    L31:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r8);
        r4 = new SafeCollector(this.a, r0.getContext());
        Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> r10 = this.b;     // Catch: Throwable -> L32
        r0.L$0 = this;     // Catch: Throwable -> L32
        r0.L$1 = r4;     // Catch: Throwable -> L32
        r0.label = 1;     // Catch: Throwable -> L32
        if (r10.invoke(r4, r0) != r2) goto L22;
        return r2;
    L22:
        r5 = this;
    L32:
        th = move-exception;
        r3.releaseIntercepted();
        throw th;
    L7:
        r0 = new onSubscription.1(this, r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> r1, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r2) {
        this.a = r1;
        this.b = r2;
    }
}
