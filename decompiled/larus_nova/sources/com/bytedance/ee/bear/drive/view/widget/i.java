package com.bytedance.ee.bear.drive.view.widget;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<j> f225978a;

    public i() {
        this.f225978a = new ArrayList();
    }

    public final void a(WebView r100, int r101) {
        tt5.a.h("DriveWebViewClientDelegate", "onRenderProcessGone rendererPriority is " + r101);
        Iterator<j> r102 = this.f225978a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().c(r100, r101);
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        Iterator<j> r102 = this.f225978a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100, r101);
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        a(r100, r101.rendererPriorityAtExit());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Iterator<j> r102 = this.f225978a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        WebResourceResponse r103 = r102.next().d(r101);
        if (r103 == null) goto L4;
        return r103;
    L9:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        Iterator<j> r102 = this.f225978a.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r102.next().f(r101) == false) goto L4;
        r103 = true;
        goto L4
    L8:
        return r103;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        Iterator<j> r102 = this.f225978a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        WebResourceResponse r103 = r102.next().e(r101);
        if (r103 == null) goto L4;
        return r103;
    L9:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        Iterator<j> r103 = this.f225978a.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        j r104 = r103.next();
        int r105 = r102.getErrorCode();
        String r106 = "";
        if (r102.getDescription() == null) goto L8;
        String r107 = r102.getDescription().toString();
    L10:
        if (r101.getUrl() == null) goto L12;
        r106 = r101.getUrl().toString();
    L12:
        r104.b(r105, r107, r106);
        goto L4
    L8:
        r107 = "";
        goto L10
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        tt5.a.h("DriveWebViewClientDelegate", "above android M, call another func");
        return;
    L6:
        Iterator<j> r104 = this.f225978a.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().b(r101, r102, r103);
        goto L8
    }
}
