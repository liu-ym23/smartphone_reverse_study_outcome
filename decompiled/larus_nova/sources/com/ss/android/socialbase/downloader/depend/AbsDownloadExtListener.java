package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDownloadExtListener extends AbsDownloadListener implements IDownloadExtListener {
    private static final String TAG = null;

    static {
        TAG = "AbsDownloadExtListener";
    }

    public AbsDownloadExtListener() {
    }

    public void onWaitingDownloadCompleteHandler(DownloadInfo r100) {
        if (Logger.debugScene(r100) == false) goto L7;
        if (r100 == null) goto L8;
        Logger.taskDebug(TAG, r100, "onWaitingDownloadCompleteHandler", "Name:" + r100.getName());
        return;
    L8:
        return;
    }
}
