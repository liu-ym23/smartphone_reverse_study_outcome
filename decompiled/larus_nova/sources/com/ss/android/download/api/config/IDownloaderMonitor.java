package com.ss.android.download.api.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IDownloaderMonitor {
    void monitorDuration(String r100, JSONObject r101, JSONObject r102);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);
}
