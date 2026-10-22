package wi7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Objects;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static int a(Context r100, Throwable r101) {
        if ((r101 instanceof ConnectTimeoutException) == false) goto L6;
        int r102 = -13;
    L26:
        if (r102 == (-15)) goto L28;
        if (r102 == (-14)) goto L28;
        return r102;
    L28:
        boolean r103 = false;
        NetworkInfo r104 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L34
        if (r104 == null) goto L36;
        if (r104.isAvailable() == false) goto L36;
        r103 = true;
    L36:
        if (r103 == false) goto L42;
        return -12;
    L42:
        return r102;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L6:
        if ((r101 instanceof SocketTimeoutException) == false) goto L9;
        r102 = -14;
        goto L26
    L9:
        if ((r101 instanceof SocketException) == false) goto L13;
        Objects.toString(r101);
    L11:
        r102 = -15;
        goto L26
    L13:
        if ((r101 instanceof SSLPeerUnverifiedException) == false) goto L17;
        Objects.toString(r101);
    L15:
        r102 = -21;
        goto L26
    L17:
        if ((r101 instanceof IOException) == false) goto L20;
        Objects.toString(r101);
        goto L11
    L20:
        if ((r101 instanceof SSLHandshakeException) == true) goto L15;
        if ((r101 instanceof UnknownHostException) == false) goto L25;
        r102 = -16;
        goto L26
    L25:
        Objects.toString(r101);
        r102 = -30;
        goto L26
    }
}
