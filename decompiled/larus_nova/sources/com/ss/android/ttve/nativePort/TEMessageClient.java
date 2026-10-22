package com.ss.android.ttve.nativePort;

/* JADX INFO: loaded from: classes38.dex */
public class TEMessageClient {
    protected com.ss.android.ttve.common.a mOnErrorListener;
    protected com.ss.android.ttve.common.a mOnInfoListener;

    public TEMessageClient() {
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
    }

    public com.ss.android.ttve.common.a getErrorListener() {
        return this.mOnErrorListener;
    }

    public com.ss.android.ttve.common.a getInfoListener() {
        return this.mOnInfoListener;
    }

    public void setErrorListener(com.ss.android.ttve.common.a r100) {
        this.mOnErrorListener = r100;
    }

    public void setInfoListener(com.ss.android.ttve.common.a r100) {
        this.mOnInfoListener = r100;
    }

    public void nativeCallback_onInfoListener(int r100, int r101, float r102) {
        com.ss.android.ttve.common.a r103 = this.mOnInfoListener;
        if (r103 == null) goto L6;
        r103.onCallback(r100, r101, r102, null);
        return;
    }

    public void nativeCallback_onErrorListener(int r100, int r101, float r102, String r103) {
        com.ss.android.ttve.common.a r104 = this.mOnErrorListener;
        if (r104 == null) goto L6;
        r104.onCallback(r100, r101, r102, r103);
        return;
    }
}
