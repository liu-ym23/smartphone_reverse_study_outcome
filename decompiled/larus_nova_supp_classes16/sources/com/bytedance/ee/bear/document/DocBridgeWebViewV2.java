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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.multitask.ScrollData;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.reloadwebview.JsThreadCheckConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.quality.safe.FileChooseHandlerV2;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.info.DocAppIdConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.utils.LarkContext;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocBridgeWebViewV2 extends WebViewV2 implements x35.e {
    public static final List<p35.f> v3 = null;
    public static long w3;
    public static int x3;
    public static final h1 y3 = null;
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
    public i05.e a3;
    public final List<l<com.bytedance.ee.bear.contract.m0>> b2;
    public int b3;
    public int c3;
    public boolean d3;
    public int e3;
    public final boolean f3;
    public final String g1;
    public final String g2;
    public final com.bytedance.ee.bear.document.ssrrender.a g3;
    public int h1;
    public volatile boolean h2;
    public boolean h3;
    public boolean i3;
    public final Map<Integer, Boolean> j3;
    public boolean k1;
    public final vv4.n k3;
    public final u1 l3;
    public boolean m3;
    public boolean n3;
    public final boolean o3;
    public boolean p1;
    public n25.c p2;
    public x35.f p3;
    public final d q3;
    public final e r3;
    public final f s3;
    public final g t3;
    public otb.e u3;
    public final ml5.b v1;
    public String v2;
    public final com.bytedance.ee.bear.contract.j x1;
    public BearUrl x2;
    public final com.bytedance.ee.bear.contract.h0 y1;
    public String y2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DocStatus {
        public static final int DEFAULT = 0;
        public static final int LOADING = 1;
        public static final int PRELOAD = 2;
    }

    public class a implements ys5.c {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public final st5.o getServiceManager() {
            return new st5.o();
        }

        public final Context getWebViewContext() {
            return this.a.getContext();
        }

        public final LarkWebView getWebView() {
            return this.a;
        }

        public a(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }
    }

    public class b extends ws5.b {
        public final /* synthetic */ DocBridgeWebViewV2 d;

        public final boolean onShowFileChooser(WebView r1, ValueCallback<Uri[]> r2, WebChromeClient.FileChooserParams r3) {
            return false;
        }

        public final boolean onConsoleMessage(ConsoleMessage r5) {
            if (r5.messageLevel().ordinal() > ConsoleMessage.MessageLevel.LOG.ordinal()) goto L5;
        L10:
            return true;
        L5:
            if (TextUtils.isEmpty(r5.message()) == false) goto L7;
        L9:
            tt5.a.h(this.d.g1 + "_js", du5.b.k(r5.message()) + " -- From line " + r5.lineNumber() + du5.b.k(r5.sourceId()));
            goto L10
        L7:
            if (r5.message().contains("name") == false) goto L9;
            return true;
        }

        public b(DocBridgeWebViewV2 r1, a r2) {
            this.d = r1;
            super(r2);
        }

        public final void onProgressChanged(WebView r4, int r5) {
            super.onProgressChanged(r4, r5);
            if (r4 == null) goto L5;
            String r6 = du5.b.k(r4.getUrl());
        L6:
            tt5.a.h(this.d.g1, "onProgressChanged: " + r5 + ", url: " + r6);
            return;
        L5:
            r6 = "";
            goto L6
        }

        public final boolean onJsPrompt(WebView r8, String r9, String r10, String r11, JsPromptResult r12) {
            if (com.bytedance.ee.bear.document.reloadwebview.a.j == false) goto L6;
            com.bytedance.ee.bear.document.reloadwebview.a.f();
        L6:
            if (TextUtils.equals("__featureGatingValue__", r10) == true) goto L8;
        L15:
            String r0 = "{}";
            boolean r1 = false;
            if (TextUtils.equals("__getPendingSSR__", r10) == false) goto L43;
            DocBridgeWebViewV2 r13 = this.d;
            r13.getClass();
            org.json.JSONObject r14 = new org.json.JSONObject();
            String r2 = r13.G1.e("render_cache", "value_render_cache_prompt_count");
        L22:
            th = move-exception;
            tt5.a.f(r13.g1, th, false);
        L24:
            String r3 = DiagramData$RESULT.SUCCESS;
        L25:
            r13.G1.j("render_cache", "value_render_cache_prompt_count", r3);
            AccountService$Account r4 = r13.y1.G2();
            if (r4 == null) goto L55;
            BearUrl r5 = r13.x2;
            if (r5 == null) goto L55;
            String r6 = r5.a;
            Map<String, String> r7 = r5.d;
            FetchClientVarExecutor r16 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
            String r17 = k25.e0.m().n(n35.a.b(r4, r6, r7), r13.x2.b).c;
            if (TextUtils.isEmpty(r17) == true) goto L55;
            int r18 = r17.length();
            DocOpenConfig.a();
            if (r18 <= DocOpenConfig.g.get_pending_ssr_max_length) goto L34;
            r13.G1.j("render_cache", "render_cache_over_limit", DiagramData$RESULT.SUCCESS);
            tt5.a.h(r13.g1 + "_getPendingSSR", "ssr is over limit");
        L35:
            r1 = true;
            goto L55
        L34:
            r13.m3 = false;
            tt5.a.h(r13.g1 + "_getPendingSSR", "success... html cache is " + r17.length());
            r13.G1.j("render_cache", "render_cache_from", "prompt");
            r0 = r17;
        L55:
            r14.put("ssrContent", r0);     // Catch: Throwable -> L38
            r14.put("disable_next_time", r1);     // Catch: Throwable -> L38
        L40:
            tt5.a.b(r13.g1, "ssrContent length is " + r0.length() + " disableNextTime is " + r1);
            r12.confirm(r14.toString());
            return true;
        L38:
            th = move-exception;
            tt5.a.j(r13.g1, th);
            goto L40
        L19:
            if (TextUtils.isEmpty(r2) == true) goto L24;
            r3 = String.valueOf(CastIntegerProtector.parseInt(r2) + 1);     // Catch: Throwable -> L22
            goto L25
        L43:
            if (TextUtils.equals("biz.util.getSSRScrollPos", r10) == false) goto L51;
            tt5.a.h(this.d.g1, "getSSRScrollPos...");
            com.bytedance.ee.bear.document.ssrrender.a r19 = this.d.g3;
            r19.getClass();
            Intrinsics.checkNotNullParameter(r12, "promptReulst");
            if (r19.a != null) goto L47;
            tt5.a.k("SSR_REN_SSRWebViewBridge", "listner is null");
            r12.confirm("{}");
        L50:
            return true;
        L47:
            com.bytedance.ee.bear.document.ssrrender.a.c r110 = new com.bytedance.ee.bear.document.ssrrender.a.c(r12);
            com.bytedance.ee.bear.document.ssrrender.a.b r20 = r19.a;
            if (r20 == null) goto L50;
            r20.a(r110);
            goto L50
        L51:
            tt5.a.h(this.d.g1 + "_onJsPrompt", r10 + "," + r11);
            return false;
        L8:
            if (TextUtils.isEmpty(r11) == true) goto L15;
            boolean r21 = com.bytedance.ee.bear.appsetting.c.a.a.g(r11);
            if (r21 == false) goto L12;
            String r111 = "true";
        L13:
            r12.confirm(r111);
            tt5.a.h(this.d.g1 + "_onJsPromptFg", "key:" + r11 + ", value:" + r21);
            return true;
        L12:
            r111 = "false";
            goto L13
        }
    }

    public class c extends WebViewRenderProcessClient {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public c(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }

        public final void onRenderProcessResponsive(WebView r1, WebViewRenderProcess r2) {
            tt5.a.k(this.a.g1, "onRenderProcessResponsive...");
            com.bytedance.ee.bear.document.reloadwebview.a.f();
        }

        public final void onRenderProcessUnresponsive(WebView r1, WebViewRenderProcess r2) {
            tt5.a.k(this.a.g1, "onRenderProcessUnresponsive...");
        }
    }

    public class d implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public d(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocBridgeWebViewV2 r0 = this.a;
            r0.Y((ConnectionService.NetworkState) r2);
        }
    }

    public class e implements Observer<Boolean> {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public e(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            tt5.a.h(this.a.g1, "init========  isVisible: " + r6 + "  getmLoadHtmlStartTime: " + this.a.getmLoadHtmlStartTime() + "  isReady： " + DocBridgeWebViewV2.z(this.a) + "  isAttachedToWindow： " + this.a.h2);
            if (r6 != Boolean.TRUE) goto L17;
            com.bytedance.ee.util.ui.m.e(this.a.s3);
            com.bytedance.ee.util.ui.m.e(this.a.t3);
            if (this.a.getmLoadHtmlStartTime() != 2147483647L) goto L7;
            return;
        L7:
            if (this.a.h2 == false) goto L12;
            if (DocBridgeWebViewV2.z(this.a) == true) goto L20;
            this.a.H();
            return;
        L20:
            return;
        L12:
            if (DocBridgeWebViewV2.z(this.a) == false) goto L14;
            return;
        L14:
            if ((System.currentTimeMillis() - this.a.getmLoadHtmlStartTime()) <= 120000) goto L16;
            DocBridgeWebViewV2.A(this.a);
            return;
        L16:
            this.a.H();
            return;
        L17:
            com.bytedance.ee.util.ui.m.e(this.a.s3);
            com.bytedance.ee.util.ui.m.e(this.a.t3);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public final void a() {
            tt5.a.k(this.a.g1, "reloadWebviewRunnable====== isAttachedToWindow: " + this.a.h2 + "  isReady： " + DocBridgeWebViewV2.z(this.a) + "   type:  " + this.a.y2);
            if (this.a.h2 == false) goto L8;
            if (DocBridgeWebViewV2.z(this.a) == true) goto L11;
            this.a.H();
            return;
        L11:
            return;
        L8:
            if (DocBridgeWebViewV2.z(this.a) == true) goto L13;
            DocBridgeWebViewV2.A(this.a);
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

        public f(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }
    }

    public class g implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            JsThreadCheckConfig r0 = com.bytedance.ee.bear.document.reloadwebview.a.a;     // Catch: Throwable -> L4
            tt5.a.h("JsThreadChecker", "loadHtmlTimeOut....");     // Catch: Throwable -> L4
            com.bytedance.ee.bear.document.reloadwebview.a.b++;     // Catch: Throwable -> L4
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
        public final /* synthetic */ DocBridgeWebViewV2 a;

        public final st5.o getServiceManager() {
            return new st5.o();
        }

        public final Context getWebViewContext() {
            return this.a.getContext();
        }

        public final LarkWebView getWebView() {
            return this.a;
        }

        public h(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }
    }

    public class i extends WebViewClient {
        public final /* synthetic */ DocBridgeWebViewV2 a;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.lark.webview.container.impl.debug.VConsoleHandler");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

        public i(DocBridgeWebViewV2 r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r5, String r6, Bitmap r7) {
            super.onPageStarted(r5, r6, r7);
            a().getMethod("injectVConsoleIfNeed", new Class[]{WebView.class}).invoke(null, new Object[]{r5});     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.l(this.a.g1, "injectVConsoleIfNeed failed", e);
        }
    }

    public interface j {
        void a(BridgeReadyModel r1);
    }

    public static class k extends InputConnectionWrapper {
        public k(InputConnection r2) {
            super(r2, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r1) {
            return super.sendKeyEvent(r1);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r18, int r19) {
            if ((r18 - r19) != 1) goto L7;
            long r16 = SystemClock.uptimeMillis();
            super.sendKeyEvent(new KeyEvent(r16, r16, 0, 67, 0, 0, -1, 0, 22));
            super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r16, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r18, r19);
        }
    }

    public static class l<T> {
        public final WeakReference<T> a;

        public final int hashCode() {
            T r0 = this.a.get();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public l(T r2) {
            this.a = new WeakReference(r2);
        }

        public final boolean equals(Object r4) {
            T r0 = this.a.get();
            if (r0 != null) goto L6;
            return false;
        L6:
            if ((r4 instanceof l) == true) goto L8;
            return false;
        L8:
            T r5 = ((l) r4).a.get();
            if (r5 != null) goto L11;
            return false;
        L11:
            if (r0 != r5) goto L14;
            return true;
        L14:
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.document.h1] */
    static {
        v3 = new CopyOnWriteArrayList();
        x3 = 0;
        y3 = new h1();
    }

    private boolean getFirstNotRenderSwitch() {
        return ((Boolean) this.v1.a("firstRenderNotAccelerate", Boolean.FALSE)).booleanValue();
    }

    private Flowable<com.bytedance.ee.bear.contract.m0> getRenderCallbacks() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = new ArrayList(this.b2).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        l r2 = (l) r1.next();
        com.bytedance.ee.bear.contract.m0 r3 = (com.bytedance.ee.bear.contract.m0) r2.a.get();
        if (r3 == null) goto L7;
        r0.add(r3);
        goto L4
    L7:
        ((CopyOnWriteArrayList) this.b2).remove(r2);
        goto L4
    L10:
        return Flowable.fromIterable(r0);
    }

    private boolean getRenderSwitch() {
        return ((Boolean) this.v1.a("renderAccelerate", Boolean.TRUE)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.view.ViewGroup, com.bytedance.ee.bear.facade.common.widget.NoNetworkView] */
    private int getTipLayoutHeight() {
        if (this.c3 != 0) goto L6;
        ?? r0 = new NoNetworkView(getContext());
        r0.setTip(getContext().getString(2131887839));
        int r1 = com.bytedance.ee.util.ui.n.a;
        r0.measure(View.MeasureSpec.makeMeasureSpec(1073741823, ShareItemModel.SRC_TINT_UNDEFINED), View.MeasureSpec.makeMeasureSpec(1073741823, ShareItemModel.SRC_TINT_UNDEFINED));
        this.c3 = com.bytedance.ee.util.ui.n.E(r0.getMeasuredHeight());
    L6:
        return this.c3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.ee.bear.document.f1] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.bytedance.ee.bear.document.g1] */
    private void r() {
        setBizType(gt5.d.b);
        at5.a r0 = getBridge();
        i2 r1 = new i2();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.i = r1;
        com.bytedance.ee.bear.contract.b0 r2 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        if (((com.bytedance.ee.bear.contract.z) org.koin.java.a.a(com.bytedance.ee.bear.contract.z.class)).isDebugEnabled(getContext()) == false) goto L5;
        WebView.setWebContentsDebuggingEnabled(true);
    L5:
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 26) goto L8;
        setRendererPriorityPolicy(2, false);
    L8:
        setReadyStatus(Boolean.FALSE);
        this.D.c("biz.content.editMode", new tb5.k(new p1(this)));
        x35.f r4 = new x35.f(this.l3, this.G1, this.H1.e(), this);
        this.p3 = r4;
        this.D.c("biz.statistics.sendEvent", new tb5.k(r4));
        setHorizontalScrollBarEnabled(false);
        this.p2 = new n25.c(this, this.g2);
        vv4.d r5 = new vv4.d(new h(this));
        this.W2 = r5;
        r5.a(new h2());
        tt5.a.h(this.g1, "generateBridgeWebViewClient() use offline res = " + this.M2);
        if (this.M2 == false) goto L12;
        this.W2.a(this.p2);
    L12:
        if (this.o3 == false) goto L14;
        this.W2.a(new n25.f(this, this.g2));
    L14:
        setWebViewClient(this.W2);
        if (DevEnvUtil.isDevelopPackage(getContext()) == false) goto L17;
        this.W2.a(new i(this));
    L17:
        a r6 = new a(this);
        vv4.c r7 = new vv4.c(r6);
        this.X2 = r7;
        b r8 = new b(this, r6);
        if (((CopyOnWriteArrayList) r7.d).contains(r8) == true) goto L20;
        ((CopyOnWriteArrayList) r7.d).add(r8);
    L20:
        setWebChromeClient(this.X2);
        final s1 r9 = new s1(this.x1, this.G1, this.H1, (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), this.H1.e());
        this.a3 = new i05.e(this);
        this.b3 = com.bytedance.ee.util.ui.n.E(com.bytedance.ee.util.ui.k.e(getContext()));
        this.D.c("biz.notify.ready", new tb5.k(new i05.c(new f1(this, r9))));
        this.D.c("biz.notify.preloadReady", new tb5.k(new i05.a(new g1(this, r9))));
        com.bytedance.ee.bear.appsetting.c r10 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.h3 = r10.i("spacekit.mobile.use_input_connection_wrapper", true);
        this.i3 = r10.i("spacekit.mobile.intercept_hard_keyboard_enable", true);
        tt5.a.h(this.g1, "useInputWrapper:" + this.h3 + ", interceptHardKeyboardEnable:" + this.i3);
        Lazy r11 = TTWebViewUtil.a;
        otb.m r12 = TTWebViewUtil.a.a(this);
        this.u3 = r12;
        r12.c(y3);
        this.u3.b(new l1());
        this.u3.a(new m1());
        this.k3.b(new h6(this), ((vv4.o) org.koin.java.a.a(vv4.o.class)).getWebServices());
        if (r3 < 29) goto L29;
        WebViewCompat.setWebViewRenderProcessClient(this, new c(this));     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        tt5.a.e(this.g1, "setWebViewRenderProcessClient failed", th, false);
        return;
    }

    public final boolean G() {
        if (DocOpenConfig.m == true) goto L5;
    L7:
        return false;
    L5:
        if (this.y2.equals(sbb.e.o.getType()) == false) goto L7;
        return true;
    }

    public final void H() {
        com.bytedance.ee.util.ui.m.e(this.s3);
        com.bytedance.ee.util.ui.m.b(this.s3, 120000);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.kill_render_process_when_js_blocked") == false) goto L8;
        com.bytedance.ee.util.ui.m.e(this.t3);
        if (this.P1 == true) goto L9;
        long r0 = com.bytedance.ee.bear.document.reloadwebview.a.a.getLoadHtmlTimeOut();
        com.bytedance.ee.util.ui.m.b(this.t3, r0);
        return;
    L9:
        return;
    }

    public final void I() {
        tt5.a.h(this.g1, "destoryView()...");
        c();
        setDocStatus(0);
    }

    public final boolean M() {
        Boolean r0 = this.M1.get(this.y2);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flowable<Boolean> R() {
        tt5.a.h(this.g1, "preloadWebview ");
        setDocStatus(0);
        this.a3.d();
        this.a3.c(this.y2, null);
        return ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).j(this, true);
    }

    public final void X() {
        if (TextUtils.equals(this.y2, sbb.e.i.getType()) == false) goto L5;
        return;
    L5:
        startNestedScroll(2);
        dispatchNestedPreScroll(0, -2147483647, null, null);
        stopNestedScroll();
    }

    public final void destroy() {
        tt5.a.h(this.g1, "destroy()... webviewId=" + this.F2);
        this.v2 = null;
        this.x2 = null;
        this.O2 = null;
        this.y2 = sbb.e.g.getType();
        tt5.a.h(this.g1, "clearRenderParams");
        ((HashMap) this.V2).clear();
        LiveData<ConnectionService.NetworkState> r0 = this.Z2;
        if (r0 == null) goto L5;
        r0.removeObserver(this.q3);
    L5:
        this.L1.e().removeObserver(this.r3);
        n25.c r1 = this.p2;
        if (r1 == null) goto L12;
        n25.a r2 = r1.b;
        if (r2 == null) goto L12;
        tt5.a.h(r2.b, "destroy");
        ConcurrentHashMap<String, String> r3 = r2.f;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        com.bytedance.ee.util.ui.m.e(this.s3);
        com.bytedance.ee.util.ui.m.e(this.t3);
        super.destroy();
    }

    public String getObjToken() {
        Serializable r0 = this.V2.get("wikiInfo");
        if (r0 != null) goto L5;
    L8:
        BearUrl r1 = this.x2;
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1.b;
    L5:
        if ((r0 instanceof WikiInfo) == false) goto L8;
        return ((WikiInfo) r0).getObjToken();
    }

    public String getPerformanceTiming() {
        otb.e r0 = this.u3;
        if (r0 != null) goto L6;
        return "{}";
    L6:
        r0.getPerformanceTiming();
        return null;
    }

    public ConcurrentHashMap<String, String> getResPath() {
        n25.c r0 = this.p2;
        if (r0 == null) goto L10;
        tt5.a.h(r0.a, "getResPath()...");
        n25.a r1 = r0.b;
        if (r1 == null) goto L8;
        return r1.f;
    L8:
        return new ConcurrentHashMap();
    L10:
        return new ConcurrentHashMap();
    }

    public long getWebviewStatusCode() {
        otb.e r0 = this.u3;
        if (r0 != null) goto L6;
        return -999;
    L6:
        r0.getLoadingStatusCode();
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void goBack() {
        WebBackForwardList r0 = copyBackForwardList();
        if (r0 == null) goto L9;
        int r1 = r0.getCurrentIndex();
        if (r1 <= 1) goto L9;
        WebHistoryItem r2 = r0.getItemAtIndex(r1 - 1);
        if (r2 == null) goto L9;
        final String r3 = r2.getOriginalUrl();
    L10:
        super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.goBack();
        JSONObject r4 = new JSONObject();
        r4.put("url", Q(r3));
        F("javascript:replace", r4);
        getRenderCallbacks().subscribe(new u0(r3), new e1(this));
        return;
    L9:
        r3 = "";
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b2 r0 = new b2(this.G1);
        this.S1 = r0;
        if (r0.e == true) goto L5;
        tt5.a.h("DocWebPerfMonitor", "monitorOn is false");
    L6:
        tt5.a.h(this.g1, "onAttachedToWindow()...");
        this.h2 = true;
        onResume();
        return;
    L5:
        b2.f++;
        r0.d = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new c2(r0, new Ref.IntRef()), 0, 5, TimeUnit.SECONDS);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b2 r0 = this.S1;
        if (r0 == null) goto L13;
        String r2 = getObjToken();
        if ((((HashMap) this.V2).get("wikiInfo") instanceof WikiInfo) == false) goto L7;
        String r3 = sbb.e.n.getType();
    L8:
        String r4 = this.y2;
        if (r0.e == false) goto L12;
        r0.b();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d2(r0, r2, r3, r4));
    L12:
        this.S1 = null;
        goto L13
    L7:
        r3 = this.y2;
    L13:
        setGetSSRScrollPosListner(null);
        boolean r1 = M();
        WeakReference<Fragment> r5 = this.V1;
        if (r5 != null) goto L16;
    L19:
        FragmentActivity r6 = null;
    L20:
        boolean r7 = true;
        if (r6 == null) goto L25;
        Intent r8 = r6.getIntent();
        if (r8 == null) goto L25;
        r7 = r8.getBooleanExtra("clear_res", true);
    L25:
        tt5.a.h(this.g1, "onDetachedFromWindow()... isReay = " + r1);
        setHostFragment(null);
        if (r1 == false) goto L29;
        if (r7 == false) goto L29;
        tt5.a.h(this.g1, "recycle()... clear");
        clearHistory();
        F("javascript:clear", null);
        evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
    L29:
        this.h2 = false;
        JSONObject r9 = new JSONObject();
        r9.put("operation", "nativeClearIO");
        r9.put("webviewId", this.F2);
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).a(r9.toString());
        return;
    L16:
        if (r5.get() == null) goto L19;
        r6 = this.V1.get().getActivity();
        goto L20
    }

    public BearUrl getBearUrl() {
        return this.x2;
    }

    public u1 getDocStateTracker() {
        return this.l3;
    }

    public int getDocStatus() {
        return this.S2;
    }

    public n25.c getOfflineEngine() {
        return this.p2;
    }

    public int getUsedCount() {
        return this.e3;
    }

    public vv4.n getWebServiceManager() {
        return this.k3;
    }

    public Map<Integer, Boolean> getWebViewActiveMap() {
        return this.j3;
    }

    public String getWebViewId() {
        return this.F2;
    }

    public long getmLoadHtmlStartTime() {
        return this.P2;
    }

    public final boolean isInEditMode() {
        return this.T1;
    }

    public DocBridgeWebViewV2(Context r3) {
        super(r3);
        this.g1 = "DocBridgeWebViewV2_" + hashCode();
        this.h1 = 0;
        this.k1 = false;
        this.p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.b2 = new CopyOnWriteArrayList();
        this.y2 = sbb.e.g.getType();
        this.F2 = UUID.randomUUID().toString();
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = 2147483647L;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.e3 = 0;
        this.f3 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled");
        this.g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        this.h3 = true;
        this.i3 = true;
        this.j3 = new HashMap();
        this.k3 = new vv4.n();
        this.l3 = new u1();
        this.m3 = false;
        this.n3 = false;
        this.o3 = false;
        this.q3 = new d(this);
        this.r3 = new e(this);
        this.s3 = new f(this);
        this.t3 = new g();
        r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void A(final DocBridgeWebViewV2 r3) {
        r3.getClass();
        int r0 = x3;
        DocOpenConfig.a();
        if (r0 >= DocOpenConfig.g.reload_max_num) goto L5;
        x3++;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).d(r3).subscribe(new y(r3), new j0(r3));
        return;
    L5:
        String r4 = r3.g1;
        StringBuilder r1 = new StringBuilder("reloadWebviewRunnable====== sReloadNum: ");
        r1.append(x3);
        r1.append("  DocOpenConfig.getReloadMaxNum()： ");
        DocOpenConfig.a();
        r1.append(DocOpenConfig.g.reload_max_num);
        tt5.a.k(r4, r1.toString());
    }

    public static void B(final DocBridgeWebViewV2 r3) {
        tt5.a.h(r3.g1, "downloadFullResource onReady");
        r3.getRenderCallbacks().subscribe(new c1(r3), new d1(r3));
        r3.R().subscribe(new a1(r3), new b1(r3));
    }

    private synchronized void setDocStatus(int r4) {
        monitor-enter(this);
        tt5.a.h(this.g1, "setDocStatus(): " + r4);     // Catch: Throwable -> L7
        this.S2 = r4;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean z(DocBridgeWebViewV2 r8) {
        r8.getClass();
        boolean r1 = false;
        if (p15.a.a() == false) goto L14;
        StringBuilder r0 = new StringBuilder("isMainJSModulesReady()... ");
        OperationRecord r3 = com.bytedance.ee.bear.document.forecast.a.a;
        Iterator r4 = com.bytedance.ee.bear.document.forecast.a.b(DocOpenConfig.e()).iterator();
    L5:
        boolean r5 = true;
    L7:
        if (r4.hasNext() == false) goto L13;
        String r6 = (String) r4.next();
        boolean r7 = Boolean.TRUE.equals(((HashMap) r8.M1).get(r6));
        r0.append(", ");
        r0.append(r6);
        r0.append(": ");
        r0.append(r7);
        if (r5 == false) goto L12;
        if (r7 == true) goto L5;
    L12:
        r5 = false;
        goto L7
    L13:
        tt5.a.h(r8.g1, r0.toString());
        return r5;
    L14:
        Boolean r2 = (Boolean) ((HashMap) r8.M1).get(sbb.e.o.getType());
        Boolean r9 = (Boolean) ((HashMap) r8.M1).get(sbb.e.h.getType());
        Boolean r10 = (Boolean) ((HashMap) r8.M1).get(sbb.e.g.getType());
        tt5.a.h(r8.g1, "isDocAndSheetReady()... ret1: " + r2 + "   ret2: " + r9 + "   ret3: " + r10);
        if (r2 == null) goto L26;
        if (r9 == null) goto L26;
        if (r10 == null) goto L26;
        if (r2.booleanValue() == false) goto L26;
        if (r9.booleanValue() == false) goto L26;
        if (r10.booleanValue() == false) goto L26;
        r1 = true;
    L26:
        return r1;
    }

    public final void C(com.bytedance.ee.bear.contract.m0 r2) {
        l<com.bytedance.ee.bear.contract.m0> r0 = new l(r2);
        if (this.b2.contains(r0) == true) goto L6;
        this.b2.add(r0);
        return;
    }

    public final void D(p35.f r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<p35.f> r0 = v3;
        if (((CopyOnWriteArrayList) r0).contains(r3) == true) goto L8;
        ((CopyOnWriteArrayList) r0).add(r3);
        return;
    }

    public final boolean N(String r2) {
        Boolean r3 = this.M1.get(r2);
        if (r3 != null) goto L5;
        return false;
    L5:
        return r3.booleanValue();
    }

    public final String Q(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        String r0 = UriProtector.parse(r4).getPath();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        int r1 = r4.indexOf(r0);
        if (r1 != (-1)) goto L10;
    L14:
        return "";
    L10:
        if (r1 > r4.length()) goto L14;
        return r4.substring(r1);
    L15:
        return null;
    }

    public final void S(com.bytedance.ee.bear.contract.m0 r3) {
        this.b2.remove(new l(r3));
    }

    public final void T(WebViewClient r2) {
        ((CopyOnWriteArrayList) this.W2.e).remove(r2);
    }

    public final void V(String r5) {
        this.m3 = true;
        this.G1.j("render_cache", "render_cache_from", "native");
        JSONObject r6 = JSON.parseObject(r5);
        tt5.a.h(this.g1, "renderCacheHTML(): connected = " + this.d3);
        int r1 = 50;
        if (this.d3 == true) goto L5;
        r1 = 50 + getTipLayoutHeight();
    L5:
        r6.put("deviceInfo", JSON.toJSON(new DeviceInfo(this.b3, r1)));
        K(r6, "renderCacheHTML");
        F("javascript:renderCacheHTML", r6);
        getRenderCallbacks().subscribe(new i0(), new k0(this));
    }

    public final boolean W(boolean r10) {
        if (M() == false) goto L6;
        setDocStatus(1);
        U(1, r10);
        return true;
    L6:
        this.Q1 = true;
        boolean r11 = s1.n;
        s1.x = System.currentTimeMillis();
        boolean r0 = false;
        if (this.M2 == false) goto L24;
        n25.c r12 = this.p2;
        tt5.a.h(r12.a, "isSlim()...");
        n25.a r13 = r12.b;
        if (r13 == null) goto L11;
        r0 = r13.t;
    L11:
        boolean r14 = ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).j();
        tt5.a.h(this.g1, "***reportOpenDoc*** loadUrlRenderIfNeed()... getWebviewStatusCode: " + getWebviewStatusCode() + ", isSlim: " + r0 + ", hasFullResource: " + r14);
        List<String> r2 = DocOpenConfig.b;
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r5 = r3.g("ccm.mobile.full_pkg_included");
        tt5.a.h(this.g1, "isFullPkgIncluded " + r5);
        if (r2.contains(this.y2) == true) goto L22;
        if (r0 == false) goto L22;
        if (r5 == true) goto L22;
        if (r14 == false) goto L18;
        getRenderCallbacks().subscribe(new t0(), new v0(this));
        R().subscribe(new a1(this), new b1(this));
    L23:
        return true;
    L18:
        getRenderCallbacks().subscribe(new w0(), new x0(this));
        tt5.a.h(this.g1, "downloadFullResource ");
        if (r3.g("ccm.mobile.full_pkg_included") == false) goto L21;
        tt5.a.h(this.g1, "isFullPkgIncluded true");
        goto L23
    L21:
        com.bytedance.ee.bear.doc.resupdate.g r16 = (com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class);
        r16.h(new n1(this));
        r16.e(EChannel.DOCS_FULLPKG_CHANNEL, new o1(this, r16));
    L22:
        this.a3.c(this.y2, null);
        getRenderCallbacks().subscribe(new r0(), new s0(this));
        goto L23
    L24:
        return false;
    }

    public final void Y(ConnectionService.NetworkState r4) {
        tt5.a.h(this.g1, "updateNetworkState:" + r4);
        if (r4 != null) goto L6;
        tt5.a.f(this.g1, new IllegalArgumentException("updateNetworkState with null state"), false);
        return;
    L6:
        this.d3 = r4.a();
        if (M() == true) goto L10;
        tt5.a.d(this.g1, "updateNetworkState while JsBridge hasn't ready");
        return;
    L10:
        JSONObject r0 = new JSONObject();
        r0.put("type", Integer.valueOf(r4.getType()));
        r0.put("connected", Boolean.valueOf(r4.a()));
        F("javascript:window.native.setNetworkState", r0);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final void loadUrl(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        iu5.d.a(this.g1, new IllegalArgumentException(" url is empty!!!"));
        return;
    L7:
        if (r4.startsWith("javascript:") == false) goto L10;
        p(r4, true);
        return;
    L10:
        if (this.p1 == false) goto L13;
        p(r4, false);
    L16:
        X();
        return;
    L13:
        if (this.k1 == false) goto L15;
        HashMap r0 = new HashMap();
        r0.put("Env", "Pre_release");
        super.loadUrl(r4, r0);
        goto L16
    L15:
        p(r4, false);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        InputConnection r3 = super/*android.webkit.WebView*/.onCreateInputConnection(r2);
        if (this.h3 == false) goto L8;
        if (r3 != null) goto L7;
        return null;
    L7:
        return new k(r3);
    L8:
        return r3;
    }

    @Override // com.bytedance.ee.bear.browser.WebViewV2
    public final void onWindowFocusChanged(boolean r4) {
        tt5.a.h(this.g1, "onWindowFocusChanged: " + r4);
        super.onWindowFocusChanged(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowVisibilityChanged(int r4) {
        super/*android.webkit.WebView*/.onWindowVisibilityChanged(r4);
        tt5.a.h(this.g1, "onWindowVisibilityChanged  visibility: " + r4);
    }

    public void setGetSSRScrollPosListner(com.bytedance.ee.bear.document.ssrrender.a.b r2) {
        this.g3.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHostFragment(Fragment r4) {
        String r0 = this.g1;
        StringBuilder r1 = new StringBuilder("setHostFragment() fragment null is ");
        if (r4 != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        tt5.a.h(r0, r1.toString());
        this.V1.clear();
        this.V1 = new WeakReference(r4);
        if (r4 != null) goto L11;
        Context r5 = getContext();
        FileChooseHandlerV2 r3 = ((ws5.b) this.X2).c;
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "context");
        r3.a = r5;
        return;
    L15:
        return;
    L11:
        FragmentActivity r6 = r4.getActivity();
        FileChooseHandlerV2 r7 = ((ws5.b) this.X2).c;
        if (r7 == null) goto L17;
        Intrinsics.checkNotNullParameter(r6, "context");
        r7.a = r6;
        return;
    L17:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setReadyCallback(j r1) {
        this.Y2 = r1;
    }

    public void setReadyStatus(Boolean r4) {
        tt5.a.h(this.g1, "setReadyStatus()...  status： " + r4);
        this.M1.put(sbb.e.g.getType(), r4);
        this.M1.put(sbb.e.n.getType(), r4);
        this.M1.put(sbb.e.h.getType(), r4);
        this.M1.put(sbb.e.k.getType(), r4);
        this.M1.put(sbb.e.o.getType(), r4);
        this.M1.put(sbb.e.i.getType(), r4);
        this.M1.put(sbb.e.l.getType(), r4);
        if (this.f3 == false) goto L6;
        this.M1.put(sbb.e.m.getType(), r4);
        return;
    }

    public void setRenderParams(Map<String, Serializable> r4) {
        tt5.a.h(this.g1, "setRenderParams:" + r4);
        if (r4 == null) goto L6;
        this.V2.putAll(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2
    public final ActionMode startActionMode(ActionMode.Callback r2) {
        return v(r2, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocBridgeWebViewV2(Context r12, String r13) {
        super(r12);
        String r14 = "DocBridgeWebViewV2_" + hashCode();
        this.g1 = r14;
        this.h1 = 0;
        this.k1 = false;
        this.p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.b2 = new CopyOnWriteArrayList();
        this.y2 = sbb.e.g.getType();
        String r1 = UUID.randomUUID().toString();
        this.F2 = r1;
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = 2147483647L;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.e3 = 0;
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.f3 = r2.g("ccm.mobile.slides_enabled");
        this.g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        boolean r3 = true;
        this.h3 = true;
        this.i3 = true;
        this.j3 = new HashMap();
        this.k3 = new vv4.n();
        this.l3 = new u1();
        this.m3 = false;
        this.n3 = false;
        this.o3 = false;
        d r4 = new d(this);
        this.q3 = r4;
        e r5 = new e(this);
        this.r3 = r5;
        this.s3 = new f(this);
        this.t3 = new g();
        this.g2 = r13;
        tt5.a.h(r14, "Native init webViewId=" + r1);
        if (TextUtils.isEmpty(r13) == true) goto L5;
        this.g1 = r14 + OfflineDoc.DASH_DELIMITER + r13;
    L5:
        this.H1 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        com.bytedance.ee.bear.contract.j r16 = com.bytedance.ee.bear.contract.j.a.a;
        this.x1 = r16;
        this.G1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.y1 = (com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class);
        com.bytedance.ee.bear.contract.f r17 = (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class);
        this.L1 = r17;
        iu5.f.a(new e0(this));
        ml5.b r6 = new ml5.b("debug_config");
        this.v1 = r6;
        this.L2 = ((Boolean) r6.a("show_doc_size_toast", Boolean.FALSE)).booleanValue();
        boolean r7 = getRenderSwitch();
        this.K2 = r7;
        this.U2 = getFirstNotRenderSwitch();
        boolean r8 = ((Boolean) r6.a("resourceIntercept", Boolean.TRUE)).booleanValue();
        this.M2 = r8;
        boolean r9 = eu5.c.d();
        this.I2 = r9;
        tt5.a.h(this.g1, "mIsDebug: " + r9);
        if (r8 == true) goto L9;
        if (r7 == true) goto L9;
    L10:
        this.o3 = r3;
        tt5.a.h(this.g1, "isOfflineOpen: " + r8 + " isRenderOpen: " + r7);
        BridgeWebViewV2.E = r2.i("spacekit.mobile.webviewbridge.run.on.main.thread", false);
        tt5.a.h(this.g1, "shandlerRunOnUIThread =  " + BridgeWebViewV2.E);
        DocOpenConfig.h();
        r();
        l35.k r0 = l35.k.a.a;
        LiveData<ConnectionService.NetworkState> r18 = r16.a();
        this.Z2 = r18;
        r18.observeForever(r4);
        r17.e().observeForever(r5);
        String r19 = this.g1;
        StringBuilder r110 = new StringBuilder("init end TTWebViewUtil.isTTWebView: false   this: ");
        TTWebViewUtil.a.d(this);
        r110.append(this);
        tt5.a.h(r19, r110.toString());
        return;
    L9:
        r3 = false;
        goto L10
    }

    private ActionMode v(ActionMode.Callback r4, int r5) {
        WeakReference<Fragment> r0 = this.V1;
        if (r0 != null) goto L5;
    L8:
        FragmentActivity r1 = null;
    L9:
        if (r1 != null) goto L11;
    L22:
        tt5.a.k(this.g1, "startActionMode while not active !");
        return null;
    L11:
        if (r1.isFinishing() == true) goto L22;
        tt5.a.h(this.g1, "DocBridgeWebView start actionMode");     // Catch: Exception -> L19
        if (com.larksuite.framework.utils.x.a() == false) goto L18;
        return v(r4, r5);
    L18:
        return v(r4, -1);
    L19:
        e = move-exception;
        tt5.a.e(this.g1, "DocBridgeWebView start actionMode exception ", e, false);
        return null;
    L5:
        if (r0.get() == null) goto L8;
        r1 = this.V1.get().getActivity();
        goto L9
    }

    public static /* synthetic */ void x(final DocBridgeWebViewV2 r3, final String r4) {
        tt5.a.h(r3.g1, "***reportOpenDoc*** ValueCallback value: " + r4);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.bitable.base.disable.performance_log") == true) goto L6;
        r3.getRenderCallbacks().subscribe(new y0(r4), new z0(r3));
        return;
    }

    public final void E(String r3, Serializable r4) {
        tt5.a.h(this.g1, "addRenderParams:".concat(r3));
        ((HashMap) this.V2).put(r3, r4);
    }

    public final void F(String r3, JSONObject r4) {
        if (r3.startsWith("javascript:") == false) goto L6;
        o(r3, r4, true);
        return;
    L6:
        if (this.p1 == false) goto L9;
        o(r3, r4, false);
    L12:
        X();
        return;
    L9:
        if (this.k1 == false) goto L11;
        String r5 = mu5.b.d(r3, r4);
        HashMap r6 = new HashMap();
        r6.put("Env", "Pre_release");
        super.loadUrl(r5, r6);
        goto L12
    L11:
        o(r3, r4, false);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long J(String r7, String r8) {
        String r0 = this.G1.e(r7, r8);
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((r0 instanceof Number) == false) goto L14;
        long r9 = ((Number) r0).longValue();
    L10:
        return System.currentTimeMillis() - (SystemClock.uptimeMillis() - r9);
    L14:
        r9 = CastLongProtector.parseLong(r0);     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        tt5.a.l(this.g1, "getWallClockFromUptimeData parse failed, dataTag = " + r7 + ", dataKey = " + r8, e);
        return 0;
    }

    public final void K(JSONObject r6, String r7) {
        BearUrl r0 = this.x2;
        String r1 = null;
        if (r0 != null) goto L6;
        String r2 = null;
    L10:
        if (AppInfoUtils.e().booleanValue() == false) goto L12;
        r1 = DocAppIdConst.Mempope.value;
    L16:
        JSONObject r3 = DocComponentConfig.getSceneConfig(r1);
        if (r3 == null) goto L19;
        r6.put(DocComponentConfig.KEY_INJECT_WEB, r3);
    L19:
        JSONObject r4 = DocComponentConfig.getPatchSettingConfig(this.V1);
        if (r4 == null) goto L22;
        r6.put(DocComponentConfig.KEY_INJECT_WEB_PATCH, r4);
    L22:
        tt5.a.h(this.g1, r7 + " inject docComponentConfig=" + r3 + " sceneId=" + r1 + " updateSettingConfig=" + r4);
        return;
    L12:
        tt5.a.h(this.g1, "injectDocComponentConfig: sceneId=" + r2);
        if (TextUtils.equals(r2, DocAppIdConst.Mempope.value) == true) goto L16;
        r1 = r2;
        goto L16
    L6:
        if (TextUtils.isEmpty(r0.r) == true) goto L8;
        r2 = this.x2.r;
        goto L10
    L8:
        r2 = this.x2.q;
        goto L10
    }

    public final void P(final boolean r4, final int r5) {
        tt5.a.k(this.g1, "onRenderProcessGone====== isAttachedToWindow: " + this.h2);
        com.bytedance.ee.util.ui.m.a(new h0(r4, r5));
    }

    public final void U(int r10, boolean r11) {
        String r0 = Q(this.v2);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        tt5.a.k(this.g1, "***reportOpenDoc*** doRender: parsed url is null uri = " + this.v2);
        return;
    L5:
        tt5.a.h(this.g1, "***reportOpenDoc*** doRender url = " + r0.hashCode());
        boolean r1 = true;
        this.n3 = true;
        AccountService$Account r2 = this.y1.G2();
        if (r2 == null) goto L76;
        JSONObject r3 = new JSONObject();
        r3.put("userId", r2.uid);
        r3.put("tenantId", r2.tenantId);
        r3.put("departmentId", r2.departmentId);
        r3.put("isPreloadFinished", Integer.valueOf(r10));
        if (h18.f.a(eu5.b.a) == false) goto L10;
        String r12 = "dark";
    L11:
        r3.put("theme", r12);
        BearUrl r13 = this.x2;
        if (r13 == null) goto L17;
        String r14 = r13.b;
        ScrollData r4 = (ScrollData) ((HashMap) c25.d.a).get(r14);
        if (r4 != null) goto L16;
        r4 = new ScrollData();
        r4.setToken(r14);
        r4.setX(0);
        r4.setY(0);
    L16:
        r3.put("x", Integer.valueOf(r4.getX()));
        r3.put("y", Integer.valueOf(r4.getY()));
    L17:
        JSONObject r16 = new JSONObject();
        r16.put("tap", Long.valueOf(w3));
        r16.put("invokeRender", Long.valueOf(System.currentTimeMillis()));
        r16.put("preloadStart", 0L);
        r16.put("webviewLoadUrl", Long.valueOf(this.P2));
        r16.put("nativeWaitPreloadStart", Long.valueOf(J("wait_preload", "start_time")));
        r16.put("nativeHtmlReady", Long.valueOf(J("wait_preload_html", "end_time")));
        r16.put("nativeJsReady", Long.valueOf(this.R2));
        r3.put("timestamp", r16);
        String r17 = this.x2.b;
        Map<String, JSONObject> r5 = d25.d.b;
        if (((JSONObject) ((HashMap) r5).get(r17)) != null) goto L20;
        r3.put("prefetchData", "");
    L21:
        r3.put("title", this.E2);
        r3.put("nativeWebviewId", this.F2);
        r3.put("editorId", this.F2);
        r3.put("isDebug", Boolean.valueOf(this.I2));
        r3.put("isShowDocumentSize", Boolean.valueOf(this.L2));
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.a() == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        r3.put("preFetchClientvarEnable", Boolean.valueOf(r18));
        boolean r19 = this.m3;
        BearUrl r6 = this.x2;
        String r7 = r6.r;
        String r8 = r6.a;
        boolean r9 = ((HashMap) this.V2).get("wikiInfo") instanceof WikiInfo;
        if (((HashMap) this.V2).containsKey("renderSSRWebviewType") == false) goto L30;
    L32:
        if (r19 == false) goto L34;
    L37:
        int r110 = 0;
    L38:
        if (r11 == true) goto L40;
    L43:
        boolean r20 = false;
    L44:
        r3.put("shouldRenderCacheHtml", Boolean.valueOf(r20));
        if (TextUtils.equals(this.y2, sbb.e.o.getType()) == false) goto L48;
        r3.put("renderSSRWebviewType", Integer.valueOf(r110));
    L48:
        if (this.x2.e.contains("/sync/") == false) goto L50;
        r3.put("syncBlockSourceToken", this.x2.b);
    L50:
        String r111 = this.g1;
        StringBuilder r21 = new StringBuilder("shouldRenderCacheHtml = ");
        if (r11 == true) goto L53;
    L55:
        r1 = false;
    L56:
        r21.append(r1);
        tt5.a.b(r111, r21.toString());
        r3.putAll(this.V2);
        JSONObject r112 = this.G2;
        if (r112 == null) goto L59;
        r3.put("versionInfo", r112);
    L61:
        if (TextUtils.isEmpty(this.H2) == true) goto L63;
        r3.put("associateAppUrl", this.H2);
    L63:
        K(r3, "render");
        JSONObject r113 = new JSONObject();
        r113.put("url", r0);
        r113.put("infos", r3);
        t45.c r114 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        s45.l r22 = r114.m8(this.v2);
        String r23 = r114.m4(r22);
        String[] r115 = r114.U3(r22);
        if (r22 != null) goto L66;
    L71:
        r113.put("srcHost", r22.c);
        r113.put("srcUrl", this.v2);
        StringBuilder r116 = new StringBuilder(r113.toString());
        if (TextUtils.isEmpty(this.N2) == false) goto L74;
        r116.insert(r116.indexOf("infos\":{") + 8, "\"clientvars\":\"\",");
    L75:
        String r117 = r116.toString();
        boolean r118 = s1.n;
        s1.x = System.currentTimeMillis();
        evaluateJavascript("javascript:render(" + r117 + ")", new l0(this));
    L77:
        getRenderCallbacks().subscribe(new o0(), new p0(this));
        X();
        return;
    L74:
        r116.insert(r116.indexOf("infos\":{") + 8, "\"clientvars\":" + this.N2 + ",");
        goto L75
    L66:
        if (TextUtils.isEmpty(r23) == true) goto L71;
        if (r115 == null) goto L71;
        tt5.a.h(this.g1, "render inject mg domain info, apiUrl=" + r23 + " frontierDomain=" + Arrays.toString(r115));
        r113.put("docsApiPrefix", r23);
        r113.put("frontierDomain", r115);
        r113.put("unit", r22.a);
        String r119 = r22.b;
        if (r119 == null) goto L71;
        r113.put("brand", r119);
        goto L71
    L59:
        tt5.a.h(this.g1, "versionInfo null");
        goto L61
    L53:
        if (this.m3 == true) goto L55;
    L40:
        if (this.m3 == true) goto L43;
        if (r110 == 1) goto L43;
        r20 = true;
        goto L44
    L34:
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.f(r7, r8, r9) == false) goto L37;
        r110 = 1;
        goto L38
    L30:
        if (DocOpenConfig.f().enable_after_render == true) goto L32;
    L24:
        if (TextUtils.equals(sbb.e.o.getType(), this.y2) == false) goto L26;
        r18 = true;
        goto L27
    L20:
        r3.put("prefetchData", (JSONObject) ((HashMap) r5).get(this.x2.b));
        goto L21
    L10:
        r12 = "light";
        goto L11
    L76:
        tt5.a.d(this.g1, "***reportOpenDoc*** onCallJsRender()... account is empty ");
        boolean r120 = s1.n;
        s1.x = System.currentTimeMillis();
        final DocException r121 = new DocException(-51, "account is empty");
        getRenderCallbacks().subscribe(new m0(r121), new n0(this));
        goto L77
    }

    @Override // x35.e
    public final void a(Integer r7, final Map<String, String> r8) {
        if (r7.intValue() != 2) goto L16;
        if (r8 == null) goto L42;
        String r9 = String.valueOf(r8.get("stage"));
        if (TextUtils.equals(r9, "render_doc") == false) goto L9;
        this.l3.d();
        return;
    L9:
        if (TextUtils.equals(r9, "pull_data") == false) goto L12;
        this.l3.g();
        return;
    L12:
        if (TextUtils.equals(r9, "render_cache") == false) goto L14;
        this.l3.c();
        return;
    L14:
        tt5.a.k(this.g1, "onReceiveFrontEvent start stage: ".concat(r9));
        return;
    L42:
        return;
    L16:
        if (r7.intValue() != 3) goto L47;
        if (r8 == null) goto L48;
        String r10 = String.valueOf(r8.get("stage"));
        String r0 = String.valueOf(r8.get("docs_result_key"));
        String r1 = String.valueOf(r8.get("docs_result_code"));
        if (TextUtils.equals("other", r0) == true) goto L21;
    L23:
        boolean r2 = false;
    L25:
        if (TextUtils.equals(r10, "render_doc") == false) goto L30;
        if (r2 == false) goto L28;
        this.l3.h();
        getRenderCallbacks().subscribe(new i1(r8), new j1(this));
        return;
    L28:
        final DocException r3 = new DocException(yu5.c.f(r1, -53), "Err in render doc");
        getRenderCallbacks().subscribe(new k1(r3, r8), new z(this));
        return;
    L30:
        if (TextUtils.equals(r10, "pull_data") == false) goto L35;
        if (r2 == false) goto L33;
        this.l3.a();
        return;
    L33:
        final DocException r4 = new DocException(yu5.c.f(r1, -54), "Err in pull data");
        getRenderCallbacks().subscribe(new a0(r4, r8), new b0(this));
        return;
    L35:
        if (TextUtils.equals(r10, "render_cache") == true) goto L37;
        tt5.a.k(this.g1, "onReceiveFrontEvent end stage: ".concat(r10));
        return;
    L37:
        if (idb.f.a().isEnable("ccm.bitable.docx_base.optimized.enable") == false) goto L39;
        getRenderCallbacks().subscribe(new c0(), new d0(this));
    L39:
        this.l3.e();
        return;
    L21:
        if (TextUtils.equals(r1, DiagramData$RESULT.FAIL) == false) goto L23;
        r2 = true;
        goto L25
    L48:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyPreIme(int r3, KeyEvent r4) {
        if (this.i3 == false) goto L9;
        if (r4.getKeyCode() != 61) goto L9;
        dispatchKeyEvent(r4);
        return true;
    L9:
        return super/*android.webkit.WebView*/.onKeyPreIme(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        super/*android.webkit.WebView*/.onVisibilityChanged(r2, r3);
        if (r3 == 0) goto L5;
        return;
    L5:
        if (r2.equals(this) == true) goto L7;
        return;
    L7:
        if (this.h1 != 0) goto L12;
        this.h1 = getBottom();
        tt5.a.h(this.g1, "onVisibilityChanged: mOriBottom=" + this.h1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean requestFocus(int r1, Rect r2) {
        return super/*android.webkit.WebView*/.requestFocus(r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.view.DecorateWebViewV2, zv4.b
    public final ActionMode startActionMode(ActionMode.Callback r1, int r2) {
        return v(r1, r2);
    }

    public DocBridgeWebViewV2(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.g1 = "DocBridgeWebViewV2_" + hashCode();
        this.h1 = 0;
        this.k1 = false;
        this.p1 = false;
        this.M1 = new HashMap();
        this.P1 = false;
        this.Q1 = false;
        this.V1 = new WeakReference(null);
        this.b2 = new CopyOnWriteArrayList();
        this.y2 = sbb.e.g.getType();
        this.F2 = UUID.randomUUID().toString();
        this.J2 = new CopyOnWriteArrayList();
        this.P2 = 2147483647L;
        this.Q2 = 0;
        this.R2 = 0;
        this.S2 = 0;
        this.T2 = false;
        this.U2 = false;
        this.V2 = new HashMap();
        this.e3 = 0;
        this.f3 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled");
        this.g3 = new com.bytedance.ee.bear.document.ssrrender.a();
        this.h3 = true;
        this.i3 = true;
        this.j3 = new HashMap();
        this.k3 = new vv4.n();
        this.l3 = new u1();
        this.m3 = false;
        this.n3 = false;
        this.o3 = false;
        this.q3 = new d(this);
        this.r3 = new e(this);
        this.s3 = new f(this);
        this.t3 = new g();
        r();
    }

    public static void y(final DocBridgeWebViewV2 r8, s1 r9, BridgeReadyModel r10) {
        r8.getClass();
        if (com.bytedance.ee.bear.document.reloadwebview.a.j == false) goto L5;
        com.bytedance.ee.util.ui.m.e(r8.t3);
        com.bytedance.ee.bear.document.reloadwebview.a.e = false;
        com.bytedance.ee.bear.document.reloadwebview.a.f();
    L5:
        n25.c r0 = r8.p2;
        if (r0 != null) goto L8;
    L10:
        tt5.a.h(r8.g1, "***reportPreloadHtml*** BIZ_NOTIFY_READY data = " + r10.toString());
        ((HashMap) r8.M1).put(r10.getType(), Boolean.TRUE);
        if (TextUtils.equals(r10.getType(), r8.y2) == false) goto L13;
        r8.R2 = System.currentTimeMillis();
    L13:
        String r1 = r10.getType();
        long r2 = r8.Q2;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        tt5.a.b("DocReport", "reportJsReady");
        org.json.JSONObject r5 = new org.json.JSONObject();
        r5.put("file_type", r1);     // Catch: Throwable -> L22
        List<String> r7 = s1.D;     // Catch: Throwable -> L22
        if (r7 == null) goto L17;
        int r3 = r7.indexOf(r1);     // Catch: Throwable -> L22
    L18:
        r5.put("ordinal", r3);     // Catch: Throwable -> L22
        r5.put("stage", "js_ready");     // Catch: Throwable -> L22
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.forecast_enable_android") == false) goto L24;
        r5.put("render_process_memory", eu5.g.f(eu5.b.a));     // Catch: Throwable -> L22
    L24:
        r9.e(r5, r2);
        if (r8.h2 == true) goto L30;
        if (TextUtils.equals(r10.getType(), sbb.e.h.getType()) == false) goto L30;
        tt5.a.h(r8.g1, "BIZ_NOTIFY_READY onPause");
        r8.onPause();
    L30:
        if (TextUtils.isEmpty(r8.v2) == false) goto L32;
    L43:
        tt5.a.h(r8.g1, "ready()... mPenndingUrl is empty");
    L44:
        r8.Y(r8.x1.getNetworkState());
        d25.d.m(r10.getData(), r10.getType());
        if (TextUtils.equals(r10.getType(), sbb.e.g.getType()) == false) goto L47;
        ((IGetDataCallback) org.koin.java.a.a(IGetDataCallback.class)).onSuccess(Boolean.TRUE);
    L47:
        j r11 = r8.Y2;
        if (r11 == null) goto L53;
        r11.a(r10);
        return;
    L53:
        return;
    L32:
        if (TextUtils.equals(r10.getType(), r8.y2) == false) goto L43;
        r8.getRenderCallbacks().subscribe(new f0(), new g0(r8));
        if (r8.G() == false) goto L36;
    L42:
        r8.setDocStatus(1);
        r8.U(0, r8.Q1);
        r8.Q1 = false;
        goto L44
    L36:
        if (TextUtils.isEmpty(r8.O2) == true) goto L42;
        BearUrl r12 = r8.x2;
        if (r12 == null) goto L42;
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.f(r12.r, r12.a, ((HashMap) r8.V2).get("wikiInfo") instanceof WikiInfo) == true) goto L42;
        tt5.a.h(r8.g1, "renderCacheHTML...  after notify module ready");
        r8.V(r8.O2);
        goto L42
    L17:
        r3 = -1;
    L22:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L24
    L8:
        if (r0.b == null) goto L10;
        n25.g.C = 0;
        n25.g.B = 0;
        goto L10
    }

    public final void O(String r5, String r6, final boolean r7) {
        if (this.v2 != null) goto L6;
        tt5.a.d(this.g1, "url is null!");
        return;
    L6:
        this.N2 = r5;
        this.O2 = r6;
        tt5.a.h(this.g1, "***reportOpenDoc*** loadUrlRenderIfNeed isRenderOpen = " + this.K2 + ", mType " + this.y2 + ", isReady " + M() + ",isOfflineOpen = " + this.M2);
        String r8 = this.G1.e("start_open", "start_time");
        BearUrl r1 = this.x2;
        if (r1 == null) goto L9;
        String r2 = r1.b;
    L10:
        String r3 = this.N2;
        if (r3 != null) goto L13;
        int r4 = -1;
    L14:
        a05.d.a(r2, "client_vars_size", String.valueOf(r4));
        if (r8 != null) goto L18;
        this.G1.j("start_open", "start_time", String.valueOf(System.currentTimeMillis()));
    L18:
        if (this.K2 == true) goto L20;
    L22:
        tt5.a.h(this.g1, "loadUrlRenderIfNeed() use system load url...");
        boolean r9 = s1.n;
        s1.x = System.currentTimeMillis();
        com.bytedance.ee.util.ui.m.d(new q0(this, r7));
        return;
    L20:
        if (W(r7) == false) goto L22;
        return;
    L13:
        r4 = r3.length();
        goto L14
    L9:
        r2 = "";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFocusChanged(boolean r1, int r2, Rect r3) {
        super/*android.webkit.WebView*/.onFocusChanged(r1, r2, r3);
    }

    public final void L(BearUrl r4, String r5, JSONObject r6, String r7) {
        if (r4.e.startsWith("https://") == false) goto L5;
    L7:
        this.v2 = r4.e;
    L8:
        this.x2 = r4;
        this.y2 = r4.a;
        this.E2 = r5;
        this.G2 = r6;
        this.H2 = r7;
        x35.f r8 = this.p3;
        if (r8 == null) goto L13;
        if (r6 != null) goto L12;
        r8.d = null;
        goto L13
    L12:
        r8.d = r6.toString();
    L13:
        String r9 = this.x2.h;
        if (TextUtils.isEmpty(r9) == false) goto L16;
        this.v2 = com.bytedance.ee.util.io.e.a(this.v2, DocRedirectToDocxPlugin.FROM, "tab_other");
        r9 = "tab_other";
    L16:
        boolean r10 = s1.n;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        s1.o = r9;
        BearUrl r11 = this.x2;
        s1.q = r11.j;
        if (TextUtils.isEmpty(r11.i) == false) goto L19;
        s1.p = null;
    L20:
        this.m3 = false;
        this.n3 = false;
        tt5.a.h(this.g1, "injectDocInfo()... doc_from=" + r9 + ", type=" + this.y2 + ", mWebViewId=" + this.F2);
        return;
    L19:
        s1.p = this.x2.i;
        goto L20
    L5:
        if (r4.e.startsWith("http://") == true) goto L7;
        this.v2 = "https://" + r4.e;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r9, int r10, int r11, int r12) {
        super.onScrollChanged(r9, r10, r11, r12);
        List<l<zv4.f>> r0 = this.J2;
        if (r0 == null) goto L13;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        l r2 = (l) r1.next();
        if (r2 == null) goto L12;
        if (r2.a.get() == null) goto L12;
        ((zv4.f) r2.a.get()).onScrollChange(this, r9, r10, r11, r12);
    L12:
        ((CopyOnWriteArrayList) this.J2).remove(r2);
        goto L6
    L21:
        return;
    }
}
