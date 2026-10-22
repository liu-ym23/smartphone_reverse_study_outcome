package com.ss.android.lark.chameleon.basewebview.client;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes35.dex */
public abstract class AbsLarkWebViewClient extends WebViewClient {

    public interface ILoadCanceledCalBack {
        void sslErrorLoadEnsureCancel();
    }

    public abstract void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102, ILoadCanceledCalBack r103);

    public AbsLarkWebViewClient() {
    }
}
