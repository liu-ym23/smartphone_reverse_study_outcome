package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface PlatformNetworkDelegate {
    Executor callbackExecutor();

    boolean canSend(PlatformNetworkRequest r1);

    boolean canUpload(PlatformNetworkUploadRequest r1);

    PlatformNetworkRequestHandle send(PlatformNetworkRequest r1, NativeNetworkCallback r2);

    PlatformNetworkRequestHandle upload(PlatformNetworkUploadRequest r1, NativeNetworkCallback r2, NativeNetworkProgressCallback r3);
}
