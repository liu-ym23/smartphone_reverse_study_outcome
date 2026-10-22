package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkResponse {
    public static final int ERROR_CANCELLED = 1;
    public static final int ERROR_CLIENT_NOT_REGISTERED = 10;
    public static final int ERROR_DECODE_ERROR = 9;
    public static final int ERROR_DNS_FAILED = 4;
    public static final int ERROR_HTTP_ERROR = 8;
    public static final int ERROR_INVALID_REQUEST = 6;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_NO_CONNECTION = 3;
    public static final int ERROR_PLATFORM = 12;
    public static final int ERROR_TIMEOUT = 2;
    public static final int ERROR_TLS_FAILED = 5;
    public static final int ERROR_TRANSPORT = 11;
    public static final int ERROR_UNAUTHORIZED = 7;
    public final byte[] body;
    public final int errorCode;
    public final String errorMessage;
    public final boolean fromCache;
    public final String[] headerNames;
    public final String[] headerValues;
    public final long receivedAtMs;
    public final String requestId;
    public final int statusCode;

    private static String[] safeStrings(String[] r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return new String[0];
    }

    public static PlatformNetworkResponse failure(String r110, int r111, String r112) {
        return new PlatformNetworkResponse(r110, 0, new String[0], new String[0], new byte[0], r111, r112, false, 0);
    }

    public static PlatformNetworkResponse success(String r110, int r111, String[] r112, String[] r113, byte[] r114) {
        return new PlatformNetworkResponse(r110, r111, r112, r113, r114, 0, "", false, 0);
    }

    public PlatformNetworkResponse(String r100, int r101, String[] r102, String[] r103, byte[] r104, int r105, String r106, boolean r107, long r108) {
        this.requestId = r100;
        this.statusCode = r101;
        this.headerNames = safeStrings(r102);
        this.headerValues = safeStrings(r103);
        if (r104 != null) goto L5;
        r104 = new byte[0];
    L5:
        this.body = r104;
        this.errorCode = r105;
        this.errorMessage = r106;
        this.fromCache = r107;
        this.receivedAtMs = r108;
    }
}
