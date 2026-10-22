package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class i0 extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f524036m;

    @Override // okio.c
    public final void m() {
        this.f524036m.close();     // Catch: AssertionError -> L5 Exception -> L10
    L16:
        return;
    L5:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == false) goto L9;
        y.f524114a.log(Level.WARNING, "Failed to close timed out socket " + this.f524036m, e);
        return;
    L9:
        throw e;
    L10:
        e = move-exception;
        y.f524114a.log(Level.WARNING, "Failed to close timed out socket " + this.f524036m, e);
    }

    public i0(Socket r100) {
        Intrinsics.checkNotNullParameter(r100, "socket");
        this.f524036m = r100;
    }

    @Override // okio.c
    public final IOException l(IOException r100) {
        SocketTimeoutException r101 = new SocketTimeoutException("timeout");
        if (r100 == null) goto L5;
        r101.initCause(r100);
    L5:
        return r101;
    }
}
