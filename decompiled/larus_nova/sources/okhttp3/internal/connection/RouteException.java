package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public RouteException(IOException r100) {
        super(r100);
        this.firstException = r100;
        this.lastException = r100;
    }

    public void addConnectException(IOException r100) {
        IOException r101 = this.firstException;
        Method r102 = cvc.c.f465530r;
        if (r102 != null) goto L9;
    L6:
        this.lastException = r100;
        return;
    L9:
        r102.invoke(r101, new Object[]{r100});     // Catch: Throwable -> L8
        goto L6
    }
}
