package com.tencent.open.web;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes35.dex */
public class a {
    private static void a(WebSettings r100) {
        r100.setSavePassword(false);     // Catch: Exception -> L5
        r100.setAllowFileAccess(false);     // Catch: Exception -> L5
        r100.setAllowFileAccessFromFileURLs(false);     // Catch: Exception -> L5
        r100.setAllowUniversalAccessFromFileURLs(false);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("WebViewUtils", "Exception", e);
    }

    private static void b(WebView r100) {
        r100.removeJavascriptInterface("searchBoxJavaBridge_");
        r100.removeJavascriptInterface("accessibility");
        r100.removeJavascriptInterface("accessibilityTraversal");
    }

    public static void a(WebView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        b(r100);
        WebSettings r101 = r100.getSettings();
        if (r101 == null) goto L8;
        a(r101);
        b(r101);
        return;
    }

    private static void b(WebSettings r100) {
        r100.setJavaScriptEnabled(true);
    }
}
