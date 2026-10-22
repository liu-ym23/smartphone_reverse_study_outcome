package uwb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.p;
import com.ss.android.lark.officewebview.monitor.base.PerformanceTimingHandler;
import com.ss.android.lark.officewebview.util.f;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import dxb.k;
import dxb.n;
import dxb.o;
import dxb.q;
import dxb.r;
import dxb.t;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import oxb.d;
import oxb.i;
import oxb.l;
import oxb.m;

/* JADX INFO: loaded from: classes37.dex */
public class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwb.c f551957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebViewClient f551958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bxb.a f551959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nxb.a f551960d;

    public c(wwb.c r100) {
        this.f551957a = r100;
        this.f551960d = new nxb.a(r100);
        this.f551959c = new bxb.a(r100.getWebView());
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        j.e("LarkBaseWebViewClient", "onLoadResource, load:" + p.c(r101));
        super.onLoadResource(r100, r101);
        int r102 = g.f437223a;
        if (g.a.a("openplatform.lark.webview.load.resource.monitor") == false) goto L5;
        bxb.a r103 = this.f551959c;
        r103.getClass();
        int r104 = t.f470510a;
        boolean r105 = r103.f21383e;
        cxb.a r106 = r103.f21379a;
        Intrinsics.checkNotNullParameter(r106, "dependency");
        Lazy<Handler> r107 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new k(r106, r105, r101));
    L5:
        WebViewClient r108 = this.f551958b;
        if (r108 == null) goto L9;
        r108.onLoadResource(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        j.e("LarkBaseWebViewClient", "onPageCommitVisible");
        super.onPageCommitVisible(r100, r101);
        WebViewClient r102 = this.f551958b;
        if (r102 == null) goto L6;
        r102.onPageCommitVisible(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r110, String r111) {
        j.e("LarkBaseWebViewClient", "onPageFinished url " + p.c(r111) + " with session:" + vwb.b.b(r111));
        bxb.a r112 = this.f551959c;
        if (r112.f21380b == false) goto L5;
        int r100 = t.f470510a;
        boolean r101 = r112.f21383e;
        cxb.a r102 = r112.f21379a;
        int r113 = r112.f21381c;
        Intrinsics.checkNotNullParameter(r102, "dependency");
        dxb.g r114 = new dxb.g("wb_load_url_end", dxb.c.f470459d, r102);
        r114.a("is_first_page", Boolean.valueOf(r101));
        r114.a("result_code", 1);
        r114.a("error_code", Integer.valueOf(r113));
        r102.getReasonParams();
        r114.f470451a.b();
        t.c(r114, r111);
        r114.b();
        int r103 = 1;
    L6:
        long r104 = System.currentTimeMillis() - r112.f21379a.getStartTime();
        boolean r105 = r112.f21383e;
        if (r105 == false) goto L9;
        cxb.a r106 = r112.f21379a;
        String r115 = String.valueOf(r104);
        Intrinsics.checkNotNullParameter(r106, "dependency");
        Lazy<Handler> r107 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new dxb.j(r106, r105, r103, r115, r111));
    L9:
        PerformanceTimingHandler.reportPerformanceTiming(r110, r112.f21383e, r111, r112.f21379a);
        r112.f21380b = false;
        r112.f21381c = -1;
        r112.f21383e = false;
        int r108 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "url");
        zwb.a r109 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r109 == null) goto L12;
        r109.onPageFinished();
    L12:
        j.e("LarkBaseWebViewClient", "onPageFinished");
        super.onPageFinished(r110, r111);
        d r116 = (d) this.f551957a.getServiceManager().a(d.class);
        if (r116 == null) goto L15;
        r116.onPageFinished();
    L15:
        WebViewClient r117 = this.f551958b;
        if (r117 == null) goto L19;
        r117.onPageFinished(r110, r111);
        return;
    L19:
        return;
    L5:
        int r118 = t.f470510a;
        boolean r119 = r112.f21383e;
        cxb.a r120 = r112.f21379a;
        Intrinsics.checkNotNullParameter(r120, "dependency");
        dxb.g r121 = new dxb.g("wb_load_url_end", dxb.c.f470457b, r120);
        r121.a("is_first_page", Boolean.valueOf(r119));
        r121.a("result_code", 0);
        r120.getReasonParams();
        r121.f470451a.b();
        t.c(r121, r111);
        r121.b();
        r103 = 0;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
    L8:
        e = move-exception;
        j.c("LarkBaseWebViewClient", "onReceivedClientCertRequest error", e);
        return;
    L4:
        if (this.f551958b == null) goto L6;
        j.e("LarkBaseWebViewClient", "onReceivedClientCertRequest mClient handle");     // Catch: Exception -> L8
        this.f551958b.onReceivedClientCertRequest(r100, r101);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        j.e("LarkBaseWebViewClient", "onReceivedClientCertRequest default handle");     // Catch: Exception -> L8
        super.onReceivedClientCertRequest(r100, r101);     // Catch: Exception -> L8
        goto L11
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        bxb.a r102 = this.f551959c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "detail");
        int r103 = t.f470510a;
        t.d(r102.f21379a);
        bxb.a.f21378f = true;
        int r104 = g.f437223a;
        boolean r105 = !g.a.a("openplatform.lark.webview.force_on_render_process_gone_return_true");
        l r106 = (l) this.f551957a.getServiceManager().a(l.class);
        if (r106 != null) goto L5;
        WebViewClient r107 = this.f551958b;
        if (r107 == null) goto L20;
        boolean r108 = r107.onRenderProcessGone(r100, r101);
        j.e("LarkBaseWebViewClient", "onRenderProcessGone mClient handle result " + r108);
        if (r105 == false) goto L19;
        j.e("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: " + r108);
        return true;
    L19:
        return r108;
    L20:
        j.e("LarkBaseWebViewClient", "onRenderProcessGone default return true");
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        new f(r101.didCrash(), r101.rendererPriorityAtExit());
    L7:
        j.e("LarkBaseWebViewClient", "onRenderProcessGone service handle");
        r106.D();
        if (r105 == false) goto L11;
        j.e("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: false");
        return true;
    L11:
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onUnhandledKeyEvent mClient handle");
        this.f551958b.onUnhandledKeyEvent(r100, r101);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onUnhandledKeyEvent default handle");
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        oxb.k r102 = (oxb.k) this.f551957a.getServiceManager().a(oxb.k.class);
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.e();
    L6:
        if (r103 != null) goto L10;
        WebViewClient r104 = this.f551958b;
        if (r104 == null) goto L10;
        r103 = r104.shouldInterceptRequest(r100, r101);
    L10:
        int r105 = g.f437223a;
        if (g.a.a("openplatform.web.webview.net.intercept.infra") == false) goto L16;
        m r106 = (m) this.f551957a.getServiceManager().a(m.class);
        if (r106 == null) goto L16;
        if (r103 != null) goto L16;
        r103 = r106.e();
    L16:
        if (r103 == null) goto L18;
        return r103;
    L18:
        return super.shouldInterceptRequest(r100, r101);
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        boolean r102 = super.shouldOverrideKeyEvent(r100, r101);
        WebViewClient r103 = this.f551958b;
        if (r103 == null) goto L5;
        r102 = r102 | r103.shouldOverrideKeyEvent(r100, r101);
    L5:
        j.e("LarkBaseWebViewClient", "shouldOverrideKeyEvent , override = " + r102);
        return r102;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        bxb.a r102 = this.f551959c;
        Uri r103 = r101.getUrl();
        r102.getClass();
        int r104 = t.f470510a;
        boolean r105 = r102.f21383e;
        cxb.a r106 = r102.f21379a;
        Intrinsics.checkNotNullParameter(r106, "dependency");
        Lazy<Handler> r107 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new n(r106, r105, r103));
        List<String> r108 = p.f437230a;
        Uri r109 = r101.getUrl();
        if (r109 != null) goto L5;
        String r110 = "";
    L6:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading url " + r110 + " with session:" + vwb.b.b(r101.getUrl().toString()));
        i r111 = (i) this.f551957a.getServiceManager().a(i.class);
        if (r111 != null) goto L9;
    L12:
        if (r111 == null) goto L14;
        r111.A(r101);
    L14:
        oxb.k r112 = (oxb.k) this.f551957a.getServiceManager().a(oxb.k.class);
        if (r112 == null) goto L17;
        boolean r113 = r112.n();
        j.e("LarkBaseWebViewClient", "IWebViewInterceptService intercept = " + r113);
    L18:
        WebViewClient r114 = this.f551958b;
        if (r114 == null) goto L22;
        r113 = r113 | r114.shouldOverrideUrlLoading(r100, r101);
        j.e("LarkBaseWebViewClient", "after mClient override url intercept = " + r113);
    L22:
        if (r113 == false) goto L25;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.f551959c.a(r101.getUrl(), "intercept_url_loading_old_api");
        return true;
    L25:
        int r115 = g.f437223a;
        if (g.a.a("openplatform.lark.webview.override_modify") == false) goto L41;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading new logic");
        String r116 = r101.getUrl().toString();
        oxb.a r117 = (oxb.a) this.f551957a.getServiceManager().a(oxb.a.class);
        if (r117 == null) goto L33;
        this.f551957a.getWebViewContext();
        if (r117.v() == false) goto L33;
        this.f551957a.getWebViewContext();
        r117.t();
        j.e("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.f551959c.b(r116, "open_applink");
        return true;
    L33:
        nxb.a r118 = this.f551960d;
        if (r118 == null) goto L36;
        r118.a((com.ss.android.lark.officewebview.base.g) r100, r116);
    L36:
        int r119 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r116, "url");
        zwb.a r120 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r120 == null) goto L39;
        r120.x();
    L39:
        this.f551959c.b(r116, "override_end");
        return false;
    L41:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        return super.shouldOverrideUrlLoading(r100, r101);
    L17:
        r113 = false;
        goto L18
    L9:
        if (r111.shouldOverrideUrlLoading(r100, r101) == false) goto L12;
        this.f551959c.a(r101.getUrl(), "error_page_ui_opt");
        return false;
    L5:
        r110 = p.c(r109.toString());
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        oxb.k r102 = (oxb.k) this.f551957a.getServiceManager().a(oxb.k.class);
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.o();
    L6:
        if (r103 != null) goto L10;
        WebViewClient r104 = this.f551958b;
        if (r104 == null) goto L10;
        r103 = r104.shouldInterceptRequest(r100, r101);
    L10:
        if (r103 != null) goto L14;
        i r105 = (i) this.f551957a.getServiceManager().a(i.class);
        if (r105 == null) goto L14;
        r103 = r105.k(r100, r101);
    L14:
        if (r103 == null) goto L16;
        return r103;
    L16:
        return super.shouldInterceptRequest(r100, r101);
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        bxb.a r102 = this.f551959c;
        r102.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        Uri r103 = UriProtector.parse(r101);
    L8:
        int r104 = t.f470510a;
        boolean r105 = r102.f21383e;
        cxb.a r106 = r102.f21379a;
        Intrinsics.checkNotNullParameter(r106, "dependency");
        Lazy<Handler> r107 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new n(r106, r105, r103));
        goto L9
    L7:
        r103 = null;
    L9:
        i r108 = (i) this.f551957a.getServiceManager().a(i.class);
        boolean r109 = false;
        if (r108 != null) goto L12;
    L15:
        if (r108 == null) goto L17;
        r108.z(r101);
    L17:
        oxb.k r110 = (oxb.k) this.f551957a.getServiceManager().a(oxb.k.class);
        if (r110 == null) goto L20;
        r109 = r110.i();
        j.e("LarkBaseWebViewClient", "interceptService intercept override result = " + r109);
    L20:
        WebViewClient r111 = this.f551958b;
        if (r111 == null) goto L24;
        r109 = r109 | r111.shouldOverrideUrlLoading(r100, r101);
        j.e("LarkBaseWebViewClient", "after mClient override , intercept = " + r109);
    L24:
        if (r109 == false) goto L27;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.f551959c.b(r101, "intercept_url_loading_new_api");
        return true;
    L27:
        oxb.a r112 = (oxb.a) this.f551957a.getServiceManager().a(oxb.a.class);
        if (r112 == null) goto L33;
        this.f551957a.getWebViewContext();
        if (r112.v() == false) goto L33;
        this.f551957a.getWebViewContext();
        r112.t();
        j.e("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.f551959c.b(r101, "open_applink");
        return true;
    L33:
        nxb.a r113 = this.f551960d;
        if (r113 == null) goto L36;
        r113.a((com.ss.android.lark.officewebview.base.g) r100, r101);
    L36:
        boolean r114 = super.shouldOverrideUrlLoading(r100, r101);
        if (r114 == true) goto L41;
        int r115 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        zwb.a r116 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r116 == null) goto L41;
        r116.x();
    L41:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        this.f551959c.b(r101, "override_end");
        return r114;
    L12:
        if (r108.shouldOverrideUrlLoading(r100, r101) == false) goto L15;
        this.f551959c.b(r101, "error_page_ui_opt");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "doUpdateVisitedHistory mClient handle , isReload = " + r102);
        this.f551958b.doUpdateVisitedHistory(r100, r101, r102);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "doUpdateVisitedHistory default handle, isReload = " + r102);
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r100, Message r101, Message r102) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onFormResubmission mClient handle");
        this.f551958b.onFormResubmission(r100, r101, r102);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onFormResubmission default handle");
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        j.e("LarkBaseWebViewClient", "onPageStarted url " + p.c(r101) + " with session:" + vwb.b.b(r101));
        bxb.a r103 = this.f551959c;
        if (TextUtils.isEmpty(r103.f21382d) == true) goto L5;
        int r104 = t.f470510a;
        cxb.a r105 = r103.f21379a;
        String r106 = r103.f21382d;
        Lazy<Handler> r107 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new q(r105, r106));
    L5:
        int r108 = t.f470510a;
        cxb.a r109 = r103.f21379a;
        Lazy<Handler> r110 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new r(r109, r101));
        boolean r111 = r103.f21383e;
        cxb.a r112 = r103.f21379a;
        Intrinsics.checkNotNullParameter(r112, "dependency");
        ThreadUtil.a.b(new dxb.l(r112, r111, r101));
        r103.f21382d = r101;
        int r113 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        zwb.a r114 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r114 == null) goto L8;
        r114.onPageStarted();
    L8:
        com.ss.android.lark.officewebview.util.m r115 = this.f551957a.getWebView().getWebTimeHelper();
        long r116 = System.currentTimeMillis();
        r115.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L11;
    L13:
        j.e("LarkBaseWebViewClient", "onPageStarted");
        oxb.g r117 = (oxb.g) this.f551957a.getServiceManager().a(oxb.g.class);
        if (r117 == null) goto L16;
        r117.F(r101, this.f551957a.getWebView());
    L16:
        nxb.a r118 = this.f551960d;
        if (r118 != null) goto L19;
    L23:
        super.onPageStarted(r100, r101, r102);
        d r119 = (d) this.f551957a.getServiceManager().a(d.class);
        if (r119 == null) goto L26;
        r119.onPageStarted();
    L26:
        WebViewClient r120 = this.f551958b;
        if (r120 == null) goto L30;
        r120.onPageStarted(r100, r101, r102);
        return;
    L30:
        return;
    L19:
        if (TextUtils.isEmpty(null) == true) goto L23;
        if (r101.startsWith("https://null") == true) goto L23;
        r118.f521098a.clear();
        r118.f521099b.add(r101);
        goto L23
    L11:
        if (r115.f437553a.containsKey(r101) == true) goto L13;
        r115.f437553a.put(r101, Long.valueOf(r116));
        goto L13
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r110, WebResourceRequest r111, WebResourceError r112) {
        bxb.a r100 = this.f551959c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, "error");
        if (r111 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        int r102 = r112.getErrorCode();
        r100.f21380b = true;
        r100.f21381c = r102;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L24;
        int r103 = t.f470510a;
        boolean r104 = r100.f21383e;
        if (r111 == null) goto L15;
        Uri r105 = r111.getUrl();
    L16:
        cxb.a r106 = r100.f21379a;
        int r107 = r112.getErrorCode();
        CharSequence r108 = r112.getDescription();
        if (r108 == null) goto L19;
        String r109 = r108.toString();
    L20:
        if (r111 == null) goto L22;
        Boolean r113 = Boolean.valueOf(r111.isForMainFrame());
    L23:
        Lazy<Handler> r114 = ThreadUtil.f437211a;
        ThreadUtil.a.a(new o(r106, r107, r109, r104, r113, r105));
        goto L24
    L22:
        r113 = null;
        goto L23
    L19:
        r109 = null;
        goto L20
    L15:
        r105 = null;
    L24:
        int r115 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r112, "error");
        zwb.a r116 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r116 == null) goto L27;
        r116.L();
    L27:
        oxb.c r117 = (oxb.c) this.f551957a.getServiceManager().a(oxb.c.class);
        if (r117 == null) goto L30;
        r117.l();
    L30:
        WebViewClient r118 = this.f551958b;
        if (r118 == null) goto L33;
        r118.onReceivedError(r110, r111, r112);
        return;
    L33:
        super.onReceivedError(r110, r111, r112);
        return;
    L5:
        if (r111.isForMainFrame() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r110, WebResourceRequest r111, WebResourceResponse r112) {
        int r100 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r112, "errorResponse");
        zwb.a r101 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r101 == null) goto L5;
        r101.U();
    L5:
        bxb.a r102 = this.f551959c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r112, "errorResponse");
        int r103 = t.f470510a;
        boolean r104 = r102.f21383e;
        Boolean r105 = null;
        if (r111 == null) goto L8;
        Uri r106 = r111.getUrl();
    L9:
        cxb.a r107 = r102.f21379a;
        Integer r108 = Integer.valueOf(r112.getStatusCode());
        String r109 = r112.getReasonPhrase();
        String r113 = r112.getMimeType();
        if (r111 == null) goto L12;
        r105 = Boolean.valueOf(r111.isForMainFrame());
    L12:
        Intrinsics.checkNotNullParameter(r107, "dependency");
        dxb.g r114 = new dxb.g("wb_load_res_failed", dxb.c.f470458c, r107);
        r114.a("error_code", r108);
        r114.a("error_msg", r109);
        r114.a("is_first_page", Boolean.valueOf(r104));
        r114.a("mime_type", r113);
        r114.a("is_main_frame", r105);
        r114.a("error_type", "http");
        t.b(r114, r106);
        r114.b();
        oxb.c r115 = (oxb.c) this.f551957a.getServiceManager().a(oxb.c.class);
        if (r115 == null) goto L15;
        r115.s();
    L15:
        WebViewClient r116 = this.f551958b;
        if (r116 == null) goto L18;
        r116.onReceivedHttpError(r110, r111, r112);
        return;
    L18:
        super.onReceivedHttpError(r110, r111, r112);
        return;
    L8:
        r106 = null;
        goto L9
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r100, SslErrorHandler r110, SslError r111) {
        oxb.c r101 = (oxb.c) this.f551957a.getServiceManager().a(oxb.c.class);
        if (r101 == null) goto L6;
        r101.y();
    L6:
        if ((this.f551958b instanceof a) == false) goto L9;
        j.e("LarkBaseWebViewClient", "mClient instanceof AbsLarkWebViewClient");
        ((a) this.f551958b).a();
        return;
    L9:
        bxb.a r102 = this.f551959c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r111, "error");
        int r103 = r111.getPrimaryError();
        r102.f21380b = true;
        r102.f21381c = r103;
        int r104 = t.f470510a;
        boolean r105 = r102.f21383e;
        String r106 = r111.getUrl();
        cxb.a r107 = r102.f21379a;
        int r108 = r111.getPrimaryError();
        Boolean r109 = Boolean.TRUE;
        dxb.g r112 = new dxb.g("wb_load_received_error", dxb.c.f470460e, r107);
        r112.a("error_code", Integer.valueOf(r108));
        r112.a("error_msg", null);
        r112.a("error_type", TTVideoEngineInterface.PLAY_API_KEY_SSL);
        r112.a("is_first_page", Boolean.valueOf(r105));
        r112.a("is_main_frame", r109);
        t.c(r112, r106);
        r112.b();
        WebViewClient r113 = this.f551958b;
        if (r113 == null) goto L13;
        r113.onReceivedSslError(r100, r110, r111);
        return;
    L13:
        super.onReceivedSslError(r100, r110, r111);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r100, float r101, float r102) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onScaleChanged mClient handle");
        this.f551958b.onScaleChanged(r100, r101, r102);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onScaleChanged default handle");
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onTooManyRedirects mClient handle");
        this.f551958b.onTooManyRedirects(r100, r101, r102);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onTooManyRedirects default handle");
        super.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        int r104 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r103, "failingUrl");
        zwb.a r105 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r105 == null) goto L5;
        r105.G();
    L5:
        oxb.c r106 = (oxb.c) this.f551957a.getServiceManager().a(oxb.c.class);
        if (r106 == null) goto L8;
        r106.onReceivedError();
    L8:
        WebViewClient r107 = this.f551958b;
        if (r107 == null) goto L11;
        r107.onReceivedError(r100, r101, r102, r103);
        return;
    L11:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onReceivedHttpAuthRequest mClient handle");
        this.f551958b.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onReceivedHttpAuthRequest default handle");
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        if (this.f551958b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onReceivedLoginRequest mClient handle");
        this.f551958b.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onReceivedLoginRequest default handle");
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        j.e("LarkBaseWebViewClient", "onSafeBrowsingHit");
        super.onSafeBrowsingHit(r100, r101, r102, r103);
        if (this.f551958b == null) goto L6;
        j.e("LarkBaseWebViewClient", "onSafeBrowsingHit mClient handle");
        this.f551958b.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    }
}
