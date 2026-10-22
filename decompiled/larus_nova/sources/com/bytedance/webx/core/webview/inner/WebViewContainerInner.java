package com.bytedance.webx.core.webview.inner;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewStructure;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import iq7.d;
import iq7.g;
import java.util.concurrent.Executor;
import oq7.c;
import pq7.a;
import pq7.b;

/* JADX INFO: loaded from: classes22.dex */
public class WebViewContainerInner extends WebView implements b, d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f272591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f272592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rq7.b f272593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rq7.a f272594d;

    @Override // pq7.b
    public oq7.a getExtendableContext() {
        a r100 = this.f272592b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f530284a;
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        if (this.f272591a != null) goto L7;
        return super.getWebChromeClient();
    L7:
        return this.f272594d;
    }

    public WebChromeClient getWebChromeClientCompat() {
        return this.f272594d.f543081c;
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        if (this.f272591a != null) goto L7;
        return super.getWebViewClient();
    L7:
        return this.f272593c;
    }

    public WebViewClient getWebViewClientCompat() {
        return this.f272593c.f543084c;
    }

    @Override // android.webkit.WebView
    public WebMessagePort[] createWebMessageChannel() {
        return super.createWebMessageChannel();
    }

    @Override // android.webkit.WebView
    public WebViewRenderProcess getWebViewRenderProcess() {
        return super.getWebViewRenderProcess();
    }

    @Override // android.webkit.WebView
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return super.getWebViewRenderProcessClient();
    }

    public rq7.a getExtendableWebChromeClient() {
        return this.f272594d;
    }

    public rq7.b getExtendableWebViewClient() {
        return this.f272593c;
    }

    public WebViewContainerInner(Context r100) {
        super(r100);
        this.f272592b = new a();
    }

    @Override // pq7.b
    public final void b(g r100) {
        g.c();
        this.f272591a = r100;
        this.f272592b.f530284a = new oq7.a(this.f272591a, this);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onProvideVirtualStructure(ViewStructure r100) {
        super.onProvideVirtualStructure(r100);
    }

    public void setExtendableWebViewClient(rq7.a r100) {
        this.f272594d = r100;
        super.setWebChromeClient(r100);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        if (this.f272591a != null) goto L6;
        super.setWebChromeClient(r100);
        return;
    L6:
        this.f272594d.f543081c = r100;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        if (this.f272591a != null) goto L6;
        super.setWebViewClient(r100);
        return;
    L6:
        this.f272593c.f543084c = r100;
    }

    @Override // android.webkit.WebView
    public void setWebViewRenderProcessClient(WebViewRenderProcessClient r100) {
        super.setWebViewRenderProcessClient(r100);
    }

    @Override // android.webkit.WebView
    public void zoomBy(float r100) {
        super.zoomBy(r100);
    }

    public void setExtendableWebViewClient(rq7.b r100) {
        this.f272593c = r100;
        super.setWebViewClient(r100);
    }

    public WebViewContainerInner(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f272592b = new a();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure r100, int r101) {
        super.onProvideAutofillVirtualStructure(r100, r101);
    }

    @Override // android.webkit.WebView
    public void postWebMessage(WebMessage r100, Uri r101) {
        super.postWebMessage(r100, r101);
    }

    @Override // android.webkit.WebView
    public void setWebViewRenderProcessClient(Executor r100, WebViewRenderProcessClient r101) {
        super.setWebViewRenderProcessClient(r100, r101);
    }

    public WebViewContainerInner(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f272592b = new a();
    }
}
