package com.bytedance.ee.bear.document;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.bytedance.ee.bear.document.webviewpool.WebViewPoolConfig;
import com.bytedance.ee.larkwebview.webview_api.adapter.LarkWebViewAdapter;
import com.larksuite.component.air.AirApplication;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y7 implements q45.b {
    public static final l7 j = null;
    public final q45.c a;
    public CompositeDisposable b;
    public final WebViewPoolConfig c;
    public final List<String> d;
    public boolean e;
    public final boolean f;
    public final p7 g;
    public final q7 h;
    public final r7 i;

    public static class a {
        public static final y7 a = null;

        static {
            a = new y7();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.document.l7] */
    static {
        j = new l7();
    }

    public final void a() {
        if (this.e == false) goto L5;
        return;
    L5:
        tt5.a.h("WebViewManager", "adjustPoolSize()...");
        c();
        if (Build.VERSION.SDK_INT < 23) goto L8;
        Looper.getMainLooper().getQueue().addIdleHandler(this.h);
        return;
    L8:
        com.bytedance.ee.util.ui.j.d(this.g, 1000);
    }

    public final void b() {
        tt5.a.h("WebViewManager", "adjustPoolSizeInternal()... occupiedSize = " + this.a.e() + ", poolSize = " + this.a.f() + ", poolConfig = " + this.c);
        com.bytedance.ee.util.ui.j.e(this.i);
        boolean r2 = false;
        if (this.a.e() != this.a.f()) goto L7;
        if (this.a.f() >= this.c.maxSize) goto L7;
    L10:
        this.b.add(d(false).subscribe(new n7(), new o7()));
        return;
    L7:
        if (this.a.e() >= this.a.f()) goto L13;
        if (this.a.f() < this.c.coreSize) goto L10;
    L13:
        if (n() == false) goto L15;
    L18:
        com.bytedance.ee.util.ui.j.d(this.i, 10000);
        return;
    L15:
        if (this.a.e() != 0) goto L17;
        r2 = true;
    L17:
        if (r2 == true) goto L18;
    }

    public final void c() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Looper.getMainLooper().getQueue().removeIdleHandler(this.h);
    L6:
        com.bytedance.ee.util.ui.j.e(this.i);
        return;
    L5:
        com.bytedance.ee.util.ui.j.e(this.g);
        goto L6
    }

    public final DocBridgeWebViewV2 k() {
        tt5.a.h("WebViewManager", "getFirstWebView()...");
        DocBridgeWebViewV2[] r0 = {null};
        q45.c r2 = this.a;
        monitor-enter(r2);
        Iterator r3 = new ArrayList(r2.a).iterator();     // Catch: Throwable -> L10
        if (r3.hasNext() == false) goto L7;
        r0[0] = ((q45.c.a) r3.next()).b;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r2);
        return r0[0];
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        if ((this.a.e() + 1) < this.a.f()) goto L5;
    L7:
        return false;
    L5:
        if (this.a.f() <= this.c.coreSize) goto L7;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.document.p7] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.document.q7] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.document.r7] */
    public y7() {
        this.b = new CompositeDisposable();
        this.d = new ArrayList();
        this.e = false;
        this.g = new p7(this);
        this.h = new q7(this);
        this.i = new r7(this);
        q45.c r0 = new q45.c();
        this.a = r0;
        r0.b = this;
        WebViewPoolConfig r1 = (WebViewPoolConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(WebViewPoolConfig.KEY, WebViewPoolConfig.class, new WebViewPoolConfig(1, 2, 5, 3));
        this.c = r1;
        DevicePerfManager r2 = DevicePerfManager.b.a;
        if ((!r2.e.h) == true) goto L5;
        r1.maxUseCount = 1;
        r1.coreSize = 1;
        r1.maxSize -= 2;
    L5:
        StringBuilder r3 = new StringBuilder(" isHighDevice:");
        r3.append(!r2.e.h);
        r3.append(" maxUseCount:");
        r3.append(r1.maxUseCount);
        tt5.a.h("WebViewManager", r3.toString());
        if (r1.maxUseCount >= 1) goto L9;
        r1.maxUseCount = 1;
    L9:
        if (r1.initialSize >= 1) goto L12;
        tt5.a.k("WebViewManager", "initialSize is less than 1! " + r1.initialSize);
        r1.initialSize = 1;
    L12:
        if (r1.coreSize >= r1.initialSize) goto L15;
        tt5.a.k("WebViewManager", "coreSize is less initialSize! coreSize = " + r1.coreSize + ", initialSize = " + r1.initialSize);
        r1.coreSize = r1.initialSize;
    L15:
        if (r1.maxSize >= r1.coreSize) goto L17;
        tt5.a.k("WebViewManager", "maxSize is less initialSize! maxSize = " + r1.maxSize + ", coreSize = " + r1.coreSize);
        r1.maxSize = r1.coreSize;
    L17:
        tt5.a.h("WebViewManager", "WebViewManager init poolConfig = " + r1);
        ml5.b r4 = new ml5.b("debug_config");
        boolean r5 = r4.a.getBoolean("drive_same_render_emed_on", true);
        this.f = r5;
        tt5.a.h("WebViewManager", "Debug setting mEnableDriveSameRenderEmed = " + r5);
        if (((Boolean) r4.a("singleWebView", Boolean.FALSE)).booleanValue() == false) goto L21;
        h("singleWebView");
        return;
    }

    public static boolean m() {
        if (eu5.c.c() == false) goto L8;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r0 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r0, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("preload_docs_sdk_enable", "key");
        if (r0.getBoolean("preload_docs_sdk_enable", true) == true) goto L8;
        tt5.a.k("WebViewManager", "isDebugDisablePreload true");
        return false;
    L8:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(DocBridgeWebViewV2 r6) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.h("ccm.bitable.larkform.new.darkmode") == true) goto L7;
        tt5.a.h("WebViewManager", "darkmode fg close");
        return;
    L7:
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L10;
        tt5.a.h("WebViewManager", "lark package close don't open darkmode");
        return;
    L10:
        WebSettings r1 = r6.getSettings();
        boolean r3 = h18.f.a(r6.getContext());
        tt5.a.h("WebViewManager", "open webview darkmode, isNightMode = " + r3);
        if (r0.h("ccm.doc.darkmode.force.open") == false) goto L16;
        tt5.a.h("WebViewManager", "ccm.doc.darkmode.force.open is true");
        if (Build.VERSION.SDK_INT < 29) goto L15;
        TTWebViewUtil.a(r1, 2, r6);
    L15:
        TTWebViewUtil.b(r1, 2, r6);
    L16:
        r6.l(r3);
        if (Build.VERSION.SDK_INT >= 33) goto L19;
        return;
    L19:
        if (r6.getContext().getApplicationInfo().targetSdkVersion < 33) goto L31;
        tt5.a.h("WebViewManager", "open darkmode on 33");
        if (WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING") == true) goto L28;
        tt5.a.h("WebViewManager", "open darkmode failed for 33");
        return;
    L28:
        WebSettingsCompat.setAlgorithmicDarkeningAllowed(r1, r3);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        tt5.a.f("WebViewManager", e, false);
        return;
    }

    public final Flowable<Boolean> d(boolean r11) {
        tt5.a.h("WebViewManager", "createWebView()... isReloadRN = " + r11);
        DocBridgeWebViewV2 r0 = this.a.a();     // Catch: Throwable -> L5
    L35:
        return q(r0, r11);
    L6:
        if ((LarkContext.getApplication() instanceof AirApplication) == false) goto L33;
        tt5.a.h("WebViewManager", "copyResourceInfoFromOld in doc");
        AirApplication r1 = LarkContext.getApplication();
        Resources r2 = r1.getResources();
        Resources r3 = r1.a();
        boolean r4 = true;
        if (r2 == null) goto L24;
        if (r3 == null) goto L24;
        if (r2.hashCode() != r3.hashCode()) goto L37;
        Log.e("WebViewPackageNotFound", "resource is same");
        goto L33
    L37:
        AssetManager r5 = r2.getAssets();     // Catch: Throwable -> L22
        AssetManager r6 = r3.getAssets();     // Catch: Throwable -> L22
        Method r7 = com.bytedance.ee.larkwebview.util.k.a(AssetManager.class, "getApkAssets", new Class[0]);     // Catch: Throwable -> L22
        if (r7 != null) goto L17;
        Log.e("WebViewPackageNotFound", "getApkAssetsMethod is null");     // Catch: Throwable -> L22
    L36:
        goto L33
    L17:
        r7.setAccessible(true);     // Catch: Throwable -> L22
        Object r8 = r7.invoke(r6, new Object[0]);     // Catch: Throwable -> L22
        Method r9 = com.bytedance.ee.larkwebview.util.k.a(AssetManager.class, "setApkAssets", new Class[]{r8.getClass(), Boolean.TYPE});     // Catch: Throwable -> L22
        if (r9 != null) goto L20;
        Log.e("WebViewPackageNotFound", "setApkAssetsMethod is null");     // Catch: Throwable -> L22
        goto L36
    L20:
        r9.setAccessible(true);     // Catch: Throwable -> L22
        r9.invoke(r5, new Object[]{r8, Boolean.TRUE});     // Catch: Throwable -> L22
        Log.i("WebViewPackageNotFound", "copyResourceInfoFromOld call suc");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Log.e("WebViewPackageNotFound", th.getMessage() + ", copyResourceInfoFromOld fail");
    L24:
        StringBuilder r10 = new StringBuilder("resource is null:");
        if (r2 != null) goto L27;
        boolean r12 = true;
    L28:
        r10.append(r12);
        r10.append(",");
        if (r3 == null) goto L32;
        r4 = false;
    L32:
        r10.append(r4);
        Log.e("WebViewPackageNotFound", r10.toString());
        goto L33
    L27:
        r12 = false;
    L33:
        r0 = this.a.a();
        goto L35
    }

    public final void e(DocBridgeWebViewV2 r3) {
        tt5.a.h("WebViewManager", "destroyWebView()... webView = " + r3);
        c();
        this.a.b(r3);
    }

    public final DocBridgeWebViewV2 f(Object r6) {
        tt5.a.h("WebViewManager", "detachWebView()... tag = " + r6);
        c();
        q45.c r0 = this.a;
        monitor-enter(r0);
        DocBridgeWebViewV2 r1 = null;
        if (r6 != null) goto L25;
        monitor-exit(r0);
    L21:
        return r1;
    L25:
        Iterator<q45.c.a> r2 = r0.a.iterator();     // Catch: Throwable -> L22
    L10:
        if (r2.hasNext() == false) goto L14;
        q45.c.a r3 = r2.next();     // Catch: Throwable -> L22
        if (r6.equals(r3.a) == false) goto L10;
        r2.remove();     // Catch: Throwable -> L22
    L15:
        if (r3 == null) goto L17;
        r3.a = null;     // Catch: Throwable -> L22
        ((LinkedList) r0.a).addLast(r3);     // Catch: Throwable -> L22
    L17:
        if (r3 == null) goto L20;
        r1 = r3.b;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r0);
        goto L21
    L14:
        r3 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final void h(String r6) {
        tt5.a.h("WebViewManager", "enterAutoTestMode() tag = ".concat(r6));
        if (((ArrayList) this.d).contains(r6) == true) goto L5;
        ((ArrayList) this.d).add(r6);
    L5:
        this.e = true;
        c();
        if (this.a.f() != 0) goto L9;
        this.b.add(d(false).subscribe(new v7(), new w7()));
    L9:
        if (this.a.f() <= 1) goto L11;
        DocBridgeWebViewV2 r0 = this.a.g(null, false);
        this.a.b(r0);
        goto L9
    }

    public final void i(String r3) {
        tt5.a.h("WebViewManager", "exitAutoTestMode() tag = ".concat(r3));
        ((ArrayList) this.d).remove(r3);
        if (((ArrayList) this.d).isEmpty() == false) goto L6;
        this.e = false;
        tt5.a.h("WebViewManager", "exitAutoTestMode");
        return;
    }

    public final DocBridgeWebViewV2 j(Object r3) {
        tt5.a.h("WebViewManager", "getCurWebView()... tag = " + r3);
        return this.a.c(r3, false);
    }

    public final Flowable<Boolean> l(boolean r7) {
        int r1 = 0;
    L4:
        if (r1 >= (this.c.initialSize - 1)) goto L7;
        this.b.add(d(false).subscribe(new x7(), new m7()));
        r1 = r1 + 1;
        goto L4
    L7:
        return d(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(DocBridgeWebViewV2 r5) {
        r5.D(j);
        r5.measure(View.MeasureSpec.makeMeasureSpec(com.bytedance.ee.util.ui.n.v(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (com.bytedance.ee.util.ui.n.t() * 0.9f), 1073741824));
        boolean r2 = false;
        r5.layout(0, 0, r5.getMeasuredWidth(), r5.getMeasuredHeight());
        new n45.c(r5.getSettings(), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).a(r5);
        if (this.f == true) goto L5;
        return;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable") == false) goto L16;
        st5.o r0 = r5.getServiceManager();
        if (r0 != null) goto L9;
        tt5.a.h("WebViewManager", "isWebViewSupportEmbed embedEnable= false, getServiceManager is null");
    L13:
        if (r2 == false) goto L16;
        int r1 = is5.a.a;
        is5.a.b(new is5.a.a(r5.getContext(), com.bytedance.ee.larkwebview.webview_api.adapter.d.a(r5), new WebViewManager$1()));
        tt5.a.h("WebViewManager", "onWebViewCreated .... Drive same render embed enabled v2");
        return;
    L9:
        st5.f r3 = r0.a(st5.f.class);
        if (r3 != null) goto L12;
        tt5.a.h("WebViewManager", "isWebViewSupportEmbed embedEnable= false, getService is null");
        goto L13
    L12:
        Boolean r4 = (Boolean) r3.p().get(PlatformPluginVersion.EMBED);
        tt5.a.h("WebViewManager", "isWebViewSupportEmbed embedEnable= " + r4);
        r2 = Boolean.TRUE.equals(r4);
    L16:
        if (ku5.c.k(LarkContext.getApplication()) == true) goto L18;
        tr5.b r6 = tr5.b.a.a;
        LarkWebViewAdapter r7 = com.bytedance.ee.larkwebview.webview_api.adapter.d.a(r5);
        r6.getClass();
        tr5.b.b(r7);
        tt5.a.h("WebViewManager", "onWebViewCreated .... Drive same render embed enabled v1");
        return;
    L18:
        tt5.a.h("WebViewManager", "onWebViewCreated .... Drive same render embed not enabled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(DocBridgeWebViewV2 r3) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable") == false) goto L5;
        int r0 = is5.a.a;
        is5.a.a(com.bytedance.ee.larkwebview.webview_api.adapter.d.a(r3));
    L5:
        ViewGroup r1 = (ViewGroup) r3.getParent();
        if (r1 == null) goto L8;
        r1.removeView(r3);
    L8:
        r3.getWebServiceManager().c();
        r3.clearHistory();
        r3.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2, java.lang.Object] */
    public final DocBridgeWebViewV2 r(Object r4) {
        ?? r0 = t(r4);
        tt5.a.h("WebViewManager", "provideCleanWebView()... tag = " + r4 + " webview = " + r0.hashCode());
        if (r0.M() == false) goto L5;
        r0.stopLoading();
    L5:
        r0.clearHistory();
        ViewGroup r5 = (ViewGroup) r0.getParent();
        if (r5 == 0) goto L8;
        r5.removeView(r0);
    L8:
        return r0;
    }

    public final DocBridgeWebViewV2 s(Object r6) {
        tt5.a.h("WebViewManager", "provideIdleWebView()... tag = " + r6);
        c();
        DocBridgeWebViewV2 r0 = this.a.c(r6, true);
        if (r0 == null) goto L6;
        tt5.a.h("WebViewManager", "provideIdleWebView()... current tag hit, webview = " + r0.hashCode());
        return r0;
    L6:
        q45.c r1 = this.a;
        monitor-enter(r1);
        Integer r2 = null;
        if (r6 != null) goto L39;
    L29:
        monitor-exit(r1);
    L30:
        DocBridgeWebViewV2 r3 = null;
    L31:
        if (r3 == null) goto L33;
        g(r3);
    L33:
        StringBuilder r4 = new StringBuilder("provideIdleWebView()... tag = ");
        r4.append(r6);
        r4.append(" webview = ");
        if (r3 == null) goto L37;
        r2 = Integer.valueOf(r3.hashCode());
    L37:
        r4.append(r2);
        tt5.a.h("WebViewManager", r4.toString());
        return r3;
    L39:
    L26:
        th = move-exception;
        throw th;
    L11:
        if (CollectionUtils.isEmpty(r1.a) == true) goto L29;
        Iterator<q45.c.a> r5 = r1.a.iterator();     // Catch: Throwable -> L26
    L15:
        if (r5.hasNext() == false) goto L19;
        q45.c.a r7 = r5.next();     // Catch: Throwable -> L26
        if (r7.a != null) goto L15;
    L20:
        if (r7 != null) goto L23;
        monitor-exit(r1);
        goto L30
    L23:
        ((LinkedList) r1.a).remove(r7);     // Catch: Throwable -> L26
        ((LinkedList) r1.a).addFirst(r7);     // Catch: Throwable -> L26
        r7.a = r6;     // Catch: Throwable -> L26
        r3 = r7.b;     // Catch: Throwable -> L26
        monitor-exit(r1);
        goto L31
    L19:
        r7 = null;
        goto L20
    }

    public final DocBridgeWebViewV2 t(Object r9) {
        tt5.a.h("WebViewManager", "provideWebView()... tag = " + r9);
        tt5.a.h("WebViewManager", "provideWebView occupiedSize = " + this.a.e() + ", poolSize = " + this.a.f() + ", poolConfig = " + this.c);
        c();
        DocBridgeWebViewV2 r0 = this.a.c(r9, true);
        if (r0 == null) goto L7;
        tt5.a.h("WebViewManager", "provideWebView()... tag = " + r9 + "webview = " + r0.hashCode());
        return r0;
    L7:
        if (this.a.e() == this.a.f()) goto L9;
    L11:
        DocBridgeWebViewV2 r1 = this.a.g(r9, true);
        tt5.a.h("WebViewManager", "provideWebView()... tag = " + r9 + "webview = " + r1.hashCode());
        g(r1);
        return r1;
    L9:
        if (this.a.f() >= this.c.maxSize) goto L11;
        this.b.add(d(false).subscribe(new s7(), new t7()));
        goto L11
    }

    public final Flowable<Boolean> q(DocBridgeWebViewV2 r5, boolean r6) {
        tt5.a.h("WebViewManager", "preloadTemplateForOneWebView()... webView = " + r5 + ", isReloadRN = " + r6);
        if (m() == true) goto L7;
        return Flowable.just(Boolean.FALSE);
    L7:
        if (s1.u.get() == false) goto L9;
        s1.C = SystemClock.uptimeMillis();
    L9:
        c();
        j35.g r0 = new j35.g(r5);
        String r7 = s45.p.t;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L12;
        r7 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).f9();
    L12:
        String r1 = "https://" + r7 + s45.p.a().U0();
        if (DocOpenConfig.g() == true) goto L15;
    L17:
        tt5.a.h("WebViewManager", "getPreloadUrl: url = " + r1);
        monitor-enter(r0);
        tt5.a.h("PreloadEntry", "preloadFlow() isReloadRN  " + r6 + "   preloadUrl: " + r1);     // Catch: Throwable -> L22
        Flowable<Boolean> r8 = ((j35.c) r0.a()).b(r6, r1);     // Catch: Throwable -> L22
        monitor-exit(r0);
        return r8;
    L22:
        th = move-exception;
        throw th;
    L15:
        if (Build.VERSION.SDK_INT >= 24) goto L17;
        r1 = "http://" + r7 + s45.p.a().U0();
        goto L17
    }
}
