package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class b1<T> implements i1<T>, Flow, kotlinx.coroutines.flow.internal.l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f504840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i1<T> f504841b;

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<?> r101) {
        return this.f504841b.collect(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        return this.f504841b.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.i1
    public final T getValue() {
        return this.f504841b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(i1<? extends T> r100, Job r101) {
        this.f504840a = r101;
        this.f504841b = r100;
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102) {
        kotlinx.coroutines.internal.b0 r103 = j1.f504898a;
        if (r101 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L12;
        if (r101 == (-2)) goto L12;
    L15:
        return SharedFlowKt.fuseSharedFlow(this, r100, r101, r102);
    L12:
        if (r102 != BufferOverflow.DROP_OLDEST) goto L15;
        return this;
    L5:
        if (r101 >= 2) goto L7;
        r104 = true;
        goto L8
    }
}
