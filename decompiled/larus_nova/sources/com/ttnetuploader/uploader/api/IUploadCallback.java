package com.ttnetuploader.uploader.api;

/* JADX INFO: loaded from: classes41.dex */
public interface IUploadCallback {
    void onFailed(ResultInfo r100);

    void onProgress(long r100, long r101, long r102, long r103);

    void onSuccess(ResultInfo r100);
}
