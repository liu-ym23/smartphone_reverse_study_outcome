package com.unionpay;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f462158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewJavascriptBridge f462159b;

    public c(WebViewJavascriptBridge r100, String r101) {
        this.f462159b = r100;
        this.f462158a = r101;
    }

    @Override // com.unionpay.g
    public final void a(String r100) {
        WebViewJavascriptBridge.access$300(this.f462159b, this.f462158a, r100);
    }
}
