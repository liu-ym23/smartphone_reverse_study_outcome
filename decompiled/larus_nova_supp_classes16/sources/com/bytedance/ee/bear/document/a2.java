package com.bytedance.ee.bear.document;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a2 extends WebChromeClient {
    public final WebViewClient a;

    public a2(WebViewClient r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r1, boolean r2, boolean r3, Message r4) {
        tt5.a.h("DocWebChromeClient", "onCreateWindow");
        WebView r5 = new WebView(r1.getContext());
        r5.setWebViewClient(this.a);
        ((WebView.WebViewTransport) r4.obj).setWebView(r5);
        r4.sendToTarget();
        return true;
    }
}
