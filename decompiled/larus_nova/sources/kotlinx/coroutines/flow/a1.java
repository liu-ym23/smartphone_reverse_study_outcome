package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class a1<T> implements d1<T>, Flow, kotlinx.coroutines.flow.internal.l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f504834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d1<T> f504835b;

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<?> r101) {
        return this.f504835b.collect(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        return this.f504835b.getReplayCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a1(d1<? extends T> r100, Job r101) {
        this.f504834a = r101;
        this.f504835b = r100;
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102) {
        return SharedFlowKt.fuseSharedFlow(this, r100, r101, r102);
    }
}
