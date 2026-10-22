package com.bytedance.ee.bear.document;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes16.dex */
public final class u4 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f222439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f222440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f222441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t4 f222442d;

    public interface a {
        Context getContext();

        ViewGroup getVideoContainer();

        WebView getWebView();
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        WebChromeClient.CustomViewCallback r100 = this.f222439a;
        if (r100 == null) goto L5;
        r100.onCustomViewHidden();
    L5:
        ViewGroup r101 = this.f222440b.getVideoContainer();
        if (r101 == null) goto L10;
        View r102 = this.f222441c;
        if (r102 == null) goto L10;
        r101.removeView(r102);
    L10:
        this.f222441c = null;
        Object r103 = com.ss.android.lark.appcontext.applifecycle.q.f408854c;
        com.ss.android.lark.appcontext.applifecycle.q.a.f408857a.b(this.f222442d);
        super.onHideCustomView();
        if (this.f222440b.getWebView() == null) goto L14;
        this.f222440b.getWebView().clearFocus();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.document.t4] */
    public u4(FullVideoPlugin.a r100) {
        this.f222442d = new t4(this);
        this.f222440b = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        this.f222441c = r100;
        this.f222439a = r101;
        Object r102 = com.ss.android.lark.appcontext.applifecycle.q.f408854c;
        com.ss.android.lark.appcontext.applifecycle.q.a.f408857a.a(this.f222442d);
        ViewGroup r103 = this.f222440b.getVideoContainer();
        if (r103 != null) goto L5;
    L8:
        super.onShowCustomView(r100, r101);
        return;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.sheet.is_use_docx_in_sheet") == false) goto L7;
        r103.addView(this.f222441c, -1, -1);
        goto L8
    L7:
        r103.addView(this.f222441c);
        goto L8
    }
}
