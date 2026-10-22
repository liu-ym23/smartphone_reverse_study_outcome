package com.bytedance.ee.bear.document;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u4 extends WebChromeClient {
    public WebChromeClient.CustomViewCallback a;
    public final a b;
    public View c;
    public final t4 d;

    public interface a {
        Context getContext();

        ViewGroup getVideoContainer();

        WebView getWebView();
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        WebChromeClient.CustomViewCallback r0 = this.a;
        if (r0 == null) goto L5;
        r0.onCustomViewHidden();
    L5:
        ViewGroup r1 = this.b.getVideoContainer();
        if (r1 == null) goto L10;
        View r2 = this.c;
        if (r2 == null) goto L10;
        r1.removeView(r2);
    L10:
        this.c = null;
        Object r3 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.b(this.d);
        super.onHideCustomView();
        if (this.b.getWebView() == null) goto L14;
        this.b.getWebView().clearFocus();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.document.t4] */
    public u4(FullVideoPlugin.a r2) {
        this.d = new t4(this);
        this.b = r2;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r4, WebChromeClient.CustomViewCallback r5) {
        this.c = r4;
        this.a = r5;
        Object r0 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.a(this.d);
        ViewGroup r1 = this.b.getVideoContainer();
        if (r1 != null) goto L5;
    L8:
        super.onShowCustomView(r4, r5);
        return;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.is_use_docx_in_sheet") == false) goto L7;
        r1.addView(this.c, -1, -1);
        goto L8
    L7:
        r1.addView(this.c);
        goto L8
    }
}
