package o1;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public static void a(HttpURLConnection r100) {
        if ((r100 instanceof HttpsURLConnection) == false) goto L9;
        SSLContext r101 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L6
        r101.init(null, null, null);     // Catch: Throwable -> L6
        ((HttpsURLConnection) r100).setSSLSocketFactory(new b(r101.getSocketFactory()));     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
