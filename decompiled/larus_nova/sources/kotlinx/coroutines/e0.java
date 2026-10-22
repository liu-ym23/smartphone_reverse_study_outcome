package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class e0<T> extends a<T> implements Deferred<T> {
    @Override // kotlinx.coroutines.Deferred
    public final T getCompleted() {
        return (T) C();
    }

    @Override // kotlinx.coroutines.Deferred
    public final kotlinx.coroutines.selects.g<T> getOnAwait() {
        kotlinx.coroutines.selects.h r100 = H();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return r100;
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation<? super T> r100) {
        Object r101 = q(r100);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r101;
    }

    public e0(CoroutineContext r100, boolean r101) {
        super(r100, true, r101);
    }
}
