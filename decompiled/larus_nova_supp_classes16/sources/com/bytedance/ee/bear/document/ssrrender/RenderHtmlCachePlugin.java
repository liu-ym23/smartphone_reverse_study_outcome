package com.bytedance.ee.bear.document.ssrrender;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.g7;
import com.bytedance.ee.bear.document.loading.DocLoadingPlugin;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k25.e0;
import k25.m0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import vv4.k;
import w35.h;
import w35.i;
import w35.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0016J\u001a\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0014\u00100\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00101\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/document/ssrrender/RenderHtmlCachePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/DocumentLoader$LoadingCallback;", "<init>", "()V", "cacheFrom", "", "mCsrWebView", "Lcom/bytedance/ee/bear/document/ISafeReuseDocumentWeb;", "mAnalyticService", "Lcom/bytedance/ee/bear/contract/AnalyticService;", "showCacheToast", "", "mRequestListener", "Lcom/bytedance/ee/bear/document/ssrrender/HtmlCacheRequestManager$HtmlCacheRequestListener;", "mLoadState", "Lcom/bytedance/ee/bear/document/ssrrender/RenderHtmlCachePlugin$LoadState;", "ssrWebViewContainer", "Landroid/view/ViewGroup;", "mDisposableContainer", "Lio/reactivex/disposables/CompositeDisposable;", "renderCacheInSsrWebView", "mGetSSRScrollPosListner", "Lcom/bytedance/ee/bear/document/ssrrender/SSRWebViewBridge$GetSSRScrollPosListner;", "getMGetSSRScrollPosListner", "()Lcom/bytedance/ee/bear/document/ssrrender/SSRWebViewBridge$GetSSRScrollPosListner;", "mGetSSRScrollPosListner$delegate", "Lkotlin/Lazy;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "onLoadStart", "registerHtmlRequestListener", "onLoadSuccess", "onLoadFail", "code", "", "e", "", "renderHtmlCache", "htmlCache", "removeSsrWebView", "getHtmlCache", "byMemoryCache", "Companion", "LoadState", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderHtmlCachePlugin extends DocumentPluginV2 implements x2.b {
    public static final a Companion = null;
    public static final String DOC_HTML_CACHE_FROM_FETCH = "fetchSSR";
    public static final String DOC_HTML_CACHE_FROM_LOCAL = "localSSR";
    public static final String TAG = "SSR_REN_RenderHtmlCachePlugin";
    private String cacheFrom;
    private com.bytedance.ee.bear.contract.d mAnalyticService;
    private z4 mCsrWebView;
    private CompositeDisposable mDisposableContainer;
    private final Lazy mGetSSRScrollPosListner$delegate;
    private LoadState mLoadState;
    private HtmlCacheRequestManager.a mRequestListener;
    private boolean renderCacheInSsrWebView;
    private boolean showCacheToast;
    private ViewGroup ssrWebViewContainer;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/ssrrender/RenderHtmlCachePlugin$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_LOAD", "LOADING", "SUCCESS", "FAILED", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static final class e implements HtmlCacheRequestManager.a {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        public e(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.ssrrender.HtmlCacheRequestManager.a
        public final boolean a(OfflineDoc r4) {
            Intrinsics.checkNotNullParameter(r4, "offlineDoc");
            String r0 = r4.getObj_token();
            DocViewModel r1 = RenderHtmlCachePlugin.access$getDocViewModel(this.a);
            if (r1 == null) goto L5;
            String r2 = r1.getToken();
        L6:
            boolean r3 = TextUtils.equals(r0, r2);
            boolean r5 = false;
            if (r3 == false) goto L26;
            String r6 = sbb.e.f(r4.getType());
            DocViewModel r7 = RenderHtmlCachePlugin.access$getDocViewModel(this.a);
            if (r7 == null) goto L13;
            BearUrl r8 = r7.getBearUrl();
            if (r8 == null) goto L13;
            String r9 = r8.a;
        L15:
            if (TextUtils.equals(r6, r9) == false) goto L26;
            String r10 = RenderHtmlCachePlugin.getHtmlCache$default(this.a, false, 1, null);
            if (r10 != null) goto L20;
        L21:
            r5 = true;
        L22:
            if (r5 == false) goto L24;
            tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "processHtmlResult... htmlCacheFromNet is isNullOrEmpty");
        L25:
            return true;
        L24:
            RenderHtmlCachePlugin.access$setCacheFrom$p(this.a, "fetchSSR");
            RenderHtmlCachePlugin.access$renderHtmlCache(this.a, r10);
            goto L25
        L20:
            if (r10.length() != 0) goto L22;
        L13:
            r9 = null;
        L26:
            return false;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class f implements w35.a.c {
        public final /* synthetic */ RenderHtmlCachePlugin a;

        @Override // w35.a.c
        public final void b(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "jsonObject");
        }

        @Override // w35.a.c
        public final void a() {
            tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "hideLoading...");
            DocLoadingPlugin r0 = (DocLoadingPlugin) RenderHtmlCachePlugin.access$findPlugin(this.a, DocLoadingPlugin.class);
            if (r0 == null) goto L6;
            r0.hideLoading();
            return;
        }

        public f(RenderHtmlCachePlugin r1) {
            this.a = r1;
        }

        @Override // w35.a.c
        public final void c(SendEventData r5) {
            com.bytedance.ee.bear.contract.d r0 = RenderHtmlCachePlugin.access$getMAnalyticService$p(this.a);
            if (r0 == null) goto L5;
            r0.j("render_cache", "render_cache_from", RenderHtmlCachePlugin.access$getCacheFrom$p(this.a));
        L5:
            z4 r1 = RenderHtmlCachePlugin.access$getMCsrWebView$p(this.a);
            if (r1 == null) goto L9;
            r1.y(r5);
            return;
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
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "registerHtmlRequestListener, but we have ssr cache in MemoryCache");
        renderHtmlCache(r0);
        return;
    L11:
        if (this.mRequestListener != null) goto L13;
        this.mRequestListener = new e(this);
    L13:
        HtmlCacheRequestManager.a r2 = this.mRequestListener;
        if (r2 == null) goto L19;
        ArrayList<HtmlCacheRequestManager.a> r3 = HtmlCacheRequestManager.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ArrayList<HtmlCacheRequestManager.a> r4 = HtmlCacheRequestManager.a;
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

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    private final com.bytedance.ee.bear.document.ssrrender.a.b getMGetSSRScrollPosListner() {
        return (com.bytedance.ee.bear.document.ssrrender.a.b) this.mGetSSRScrollPosListner$delegate.getValue();
    }

    private final void removeSsrWebView() {
        z4 r0 = this.mCsrWebView;
        if (r0 == null) goto L5;
        r0.D(getMGetSSRScrollPosListner());
    L5:
        this.mDisposableContainer.dispose();
        this.mDisposableContainer = new CompositeDisposable();
        if (this.renderCacheInSsrWebView == false) goto L23;
        this.renderCacheInSsrWebView = false;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "removeSsrWebView...");
        ViewGroup r1 = this.ssrWebViewContainer;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ssrWebViewContainer");
        r1 = null;
    L10:
        r1.setVisibility(8);
        r1.removeAllViews();
        h r4 = h.a;
        Intrinsics.checkNotNullParameter(r1, "viewGroup");
        LarkWebView r5 = h.b;
        if (r5 == null) goto L13;
        ViewParent r6 = r5.getParent();
    L15:
        if (Intrinsics.areEqual(r6, r1) == true) goto L17;
        tt5.a.h("SSR_REN_SsrWebViewManager", "removeSsrWebView, viewGroup is not parent");
        return;
    L17:
        tt5.a.h("SSR_REN_SsrWebViewManager", "removeSsrWebView...");
        r1.removeView(h.b);
        j r2 = h.c;
        if (r2 == null) goto L25;
        tt5.a.h("SSR_REN_ScrollChange", "stop... count = " + r2.c);
        r2.c = 0;
        r2.b = "{}";
        com.bytedance.ee.util.ui.j.e(r2.d);
        w35.a r3 = r2.a;
        if (Intrinsics.areEqual(r2.e, r3.F) == false) goto L26;
        r3.F = null;
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r6 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        this.mLoadState = LoadState.LOADING;
        g7 r0 = getWebEditorAbility();
        if (r0 == null) goto L5;
        k r1 = r0.getWeb();
    L7:
        if ((r1 instanceof z4) == true) goto L10;
        tt5.a.k("SSR_REN_RenderHtmlCachePlugin", "webview is not ISafeReuseDocumentWeb");
        return;
    L10:
        z4 r2 = (z4) r1;
        this.mCsrWebView = r2;
        boolean r3 = true;
        if (r2 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "render html cache by csr webview");
        return;
    L19:
        String r5 = getHtmlCache$default(this, false, 1, null);
        if (r5 != null) goto L22;
    L25:
        if (r3 == true) goto L27;
        renderHtmlCache(r5);
        return;
    L27:
        this.mDisposableContainer.add(Flowable.just("").observeOn(fo5.d.c()).map(new b(this)).observeOn(fo5.d.d()).subscribe(new c(this), new d(this)));
        return;
    L22:
        if (r5.length() == 0) goto L25;
        r3 = false;
        goto L25
    L13:
        if (r2.f() != true) goto L15;
        r4 = true;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        this.mLoadState = LoadState.SUCCESS;
        HtmlCacheRequestManager.a r0 = this.mRequestListener;
        TypeIntrinsics.asMutableCollection(HtmlCacheRequestManager.a).remove(r0);
        removeSsrWebView();
    }

    public RenderHtmlCachePlugin() {
        this.cacheFrom = "localSSR";
        this.mLoadState = LoadState.BEFORE_LOAD;
        this.mDisposableContainer = new CompositeDisposable();
        this.mGetSSRScrollPosListner$delegate = LazyKt.lazy(new RenderHtmlCachePlugin$mGetSSRScrollPosListner$2(this));
    }

    public static final /* synthetic */ String access$getCacheFrom$p(RenderHtmlCachePlugin r0) {
        return r0.cacheFrom;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(RenderHtmlCachePlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.contract.d access$getMAnalyticService$p(RenderHtmlCachePlugin r0) {
        return r0.mAnalyticService;
    }

    public static final /* synthetic */ z4 access$getMCsrWebView$p(RenderHtmlCachePlugin r0) {
        return r0.mCsrWebView;
    }

    public static final /* synthetic */ ViewGroup access$getSsrWebViewContainer$p(RenderHtmlCachePlugin r0) {
        return r0.ssrWebViewContainer;
    }

    public static final /* synthetic */ void access$registerHtmlRequestListener(RenderHtmlCachePlugin r0) {
        r0.registerHtmlRequestListener();
    }

    private final String getHtmlCache(boolean r7) {
        DocViewModel r0 = getDocViewModel();
        String r1 = "";
        if (r0 == null) goto L8;
        BearUrl r2 = r0.getBearUrl();
        if (r2 == null) goto L8;
        String r3 = r2.b;
        if (r3 == null) goto L8;
    L9:
        PluginHost r4 = getHost();
        if (r4 == null) goto L16;
        vo5.a r5 = r4.getUserComponent();
        if (r5 == null) goto L16;
        h0 r6 = (h0) r5.a(h0.class);
        if (r6 == null) goto L16;
        AccountService$Account r8 = r6.G2();
    L17:
        DocViewModel r9 = getDocViewModel();
        if (r9 == null) goto L25;
        BearUrl r10 = r9.getBearUrl();
        if (r10 == null) goto L25;
        String r11 = r10.a;
        if (r11 == null) goto L25;
        r1 = r11;
    L25:
        DocViewModel r12 = getDocViewModel();
        if (r12 == null) goto L31;
        BearUrl r13 = r12.getBearUrl();
        if (r13 == null) goto L31;
        Map r14 = r13.d;
        if (r14 == null) goto L31;
    L32:
        FetchClientVarExecutor r16 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
        String r17 = n35.a.b(r8, r1, r14);
        if (r7 == true) goto L39;
        m0 r18 = e0.m().o(r8, r3, r1, r14);
        if (r18 != null) goto L38;
        return null;
    L38:
        return r18.c;
    L39:
        return e0.m().n(r17, r3).c;
    L31:
        r14 = new HashMap();
    L16:
        r8 = null;
    L8:
        r3 = "";
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [android.webkit.WebView, w35.a] */
    private final void renderHtmlCache(String r11) {
        z4 r0 = this.mCsrWebView;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
    L16:
        z4 r2 = this.mCsrWebView;
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L29;
        z4 r12 = this.mCsrWebView;
        if (r12 == null) goto L26;
        r12.b("renderSSRWebviewType", 0);
    L26:
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "isRenderCacheHtmlAlready is true");
        return;
    L29:
        if (this.mLoadState == LoadState.LOADING) goto L32;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "csr webview is not in loading");
        return;
    L32:
        PluginHost r4 = getHost();
        ViewGroup r5 = null;
        if (r4 == null) goto L39;
        LifecycleOwner r6 = r4.getLifecycleOwner();
        if (r6 == null) goto L39;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L39;
        Lifecycle.State r8 = r7.getCurrentState();
    L41:
        if (r8 != Lifecycle.State.RESUMED) goto L43;
    L48:
        DocViewModel r9 = getDocViewModel();
        if (r9 == null) goto L51;
        BearUrl r10 = r9.getBearUrl();
    L52:
        if (r10 == null) goto L93;
        ViewGroup r13 = this.ssrWebViewContainer;
        if (r13 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("ssrWebViewContainer");
        r13 = null;
    L56:
        r13.setVisibility(0);
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "render html cache in ssr webview");
        z4 r14 = this.mCsrWebView;
        if (r14 == null) goto L59;
        r14.q(getMGetSSRScrollPosListner());
    L59:
        z4 r16 = this.mCsrWebView;
        if (r16 == null) goto L62;
        r16.b("renderSSRWebviewType", 1);
    L62:
        this.renderCacheInSsrWebView = true;
        h r17 = h.a;
        ViewGroup r18 = this.ssrWebViewContainer;
        if (r18 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("ssrWebViewContainer");
        r18 = null;
    L65:
        f r19 = new f(this);
        Intrinsics.checkNotNullParameter(r18, "viewGroup");
        Intrinsics.checkNotNullParameter(r11, "cacheHtml");
        Intrinsics.checkNotNullParameter(r10, "bearUrl");
        Intrinsics.checkNotNullParameter(r19, "loadCallBack");
        LarkWebView r20 = h.b;
        if (r20 != null) goto L69;
        tt5.a.k("SSR_REN_SsrWebViewManager", "SsrWebView is null");
    L82:
        if (this.showCacheToast == false) goto L94;
        ViewGroup r21 = this.ssrWebViewContainer;
        if (r21 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("ssrWebViewContainer");
        r21 = null;
    L86:
        TextView r110 = new TextView(r21.getContext());
        r110.setText("SSR WebView");
        ViewGroup r22 = this.ssrWebViewContainer;
        if (r22 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("ssrWebViewContainer");
    L90:
        r5.addView(r110);
        return;
    L89:
        r5 = r22;
        goto L90
    L94:
        return;
    L69:
        if (r20.getParent() == null) goto L71;
        tt5.a.k("SSR_REN_SsrWebViewManager", "SsrWebView was added to viewGroup");
        goto L82
    L71:
        r18.addView(h.b, -1, -1);
        j r23 = h.c;
        if (r23 == null) goto L74;
        tt5.a.h("SSR_REN_ScrollChange", "start...");
        r23.a.setOnSsrScrollChangeListner(r23.e);
    L74:
        ?? r24 = h.b;
        if (r24 == 0) goto L82;
        i r26 = new i(r19);
        Intrinsics.checkNotNullParameter(r11, "htmlCache");
        Intrinsics.checkNotNullParameter(r10, "bearUrl");
        Intrinsics.checkNotNullParameter(r26, "loadCallBack");
        r24.clearView();
        com.bytedance.ee.bear.contract.d r27 = r24.G;
        Object r28 = ((HashMap) r24.A).get(r10.a);
        Boolean r29 = Boolean.TRUE;
        r27.j("render_cache", "value_render_cache_ssrwebview_is_ready", String.valueOf(Intrinsics.areEqual(r28, r29)));
        if (Intrinsics.areEqual(((HashMap) r24.A).get(r10.a), r29) == false) goto L79;
        r24.o(r11, r10);
    L80:
        r24.J = r26;
        goto L82
    L79:
        r24.E = System.currentTimeMillis();
        tt5.a.h("SSR_REN_SSRWebView", r10.a + " is not ready");
        r24.I = r11;
        r24.H = r10;
        goto L80
    L93:
        return;
    L51:
        r10 = null;
        goto L52
    L43:
        if (r8 == Lifecycle.State.STARTED) goto L48;
        if (r8 == Lifecycle.State.CREATED) goto L48;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "lifecycleOwner current state is " + r8);
        return;
    L39:
        r8 = null;
        goto L41
    L19:
        if (r2.f() != true) goto L21;
        r3 = true;
        goto L22
    L11:
        if (DocOpenConfig.f().enable_after_render == true) goto L16;
        tt5.a.h("SSR_REN_RenderHtmlCachePlugin", "after render, and enable_after_render is false");
        z4 r111 = this.mCsrWebView;
        if (r111 == null) goto L92;
        r111.b("renderSSRWebviewType", 0);
        return;
    L92:
        return;
    L5:
        if (r0.G() != true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        getEditorAbility().getDocumentLoader().S(this);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(RenderHtmlCachePlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ String access$getHtmlCache(RenderHtmlCachePlugin r0, boolean r1) {
        return r0.getHtmlCache(r1);
    }

    public static final /* synthetic */ void access$renderHtmlCache(RenderHtmlCachePlugin r0, String r1) {
        r0.renderHtmlCache(r1);
    }

    public static final /* synthetic */ void access$setCacheFrom$p(RenderHtmlCachePlugin r0, String r1) {
        r0.cacheFrom = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r4, t r5) {
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "uiContainer");
        View r0 = r5.findView(2131387152);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        this.ssrWebViewContainer = (ViewGroup) r0;
        this.showCacheToast = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
        this.mAnalyticService = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.mLoadState = LoadState.LOADING;
        getEditorAbility().getDocumentLoader().S3(this);
        onLoadStart();
        super.onAttachToUIContainer(r4, r5);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        removeSsrWebView();
        HtmlCacheRequestManager.a r4 = this.mRequestListener;
        TypeIntrinsics.asMutableCollection(HtmlCacheRequestManager.a).remove(r4);
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r1, Throwable r2) {
        this.mLoadState = LoadState.FAILED;
        HtmlCacheRequestManager.a r3 = this.mRequestListener;
        TypeIntrinsics.asMutableCollection(HtmlCacheRequestManager.a).remove(r3);
        removeSsrWebView();
    }

    public static /* synthetic */ String getHtmlCache$default(RenderHtmlCachePlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.getHtmlCache(r1);
    }
}
