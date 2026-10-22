package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkUploadRequest {
    public static final int FORMAT_MULTIPART_FORM = 1;
    public static final int FORMAT_RAW_BODY = 0;
    public final int format;
    public final PlatformNetworkUploadPart[] parts;
    public final PlatformNetworkRequest request;

    public PlatformNetworkUploadRequest(PlatformNetworkRequest r100, int r101, PlatformNetworkUploadPart[] r102) {
        this.request = r100;
        this.format = r101;
        if (r102 != null) goto L5;
        r102 = new PlatformNetworkUploadPart[0];
    L5:
        this.parts = r102;
    }
}
