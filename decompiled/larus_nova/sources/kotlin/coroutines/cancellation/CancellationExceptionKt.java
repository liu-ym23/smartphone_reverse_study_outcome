package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¨\u0006\n"}, d2 = {"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "message", "", "cause", "", "Lkotlin/SinceKotlin;", "version", "1.4", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CancellationExceptionKt {
    public static /* synthetic */ void CancellationException$annotations() {
    }

    private static final CancellationException CancellationException(Throwable r100) {
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        CancellationException r102 = new CancellationException(r101);
        r102.initCause(r100);
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    private static final CancellationException CancellationException(String r100, Throwable r101) {
        CancellationException r102 = new CancellationException(r100);
        r102.initCause(r101);
        return r102;
    }
}
