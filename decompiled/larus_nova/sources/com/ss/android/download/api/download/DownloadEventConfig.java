package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadEventConfig {
    JSONObject getAdExtraDataObject();

    JSONObject getAppPkgInfo();

    String getClickButtonTag();

    String getClickContinueLabel();

    String getClickInstallLabel();

    String getClickItemTag();

    String getClickLabel();

    String getClickPauseLabel();

    String getClickStartLabel();

    int getDownloadScene();

    Object getExtraEventObject();

    JSONObject getExtraJson();

    JSONObject getParamsJson();

    String getRefer();

    String getStorageDenyLabel();

    boolean hasShowPkgInfo();

    boolean isEnableClickEvent();

    boolean isEnableV3Event();

    void setDownloadScene(int r100);

    void setRefer(String r100);
}
