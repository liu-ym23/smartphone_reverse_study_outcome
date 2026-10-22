package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
final class NativeNetworkProgressCallbackProxy implements NativeNetworkProgressCallback {
    private long nativeState;

    private static native void nativeProgress(long r100, PlatformNetworkUploadProgress r101);

    private static native void nativeRelease(long r100);

    public synchronized void close() {
        monitor-enter(this);
        long r100 = this.nativeState;     // Catch: Throwable -> L8
        this.nativeState = 0;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        nativeRelease(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public NativeNetworkProgressCallbackProxy(long r100) {
        this.nativeState = r100;
    }

    @Override // com.bytedance.bdlocation.bridge.NativeNetworkProgressCallback
    public synchronized void onProgress(PlatformNetworkUploadProgress r100) {
        monitor-enter(this);
        long r101 = this.nativeState;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeProgress(r101, r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
