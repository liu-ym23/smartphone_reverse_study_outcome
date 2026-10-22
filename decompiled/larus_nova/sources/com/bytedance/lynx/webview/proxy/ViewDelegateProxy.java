package com.bytedance.lynx.webview.proxy;

import android.webkit.WebView;
import android.webkit.WebViewProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes21.dex */
public class ViewDelegateProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProvider.ViewDelegate f265427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f265428b;

    public WebViewProvider.ViewDelegate getViewDelegate() {
        InvocationHandler r100 = new AnonymousClass1(this);
        return (WebViewProvider.ViewDelegate) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{WebViewProvider.ViewDelegate.class}, r100);
    }

    public ViewDelegateProxy(WebViewProvider.ViewDelegate r100, WebView r101) {
        this.f265427a = null;
        this.f265427a = r100;
        this.f265428b = r101;
    }
}
