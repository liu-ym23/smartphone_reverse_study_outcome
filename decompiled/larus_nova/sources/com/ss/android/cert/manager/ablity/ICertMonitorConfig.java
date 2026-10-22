package com.ss.android.cert.manager.ablity;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface ICertMonitorConfig {
    int getAppId();

    void onEvent(String r100, JSONObject r101);
}
