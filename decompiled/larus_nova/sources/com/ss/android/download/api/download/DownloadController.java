package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadController {
    boolean enableAH();

    boolean enableAM();

    boolean enableNewActivity();

    boolean enableShowComplianceDialog();

    String getBizParamsJson();

    String getCertId();

    int getDowloadChunkCount();

    int getDownloadMode();

    Object getExtraClickOperation();

    JSONObject getExtraJson();

    Object getExtraObject();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isAutoDownloadOnCardShow();

    boolean isEnableBackDialog();

    boolean isEnableMultipleDownload();

    boolean isOrderDownload();

    void setDownloadMode(int r100);

    void setEnableNewActivity(boolean r100);

    void setEnableShowComplianceDialog(boolean r100);

    void setLinkMode(int r100);

    boolean shouldUseNewWebView();
}
