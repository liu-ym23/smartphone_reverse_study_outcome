package com.ss.mediakit.medialoader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDataLoaderNotifyInfo {
    public long code;
    public JSONObject jsonLog;
    public String logExtraJsonStr;
    public String logInfo;
    public String logType;
    public long parameter;
    public int what;

    public void logToJson() {
        if (this.logInfo != null) goto L5;
        return;
    L5:
        this.jsonLog = null;
        this.jsonLog = new JSONObject(this.logInfo);     // Catch: Exception -> L8
        return;
    L8:
        this.jsonLog = null;
    }

    public AVMDLDataLoaderNotifyInfo() {
        this.what = -1;
        this.code = -1;
        this.parameter = -1;
        this.logInfo = null;
        this.jsonLog = null;
    }

    public AVMDLDataLoaderNotifyInfo(int r100, int r101, String r102) {
        this.what = r100;
        this.code = r101;
        this.parameter = -1;
        this.logInfo = r102;
        this.jsonLog = null;
    }
}
