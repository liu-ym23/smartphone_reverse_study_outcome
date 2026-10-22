package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public class i extends uwb.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<WebViewClient> f411166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j> f411167f;

    public i(wwb.c r100) {
        super(r100);
        this.f411166e = new CopyOnWriteArrayList();
        this.f411167f = new CopyOnWriteArrayList();
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        super.onLoadResource(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onLoadResource(r100, r101);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        super.onPageCommitVisible(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onPageCommitVisible(r100, r101);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onPageFinished(r100, r101);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        super.onReceivedClientCertRequest(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onReceivedClientCertRequest(r100, r101);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).onRenderProcessGone(r100, r101) == false) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return true;
    L11:
        if (super.onRenderProcessGone(r100, r101) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r103 = false;
        goto L9
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        super.onUnhandledKeyEvent(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onUnhandledKeyEvent(r100, r101);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        WebResourceResponse r103 = ((WebViewClient) r102.next()).shouldInterceptRequest(r100, r101);
        if (r103 == null) goto L4;
    L9:
        if (r103 != null) goto L12;
        r103 = super.shouldInterceptRequest(r100, r101);
    L12:
        if (r101.isForMainFrame() == true) goto L14;
    L29:
        return r103;
    L14:
        if (r103 != null) goto L17;
        com.ss.android.lark.officesdk.utils.di.j.e("ExtendableWebViewClientV2", "injectScriptIntoResponse: response is null, can not inject script");
        goto L29
    L17:
        if (((CopyOnWriteArrayList) this.f411167f).isEmpty() == false) goto L19;
        com.ss.android.lark.officesdk.utils.di.j.e("ExtendableWebViewClientV2", "injectScriptIntoResponse: scripInjectors is empty, no need to inject script");
        goto L29
    L19:
        StringBuilder r104 = new StringBuilder("<!DOCTYPE html>\n");
        Iterator r105 = ((CopyOnWriteArrayList) this.f411167f).iterator();
    L21:
        if (r105.hasNext() == false) goto L25;
        String r106 = ((j) r105.next()).a(r101).trim();
        if (TextUtils.isEmpty(r106) == true) goto L21;
        r104.append(r106);
        r104.append("\n");
        goto L21
    L25:
        String r107 = r104.toString();
        com.ss.android.lark.officesdk.utils.di.j.e("ExtendableWebViewClientV2", "injectScriptIntoResponse: injectScriptText: " + r107);
        ByteArrayInputStream r108 = new ByteArrayInputStream(r107.getBytes());
        InputStream r109 = r103.getData();
        if (r109 != null) goto L28;
        com.ss.android.lark.officesdk.utils.di.j.f("ExtendableWebViewClientV2", "injectScriptIntoResponse: originStream is null, only injecting script.");
        goto L29
    L28:
        r103.setData(new SequenceInputStream(r108, r109));
        goto L29
    L8:
        r103 = null;
        goto L9
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideKeyEvent(r100, r101) == false) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return true;
    L11:
        if (super.shouldOverrideKeyEvent(r100, r101) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r103 = false;
        goto L9
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        super.doUpdateVisitedHistory(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).doUpdateVisitedHistory(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        super.onFormResubmission(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onFormResubmission(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onPageStarted(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedError(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedHttpError(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        super.onReceivedSslError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedSslError(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        super.onScaleChanged(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onScaleChanged(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        super.onTooManyRedirects(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onTooManyRedirects(r100, r101, r102);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedError(r100, r101, r102, r103);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedHttpAuthRequest(r100, r101, r102, r103);
        goto L4
    }

    @Override // uwb.c, android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        super.onReceivedLoginRequest(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f411166e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedLoginRequest(r100, r101, r102, r103);
        goto L4
    }
}
