package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes23.dex */
public class ExceptionCode {
    public static final int CANCEL = 10000100;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 10000402;
    public static final int CONNECTION_REFUSED = 10000404;
    public static final int CONNECTION_RESET = 10000401;
    public static final int CONNECT_FAILED = 10000403;
    public static final int CRASH_EXCEPTION = 10000000;
    public static final int INTERRUPT_CONNECT_CLOSE = 10000405;
    public static final int INTERRUPT_EXCEPTION = 10000804;
    public static final int NETWORK_CHANGED = 10000201;
    public static final int NETWORK_IO_EXCEPTION = 10000802;
    public static final int NETWORK_TIMEOUT = 10000101;
    public static final int NETWORK_UNREACHABLE = 10000200;
    public static final int NETWORK_UNSUPPORTED = 10000102;
    public static final int PROTOCOL_ERROR = 10000801;
    private static final String READ = "read";
    public static final int READ_ERROR = 10000601;
    public static final int ROUTE_FAILED = 10000301;
    public static final int SHUTDOWN_EXCEPTION = 10000202;
    public static final int SOCKET_CLOSE = 10000406;
    public static final int SOCKET_CONNECT_TIMEOUT = 10000400;
    public static final int SOCKET_READ_TIMEOUT = 10000600;
    public static final int SOCKET_TIMEOUT = 10000803;
    public static final int SOCKET_WRITE_TIMEOUT = 10000700;
    public static final int SSL_HANDSHAKE_EXCEPTION = 10000501;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 10000502;
    public static final int SSL_PROTOCOL_EXCEPTION = 10000500;
    public static final int UNABLE_TO_RESOLVE_HOST = 10000300;
    public static final int UNEXPECTED_EOF = 10000800;
    private static final String WRITE = "write";

    public ExceptionCode() {
    }

    public static int getErrorCodeFromException(Exception r100) {
        if (r100 != null) goto L6;
        return NETWORK_IO_EXCEPTION;
    L6:
        if ((r100 instanceof IOException) == true) goto L9;
        return 10000000;
    L9:
        String r101 = r100.getMessage();
        if (r101 != null) goto L12;
        return NETWORK_IO_EXCEPTION;
    L12:
        String r102 = StringUtils.toLowerCase(r101);
        int r103 = getErrorCodeFromMsg(r102);
        if (r103 == 10000802) goto L16;
        return r103;
    L16:
        if ((r100 instanceof SocketTimeoutException) == false) goto L20;
        return getErrorCodeSocketTimeout(r100);
    L20:
        if ((r100 instanceof ConnectException) == false) goto L24;
        return CONNECT_FAILED;
    L24:
        if ((r100 instanceof NoRouteToHostException) == false) goto L28;
        return ROUTE_FAILED;
    L28:
        if ((r100 instanceof SSLProtocolException) == false) goto L32;
        return SSL_PROTOCOL_EXCEPTION;
    L32:
        if ((r100 instanceof SSLHandshakeException) == false) goto L36;
        return SSL_HANDSHAKE_EXCEPTION;
    L36:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L40;
        return SSL_PEERUNVERIFIED_EXCEPTION;
    L40:
        if ((r100 instanceof UnknownHostException) == false) goto L44;
        return UNABLE_TO_RESOLVE_HOST;
    L44:
        if ((r100 instanceof InterruptedIOException) == false) goto L52;
        if (r102.contains("connection has been shut down") == false) goto L49;
        return INTERRUPT_CONNECT_CLOSE;
    L49:
        return INTERRUPT_EXCEPTION;
    L52:
        if ((r100 instanceof ProtocolException) == false) goto L55;
        return PROTOCOL_ERROR;
    L55:
        return r103;
    }

    private static int getErrorCodeFromMsg(String r100) {
        if (r100.contains("unexpected end of stream") == false) goto L6;
        return UNEXPECTED_EOF;
    L6:
        if (r100.contains("unable to resolve host") == false) goto L9;
        return UNABLE_TO_RESOLVE_HOST;
    L9:
        if (r100.contains("read error") == false) goto L12;
        return READ_ERROR;
    L12:
        if (r100.contains("connection reset") == false) goto L15;
        return CONNECTION_RESET;
    L15:
        if (r100.contains("software caused connection abort") == false) goto L18;
        return CONNECTION_ABORT;
    L18:
        if (r100.contains("failed to connect to") == false) goto L21;
        return CONNECT_FAILED;
    L21:
        if (r100.contains("connection refused") == false) goto L24;
        return CONNECTION_REFUSED;
    L24:
        if (r100.contains("connection timed out") == false) goto L28;
        return SOCKET_CONNECT_TIMEOUT;
    L28:
        if (r100.contains("no route to host") == false) goto L31;
        return ROUTE_FAILED;
    L31:
        if (r100.contains("network is unreachable") == false) goto L34;
        return NETWORK_UNREACHABLE;
    L34:
        if (r100.contains("socket closed") == false) goto L36;
        return SOCKET_CLOSE;
    L36:
        return NETWORK_IO_EXCEPTION;
    }

    private static int getErrorCodeSocketTimeout(Exception r100) {
        String r101 = checkExceptionContainsKey(r100, new String[]{CONNECT, READ, WRITE});
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case 3496342: goto L14;
            case 113399775: goto L10;
            case 951351530: goto L6;
            default: goto L17;
        };
    L17:
        switch(r102) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        return SOCKET_TIMEOUT;
    L20:
        return SOCKET_CONNECT_TIMEOUT;
    L22:
        return SOCKET_WRITE_TIMEOUT;
    L24:
        return SOCKET_READ_TIMEOUT;
    L6:
        if (r101.equals(CONNECT) == false) goto L17;
        r102 = 2;
        goto L17
    L10:
        if (r101.equals(WRITE) == false) goto L17;
        r102 = 1;
        goto L17
    L14:
        if (r101.equals(READ) == false) goto L17;
        r102 = 0;
        goto L17
    }

    private static String checkExceptionContainsKey(Exception r100, String... r101) {
        return checkStrContainsKey(StringUtils.toLowerCase(r100.getMessage()), r101);
    }

    private static String checkStrContainsKey(String r100, String... r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        String r104 = r101[r103];
        if (r100.contains(r104) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r104;
    L11:
        return "";
    }
}
