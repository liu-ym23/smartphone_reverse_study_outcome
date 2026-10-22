package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class NativeNetworkProgressCallbackProxy implements NativeNetworkProgressCallback {
    private long nativeState;

    private static native void nativeProgress(long r0, PlatformNetworkUploadProgress r2);

    private static native void nativeRelease(long r0);

    public synchronized void close() {
        monitor-enter(this);
        long r0 = this.nativeState;     // Catch: Throwable -> L8
        this.nativeState = 0;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        nativeRelease(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public NativeNetworkProgressCallbackProxy(long r1) {
        this.nativeState = r1;
    }

    @Override // com.bytedance.bdlocation.bridge.NativeNetworkProgressCallback
    public synchronized void onProgress(PlatformNetworkUploadProgress r6) {
        monitor-enter(this);
        long r0 = this.nativeState;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        nativeProgress(r0, r6);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
