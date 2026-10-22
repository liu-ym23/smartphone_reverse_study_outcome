package com.unionpay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f462160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewJavascriptBridge f462161b;

    public c0(WebViewJavascriptBridge r100, String r101) {
        this.f462161b = r100;
        this.f462160a = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f462161b.mWebView.loadUrl(this.f462160a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
