package okhttp3.ttnet;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class TTNetUtils {
    public TTNetUtils() {
    }

    public static int convertExceptionToErrorCode(IOException r100) {
        if ((r100 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r100 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r100 instanceof SSLProtocolException) == false) goto L12;
        return -107;
    L12:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r100 instanceof UnknownHostException) == false) goto L18;
        return -105;
    L18:
        if ((r100 instanceof ConnectException) == false) goto L21;
        return convertConnectException(r100, -104);
    L21:
        if ((r100 instanceof PortUnreachableException) == false) goto L24;
        return -108;
    L24:
        if ((r100 instanceof NoRouteToHostException) == false) goto L27;
        return -109;
    L27:
        if ((r100 instanceof BindException) == false) goto L30;
        return NetError.ERR_ADDRESS_IN_USE;
    L30:
        if ((r100 instanceof SocketException) == false) goto L33;
        return convertConnectException(r100, -15);
    L33:
        if ((r100 instanceof MalformedURLException) == false) goto L36;
        return -300;
    L36:
        if ((r100 instanceof SocketTimeoutException) == false) goto L39;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L39:
        if ((r100 instanceof ProtocolException) == false) goto L42;
        return -901;
    L42:
        if ((r100 instanceof HttpRetryException) == false) goto L50;
        String r101 = r100.getMessage();
        if (TextUtils.isEmpty(r101) == false) goto L46;
    L48:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L46:
        if (r101.contains("Too many follow-up requests") == false) goto L48;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L50:
        if ((r100 instanceof UnknownServiceException) == false) goto L52;
        return -902;
    L52:
        if (r100 == null) goto L57;
        if ("Canceled#Reason=-199".equals(r100.getMessage()) == false) goto L57;
        return NetError.ERR_TTNET_APP_TIMED_OUT;
    L57:
        if (isRequestTimeout(r100) == false) goto L59;
        return NetError.ERR_TTNET_REQUEST_TIMED_OUT;
    L59:
        return -1;
    }

    public static boolean isRequestTimeout(IOException r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ("Canceled#Reason=-192".equals(r100.getMessage()) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof InterruptedIOException) == false) goto L17;
        Throwable r101 = r100.getCause();
        if (r101 == null) goto L17;
        if (TextUtils.isEmpty(r101.getMessage()) == true) goto L17;
        if ("Canceled#Reason=-192".equals(r101.getMessage()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    private static int convertConnectException(IOException r100, int r101) {
        if (r100 != null) goto L21;
        return r101;
    L21:
        int r102 = convertConnectionExceptionInternal(r100.getMessage(), r101);     // Catch: Throwable -> L18
        if (r102 == r101) goto L19;
        return r102;
    L19:
        Throwable r103 = r100.getCause();     // Catch: Throwable -> L15
        if (r103 != null) goto L10;
        return r102;
    L10:
        String r104 = r103.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return r102;
    L13:
        return convertConnectionExceptionInternal(r104, r101);
    L15:
        r101 = r102;
    L17:
        return r101;
    }

    private static int convertConnectionExceptionInternal(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        if (r100.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r100.contains("Connection reset") == true) goto L39;
        if (r100.contains("reset by peer") == true) goto L39;
        if (r100.contains("ECONNREFUSED") == false) goto L16;
        return -102;
    L16:
        if (r100.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return -103;
    L18:
        if (r100.contains("connection abort") == true) goto L38;
        if (r100.contains("ENETDOWN") == false) goto L23;
    L37:
        return -106;
    L23:
        if (r100.contains("Network is unreachable") == true) goto L37;
        if (r100.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return -109;
    L28:
        if (r100.contains("ENETUNREACH") == true) goto L36;
        if (r100.contains("EADDRNOTAVAIL") == false) goto L34;
        return -108;
    L34:
        if (r100.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r101;
    }
}
