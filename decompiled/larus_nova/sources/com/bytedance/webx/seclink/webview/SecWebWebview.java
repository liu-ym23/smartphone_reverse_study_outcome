package com.bytedance.webx.seclink.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import dr7.c;
import jr7.a;

/* JADX INFO: loaded from: classes22.dex */
public class SecWebWebview extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f272651a;

    @Override // android.webkit.WebView
    public final void goBack() {
        if (this.f272651a.b() == false) goto L5;
        return;
    L5:
        super.goBack();
    }

    @Override // android.webkit.WebView
    public final boolean canGoBack() {
        if (super.canGoBack() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f272651a.canGoBack() == false) goto L7;
        return true;
    }

    public SecWebWebview(Context r100) {
        super(r100);
        setWebViewClient(new a(this));
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100) {
        super.loadUrl(r100);
    }

    public void setSecLinkStategy(c r100) {
        this.f272651a = r100;
    }

    public SecWebWebview(Context r100, AttributeSet r101) {
        super(r100, r101);
        setWebViewClient(new a(this));
    }

    public SecWebWebview(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setWebViewClient(new a(this));
    }
}
