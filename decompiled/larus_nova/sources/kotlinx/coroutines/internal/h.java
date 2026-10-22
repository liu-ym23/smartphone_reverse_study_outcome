package kotlinx.coroutines.internal;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes6.dex */
public final class h {
    public static final void a(CoroutineContext r100, Throwable r101) {
        Iterator<CoroutineExceptionHandler> r102 = g.f504948a.iterator();
    L4:
        if (r102.hasNext() == true) goto L20;
        ExceptionsKt.addSuppressed(r101, new DiagnosticCoroutineContextException(r100));     // Catch: Throwable -> L17
    L15:
        Thread r103 = ThreadMethodProxy.currentThread();
        r103.getUncaughtExceptionHandler().uncaughtException(r103, r101);
        return;
    L20:
        r102.next().handleException(r100, r101);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L13
    L13:
        return;
    L8:
        th = move-exception;
        if (r101 != th) goto L11;
        Throwable r104 = r101;
    L12:
        Thread r105 = ThreadMethodProxy.currentThread();
        r105.getUncaughtExceptionHandler().uncaughtException(r105, r104);
        goto L4
    L11:
        r104 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r104, r101);
        goto L12
    }
}
