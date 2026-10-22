package com.ivy.ivykit.plugin.impl.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b36.k;
import b36.l;
import b36.m;
import b36.n;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ivy.ivykit.plugin.impl.jsb.BulletViewMethodFinder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t36.j;

/* JADX INFO: loaded from: classes23.dex */
public final class PluginWebView extends kx7.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f278460n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f278461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BulletContainerView f278462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ix7.e f278463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ix7.d f278464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ix7.f f278465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ix7.h f278466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ix7.g f278467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebView f278468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BulletViewMethodFinder f278469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m16.b f278470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PluginWebView$urlInterceptor$1 f278471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f278472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f278473m;

    public static final class a {
    }

    public static final class b extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278474a;

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.q
        public final void lX() {
            Map<Class<?>, ox7.a> r100 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onBulletViewRelease", null);
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.q
        public final void onClose() {
            Map<Class<?>, ox7.a> r100 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onClose", null);
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.q
        public final void onOpen() {
            Map<Class<?>, ox7.a> r100 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onOpen", null);
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.q
        public final void rS() {
            Map<Class<?>, ox7.a> r100 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onBulletViewCreate", null);
        }

        public b(PluginWebView r100) {
            this.f278474a = r100;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void Ox(Uri r100, h16.e r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            ix7.d r102 = this.f278474a.f278464d;
            if (r102 == null) goto L6;
            r102.onLoadStart();
            return;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void TH(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
            Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onFallback", null);
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void gQ(Uri r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onKitViewCreate", null);
            WebView r103 = this.f278474a.l(r101);
            if (r103 == null) goto L8;
            ix7.d r104 = this.f278474a.f278464d;
            if (r104 == null) goto L9;
            r104.d(r103);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void go(Uri r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            WebView r102 = this.f278474a.l(r101);
            if (r102 == null) goto L8;
            ix7.d r103 = this.f278474a.f278464d;
            if (r103 == null) goto L9;
            r103.onLoadSuccess(r102);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
            Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onLoadFail: " + r101.getMessage(), null);
            ix7.d r103 = this.f278474a.f278464d;
            if (r103 == null) goto L6;
            r103.e(r101);
            return;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void LG(Uri r100, o r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Map<Class<?>, ox7.a> r103 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onKitViewDestroy", null);
            if (r101 != null) goto L5;
            return;
        L5:
            if (this.f278474a.l(r101) == null) goto L11;
            ix7.d r104 = this.f278474a.f278464d;
            if (r104 == null) goto L12;
            r104.f();
            return;
        L12:
            return;
        }

        @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
        public final void bK(Uri r100, o r101, j r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
            Map<Class<?>, ox7.a> r103 = ox7.b.f527091a;
            ox7.b.b(PluginWebView.f278460n, "onLoadModelSuccess", null);
        }
    }

    public static final class c extends c26.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ivy.ivykit.plugin.impl.web.f f278476c;

        @Override // b36.j, android.webkit.WebChromeClient
        public final Bitmap getDefaultVideoPoster() {
            return this.f278476c.f278488g;
        }

        @Override // android.webkit.WebChromeClient
        public final void onHideCustomView() {
            super.onHideCustomView();
            ix7.e r100 = this.f278475b.f278463c;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        @Override // b36.j
        public final void a(m r100) {
            ix7.e r101 = this.f278475b.f278463c;
            if (r101 == null) goto L8;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            com.ivy.ivykit.plugin.impl.web.b r102 = new com.ivy.ivykit.plugin.impl.web.b(r100);
        L7:
            boolean r103 = r101.d(r102);
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            super.a(r100);
            throw null;
        L6:
            r102 = null;
            goto L7
        L8:
            r103 = false;
            goto L9
        }

        public c(PluginWebView r100, com.ivy.ivykit.plugin.impl.web.f r101) {
            this.f278475b = r100;
            this.f278476c = r101;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            ix7.e r102 = this.f278475b.f278463c;
            if (r102 == null) goto L6;
            r102.i(r100, r101);
            return;
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r100, String r101) {
            super.onReceivedTitle(r100, r101);
            ix7.e r102 = this.f278475b.f278463c;
            if (r102 == null) goto L6;
            r102.onReceivedTitle(r100, r101);
            return;
        }

        @Override // android.webkit.WebChromeClient
        public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
            super.onShowCustomView(r100, r101);
            ix7.e r102 = this.f278475b.f278463c;
            if (r102 == null) goto L6;
            r102.e(r100);
            return;
        }

        @Override // b36.j
        public final boolean b(WebView r100, ValueCallback r101, n r102) {
            ix7.e r103 = this.f278475b.f278463c;
            if (r103 == null) goto L6;
            new com.ivy.ivykit.plugin.impl.web.d(r102);
            return r103.g(r100, r101);
        L6:
            super.b(r100, r101, r102);
            throw null;
        }

        @Override // android.webkit.WebChromeClient
        public final void onConsoleMessage(String r100, int r101, String r102) {
            super.onConsoleMessage(r100, r101, r102);
            ix7.e r103 = this.f278475b.f278463c;
            if (r103 == null) goto L6;
            r103.h(r100, r101, r102);
            return;
        }

        @Override // b36.j, android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
            ix7.e r103 = this.f278475b.f278463c;
            if (r103 == null) goto L6;
            return r103.g(r100, r101);
        L6:
            return super.onShowFileChooser(r100, r101, r102);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
            return super.onCreateWindow(r100, r101, r102, r103);
        }
    }

    public static final class d implements SSWebView.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278477a;

        public d(PluginWebView r100) {
            this.f278477a = r100;
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.f
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            ix7.f r101 = this.f278477a.f278465e;
            if (r101 == null) goto L5;
            r101.onTouchEvent(r100);
        L5:
            Intrinsics.checkNotNullParameter(r100, "event");
            throw new YieldError("An operation is not implemented");
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.f
        public final boolean a(int r100, boolean r101) {
            ix7.f r102 = this.f278477a.f278465e;
            if (r102 == null) goto L9;
            Boolean r103 = r102.a(r100, r101);
            if (r103 == null) goto L9;
            return r103.booleanValue();
        L9:
            throw new YieldError("An operation is not implemented");
        }
    }

    public static final class e implements SSWebView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278478a;

        public e(PluginWebView r100) {
            this.f278478a = r100;
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.g
        public final void a(int r100, int r101, boolean r102, boolean r103) {
            ix7.h r104 = this.f278478a.f278466f;
            if (r104 == null) goto L6;
            r104.a(r100, r101, r102, r103);
            return;
        }
    }

    public static final class f implements SSWebView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278479a;

        public f(PluginWebView r100) {
            this.f278479a = r100;
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.e
        public final void onScrollChanged(int r100, int r101, int r102, int r103) {
            ix7.h r104 = this.f278479a.f278466f;
            if (r104 == null) goto L6;
            r104.onScrollChanged(r100, r101, r102, r103);
            return;
        }
    }

    public static final class g implements SSWebView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278480a;

        public g(PluginWebView r100) {
            this.f278480a = r100;
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.d
        public final void b(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, boolean r211) {
            ix7.h r100 = this.f278480a.f278466f;
            if (r100 == null) goto L6;
            r100.b(r110, r111, r112, r113, r114, r115, r116, r210, r211);
            return;
        }
    }

    public static final class h extends c26.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f278481b;

        public h(PluginWebView r100) {
            this.f278481b = r100;
        }

        @Override // b36.q
        public final boolean a(WebView r100, l r101) {
            Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
            String r103 = PluginWebView.f278460n;
            StringBuilder r104 = new StringBuilder("onRenderProcessGone url: ");
            if (r100 == null) goto L5;
            String r105 = r100.getUrl();
        L6:
            r104.append(r105);
            ox7.b.b(r103, r104.toString(), null);
            ix7.e r106 = this.f278481b.f278463c;
            if (r106 == null) goto L14;
            if (r101 == null) goto L10;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            com.ivy.ivykit.plugin.impl.web.c r107 = new com.ivy.ivykit.plugin.impl.web.c(r101);
        L12:
            if (r106.j(r100, r107) != true) goto L14;
            boolean r108 = true;
        L15:
            if (r108 == false) goto L17;
            return true;
        L17:
            super.a(r100, r101);
            throw null;
        L10:
            r107 = null;
        L14:
            r108 = false;
            goto L15
        L5:
            r105 = null;
            goto L6
        }

        @Override // b36.q
        public final WebResourceResponse b(WebView r100, k r101) {
            super.b(r100, r101);
            throw null;
        }

        @Override // b36.q
        public final boolean c(WebView r100, k r101) {
            super.c(r100, r101);
            throw null;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            ix7.e r102 = this.f278481b.f278463c;
            if (r102 == null) goto L6;
            r102.onPageFinished(r100, r101);
            return;
        }

        @Override // b36.q, android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
            Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
            ox7.b.b("AIPackageWebView", "PluginWebView shouldInterceptRequest: " + r101, null);
            super.shouldInterceptRequest(r100, r101);
            throw null;
        }

        @Override // b36.q, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            ix7.e r102 = this.f278481b.f278463c;
            boolean r103 = false;
            if (r102 != null) goto L5;
        L7:
            if (r103 == false) goto L10;
            return true;
        L10:
            return super.shouldOverrideUrlLoading(r100, r101);
        L5:
            if (r102.shouldOverrideUrlLoading(r100, r101) != true) goto L7;
            r103 = true;
            goto L7
        }

        @Override // b36.q, android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
            return super.shouldOverrideUrlLoading(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            super.onPageStarted(r100, r101, r102);
            ix7.e r103 = this.f278481b.f278463c;
            if (r103 == null) goto L6;
            r103.onPageStarted(r101);
            return;
        }

        @Override // b36.q, android.webkit.WebViewClient
        public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
            super.onReceivedError(r100, r101, r102);
            ix7.e r103 = this.f278481b.f278463c;
            if (r103 == null) goto L6;
            r103.k(r101, r102);
            return;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
            super.onReceivedSslError(r100, r101, r102);
            ix7.e r103 = this.f278481b.f278463c;
            if (r103 == null) goto L6;
            r103.b(r102);
            return;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
            super.onReceivedError(r100, r101, r102, r103);
            ix7.e r104 = this.f278481b.f278463c;
            if (r104 == null) goto L6;
            r104.a(r101, r102, r103);
            return;
        }
    }

    static {
        f278460n = PluginWebView.class.getName();
    }

    @Override // kx7.c
    public final boolean a() {
        SccConfig.SccLevel r100 = SccConfig.SccLevel.SAFE;
        o r101 = this.f278462b.getKitView();
        if (r101 == null) goto L5;
        SccConfig.SccLevel r102 = r101.i();
    L7:
        if (r100 == r102) goto L9;
        return false;
    L9:
        WebView r103 = this.f278468h;
        if (r103 != null) goto L12;
        return false;
    L12:
        return r103.canGoBack();
    L5:
        r102 = null;
        goto L7
    }

    @Override // kx7.c
    public final String b() {
        String r100 = this.f278462b.getSessionId();
        if (StringsKt.isBlank(r100) == false) goto L6;
        return null;
    L6:
        return r100;
    }

    @Override // kx7.c
    public final void c() {
        o r100 = this.f278462b.getKitView();
        if (r100 == null) goto L6;
        r100.onBackPressed();
        return;
    }

    @Override // kx7.c
    public final void g() {
        o r100 = this.f278462b.getKitView();
        if (r100 == null) goto L6;
        r100.m();
        return;
    }

    @Override // kx7.c
    public final String i() {
        WebView r100 = this.f278468h;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUrl();
    }

    @Override // kx7.c
    public final WebView j() {
        o r100 = this.f278462b.getKitView();
        if (r100 != null) goto L7;
        return null;
    L7:
        return l(r100);
    }

    public final void k() {
        this.f278462b.release();
    }

    @Override // kx7.c
    public final BulletContainerView f() {
        return this.f278462b;
    }

    public final Context getContext() {
        return this.f278461a;
    }

    @Override // kx7.c
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        e(r100, true);
    }

    public final WebView l(o r100) {
        SSWebView r101 = null;
        if (r100 == null) goto L12;
        View r102 = r100.realView();
        if (r102 == null) goto L12;
        if ((r102 instanceof WebView) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        WebView r103 = (WebView) r102;
    L14:
        if (this.f278468h != null) goto L20;
        this.f278468h = r103;
        if ((r103 instanceof SSWebView) == false) goto L18;
        r101 = (SSWebView) r103;
    L18:
        if (r101 == null) goto L20;
        r101.setWebViewEventDelegate(new d(this));
        r101.setWebViewScrollDelegate(new e(this));
        r101.setWebScrollListener(new f(this));
        r101.setWebOverScrollByListener(new g(this));
    L20:
        return r103;
    L12:
        r103 = null;
        goto L14
    }

    @Override // kx7.c
    public final void e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        m16.b r102 = new m16.b();
        r102.b(this.f278470j);
        ix7.g r103 = this.f278467g;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r102.d(ix7.g.class, r103);
    L5:
        BulletContainerView r104 = this.f278462b;
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L15;
        String r105 = URLEncoder.encode(r100);
        String r106 = "";
        if ((!Intrinsics.areEqual(IIvyAIPackageResourceService.f278317a.getBid(), this.f278462b.getBid())) == false) goto L10;
        String r107 = "&need_sec_link=1&sec_link_scene=im";
    L11:
        if (r101 == false) goto L14;
        r106 = "&loader_name=forest";
    L14:
        Uri r108 = UriProtector.parse("aweme://webview/?url=" + r105 + "&use_xbridge3=true" + r106 + r107);
    L16:
        r104.h(r108, null, r102, new b(this));
        return;
    L10:
        r107 = "";
        goto L11
    L15:
        r108 = UriProtector.parse(r100);
        goto L16
    }

    @Override // kx7.c
    public final void h(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        o r102 = this.f278462b.getKitView();
        if (r102 == null) goto L6;
        r102.sendEvent(r100, r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.ivy.ivykit.plugin.impl.web.PluginWebView$urlInterceptor$1] */
    public PluginWebView(String r100, com.ivy.ivykit.plugin.impl.web.f r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "webViewClient");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f278461a = r102;
        AttributeSet r103 = null;
        BulletContainerView r104 = new BulletContainerView(r102, r103, 6, 0);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r104.d(r101.f278487f);
        this.f278462b = r104;
        this.f278469i = new BulletViewMethodFinder();
        m16.b r105 = new m16.b();
        r105.d(PluginWebView.class, this);
        this.f278470j = r105;
        this.f278471k = new PluginWebView$urlInterceptor$1(this);
        this.f278472l = new c(this, r101);
        this.f278473m = new h(this);
        this.f278463c = r101.f511226a;
        this.f278464d = r101.f511227b;
        this.f278465e = r101.f511228c;
        this.f278466f = r101.f511229d;
        this.f278467g = r101.f511230e;
    }
}
