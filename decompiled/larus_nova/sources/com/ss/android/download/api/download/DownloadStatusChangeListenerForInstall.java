package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadStatusChangeListenerForInstall extends DownloadStatusChangeListener {
    void onInstallFailed(DownloadShortInfo r100, int r101);

    void onJumpInstall(DownloadShortInfo r100, int r101);
}
