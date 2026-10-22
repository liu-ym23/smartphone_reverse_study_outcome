package com.ss.android.lark.chameleon.util;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.NonProguard;

/* JADX INFO: loaded from: classes35.dex */
public class SafeJSExecutor {
    private static final String TAG = "SafeJSExecutor";

    public SafeJSExecutor() {
    }

    private static boolean webViewNotOk(WebView r100) {
        if (r100 != null) goto L5;
        new IllegalStateException("execJS no webView !");
        return true;
    L5:
        return false;
    }

    public static void execJS(WebView r100, String r101) {
        execJS(r100, r101, null, null);
    }

    public static void execJS(WebView r100, String r101, JsonObject r102) {
        execJS(r100, r101, r102, null);
    }

    public static void execJS(WebView r100, String r101, NonProguard r102) {
        execJS(r100, r101, r102, null);
    }

    public static void execJS(WebView r100, String r101, JsonObject r102, ValueCallback<String> r103) {
        if (webViewNotOk(r100) == false) goto L5;
        return;
    L5:
        r100.evaluateJavascript(JsonUtils.INSTANCE.combineRequestContent(r101, r102), r103);
    }

    public static void execJS(WebView r100, String r101, NonProguard r102, ValueCallback<String> r103) {
        if (webViewNotOk(r100) == false) goto L5;
        return;
    L5:
        r100.evaluateJavascript(JsonUtils.INSTANCE.combineRequestContent(r101, r102), r103);
    }
}
