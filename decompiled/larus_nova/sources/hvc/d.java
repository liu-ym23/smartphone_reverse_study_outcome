package hvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes42.dex */
public final class d extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f487383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f487384d;

    @Override // hvc.g
    @Nullable
    public final String j(SSLSocket r100) {
        String r101 = (String) this.f487384d.invoke(r100, new Object[0]);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13
        if (r101 == null) goto L9;
        if (r101.equals("") == true) goto L9;
        return r101;
    L9:
        return null;
    L10:
        e = move-exception;
        throw cvc.c.a("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        if ((e.getCause() instanceof UnsupportedOperationException) == false) goto L18;
        return null;
    L18:
        throw cvc.c.a("failed to get ALPN selected protocol", e);
    }

    @Override // hvc.g
    public final X509TrustManager p(SSLSocketFactory r100) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    public d(Method r100, Method r101) {
        this.f487383c = r100;
        this.f487384d = r101;
    }

    @Override // hvc.g
    public final void g(SSLSocket r100, String r101, List<Protocol> r102) {
        SSLParameters r103 = r100.getSSLParameters();     // Catch: Throwable -> L4 IllegalAccessException -> L6
        List<String> r104 = g.c(r102);     // Catch: Throwable -> L4 IllegalAccessException -> L6
        ArrayList r105 = (ArrayList) r104;     // Catch: Throwable -> L4 IllegalAccessException -> L6
        this.f487383c.invoke(r103, new Object[]{r105.toArray(new String[r105.size()])});     // Catch: Throwable -> L4 IllegalAccessException -> L6
        r100.setSSLParameters(r103);     // Catch: Throwable -> L4 IllegalAccessException -> L6
        return;
    L4:
        e = move-exception;
        throw cvc.c.a("unable to set ssl parameters", e);
    }
}
