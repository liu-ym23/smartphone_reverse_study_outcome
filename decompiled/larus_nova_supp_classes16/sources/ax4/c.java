package ax4;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static int a(Throwable r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        if ((r2 instanceof SocketTimeoutException) == false) goto L10;
        return -2;
    L10:
        if ((r2 instanceof ConnectTimeoutException) == false) goto L14;
        return -4;
    L14:
        if ((r2 instanceof UnknownHostException) == false) goto L18;
        return -5;
    L18:
        if ((r2 instanceof SSLHandshakeException) == false) goto L30;
        if (r2.toString().contains("Connection closed by peer") == false) goto L24;
        return -14;
    L24:
        if (r2.toString().contains("CertPathValidatorException") == false) goto L27;
        return -7;
    L27:
        return -6;
    L30:
        if ((r2 instanceof SocketException) == false) goto L46;
        if ((r2 instanceof NoRouteToHostException) == false) goto L36;
        return -13;
    L36:
        if (r2.toString().contains("Socket closed") == false) goto L40;
        return -8;
    L40:
        if (r2.toString().contains("Network is unreachable") == false) goto L43;
        return -15;
    L43:
        return -9;
    L46:
        if ((r2 instanceof SSLPeerUnverifiedException) == false) goto L50;
        return -10;
    L50:
        if ((r2 instanceof StreamResetException) == false) goto L54;
        return -16;
    L54:
        if ((r2 instanceof IOException) == true) goto L56;
        return -3;
    L56:
        if (r2.toString().contains("Canceled") == false) goto L60;
        return -11;
    L60:
        if (r2.toString().contains("unexpected end of stream on null") == false) goto L65;
        return -17;
    L65:
        return -3;
    }
}
