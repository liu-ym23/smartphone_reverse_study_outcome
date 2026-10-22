package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class NativeNetworkCallbackProxy implements NativeNetworkCallback {
    private long nativeState;

    private static native void nativeComplete(long r0, PlatformNetworkResponse r2);

    public NativeNetworkCallbackProxy(long r1) {
        this.nativeState = r1;
    }

    @Override // com.bytedance.bdlocation.bridge.NativeNetworkCallback
    public void onComplete(PlatformNetworkResponse r6) {
        long r0 = this.nativeState;
        this.nativeState = 0;
        if (r0 == 0) goto L6;
        nativeComplete(r0, r6);
        return;
    }
}
