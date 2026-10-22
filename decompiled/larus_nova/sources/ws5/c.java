package ws5;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
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
import com.bytedance.ee.larkwebview.monitor.base.PerformanceTimingHandler;
import com.bytedance.ee.larkwebview.util.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.utils.p0;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import gt5.e;
import gt5.g;
import gt5.j;
import gt5.k;
import gt5.o;
import gt5.p;
import gt5.q;
import gt5.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import st5.h;
import st5.l;
import st5.m;
import st5.n;

/* JADX INFO: loaded from: classes19.dex */
public class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ys5.c f561053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebViewClient f561054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final et5.a f561055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rt5.a f561056d;

    public c(ys5.c r100) {
        this.f561053a = r100;
        this.f561056d = new rt5.a(r100);
        this.f561055c = new et5.a(r100.getWebView());
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        Log.i("LarkBaseWebViewClient", "onLoadResource, load:" + p0.d(r101));
        super.onLoadResource(r100, r101);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.lark.webview.load.resource.monitor") == false) goto L5;
        et5.a r102 = this.f561055c;
        r102.getClass();
        int r103 = p.f482566a;
        boolean r104 = r102.f473929e;
        ft5.a r105 = r102.f473925a;
        Intrinsics.checkNotNullParameter(r105, "dependency");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new k(r105, r104, r101));
    L5:
        WebViewClient r106 = this.f561054b;
        if (r106 == null) goto L9;
        r106.onLoadResource(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        Log.i("LarkBaseWebViewClient", "onPageCommitVisible");
        super.onPageCommitVisible(r100, r101);
        WebViewClient r102 = this.f561054b;
        if (r102 == null) goto L6;
        r102.onPageCommitVisible(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r110, String r111) {
        Log.i("LarkBaseWebViewClient", "onPageFinished url " + p0.d(r111) + " with session:" + xs5.b.b(r111));
        et5.a r112 = this.f561055c;
        if (r112.f473926b == false) goto L5;
        int r100 = p.f482566a;
        boolean r101 = r112.f473929e;
        ft5.a r102 = r112.f473925a;
        int r113 = r112.f473927c;
        Intrinsics.checkNotNullParameter(r102, "dependency");
        OPMonitor r103 = new g("wb_load_url_end", e.f482521e, r102).addCategoryValue("is_first_page", Boolean.valueOf(r101)).addCategoryValue("result_code", 1).addCategoryValue("error_code", Integer.valueOf(r113)).addMap(r102.getReasonParams());
        Intrinsics.checkNotNull(r103);
        p.c(r103, r111);
        r103.flush();
        int r104 = 1;
    L6:
        long r105 = System.currentTimeMillis() - r112.f473925a.getStartTime();
        boolean r106 = r112.f473929e;
        if (r106 == false) goto L9;
        ft5.a r107 = r112.f473925a;
        String r114 = String.valueOf(r105);
        Intrinsics.checkNotNullParameter(r107, "dependency");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new j(r107, r106, r104, r114, r111));
    L9:
        PerformanceTimingHandler.reportPerformanceTiming(r110, r112.f473929e, r111, r112.f473925a);
        r112.f473926b = false;
        r112.f473927c = -1;
        r112.f473929e = false;
        zs5.c r108 = zs5.a.f573485a;
        Log.i("LarkBaseWebViewClient", "onPageFinished");
        super.onPageFinished(r110, r111);
        st5.e r109 = (st5.e) this.f561053a.getServiceManager().a(st5.e.class);
        if (r109 == null) goto L12;
        r109.onPageFinished();
    L12:
        WebViewClient r115 = this.f561054b;
        if (r115 == null) goto L16;
        r115.onPageFinished(r110, r111);
        return;
    L16:
        return;
    L5:
        int r116 = p.f482566a;
        boolean r117 = r112.f473929e;
        ft5.a r118 = r112.f473925a;
        Intrinsics.checkNotNullParameter(r118, "dependency");
        OPMonitor r119 = new g("wb_load_url_end", e.f482518b, r118).addCategoryValue("is_first_page", Boolean.valueOf(r117)).addCategoryValue("result_code", 0).addMap(r118.getReasonParams());
        Intrinsics.checkNotNull(r119);
        p.c(r119, r111);
        r119.flush();
        r104 = 0;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
    L8:
        e = move-exception;
        Log.e("LarkBaseWebViewClient", "onReceivedClientCertRequest error", e);
        return;
    L4:
        if (this.f561054b == null) goto L6;
        Log.i("LarkBaseWebViewClient", "onReceivedClientCertRequest mClient handle");     // Catch: Exception -> L8
        this.f561054b.onReceivedClientCertRequest(r100, r101);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        Log.i("LarkBaseWebViewClient", "onReceivedClientCertRequest default handle");     // Catch: Exception -> L8
        super.onReceivedClientCertRequest(r100, r101);     // Catch: Exception -> L8
        goto L11
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        et5.a r102 = this.f561055c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "detail");
        int r103 = p.f482566a;
        ft5.a r104 = r102.f473925a;
        Intrinsics.checkNotNullParameter(r104, "dependency");
        new g("wb_render_process_gone", e.f482534r, r104).flush();
        et5.a.f473924f = true;
        boolean r105 = !FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.lark.webview.force_on_render_process_gone_return_true");
        m r106 = (m) this.f561053a.getServiceManager().a(m.class);
        if (r106 != null) goto L5;
        WebViewClient r107 = this.f561054b;
        if (r107 == null) goto L20;
        boolean r108 = r107.onRenderProcessGone(r100, r101);
        Log.i("LarkBaseWebViewClient", "onRenderProcessGone mClient handle result " + r108);
        if (r105 == false) goto L19;
        Log.i("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: " + r108);
        return true;
    L19:
        return r108;
    L20:
        Log.i("LarkBaseWebViewClient", "onRenderProcessGone default return true");
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        new d(r101.didCrash(), r101.rendererPriorityAtExit());
    L7:
        Log.i("LarkBaseWebViewClient", "onRenderProcessGone service handle");
        r106.D();
        if (r105 == false) goto L11;
        Log.i("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: false");
        return true;
    L11:
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onUnhandledKeyEvent mClient handle");
        this.f561054b.onUnhandledKeyEvent(r100, r101);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onUnhandledKeyEvent default handle");
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        l r102 = (l) this.f561053a.getServiceManager().a(l.class);
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.o(r100, r101);
    L6:
        if (r103 != null) goto L11;
        WebViewClient r104 = this.f561054b;
        if (r104 == null) goto L11;
        r103 = r104.shouldInterceptRequest(r100, r101);
    L11:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("openplatform.web.webview.net.intercept.infra") == false) goto L16;
        n r105 = (n) this.f561053a.getServiceManager().a(n.class);
        if (r105 == null) goto L16;
        if (r103 != null) goto L16;
        r103 = r105.o(r100, r101);
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
        WebViewClient r103 = this.f561054b;
        if (r103 == null) goto L5;
        r102 = r102 | r103.shouldOverrideKeyEvent(r100, r101);
    L5:
        Log.i("LarkBaseWebViewClient", "shouldOverrideKeyEvent , override = " + r102);
        return r102;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        et5.a r102 = this.f561055c;
        Uri r103 = r101.getUrl();
        r102.getClass();
        int r104 = p.f482566a;
        boolean r105 = r102.f473929e;
        ft5.a r106 = r102.f473925a;
        Intrinsics.checkNotNullParameter(r106, "dependency");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new gt5.n(r106, r105, r103));
        List<String> r107 = p0.f444745a;
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading url " + p0.c(r101.getUrl()) + " with session:" + xs5.b.b(r101.getUrl().toString()));
        st5.j r108 = (st5.j) this.f561053a.getServiceManager().a(st5.j.class);
        if (r108 != null) goto L5;
    L8:
        if (r108 == null) goto L10;
        r108.A(r101);
    L10:
        l r109 = (l) this.f561053a.getServiceManager().a(l.class);
        if (r109 == null) goto L13;
        boolean r110 = r109.n();
        Log.i("LarkBaseWebViewClient", "IWebViewInterceptService intercept = " + r110);
    L14:
        WebViewClient r111 = this.f561054b;
        if (r111 == null) goto L18;
        r110 = r110 | r111.shouldOverrideUrlLoading(r100, r101);
        Log.i("LarkBaseWebViewClient", "after mClient override url intercept = " + r110);
    L18:
        if (r110 == false) goto L22;
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.f561055c.a(r101.getUrl(), "intercept_url_loading_old_api");
        return true;
    L22:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.lark.webview.override_modify") == false) goto L34;
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading new logic");
        String r112 = r101.getUrl().toString();
        st5.a r113 = (st5.a) this.f561053a.getServiceManager().a(st5.a.class);
        if (r113 == null) goto L29;
        this.f561053a.getWebViewContext();
        if (r113.v() == false) goto L29;
        this.f561053a.getWebViewContext();
        r113.t();
        Log.i("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.f561055c.b(r112, "open_applink");
        return true;
    L29:
        rt5.a r114 = this.f561056d;
        if (r114 == null) goto L32;
        r114.a((com.bytedance.ee.larkwebview.base.g) r100, r112);
    L32:
        zs5.c r115 = zs5.a.f573485a;
        this.f561055c.b(r112, "override_end");
        return false;
    L34:
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        return super.shouldOverrideUrlLoading(r100, r101);
    L13:
        r110 = false;
        goto L14
    L5:
        if (r108.shouldOverrideUrlLoading(r100, r101) == false) goto L8;
        this.f561055c.a(r101.getUrl(), "error_page_ui_opt");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        l r102 = (l) this.f561053a.getServiceManager().a(l.class);
        if (r102 == null) goto L5;
        WebResourceResponse r103 = r102.e();
    L6:
        if (r103 != null) goto L10;
        WebViewClient r104 = this.f561054b;
        if (r104 == null) goto L10;
        r103 = r104.shouldInterceptRequest(r100, r101);
    L10:
        if (r103 != null) goto L14;
        st5.j r105 = (st5.j) this.f561053a.getServiceManager().a(st5.j.class);
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
        et5.a r102 = this.f561055c;
        r102.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        Uri r103 = UriProtector.parse(r101);
    L8:
        int r104 = p.f482566a;
        boolean r105 = r102.f473929e;
        ft5.a r106 = r102.f473925a;
        Intrinsics.checkNotNullParameter(r106, "dependency");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new gt5.n(r106, r105, r103));
        goto L9
    L7:
        r103 = null;
    L9:
        st5.j r107 = (st5.j) this.f561053a.getServiceManager().a(st5.j.class);
        boolean r108 = false;
        if (r107 != null) goto L12;
    L15:
        if (r107 == null) goto L17;
        r107.z(r101);
    L17:
        l r109 = (l) this.f561053a.getServiceManager().a(l.class);
        if (r109 == null) goto L20;
        r108 = r109.i();
        Log.i("LarkBaseWebViewClient", "interceptService intercept override result = " + r108);
    L20:
        WebViewClient r110 = this.f561054b;
        if (r110 == null) goto L24;
        r108 = r108 | r110.shouldOverrideUrlLoading(r100, r101);
        Log.i("LarkBaseWebViewClient", "after mClient override , intercept = " + r108);
    L24:
        if (r108 == false) goto L27;
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.f561055c.b(r101, "intercept_url_loading_new_api");
        return true;
    L27:
        st5.a r111 = (st5.a) this.f561053a.getServiceManager().a(st5.a.class);
        if (r111 == null) goto L33;
        this.f561053a.getWebViewContext();
        if (r111.v() == false) goto L33;
        this.f561053a.getWebViewContext();
        r111.t();
        Log.i("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.f561055c.b(r101, "open_applink");
        return true;
    L33:
        rt5.a r112 = this.f561056d;
        if (r112 == null) goto L36;
        r112.a((com.bytedance.ee.larkwebview.base.g) r100, r101);
    L36:
        boolean r113 = super.shouldOverrideUrlLoading(r100, r101);
        if (r113 == true) goto L39;
        zs5.c r114 = zs5.a.f573485a;
    L39:
        Log.i("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        this.f561055c.b(r101, "override_end");
        return r113;
    L12:
        if (r107.shouldOverrideUrlLoading(r100, r101) == false) goto L15;
        this.f561055c.b(r101, "error_page_ui_opt");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "doUpdateVisitedHistory mClient handle , isReload = " + r102);
        this.f561054b.doUpdateVisitedHistory(r100, r101, r102);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "doUpdateVisitedHistory default handle, isReload = " + r102);
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r100, Message r101, Message r102) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onFormResubmission mClient handle");
        this.f561054b.onFormResubmission(r100, r101, r102);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onFormResubmission default handle");
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        Log.i("LarkBaseWebViewClient", "onPageStarted url " + p0.d(r101) + " with session:" + xs5.b.b(r101));
        et5.a r103 = this.f561055c;
        if (TextUtils.isEmpty(r103.f473928d) == true) goto L5;
        int r104 = p.f482566a;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new q(r103.f473925a, r103.f473928d));
    L5:
        int r105 = p.f482566a;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new r(r103.f473925a, r101));
        boolean r106 = r103.f473929e;
        ft5.a r107 = r103.f473925a;
        Intrinsics.checkNotNullParameter(r107, "dependency");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new gt5.l(r107, r106, r101));
        r103.f473928d = r101;
        zs5.c r108 = zs5.a.f573485a;
        com.bytedance.ee.larkwebview.util.l r109 = this.f561053a.getWebView().getWebTimeHelper();
        long r110 = System.currentTimeMillis();
        r109.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L8;
    L10:
        Log.i("LarkBaseWebViewClient", "onPageStarted");
        h r111 = (h) this.f561053a.getServiceManager().a(h.class);
        if (r111 == null) goto L13;
        r111.K(r101, this.f561053a.getWebView());
    L13:
        rt5.a r112 = this.f561056d;
        if (r112 != null) goto L16;
    L20:
        super.onPageStarted(r100, r101, r102);
        st5.e r113 = (st5.e) this.f561053a.getServiceManager().a(st5.e.class);
        if (r113 == null) goto L23;
        r113.onPageStarted();
    L23:
        WebViewClient r114 = this.f561054b;
        if (r114 == null) goto L27;
        r114.onPageStarted(r100, r101, r102);
        return;
    L27:
        return;
    L16:
        if (TextUtils.isEmpty(null) == true) goto L20;
        if (r101.startsWith("https://null") == true) goto L20;
        r112.f539197a.clear();
        r112.f539198b.add(r101);
        goto L20
    L8:
        if (r109.f242979a.containsKey(r101) == true) goto L10;
        r109.f242979a.put(r101, Long.valueOf(r110));
        goto L10
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r110, WebResourceRequest r111, WebResourceError r112) {
        et5.a r100 = this.f561055c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, "error");
        if (r111 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        int r102 = r112.getErrorCode();
        r100.f473926b = true;
        r100.f473927c = r102;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L24;
        int r103 = p.f482566a;
        boolean r104 = r100.f473929e;
        if (r111 == null) goto L15;
        Uri r105 = r111.getUrl();
    L16:
        ft5.a r106 = r100.f473925a;
        int r107 = r112.getErrorCode();
        CharSequence r108 = r112.getDescription();
        if (r108 == null) goto L19;
        String r109 = r108.toString();
    L20:
        if (r111 == null) goto L22;
        Boolean r113 = Boolean.valueOf(r111.isForMainFrame());
    L23:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new o(r106, r107, r109, r104, r113, r105));
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
        zs5.c r114 = zs5.a.f573485a;
        st5.d r115 = (st5.d) this.f561053a.getServiceManager().a(st5.d.class);
        if (r115 == null) goto L27;
        r115.l();
    L27:
        WebViewClient r116 = this.f561054b;
        if (r116 == null) goto L30;
        r116.onReceivedError(r110, r111, r112);
        return;
    L30:
        super.onReceivedError(r110, r111, r112);
        return;
    L5:
        if (r111.isForMainFrame() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r110, WebResourceRequest r111, WebResourceResponse r112) {
        zs5.c r100 = zs5.a.f573485a;
        et5.a r101 = this.f561055c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r112, "errorResponse");
        int r102 = p.f482566a;
        boolean r103 = r101.f473929e;
        Boolean r104 = null;
        if (r111 == null) goto L5;
        Uri r105 = r111.getUrl();
    L6:
        ft5.a r106 = r101.f473925a;
        Integer r107 = Integer.valueOf(r112.getStatusCode());
        String r108 = r112.getReasonPhrase();
        String r109 = r112.getMimeType();
        if (r111 == null) goto L9;
        r104 = Boolean.valueOf(r111.isForMainFrame());
    L9:
        Intrinsics.checkNotNullParameter(r106, "dependency");
        OPMonitor r113 = new g("wb_load_res_failed", e.f482519c, r106).addCategoryValue("error_code", r107).addCategoryValue("error_msg", r108).addCategoryValue("is_first_page", Boolean.valueOf(r103)).addCategoryValue("mime_type", r109).addCategoryValue("is_main_frame", r104).addCategoryValue("error_type", "http");
        Intrinsics.checkNotNull(r113);
        p.b(r113, r105);
        r113.flush();
        st5.d r114 = (st5.d) this.f561053a.getServiceManager().a(st5.d.class);
        if (r114 == null) goto L12;
        r114.s();
    L12:
        WebViewClient r115 = this.f561054b;
        if (r115 == null) goto L15;
        r115.onReceivedHttpError(r110, r111, r112);
        return;
    L15:
        super.onReceivedHttpError(r110, r111, r112);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r100, SslErrorHandler r110, SslError r111) {
        st5.d r101 = (st5.d) this.f561053a.getServiceManager().a(st5.d.class);
        if (r101 == null) goto L6;
        r101.y();
    L6:
        if ((this.f561054b instanceof a) == false) goto L9;
        Log.i("LarkBaseWebViewClient", "mClient instanceof AbsLarkWebViewClient");
        ((a) this.f561054b).a();
        return;
    L9:
        et5.a r102 = this.f561055c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r111, "error");
        int r103 = r111.getPrimaryError();
        r102.f473926b = true;
        r102.f473927c = r103;
        int r104 = p.f482566a;
        boolean r105 = r102.f473929e;
        String r106 = r111.getUrl();
        ft5.a r107 = r102.f473925a;
        int r108 = r111.getPrimaryError();
        Boolean r109 = Boolean.TRUE;
        OPMonitor r112 = new g("wb_load_received_error", e.f482525i, r107).addCategoryValue("error_code", Integer.valueOf(r108)).addCategoryValue("error_msg", null).addCategoryValue("error_type", TTVideoEngineInterface.PLAY_API_KEY_SSL).addCategoryValue("is_first_page", Boolean.valueOf(r105)).addCategoryValue("is_main_frame", r109);
        Intrinsics.checkNotNull(r112);
        p.c(r112, r106);
        r112.flush();
        WebViewClient r113 = this.f561054b;
        if (r113 == null) goto L13;
        r113.onReceivedSslError(r100, r110, r111);
        return;
    L13:
        super.onReceivedSslError(r100, r110, r111);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r100, float r101, float r102) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onScaleChanged mClient handle");
        this.f561054b.onScaleChanged(r100, r101, r102);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onScaleChanged default handle");
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onTooManyRedirects mClient handle");
        this.f561054b.onTooManyRedirects(r100, r101, r102);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onTooManyRedirects default handle");
        super.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        zs5.c r104 = zs5.a.f573485a;
        st5.d r105 = (st5.d) this.f561053a.getServiceManager().a(st5.d.class);
        if (r105 == null) goto L5;
        r105.onReceivedError();
    L5:
        WebViewClient r106 = this.f561054b;
        if (r106 == null) goto L8;
        r106.onReceivedError(r100, r101, r102, r103);
        return;
    L8:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onReceivedHttpAuthRequest mClient handle");
        this.f561054b.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onReceivedHttpAuthRequest default handle");
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        if (this.f561054b == null) goto L5;
        Log.i("LarkBaseWebViewClient", "onReceivedLoginRequest mClient handle");
        this.f561054b.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    L5:
        Log.i("LarkBaseWebViewClient", "onReceivedLoginRequest default handle");
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        Log.i("LarkBaseWebViewClient", "onSafeBrowsingHit");
        super.onSafeBrowsingHit(r100, r101, r102, r103);
        if (this.f561054b == null) goto L6;
        Log.i("LarkBaseWebViewClient", "onSafeBrowsingHit mClient handle");
        this.f561054b.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    }
}
