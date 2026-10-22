package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PlatformNetworkUploadRequest {
    public static final int FORMAT_MULTIPART_FORM = 1;
    public static final int FORMAT_RAW_BODY = 0;
    public final int format;
    public final PlatformNetworkUploadPart[] parts;
    public final PlatformNetworkRequest request;

    public PlatformNetworkUploadRequest(PlatformNetworkRequest r1, int r2, PlatformNetworkUploadPart[] r3) {
        this.request = r1;
        this.format = r2;
        if (r3 != null) goto L5;
        r3 = new PlatformNetworkUploadPart[0];
    L5:
        this.parts = r3;
    }
}
