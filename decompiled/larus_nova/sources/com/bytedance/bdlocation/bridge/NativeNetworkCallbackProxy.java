package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
final class NativeNetworkCallbackProxy implements NativeNetworkCallback {
    private long nativeState;

    private static native void nativeComplete(long r100, PlatformNetworkResponse r101);

    public NativeNetworkCallbackProxy(long r100) {
        this.nativeState = r100;
    }

    @Override // com.bytedance.bdlocation.bridge.NativeNetworkCallback
    public void onComplete(PlatformNetworkResponse r100) {
        long r101 = this.nativeState;
        this.nativeState = 0;
        if (r101 == 0) goto L6;
        nativeComplete(r101, r100);
        return;
    }
}
