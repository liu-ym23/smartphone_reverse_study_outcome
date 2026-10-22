package com.ss.android.lark.chameleon.basewebview.client;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Log;
import k0b.a;

/* JADX INFO: loaded from: classes35.dex */
public class LarkBaseWebViewClient extends WebViewClient {
    private static final String TAG = "LarkBaseWebViewClient";
    private WebViewClient mClient;
    private ILarkWebViewContext mContext;

    public static /* synthetic */ void a() {
        lambda$onReceivedSslError$0();
    }

    private static /* synthetic */ void lambda$onReceivedSslError$0() {
        Log.i(TAG, "sslErrorLoadEnsureCancel clicked");
    }

    public WebViewClient getWebViewClient() {
        return this.mClient;
    }

    public LarkBaseWebViewClient(ILarkWebViewContext r100) {
        this.mContext = r100;
    }

    public void setWebViewClient(WebViewClient r100) {
        StringBuilder r101 = new StringBuilder("Caller setWebViewClient: client=");
        if (r100 != null) goto L5;
        Object r102 = "null";
    L6:
        r101.append(r102);
        Log.i(TAG, r101.toString());
        this.mClient = r100;
        return;
    L5:
        r102 = Integer.valueOf(r100.hashCode());
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        Log.i(TAG, "onLoadResource, this" + hashCode());
        super.onLoadResource(r100, r101);
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onLoadResource(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        Log.i(TAG, "onPageCommitVisible");
        super.onPageCommitVisible(r100, r101);
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onPageCommitVisible(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        Log.i(TAG, "onPageFinished");
        super.onPageFinished(r100, r101);
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onPageFinished(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedClientCertRequest mClient handle");
        this.mClient.onReceivedClientCertRequest(r100, r101);
        return;
    L5:
        Log.i(TAG, "onReceivedClientCertRequest default handle");
        super.onReceivedClientCertRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L6;
        boolean r103 = r102.onRenderProcessGone(r100, r101);
        Log.i(TAG, "onRenderProcessGone mClient handle result " + r103);
        return r103;
    L6:
        Log.i(TAG, "onRenderProcessGone default return true");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onUnhandledKeyEvent mClient handle");
        this.mClient.onUnhandledKeyEvent(r100, r101);
        return;
    L5:
        Log.i(TAG, "onUnhandledKeyEvent default handle");
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.shouldInterceptRequest(r100, r101);
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return super.shouldInterceptRequest(r100, r101);
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        boolean r102 = super.shouldOverrideKeyEvent(r100, r101);
        WebViewClient r103 = this.mClient;
        if (r103 == null) goto L5;
        r102 = r102 | r103.shouldOverrideKeyEvent(r100, r101);
    L5:
        Log.i(TAG, "shouldOverrideKeyEvent , override = " + r102);
        return r102;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        WebViewClient r102 = this.mClient;
        boolean r103 = false;
        if (r102 == null) goto L5;
        r103 = false | r102.shouldOverrideUrlLoading(r100, r101);
        Log.i(TAG, "after mClient override url intercept = " + r103);
    L5:
        if (r103 == false) goto L8;
        Log.i(TAG, "shouldOverrideUrlLoading intercept return true");
        return true;
    L8:
        Log.i(TAG, "shouldOverrideUrlLoading return default");
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        WebViewClient r102 = this.mClient;
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.shouldInterceptRequest(r100, r101);
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return super.shouldInterceptRequest(r100, r101);
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        WebViewClient r102 = this.mClient;
        boolean r103 = false;
        if (r102 == null) goto L5;
        r103 = false | r102.shouldOverrideUrlLoading(r100, r101);
        Log.i(TAG, "after mClient override , intercept = " + r103);
    L5:
        if (r103 == false) goto L8;
        Log.i(TAG, "shouldOverrideUrlLoading intercept return true");
        return true;
    L8:
        boolean r104 = super.shouldOverrideUrlLoading(r100, r101);
        Log.i(TAG, "shouldOverrideUrlLoading return default");
        return r104;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "doUpdateVisitedHistory mClient handle , isReload = " + r102);
        this.mClient.doUpdateVisitedHistory(r100, r101, r102);
        return;
    L5:
        Log.i(TAG, "doUpdateVisitedHistory default handle, isReload = " + r102);
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r100, Message r101, Message r102) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onFormResubmission mClient handle");
        this.mClient.onFormResubmission(r100, r101, r102);
        return;
    L5:
        Log.i(TAG, "onFormResubmission default handle");
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        Log.i(TAG, "onPageStarted url ");
        super.onPageStarted(r100, r101, r102);
        WebViewClient r103 = this.mClient;
        if (r103 == null) goto L6;
        r103.onPageStarted(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        WebViewClient r103 = this.mClient;
        if (r103 == null) goto L5;
        r103.onReceivedError(r100, r101, r102);
        return;
    L5:
        super.onReceivedError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        WebViewClient r103 = this.mClient;
        if (r103 == null) goto L5;
        r103.onReceivedHttpError(r100, r101, r102);
        return;
    L5:
        super.onReceivedHttpError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        WebViewClient r103 = this.mClient;
        if ((r103 instanceof AbsLarkWebViewClient) == false) goto L6;
        Log.i(TAG, "mClient instanceof AbsLarkWebViewClient");
        ((AbsLarkWebViewClient) this.mClient).onReceivedSslError(r100, r101, r102, new a());
        return;
    L6:
        if (r103 == null) goto L9;
        r103.onReceivedSslError(r100, r101, r102);
        return;
    L9:
        super.onReceivedSslError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r100, float r101, float r102) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onScaleChanged mClient handle");
        this.mClient.onScaleChanged(r100, r101, r102);
        return;
    L5:
        Log.i(TAG, "onScaleChanged default handle");
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onTooManyRedirects mClient handle");
        this.mClient.onTooManyRedirects(r100, r101, r102);
        return;
    L5:
        Log.i(TAG, "onTooManyRedirects default handle");
        super.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        WebViewClient r104 = this.mClient;
        if (r104 == null) goto L5;
        r104.onReceivedError(r100, r101, r102, r103);
        return;
    L5:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedHttpAuthRequest mClient handle");
        this.mClient.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    L5:
        Log.i(TAG, "onReceivedHttpAuthRequest default handle");
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedLoginRequest mClient handle");
        this.mClient.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    L5:
        Log.i(TAG, "onReceivedLoginRequest default handle");
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        Log.i(TAG, "onSafeBrowsingHit");
        super.onSafeBrowsingHit(r100, r101, r102, r103);
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onSafeBrowsingHit mClient handle");
        this.mClient.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    }
}
