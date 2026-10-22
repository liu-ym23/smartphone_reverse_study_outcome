package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.JsCallBack;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;

/* JADX INFO: loaded from: classes35.dex */
public class SimpleWebV2 implements Web {
    private static final String BIZ_EXCE_JS = "biz.execJS";
    private static final String TAG = "SimpleWebV2";
    private final Bridge bridge;
    private final WebView webView;

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ void addJSONParamInterceptor(Web.JSONParamInterceptor r100) {
        Web.CC.$default$addJSONParamInterceptor(this, r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addOnTouchListener(View.OnTouchListener r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r100, int r101) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebViewClientDelegate(WebViewClient r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebViewClientDelegate(WebViewClient r100, int r101) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r100, BridgeHandler r101) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public IBridge getBridge() {
        return null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ String getWebViewId() {
        return Web.CC.$default$getWebViewId(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ void removeJSONParamInterceptor() {
        Web.CC.$default$removeJSONParamInterceptor(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeOnTouchListener(View.OnTouchListener r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeWebChromeClientDelegate(WebChromeClient r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeWebViewClientDelegate(WebViewClient r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public Context getContext() {
        return this.webView.getContext().getApplicationContext();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public WebView getWebView() {
        return this.webView;
    }

    public static CallBackFunction newToOldCallback(final JsCallBack r100) {
        return new AnonymousClass1(r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r100) {
        execJS(r100, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void loadUrl(String r100) {
        this.webView.loadUrl(r100);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void unbindJSHandler(String r100) {
        this.bridge.unRegisterHandler(r100);
    }

    public SimpleWebV2(WebView r100, Bridge r101) {
        this.webView = r100;
        this.bridge = r101;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r100, BridgeHandlerV2 r101) {
        this.bridge.registerHandler(r100, BridgeWebViewV2.oldToNewHandler(r101));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r100, NonProguard r101) {
        this.bridge.callJSFun(r100, r101, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r100, JSHandler r101) {
        this.bridge.registerHandler(r100, BridgeWebViewV2.oldToNewHandler(r101));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r100, JsonObject r101) {
        execJS(r100, r101, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r100, JsonObject r101, ValueCallback<String> r102) {
        this.bridge.callJSFun(r100, r101.toString(), r102);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        SafeJSExecutor.execJS(this.webView, r100, r101, r102);
    }
}
