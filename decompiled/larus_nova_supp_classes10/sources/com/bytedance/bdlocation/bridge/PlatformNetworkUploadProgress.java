package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PlatformNetworkUploadProgress {
    public final long bytesSent;
    public final String requestId;
    public final long totalBytes;

    public PlatformNetworkUploadProgress(String r1, long r2, long r4) {
        this.requestId = r1;
        this.bytesSent = r2;
        this.totalBytes = r4;
    }
}
