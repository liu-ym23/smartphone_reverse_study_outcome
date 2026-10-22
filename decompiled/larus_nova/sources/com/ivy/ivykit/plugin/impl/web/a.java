package com.ivy.ivykit.plugin.impl.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import b36.m;
import b36.n;
import com.bytedance.ies.bullet.service.base.YieldError;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends c26.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c26.c f278483b;

    /* JADX INFO: renamed from: com.ivy.ivykit.plugin.impl.web.a$a, reason: collision with other inner class name */
    public static final class C3881a {
    }

    static {
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        c26.c r100 = this.f278483b;
        if (r100 != null) goto L9;
    L6:
        super.getDefaultVideoPoster();
        throw null;
    L9:
        return r100.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        c26.c r100 = this.f278483b;
        if (r100 == null) goto L6;
        r100.onHideCustomView();
        return;
    }

    public a(PluginWebView.c r100) {
        this.f278483b = r100;
    }

    @Override // b36.j
    public final void a(m r100) {
        c26.c r101 = this.f278483b;
        if (r101 != null) goto L9;
    L6:
        super.a(r100);
        throw null;
    L9:
        r101.a(r100);     // Catch: YieldError -> L8
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        c26.c r102 = this.f278483b;
        if (r102 != null) goto L9;
    L6:
        super.onProgressChanged(r100, r101);
        return;
    L9:
        r102.onProgressChanged(r100, r101);     // Catch: YieldError -> L8
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        c26.c r102 = this.f278483b;
        if (r102 == null) goto L6;
        r102.onReceivedTitle(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        c26.c r102 = this.f278483b;
        if (r102 != null) goto L9;
    L6:
        super.onShowCustomView(r100, r101);
        return;
    L9:
        r102.onShowCustomView(r100, r101);     // Catch: YieldError -> L8
    }

    @Override // b36.j
    public final boolean b(WebView r100, ValueCallback r101, n r102) {
        c26.c r103 = this.f278483b;
        if (r103 != null) goto L9;
    L6:
        super.b(r100, r101, r102);
        throw null;
    L9:
        return r103.b(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        c26.c r103 = this.f278483b;
        if (r103 == null) goto L9;
        r103.onConsoleMessage(r100, r101, r102);     // Catch: YieldError -> L6
        return;
    L10:
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        c26.c r103 = this.f278483b;
        if (r103 != null) goto L9;
    L6:
        super.onShowCustomView(r100, r101, r102);
        return;
    L9:
        r103.onShowCustomView(r100, r101, r102);     // Catch: YieldError -> L8
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        c26.c r103 = this.f278483b;
        if (r103 == null) goto L7;
        return r103.onShowFileChooser(r100, r101, r102);
    L7:
        return super.onShowFileChooser(r100, r101, r102);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        c26.c r104 = this.f278483b;
        if (r104 != null) goto L9;
    L6:
        super.onJsBeforeUnload(r100, r101, r102, r103);
        throw null;
    L9:
        return r104.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        c26.c r104 = this.f278483b;
        if (r104 != null) goto L9;
    L6:
        super.onJsConfirm(r100, r101, r102, r103);
        throw null;
    L9:
        return r104.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r101, String r102, String r110, JsPromptResult r111) {
        c26.c r103 = this.f278483b;
        if (r103 != null) goto L10;
    L7:
        super.onJsPrompt(r100, r101, r102, r110, r111);
        throw null;
    L10:
        return r103.onJsPrompt(r100, r101, r102, r110, r111);
    }
}
