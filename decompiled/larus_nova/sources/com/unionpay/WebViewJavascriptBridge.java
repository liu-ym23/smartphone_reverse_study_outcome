package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class WebViewJavascriptBridge implements Serializable {
    f _messageHandler;
    Map _messageHandlers;
    Map _responseCallbacks;
    long _uniqueId;
    private boolean mAllowScheme;
    Activity mContext;
    WebView mWebView;

    public WebViewJavascriptBridge(Activity r100, WebView r101, f r102) {
        this.mAllowScheme = false;
        this.mContext = r100;
        this.mWebView = r101;
        this._messageHandler = r102;
        this._messageHandlers = new HashMap();
        this._responseCallbacks = new HashMap();
        this._uniqueId = 0;
        WebSettings r103 = this.mWebView.getSettings();
        r103.setJavaScriptEnabled(true);
        r103.setSavePassword(false);
        r103.setAllowFileAccess(false);
        r103.setDomStorageEnabled(true);
        this.mWebView.removeJavascriptInterface("accessibility");     // Catch: Throwable -> L5
        this.mWebView.removeJavascriptInterface("accessibilityTraversal");     // Catch: Throwable -> L5
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");     // Catch: Throwable -> L5
    L7:
        this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
        this.mWebView.setWebViewClient(new e(this));
        this.mWebView.setWebChromeClient(new d(this));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public static /* synthetic */ boolean access$200(WebViewJavascriptBridge r100) {
        return r100.mAllowScheme;
    }

    public static String convertStreamToString(InputStream r100) {
        String r101 = "";
        Scanner r102 = new Scanner(r100, "UTF-8").useDelimiter("\\A");     // Catch: Exception -> L8
        if (r102.hasNext() == false) goto L6;
        r101 = r102.next();     // Catch: Exception -> L8
    L6:
        r100.close();     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @JavascriptInterface
    public void _handleMessageFromJs(String r100, String r101, String r102, String r103, String r104) {
        if (r101 == null) goto L5;
        ((g) this._responseCallbacks.get(r101)).a(r102);
        this._responseCallbacks.remove(r101);
        return;
    L5:
        if (r103 == null) goto L7;
        c r105 = new c(this, r103);
    L8:
        if (r104 == null) goto L13;
        f r106 = (f) this._messageHandlers.get(r104);
        if (r106 != null) goto L19;
        "WVJB Warning: No handler for ".concat(r104);
        return;
    L19:
        this.mContext.runOnUiThread(new b0(r106, r100, r105));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.getMessage();
        return;
    L13:
        r106 = this._messageHandler;
        goto L19
    L7:
        r105 = null;
        goto L8
    }

    public final void b(String r100, g r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("data", r100);
        if (r101 == null) goto L5;
        StringBuilder r104 = new StringBuilder("java_cb_");
        long r105 = this._uniqueId + 1;
        this._uniqueId = r105;
        r104.append(r105);
        String r106 = r104.toString();
        this._responseCallbacks.put(r106, r101);
        r103.put("callbackId", r106);
    L5:
        if (r102 == null) goto L7;
        r103.put("handlerName", r102);
    L7:
        a(r103);
    }

    public void callHandler(String r100) {
        callHandler(r100, null, null);
    }

    public void callHandler(String r100, String r101) {
        callHandler(r100, r101, null);
    }

    public void callHandler(String r100, String r101, g r102) {
        b(r101, r102, r100);
    }

    public void registerHandler(String r100, f r101) {
        this._messageHandlers.put(r100, r101);
    }

    public void send(String r100) {
        send(r100, null);
    }

    public void send(String r100, g r101) {
        b(r100, r101, null);
    }

    public void setAllowScheme(boolean r100) {
        this.mAllowScheme = r100;
    }

    public final void a(Map r100) {
        String r101 = new JSONObject(r100).toString();
        "sending:".concat(String.valueOf(r101));
        this.mContext.runOnUiThread(new c0(this, String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", new Object[]{r101.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f")})));
    }

    public static void access$300(WebViewJavascriptBridge r100, String r101, String r102) {
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("responseId", r101);
        r103.put(OnekeyLoginConstants.CT_KEY_RSP_DATA, r102);
        r100.a(r103);
    }
}
