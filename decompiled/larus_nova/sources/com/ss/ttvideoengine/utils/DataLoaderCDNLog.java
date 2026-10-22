package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class DataLoaderCDNLog {
    public long contentLength;
    public String fileKey;
    public String host;
    public long reqEndT;
    public long reqStartT;
    public String serverIp;
    public String url;
    public String xCache;
    public String xMCache;

    public DataLoaderCDNLog(JSONObject r100) throws Exception {
        if (r100 == null) goto L9;
        this.url = r100.optString("url");     // Catch: Exception -> L6
        this.host = new URL(this.url).getHost();     // Catch: Exception -> L6
        this.serverIp = r100.optString("server_ip");     // Catch: Exception -> L6
        this.xCache = r100.optString("x_cache");     // Catch: Exception -> L6
        this.xMCache = r100.optString("x_m_cache");     // Catch: Exception -> L6
        this.fileKey = r100.optString("f_key");     // Catch: Exception -> L6
        this.contentLength = r100.optLong("contentLength", -1);     // Catch: Exception -> L6
        this.reqStartT = r100.optLong("req_start_t", -1);     // Catch: Exception -> L6
        this.reqEndT = r100.optLong("req_end_t", -1);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new Exception("log null");
    }

    public static JSONObject process(JSONObject r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        String r101 = r100.optString("url");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r101) == true) goto L10;
        String r102 = new URL(r101).getHost();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r100.put("host", r102);     // Catch: Exception -> L11
    L10:
        return r100;
    L11:
        return null;
    }
}
