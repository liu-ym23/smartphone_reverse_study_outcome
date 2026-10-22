package com.bytedance.ee.bear.document;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.collection.SieveCacheKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.bytedance.ee.bear.document.multitask.ScrollData;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.reloadwebview.JsThreadCheckConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.quality.safe.FileChooseHandlerV2;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.info.DocAppIdConst;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public class DocBridgeWebViewV2 extends WebViewV2 implements x35.e {

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final List<p35.f> f218499v3 = null;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public static long f218500w3;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public static int f218501x3;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public static final h1 f218502y3 = null;
    public String E2;
    public final String F2;
    public final com.bytedance.ee.bear.contract.d G1;
    public JSONObject G2;
    public final com.bytedance.ee.bear.contract.b0 H1;
    public String H2;
    public final boolean I2;
    public final List<l<zv4.f>> J2;
    public final boolean K2;
    public final com.bytedance.ee.bear.contract.f L1;
    public final boolean L2;
    public final Map<String, Boolean> M1;
    public final boolean M2;
    public String N2;
    public String O2;
    public boolean P1;
    public long P2;
    public boolean Q1;
    public long Q2;
    public long R2;
    public b2 S1;
    public int S2;
    public boolean T1;
    public boolean T2;
    public final boolean U2;
    public WeakReference<Fragment> V1;
    public final Map<String, Serializable> V2;
    public vv4.d W2;
    public vv4.c X2;
    public j Y2;
    public final LiveData<ConnectionService.NetworkState> Z2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public i05.e f218503a3;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final List<l<com.bytedance.ee.bear.contract.m0>> f218504b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public int f218505b3;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public int f218506c3;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public boolean f218507d3;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public int f218508e3;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public final boolean f218509f3;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final String f218510g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final String f218511g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.ssrrender.a f218512g3;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f218513h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public volatile boolean f218514h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public boolean f218515h3;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public boolean f218516i3;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public final Map<Integer, Boolean> f218517j3;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f218518k1;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public final vv4.n f218519k3;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public final u1 f218520l3;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public boolean f218521m3;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public boolean f218522n3;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public final boolean f218523o3;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f218524p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public n25.c f218525p2;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public x35.f f218526p3;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public final d f218527q3;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public final e f218528r3;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public final f f218529s3;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public final g f218530t3;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public otb.e f218531u3;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final ml5.b f218532v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public String f218533v2;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.j f218534x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public BearUrl f218535x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.h0 f218536y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public String f218537y2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DocStatus {
        public static final int DEFAULT = 0;
        public static final int LOADING = 1;
        public static final int PRELOAD = 2;
    }

    public class a implements ys5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218538a;

        @Override // ys5.c
        public final st5.o getServiceManager() {
            return new st5.o();
        }

        @Override // ys5.c
        public final Context getWebViewContext() {
            return this.f218538a.getContext();
        }

        @Override // ys5.c
        public final LarkWebView getWebView() {
            return this.f218538a;
        }

        public a(DocBridgeWebViewV2 r100) {
            this.f218538a = r100;
        }
    }

    public class b extends ws5.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218539d;

        @Override // ws5.b, android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
            return false;
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            if (r100.messageLevel().ordinal() > ConsoleMessage.MessageLevel.LOG.ordinal()) goto L5;
        L10:
            return true;
        L5:
            if (TextUtils.isEmpty(r100.message()) == false) goto L7;
        L9:
            tt5.a.h(this.f218539d.f218510g1 + "_js", du5.b.k(r100.message()) + " -- From line " + r100.lineNumber() + du5.b.k(r100.sourceId()));
            goto L10
        L7:
            if (r100.message().contains("name") == false) goto L9;
            return true;
        }

        public b(DocBridgeWebViewV2 r100, a r101) {
            this.f218539d = r100;
            super(r101);
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            if (r100 == null) goto L5;
            String r102 = du5.b.k(r100.getUrl());
        L6:
            tt5.a.h(this.f218539d.f218510g1, "onProgressChanged: " + r101 + ", url: " + r102);
            return;
        L5:
            r102 = "";
            goto L6
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView r100, String r101, String r110, String r111, JsPromptResult r112) {
            if (com.bytedance.ee.bear.document.reloadwebview.a.f221273j == false) goto L6;
            com.bytedance.ee.bear.document.reloadwebview.a.f();
        L6:
            if (TextUtils.equals("__featureGatingValue__", r110) == true) goto L8;
        L15:
            boolean r102 = TextUtils.equals("__getPendingSSR__", r110);
            String r103 = SliceInitService.DEFAULT_SWITCH;
            boolean r104 = false;
            if (r102 == false) goto L43;
            DocBridgeWebViewV2 r105 = this.f218539d;
            r105.getClass();
            org.json.JSONObject r113 = new org.json.JSONObject();
            String r106 = r105.G1.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_prompt_count");
        L22:
            th = move-exception;
            tt5.a.f(r105.f218510g1, th, false);
        L24:
            String r107 = "1";
        L25:
            r105.G1.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_prompt_count", r107);
            AccountService$Account r108 = r105.f218536y1.G2();
            if (r108 == null) goto L55;
            BearUrl r109 = r105.f218535x2;
            if (r109 == null) goto L55;
            String r114 = r109.f222560a;
            Map<String, String> r115 = r109.f222563d;
            FetchClientVarExecutor r116 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.f220658a;
            String r117 = k25.e0.m().n(n35.a.b(r108, r114, r115), r105.f218535x2.f222561b).f501542c;
            if (TextUtils.isEmpty(r117) == true) goto L55;
            int r118 = r117.length();
            DocOpenConfig.a();
            if (r118 <= DocOpenConfig.f218553g.get_pending_ssr_max_length) goto L34;
            r105.G1.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_over_limit", "1");
            tt5.a.h(r105.f218510g1 + "_getPendingSSR", "ssr is over limit");
        L35:
            r104 = true;
            goto L55
        L34:
            r105.f218521m3 = false;
            tt5.a.h(r105.f218510g1 + "_getPendingSSR", "success... html cache is " + r117.length());
            r105.G1.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_from", EventConstant.Key.RETAIN_PROMPT);
            r103 = r117;
        L55:
            r113.put("ssrContent", r103);     // Catch: Throwable -> L38
            r113.put("disable_next_time", r104);     // Catch: Throwable -> L38
        L40:
            tt5.a.b(r105.f218510g1, "ssrContent length is " + r103.length() + " disableNextTime is " + r104);
            r112.confirm(r113.toString());
            return true;
        L38:
            th = move-exception;
            tt5.a.j(r105.f218510g1, th);
            goto L40
        L19:
            if (TextUtils.isEmpty(r106) == true) goto L24;
            r107 = String.valueOf(CastIntegerProtector.parseInt(r106) + 1);     // Catch: Throwable -> L22
            goto L25
        L43:
            if (TextUtils.equals("biz.util.getSSRScrollPos", r110) == false) goto L51;
            tt5.a.h(this.f218539d.f218510g1, "getSSRScrollPos...");
            com.bytedance.ee.bear.document.ssrrender.a r119 = this.f218539d.f218512g3;
            r119.getClass();
            Intrinsics.checkNotNullParameter(r112, "promptReulst");
            if (r119.f221906a != null) goto L47;
            tt5.a.k("SSR_REN_SSRWebViewBridge", "listner is null");
            r112.confirm(SliceInitService.DEFAULT_SWITCH);
        L50:
            return true;
        L47:
            com.bytedance.ee.bear.document.ssrrender.a.c r120 = new com.bytedance.ee.bear.document.ssrrender.a.c(r112);
            com.bytedance.ee.bear.document.ssrrender.a.b r121 = r119.f221906a;
            if (r121 == null) goto L50;
            r121.a(r120);
            goto L50
        L51:
            tt5.a.h(this.f218539d.f218510g1 + "_onJsPrompt", r110 + "," + r111);
            return false;
        L8:
            if (TextUtils.isEmpty(r111) == true) goto L15;
            boolean r122 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g(r111);
            if (r122 == false) goto L12;
            String r123 = "true";
        L13:
            r112.confirm(r123);
            tt5.a.h(this.f218539d.f218510g1 + "_onJsPromptFg", "key:" + r111 + ", value:" + r122);
            return true;
        L12:
            r123 = "false";
            goto L13
        }
    }

    public class c extends WebViewRenderProcessClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218540a;

        public c(DocBridgeWebViewV2 r100) {
            this.f218540a = r100;
        }

        @Override // androidx.webkit.WebViewRenderProcessClient
        public final void onRenderProcessResponsive(WebView r100, WebViewRenderProcess r101) {
            tt5.a.k(this.f218540a.f218510g1, "onRenderProcessResponsive...");
            com.bytedance.ee.bear.document.reloadwebview.a.f();
        }

        @Override // androidx.webkit.WebViewRenderProcessClient
        public final void onRenderProcessUnresponsive(WebView r100, WebViewRenderProcess r101) {
            tt5.a.k(this.f218540a.f218510g1, "onRenderProcessUnresponsive...");
        }
    }

    public class d implements Observer<ConnectionService.NetworkState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218541a;

        public d(DocBridgeWebViewV2 r100) {
            this.f218541a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ConnectionService.NetworkState r100) {
            DocBridgeWebViewV2 r101 = this.f218541a;
            r101.Y(r100);
        }
    }

    public class e implements Observer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218542a;

        public e(DocBridgeWebViewV2 r100) {
            this.f218542a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Boolean r100) {
            Boolean r101 = r100;
            tt5.a.h(this.f218542a.f218510g1, "init========  isVisible: " + r101 + "  getmLoadHtmlStartTime: " + this.f218542a.getmLoadHtmlStartTime() + "  isReady： " + DocBridgeWebViewV2.z(this.f218542a) + "  isAttachedToWindow： " + this.f218542a.f218514h2);
            if (r101 != Boolean.TRUE) goto L17;
            com.bytedance.ee.util.ui.m.e(this.f218542a.f218529s3);
            com.bytedance.ee.util.ui.m.e(this.f218542a.f218530t3);
            if (this.f218542a.getmLoadHtmlStartTime() != SieveCacheKt.NodeLinkMask) goto L7;
            return;
        L7:
            if (this.f218542a.f218514h2 == false) goto L12;
            if (DocBridgeWebViewV2.z(this.f218542a) == true) goto L20;
            this.f218542a.H();
            return;
        L20:
            return;
        L12:
            if (DocBridgeWebViewV2.z(this.f218542a) == false) goto L14;
            return;
        L14:
            if ((System.currentTimeMillis() - this.f218542a.getmLoadHtmlStartTime()) <= 120000) goto L16;
            DocBridgeWebViewV2.A(this.f218542a);
            return;
        L16:
            this.f218542a.H();
            return;
        L17:
            com.bytedance.ee.util.ui.m.e(this.f218542a.f218529s3);
            com.bytedance.ee.util.ui.m.e(this.f218542a.f218530t3);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218543a;

        public final void a() {
            tt5.a.k(this.f218543a.f218510g1, "reloadWebviewRunnable====== isAttachedToWindow: " + this.f218543a.f218514h2 + "  isReady： " + DocBridgeWebViewV2.z(this.f218543a) + "   type:  " + this.f218543a.f218537y2);
            if (this.f218543a.f218514h2 == false) goto L8;
            if (DocBridgeWebViewV2.z(this.f218543a) == true) goto L11;
            this.f218543a.H();
            return;
        L11:
            return;
        L8:
            if (DocBridgeWebViewV2.z(this.f218543a) == true) goto L13;
            DocBridgeWebViewV2.A(this.f218543a);
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

        public f(DocBridgeWebViewV2 r100) {
            this.f218543a = r100;
        }
    }

    public class g implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            JsThreadCheckConfig r100 = com.bytedance.ee.bear.document.reloadwebview.a.f221264a;     // Catch: Throwable -> L4
            tt5.a.h("JsThreadChecker", "loadHtmlTimeOut....");     // Catch: Throwable -> L4
            com.bytedance.ee.bear.document.reloadwebview.a.f221265b++;     // Catch: Throwable -> L4
            com.bytedance.ee.bear.document.reloadwebview.a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g() {
        }
    }

    public class h implements ys5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218544a;

        @Override // ys5.c
        public final st5.o getServiceManager() {
            return new st5.o();
        }

        @Override // ys5.c
        public final Context getWebViewContext() {
            return this.f218544a.getContext();
        }

        @Override // ys5.c
        public final LarkWebView getWebView() {
            return this.f218544a;
        }

        public h(DocBridgeWebViewV2 r100) {
            this.f218544a = r100;
        }
    }

    public class i extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocBridgeWebViewV2 f218545a;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");
        }

        public i(DocBridgeWebViewV2 r100) {
            this.f218545a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            super.onPageStarted(r100, r101, r102);
            a().getMethod("injectVConsoleIfNeed", new Class[]{WebView.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.l(this.f218545a.f218510g1, "injectVConsoleIfNeed failed", e);
        }
    }

    public interface j {
        void a(BridgeReadyModel r100);
    }

    public static class k extends InputConnectionWrapper {
        public k(InputConnection r100) {
            super(r100, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r110, int r111) {
            if ((r110 - r111) != 1) goto L7;
            long r112 = SystemClock.uptimeMillis();
            super.sendKeyEvent(new KeyEvent(r112, r112, 0, 67, 0, 0, -1, 0, 22));
            super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r112, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r110, r111);
        }
    }

    public static class l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<T> f218546a;

        public final int hashCode() {
            T r100 = this.f218546a.get();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public l(T r100) {
            this.f218546a = new WeakReference(r100);
        }

        public final boolean equals(Object r100) {
            T r101 = this.f218546a.get();
            if (r101 != null) goto L6;
            return false;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            T r102 = ((l) r100).f218546a.get();
            if (r102 != null) goto L11;
            return false;
        L11:
            if (r101 != r102) goto L14;
            return true;
        L14:
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.document.h1] */
    static {
        f218499v3 = new CopyOnWriteArrayList();
        f218501x3 = 0;
        f218502y3 = new h1();
    }

    private boolean getFirstNotRenderSwitch() {
        return ((Boolean) this.f218532v1.a("firstRenderNotAccelerate", Boolean.FALSE)).booleanValue();
    }

    private Flowable<com.bytedance.ee.bear.contract.m0> getRenderCallbacks() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = new ArrayList(this.f218504b2).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        l r102 = (l) r101.next();
        com.bytedance.ee.bear.contract.m0 r103 = (com.bytedance.ee.bear.contract.m0) r102.f218546a.get();
        if (r103 == null) goto L7;
        r100.add(r103);
        goto L4
    L7:
        ((CopyOnWriteArrayList) this.f218504b2).remove(r102);
        goto L4
    L10:
        return Flowable.fromIterable(r100);
    }

    private boolean getRenderSwitch() {
        return ((Boolean) this.f218532v1.a("renderAccelerate", Boolean.TRUE)).booleanValue();
    }

    private int getTipLayoutHeight() {
        if (this.f218506c3 != 0) goto L6;
        NoNetworkView r100 = new NoNetworkView(getContext());
        r100.setTip(getContext().getString(R.string.Doc_Facade_SyncedNextOnline));
        int r101 = com.bytedance.ee.util.ui.n.f243167a;
        r100.measure(View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        this.f218506c3 = com.bytedance.ee.util.ui.n.E(r100.getMeasuredHeight());
    L6:
        return this.f218506c3;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.ee.bear.document.f1] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.bytedance.ee.bear.document.g1] */
    private void r() {
        setBizType(gt5.d.f482512b);
        at5.a r100 = getBridge();
        i2 r101 = new i2();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.f16239i = r101;
        com.bytedance.ee.bear.contract.b0 r102 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        if (((com.bytedance.ee.bear.contract.z) org.koin.java.a.a(com.bytedance.ee.bear.contract.z.class)).isDebugEnabled(getContext()) == false) goto L5;
        WebView.setWebContentsDebuggingEnabled(true);
    L5:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 26) goto L8;
        setRendererPriorityPolicy(2, false);
    L8:
        setReadyStatus(Boolean.FALSE);
        this.D.c("biz.content.editMode", new tb5.k(new p1(this)));
        x35.f r104 = new x35.f(this.f218520l3, this.G1, this.H1.e(), this);
        this.f218526p3 = r104;
        this.D.c("biz.statistics.sendEvent", new tb5.k(r104));
        setHorizontalScrollBarEnabled(false);
        this.f218525p2 = new n25.c(this, this.f218511g2);
        vv4.d r105 = new vv4.d(new h(this));
        this.W2 = r105;
        r105.a(new h2());
        tt5.a.h(this.f218510g1, "generateBridgeWebViewClient() use offline res = " + this.M2);
        if (this.M2 == false) goto L12;
        this.W2.a(this.f218525p2);
    L12:
        if (this.f218523o3 == false) goto L14;
        this.W2.a(new n25.f(this, this.f218511g2));
    L14:
        setWebViewClient(this.W2);
        if (DevEnvUtil.isDevelopPackage(getContext()) == false) goto L17;
        this.W2.a(new i(this));
    L17:
        a r106 = new a(this);
        vv4.c r107 = new vv4.c(r106);
        this.X2 = r107;
        b r108 = new b(this, r106);
        if (((CopyOnWriteArrayList) r107.f557385d).contains(r108) == true) goto L20;
        ((CopyOnWriteArrayList) r107.f557385d).add(r108);
    L20:
        setWebChromeClient(this.X2);
        final s1 r109 = new s1(this.f218534x1, this.G1, this.H1, (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), this.H1.e());
        this.f218503a3 = new i05.e(this);
        this.f218505b3 = com.bytedance.ee.util.ui.n.E(com.bytedance.ee.util.ui.k.e(getContext()));
        this.D.c(JsBridgeConstants.BIZ_NOTIFY_READY, new tb5.k(new i05.c(new f1(this, r109))));
        this.D.c(JsBridgeConstants.BIZ_NOTIFY_PRELOADREADY, new tb5.k(new i05.a(new g1(this, r109))));
        com.bytedance.ee.bear.appsetting.c r110 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f218515h3 = r110.i("spacekit.mobile.use_input_connection_wrapper", true);
        this.f218516i3 = r110.i("spacekit.mobile.intercept_hard_keyboard_enable", true);
        tt5.a.h(this.f218510g1, "useInputWrapper:" + this.f218515h3 + ", interceptHardKeyboardEnable:" + this.f218516i3);
        Lazy<otb.n> r111 = TTWebViewUtil.f437209a;
        otb.e r112 = TTWebViewUtil.a.a(this);
        this.f218531u3 = r112;
        ((otb.m) r112).c(f218502y3);
        this.f218531u3.b(new l1());
        this.f218531u3.a(new m1());
        this.f218519k3.b(new h6(this), ((vv4.o) org.koin.java.a.a(vv4.o.class)).getWebServices());
        if (r103 < 29) goto L29;
        WebViewCompat.setWebViewRenderProcessClient(this, new c(this));     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        tt5.a.e(this.f218510g1, "setWebViewRenderProcessClient failed", th, false);
        return;
    }

    public final boolean G() {
        if (DocOpenConfig.f218559m == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f218537y2.equals(sbb.e.f541304o.getType()) == false) goto L7;
        return true;
    }

    public final void H() {
        com.bytedance.ee.util.ui.m.e(this.f218529s3);
        com.bytedance.ee.util.ui.m.b(this.f218529s3, 120000);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docs.kill_render_process_when_js_blocked") == false) goto L8;
        com.bytedance.ee.util.ui.m.e(this.f218530t3);
        if (this.P1 == true) goto L9;
        long r100 = com.bytedance.ee.bear.document.reloadwebview.a.f221264a.getLoadHtmlTimeOut();
        com.bytedance.ee.util.ui.m.b(this.f218530t3, r100);
        return;
    L9:
        return;
    }

    public final void I() {
        tt5.a.h(this.f218510g1, "destoryView()...");
        c();
        setDocStatus(0);
    }

    public final boolean M() {
        Boolean r100 = this.M1.get(this.f218537y2);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.booleanValue();
    }

    public final Flowable<Boolean> R() {
        tt5.a.h(this.f218510g1, "preloadWebview ");
        setDocStatus(0);
        this.f218503a3.d();
        this.f218503a3.c(this.f218537y2, null);
        return ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).j(this, true);
    }

    public final void X() {
        if (TextUtils.equals(this.f218537y2, sbb.e.f541298i.getType()) == false) goto L5;
        return;
    L5:
        startNestedScroll(2);
        dispatchNestedPreScroll(0, -2147483647, null, null);
        stopNestedScroll();
    }

    @Override // com.bytedance.ee.bear.webview.fps.FpsWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView
    public final void destroy() {
        tt5.a.h(this.f218510g1, "destroy()... webviewId=" + this.F2);
        this.f218533v2 = null;
        this.f218535x2 = null;
        this.O2 = null;
        this.f218537y2 = sbb.e.f541296g.getType();
        tt5.a.h(this.f218510g1, "clearRenderParams");
        ((HashMap) this.V2).clear();
        LiveData<ConnectionService.NetworkState> r100 = this.Z2;
        if (r100 == null) goto L5;
        r100.removeObserver(this.f218527q3);
    L5:
        this.L1.e().removeObserver(this.f218528r3);
        n25.c r101 = this.f218525p2;
        if (r101 == null) goto L12;
        n25.a r102 = r101.f516703b;
        if (r102 == null) goto L12;
        tt5.a.h(r102.f516714b, MapMonitorConst.EVENT_DESTROY);
        ConcurrentHashMap<String, String> r103 = r102.f516718f;
        if (r103 == null) goto L12;
        r103.clear();
    L12:
        com.bytedance.ee.util.ui.m.e(this.f218529s3);
        com.bytedance.ee.util.ui.m.e(this.f218530t3);
        super.destroy();
    }

    public String getObjToken() {
        Serializable r100 = this.V2.get("wikiInfo");
        if (r100 != null) goto L5;
    L8:
        BearUrl r101 = this.f218535x2;
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101.f222561b;
    L5:
        if ((r100 instanceof WikiInfo) == false) goto L8;
        return ((WikiInfo) r100).getObjToken();
    }

    public String getPerformanceTiming() {
        otb.e r100 = this.f218531u3;
        if (r100 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        r100.getPerformanceTiming();
        return null;
    }

    public ConcurrentHashMap<String, String> getResPath() {
        n25.c r100 = this.f218525p2;
        if (r100 == null) goto L10;
        tt5.a.h(r100.f516702a, "getResPath()...");
        n25.a r101 = r100.f516703b;
        if (r101 == null) goto L8;
        return r101.f516718f;
    L8:
        return new ConcurrentHashMap();
    L10:
        return new ConcurrentHashMap();
    }

    public long getWebviewStatusCode() {
        otb.e r100 = this.f218531u3;
        if (r100 != null) goto L6;
        return -999;
    L6:
        r100.getLoadingStatusCode();
        return 0;
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView
    public final void goBack() {
        WebBackForwardList r100 = copyBackForwardList();
        if (r100 == null) goto L9;
        int r101 = r100.getCurrentIndex();
        if (r101 <= 1) goto L9;
        WebHistoryItem r102 = r100.getItemAtIndex(r101 - 1);
        if (r102 == null) goto L9;
        final String r103 = r102.getOriginalUrl();
    L10:
        super.goBack();
        JSONObject r104 = new JSONObject();
        r104.put2("url", Q(r103));
        F("javascript:replace", r104);
        getRenderCallbacks().subscribe(new u0(r103), new e1(this));
        return;
    L9:
        r103 = "";
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, com.bytedance.ee.bear.jsbridge.BridgeWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b2 r100 = new b2(this.G1);
        this.S1 = r100;
        if (r100.f219148e == true) goto L5;
        tt5.a.h("DocWebPerfMonitor", "monitorOn is false");
    L6:
        tt5.a.h(this.f218510g1, "onAttachedToWindow()...");
        this.f218514h2 = true;
        onResume();
        return;
    L5:
        b2.f219143f++;
        r100.f219147d = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new c2(r100, new Ref.IntRef()), 0, 5, TimeUnit.SECONDS);
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, com.bytedance.ee.bear.webview.fps.FpsWebViewV2, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b2 r100 = this.S1;
        if (r100 == null) goto L13;
        String r101 = getObjToken();
        if ((((HashMap) this.V2).get("wikiInfo") instanceof WikiInfo) == false) goto L7;
        String r102 = sbb.e.f541303n.getType();
    L8:
        String r103 = this.f218537y2;
        if (r100.f219148e == false) goto L12;
        r100.b();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d2(r100, r101, r102, r103));
    L12:
        this.S1 = null;
        goto L13
    L7:
        r102 = this.f218537y2;
    L13:
        setGetSSRScrollPosListner(null);
        boolean r104 = M();
        WeakReference<Fragment> r105 = this.V1;
        if (r105 != null) goto L16;
    L19:
        FragmentActivity r106 = null;
    L20:
        boolean r107 = true;
        if (r106 == null) goto L25;
        Intent r108 = r106.getIntent();
        if (r108 == null) goto L25;
        r107 = r108.getBooleanExtra("clear_res", true);
    L25:
        tt5.a.h(this.f218510g1, "onDetachedFromWindow()... isReay = " + r104);
        setHostFragment(null);
        if (r104 == false) goto L29;
        if (r107 == false) goto L29;
        tt5.a.h(this.f218510g1, "recycle()... clear");
        clearHistory();
        F("javascript:clear", null);
        evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
    L29:
        this.f218514h2 = false;
        JSONObject r109 = new JSONObject();
        r109.put2(WikiFolderPushPlugin.OPT, "nativeClearIO");
        r109.put2("webviewId", this.F2);
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).a(r109.toString());
        return;
    L16:
        if (r105.get() == null) goto L19;
        r106 = this.V1.get().getActivity();
        goto L20
    }

    public BearUrl getBearUrl() {
        return this.f218535x2;
    }

    public u1 getDocStateTracker() {
        return this.f218520l3;
    }

    public int getDocStatus() {
        return this.S2;
    }

    public n25.c getOfflineEngine() {
        return this.f218525p2;
    }

    public int getUsedCount() {
        return this.f218508e3;
    }

    public vv4.n getWebServiceManager() {
        return this.f218519k3;
    }

    public Map<Integer, Boolean> getWebViewActiveMap() {
        return this.f218517j3;
    }

    public String getWebViewId() {
        return this.F2;
    }

    public long getmLoadHtmlStartTime() {
        return this.P2;
    }

    @Override // android.view.View
    public final boolean isInEditMode() {
        return this.T1;
    }

    public DocBridgeWebViewV2(Context r100) {
        super(r100);
        this.f218510g1 = "DocBridgeWebViewV2_" + hashCode();
        this.f218513h1 = 0;
        this.f218518k1 = false;
        this.f218524p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.f218504b2 = new CopyOnWriteArrayList();
        this.f218537y2 = sbb.e.f541296g.getType();
        this.F2 = UUID.randomUUID().toString();
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = SieveCacheKt.NodeLinkMask;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.f218508e3 = 0;
        this.f218509f3 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.slides_enabled");
        this.f218512g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        this.f218515h3 = true;
        this.f218516i3 = true;
        this.f218517j3 = new HashMap();
        this.f218519k3 = new vv4.n();
        this.f218520l3 = new u1();
        this.f218521m3 = false;
        this.f218522n3 = false;
        this.f218523o3 = false;
        this.f218527q3 = new d(this);
        this.f218528r3 = new e(this);
        this.f218529s3 = new f(this);
        this.f218530t3 = new g();
        r();
    }

    public static void A(final DocBridgeWebViewV2 r100) {
        r100.getClass();
        int r101 = f218501x3;
        DocOpenConfig.a();
        if (r101 >= DocOpenConfig.f218553g.reload_max_num) goto L5;
        f218501x3++;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).d(r100).subscribe(new y(r100), new j0(r100));
        return;
    L5:
        String r102 = r100.f218510g1;
        StringBuilder r103 = new StringBuilder("reloadWebviewRunnable====== sReloadNum: ");
        r103.append(f218501x3);
        r103.append("  DocOpenConfig.getReloadMaxNum()： ");
        DocOpenConfig.a();
        r103.append(DocOpenConfig.f218553g.reload_max_num);
        tt5.a.k(r102, r103.toString());
    }

    public static void B(final DocBridgeWebViewV2 r100) {
        tt5.a.h(r100.f218510g1, "downloadFullResource onReady");
        r100.getRenderCallbacks().subscribe(new c1(r100), new d1(r100));
        r100.R().subscribe(new a1(r100), new b1(r100));
    }

    private synchronized void setDocStatus(int r100) {
        monitor-enter(this);
        tt5.a.h(this.f218510g1, "setDocStatus(): " + r100);     // Catch: Throwable -> L7
        this.S2 = r100;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean z(DocBridgeWebViewV2 r100) {
        r100.getClass();
        boolean r101 = false;
        if (p15.a.a() == false) goto L14;
        StringBuilder r102 = new StringBuilder("isMainJSModulesReady()... ");
        OperationRecord r103 = com.bytedance.ee.bear.document.forecast.a.f219926a;
        Iterator r104 = com.bytedance.ee.bear.document.forecast.a.b(DocOpenConfig.e()).iterator();
    L5:
        boolean r105 = true;
    L7:
        if (r104.hasNext() == false) goto L13;
        String r106 = (String) r104.next();
        boolean r107 = Boolean.TRUE.equals(((HashMap) r100.M1).get(r106));
        r102.append(", ");
        r102.append(r106);
        r102.append(": ");
        r102.append(r107);
        if (r105 == false) goto L12;
        if (r107 == true) goto L5;
    L12:
        r105 = false;
        goto L7
    L13:
        tt5.a.h(r100.f218510g1, r102.toString());
        return r105;
    L14:
        Boolean r108 = (Boolean) ((HashMap) r100.M1).get(sbb.e.f541304o.getType());
        Boolean r109 = (Boolean) ((HashMap) r100.M1).get(sbb.e.f541297h.getType());
        Boolean r110 = (Boolean) ((HashMap) r100.M1).get(sbb.e.f541296g.getType());
        tt5.a.h(r100.f218510g1, "isDocAndSheetReady()... ret1: " + r108 + "   ret2: " + r109 + "   ret3: " + r110);
        if (r108 == null) goto L26;
        if (r109 == null) goto L26;
        if (r110 == null) goto L26;
        if (r108.booleanValue() == false) goto L26;
        if (r109.booleanValue() == false) goto L26;
        if (r110.booleanValue() == false) goto L26;
        r101 = true;
    L26:
        return r101;
    }

    public final void C(com.bytedance.ee.bear.contract.m0 r100) {
        l<com.bytedance.ee.bear.contract.m0> r101 = new l(r100);
        if (this.f218504b2.contains(r101) == true) goto L6;
        this.f218504b2.add(r101);
        return;
    }

    public final void D(p35.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<p35.f> r101 = f218499v3;
        if (((CopyOnWriteArrayList) r101).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) r101).add(r100);
        return;
    }

    public final boolean N(String r100) {
        Boolean r101 = this.M1.get(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.booleanValue();
    }

    public final String Q(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String r101 = UriProtector.parse(r100).getPath();
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r102 = r100.indexOf(r101);
        if (r102 != (-1)) goto L10;
    L14:
        return "";
    L10:
        if (r102 > r100.length()) goto L14;
        return r100.substring(r102);
    L15:
        return null;
    }

    public final void S(com.bytedance.ee.bear.contract.m0 r100) {
        this.f218504b2.remove(new l(r100));
    }

    public final void T(WebViewClient r100) {
        ((CopyOnWriteArrayList) this.W2.f557386e).remove(r100);
    }

    public final void V(String r100) {
        this.f218521m3 = true;
        this.G1.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_from", "native");
        JSONObject r101 = JSON.parseObject(r100);
        tt5.a.h(this.f218510g1, "renderCacheHTML(): connected = " + this.f218507d3);
        int r102 = 50;
        if (this.f218507d3 == true) goto L5;
        r102 = 50 + getTipLayoutHeight();
    L5:
        r101.put2("deviceInfo", JSON.toJSON(new DeviceInfo(this.f218505b3, r102)));
        K(r101, "renderCacheHTML");
        F("javascript:renderCacheHTML", r101);
        getRenderCallbacks().subscribe(new i0(), new k0(this));
    }

    public final boolean W(boolean r110) {
        if (M() == false) goto L6;
        setDocStatus(1);
        U(1, r110);
        return true;
    L6:
        this.Q1 = true;
        boolean r111 = s1.f221470n;
        s1.f221480x = System.currentTimeMillis();
        boolean r100 = false;
        if (this.M2 == false) goto L24;
        n25.c r112 = this.f218525p2;
        tt5.a.h(r112.f516702a, "isSlim()...");
        n25.a r113 = r112.f516703b;
        if (r113 == null) goto L11;
        r100 = r113.f516732t;
    L11:
        boolean r114 = ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).j();
        tt5.a.h(this.f218510g1, "***reportOpenDoc*** loadUrlRenderIfNeed()... getWebviewStatusCode: " + getWebviewStatusCode() + ", isSlim: " + r100 + ", hasFullResource: " + r114);
        List<String> r101 = DocOpenConfig.f218548b;
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r103 = r102.g("ccm.mobile.full_pkg_included");
        tt5.a.h(this.f218510g1, "isFullPkgIncluded " + r103);
        if (r101.contains(this.f218537y2) == true) goto L22;
        if (r100 == false) goto L22;
        if (r103 == true) goto L22;
        if (r114 == false) goto L18;
        getRenderCallbacks().subscribe(new t0(), new v0(this));
        R().subscribe(new a1(this), new b1(this));
    L23:
        return true;
    L18:
        getRenderCallbacks().subscribe(new w0(), new x0(this));
        tt5.a.h(this.f218510g1, "downloadFullResource ");
        if (r102.g("ccm.mobile.full_pkg_included") == false) goto L21;
        tt5.a.h(this.f218510g1, "isFullPkgIncluded true");
        goto L23
    L21:
        com.bytedance.ee.bear.doc.resupdate.g r115 = (com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class);
        r115.h(new n1(this));
        r115.e(EChannel.DOCS_FULLPKG_CHANNEL, new o1(this, r115));
    L22:
        this.f218503a3.c(this.f218537y2, null);
        getRenderCallbacks().subscribe(new r0(), new s0(this));
        goto L23
    L24:
        return false;
    }

    public final void Y(ConnectionService.NetworkState r100) {
        tt5.a.h(this.f218510g1, "updateNetworkState:" + r100);
        if (r100 != null) goto L6;
        tt5.a.f(this.f218510g1, new IllegalArgumentException("updateNetworkState with null state"), false);
        return;
    L6:
        this.f218507d3 = r100.a();
        if (M() == true) goto L10;
        tt5.a.d(this.f218510g1, "updateNetworkState while JsBridge hasn't ready");
        return;
    L10:
        JSONObject r101 = new JSONObject();
        r101.put2("type", Integer.valueOf(r100.getType()));
        r101.put2(PTYSocketStateCallback.CONNECTED, Boolean.valueOf(r100.a()));
        F("javascript:window.native.setNetworkState", r101);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void loadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        iu5.d.a(this.f218510g1, new IllegalArgumentException(" url is empty!!!"));
        return;
    L7:
        if (r100.startsWith("javascript:") == false) goto L10;
        p(r100, true);
        return;
    L10:
        if (this.f218524p1 == false) goto L13;
        p(r100, false);
    L16:
        X();
        return;
    L13:
        if (this.f218518k1 == false) goto L15;
        HashMap r101 = new HashMap();
        r101.put("Env", "Pre_release");
        super.loadUrl(r100, r101);
        goto L16
    L15:
        p(r100, false);
        goto L16
    }

    @Override // android.webkit.WebView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (this.f218515h3 == false) goto L8;
        if (r101 != null) goto L7;
        return null;
    L7:
        return new k(r101);
    L8:
        return r101;
    }

    @Override // com.bytedance.ee.bear.browser.WebViewV2, android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        tt5.a.h(this.f218510g1, "onWindowFocusChanged: " + r100);
        super.onWindowFocusChanged(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        tt5.a.h(this.f218510g1, "onWindowVisibilityChanged  visibility: " + r100);
    }

    public void setGetSSRScrollPosListner(com.bytedance.ee.bear.document.ssrrender.a.b r100) {
        this.f218512g3.f221906a = r100;
    }

    public void setHostFragment(Fragment r100) {
        String r101 = this.f218510g1;
        StringBuilder r102 = new StringBuilder("setHostFragment() fragment null is ");
        if (r100 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        tt5.a.h(r101, r102.toString());
        this.V1.clear();
        this.V1 = new WeakReference(r100);
        if (r100 != null) goto L11;
        Context r104 = getContext();
        FileChooseHandlerV2 r105 = this.X2.f561052c;
        if (r105 == null) goto L15;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105.f242914a = r104;
        return;
    L15:
        return;
    L11:
        FragmentActivity r106 = r100.getActivity();
        FileChooseHandlerV2 r107 = this.X2.f561052c;
        if (r107 == null) goto L17;
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        r107.f242914a = r106;
        return;
    L17:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void setReadyCallback(j r100) {
        this.Y2 = r100;
    }

    public void setReadyStatus(Boolean r100) {
        tt5.a.h(this.f218510g1, "setReadyStatus()...  status： " + r100);
        this.M1.put(sbb.e.f541296g.getType(), r100);
        this.M1.put(sbb.e.f541303n.getType(), r100);
        this.M1.put(sbb.e.f541297h.getType(), r100);
        this.M1.put(sbb.e.f541300k.getType(), r100);
        this.M1.put(sbb.e.f541304o.getType(), r100);
        this.M1.put(sbb.e.f541298i.getType(), r100);
        this.M1.put(sbb.e.f541301l.getType(), r100);
        if (this.f218509f3 == false) goto L6;
        this.M1.put(sbb.e.f541302m.getType(), r100);
        return;
    }

    public void setRenderParams(Map<String, Serializable> r100) {
        tt5.a.h(this.f218510g1, "setRenderParams:" + r100);
        if (r100 == null) goto L6;
        this.V2.putAll(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100) {
        return v(r100, -1);
    }

    public DocBridgeWebViewV2(Context r110, String r111) {
        super(r110);
        String r112 = "DocBridgeWebViewV2_" + hashCode();
        this.f218510g1 = r112;
        this.f218513h1 = 0;
        this.f218518k1 = false;
        this.f218524p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.f218504b2 = new CopyOnWriteArrayList();
        this.f218537y2 = sbb.e.f541296g.getType();
        String r100 = UUID.randomUUID().toString();
        this.F2 = r100;
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = SieveCacheKt.NodeLinkMask;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.f218508e3 = 0;
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f218509f3 = r101.g("ccm.mobile.slides_enabled");
        this.f218512g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        boolean r102 = true;
        this.f218515h3 = true;
        this.f218516i3 = true;
        this.f218517j3 = new HashMap();
        this.f218519k3 = new vv4.n();
        this.f218520l3 = new u1();
        this.f218521m3 = false;
        this.f218522n3 = false;
        this.f218523o3 = false;
        d r103 = new d(this);
        this.f218527q3 = r103;
        e r104 = new e(this);
        this.f218528r3 = r104;
        this.f218529s3 = new f(this);
        this.f218530t3 = new g();
        this.f218511g2 = r111;
        tt5.a.h(r112, "Native init webViewId=" + r100);
        if (TextUtils.isEmpty(r111) == true) goto L5;
        this.f218510g1 = r112 + "_" + r111;
    L5:
        this.H1 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        com.bytedance.ee.bear.contract.j r113 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f218534x1 = r113;
        this.G1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.f218536y1 = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class);
        com.bytedance.ee.bear.contract.f r114 = (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class);
        this.L1 = r114;
        iu5.f.a(new e0(this));
        ml5.b r105 = new ml5.b("debug_config");
        this.f218532v1 = r105;
        this.L2 = ((Boolean) r105.a("show_doc_size_toast", Boolean.FALSE)).booleanValue();
        boolean r106 = getRenderSwitch();
        this.K2 = r106;
        this.U2 = getFirstNotRenderSwitch();
        boolean r107 = ((Boolean) r105.a("resourceIntercept", Boolean.TRUE)).booleanValue();
        this.M2 = r107;
        boolean r108 = eu5.c.d();
        this.I2 = r108;
        tt5.a.h(this.f218510g1, "mIsDebug: " + r108);
        if (r107 == true) goto L9;
        if (r106 == true) goto L9;
    L10:
        this.f218523o3 = r102;
        tt5.a.h(this.f218510g1, "isOfflineOpen: " + r107 + " isRenderOpen: " + r106);
        BridgeWebViewV2.E = r101.i("spacekit.mobile.webviewbridge.run.on.main.thread", false);
        tt5.a.h(this.f218510g1, "shandlerRunOnUIThread =  " + BridgeWebViewV2.E);
        DocOpenConfig.h();
        r();
        l35.k r109 = l35.k.a.f507260a;
        LiveData<ConnectionService.NetworkState> r115 = r113.a();
        this.Z2 = r115;
        r115.observeForever(r103);
        r114.e().observeForever(r104);
        String r116 = this.f218510g1;
        StringBuilder r117 = new StringBuilder("init end TTWebViewUtil.isTTWebView: false   this: ");
        TTWebViewUtil.a.d(this);
        r117.append(this);
        tt5.a.h(r116, r117.toString());
        return;
    L9:
        r102 = false;
        goto L10
    }

    private ActionMode v(ActionMode.Callback r100, int r101) {
        WeakReference<Fragment> r102 = this.V1;
        if (r102 != null) goto L5;
    L8:
        FragmentActivity r103 = null;
    L9:
        if (r103 != null) goto L11;
    L22:
        tt5.a.k(this.f218510g1, "startActionMode while not active !");
        return null;
    L11:
        if (r103.isFinishing() == true) goto L22;
        tt5.a.h(this.f218510g1, "DocBridgeWebView start actionMode");     // Catch: Exception -> L19
        if (com.larksuite.framework.utils.x.a() == false) goto L18;
        return v(r100, r101);
    L18:
        return v(r100, -1);
    L19:
        e = move-exception;
        tt5.a.e(this.f218510g1, "DocBridgeWebView start actionMode exception ", e, false);
        return null;
    L5:
        if (r102.get() == null) goto L8;
        r103 = this.V1.get().getActivity();
        goto L9
    }

    public static /* synthetic */ void x(final DocBridgeWebViewV2 r100, final String r101) {
        tt5.a.h(r100.f218510g1, "***reportOpenDoc*** ValueCallback value: " + r101);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.bitable.base.disable.performance_log") == true) goto L6;
        r100.getRenderCallbacks().subscribe(new y0(r101), new z0(r100));
        return;
    }

    public final void E(String r100, Serializable r101) {
        tt5.a.h(this.f218510g1, "addRenderParams:".concat(r100));
        ((HashMap) this.V2).put(r100, r101);
    }

    public final void F(String r100, JSONObject r101) {
        if (r100.startsWith("javascript:") == false) goto L6;
        o(r100, r101, true);
        return;
    L6:
        if (this.f218524p1 == false) goto L9;
        o(r100, r101, false);
    L12:
        X();
        return;
    L9:
        if (this.f218518k1 == false) goto L11;
        String r102 = mu5.b.d(r100, r101);
        HashMap r103 = new HashMap();
        r103.put("Env", "Pre_release");
        super.loadUrl(r102, r103);
        goto L12
    L11:
        o(r100, r101, false);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long J(String r100, String r101) {
        String r102 = this.G1.e(r100, r101);
        if (r102 != 0) goto L6;
        return 0;
    L6:
        if ((r102 instanceof Number) == false) goto L14;
        long r103 = ((Number) r102).longValue();
    L10:
        return System.currentTimeMillis() - (SystemClock.uptimeMillis() - r103);
    L14:
        r103 = CastLongProtector.parseLong(r102);     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        tt5.a.l(this.f218510g1, "getWallClockFromUptimeData parse failed, dataTag = " + r100 + ", dataKey = " + r101, e);
        return 0;
    }

    public final void K(JSONObject r100, String r101) {
        BearUrl r102 = this.f218535x2;
        String r103 = null;
        if (r102 != null) goto L6;
        String r104 = null;
    L10:
        if (AppInfoUtils.e().booleanValue() == false) goto L12;
        r103 = DocAppIdConst.Mempope.value;
    L16:
        JSONObject r105 = DocComponentConfig.getSceneConfig(r103);
        if (r105 == null) goto L19;
        r100.put2(DocComponentConfig.KEY_INJECT_WEB, r105);
    L19:
        JSONObject r106 = DocComponentConfig.getPatchSettingConfig(this.V1);
        if (r106 == null) goto L22;
        r100.put2(DocComponentConfig.KEY_INJECT_WEB_PATCH, r106);
    L22:
        tt5.a.h(this.f218510g1, r101 + " inject docComponentConfig=" + r105 + " sceneId=" + r103 + " updateSettingConfig=" + r106);
        return;
    L12:
        tt5.a.h(this.f218510g1, "injectDocComponentConfig: sceneId=" + r104);
        if (TextUtils.equals(r104, DocAppIdConst.Mempope.value) == true) goto L16;
        r103 = r104;
        goto L16
    L6:
        if (TextUtils.isEmpty(r102.f222577r) == true) goto L8;
        r104 = this.f218535x2.f222577r;
        goto L10
    L8:
        r104 = this.f218535x2.f222576q;
        goto L10
    }

    public final void P(final boolean r100, final int r101) {
        tt5.a.k(this.f218510g1, "onRenderProcessGone====== isAttachedToWindow: " + this.f218514h2);
        com.bytedance.ee.util.ui.m.a(new h0(r100, r101));
    }

    public final void U(int r110, boolean r111) {
        String r100 = Q(this.f218533v2);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        tt5.a.k(this.f218510g1, "***reportOpenDoc*** doRender: parsed url is null uri = " + this.f218533v2);
        return;
    L5:
        tt5.a.h(this.f218510g1, "***reportOpenDoc*** doRender url = " + r100.hashCode());
        boolean r101 = true;
        this.f218522n3 = true;
        AccountService$Account r102 = this.f218536y1.G2();
        if (r102 == null) goto L76;
        JSONObject r103 = new JSONObject();
        r103.put2("userId", r102.uid);
        r103.put2("tenantId", r102.tenantId);
        r103.put2("departmentId", r102.departmentId);
        r103.put2("isPreloadFinished", Integer.valueOf(r110));
        if (h18.f.a(eu5.b.f474075a) == false) goto L10;
        Object r112 = "dark";
    L11:
        r103.put2("theme", r112);
        BearUrl r113 = this.f218535x2;
        if (r113 == null) goto L17;
        String r114 = r113.f222561b;
        ScrollData r104 = (ScrollData) ((HashMap) c25.d.f22198a).get(r114);
        if (r104 != null) goto L16;
        r104 = new ScrollData();
        r104.setToken(r114);
        r104.setX(0);
        r104.setY(0);
    L16:
        r103.put2("x", Integer.valueOf(r104.getX()));
        r103.put2("y", Integer.valueOf(r104.getY()));
    L17:
        JSONObject r115 = new JSONObject();
        r115.put2("tap", Long.valueOf(f218500w3));
        r115.put2("invokeRender", Long.valueOf(System.currentTimeMillis()));
        r115.put2("preloadStart", 0L);
        r115.put2("webviewLoadUrl", Long.valueOf(this.P2));
        r115.put2("nativeWaitPreloadStart", Long.valueOf(J("wait_preload", ILoadStallMonitor.START_TIME)));
        r115.put2("nativeHtmlReady", Long.valueOf(J("wait_preload_html", "end_time")));
        r115.put2("nativeJsReady", Long.valueOf(this.R2));
        r103.put2("timestamp", r115);
        String r116 = this.f218535x2.f222561b;
        Map<String, JSONObject> r105 = d25.d.f466515b;
        if (((JSONObject) ((HashMap) r105).get(r116)) != null) goto L20;
        r103.put2("prefetchData", "");
    L21:
        r103.put2("title", this.E2);
        r103.put2("nativeWebviewId", this.F2);
        r103.put2("editorId", this.F2);
        r103.put2("isDebug", Boolean.valueOf(this.I2));
        r103.put2("isShowDocumentSize", Boolean.valueOf(this.L2));
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.a() == true) goto L24;
    L26:
        boolean r117 = false;
    L27:
        r103.put2("preFetchClientvarEnable", Boolean.valueOf(r117));
        boolean r118 = this.f218521m3;
        BearUrl r106 = this.f218535x2;
        String r107 = r106.f222577r;
        String r108 = r106.f222560a;
        boolean r109 = ((HashMap) this.V2).get("wikiInfo") instanceof WikiInfo;
        if (((HashMap) this.V2).containsKey("renderSSRWebviewType") == false) goto L30;
    L32:
        if (r118 == false) goto L34;
    L37:
        int r119 = 0;
    L38:
        if (r111 == true) goto L40;
    L43:
        boolean r120 = false;
    L44:
        r103.put2("shouldRenderCacheHtml", Boolean.valueOf(r120));
        if (TextUtils.equals(this.f218537y2, sbb.e.f541304o.getType()) == false) goto L48;
        r103.put2("renderSSRWebviewType", Integer.valueOf(r119));
    L48:
        if (this.f218535x2.f222564e.contains("/sync/") == false) goto L50;
        r103.put2("syncBlockSourceToken", this.f218535x2.f222561b);
    L50:
        String r121 = this.f218510g1;
        StringBuilder r122 = new StringBuilder("shouldRenderCacheHtml = ");
        if (r111 == true) goto L53;
    L55:
        r101 = false;
    L56:
        r122.append(r101);
        tt5.a.b(r121, r122.toString());
        r103.putAll(this.V2);
        Object r123 = this.G2;
        if (r123 == null) goto L59;
        r103.put2("versionInfo", r123);
    L61:
        if (TextUtils.isEmpty(this.H2) == true) goto L63;
        r103.put2("associateAppUrl", this.H2);
    L63:
        K(r103, ChameleonOpenTracker.Stage.RENDER);
        JSONObject r124 = new JSONObject();
        r124.put2("url", r100);
        r124.put2("infos", r103);
        t45.c r125 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        s45.l r126 = r125.m8(this.f218533v2);
        String r127 = r125.m4(r126);
        String[] r128 = r125.U3(r126);
        if (r126 != null) goto L66;
    L71:
        r124.put2("srcHost", r126.f540578c);
        r124.put2("srcUrl", this.f218533v2);
        StringBuilder r129 = new StringBuilder(r124.toString());
        if (TextUtils.isEmpty(this.N2) == false) goto L74;
        r129.insert(r129.indexOf("infos\":{") + 8, "\"clientvars\":\"\",");
    L75:
        String r130 = r129.toString();
        boolean r131 = s1.f221470n;
        s1.f221480x = System.currentTimeMillis();
        evaluateJavascript("javascript:render(" + r130 + ")", new l0(this));
    L77:
        getRenderCallbacks().subscribe(new o0(), new p0(this));
        X();
        return;
    L74:
        r129.insert(r129.indexOf("infos\":{") + 8, "\"clientvars\":" + this.N2 + ",");
        goto L75
    L66:
        if (TextUtils.isEmpty(r127) == true) goto L71;
        if (r128 == null) goto L71;
        tt5.a.h(this.f218510g1, "render inject mg domain info, apiUrl=" + r127 + " frontierDomain=" + Arrays.toString(r128));
        r124.put2("docsApiPrefix", r127);
        r124.put2("frontierDomain", r128);
        r124.put2(Scraps.INNER_UNIT, r126.f540576a);
        String r132 = r126.f540577b;
        if (r132 == null) goto L71;
        r124.put2("brand", r132);
        goto L71
    L59:
        tt5.a.h(this.f218510g1, "versionInfo null");
        goto L61
    L53:
        if (this.f218521m3 == true) goto L55;
    L40:
        if (this.f218521m3 == true) goto L43;
        if (r119 == 1) goto L43;
        r120 = true;
        goto L44
    L34:
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.f(r107, r108, r109) == false) goto L37;
        r119 = 1;
        goto L38
    L30:
        if (DocOpenConfig.f().enable_after_render == true) goto L32;
    L24:
        if (TextUtils.equals(sbb.e.f541304o.getType(), this.f218537y2) == false) goto L26;
        r117 = true;
        goto L27
    L20:
        r103.put2("prefetchData", (JSONObject) ((HashMap) r105).get(this.f218535x2.f222561b));
        goto L21
    L10:
        r112 = "light";
        goto L11
    L76:
        tt5.a.d(this.f218510g1, "***reportOpenDoc*** onCallJsRender()... account is empty ");
        boolean r133 = s1.f221470n;
        s1.f221480x = System.currentTimeMillis();
        final DocException r134 = new DocException(-51, "account is empty");
        getRenderCallbacks().subscribe(new m0(r134), new n0(this));
        goto L77
    }

    @Override // x35.e
    public final void a(Integer r100, final Map<String, String> r101) {
        if (r100.intValue() != 2) goto L16;
        if (r101 == null) goto L42;
        String r102 = String.valueOf(r101.get("stage"));
        if (TextUtils.equals(r102, "render_doc") == false) goto L9;
        this.f218520l3.d();
        return;
    L9:
        if (TextUtils.equals(r102, "pull_data") == false) goto L12;
        this.f218520l3.g();
        return;
    L12:
        if (TextUtils.equals(r102, IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE) == false) goto L14;
        this.f218520l3.c();
        return;
    L14:
        tt5.a.k(this.f218510g1, "onReceiveFrontEvent start stage: ".concat(r102));
        return;
    L42:
        return;
    L16:
        if (r100.intValue() != 3) goto L47;
        if (r101 == null) goto L48;
        String r103 = String.valueOf(r101.get("stage"));
        String r104 = String.valueOf(r101.get("docs_result_key"));
        String r105 = String.valueOf(r101.get("docs_result_code"));
        if (TextUtils.equals("other", r104) == true) goto L21;
    L23:
        boolean r106 = false;
    L25:
        if (TextUtils.equals(r103, "render_doc") == false) goto L30;
        if (r106 == false) goto L28;
        this.f218520l3.h();
        getRenderCallbacks().subscribe(new i1(r101), new j1(this));
        return;
    L28:
        final DocException r107 = new DocException(yu5.c.f(r105, -53), "Err in render doc");
        getRenderCallbacks().subscribe(new k1(r107, r101), new z(this));
        return;
    L30:
        if (TextUtils.equals(r103, "pull_data") == false) goto L35;
        if (r106 == false) goto L33;
        this.f218520l3.a();
        return;
    L33:
        final DocException r108 = new DocException(yu5.c.f(r105, -54), "Err in pull data");
        getRenderCallbacks().subscribe(new a0(r108, r101), new b0(this));
        return;
    L35:
        if (TextUtils.equals(r103, IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE) == true) goto L37;
        tt5.a.k(this.f218510g1, "onReceiveFrontEvent end stage: ".concat(r103));
        return;
    L37:
        if (idb.f.a().isEnable("ccm.bitable.docx_base.optimized.enable") == false) goto L39;
        getRenderCallbacks().subscribe(new c0(), new d0(this));
    L39:
        this.f218520l3.e();
        return;
    L21:
        if (TextUtils.equals(r105, "0") == false) goto L23;
        r106 = true;
        goto L25
    L48:
        return;
    }

    @Override // android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (this.f218516i3 == false) goto L9;
        if (r101.getKeyCode() != 61) goto L9;
        dispatchKeyEvent(r101);
        return true;
    L9:
        return super.onKeyPreIme(r100, r101);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        if (r100.equals(this) == true) goto L7;
        return;
    L7:
        if (this.f218513h1 != 0) goto L12;
        this.f218513h1 = getBottom();
        tt5.a.h(this.f218510g1, "onVisibilityChanged: mOriBottom=" + this.f218513h1);
        return;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int r100, Rect r101) {
        return super.requestFocus(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, android.view.View, zv4.b
    public final ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        return v(r100, r101);
    }

    public DocBridgeWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f218510g1 = "DocBridgeWebViewV2_" + hashCode();
        this.f218513h1 = 0;
        this.f218518k1 = false;
        this.f218524p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.f218504b2 = new CopyOnWriteArrayList();
        this.f218537y2 = sbb.e.f541296g.getType();
        this.F2 = UUID.randomUUID().toString();
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = SieveCacheKt.NodeLinkMask;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.f218508e3 = 0;
        this.f218509f3 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.slides_enabled");
        this.f218512g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        this.f218515h3 = true;
        this.f218516i3 = true;
        this.f218517j3 = new HashMap();
        this.f218519k3 = new vv4.n();
        this.f218520l3 = new u1();
        this.f218521m3 = false;
        this.f218522n3 = false;
        this.f218523o3 = false;
        this.f218527q3 = new d(this);
        this.f218528r3 = new e(this);
        this.f218529s3 = new f(this);
        this.f218530t3 = new g();
        r();
    }

    public static void y(final DocBridgeWebViewV2 r100, s1 r101, BridgeReadyModel r110) {
        r100.getClass();
        if (com.bytedance.ee.bear.document.reloadwebview.a.f221273j == false) goto L5;
        com.bytedance.ee.util.ui.m.e(r100.f218530t3);
        com.bytedance.ee.bear.document.reloadwebview.a.f221268e = false;
        com.bytedance.ee.bear.document.reloadwebview.a.f();
    L5:
        n25.c r102 = r100.f218525p2;
        if (r102 != null) goto L8;
    L10:
        tt5.a.h(r100.f218510g1, "***reportPreloadHtml*** BIZ_NOTIFY_READY data = " + r110.toString());
        ((HashMap) r100.M1).put(r110.getType(), Boolean.TRUE);
        if (TextUtils.equals(r110.getType(), r100.f218537y2) == false) goto L13;
        r100.R2 = System.currentTimeMillis();
    L13:
        String r103 = r110.getType();
        long r104 = r100.Q2;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        tt5.a.b("DocReport", "reportJsReady");
        org.json.JSONObject r105 = new org.json.JSONObject();
        r105.put("file_type", r103);     // Catch: Throwable -> L22
        List<String> r106 = s1.D;     // Catch: Throwable -> L22
        if (r106 == null) goto L17;
        int r107 = r106.indexOf(r103);     // Catch: Throwable -> L22
    L18:
        r105.put("ordinal", r107);     // Catch: Throwable -> L22
        r105.put("stage", "js_ready");     // Catch: Throwable -> L22
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docs.forecast_enable_android") == false) goto L24;
        r105.put("render_process_memory", eu5.g.f(eu5.b.f474075a));     // Catch: Throwable -> L22
    L24:
        r101.e(r105, r104);
        if (r100.f218514h2 == true) goto L30;
        if (TextUtils.equals(r110.getType(), sbb.e.f541297h.getType()) == false) goto L30;
        tt5.a.h(r100.f218510g1, "BIZ_NOTIFY_READY onPause");
        r100.onPause();
    L30:
        if (TextUtils.isEmpty(r100.f218533v2) == false) goto L32;
    L43:
        tt5.a.h(r100.f218510g1, "ready()... mPenndingUrl is empty");
    L44:
        r100.Y(r100.f218534x1.getNetworkState());
        d25.d.m(r110.getData(), r110.getType());
        if (TextUtils.equals(r110.getType(), sbb.e.f541296g.getType()) == false) goto L47;
        ((IGetDataCallback) org.koin.java.a.a(IGetDataCallback.class)).onSuccess(Boolean.TRUE);
    L47:
        j r108 = r100.Y2;
        if (r108 == null) goto L53;
        r108.a(r110);
        return;
    L53:
        return;
    L32:
        if (TextUtils.equals(r110.getType(), r100.f218537y2) == false) goto L43;
        r100.getRenderCallbacks().subscribe(new f0(), new g0(r100));
        if (r100.G() == false) goto L36;
    L42:
        r100.setDocStatus(1);
        r100.U(0, r100.Q1);
        r100.Q1 = false;
        goto L44
    L36:
        if (TextUtils.isEmpty(r100.O2) == true) goto L42;
        BearUrl r109 = r100.f218535x2;
        if (r109 == null) goto L42;
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.f(r109.f222577r, r109.f222560a, ((HashMap) r100.V2).get("wikiInfo") instanceof WikiInfo) == true) goto L42;
        tt5.a.h(r100.f218510g1, "renderCacheHTML...  after notify module ready");
        r100.V(r100.O2);
        goto L42
    L17:
        r107 = -1;
    L22:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L24
    L8:
        if (r102.f516703b == null) goto L10;
        n25.g.C = 0;
        n25.g.B = 0;
        goto L10
    }

    public final void O(String r100, String r101, final boolean r102) {
        if (this.f218533v2 != null) goto L6;
        tt5.a.d(this.f218510g1, "url is null!");
        return;
    L6:
        this.N2 = r100;
        this.O2 = r101;
        tt5.a.h(this.f218510g1, "***reportOpenDoc*** loadUrlRenderIfNeed isRenderOpen = " + this.K2 + ", mType " + this.f218537y2 + ", isReady " + M() + ",isOfflineOpen = " + this.M2);
        String r103 = this.G1.e("start_open", ILoadStallMonitor.START_TIME);
        BearUrl r104 = this.f218535x2;
        if (r104 == null) goto L9;
        String r105 = r104.f222561b;
    L10:
        String r106 = this.N2;
        if (r106 != null) goto L13;
        int r107 = -1;
    L14:
        a05.d.a(r105, "client_vars_size", String.valueOf(r107));
        if (r103 != null) goto L18;
        this.G1.j("start_open", ILoadStallMonitor.START_TIME, String.valueOf(System.currentTimeMillis()));
    L18:
        if (this.K2 == true) goto L20;
    L22:
        tt5.a.h(this.f218510g1, "loadUrlRenderIfNeed() use system load url...");
        boolean r108 = s1.f221470n;
        s1.f221480x = System.currentTimeMillis();
        com.bytedance.ee.util.ui.m.d(new q0(this, r102));
        return;
    L20:
        if (W(r102) == false) goto L22;
        return;
    L13:
        r107 = r106.length();
        goto L14
    L9:
        r105 = "";
        goto L10
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
    }

    public final void L(BearUrl r100, String r101, JSONObject r102, String r103) {
        if (r100.f222564e.startsWith("https://") == false) goto L5;
    L7:
        this.f218533v2 = r100.f222564e;
    L8:
        this.f218535x2 = r100;
        this.f218537y2 = r100.f222560a;
        this.E2 = r101;
        this.G2 = r102;
        this.H2 = r103;
        x35.f r104 = this.f218526p3;
        if (r104 == null) goto L13;
        if (r102 != null) goto L12;
        r104.f562354d = null;
        goto L13
    L12:
        r104.f562354d = r102.toString();
    L13:
        String r105 = this.f218535x2.f222567h;
        if (TextUtils.isEmpty(r105) == false) goto L16;
        this.f218533v2 = com.bytedance.ee.util.io.e.a(this.f218533v2, "from", "tab_other");
        r105 = "tab_other";
    L16:
        boolean r106 = s1.f221470n;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        s1.f221471o = r105;
        BearUrl r107 = this.f218535x2;
        s1.f221473q = r107.f222569j;
        if (TextUtils.isEmpty(r107.f222568i) == false) goto L19;
        s1.f221472p = null;
    L20:
        this.f218521m3 = false;
        this.f218522n3 = false;
        tt5.a.h(this.f218510g1, "injectDocInfo()... doc_from=" + r105 + ", type=" + this.f218537y2 + ", mWebViewId=" + this.F2);
        return;
    L19:
        s1.f221472p = this.f218535x2.f222568i;
        goto L20
    L5:
        if (r100.f222564e.startsWith("http://") == true) goto L7;
        this.f218533v2 = "https://" + r100.f222564e;
        goto L8
    }

    @Override // com.bytedance.ee.bear.webview.fps.FpsWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r100, int r110, int r111, int r112) {
        super.onScrollChanged(r100, r110, r111, r112);
        List<l<zv4.f>> r101 = this.J2;
        if (r101 == null) goto L13;
        Iterator r102 = ((CopyOnWriteArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        l r103 = (l) r102.next();
        if (r103 == null) goto L12;
        if (r103.f218546a.get() == null) goto L12;
        ((zv4.f) r103.f218546a.get()).onScrollChange(this, r100, r110, r111, r112);
    L12:
        ((CopyOnWriteArrayList) this.J2).remove(r103);
        goto L6
    L21:
        return;
    }
}
