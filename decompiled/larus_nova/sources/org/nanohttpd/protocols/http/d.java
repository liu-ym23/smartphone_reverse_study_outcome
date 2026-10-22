package org.nanohttpd.protocols.http;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NanoHTTPD f526196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f526197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IOException f526198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f526199d;

    public final void a() {
        ServerSocket r100 = this.f526196a.getMyServerSocket();     // Catch: IOException -> L17
        if (this.f526196a.hostname == null) goto L5;
        NanoHTTPD r101 = this.f526196a;     // Catch: IOException -> L17
        InetSocketAddress r102 = new InetSocketAddress(r101.hostname, r101.myPort);     // Catch: IOException -> L17
    L6:
        r100.bind(r102);     // Catch: IOException -> L17
        this.f526199d = true;     // Catch: IOException -> L17
    L20:
        Socket r103 = this.f526196a.getMyServerSocket().accept();     // Catch: IOException -> L12
        int r104 = this.f526197b;     // Catch: IOException -> L12
        if (r104 <= 0) goto L10;
        r103.setSoTimeout(r104);     // Catch: IOException -> L12
    L10:
        InputStream r105 = r103.getInputStream();     // Catch: IOException -> L12
        NanoHTTPD r106 = this.f526196a;     // Catch: IOException -> L12
        uwc.b r107 = r106.asyncRunner;     // Catch: IOException -> L12
        uwc.a r108 = (uwc.a) r107;     // Catch: IOException -> L12
        r108.b(r106.createClientHandler(r103, r105));     // Catch: IOException -> L12
    L15:
        if (this.f526196a.getMyServerSocket().isClosed() == false) goto L20;
        return;
    L12:
        e = move-exception;
        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
        goto L15
    L5:
        r102 = new InetSocketAddress(this.f526196a.myPort);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        this.f526198c = e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(NanoHTTPD r100, int r101) {
        this.f526199d = false;
        this.f526196a = r100;
        this.f526197b = r101;
    }
}
