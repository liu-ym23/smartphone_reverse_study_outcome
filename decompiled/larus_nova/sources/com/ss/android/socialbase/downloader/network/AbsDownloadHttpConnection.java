package com.ss.android.socialbase.downloader.network;

import android.util.Pair;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDownloadHttpConnection implements IDownloadHttpConnection {
    public AbsDownloadHttpConnection() {
    }

    public String getHostIp() {
        return "";
    }

    public long getRacingTaskExcessBytes() {
        return 0;
    }

    public String getRedirectPartialUrlResults() {
        return "";
    }

    public String getRequestLog() {
        return "";
    }

    public List<Pair<String, String>> getResponseHeaders() {
        return null;
    }

    public boolean isOkhttp() {
        return false;
    }

    public void monitorNetworkInfo(JSONObject r100, boolean r101) {
    }

    public void onThrowable(Throwable r100) {
    }

    public void setThrottleNetSpeedWhenRunning(long r100) {
    }
}
