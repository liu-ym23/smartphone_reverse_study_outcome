package com.bytedance.ee.bear.edit.component.richtexteditor;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import ws5.c;

/* JADX INFO: loaded from: classes16.dex */
public class a extends c {
    @Override // ws5.c, android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        super.onReceivedSslError(r100, r101, r102);
    }
}
