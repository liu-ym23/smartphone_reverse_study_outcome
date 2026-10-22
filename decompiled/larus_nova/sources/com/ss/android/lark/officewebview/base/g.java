package com.ss.android.lark.officewebview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import com.ss.android.lark.officesdk.utils.RomUtils;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.k;
import com.ss.android.lark.officesdk.utils.di.v;
import com.ss.android.lark.officewebview.util.i;
import com.ss.android.lark.officewebview.util.l;
import com.ss.android.lark.officewebview.util.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dxb.t;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import ntb.z;
import oxb.n;

/* JADX INFO: loaded from: classes37.dex */
public abstract class g extends WebView implements wwb.c, cxb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile n f437458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ywb.c f437459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uwb.c f437460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public uwb.b f437461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f437462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f437463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f437464g;

    public abstract /* synthetic */ String getBaseTraceId();

    public abstract /* synthetic */ String getBizType();

    public abstract /* synthetic */ Map<String, Object> getCommonParams();

    public abstract /* synthetic */ Map<String, Object> getReasonParams();

    public abstract /* synthetic */ n getServiceManager();

    public abstract /* synthetic */ long getStartTime();

    public abstract /* synthetic */ OfficeWebView getWebView();

    public abstract void k();

    @Override // android.webkit.WebView
    public final boolean canGoBack() {
        oxb.b r100 = (oxb.b) this.f437458a.a(oxb.b.class);
        if (r100 == null) goto L11;
        copyBackForwardList();
        boolean r101 = r100.canGoBack();
        boolean r102 = super.canGoBack();
        j.e("BaseOfficeWebView", "canGoBack proxy handle , canGoBack = " + r101 + " , super canGoBack = " + r102);
        if (r101 == false) goto L8;
        if (r102 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoBack();
    }

    @Override // android.webkit.WebView
    public final boolean canGoForward() {
        oxb.b r100 = (oxb.b) this.f437458a.a(oxb.b.class);
        if (r100 == null) goto L11;
        copyBackForwardList();
        boolean r101 = r100.j();
        boolean r102 = super.canGoForward();
        j.e("BaseOfficeWebView", "canGoForward proxy handle, canGoForward = " + r101 + ", base canGoForward " + r102);
        if (r101 == false) goto L8;
        if (r102 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoForward();
    }

    public String getTTWebViewVersion() {
        Lazy<otb.n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        return "";
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        uwb.c r100 = this.f437460c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f551958b;
    }

    @Override // wwb.c
    public Context getWebViewContext() {
        return getContext();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
        l r100 = this.f437463f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f437552a != null) goto L8;
        return;
    L8:
        if (getParent() != null) goto L11;
        return;
    L11:
        if ((getParent() instanceof FrameLayout) == false) goto L14;
        r100.a(false, (FrameLayout) getParent());
        return;
    L14:
        if ((getParent().getParent() instanceof ConstraintLayout) == false) goto L17;
        r100.b(false, (ConstraintLayout) getParent().getParent());
        return;
    L17:
        if ((getParent().getParent() instanceof FrameLayout) == false) goto L23;
        r100.a(false, (FrameLayout) getParent().getParent());
        return;
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        l r100 = this.f437463f;
        if (r100 == null) goto L6;
        r100.c(this);
        return;
    }

    public m getWebTimeHelper() {
        return this.f437464g;
    }

    public ywb.c getWebViewConfig() {
        return this.f437459b;
    }

    public g(Context r100) {
        this(new com.ss.android.lark.officewebview.util.d(r100), null);
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r100) {
        oxb.b r101 = (oxb.b) this.f437458a.a(oxb.b.class);
        if (r101 == null) goto L11;
        copyBackForwardList();
        boolean r102 = r101.q();
        boolean r103 = super.canGoBackOrForward(r100);
        j.e("BaseOfficeWebView", "canGoBackOrForward proxy handle, canGoBackOrForward = " + r102 + " , superCanGoBackOrForward " + r103);
        if (r102 == false) goto L8;
        if (r103 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoBackOrForward(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        int r101 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.web.disable.huawei.subThread.draw") == false) goto L7;
        super.draw(r100);
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        super.draw(r100);
        return;
    L10:
        if (RomUtils.f437185a[0].equals(RomUtils.c().f437207a) == false) goto L12;
        j.b("BaseOfficeWebView", "huawei is drawing webView in subThread !!");
        return;
    L12:
        super.draw(r100);
    }

    public final void l(boolean r100) {
        Lazy<otb.n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        j.b("BaseOfficeWebView", "is system core not support darkMode");
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100) {
        j.e("BaseOfficeWebView", "loadUrl");
        this.f437464g.a(r100, System.currentTimeMillis());
        if (i.a() == true) goto L11;
        i.a.f437549a.b(new b(this, r100));
        return;
    L11:
        super.loadUrl(r100, new HashMap());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public void setOpenFromMultiWindow(boolean r100) {
        this.f437462e = r100;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        if (this.f437461d == null) goto L5;
        j.e("BaseOfficeWebView", "setWebChromeClient success");
        uwb.b r101 = this.f437461d;
        r101.getClass();
        j.e("LarkBaseWebChromeClient", "Caller setWebChromeClient");
        r101.f551955b = r100;
        return;
    L5:
        int r102 = t.f470510a;
        dxb.c.a r103 = dxb.c.f470456a;
        int r104 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        o r105 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r105 == null) goto L9;
        o.a r106 = r105.d();
        if (r106 == null) goto L9;
    L22:
        Map<String, Object> r107 = getCommonParams();     // Catch: Throwable -> L20
        if (r107 == null) goto L15;
        boolean r108 = true;
        if ((!r107.isEmpty()) != true) goto L15;
    L16:
        if (r108 == false) goto L18;
        r106.b();     // Catch: Throwable -> L20
    L18:
        r106.flush();     // Catch: Throwable -> L20
        return;
    L15:
        r108 = false;
    L20:
        th = move-exception;
        throw th;
    L9:
        r106 = new k();
        goto L22
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        boolean r101 = false;
        if (this.f437460c == null) goto L35;
        j.e("BaseOfficeWebView", "mWebViewClient setWebViewClient");
        Context r102 = getWebViewContext();
        int r103 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.a(r102) == false) goto L30;
        if (r100 == null) goto L30;
        if ((r100 instanceof wwb.b) == true) goto L30;
        StackTraceElement[] r104 = ThreadMethodProxy.currentThread().getStackTrace();
        int r105 = r104.length;
        StringBuilder r106 = new StringBuilder();
        int r107 = 2;
        if (r105 <= 2) goto L13;
    L11:
        if (r107 >= r105) goto L13;
        StackTraceElement r108 = r104[r107];
        r106.append(r108.getClassName());
        r106.append("#");
        r106.append(r108.getMethodName());
        r106.append(com.alipay.sdk.m.u.i.f25853b);
        r107 = r107 + 1;
    L13:
        int r109 = t.f470510a;
        Intrinsics.checkNotNullParameter(r106.toString(), "stackTrace");
        dxb.c.a r110 = dxb.c.f470456a;
        int r111 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        o r112 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r112 == null) goto L17;
        o.a r113 = r112.d();
        if (r113 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter(LocationMonitorConst.ERR_MSG, "key");
        r113.a(LocationMonitorConst.ERR_MSG);
        Map<String, Object> r114 = getCommonParams();     // Catch: Throwable -> L28
        if (r114 != null) goto L22;
    L24:
        if (r101 == false) goto L26;
        r113.b();     // Catch: Throwable -> L28
    L26:
        r113.flush();     // Catch: Throwable -> L28
        goto L30
    L22:
        if ((!r114.isEmpty()) != true) goto L24;
        r101 = true;
    L28:
        th = move-exception;
        throw th;
    L17:
        r113 = new k();
    L30:
        uwb.c r115 = this.f437460c;
        r115.getClass();
        StringBuilder r116 = new StringBuilder("Caller setWebViewClient: client=");
        if (r100 != null) goto L33;
        Object r117 = "null";
    L34:
        r116.append(r117);
        j.e("LarkBaseWebViewClient", r116.toString());
        r115.f551958b = r100;
        return;
    L33:
        r117 = Integer.valueOf(r100.hashCode());
        goto L34
    L35:
        int r118 = t.f470510a;
        dxb.c.a r119 = dxb.c.f470456a;
        int r120 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        o r121 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r121 == null) goto L39;
        o.a r122 = r121.d();
        if (r122 == null) goto L39;
    L53:
        Map<String, Object> r123 = getCommonParams();     // Catch: Throwable -> L49
        if (r123 != null) goto L43;
    L45:
        if (r101 == false) goto L47;
        r122.b();     // Catch: Throwable -> L49
    L47:
        r122.flush();     // Catch: Throwable -> L49
        return;
    L43:
        if ((!r123.isEmpty()) != true) goto L45;
        r101 = true;
    L49:
        th = move-exception;
        throw th;
    L39:
        r122 = new k();
        goto L53
    }

    public void setWebViewConfig(ywb.c r110) {
        if (r110 == null) goto L58;
        Context r100 = getContext();
        ywb.b.a r101 = new ywb.b.a();
        ywb.e.a r102 = new ywb.e.a();
        ywb.d.a r103 = new ywb.d.a();
        int r104 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        r101.f569366a.f569365a = com.ss.android.lark.officesdk.utils.di.e.a.a(r100);
        boolean r105 = true;
        r103.f569371a.f569370a = true;
        ywb.c r106 = new ywb.c();
        ywb.b r107 = r110.f569367a;
        if (r107 != null) goto L8;
        r107 = r101.f569366a;
    L8:
        r106.f569367a = r107;
        ywb.e r108 = r110.f569368b;
        if (r108 != null) goto L12;
        r108 = r102.f569372a;
    L12:
        r106.f569368b = r108;
        ywb.d r109 = r110.f569369c;
        if (r109 != null) goto L16;
        r109 = r103.f569371a;
    L16:
        r106.f569369c = r109;
        this.f437459b = r106;
        ywb.b r111 = r110.f569367a;
        if (r111 != null) goto L19;
        j.f("BaseOfficeWebView", "setWebViewConfig failed, debuggableConfig is null.");
    L24:
        if (r110.f569368b == null) goto L51;
        WebSettings r112 = getSettings();
        r112.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        r112.setLoadWithOverviewMode(true);
        r112.setUseWideViewPort(true);
        r112.setDomStorageEnabled(true);
        r112.setDatabaseEnabled(true);
        r112.setDisplayZoomControls(false);
        r112.setBuiltInZoomControls(true);
        r112.setAllowFileAccess(false);
        r112.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        r112.setSupportZoom(true);
        r112.setJavaScriptEnabled(true);
        r112.setSupportMultipleWindows(false);
        if (TextUtils.isEmpty(null) == false) goto L34;
        String r113 = r112.getUserAgentString();
        Context r114 = getContext();
        Locale r115 = Locale.getDefault();
        int r116 = v.f437238a;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "userAgent");
        Intrinsics.checkNotNullParameter(r115, "locale");
        DependencyContainer r117 = DependencyContainer.f433166a;
        z r118 = (z) DependencyContainer.a(z.class, null);
        if (r118 == null) goto L33;
        String r119 = r118.Y();
        if (r119 == null) goto L33;
        r113 = r119;
    L33:
        r112.setUserAgentString(r113);
    L35:
        int r120 = com.ss.android.lark.officesdk.utils.di.b.f437218a;
        DependencyContainer r121 = DependencyContainer.f433166a;
        ntb.c r122 = (ntb.c) DependencyContainer.a(ntb.c.class, null);
        if (r122 == null) goto L38;
        boolean r123 = r122.isInit();
    L40:
        if (r123 == true) goto L42;
        j.f("WebSettingConfig", "AuditManager has not init");
    L50:
        r112.setGeolocationEnabled(r105);
    L52:
        ywb.d r124 = r110.f569369c;
        if (r124 != null) goto L55;
        j.f("BaseOfficeWebView", "setPerformanceConfig failed, performanceConfig is null.");
        return;
    L55:
        if (r124.f569370a == false) goto L60;
        j.e("BaseOfficeWebView", "performanceConfig is enable");
        Lazy<otb.n> r125 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        return;
    L60:
        return;
    L42:
        Intrinsics.checkNotNullParameter("PRIVACY_GPS_LOCATION", "permissionType");
        ntb.c r126 = (ntb.c) DependencyContainer.a(ntb.c.class, null);
        if (r126 == null) goto L45;
        int r127 = r126.j();
    L46:
        j.e("WebSettingConfig", "checkAuthority result=" + r127);
        if (r127 != 2) goto L50;
        r105 = false;
        goto L50
    L45:
        r127 = 0;
        goto L46
    L38:
        r123 = false;
        goto L40
    L34:
        r112.setUserAgentString(null);
        goto L35
    L51:
        j.f("BaseOfficeWebView", "setWebViewConfig failed, webSettingConfig is null.");
        goto L52
    L19:
        if (r111.f569365a == true) goto L21;
        WebView.setWebContentsDebuggingEnabled(false);
        goto L24
    L21:
        j.f("BaseOfficeWebView", "open inspect");
        goto L24
    L58:
        j.f("BaseOfficeWebView", "setWebViewConfig failed, config is null.");
    }

    public g(com.ss.android.lark.officewebview.util.d r100, AttributeSet r101) {
        super(r100.getContext(), r101);
        r100.a(r100.getContext());
        this.f437463f = new l();
        this.f437464g = new m();
        Context r102 = getContext();
        ywb.b.a r103 = new ywb.b.a();
        ywb.e.a r104 = new ywb.e.a();
        ywb.d.a r105 = new ywb.d.a();
        int r106 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        r103.f569366a.f569365a = com.ss.android.lark.officesdk.utils.di.e.a.a(r102);
        r105.f569371a.f569370a = true;
        ywb.c r107 = new ywb.c();
        r107.f569367a = r103.f569366a;
        r107.f569368b = r104.f569372a;
        r107.f569369c = r105.f569371a;
        this.f437459b = r107;
        setWebViewConfig(r107);
        this.f437460c = new uwb.c(this);
        this.f437461d = new uwb.b(this);
        super.setWebViewClient(this.f437460c);
        super.setWebChromeClient(this.f437461d);
        this.f437458a = new n();
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.b.class);
        k();
        j.e("BaseOfficeWebView", "initWebView done");
        postDelayed(new d(this), 1500);
    }

    public static void a(g r100, String r101) {
        r100.getClass();
        super.loadUrl(r101, new HashMap());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    @Override // android.webkit.WebView
    public final void evaluateJavascript(final String r100, final ValueCallback<String> r101) {
        j.e("BaseOfficeWebView", "evaluateJavascript run");
        if (i.a() == false) goto L5;
        super.evaluateJavascript(r100, r101);
        return;
    L5:
        i.a.f437549a.b(new a(this, r100, r101));
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100, final Map<String, String> r101) {
        j.e("BaseOfficeWebView", "loadUrl additional");
        this.f437464g.a(r100, System.currentTimeMillis());
        if (r101 == null) goto L8;
        DependencyContainer r102 = DependencyContainer.f433166a;
        ntb.m r103 = (ntb.m) DependencyContainer.a(ntb.m.class, DependencyContextUniqueId.OfficeWebView);
        if (r103 == null) goto L8;
        r101.put("Accept-Language", r103.t());
    L8:
        if (i.a() == true) goto L15;
        i.a.f437549a.b(new e(this, r100, r101));
        return;
    L15:
        super.loadUrl(r100, r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public static void g(g r100, String r101, Map r102) {
        r100.getClass();
        super.loadUrl(r101, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public static /* synthetic */ void h(g r100, String r101, ValueCallback r102) {
        super.evaluateJavascript(r101, r102);
    }

    @Override // android.webkit.WebView
    public final void loadData(final String r100, final String r101, final String r102) {
        j.e("BaseOfficeWebView", "loadData");
        this.f437464g.a(getUrl(), System.currentTimeMillis());
        if (i.a() == false) goto L5;
        super.loadData(r100, r101, r102);
        return;
    L5:
        i.a.f437549a.b(new f(this, r100, r101, r102));
    }

    public static /* synthetic */ void j(g r100, String r101, String r102, String r103) {
        super.loadData(r101, r102, r103);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String r110, final String r111, final String r112, final String r113, final String r114) {
        j.e("BaseOfficeWebView", "loadDataWithBaseUrl");
        this.f437464g.a(r110, System.currentTimeMillis());
        if (i.a() == false) goto L5;
        super.loadDataWithBaseURL(r110, r111, r112, r113, r114);
        return;
    L5:
        i.a.f437549a.b(new c(this, r110, r111, r112, r113, r114));
    }

    public static /* synthetic */ void i(g r100, String r101, String r102, String r103, String r104, String r105) {
        super.loadDataWithBaseURL(r101, r102, r103, r104, r105);
    }
}
