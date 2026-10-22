package com.ss.android.lark.chameleon.basewebview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient;
import com.ss.android.lark.chameleon.basewebview.config.LarkWebViewConfig;
import com.ss.android.lark.chameleon.basewebview.config.PerformanceConfig;
import com.ss.android.lark.chameleon.basewebview.config.WebSettingConfig;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewClientCompat;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.DarkModeContextExtension;
import com.ss.android.lark.chameleon.util.RomUtils;
import com.ss.android.lark.chameleon.util.UIExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseWebView extends WebView implements ILarkWebViewContext {
    private static final String FG_KEY_DISABLE_SUBTHREAD_DRAW_IN_HUAWEI = "openplatform.web.disable.huawei.subThread.draw";
    private static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    private static final String PERFORMANCE_CMD = "ttwebview:/*enableTTLogEvent*/;";
    private static final String TAG = "BaseWebView";
    private LarkBaseWebChromeClient mBaseWebChromeClient;
    private LarkBaseWebViewClient mBaseWebViewClient;
    private LarkWebViewConfig mConfig;
    private boolean mIsOpenFromMultiWindow;

    public static /* synthetic */ void a(BaseWebView r100, String r101, String r102, String r103) {
        r100.lambda$loadData$3(r101, r102, r103);
    }

    public static /* synthetic */ void b(BaseWebView r100, String r101, Map r102) {
        r100.lambda$loadUrl$2(r101, r102);
    }

    public static /* synthetic */ void c(BaseWebView r100, String r101) {
        r100.lambda$loadUrl$1(r101);
    }

    public static /* synthetic */ void d(BaseWebView r100, String r101, String r102, String r103, String r104, String r105) {
        r100.lambda$loadDataWithBaseURL$4(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void e(BaseWebView r100, String r101, ValueCallback r102) {
        r100.lambda$evaluateJavascript$0(r101, r102);
    }

    private void registerService() {
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        LarkBaseWebViewClient r100 = this.mBaseWebViewClient;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getWebViewClient();
    }

    private void initWebView() {
        LarkWebViewConfig r100 = LarkWebViewConfig.createDefault(getContext());
        this.mConfig = r100;
        setWebViewConfig(r100);
        this.mBaseWebViewClient = new LarkBaseWebViewClient(this);
        this.mBaseWebChromeClient = new LarkBaseWebChromeClient(this);
        super.setWebViewClient(this.mBaseWebViewClient);
        super.setWebChromeClient(this.mBaseWebChromeClient);
        registerService();
        Log.i(TAG, "initWebView done");
    }

    @Override // com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext
    public Context getWebViewContext() {
        return getContext();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    public void resetServiceAndClient() {
        LarkWebViewConfig r100 = LarkWebViewConfig.createDefault(getContext());
        this.mConfig = r100;
        setWebViewConfig(r100);
        this.mBaseWebViewClient.setWebViewClient(null);
        this.mBaseWebChromeClient.setWebChromeClient(null);
        registerService();
    }

    public LarkWebViewConfig getWebViewConfig() {
        return this.mConfig;
    }

    public boolean isOpenFromMultiWindow() {
        return this.mIsOpenFromMultiWindow;
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    public BaseWebView(Context r100) {
        this(new DarkModeContextExtension(r100), null);
    }

    private /* synthetic */ void lambda$loadUrl$1(String r100) {
        loadUrlInternal(r100, new HashMap());
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        super.draw(r100);
        return;
    L6:
        if (RomUtils.isHuawei() == false) goto L8;
        Log.e(TAG, "huawei is drawing webView in subThread !!");
        return;
    L8:
        super.draw(r100);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100) {
        Log.i(TAG, "loadUrl");
        if (UIExecutor.checkUiThread() == false) goto L5;
        loadUrlInternal(r100, new HashMap());
        return;
    L5:
        UIExecutor.executor().post(new e(this, r100));
    }

    public void setOpenFromMultiWindow(boolean r100) {
        this.mIsOpenFromMultiWindow = r100;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        if (this.mBaseWebChromeClient == null) goto L6;
        Log.i(TAG, "setWebChromeClient success");
        this.mBaseWebChromeClient.setWebChromeClient(r100);
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        if (this.mBaseWebViewClient == null) goto L16;
        Log.i(TAG, "mWebViewClient setWebViewClient");
        if (AppInfoUtils.isApkInDebug(getWebViewContext()) == false) goto L13;
        if (r100 == null) goto L13;
        if ((r100 instanceof ILarkWebViewClientCompat) == true) goto L13;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        int r102 = r101.length;
        int r103 = 2;
        if (r102 <= 2) goto L13;
    L11:
        if (r103 >= r102) goto L13;
        StackTraceElement r104 = r101[r103];
        r104.getClassName();
        r104.getMethodName();
        r103 = r103 + 1;
    L13:
        this.mBaseWebViewClient.setWebViewClient(r100);
        return;
    }

    public void setWebViewConfig(LarkWebViewConfig r100) {
        if (r100 == null) goto L4;
        updateWebViewConfig(r100);
        return;
    L4:
        Log.w(TAG, "setWebViewConfig failed, config is null.");
    }

    public void updateWebViewConfig(LarkWebViewConfig r100) {
        if (r100 != null) goto L6;
        Log.w(TAG, "updateWebViewConfig failed, config is null.");
        return;
    L6:
        this.mConfig = new LarkWebViewConfig.Builder(getContext()).apply(r100);
        if (r100.getDebuggableConfig() != null) goto L9;
        Log.w(TAG, "setWebViewConfig failed, debuggableConfig is null.");
    L13:
        WebSettingConfig r101 = r100.getWebSettingConfig();
        if (r101 == null) goto L16;
        r101.apply(this);
    L17:
        PerformanceConfig r102 = r100.getPerformanceConfig();
        if (r102 != null) goto L20;
        Log.w(TAG, "setPerformanceConfig failed, performanceConfig is null.");
        return;
    L20:
        if (r102.isPerformanceEnable() == false) goto L24;
        Log.i(TAG, "performanceConfig is enable");
        return;
    L24:
        return;
    L16:
        Log.w(TAG, "setWebViewConfig failed, webSettingConfig is null.");
        goto L17
    L9:
        if (r100.getDebuggableConfig().isWebViewInspectEnable() == true) goto L11;
        WebView.setWebContentsDebuggingEnabled(false);
        goto L13
    L11:
        Log.w(TAG, "open inspect");
        goto L13
    }

    public BaseWebView(DarkModeContextExtension r100, AttributeSet r101) {
        super(r100.getContext(), r101);
        r100.injectRedirectConfiguration(r100.getContext());
        initWebView();
    }

    private /* synthetic */ void lambda$evaluateJavascript$0(String r100, ValueCallback r101) {
        super.evaluateJavascript(r100, r101);
    }

    private /* synthetic */ void lambda$loadUrl$2(String r100, Map r101) {
        loadUrlInternal(r100, r101);
    }

    private void loadUrlInternal(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(final String r100, final ValueCallback<String> r101) {
        Log.i(TAG, "evaluateJavascript run");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.evaluateJavascript(r100, r101);
        return;
    L5:
        UIExecutor.executor().post(new b(this, r100, r101));
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r100, final Map<String, String> r101) {
        Log.i(TAG, "loadUrl additional");
        if (r101 == null) goto L6;
        r101.put("Accept-Language", Env.getCacheLanguageSetting().toLanguageTag());
    L6:
        if (UIExecutor.checkUiThread() == false) goto L8;
        loadUrlInternal(r100, r101);
        return;
    L8:
        UIExecutor.executor().post(new c(this, r100, r101));
    }

    private /* synthetic */ void lambda$loadData$3(String r100, String r101, String r102) {
        super.loadData(r100, r101, r102);
    }

    @Override // android.webkit.WebView
    public void loadData(final String r100, final String r101, final String r102) {
        Log.i(TAG, "loadData");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.loadData(r100, r101, r102);
        return;
    L5:
        UIExecutor.executor().post(new a(this, r100, r101, r102));
    }

    private /* synthetic */ void lambda$loadDataWithBaseURL$4(String r100, String r101, String r102, String r103, String r104) {
        super.loadDataWithBaseURL(r100, r101, r102, r103, r104);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String r110, final String r111, final String r112, final String r113, final String r114) {
        Log.i(TAG, "loadDataWithBaseUrl");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.loadDataWithBaseURL(r110, r111, r112, r113, r114);
        return;
    L5:
        UIExecutor.executor().post(new d(this, r110, r111, r112, r113, r114));
    }
}
