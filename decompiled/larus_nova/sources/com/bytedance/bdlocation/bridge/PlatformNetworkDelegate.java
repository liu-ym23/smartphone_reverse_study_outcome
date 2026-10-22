package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public interface PlatformNetworkDelegate {
    Executor callbackExecutor();

    boolean canSend(PlatformNetworkRequest r100);

    boolean canUpload(PlatformNetworkUploadRequest r100);

    PlatformNetworkRequestHandle send(PlatformNetworkRequest r100, NativeNetworkCallback r101);

    PlatformNetworkRequestHandle upload(PlatformNetworkUploadRequest r100, NativeNetworkCallback r101, NativeNetworkProgressCallback r102);
}
