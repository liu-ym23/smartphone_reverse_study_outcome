package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes38.dex */
public interface ITempFileSaveCompleteCallback {
    void onFailed(BaseException r100);

    void onSameTaskSave();

    void onSuccess();
}
