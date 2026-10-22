package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T> extends x<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean y(Throwable r100) {
        if ((r100 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return s(r100);
    }

    public j(CoroutineContext r100, Continuation<? super T> r101) {
        super(r100, r101);
    }
}
