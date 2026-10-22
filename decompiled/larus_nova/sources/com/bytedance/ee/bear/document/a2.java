package com.bytedance.ee.bear.document;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes16.dex */
public final class a2 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewClient f218650a;

    public a2(WebViewClient r100) {
        this.f218650a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        tt5.a.h("DocWebChromeClient", "onCreateWindow");
        WebView r104 = new WebView(r100.getContext());
        r104.setWebViewClient(this.f218650a);
        ((WebView.WebViewTransport) r103.obj).setWebView(r104);
        r103.sendToTarget();
        return true;
    }
}
