package com.volcengine.zeus.download;

/* JADX INFO: loaded from: classes41.dex */
public interface IZeusDownloadListener {
    void onFailed(Throwable r100, int r101, String r102);

    void onProgress(long r100, long r101);

    void onStart();

    void onSuccess(String r100, String r101, long r102);
}
