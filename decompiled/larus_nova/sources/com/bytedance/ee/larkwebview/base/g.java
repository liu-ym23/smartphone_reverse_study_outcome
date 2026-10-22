package com.bytedance.ee.larkwebview.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.u.i;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.larkwebview.util.j;
import com.bytedance.ee.larkwebview.util.l;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.RomUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gt5.p;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
public abstract class g extends WebView implements ys5.c, ft5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o f242880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bt5.c f242881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ws5.c f242882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ws5.b f242883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f242884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f242885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f242886g;

    public abstract /* synthetic */ TracingCoreSpan getBaseTraceSpan();

    public abstract /* synthetic */ String getBizType();

    public abstract /* synthetic */ Map<String, Object> getCommonParams();

    public abstract /* synthetic */ Map<String, Object> getReasonParams();

    public abstract /* synthetic */ o getServiceManager();

    public abstract /* synthetic */ long getStartTime();

    public abstract /* synthetic */ LarkWebView getWebView();

    public abstract void j();

    @Override // android.webkit.WebView
    public final boolean canGoBack() {
        st5.b r100 = (st5.b) this.f242880a.a(st5.b.class);
        if (r100 == null) goto L11;
        copyBackForwardList();
        boolean r101 = r100.canGoBack();
        boolean r102 = super.canGoBack();
        Log.i("BaseWebView", "canGoBack proxy handle , canGoBack = " + r101 + " , super canGoBack = " + r102);
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
        st5.b r100 = (st5.b) this.f242880a.a(st5.b.class);
        if (r100 == null) goto L11;
        copyBackForwardList();
        boolean r101 = r100.j();
        boolean r102 = super.canGoForward();
        Log.i("BaseWebView", "canGoForward proxy handle, canGoForward = " + r101 + ", base canGoForward " + r102);
        if (r101 == false) goto L8;
        if (r102 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoForward();
    }

    public String getTTWebViewVersion() {
        Lazy<n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        return "";
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        ws5.c r100 = this.f242882c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f561054b;
    }

    @Override // ys5.c
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
        j r100 = this.f242885f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f242977a != null) goto L8;
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
        j r100 = this.f242885f;
        if (r100 == null) goto L6;
        r100.c(this);
        return;
    }

    public l getWebTimeHelper() {
        return this.f242886g;
    }

    public bt5.c getWebViewConfig() {
        return this.f242881b;
    }

    public g(Context r100) {
        this(new com.bytedance.ee.larkwebview.util.c(r100), null);
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r100) {
        st5.b r101 = (st5.b) this.f242880a.a(st5.b.class);
        if (r101 == null) goto L11;
        copyBackForwardList();
        boolean r102 = r101.q();
        boolean r103 = super.canGoBackOrForward(r100);
        Log.i("BaseWebView", "canGoBackOrForward proxy handle, canGoBackOrForward = " + r102 + " , superCanGoBackOrForward " + r103);
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
        if (FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.web.disable.huawei.subThread.draw") == false) goto L7;
        super.draw(r100);
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        super.draw(r100);
        return;
    L10:
        if (RomUtils.g() == false) goto L12;
        Log.e("BaseWebView", "huawei is drawing webView in subThread !!");
        return;
    L12:
        super.draw(r100);
    }

    public final void l(boolean r100) {
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        Log.e("BaseWebView", "is system core not support darkMode");
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100) {
        Log.i("BaseWebView", "loadUrl");
        this.f242886g.a(r100, System.currentTimeMillis());
        if (com.bytedance.ee.larkwebview.util.g.a() == false) goto L5;
        k(r100, new HashMap());
        return;
    L5:
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new e(this, r100));
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onDragEvent(DragEvent r100) {
        return super.onDragEvent(r100);
    L4:
        e = move-exception;
        Log.e("BaseWebView", "onDragEvent failed", e);
        return false;
    }

    public void setOpenFromMultiWindow(boolean r100) {
        this.f242884e = r100;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        if (this.f242883d == null) goto L5;
        Log.i("BaseWebView", "setWebChromeClient success");
        ws5.b r101 = this.f242883d;
        r101.getClass();
        Log.i("LarkBaseWebChromeClient", "Caller setWebChromeClient");
        r101.f561051b = r100;
        return;
    L5:
        int r102 = p.f482566a;
        new gt5.g("wb_set_webchrome_client_failed", gt5.e.f482524h, this).flush();
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        if (this.f242882c == null) goto L19;
        Log.i("BaseWebView", "mWebViewClient setWebViewClient");
        if (DevEnvUtil.isDebugMode(getWebViewContext()) == false) goto L14;
        if (r100 == null) goto L14;
        if ((r100 instanceof ys5.b) == true) goto L14;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        int r102 = r101.length;
        StringBuilder r103 = new StringBuilder();
        int r104 = 2;
        if (r102 <= 2) goto L13;
    L11:
        if (r104 >= r102) goto L13;
        StackTraceElement r105 = r101[r104];
        r103.append(r105.getClassName());
        r103.append("#");
        r103.append(r105.getMethodName());
        r103.append(i.f25853b);
        r104 = r104 + 1;
    L13:
        int r106 = p.f482566a;
        String r107 = r103.toString();
        Intrinsics.checkNotNullParameter(r107, "stackTrace");
        new gt5.g("wb_invalid_web_client", gt5.e.f482532p, this).addCategoryValue(LocationMonitorConst.ERR_MSG, r107).flush();
    L14:
        ws5.c r108 = this.f242882c;
        r108.getClass();
        StringBuilder r109 = new StringBuilder("Caller setWebViewClient: client=");
        if (r100 != null) goto L17;
        Object r110 = "null";
    L18:
        r109.append(r110);
        Log.i("LarkBaseWebViewClient", r109.toString());
        r108.f561054b = r100;
        return;
    L17:
        r110 = Integer.valueOf(r100.hashCode());
        goto L18
    L19:
        int r111 = p.f482566a;
        new gt5.g("wb_set_webview_client_failed", gt5.e.f482523g, this).flush();
    }

    public void setWebViewConfig(bt5.c r100) {
        if (r100 == null) goto L44;
        Context r101 = getContext();
        bt5.b.a r102 = new bt5.b.a();
        bt5.e.a r103 = new bt5.e.a();
        bt5.d.a r104 = new bt5.d.a();
        r102.f20558a.f20557a = DevEnvUtil.isDebugMode(r101);
        boolean r105 = true;
        r104.f20563a.f20562a = true;
        bt5.c r106 = new bt5.c();
        bt5.b r107 = r100.f20559a;
        if (r107 != null) goto L8;
        r107 = r102.f20558a;
    L8:
        r106.f20559a = r107;
        bt5.e r108 = r100.f20560b;
        if (r108 != null) goto L12;
        r108 = r103.f20564a;
    L12:
        r106.f20560b = r108;
        bt5.d r109 = r100.f20561c;
        if (r109 != null) goto L16;
        r109 = r104.f20563a;
    L16:
        r106.f20561c = r109;
        this.f242881b = r106;
        bt5.b r110 = r100.f20559a;
        if (r110 != null) goto L19;
        Log.w("BaseWebView", "setWebViewConfig failed, debuggableConfig is null.");
    L24:
        if (r100.f20560b == null) goto L37;
        WebSettings r111 = getSettings();
        r111.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        r111.setLoadWithOverviewMode(true);
        int r112 = com.larksuite.framework.utils.autoscale.a.f285947a;
        r111.setUseWideViewPort(true);
        r111.setDomStorageEnabled(true);
        r111.setDatabaseEnabled(true);
        r111.setDisplayZoomControls(false);
        r111.setBuiltInZoomControls(true);
        r111.setAllowFileAccess(false);
        r111.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        r111.setSupportZoom(true);
        r111.setJavaScriptEnabled(true);
        r111.setSupportMultipleWindows(false);
        if (TextUtils.isEmpty(null) == false) goto L28;
        r111.getUserAgentString();
        Context r113 = getContext();
        Locale.getDefault();
        r111.setUserAgentString(xoc.a.a(r113));
    L30:
        if (AuditManager.isInit() == true) goto L32;
        Log.w("WebSettingConfig", "AuditManager has not init");
    L36:
        r111.setGeolocationEnabled(r105);
    L38:
        bt5.d r114 = r100.f20561c;
        if (r114 != null) goto L41;
        Log.w("BaseWebView", "setPerformanceConfig failed, performanceConfig is null.");
        return;
    L41:
        if (r114.f20562a == false) goto L46;
        Log.i("BaseWebView", "performanceConfig is enable");
        Lazy<n> r115 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        return;
    L46:
        return;
    L32:
        int r116 = AuditManager.getInstance().checkAuthority(18);
        Log.i("WebSettingConfig", "checkAuthority result=" + r116);
        if (r116 != 1) goto L36;
        r105 = false;
        goto L36
    L28:
        r111.setUserAgentString(null);
        goto L30
    L37:
        Log.w("BaseWebView", "setWebViewConfig failed, webSettingConfig is null.");
        goto L38
    L19:
        if (r110.f20557a == true) goto L21;
        WebView.setWebContentsDebuggingEnabled(false);
        goto L24
    L21:
        Log.w("BaseWebView", "open inspect");
        goto L24
    L44:
        Log.w("BaseWebView", "setWebViewConfig failed, config is null.");
    }

    public g(com.bytedance.ee.larkwebview.util.c r100, AttributeSet r101) {
        super(r100.getContext(), r101);
        Context r102 = r100.getContext();
        Configuration r103 = r102.getResources().getConfiguration();
        Log.i("DarkModeContextExtension", "merge config=" + r103);
        int r104 = r100.f242968b;
        if (r104 != r103.uiMode) goto L5;
        Log.i("DarkModeContextExtension", "redirect pass");
    L6:
        this.f242885f = new j();
        this.f242886g = new l();
        Context r105 = getContext();
        bt5.b.a r106 = new bt5.b.a();
        bt5.e.a r107 = new bt5.e.a();
        bt5.d.a r108 = new bt5.d.a();
        r106.f20558a.f20557a = DevEnvUtil.isDebugMode(r105);
        r108.f20563a.f20562a = true;
        bt5.c r109 = new bt5.c();
        r109.f20559a = r106.f20558a;
        r109.f20560b = r107.f20564a;
        r109.f20561c = r108.f20563a;
        this.f242881b = r109;
        setWebViewConfig(r109);
        this.f242882c = new ws5.c(this);
        this.f242883d = new ws5.b(this);
        super.setWebViewClient(this.f242882c);
        super.setWebChromeClient(this.f242883d);
        this.f242880a = new o();
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.b.class);
        j();
        Log.i("BaseWebView", "initWebView done");
        postDelayed(new c(this), 1500);
        return;
    L5:
        r103.uiMode = r104;
        Resources r110 = r102.getResources();
        Resources r111 = r102.getResources();
        r110.updateConfiguration(r103, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()));
        Log.i("DarkModeContextExtension", "redirect config=" + r102.getResources().getConfiguration());
        goto L6
    }

    @Override // android.webkit.WebView
    public final void evaluateJavascript(final String r100, final ValueCallback<String> r101) {
        Log.i("BaseWebView", "evaluateJavascript run");
        if (com.bytedance.ee.larkwebview.util.g.a() == false) goto L5;
        super.evaluateJavascript(r100, r101);
        return;
    L5:
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new a(this, r100, r101));
    }

    public final void k(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("BaseWebView", e);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100, final Map<String, String> r101) {
        Log.i("BaseWebView", "loadUrl additional");
        this.f242886g.a(r100, System.currentTimeMillis());
        if (r101 == null) goto L8;
        if (((ct5.a) ClaymoreServiceLoader.loadFirst(ct5.a.class)) == null) goto L8;
        yob.e.a().getClass();
        int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
        r101.put("Accept-Language", com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting().toLanguageTag());
    L8:
        if (com.bytedance.ee.larkwebview.util.g.a() == false) goto L10;
        k(r100, r101);
        return;
    L10:
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new d(this, r100, r101));
    }

    public static /* synthetic */ void g(g r100, String r101, ValueCallback r102) {
        super.evaluateJavascript(r101, r102);
    }

    @Override // android.webkit.WebView
    public final void loadData(final String r100, final String r101, final String r102) {
        Log.i("BaseWebView", "loadData");
        this.f242886g.a(getUrl(), System.currentTimeMillis());
        if (com.bytedance.ee.larkwebview.util.g.a() == false) goto L5;
        super.loadData(r100, r101, r102);
        return;
    L5:
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new b(this, r100, r101, r102));
    }

    public static /* synthetic */ void h(g r100, String r101, String r102, String r103) {
        super.loadData(r101, r102, r103);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String r110, final String r111, final String r112, final String r113, final String r114) {
        Log.i("BaseWebView", "loadDataWithBaseUrl");
        this.f242886g.a(r110, System.currentTimeMillis());
        if (com.bytedance.ee.larkwebview.util.g.a() == false) goto L5;
        super.loadDataWithBaseURL(r110, r111, r112, r113, r114);
        return;
    L5:
        com.bytedance.ee.larkwebview.util.g.a.f242974a.b(new f(this, r110, r111, r112, r113, r114));
    }

    public static /* synthetic */ void i(g r100, String r101, String r102, String r103, String r104, String r105) {
        super.loadDataWithBaseURL(r101, r102, r103, r104, r105);
    }
}
