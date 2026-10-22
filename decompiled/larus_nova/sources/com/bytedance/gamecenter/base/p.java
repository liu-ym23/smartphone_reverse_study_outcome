package com.bytedance.gamecenter.base;

import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.DownloadStatusChangeListener2;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface p extends DownloadStatusChangeListener2, DownloadStatusChangeListener {
    void a(DownloadInfo r100);

    void b(DownloadShortInfo r100);

    void c(JSONObject r100);

    void d(JSONObject r100);

    void e(JSONObject r100);

    void onInstallFailed(DownloadShortInfo r100, int r101);

    void onJumpInstall(DownloadShortInfo r100, int r101);

    void onShow();

    void onUpdate();
}
