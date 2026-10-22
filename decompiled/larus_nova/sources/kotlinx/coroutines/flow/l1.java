package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public final class l1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f504901a;

    public l1(Throwable r100) {
        this.f504901a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation<? super Unit> r101) {
        throw this.f504901a;
    }
}
