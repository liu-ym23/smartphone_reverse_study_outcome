package com.ss.android.downloadad.api;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface AdWebViewDownloadManager {
    void action(long r100);

    void action(long r100, DownloadEventConfig r101, DownloadController r102);

    void action(long r100, DownloadEventConfig r101, DownloadController r102, JSONObject r103);

    boolean bind(Context r100, long r101, String r102, DownloadStatusChangeListener r103, int r104);

    boolean bind(Context r100, long r101, String r102, DownloadStatusChangeListener r103, int r104, JSONObject r105);

    boolean isDownloadInfoExisted(long r100);

    boolean tryOpenMarket(Context r100, Uri r101, DownloadModel r102);

    boolean tryOpenMarket(Context r100, Uri r101, DownloadModel r102, DownloadEventConfig r103, DownloadController r104);

    boolean tryOpenMarket(Context r100, Uri r101, DownloadModel r102, DownloadEventConfig r103, DownloadController r104, IDownloadButtonClickListener r105);

    Dialog tryStartDownload(Context r100, String r101, boolean r102, DownloadModel r103, DownloadEventConfig r104, DownloadController r105, DownloadStatusChangeListener r106, int r107);

    Dialog tryStartDownload(Context r100, String r101, boolean r102, DownloadModel r103, DownloadEventConfig r104, DownloadController r105, DownloadStatusChangeListener r106, int r107, IDownloadButtonClickListener r108);

    Dialog tryStartDownload(Context r100, String r101, boolean r102, DownloadModel r103, DownloadEventConfig r104, DownloadController r105, DownloadStatusChangeListener r106, int r107, boolean r108);

    Dialog tryStartDownload(Context r100, String r101, boolean r102, DownloadModel r103, DownloadEventConfig r104, DownloadController r105, DownloadStatusChangeListener r106, int r107, boolean r108, IDownloadButtonClickListener r110);

    Dialog tryStartDownload(Context r100, String r101, boolean r102, DownloadModel r103, DownloadStatusChangeListener r104, int r105);

    boolean unbind(long r100, int r101);
}
