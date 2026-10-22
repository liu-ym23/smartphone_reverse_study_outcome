package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class s1<T> extends kotlinx.coroutines.internal.x<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean y(Throwable r100) {
        return false;
    }

    public s1(CoroutineContext r100, Continuation<? super T> r101) {
        super(r100, r101);
    }
}
