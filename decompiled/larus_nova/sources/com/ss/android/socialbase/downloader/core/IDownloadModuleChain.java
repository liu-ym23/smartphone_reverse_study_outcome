package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadModuleChain {
    void onDownloadStart();

    void proceed() throws BaseException;
}
