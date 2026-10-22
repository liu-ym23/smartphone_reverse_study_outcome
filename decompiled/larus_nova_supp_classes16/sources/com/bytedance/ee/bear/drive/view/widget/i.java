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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends WebViewClient {
    public final ArrayList<j> a;

    public i() {
        this.a = new ArrayList();
    }

    public final void a(WebView r3, int r4) {
        tt5.a.h("DriveWebViewClientDelegate", "onRenderProcessGone rendererPriority is " + r4);
        Iterator<j> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c(r3, r4);
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r3, String r4) {
        super.onPageFinished(r3, r4);
        Iterator<j> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4);
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r1, RenderProcessGoneDetail r2) {
        a(r1, r2.rendererPriorityAtExit());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r3, WebResourceRequest r4) {
        Iterator<j> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        WebResourceResponse r1 = r0.next().d(r4);
        if (r1 == null) goto L4;
        return r1;
    L9:
        return super.shouldInterceptRequest(r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r3, String r4) {
        Iterator<j> r5 = this.a.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r5.next().f(r4) == false) goto L4;
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r3, String r4) {
        Iterator<j> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        WebResourceResponse r1 = r0.next().e(r4);
        if (r1 == null) goto L4;
        return r1;
    L9:
        return super.shouldInterceptRequest(r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r6, WebResourceRequest r7, WebResourceError r8) {
        super.onReceivedError(r6, r7, r8);
        Iterator<j> r9 = this.a.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        j r0 = r9.next();
        int r1 = r8.getErrorCode();
        String r3 = "";
        if (r8.getDescription() == null) goto L8;
        String r2 = r8.getDescription().toString();
    L10:
        if (r7.getUrl() == null) goto L12;
        r3 = r7.getUrl().toString();
    L12:
        r0.b(r1, r2, r3);
        goto L4
    L8:
        r2 = "";
        goto L10
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r2, int r3, String r4, String r5) {
        super.onReceivedError(r2, r3, r4, r5);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        tt5.a.h("DriveWebViewClientDelegate", "above android M, call another func");
        return;
    L6:
        Iterator<j> r6 = this.a.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().b(r3, r4, r5);
        goto L8
    }
}
