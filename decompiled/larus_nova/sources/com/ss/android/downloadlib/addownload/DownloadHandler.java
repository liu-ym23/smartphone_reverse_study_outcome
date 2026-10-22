package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadHandler {
    DownloadHandler addStatusChangeListener(int r100, DownloadStatusChangeListener r101);

    void cancelDownload(boolean r100, JSONObject r101);

    boolean deleteModel(String r100);

    long getDownloadAdId();

    String getDownloadTaskKey();

    long getLastWorkTime();

    void handleDownload(int r100);

    boolean isBind();

    boolean isDownloadStarted();

    boolean isSupportSilentDownload();

    void onBind();

    boolean onUnbind(int r100);

    void resetHandlerInfo();

    DownloadHandler setContext(Context r100);

    DownloadHandler setDownloadButtonClickListener(IDownloadButtonClickListener r100);

    DownloadHandler setDownloadController(DownloadController r100);

    DownloadHandler setDownloadEventConfig(DownloadEventConfig r100);

    void setDownloadExtra(JSONObject r100);

    DownloadHandler setDownloadModel(DownloadModel r100, int r101);

    DownloadHandler setDownloadTaskKey(String r100);

    DownloadHandler setModelId(long r100);

    DownloadHandler setOnItemClickListener(OnItemClickListener r100);
}
