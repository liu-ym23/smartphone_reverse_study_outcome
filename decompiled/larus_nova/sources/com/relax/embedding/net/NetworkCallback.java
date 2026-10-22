package com.relax.embedding.net;

/* JADX INFO: loaded from: classes34.dex */
public class NetworkCallback {
    private long mPtr;
    private long mSeqid;

    private native void nativeDestroyNetworkCallback(long r100);

    private native void nativeOnNetworkFailed(long r100, long r101, String r102);

    private native void nativeOnNetworkSucceeded(long r100, long r101, byte[] r102);

    public void destroy() {
        long r100 = this.mPtr;
        if (r100 == 0) goto L6;
        nativeDestroyNetworkCallback(r100);
        this.mPtr = 0;
        return;
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public void onFailed(String r100) {
        nativeOnNetworkFailed(this.mSeqid, this.mPtr, r100);
    }

    public void onSucceeded(byte[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        nativeOnNetworkSucceeded(this.mSeqid, this.mPtr, r100);
    }

    public NetworkCallback(long r100, long r101) {
        this.mPtr = r100;
        this.mSeqid = r101;
    }
}
