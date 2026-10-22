package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class r<T> extends JobSupport implements CompletableDeferred<T> {
    public final T getCompleted() {
        return (T) C();
    }

    public final g<T> getOnAwait() {
        kotlinx.coroutines.selects.h r0 = H();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return r0;
    }

    public r(Job r2) {
        super(true);
        P(r2);
    }

    public final Object await(Continuation<? super T> r1) {
        Object r2 = q(r1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r2;
    }

    public final boolean complete(T r1) {
        return U(r1);
    }

    public final boolean completeExceptionally(Throwable r3) {
        return U(new t(r3, false));
    }
}
