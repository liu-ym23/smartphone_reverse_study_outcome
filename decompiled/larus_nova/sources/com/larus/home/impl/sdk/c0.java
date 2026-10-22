package com.larus.home.impl.sdk;

import android.net.http.SslError;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c0 implements ix7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<String, Map<String, String>, Map<String, String>> f346147a;

    @Override // ix7.e
    public final void b(SslError r100) {
    }

    @Override // ix7.e
    public final boolean d(com.ivy.ivykit.plugin.impl.web.b r100) {
        return false;
    }

    @Override // ix7.e
    public final void e(View r100) {
    }

    @Override // ix7.e
    public final void f() {
    }

    @Override // ix7.e
    public final boolean g(WebView r100, ValueCallback r101) {
        return false;
    }

    @Override // ix7.e
    public final void h(String r100, int r101, String r102) {
    }

    @Override // ix7.e
    public final void i(WebView r100, int r101) {
    }

    @Override // ix7.e
    public final void onReceivedTitle(WebView r100, String r101) {
    }

    @Override // ix7.e
    public final boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        return false;
    }

    public c0(com.larus.bmhome.chat.layout.widget.handler.h r100) {
        this.f346147a = r100;
    }

    @Override // ix7.e
    public final lx7.b c(lx7.b r100) {
        Intrinsics.checkNotNullParameter(r100, "before");
        String r101 = r100.f511231a;
        return new lx7.b(r101, this.f346147a.invoke(r101, r100.f511232b));
    }

    @Override // ix7.e
    public final void onPageStarted(String r100) {
        FLogger r101 = FLogger.f375446a;
        b0 r102 = b0.f346140a;
        r101.d("IvykitServiceImpl", "[biz_deep_search] onPageStarted " + r100);
    }

    @Override // ix7.e
    public final boolean j(WebView r100, com.ivy.ivykit.plugin.impl.web.c r101) {
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        String r103 = "crashed";
    L11:
        FLogger r104 = FLogger.f375446a;
        b0 r105 = b0.f346140a;
        StringBuilder r106 = new StringBuilder("Render process ");
        r106.append(r103);
        r106.append(". WebView URL: ");
        if (r100 == null) goto L14;
        String r107 = r100.getUrl();
    L15:
        r106.append(r107);
        r104.e("IvykitServiceImpl", r106.toString());
        return true;
    L14:
        r107 = null;
        goto L15
    L10:
        r103 = "killed by system";
        goto L11
    L5:
        if (r101.a() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // ix7.e
    public final void k(WebResourceRequest r100, WebResourceError r101) {
        FLogger r102 = FLogger.f375446a;
        b0 r103 = b0.f346140a;
        r102.d("IvykitServiceImpl", "[biz_deep_search] onReceivedError " + r101);
    }

    @Override // ix7.e
    public final void onPageFinished(WebView r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        b0 r103 = b0.f346140a;
        r102.d("IvykitServiceImpl", "[biz_deep_search] onPageFinished " + r101);
    }

    @Override // ix7.e
    public final void a(int r100, String r101, String r102) {
        FLogger r103 = FLogger.f375446a;
        b0 r104 = b0.f346140a;
        r103.d("IvykitServiceImpl", "[biz_deep_search] onReceivedError " + r100);
    }
}
