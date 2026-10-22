package swc;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements vwc.b<ServerSocket, IOException> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLServerSocketFactory f543781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f543782b;

    @Override // vwc.b
    public final ServerSocket create() throws Throwable {
        SSLServerSocket r100 = (SSLServerSocket) this.f543781a.createServerSocket();
        String[] r101 = this.f543782b;
        if (r101 == null) goto L5;
        r100.setEnabledProtocols(r101);
    L6:
        r100.setUseClientMode(false);
        r100.setWantClientAuth(false);
        r100.setNeedClientAuth(false);
        return r100;
    L5:
        r100.setEnabledProtocols(r100.getSupportedProtocols());
        goto L6
    }

    public b(SSLServerSocketFactory r100, String[] r101) {
        this.f543781a = r100;
        this.f543782b = r101;
    }
}
