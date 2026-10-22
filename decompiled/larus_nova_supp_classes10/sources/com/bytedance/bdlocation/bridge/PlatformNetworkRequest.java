package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    private static String[] safeStrings(String[] r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return new String[0];
    }

    public PlatformNetworkRequest(String r3, String r4, int r5, String[] r6, String[] r7, byte[] r8, int r9, int r10, int r11, int r12, int r13, int r14, boolean r15, boolean r16, boolean r17, int r18, int r19, String r20, String r21, String[] r22, String[] r23) {
        this.requestId = r3;
        this.url = r4;
        this.method = r5;
        this.headerNames = safeStrings(r6);
        this.headerValues = safeStrings(r7);
        if (r8 != null) goto L5;
        byte[] r1 = new byte[0];
    L6:
        this.body = r1;
        this.connectTimeoutMs = r9;
        this.readTimeoutMs = r10;
        this.totalTimeoutMs = r11;
        this.retryMaxAttempts = r12;
        this.retryInitialBackoffMs = r13;
        this.retryMaxBackoffMs = r14;
        this.retryOnTimeout = r15;
        this.retryOnNoConnection = r16;
        this.retryOn5xx = r17;
        this.priority = r18;
        this.cachePolicy = r19;
        this.sdk = r20;
        this.purpose = r21;
        this.fieldNames = safeStrings(r22);
        this.fieldValues = safeStrings(r23);
        return;
    L5:
        r1 = r8;
        goto L6
    }
}
