package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes6.dex */
public final class u0 {
    public static final CancellationException a(String r100, Throwable r101) {
        CancellationException r102 = new CancellationException(r100);
        r102.initCause(r101);
        return r102;
    }
}
