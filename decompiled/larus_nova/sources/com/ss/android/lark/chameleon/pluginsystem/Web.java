package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.NonProguard;

/* JADX INFO: loaded from: classes35.dex */
public interface Web {
    public static final int DEFAULT_PRIORITY = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.Web$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addJSONParamInterceptor(Web r100, JSONParamInterceptor r101) {
        }

        public static String $default$getWebViewId(Web r100) {
            return "";
        }

        public static void $default$removeJSONParamInterceptor(Web r100) {
        }
    }

    public interface JSONParamInterceptor {
        boolean enableAddJsonExtraParam();

        String getInterceptFuncName();

        JsonObject getInterceptJSONObject();
    }

    void addJSONParamInterceptor(JSONParamInterceptor r100);

    void addOnTouchListener(View.OnTouchListener r100);

    void addWebChromeClientDelegate(WebChromeClient r100);

    void addWebChromeClientDelegate(WebChromeClient r100, int r101);

    void addWebViewClientDelegate(WebViewClient r100);

    void addWebViewClientDelegate(WebViewClient r100, int r101);

    void bindJSHandler(String r100, BridgeHandler r101);

    void bindJSHandler(String r100, BridgeHandlerV2 r101);

    void bindJSHandler(String r100, JSHandler r101);

    void execJS(String r100);

    void execJS(String r100, JsonObject r101);

    void execJS(String r100, JsonObject r101, ValueCallback<String> r102);

    void execJS(String r100, NonProguard r101);

    void execJS(String r100, NonProguard r101, ValueCallback<String> r102);

    IBridge getBridge();

    Context getContext();

    WebView getWebView();

    String getWebViewId();

    void loadUrl(String r100);

    void removeJSONParamInterceptor();

    void removeOnTouchListener(View.OnTouchListener r100);

    void removeWebChromeClientDelegate(WebChromeClient r100);

    void removeWebViewClientDelegate(WebViewClient r100);

    void unbindJSHandler(String r100);
}
