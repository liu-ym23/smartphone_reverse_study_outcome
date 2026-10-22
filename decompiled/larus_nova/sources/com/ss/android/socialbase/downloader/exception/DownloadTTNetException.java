package com.ss.android.socialbase.downloader.exception;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadTTNetException extends BaseException {
    private String remoteIp;

    public void parseRemoteIp() {
        String r100 = this.remoteIp;
        if (r100 == null) goto L7;
        if ("0:".equals(r100) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(getRequestLog()) == true) goto L18;
        String r101 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(getRequestLog()), "socket").optString("remote");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == true) goto L19;
        this.remoteIp = DownloadUtils.parseTTNetIp(r101);     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public String getRemoteIp() {
        return this.remoteIp;
    }

    public DownloadTTNetException setRemoteIp(String r100) {
        this.remoteIp = r100;
        return this;
    }

    public DownloadTTNetException setRequestLog(String r100) {
        setExtraInfo(r100);
        return this;
    }

    public DownloadTTNetException(int r100, String r101) {
        super(r100, r101);
    }

    public DownloadTTNetException(int r100, Throwable r101) {
        super(r100, r101);
    }
}
