package com.bytedance.ies.bullet.service.webkit;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.kit.web.q;
import com.bytedance.ies.bullet.service.base.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {
    public boolean a() {
        return true;
    }

    public abstract SSWebView b(String r100);

    public void c(SSWebView r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
    }

    public String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return r100;
    }

    public boolean g() {
        return false;
    }

    public abstract BulletContext getContext();

    public WebResourceResponse h(WebResourceRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return null;
    }

    public WebResourceResponse i(WebResourceRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return null;
    }

    public WebResourceResponse j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return null;
    }

    public void k() {
    }

    public void m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
    }

    public void n() {
    }

    public void o() {
    }

    public void p(SSWebView r100, WebKitView r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "kitView");
    }

    public abstract j q(String r100, String r101);

    public com.bytedance.ies.bullet.service.base.j r() {
        return null;
    }

    public abstract q s();

    public void t(o r100) {
        Intrinsics.checkNotNullParameter(r100, "kitViewService");
    }

    public void u(Uri r100, SSWebView r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "view");
    }

    public void v(SSWebView r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "globalProps");
    }

    public a(s26.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
    }
}
