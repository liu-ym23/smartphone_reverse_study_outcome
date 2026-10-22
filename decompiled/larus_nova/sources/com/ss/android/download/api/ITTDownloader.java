package com.ss.android.download.api;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.downloadad.api.AdDownloadCompletedEventHandler;
import com.ss.android.downloadad.api.AdWebViewDownloadManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface ITTDownloader {
    void action(String r100, int r101, DownloadEventConfig r102);

    void action(String r100, long r101, int r102);

    void action(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104);

    void action(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104, IDownloadButtonClickListener r105);

    void action(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104, OnItemClickListener r105, IDownloadButtonClickListener r106);

    void action(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104, DownloadModel r105);

    void action(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104, JSONObject r105);

    void addDownloadCompletedListener(DownloadCompletedListener r100);

    void bind(int r100, DownloadStatusChangeListener r101, DownloadModel r102);

    void bind(Context r100, int r101, DownloadStatusChangeListener r102, DownloadModel r103);

    void cancel(String r100);

    void cancel(String r100, boolean r101);

    ActionDecisionApi getActionDecision(String r100, long r101, int r102, DownloadEventConfig r103, DownloadController r104);

    AdDownloadCompletedEventHandler getAdDownloadCompletedEventHandler();

    AdWebViewDownloadManager getAdWebViewDownloadManager();

    DownloadConfigure getDownloadConfigure();

    DownloadInfo getDownloadInfo(String r100);

    DownloadInfo getDownloadInfo(String r100, String r101);

    boolean isStarted(String r100);

    void removeDownloadCompletedListener(DownloadCompletedListener r100);

    void unbind(String r100, int r101);
}
