package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkUploadProgress {
    public final long bytesSent;
    public final String requestId;
    public final long totalBytes;

    public PlatformNetworkUploadProgress(String r100, long r101, long r102) {
        this.requestId = r100;
        this.bytesSent = r101;
        this.totalBytes = r102;
    }
}
