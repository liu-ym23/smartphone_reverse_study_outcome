package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ChameleonWebViewManager implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, q0b.a> f411138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f411139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f411140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Runnable> f411141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f411142f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f411143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebViewManager f411144b;

        public final void a() {
            q0b.a r100 = this.f411144b.f411138b.get(this.f411143a);
            if (r100 == null) goto L27;
            ChameleonWebViewManager r101 = this.f411144b;
            r101.getClass();
            WebViewPoolConfig r102 = r100.a();
            com.ss.android.lark.officesdk.utils.di.j.e(r101.f411137a, "shrinkWebPoolSize() 11... occupiedSize = " + r100.occupiedSize() + ", poolSize = " + r100.poolSize() + ", poolConfig = " + r102);
        L6:
            if ((r100.occupiedSize() + 1) >= r100.poolSize()) goto L13;
            if (r100.poolSize() <= r102.getCoreSize()) goto L13;
            ChameleonWebView r103 = r100.d(null);
            if (r103 == null) goto L13;
            com.ss.android.lark.officesdk.utils.di.j.e(r101.f411137a, "shrinkWebPoolSize == webView: " + r103.hashCode());
            r100.e(r103);
        L13:
            com.ss.android.lark.officesdk.utils.di.j.e(r101.f411137a, "shrinkWebPoolSize() 22... occupiedSize = " + r100.occupiedSize() + ", poolSize = " + r100.poolSize() + ", poolConfig = " + r102);
            if (r100.occupiedSize() != 0) goto L17;
            Lazy<otb.n> r104 = TTWebViewUtil.f437209a;
            TTWebViewUtil.a.b().Q();
        L17:
            if (r100.occupiedSize() != 0) goto L28;
            ChameleonWebView r105 = r100.getOverMaxUsedWebView(r102.getMaxUseCount());
            if (r105 == null) goto L29;
            com.ss.android.lark.officesdk.utils.di.j.e(r101.f411137a, "release over-max-used WebView:  " + r105.hashCode());
            r100.e(r105);
            if (r100.poolSize() != 0) goto L30;
            com.ss.android.lark.officesdk.utils.di.j.e(r101.f411137a, "webViewPool.poolSize() == 0. createWebView");
            r100.b(r105.getChameleonConfig(), null).z();
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ChameleonWebViewManager r100) {
            this.f411144b = r100;
            this.f411143a = "";
        }
    }

    public final void b() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "destroyAll()...");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$destroyAll$1(this, null), 3, null);
    }

    public ChameleonWebViewManager() {
        this.f411137a = "CML_TAG_WebViewManager" + hashCode();
        this.f411138b = new HashMap();
        this.f411139c = new ArrayList();
        this.f411140d = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
        this.f411141e = new HashMap();
        this.f411142f = new a(this);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f411140d;
    }

    public static String e(ChameleonConfig r100) {
        String r101 = r100.getBizName();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.getSubBizname();
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return r101.concat(r102);
    }

    public final void a(String r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "destroy()... bizName = " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$destroy$1(this.f411138b.get(r100), this, r100, null), 3, null);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void c(ChameleonWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "destroyWebview()... webView = " + r100.hashCode());
        q0b.a r101 = this.f411138b.get(e(r100.getChameleonConfig()));
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public final ChameleonWebView d(ChameleonConfig r100, Object r110) {
        WebviewConfig r101 = r100.getWebviewConfig();
        if (r101 == null) goto L6;
        WebViewPoolConfig r102 = r101.getWebViewPoolConfig();
        if (r102 == null) goto L6;
    L7:
        final q0b.b r103 = new q0b.b(r102);
        this.f411138b.put(e(r100), r103);
        r103.f531233b = new ChameleonWebViewManager$doCreateWebView$1(this, r103);
        ChameleonWebView r104 = r103.b(r100, r110);
        r104.z();
        return r104;
    L6:
        r102 = new WebViewPoolConfig(0, 0, 0, 0, 15, null);
        goto L7
    }

    public final ChameleonWebView f(ChameleonConfig r100, Object r110) {
        Intrinsics.checkNotNullParameter(r100, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r110, "tag");
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "getWebView()... bizName = " + r100.getBizName() + ",  tag = " + r110);
        PreloadConfig r101 = r100.getPreloadConfig();
        if (r101 == null) goto L6;
        PreloadPolicy r102 = r101.getPolicy();
        if (r102 == null) goto L6;
    L8:
        if (r102 != PreloadPolicy.NO_PRELOAD) goto L11;
        int r103 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        return new ChameleonWebView(com.ss.android.lark.officesdk.utils.di.d.a.a(), r100);
    L11:
        Runnable r104 = this.f411141e.get(e(r100));
        if (r104 == null) goto L14;
        Lazy<Handler> r105 = ThreadUtil.f437211a;
        ThreadUtil.a.e(r104);
    L14:
        q0b.a r106 = this.f411138b.get(e(r100));
        ViewGroup r107 = null;
        if (r106 == null) goto L17;
        WebViewPoolConfig r108 = r106.a();
    L18:
        if (r106 == null) goto L42;
        int r109 = r106.poolSize();
        int r111 = r106.occupiedSize();
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "provideWebView occupiedSize = " + r111 + ", poolSize = " + r109 + ", poolConfig = " + r108);
        ChameleonWebView r112 = r106.c(r110);
        if (r112 == null) goto L23;
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "provideWebView()1... tag = " + r110 + ",  webview = " + r112.hashCode());
        return r112;
    L23:
        if (r111 != r109) goto L30;
        if (r108 == null) goto L26;
        int r113 = r108.getMaxSize();
    L27:
        if (r109 >= r113) goto L30;
        ChameleonWebView r114 = r106.b(r100, r110);
        r114.z();
        return r114;
    L26:
        r113 = Integer.MAX_VALUE;
    L30:
        ChameleonWebView r115 = r106.d(r110);
        if (r115 == null) goto L33;
        ViewParent r116 = r115.getParent();
    L35:
        if ((r116 instanceof ViewGroup) == false) goto L37;
        r107 = (ViewGroup) r116;
    L37:
        if (r107 == null) goto L39;
        r115.stopLoading();
        r115.clearHistory();
        r107.removeView(r115);
    L39:
        com.ss.android.lark.officesdk.utils.di.j.e(this.f411137a, "provideWebView()2... tag = " + r110 + ",    webview = " + r115.hashCode());
        return r115;
    L33:
        r116 = null;
        goto L35
    L42:
        return d(r100, r110);
    L17:
        r108 = null;
    L6:
        r102 = PreloadPolicy.NO_PRELOAD;
        goto L8
    }

    public final void h(ChameleonConfig r100, WebView r101) {
        Intrinsics.checkNotNullParameter(r100, "chameleonConfig");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$preloadWebview$1(this, r100, r101, null), 3, null);
    }

    public final void g(ChameleonConfig r110, ChameleonWebView r111, Object r112) {
        Intrinsics.checkNotNullParameter(r110, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r111, "webView");
        Intrinsics.checkNotNullParameter(r112, "tag");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$onWebViewDetached$1(this, r112, r110, r111, null), 3, null);
    }
}
