package com.bytedance.lynx.webview.glue;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.PacProcessor;
import android.webkit.ServiceWorkerController;
import android.webkit.TokenBindingService;
import android.webkit.TracingController;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.webkit.WebViewFactoryProvider;
import android.webkit.WebViewProvider;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.e;
import com.bytedance.lynx.webview.internal.n0;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.lynx.webview.proxy.WebViewProviderProxy;
import f17.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import l17.n;

/* JADX INFO: loaded from: classes21.dex */
public class TTWebProviderWrapper implements WebViewFactoryProvider, a.InterfaceC5847a {
    private static final String TAG = "TTWebProviderWrapper";
    private static final String TTWEBVIEW_TAG = "tt_webview";
    private static WebViewFactoryProvider sSingleSystemProvider;
    private Handler mBackgroundHandler;
    private a mCurrentLoadResult;
    private EventCallback mEventCallback;
    private Runnable mInitCallback;
    private boolean mIsRenderProcess;
    private Runnable mPrepareBuiltinCallback;
    private ProviderCallback mProviderCallback;
    private WebViewFactoryProvider mTTGlueProvider;

    public interface EventCallback {
        void sendEnsureTime(long r100);
    }

    public interface ProviderCallback {
        WebViewFactoryProvider getTTGlueProvider();
    }

    public void ensureFactoryProviderCreated() {
        ensureFactoryProviderCreated(false);
    }

    public void asyncTriggerEnsure() {
        if (this.mPrepareBuiltinCallback == null) goto L8;
        Handler r100 = this.mBackgroundHandler;
        if (r100 == null) goto L9;
        r100.post(new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public CookieManager getCookieManager() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getCookieManager();
    }

    public WebViewFactoryProvider getCurrentProvider() {
        if (this.mCurrentLoadResult != null) goto L6;
        return null;
    L6:
        if (isTTProvider() == false) goto L9;
        WebViewFactoryProvider r100 = getTTProvider();
    L11:
        if (r100 != null) goto L13;
        r.b("[Load] TTWebProviderWrapper getCurrentProvider mCurrentLoadResult = " + this.mCurrentLoadResult);
    L13:
        return r100;
    L9:
        if (isSystemProvider() == false) goto L14;
        r100 = getSystemProvider();
        goto L11
    L14:
        return null;
    }

    public GeolocationPermissions getGeolocationPermissions() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getGeolocationPermissions();
    }

    public PacProcessor getPacProcessor() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getPacProcessor();
    }

    public ServiceWorkerController getServiceWorkerController() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return GlueApiHelperForO.createServiceWorkerController(getCurrentProvider());
    }

    public WebViewFactoryProvider.Statics getStatics() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getStatics();
    }

    public CookieManager getSysCookieManager() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getSystemProvider().getCookieManager();
    }

    public WebViewFactoryProvider getSystemProvider() {
        if (sSingleSystemProvider != null) goto L18;
        if (getTTProvider() != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (sSingleSystemProvider != null) goto L10;
        sSingleSystemProvider = n0.a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        goto L18
    L16:
        throw new RuntimeException("TTWebView has been initialized, SystemWebView shouldn't be launched due to libwebviewchromium_plat_support library.");
    L18:
        return sSingleSystemProvider;
    }

    public TokenBindingService getTokenBindingService() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return GlueApiHelperForO.createTokenBindingService(getCurrentProvider());
    }

    public WebIconDatabase getWebIconDatabase() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getWebIconDatabase();
    }

    public WebStorage getWebStorage() {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getWebStorage();
    }

    public boolean isSystemProvider() {
        return this.mCurrentLoadResult.f();
    }

    public boolean isTTProvider() {
        return this.mCurrentLoadResult.g();
    }

    public TracingController getTracingController() {
        ensureFactoryProviderCreated();
        return getCurrentProvider().getTracingController();
    }

    public ClassLoader getWebViewClassLoader() {
        ensureFactoryProviderCreated();
        return getCurrentProvider().getWebViewClassLoader();
    }

    public WebViewFactoryProvider getTTProvider() {
        return this.mTTGlueProvider;
    }

    public TTWebProviderWrapper(boolean r100) {
        this.mCurrentLoadResult = null;
        this.mIsRenderProcess = r100;
    }

    public static /* synthetic */ Runnable access$000(TTWebProviderWrapper r100) {
        return r100.mPrepareBuiltinCallback;
    }

    public void ensureFactoryProviderCreated(boolean r100) {
        if (this.mIsRenderProcess == false) goto L5;
        return;
    L5:
        if (getCurrentProvider() == null) goto L8;
        if (r100 == true) goto L8;
        return;
    L8:
        monitor-enter(this);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (getCurrentProvider() == null) goto L35;
        if (r100 == true) goto L35;
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L35:
        this.mInitCallback.run();     // Catch: Throwable -> L19
        long r102 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L31
        EventCallback r103 = this.mEventCallback;     // Catch: Throwable -> L31
        if (r103 == null) goto L24;
    L17:
        r103.sendEnsureTime(r102);     // Catch: Throwable -> L31
    L24:
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L19:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L26
        r102 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L31
        r103 = this.mEventCallback;     // Catch: Throwable -> L31
        if (r103 == null) goto L24;
    L26:
        th = move-exception;
        long r104 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L31
        EventCallback r105 = this.mEventCallback;     // Catch: Throwable -> L31
        if (r105 == null) goto L30;
        r105.sendEnsureTime(r104);     // Catch: Throwable -> L31
    L30:
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public WebViewDatabase getWebViewDatabase(Context r100) {
        if (this.mIsRenderProcess == false) goto L6;
        return null;
    L6:
        ensureFactoryProviderCreated(false);
        return getCurrentProvider().getWebViewDatabase(r100);
    }

    @Override // f17.a.InterfaceC5847a
    public void onLoadResultChanged(a r100) {
        this.mCurrentLoadResult = r100;
        this.mTTGlueProvider = this.mProviderCallback.getTTGlueProvider();
        r.d("[Load-tmp] TTWebProviderWrapper onLoadResultChanged mTTGlueProvider = " + this.mTTGlueProvider);
    }

    public WebViewProvider createWebView(WebView r110, WebView.PrivateAccess r111) {
        if (this.mIsRenderProcess == false) goto L5;
        return null;
    L5:
        long r100 = System.currentTimeMillis();
        ensureFactoryProviderCreated(false);
        long r101 = System.currentTimeMillis();
        Object r102 = r110.getTag();
        if ((r110 instanceof DedicatedWebView) == false) goto L13;
        Method r112 = this.mTTGlueProvider.getClass().getDeclaredMethod("createWebView", new Class[]{WebView.class, WebView.PrivateAccess.class, Boolean.TYPE});     // Catch: Throwable -> L11
        r112.setAccessible(true);     // Catch: Throwable -> L11
        r110.setTag(new Pair(TTWEBVIEW_TAG, new Pair(Long.valueOf(r100), Long.valueOf(r101))));     // Catch: Throwable -> L11
        WebViewProvider r103 = (WebViewProvider) r112.invoke(this.mTTGlueProvider, new Object[]{r110, r111, Boolean.TRUE});     // Catch: Throwable -> L11
        r110.setTag(r102);     // Catch: Throwable -> L10
    L16:
        if (r103 != null) goto L19;
        r110.setTag(new Pair(TTWEBVIEW_TAG, new Pair(Long.valueOf(r100), Long.valueOf(r101))));
        r103 = getCurrentProvider().createWebView(r110, r111);
        r110.setTag(r102);
    L19:
        if (Setting.c().k() == true) goto L29;
        if (TTWebSdk.isSettingSupportHotReload() == true) goto L23;
    L27:
        return r103;
    L23:
        if (n.e(TTWebContext.h().getContext()) == true) goto L29;
        AtomicBoolean r104 = e.f265294a;
        if (Setting.c().b("sdk_enable_hot_reload_main_proc", false) == false) goto L27;
    L29:
        return new WebViewProviderProxy(r110, r103).getWebViewProvider();
    L15:
        r103 = null;
        goto L16
    L13:
        if ((r110 instanceof WebViewType.SystemWebView) == false) goto L15;
        r103 = getSystemProvider().createWebView(r110, r111);
        goto L16
    }

    public TTWebProviderWrapper(Handler r100, Runnable r101, Runnable r102, ProviderCallback r103, EventCallback r104) {
        this.mIsRenderProcess = false;
        this.mCurrentLoadResult = null;
        this.mPrepareBuiltinCallback = r101;
        this.mInitCallback = r102;
        this.mProviderCallback = r103;
        this.mEventCallback = r104;
        this.mBackgroundHandler = r100;
        ConcurrentLinkedQueue<a.InterfaceC5847a> r105 = a.f475072d;
        monitor-enter(a.class);
        ConcurrentLinkedQueue<a.InterfaceC5847a> r106 = a.f475072d;     // Catch: Throwable -> L10
        if (r106.contains(this) == false) goto L7;
        r.b("addLoadResultObserver a already added observer " + this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return;
    L7:
        r106.add(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
