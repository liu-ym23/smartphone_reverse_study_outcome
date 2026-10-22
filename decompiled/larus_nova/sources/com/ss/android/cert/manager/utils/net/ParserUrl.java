package com.ss.android.cert.manager.utils.net;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.net.URL;

/* JADX INFO: loaded from: classes34.dex */
public class ParserUrl {
    private static final String TAG = "ParserUrl";
    private String mBaseUrl;
    private String mPath;
    private String mUrl;

    public ParserUrl invoke() {
        if (isHttpUrl(this.mUrl) == true) goto L22;
        return this;
    L22:
        URL r100 = new URL(this.mUrl);     // Catch: Throwable -> L19
        String r101 = r100.getProtocol();     // Catch: Throwable -> L19
        String r102 = r100.getHost();     // Catch: Throwable -> L19
        int r103 = r100.getPort();     // Catch: Throwable -> L19
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L19
        if (r102 == null) goto L13;
        if (r101 == null) goto L9;
        r104.append(r101);     // Catch: Throwable -> L19
        r104.append("://");     // Catch: Throwable -> L19
    L9:
        r104.append(r102);     // Catch: Throwable -> L19
        if (r103 <= 0) goto L12;
        r104.append(':');     // Catch: Throwable -> L19
        r104.append(r103);     // Catch: Throwable -> L19
    L12:
        r104.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L19
    L13:
        this.mBaseUrl = r104.toString();     // Catch: Throwable -> L19
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L19
        r105.append(r100.getPath());     // Catch: Throwable -> L19
        if (r100.getQuery() != null) goto L16;
        String r106 = "";
    L17:
        r105.append(r106);     // Catch: Throwable -> L19
        this.mPath = r105.toString();     // Catch: Throwable -> L19
    L21:
        return this;
    L16:
        r106 = "?" + r100.getQuery();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public String getPath() {
        return this.mPath;
    }

    public ParserUrl(String r100) {
        this.mUrl = r100;
    }

    public static boolean isHttpUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("http") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.startsWith("https") == true) goto L9;
        return false;
    }
}
