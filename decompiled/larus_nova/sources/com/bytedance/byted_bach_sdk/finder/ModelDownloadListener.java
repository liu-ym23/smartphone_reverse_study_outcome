package com.bytedance.byted_bach_sdk.finder;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ModelDownloadListener {
    protected long m_nativeListener;

    private native void deleteNativeObject(long r100);

    public abstract void onFailed();

    public abstract void onSuccess();

    public ModelDownloadListener() {
        this.m_nativeListener = 0;
    }

    public void finalize() throws Throwable {
        super.finalize();
        deleteNativeObject(this.m_nativeListener);
    }

    public final void setNativeListener(long r100) {
        this.m_nativeListener = r100;
    }
}
