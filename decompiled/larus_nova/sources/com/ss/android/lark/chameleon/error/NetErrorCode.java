package com.ss.android.lark.chameleon.error;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes35.dex */
public class NetErrorCode {
    public static final int NET_CODE_CANCELED = -11;
    public static final int NET_CODE_CERT_PATH = -7;
    public static final int NET_CODE_CONN_CLOSED_BY_PEER = -14;
    public static final int NET_CODE_CONN_TIMEOUT = -4;
    public static final int NET_CODE_HANDSHAKE = -6;
    public static final int NET_CODE_IFRAME_CHECK_FAILED = -18;
    public static final int NET_CODE_NETWORK_UNREACHABLE = -15;
    public static final int NET_CODE_NO_NETWORK_EXCEPTION = -1;
    public static final int NET_CODE_NO_ROUTE_TO_HOST = -13;
    public static final int NET_CODE_OTHER_IO_EXCEPTION = -12;
    public static final int NET_CODE_OTHER_SOCKET_ERROR = -9;
    public static final int NET_CODE_REQUEST_TIMEOUT_EXCEPTION = -2;
    public static final int NET_CODE_SOCKET_CLOSED = -8;
    public static final int NET_CODE_SSL_PEER_UNVERIFIED = -10;
    public static final int NET_CODE_STREAM_RESET = -16;
    public static final int NET_CODE_SUCCESS = 0;
    public static final int NET_CODE_UNEXPECTED_END_NULL = -17;
    public static final int NET_CODE_UNKNOWN_HOST = -5;
    public static final int NET_CODE_UNKOWN_EXCEPTION = -3;

    public NetErrorCode() {
    }

    public static int exceptionToCode(Throwable r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof SocketTimeoutException) == false) goto L10;
        return -2;
    L10:
        if ((r100 instanceof ConnectTimeoutException) == false) goto L14;
        return -4;
    L14:
        if ((r100 instanceof UnknownHostException) == false) goto L18;
        return -5;
    L18:
        if ((r100 instanceof SSLHandshakeException) == false) goto L30;
        if (r100.toString().contains("Connection closed by peer") == false) goto L24;
        return -14;
    L24:
        if (r100.toString().contains("CertPathValidatorException") == false) goto L27;
        return -7;
    L27:
        return -6;
    L30:
        if ((r100 instanceof SocketException) == false) goto L46;
        if ((r100 instanceof NoRouteToHostException) == false) goto L36;
        return -13;
    L36:
        if (r100.toString().contains("Socket closed") == false) goto L40;
        return -8;
    L40:
        if (r100.toString().contains("Network is unreachable") == false) goto L43;
        return -15;
    L43:
        return -9;
    L46:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L50;
        return -10;
    L50:
        if ((r100 instanceof IOException) == true) goto L52;
        return -3;
    L52:
        if (r100.toString().contains("Canceled") == false) goto L56;
        return -11;
    L56:
        if (r100.toString().contains("unexpected end of stream on null") == false) goto L61;
        return -17;
    L61:
        return -3;
    }
}
