package com.bytedance.ee.bear.document.ssr.plugin;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.o;
import com.bytedance.ee.bear.document.render.node.perf.SendEventData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\"%\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00100\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001c\u00103\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00104\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0006H\u0002J\u0012\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020-H\u0002J\u0014\u0010F\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010G\u001a\u00020\u0012H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u000e2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b)\u0010*¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/DocumentLoader$LoadingCallback;", "<init>", "()V", "cacheFrom", "", "analyticService", "Lcom/bytedance/ee/bear/contract/AnalyticService;", "requestListener", "Lcom/bytedance/ee/bear/document/ssr/HtmlCacheRequestManager$HtmlCacheRequestListener;", "loadState", "Lcom/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$LoadState;", "ssrWebViewContainer", "Landroid/view/ViewGroup;", "disposableContainer", "Lio/reactivex/disposables/CompositeDisposable;", "renderCacheInSsrWebView", "", "getRenderCacheInSsrWebView", "()Z", "setRenderCacheInSsrWebView", "(Z)V", "jsRenderIsCalled", "renderCacheHtmlAlready", "renderLoader", "Lcom/bytedance/ee/bear/document/render/loader/DocumentLoaderV3;", "getRenderLoader", "()Lcom/bytedance/ee/bear/document/render/loader/DocumentLoaderV3;", "renderLoader$delegate", "Lkotlin/Lazy;", "ssrBridge", "Lcom/bytedance/ee/bear/document/ssr/SSRWebViewBridge;", "renderCallback", "com/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$renderCallback$1", "Lcom/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$renderCallback$1;", "webChromeClientDelegate", "com/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$webChromeClientDelegate$1", "Lcom/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$webChromeClientDelegate$1;", "getSSRScrollPosListner", "Lcom/bytedance/ee/bear/document/ssr/SSRWebViewBridge$GetSSRScrollPosListner;", "getGetSSRScrollPosListner", "()Lcom/bytedance/ee/bear/document/ssr/SSRWebViewBridge$GetSSRScrollPosListner;", "getSSRScrollPosListner$delegate", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "onLoadStart", "registerHtmlRequestListener", "onLoadSuccess", "onLoadFail", "code", "", "e", "", "renderHtmlCache", "htmlCache", "sendEventFromSsrWebView", "message", "Lcom/ss/android/lark/officewebview/bridge/Message;", "promptGetPendingSsr", TipCallBackData.RESULT, "Landroid/webkit/JsPromptResult;", "removeSsrWebView", "getHtmlCache", "byMemoryCache", "ensureSsrContainer", "Companion", "LoadState", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderHtmlCachePlugin extends DocumentPluginV3 implements x2.b {
    public static final a Companion = null;
    public static final String DOC_HTML_CACHE_FROM_FETCH = "fetchSSR";
    public static final String DOC_HTML_CACHE_FROM_LOCAL = "localSSR";
    private static final String PROMPT_GET_PENDING_SSR = "__getPendingSSR__";
    private static final String PROMPT_GET_SSR_SCROLL_POS = "biz.util.getSSRScrollPos";
    private static final String SSR_CONTAINER_TAG = "docs_sdk_ssr_container";
    public static final String TAG = "SSR_REN_RenderHtmlCachePlugin";
    private com.bytedance.ee.bear.contract.d analyticService;
    private String cacheFrom;
    private CompositeDisposable disposableContainer;
    private final Lazy getSSRScrollPosListner$delegate;
    private boolean jsRenderIsCalled;
    private LoadState loadState;
    private boolean renderCacheHtmlAlready;
    private boolean renderCacheInSsrWebView;
    private final f renderCallback;
    private final Lazy renderLoader$delegate;
    private com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a requestListener;
    private final com.bytedance.ee.bear.document.ssr.b ssrBridge;
    private ViewGroup ssrWebViewContainer;
    private final i webChromeClientDelegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/ssr/plugin/RenderHtmlCachePlugin$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_LOAD", "LOADING", "SUCCESS", "FAILED", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState BEFORE_LOAD = null;
        public static final LoadState FAILED = null;
        public static final LoadState LOADING = null;
        public static final LoadState SUCCESS = null;
        public static final /* synthetic */ LoadState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadState> getEntries() {
            return b;
        }

        static {
            LoadState r0 = new LoadState("BEFORE_LOAD", 0);
            BEFORE_LOAD = r0;
            LoadState r1 = new LoadState("LOADING", 1);
            LOADING = r1;
            LoadState r3 = new LoadState("SUCCESS", 2);
            SUCCESS = r3;
            LoadState r5 = new LoadState("FAILED", 3);
            FAILED = r5;
            LoadState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static LoadState[] values() {
            return (LoadState[]) a.clone();
        }

        public static LoadState valueOf(String r1) {
            return (LoadState) r27.a.a(LoadState.class, r1);
        }

        public LoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public b(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            String r3 = RenderHtmlCachePlugin.access$getHtmlCache(this.a, false);
            if (r3 != null) goto L6;
            return "";
        L6:
            return r3;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public c(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            if (r3 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            RenderHtmlCachePlugin.access$registerHtmlRequestListener(this.a);
            return;
        L11:
            RenderHtmlCachePlugin.access$renderHtmlCache(this.a, r3);
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r0 = false;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public d(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f("SSR_REN_RenderHtmlCachePlugin", (Throwable) r3, false);
            RenderHtmlCachePlugin.access$registerHtmlRequestListener(this.a);
        }
    }

    public static final class e implements com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public e(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a
        public final boolean a(OfflineDoc r5) {
            Intrinsics.checkNotNullParameter(r5, "offlineDoc");
            DocViewModel r0 = this.a.getDocViewModel();
            boolean r1 = false;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (TextUtils.equals(r5.getObj_token(), r0.getToken()) == false) goto L22;
            String r6 = sbb.e.f(r5.getType());
            BearUrl r2 = r0.getBearUrl();
            if (r2 == null) goto L10;
            String r3 = r2.a;
        L12:
            if (TextUtils.equals(r6, r3) == false) goto L22;
            String r7 = RenderHtmlCachePlugin.getHtmlCache$default(this.a, false, 1, null);
            if (r7 != null) goto L17;
        L18:
            r1 = true;
        L19:
            if (r1 == true) goto L21;
            RenderHtmlCachePlugin.access$setCacheFrom$p(this.a, "fetchSSR");
            RenderHtmlCachePlugin.access$renderHtmlCache(this.a, r7);
        L21:
            return true;
        L17:
            if (r7.length() != 0) goto L19;
        L10:
            r3 = null;
        L22:
            return false;
        }
    }

    public static final class f implements m0 {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r1, Map r2) {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r1) {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
            RenderHtmlCachePlugin.access$setRenderCacheHtmlAlready$p(this.a, true);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            RenderHtmlCachePlugin.access$setJsRenderIsCalled$p(this.a, true);
        }

        public f(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }
    }

    public static final class g implements u35.a.InterfaceC0304a {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        @Override // u35.a.InterfaceC0304a
        public final void a() {
            x2 r0 = this.a.getDocumentLoader();
            if ((r0 instanceof DocumentLoaderV3) == false) goto L5;
            DocumentLoaderV3 r1 = (DocumentLoaderV3) r0;
        L6:
            if (r1 == null) goto L8;
            r1.k();
        L8:
            ChameleonPluginHost r2 = this.a.getHost();
            if (r2 == null) goto L14;
            com.bytedance.ee.bear.document.container.a r3 = (com.bytedance.ee.bear.document.container.a) r2.getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
            if (r3 == null) goto L15;
            r3.hideLoading();
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public g(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        @Override // u35.a.InterfaceC0304a
        public final void b(SendEventData r5) {
            com.bytedance.ee.bear.contract.d r0 = RenderHtmlCachePlugin.access$getAnalyticService$p(this.a);
            if (r0 == null) goto L5;
            r0.j("render_cache", "render_cache_from", RenderHtmlCachePlugin.access$getCacheFrom$p(this.a));
        L5:
            Message r1 = new Message();
            r1.setApiName("biz.statistics.sendEvent");
            String r6 = GsonProtectorUtils.toJson(new Gson(), r5);
            if (r6 != null) goto L8;
            r6 = "{}";
        L8:
            r1.setData(r6);
            RenderHtmlCachePlugin.access$sendEventFromSsrWebView(this.a, r1);
        }
    }

    public static final class h implements m {
        public h() {
        }

        @Override // tb5.m
        public final void a(NonProguard r1) {
        }

        @Override // tb5.m
        public final void b(JSONObject r1) {
        }

        @Override // tb5.m
        public final void onCallBack(String r1) {
        }
    }

    public static final class i extends WebChromeClient {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public i(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView r2, String r3, String r4, String r5, JsPromptResult r6) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "message");
            Intrinsics.checkNotNullParameter(r5, "defaultValue");
            Intrinsics.checkNotNullParameter(r6, TipCallBackData.RESULT);
            if (Intrinsics.areEqual(r4, RenderHtmlCachePlugin.PROMPT_GET_PENDING_SSR) == false) goto L6;
            return RenderHtmlCachePlugin.access$promptGetPendingSsr(this.a, r6);
        L6:
            if (Intrinsics.areEqual(r4, RenderHtmlCachePlugin.PROMPT_GET_SSR_SCROLL_POS) == false) goto L14;
            com.bytedance.ee.bear.document.ssr.b r7 = RenderHtmlCachePlugin.access$getSsrBridge$p(this.a);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r6, "promptReulst");
            if (r7.a != null) goto L10;
            tt5.a.k("SSR_REN_SSRWebViewBridge", "listner is null");
            r6.confirm("{}");
        L13:
            return true;
        L10:
            com.bytedance.ee.bear.document.ssr.b.c r8 = new com.bytedance.ee.bear.document.ssr.b.c(r6);
            com.bytedance.ee.bear.document.ssr.b.InterfaceC0107b r9 = r7.a;
            if (r9 == null) goto L13;
            r9.a(r8);
            goto L13
        L14:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    private final void registerHtmlRequestListener() {
        boolean r1 = false;
        String r0 = getHtmlCache$default(this, false, 1, null);
        if (r0 != null) goto L5;
    L6:
        r1 = true;
    L7:
        if (r1 == true) goto L11;
        renderHtmlCache(r0);
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderHtmlCache not null");
        return;
    L11:
        if (this.requestListener != null) goto L13;
        this.requestListener = new e(this);
    L13:
        com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a r2 = this.requestListener;
        if (r2 == null) goto L19;
        ArrayList<com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a> r3 = com.bytedance.ee.bear.document.ssr.a.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ArrayList<com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a> r4 = com.bytedance.ee.bear.document.ssr.a.a;
        if (r4.contains(r2) == true) goto L20;
        r4.add(r2);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r0.length() != 0) goto L7;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    private final com.bytedance.ee.bear.document.ssr.b.InterfaceC0107b getGetSSRScrollPosListner() {
        return (com.bytedance.ee.bear.document.ssr.b.InterfaceC0107b) this.getSSRScrollPosListner$delegate.getValue();
    }

    private final DocumentLoaderV3 getRenderLoader() {
        return (DocumentLoaderV3) this.renderLoader$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [v35.a, vv4.a] */
    private final void removeSsrWebView() {
        com.bytedance.ee.bear.document.ssr.b r0 = this.ssrBridge;
        if (Intrinsics.areEqual(r0.a, getGetSSRScrollPosListner()) == false) goto L5;
        r0.a = null;
    L5:
        this.disposableContainer.dispose();
        this.disposableContainer = new CompositeDisposable();
        if (this.renderCacheInSsrWebView == false) goto L43;
        this.renderCacheInSsrWebView = false;
        ViewGroup r1 = this.ssrWebViewContainer;
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        ViewGroup r2 = this.ssrWebViewContainer;
        if (r2 == null) goto L13;
        r2.removeAllViews();
    L13:
        u35.a r3 = u35.a.a;
        ViewGroup r4 = this.ssrWebViewContainer;
        if (r4 == null) goto L48;
        ChameleonWebView r5 = u35.a.b;
        if (r5 != null) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r5.getParent(), r4) == false) goto L22;
        r4.removeView(r5);
    L22:
        u35.c r6 = u35.a.c;
        if (r6 == null) goto L25;
        r6.b = "{}";
        j.e(r6.c);
        r6.a.B(r6.d);
    L25:
        r5.scrollTo(0, 0);
        ?? r7 = (v35.a) r5.getWebService(v35.a.class);
        if (r7 == 0) goto L44;
        r7.c = null;
        r7.d = null;
        r7.e = null;
        r7.f = 0;
        if ((!((HashMap) r7.b).isEmpty()) == false) goto L45;
        k r8 = r7.getWeb();
        if (r8 == null) goto L32;
        r8.execJS("javascript:clear");
    L32:
        k r9 = r7.getWeb();
        if (r9 == null) goto L37;
        WebView r10 = r9.getWebView();
        if (r10 == null) goto L37;
        r10.evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
    L37:
        k r11 = r7.getWeb();
        if (r11 == null) goto L46;
        WebView r12 = r11.getWebView();
        if (r12 == null) goto L47;
        r12.clearHistory();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L48:
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        this.loadState = LoadState.LOADING;
        x2 r0 = getDocumentLoader();
        if (r0 == null) goto L5;
        r0.S(this);
    L5:
        x2 r1 = getDocumentLoader();
        if (r1 == null) goto L9;
        r1.S3(this);
    L9:
        if (this.renderCacheHtmlAlready == false) goto L12;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderCacheHtmlAlready");
        return;
    L12:
        boolean r2 = false;
        String r3 = getHtmlCache$default(this, false, 1, null);
        if (r3 != null) goto L15;
    L16:
        r2 = true;
    L17:
        if (r2 == true) goto L19;
        renderHtmlCache(r3);
        return;
    L19:
        Disposable r4 = Flowable.just("").observeOn(fo5.d.c()).map(new b(this)).observeOn(fo5.d.d()).subscribe(new c(this), new d(this));
        this.disposableContainer.add(r4);
        return;
    L15:
        if (r3.length() != 0) goto L17;
        goto L16
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        this.loadState = LoadState.SUCCESS;
        com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a r0 = this.requestListener;
        TypeIntrinsics.asMutableCollection(com.bytedance.ee.bear.document.ssr.a.a).remove(r0);
        removeSsrWebView();
    }

    public RenderHtmlCachePlugin() {
        this.cacheFrom = "localSSR";
        this.loadState = LoadState.BEFORE_LOAD;
        this.disposableContainer = new CompositeDisposable();
        this.renderLoader$delegate = LazyKt.lazy(new RenderHtmlCachePlugin$renderLoader$2(this));
        this.ssrBridge = new com.bytedance.ee.bear.document.ssr.b();
        this.renderCallback = new f(this);
        this.webChromeClientDelegate = new i(this);
        this.getSSRScrollPosListner$delegate = LazyKt.lazy(new RenderHtmlCachePlugin$getSSRScrollPosListner$2(this));
    }

    public final boolean getRenderCacheInSsrWebView() {
        return this.renderCacheInSsrWebView;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.contract.d access$getAnalyticService$p(RenderHtmlCachePlugin r0) {
        return r0.analyticService;
    }

    public static final /* synthetic */ String access$getCacheFrom$p(RenderHtmlCachePlugin r0) {
        return r0.cacheFrom;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.document.ssr.b access$getSsrBridge$p(RenderHtmlCachePlugin r0) {
        return r0.ssrBridge;
    }

    public static final /* synthetic */ ViewGroup access$getSsrWebViewContainer$p(RenderHtmlCachePlugin r0) {
        return r0.ssrWebViewContainer;
    }

    public static final /* synthetic */ void access$registerHtmlRequestListener(RenderHtmlCachePlugin r0) {
        r0.registerHtmlRequestListener();
    }

    private final ViewGroup ensureSsrContainer(t r3) {
        View r4 = r3.getContentView().findViewById(2131367056);
        if ((r4 instanceof ViewGroup) == false) goto L5;
        ViewGroup r5 = (ViewGroup) r4;
    L6:
        this.ssrWebViewContainer = r5;
        if (r5 == null) goto L10;
        r5.setTag(SSR_CONTAINER_TAG);
        r5.setVisibility(8);
        return r5;
    L10:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    private final String getHtmlCache(boolean r6) {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return null;
    L5:
        BearUrl r2 = r0.getBearUrl();
        if (r2 == null) goto L27;
        String r3 = r2.b;
        if (r3 == null) goto L27;
        AccountService$Account r4 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r4 != null) goto L13;
        return null;
    L13:
        BearUrl r5 = r0.getBearUrl();
        if (r5 == null) goto L27;
        String r7 = r5.a;
        if (r7 == null) goto L27;
        BearUrl r1 = r0.getBearUrl();
        if (r1 == null) goto L22;
        Map r8 = r1.d;
        if (r8 == null) goto L22;
    L23:
        if (r6 == false) goto L26;
        return com.bytedance.ee.bear.document.ssr.c.b(r4, r3, r7, r8);
    L26:
        return com.bytedance.ee.bear.document.ssr.c.a(r4, r3, r7, r8);
    L22:
        r8 = new HashMap();
    L27:
        return null;
    }

    private final boolean promptGetPendingSsr(JsPromptResult r11) {
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L5;
        BearUrl r2 = r1.getBearUrl();
    L6:
        org.json.JSONObject r3 = new org.json.JSONObject();
        com.bytedance.ee.bear.contract.d r4 = this.analyticService;
        if (r4 == null) goto L9;
        String r5 = r4.e("render_cache", "value_render_cache_prompt_count");
    L47:
        if (TextUtils.isEmpty(r5) == true) goto L17;
        if (r5 == null) goto L17;
        String r6 = String.valueOf(CastIntegerProtector.parseInt(r5) + 1);     // Catch: Throwable -> L16
    L18:
        com.bytedance.ee.bear.contract.d r8 = this.analyticService;
        if (r8 == null) goto L21;
        r8.j("render_cache", "value_render_cache_prompt_count", r6);
    L21:
        AccountService$Account r7 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        boolean r9 = false;
        String r10 = "{}";
        if (r7 == null) goto L45;
        if (r2 == null) goto L45;
        int r12 = com.bytedance.ee.bear.document.ssr.c.a;
        String r13 = r2.b;
        String r14 = r2.a;
        Map<String, String> r16 = r2.d;
        if (r16 != null) goto L27;
        r16 = MapsKt.emptyMap();
    L27:
        String r17 = com.bytedance.ee.bear.document.ssr.c.b(r7, r13, r14, r16);
        if (r17 != null) goto L30;
    L33:
        boolean r18 = true;
    L34:
        if (r18 == true) goto L45;
        int r19 = r17.length();
        DocOpenConfig.a();
        if (r19 <= DocOpenConfig.g.get_pending_ssr_max_length) goto L40;
        com.bytedance.ee.bear.contract.d r20 = this.analyticService;
        if (r20 == null) goto L44;
        r20.j("render_cache", "render_cache_over_limit", DiagramData$RESULT.SUCCESS);
    L44:
        r9 = true;
        goto L45
    L40:
        this.renderCacheHtmlAlready = false;
        com.bytedance.ee.bear.contract.d r0 = this.analyticService;
        if (r0 == null) goto L43;
        r0.j("render_cache", "render_cache_from", "prompt");
    L43:
        r10 = r17;
        goto L44
    L30:
        if (r17.length() == 0) goto L33;
        r18 = false;
    L45:
        r3.put("ssrContent", r10);
        r3.put("disable_next_time", r9);
        r11.confirm(r3.toString());
        return true;
    L17:
        r6 = DiagramData$RESULT.SUCCESS;
        goto L18
    L9:
        r5 = null;
        goto L47
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void renderHtmlCache(String r9) {
        if (this.jsRenderIsCalled == false) goto L14;
        if (DocOpenConfig.f().enable_after_render == true) goto L14;
        DocumentLoaderV3 r10 = getRenderLoader();
        if (r10 == null) goto L11;
        o r11 = r10.h;
        if (r11 == null) goto L11;
        r11.a("renderSSRWebviewType", 0);
    L11:
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderHtmlCache jsRenderIsCalled " + this.jsRenderIsCalled);
        return;
    L14:
        if (this.renderCacheHtmlAlready == false) goto L23;
        DocumentLoaderV3 r12 = getRenderLoader();
        if (r12 == null) goto L20;
        o r13 = r12.h;
        if (r13 == null) goto L20;
        r13.a("renderSSRWebviewType", 0);
    L20:
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderHtmlCache renderCacheHtmlAlready " + this.renderCacheHtmlAlready);
        return;
    L23:
        if (this.loadState == LoadState.LOADING) goto L26;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderHtmlCache loadState " + this.loadState);
        return;
    L26:
        ChameleonPluginHost r0 = getHost();
        ViewGroup r2 = null;
        if (r0 == null) goto L33;
        LifecycleOwner r1 = r0.getLifecycleOwner();
        if (r1 == null) goto L33;
        Lifecycle r3 = r1.getLifecycle();
        if (r3 == null) goto L33;
        Lifecycle.State r4 = r3.getCurrentState();
    L35:
        if (r4 != Lifecycle.State.RESUMED) goto L37;
    L42:
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L96;
        BearUrl r6 = r5.getBearUrl();
        if (r6 == null) goto L102;
        ViewGroup r7 = ensureSsrContainer(getUIContainer());
        this.ssrWebViewContainer = r7;
        if (r7 == null) goto L50;
        r7.setVisibility(0);
    L50:
        this.ssrBridge.a = getGetSSRScrollPosListner();
        DocumentLoaderV3 r8 = getRenderLoader();
        if (r8 == null) goto L55;
        o r14 = r8.h;
        if (r14 == null) goto L55;
        r14.a("renderSSRWebviewType", 1);
    L55:
        DocumentLoaderV3 r16 = getRenderLoader();
        if (r16 == null) goto L58;
        boolean r17 = com.bytedance.ee.bear.document.render.node.a.a;
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter("ssrwebview", DocRedirectToDocxPlugin.FROM);
        com.bytedance.ee.bear.document.render.node.a.a(r16, "load ssr cache, from = ".concat("ssrwebview"));
    L58:
        this.renderCacheInSsrWebView = true;
        u35.a r18 = u35.a.a;
        ViewGroup r19 = this.ssrWebViewContainer;
        g r20 = new g(this);
        Intrinsics.checkNotNullParameter(r9, "cacheHtml");
        Intrinsics.checkNotNullParameter(r6, "bearUrl");
        Intrinsics.checkNotNullParameter(r20, "loadCallBack");
        if (r19 == null) goto L99;
        monitor-enter(r18);
    L93:
        th = move-exception;
        throw th;
    L63:
        if (u35.a.b == null) goto L67;
        tt5.a.h("SSR_REN_SsrWebViewManager", "ensureWebViewNotNull: ssrWebView is not null");     // Catch: Throwable -> L93
        monitor-exit(r18);
    L69:
        ChameleonWebView r21 = u35.a.b;
        if (r21 == null) goto L100;
        v35.a r22 = (v35.a) r21.getWebService(v35.a.class);
        if (r22 == null) goto L101;
        ViewParent r23 = r21.getParent();
        if ((r23 instanceof ViewGroup) == false) goto L78;
        r2 = (ViewGroup) r23;
    L78:
        if (r2 == null) goto L83;
        if (Intrinsics.areEqual(r2, r19) == true) goto L83;
        r2.removeView(r21);
    L83:
        if (r21.getParent() != null) goto L85;
        r19.addView(r21, -1, -1);
    L85:
        u35.c r24 = u35.a.c;
        if (r24 == null) goto L88;
        r24.a.B(r24.d);
        r24.a.x(r24.d);
    L88:
        u35.b r26 = new u35.b(r20);
        Intrinsics.checkNotNullParameter(r9, "html");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r26, "callback");
        r22.e = r26;
        r22.c = r6;
        r22.d = r9;
        com.bytedance.ee.bear.contract.d r27 = r22.a;
        Object r28 = ((HashMap) r22.b).get(r6.a);
        Boolean r29 = Boolean.TRUE;
        r27.j("render_cache", "value_render_cache_ssrwebview_is_ready", String.valueOf(Intrinsics.areEqual(r28, r29)));
        if (Intrinsics.areEqual(((HashMap) r22.b).get(r6.a), r29) == false) goto L91;
        tt5.a.h("SSR_REN_SsrWebViewWebService", r6.a + " is ready call");
        r22.e(r9);
        return;
    L91:
        r22.f = System.currentTimeMillis();
        tt5.a.h("SSR_REN_SsrWebViewWebService", r6.a + " is not ready");
        return;
    L101:
        return;
    L100:
        return;
    L67:
        u35.a.e = true;     // Catch: Throwable -> L93
        u35.a.c(null);     // Catch: Throwable -> L93
        monitor-exit(r18);
        goto L69
    L99:
        return;
    L102:
        return;
    L96:
        return;
    L37:
        if (r4 == Lifecycle.State.STARTED) goto L42;
        if (r4 == Lifecycle.State.CREATED) goto L42;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "renderHtmlCache state " + r4);
        return;
    L33:
        r4 = null;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void sendEventFromSsrWebView(Message r4) {
        ChameleonPluginHost r0 = getHost();
        ChameleonSafeReuseWeb r1 = null;
        if (r0 == null) goto L5;
        k r2 = r0.getChameleonWeb();
    L7:
        if ((r2 instanceof ChameleonSafeReuseWeb) == false) goto L9;
        r1 = (ChameleonSafeReuseWeb) r2;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        r1.J(r4, new h());
        return;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.analyticService = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        DocumentLoaderV3 r4 = getRenderLoader();
        if (r4 == null) goto L5;
        r4.m(this.renderCallback);
    L5:
        k r5 = getWeb();
        if (r5 == null) goto L9;
        r5.addWebChromeClientDelegate(this.webChromeClientDelegate);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r3) {
        DocumentLoaderV3 r0 = getRenderLoader();
        if (r0 == null) goto L5;
        r0.n(this.renderCallback);
    L5:
        k r1 = getWeb();
        if (r1 == null) goto L8;
        r1.removeWebChromeClientDelegate(this.webChromeClientDelegate);
    L8:
        x2 r2 = getDocumentLoader();
        if (r2 == null) goto L11;
        r2.S(this);
    L11:
        u35.a r4 = u35.a.a;
        if (u35.a.e == false) goto L14;
        u35.a.c(null);
    L14:
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r3);
    }

    public final void setRenderCacheInSsrWebView(boolean r1) {
        this.renderCacheInSsrWebView = r1;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ String access$getHtmlCache(RenderHtmlCachePlugin r0, boolean r1) {
        return r0.getHtmlCache(r1);
    }

    public static final /* synthetic */ boolean access$promptGetPendingSsr(RenderHtmlCachePlugin r0, JsPromptResult r1) {
        return r0.promptGetPendingSsr(r1);
    }

    public static final /* synthetic */ void access$renderHtmlCache(RenderHtmlCachePlugin r0, String r1) {
        r0.renderHtmlCache(r1);
    }

    public static final /* synthetic */ void access$sendEventFromSsrWebView(RenderHtmlCachePlugin r0, Message r1) {
        r0.sendEventFromSsrWebView(r1);
    }

    public static final /* synthetic */ void access$setCacheFrom$p(RenderHtmlCachePlugin r0, String r1) {
        r0.cacheFrom = r1;
    }

    public static final /* synthetic */ void access$setJsRenderIsCalled$p(RenderHtmlCachePlugin r0, boolean r1) {
        r0.jsRenderIsCalled = r1;
    }

    public static final /* synthetic */ void access$setRenderCacheHtmlAlready$p(RenderHtmlCachePlugin r0, boolean r1) {
        r0.renderCacheHtmlAlready = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        if (r2 != null) goto L5;
        return;
    L5:
        onLoadStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r3, t r4) {
        removeSsrWebView();
        com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a r0 = this.requestListener;
        TypeIntrinsics.asMutableCollection(com.bytedance.ee.bear.document.ssr.a.a).remove(r0);
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r3, r4);
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r1, Throwable r2) {
        this.loadState = LoadState.FAILED;
        com.bytedance.ee.bear.document.ssr.a.InterfaceC0106a r3 = this.requestListener;
        TypeIntrinsics.asMutableCollection(com.bytedance.ee.bear.document.ssr.a.a).remove(r3);
        removeSsrWebView();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static /* synthetic */ String getHtmlCache$default(RenderHtmlCachePlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.getHtmlCache(r1);
    }
}
