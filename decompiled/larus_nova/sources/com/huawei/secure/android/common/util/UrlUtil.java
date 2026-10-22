package com.huawei.secure.android.common.util;

import android.webkit.URLUtil;

/* JADX INFO: loaded from: classes23.dex */
public class UrlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f278230a = "file:///android_res/";

    public UrlUtil() {
    }

    public static boolean isAboutUrl(String r100) {
        return URLUtil.isAboutUrl(r100);
    }

    public static boolean isAssetUrl(String r100) {
        return URLUtil.isAssetUrl(r100);
    }

    public static boolean isContentUrl(String r100) {
        return URLUtil.isContentUrl(r100);
    }

    public static boolean isDataUrl(String r100) {
        return URLUtil.isDataUrl(r100);
    }

    public static boolean isFileUrl(String r100) {
        return URLUtil.isFileUrl(r100);
    }

    public static boolean isHttpUrl(String r100) {
        return URLUtil.isHttpUrl(r100);
    }

    public static boolean isHttpsUrl(String r100) {
        return URLUtil.isHttpsUrl(r100);
    }

    public static boolean isJavaScriptUrl(String r100) {
        return URLUtil.isJavaScriptUrl(r100);
    }

    public static boolean isNetworkUrl(String r100) {
        return URLUtil.isNetworkUrl(r100);
    }

    public static boolean isResourceUrl(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith(f278230a) == false) goto L6;
        return true;
    }

    public static boolean isValidUrl(String r100) {
        return URLUtil.isValidUrl(r100);
    }
}
