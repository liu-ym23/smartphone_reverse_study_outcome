package com.facebook.net;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.facebook.imagepipeline.exception.BDException;
import com.facebook.imagepipeline.net.ExpiredUrlException;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public final class NetUtils {
    public static final int SC_BIND_EXCEPTION = 7;
    public static final int SC_CANCEL = 40;
    public static final int SC_CLIENT_PROTOCOL_EXCEPTION = 19;
    public static final int SC_CONNECT_EXCEPTION = 8;
    public static final int SC_CONNECT_TIMEOUT = 2;
    public static final int SC_EACCES = 36;
    public static final int SC_EADDRINUSE = 17;
    public static final int SC_EADDRNOTAVAIL = 16;
    public static final int SC_ECONNREFUSED = 13;
    public static final int SC_ECONNRESET = 12;
    public static final int SC_EDQUOT = 34;
    public static final int SC_EHOSTUNREACH = 14;
    public static final int SC_EIO = 37;
    public static final int SC_ENETUNREACH = 15;
    public static final int SC_ENOENT = 33;
    public static final int SC_EROFS = 35;
    public static final int SC_EXPIRED_URL_EXCEPTION = 43;
    public static final int SC_FILE_TOO_LARGE = 20;
    public static final int SC_IO_EXCEPTION = 4;
    public static final int SC_NO_HTTP_RESPONSE = 18;
    public static final int SC_NO_NETWORK = 41;
    public static final int SC_NO_REOUTE_TO_HOST = 9;
    public static final int SC_NO_SPACE = 32;
    public static final int SC_PORT_UNREACHABLE = 10;
    public static final int SC_RESET_BY_PEER = 6;
    public static final int SC_SOCKET_EXCEPTION = 5;
    public static final int SC_SOCKET_TIMEOUT = 3;
    public static final int SC_UNKNOWN = 1;
    public static final int SC_UNKNOWN_HOST = 11;
    public static final String TAG = "NetUtils";

    private NetUtils() {
    }

    public static int checkHttpRequestException(Throwable r100) {
        if ((r100 instanceof ExpiredUrlException) == false) goto L7;
        return 43;
    L7:
        if ((r100 instanceof IOException) == false) goto L15;
        if (r100.getMessage() == null) goto L15;
        if (r100.getMessage().contains(BDErrorCodeConst.BD_ERROR_MSG_REQUEST_CANCELED) == false) goto L15;
        return -999;
    L15:
        if ((r100 instanceof HttpResponseException) == false) goto L18;
        return -1011;
    L18:
        if ((r100 instanceof NetworkExceptionImpl) == false) goto L22;
        return ((NetworkExceptionImpl) r100).getCronetInternalErrorCode();
    L22:
        if ((r100 instanceof CronetIOException) == false) goto L29;
        CronetIOException r101 = (CronetIOException) r100;
        if (r101.getStatusCode() == 0) goto L27;
        return -1011;
    L27:
        return r101.getCronetInternalErrorCode();
    L29:
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L33;
        return ((NetworkNotAvailabeException) r100).getCronetInternalErrorCode();
    L33:
        if ((r100 instanceof BDException) == true) goto L35;
        return 1;
    L35:
        return ((BDException) r100).getErrorCode();
    }

    public static int checkHttpRequestException(Throwable r100, String[] r101) {
        return checkHttpRequestException(r100);
    }
}
