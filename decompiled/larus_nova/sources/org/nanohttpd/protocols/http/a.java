package org.nanohttpd.protocols.http;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NanoHTTPD f526178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f526179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Socket f526180c;

    public final void a() {
        OutputStream r100 = null;
        r100 = this.f526180c.getOutputStream();     // Catch: Throwable -> L8 Exception -> L10
        ((twc.b) this.f526178a.getTempFileManagerFactory()).getClass();     // Catch: Throwable -> L8 Exception -> L10
        twc.a r101 = new twc.a();     // Catch: Throwable -> L8 Exception -> L10
        b r102 = new b(this.f526178a, r101, this.f526179b, r100, this.f526180c.getInetAddress(), this.f526180c);     // Catch: Throwable -> L8 Exception -> L10
    L5:
        if (this.f526180c.isClosed() == true) goto L18;
        r102.e();     // Catch: Throwable -> L8 Exception -> L10
    L18:
        NanoHTTPD.safeClose(r100);
        NanoHTTPD.safeClose(this.f526179b);
        NanoHTTPD.safeClose(this.f526180c);
        ((uwc.a) this.f526178a.asyncRunner).a(this);
        return;
    L8:
        th = move-exception;
        NanoHTTPD.safeClose(r100);
        NanoHTTPD.safeClose(this.f526179b);
        NanoHTTPD.safeClose(this.f526180c);
        ((uwc.a) this.f526178a.asyncRunner).a(this);
        throw th;
    L10:
        e = move-exception;
        if ((e instanceof SocketException) == false) goto L16;
        if ("NanoHttpd Shutdown".equals(e.getMessage()) == true) goto L18;
    L16:
        if ((e instanceof SocketTimeoutException) == true) goto L18;
        NanoHTTPD.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e);     // Catch: Throwable -> L8
        goto L18
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

    public a(NanoHTTPD r100, InputStream r101, Socket r102) {
        this.f526178a = r100;
        this.f526179b = r101;
        this.f526180c = r102;
    }
}
