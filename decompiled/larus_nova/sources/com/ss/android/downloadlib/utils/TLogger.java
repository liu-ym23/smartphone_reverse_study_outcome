package com.ss.android.downloadlib.utils;

import com.ss.android.download.api.config.DownloadTLogger;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class TLogger {
    private static String TAG = "TTDownloaderLogger";

    public TLogger() {
    }

    public static void d(String r100) {
        d(TAG, r100, null);
    }

    public static void e(String r100) {
        e(TAG, r100, null);
    }

    public static void v(String r100) {
        v(TAG, r100, null);
    }

    public static void d(String r100, JSONObject r101) {
        d(TAG, r100, r101);
    }

    public static void e(String r100, JSONObject r101) {
        e(TAG, r100, r101);
    }

    public static void v(String r100, JSONObject r101) {
        v(TAG, r100, r101);
    }

    public static void d(String r100, String r101) {
        d(r100, r101, null);
    }

    public static void e(String r100, String r101) {
        e(r100, r101, null);
    }

    public static void v(String r100, String r101) {
        v(r100, r101, null);
    }

    public static void d(String r100, String r101, JSONObject r102) {
        DownloadTLogger r103 = GlobalInfo.getDownloadTLogger();
        if (r103 == null) goto L6;
        r103.log(3, r100, r101, r102);
        return;
    }

    public static void e(String r100, String r101, JSONObject r102) {
        DownloadTLogger r103 = GlobalInfo.getDownloadTLogger();
        if (r103 == null) goto L6;
        r103.log(6, r100, r101, r102);
        return;
    }

    public static void v(String r100, String r101, JSONObject r102) {
        DownloadTLogger r103 = GlobalInfo.getDownloadTLogger();
        if (r103 == null) goto L6;
        r103.log(2, r100, r101, r102);
        return;
    }
}
