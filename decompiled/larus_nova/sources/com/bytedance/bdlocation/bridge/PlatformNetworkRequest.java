package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkRequest {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 5;
    public static final int METHOD_PATCH = 4;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public final byte[] body;
    public final int cachePolicy;
    public final int connectTimeoutMs;
    public final String[] fieldNames;
    public final String[] fieldValues;
    public final String[] headerNames;
    public final String[] headerValues;
    public final int method;
    public final int priority;
    public final String purpose;
    public final int readTimeoutMs;
    public final String requestId;
    public final int retryInitialBackoffMs;
    public final int retryMaxAttempts;
    public final int retryMaxBackoffMs;
    public final boolean retryOn5xx;
    public final boolean retryOnNoConnection;
    public final boolean retryOnTimeout;
    public final String sdk;
    public final int totalTimeoutMs;
    public final String url;

    private static String[] safeStrings(String[] r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return new String[0];
    }

    public PlatformNetworkRequest(String r100, String r101, int r102, String[] r103, String[] r104, byte[] r105, int r106, int r110, int r111, int r112, int r113, int r114, boolean r115, boolean r116, boolean r117, int r118, int r119, String r210, String r211, String[] r212, String[] r213) {
        this.requestId = r100;
        this.url = r101;
        this.method = r102;
        this.headerNames = safeStrings(r103);
        this.headerValues = safeStrings(r104);
        if (r105 != null) goto L5;
        byte[] r107 = new byte[0];
    L6:
        this.body = r107;
        this.connectTimeoutMs = r106;
        this.readTimeoutMs = r110;
        this.totalTimeoutMs = r111;
        this.retryMaxAttempts = r112;
        this.retryInitialBackoffMs = r113;
        this.retryMaxBackoffMs = r114;
        this.retryOnTimeout = r115;
        this.retryOnNoConnection = r116;
        this.retryOn5xx = r117;
        this.priority = r118;
        this.cachePolicy = r119;
        this.sdk = r210;
        this.purpose = r211;
        this.fieldNames = safeStrings(r212);
        this.fieldValues = safeStrings(r213);
        return;
    L5:
        r107 = r105;
        goto L6
    }
}
