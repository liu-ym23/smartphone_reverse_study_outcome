package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends g<T, T> {
    @Override // kotlinx.coroutines.flow.internal.d
    public final Flow<T> e() {
        return (Flow<T>) this.f504885d;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.g
    public final Object g(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
        Object r102 = this.f504885d.collect((FlowCollector<? super S>) r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final d<T> d(CoroutineContext r100, int r101, BufferOverflow r102) {
        return new h(this.f504885d, r100, r101, r102);
    }

    public h(Flow<? extends T> r100, CoroutineContext r101, int r102, BufferOverflow r103) {
        super(r100, r101, r102, r103);
    }

    public h(Flow r100, CoroutineDispatcher r101, int r102, BufferOverflow r103, int r104) {
        CoroutineContext r105 = r101;
        if ((r104 & 2) == 0) goto L6;
        r105 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = -3;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = BufferOverflow.SUSPEND;
    L11:
        super(r100, r105, r102, r103);
    }
}
