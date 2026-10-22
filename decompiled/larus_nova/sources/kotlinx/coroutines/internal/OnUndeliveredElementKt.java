package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes42.dex */
public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, Unit> a(final Function1<? super E, Unit> r100, final E r101, final CoroutineContext r102) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(r100, r101, r102);
    }

    public static final <E> void b(Function1<? super E, Unit> r100, E r101, CoroutineContext r102) {
        UndeliveredElementException r103 = c(r100, r101, null);
        if (r103 == null) goto L6;
        kotlinx.coroutines.y.a(r102, r103);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(Function1<? super E, Unit> r100, E r101, UndeliveredElementException r102) {
        r100.invoke(r101);     // Catch: Throwable -> L4
    L9:
        return r102;
    L4:
        th = move-exception;
        if (r102 == null) goto L11;
        if (r102.getCause() == th) goto L11;
        ExceptionsKt.addSuppressed(r102, th);
    L11:
        return new UndeliveredElementException("Exception in undelivered element handler for " + r101, th);
    }
}
