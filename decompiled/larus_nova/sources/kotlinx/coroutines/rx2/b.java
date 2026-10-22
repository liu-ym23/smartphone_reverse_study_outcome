package kotlinx.coroutines.rx2;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static final void a(Throwable r100, CoroutineContext r101) {
        if ((r100 instanceof CancellationException) == false) goto L10;
        return;
    L10:
        RxJavaPlugins.onError(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ExceptionsKt.addSuppressed(r100, th);
        y.a(r101, r100);
    }
}
