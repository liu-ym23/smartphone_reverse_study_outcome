package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import n4a.f5;
import n4a.r;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f380037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f380038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLContext f380039c;

    public e(Context r100, SSLContext r101) {
        if (r100 != null) goto L55;
    L5:
        this.f380039c = r101;     // Catch: Throwable -> L20
        if (r101 == null) goto L8;
        this.f380037a = r101.getSocketFactory();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r.f(th, "myssl", "<init>");     // Catch: Throwable -> L35
    L26:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L59:
    L32:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        return;
    L29:
        if (this.f380037a != null) goto L66;
        this.f380037a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L32
        return;
    L66:
        return;
    L23:
        if (this.f380039c != null) goto L59;
        this.f380039c = SSLContext.getDefault();     // Catch: Throwable -> L26
    L35:
        th = move-exception;
    L40:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L63:
    L46:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        throw th;
    L43:
        if (this.f380037a != null) goto L67;
        this.f380037a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L46
        throw th;
    L67:
        throw th;
    L37:
        if (this.f380039c != null) goto L63;
        this.f380039c = SSLContext.getDefault();     // Catch: Throwable -> L40
    L8:
        if (r101 != null) goto L53;
        this.f380039c = SSLContext.getDefault();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L53:
    L17:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        return;
    L14:
        if (this.f380037a != null) goto L65;
        this.f380037a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L17
        return;
    L65:
        return;
    L55:
        this.f380038b = r100.getApplicationContext();     // Catch: Throwable -> L20
        goto L5
    }

    public static void b(Socket r100) {
    L8:
        th = move-exception;
        r.f(th, "myssl", "stlv2");
        return;
    L3:
        if (i.g.f380140b == true) goto L5;
        return;
    L5:
        if ((r100 instanceof SSLSocket) == false) goto L14;
        ((SSLSocket) r100).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L8
        return;
    }

    public static void c(Socket r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (i.g.f380141c == true) goto L5;
        return;
    L5:
        if (i.g.f380143e == true) goto L8;
        return;
    L8:
        if ((r100 instanceof SSLSocket) == true) goto L10;
        return;
    L10:
        int r102 = i.g.f380144f;
        int r103 = i.g.f380142d;
        if (r102 <= r103) goto L14;
        r102 = r103;
    L14:
        if (r102 <= 17) goto L17;
        if (r101 <= r102) goto L17;
        return;
    L17:
        Class<?> r104 = r100.getClass();
        r104.getMethod(f5.o("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r100, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        r.f(th, "myssl", "sust");
    }

    public final void a(SSLSessionCache r110) {
        SSLContext r100 = this.f380039c;
        if (r100 != null) goto L16;
        return;
    L16:
        SSLSessionContext r101 = r100.getClientSessionContext();     // Catch: Throwable -> L13
        Field r102 = r110.getClass().getDeclaredField(f5.o("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L13
        r102.setAccessible(true);     // Catch: Throwable -> L13
        Object r111 = r102.get(r110);     // Catch: Throwable -> L13
        Method[] r103 = r101.getClass().getMethods();     // Catch: Throwable -> L13
        String r104 = f5.o("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L13
        int r105 = r103.length;     // Catch: Throwable -> L13
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        Method r107 = r103[r106];     // Catch: Throwable -> L13
        if (r107.getName().equals(r104) == true) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        r107.invoke(r101, new Object[]{r111});     // Catch: Throwable -> L13
        return;
    L12:
        return;
    L13:
        th = move-exception;
        r.f(th, "myssl", "isc2");
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        SSLSocketFactory r100 = this.f380037a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Socket r101 = r100.createSocket();     // Catch: Throwable -> L6
        b(r101);     // Catch: Throwable -> L6
        c(r101);     // Catch: Throwable -> L6
        return r101;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs1");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        SSLSocketFactory r102 = this.f380037a;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        Socket r103 = r102.createSocket(r100, r101);     // Catch: Throwable -> L6
        b(r103);     // Catch: Throwable -> L6
        c(r103);     // Catch: Throwable -> L6
        return r103;
    L11:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs3");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        SSLSocketFactory r104 = this.f380037a;     // Catch: Throwable -> L6
        if (r104 == null) goto L11;
        Socket r105 = r104.createSocket(r100, r101, r102, r103);     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        c(r105);     // Catch: Throwable -> L6
        return r105;
    L11:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs4");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101) throws IOException {
        SSLSocketFactory r102 = this.f380037a;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        Socket r103 = r102.createSocket(r100, r101);     // Catch: Throwable -> L6
        b(r103);     // Catch: Throwable -> L6
        c(r103);     // Catch: Throwable -> L6
        return r103;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs5");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        SSLSocketFactory r104 = this.f380037a;     // Catch: Throwable -> L6
        if (r104 == null) goto L9;
        Socket r105 = r104.createSocket(r100, r101, r102, r103);     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        c(r105);     // Catch: Throwable -> L6
        return r105;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs6");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        SSLSocketFactory r104 = this.f380037a;     // Catch: Throwable -> L6
        if (r104 == null) goto L9;
        Socket r105 = r104.createSocket(r100, r101, r102, r103);     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        c(r105);     // Catch: Throwable -> L6
        return r105;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs2");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r100 = this.f380037a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        return r100.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        r.f(th, "myssl", "gdcs");
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r100 = this.f380037a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        return r100.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        r.f(th, "myssl", "gscs");
        goto L9
    }
}
