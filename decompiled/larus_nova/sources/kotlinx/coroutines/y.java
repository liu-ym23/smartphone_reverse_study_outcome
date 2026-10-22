package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
public final class y {
    public static final void a(CoroutineContext r100, Throwable r101) {
        CoroutineExceptionHandler r102 = (CoroutineExceptionHandler) r100.get(CoroutineExceptionHandler.Key);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.handleException(r100, r101);     // Catch: Throwable -> L8
        return;
    L6:
        kotlinx.coroutines.internal.h.a(r100, r101);
        return;
    L8:
        th = move-exception;
        if (r101 == th) goto L12;
        RuntimeException r103 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r103, r101);
        r101 = r103;
    L12:
        kotlinx.coroutines.internal.h.a(r100, r101);
    }
}
