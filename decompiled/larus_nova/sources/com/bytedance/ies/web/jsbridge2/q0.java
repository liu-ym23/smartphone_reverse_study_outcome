package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes19.dex */
public final class q0 extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f249422n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WebView f249423o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249424p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f249425q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x f249426r;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.web.jsbridge2.b
    public final String h() {
        WebView r100 = this.f249423o;
        if ((r100 instanceof x) == false) goto L8;
        String r101 = ((x) r100).getSafeUrl();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        return r101;
    L7:
        return this.f249423o.getUrl();
    L8:
        x r102 = this.f249426r;
        if (r102 == null) goto L14;
        String r103 = r102.getSafeUrl();
        if (TextUtils.isEmpty(r103) == true) goto L13;
        return r103;
    L13:
        return this.f249423o.getUrl();
    L14:
        boolean r104 = this.f249424p;
        boolean r105 = this.f249425q;
        if (r104 == false) goto L22;
        if (r105 == false) goto L22;
        if (r100 == 0) goto L22;
        if ((r100 instanceof x) == true) goto L22;
        r100.post(new n(r100));
    L22:
        return this.f249423o.getUrl();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void p() {
        super.p();
        this.f249423o.removeJavascriptInterface(this.f249422n);
    }

    static {
    }

    public q0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public Context getContext(o r100) {
        Context r101 = r100.f249401f;
        if (r101 == null) goto L5;
        return r101;
    L5:
        WebView r102 = r100.f249396a;
        if (r102 == null) goto L10;
        return r102.getContext();
    L10:
        throw new IllegalStateException("WebView cannot be null!");
    }

    @JavascriptInterface
    public void invokeMethod(String r100) {
        if (this.f249302f == true) goto L7;
        TimeLineEvent.b r101 = new TimeLineEvent.b();
        r101.c();
        r101.f249287a = "label_pre_call_origin_url";
        TimeLineEvent r102 = new TimeLineEvent(r101, null);
        this.f249300d.post(new c(this, r100, r102));
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void j(o r100) {
        this.f249424p = r100.f249402g;
        this.f249425q = r100.f249412q;
        WebView r101 = r100.f249396a;
        this.f249423o = r101;
        String r102 = r100.f249399d;
        this.f249422n = r102;
        if (r100.f249409n == true) goto L5;
        r101.addJavascriptInterface(this, r102);
    L5:
        this.f249426r = r100.f249416u;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void k(String r100) {
        r("javascript:" + this.f249422n + "._handleMessageFromToutiao(" + r100 + ")");
    }

    public final void r(String r100) {
        if (this.f249302f == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        p0 r101 = new p0(this, r100);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L11;
        this.f249300d.post(r101);
        return;
    L11:
        r101.run();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void m(String r100, c0 r101) {
        if (r101 != null) goto L4;
    L6:
        k(r100);
        return;
    L4:
        if (TextUtils.isEmpty(r101.f249323h) == true) goto L6;
        String r102 = r101.f249323h;
        String r103 = Base64.encodeToString(r102.getBytes(), 2);
        r(String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", new Object[]{Base64.encodeToString(String.format("iframe[src=\"%s\"", new Object[]{r102}).getBytes(), 2), r100, r103}));
    }
}
