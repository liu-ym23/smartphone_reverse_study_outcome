package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    private static String[] safeStrings(String[] r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return new String[0];
    }

    public static PlatformNetworkResponse failure(String r12, int r13, String r14) {
        return new PlatformNetworkResponse(r12, 0, new String[0], new String[0], new byte[0], r13, r14, false, 0);
    }

    public static PlatformNetworkResponse success(String r12, int r13, String[] r14, String[] r15, byte[] r16) {
        return new PlatformNetworkResponse(r12, r13, r14, r15, r16, 0, "", false, 0);
    }

    public PlatformNetworkResponse(String r1, int r2, String[] r3, String[] r4, byte[] r5, int r6, String r7, boolean r8, long r9) {
        this.requestId = r1;
        this.statusCode = r2;
        this.headerNames = safeStrings(r3);
        this.headerValues = safeStrings(r4);
        if (r5 != null) goto L5;
        r5 = new byte[0];
    L5:
        this.body = r5;
        this.errorCode = r6;
        this.errorMessage = r7;
        this.fromCache = r8;
        this.receivedAtMs = r9;
    }
}
