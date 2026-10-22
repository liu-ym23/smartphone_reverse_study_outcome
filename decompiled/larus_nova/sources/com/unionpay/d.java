package com.unionpay;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewJavascriptBridge f462162a;

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage r100) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        r103.cancel();
        Toast.makeText(this.f462162a.mContext, r102, 0).show();
        return true;
    }

    public d(WebViewJavascriptBridge r100) {
        this.f462162a = r100;
    }
}
