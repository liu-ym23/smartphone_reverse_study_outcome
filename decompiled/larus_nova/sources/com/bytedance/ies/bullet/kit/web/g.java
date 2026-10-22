package com.bytedance.ies.bullet.kit.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends b36.q {
    public g() {
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        com.bytedance.android.monitorV2.webview.m.f163358f.H(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        com.bytedance.android.monitorV2.webview.m.f163358f.I(r100, r101);
    }

    @Override // b36.q, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        com.bytedance.android.monitorV2.webview.m.f163358f.u(r100, r101, r102);
    }

    @Override // b36.q, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        com.bytedance.android.monitorV2.webview.m.f163358f.x(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        com.bytedance.android.monitorV2.webview.m.f163358f.t(r100, r101, r102, r103);
    }
}
