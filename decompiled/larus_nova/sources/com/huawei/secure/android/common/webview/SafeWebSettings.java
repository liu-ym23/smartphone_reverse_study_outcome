package com.huawei.secure.android.common.webview;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes23.dex */
public class SafeWebSettings {
    public static void disablePasswordStorage(WebSettings r100) {
    }

    public SafeWebSettings() {
    }

    public static void disableContentAccess(WebSettings r100) {
        r100.setAllowContentAccess(false);
    }

    public static void disableFileCrossAccess(WebSettings r100) {
        r100.setAllowFileAccess(false);
        r100.setAllowFileAccessFromFileURLs(false);
        r100.setAllowUniversalAccessFromFileURLs(false);
    }

    public static void disableGeolocation(WebSettings r100) {
        r100.setGeolocationEnabled(false);
    }

    public static void disableMixedContentMode(WebSettings r100) {
        r100.setMixedContentMode(1);
    }

    public static void initWebviewAndSettings(WebView r100) {
        WebSettings r101 = r100.getSettings();
        disableFileCrossAccess(r101);
        removeUnSafeJavascriptImpl(r100);
        disablePasswordStorage(r101);
        disableGeolocation(r101);
        disableMixedContentMode(r101);
        disableContentAccess(r101);
    }

    public static void removeUnSafeJavascriptImpl(WebView r100) {
        r100.removeJavascriptInterface("searchBoxJavaBridge_");
        r100.removeJavascriptInterface("accessibility");
        r100.removeJavascriptInterface("accessibilityTraversal");
    }
}
