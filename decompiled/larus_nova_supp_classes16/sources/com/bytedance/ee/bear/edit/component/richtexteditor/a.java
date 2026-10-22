package com.bytedance.ee.bear.edit.component.richtexteditor;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import ws5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a extends c {
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
    }

    public void onPageStarted(WebView r1, String r2, Bitmap r3) {
        super.onPageStarted(r1, r2, r3);
    }

    public final void onReceivedError(WebView r1, WebResourceRequest r2, WebResourceError r3) {
        super.onReceivedError(r1, r2, r3);
    }

    public final void onReceivedHttpError(WebView r1, WebResourceRequest r2, WebResourceResponse r3) {
        super.onReceivedHttpError(r1, r2, r3);
    }

    public final void onReceivedSslError(WebView r1, SslErrorHandler r2, SslError r3) {
        super.onReceivedSslError(r1, r2, r3);
    }
}
