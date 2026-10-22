package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g<S, T> extends d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Flow<S> f504885d;

    public abstract Object g(FlowCollector<? super T> r100, Continuation<? super Unit> r101);

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return this.f504885d + " -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.k<? super T> r100, Continuation<? super Unit> r101) {
        Object r102 = g(new p(r100), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
        if (this.f504883b != (-3)) goto L23;
        CoroutineContext r102 = r101.getContext();
        CoroutineContext r103 = CoroutineContextKt.b(r102, this.f504882a);
        if (Intrinsics.areEqual(r103, r102) == false) goto L10;
        Object r104 = g(r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        return r104;
    L28:
        return Unit.INSTANCE;
    L10:
        ContinuationInterceptor.Key r105 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r103.get(r105), r102.get(r105)) == false) goto L23;
        CoroutineContext r106 = r101.getContext();
        if ((r100 instanceof p) == false) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L19;
        r100 = new UndispatchedContextCollector(r100, r106);
    L19:
        ChannelFlowOperator$collectWithContextUndispatched$2 r108 = new ChannelFlowOperator$collectWithContextUndispatched$2(this, null);
        Object r109 = e.a(r103, r100, ThreadContextKt.b(r103), r108, r101);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r109;
    L29:
        return Unit.INSTANCE;
    L15:
        r107 = r100 instanceof n;
    L23:
        Object r110 = super.collect(r100, r101);
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r110;
    L27:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Flow<? extends S> r100, CoroutineContext r101, int r102, BufferOverflow r103) {
        super(r101, r102, r103);
        this.f504885d = r100;
    }
}
