package com.bytedance.ee.bear.document;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class x3 implements x2, d5, y4 {
    public static final /* synthetic */ int v = 0;
    public String a;
    public final DocumentPluginHost b;
    public final s1 c;
    public final a d;
    public final b e;
    public final List<x2.b> f;
    public final y2 g;
    public AccountService$Account h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public Disposable m;
    public b5 n;
    public j3 o;
    public u1 p;
    public boolean q;
    public final z05.d r;
    public z05.g s;
    public final CompositeDisposable t;
    public final boolean u;

    public class a implements com.bytedance.ee.bear.contract.m0 {
        public final /* synthetic */ x3 a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
            tt5.a.h(this.a.a, "onDownloadFullResource");
            x3 r0 = this.a;
            if (r0.p.a != DocLoadingState.WAITING_DOWNLOAD) goto L5;
            r0.c.n();
        L5:
            f();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
            tt5.a.h(this.a.a, "onDocGoBack");
            com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            if (r0.e("start_open", "start_time") != null) goto L6;
            r0.j("start_open", "start_time", String.valueOf(System.currentTimeMillis()));
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
            tt5.a.h(this.a.a, "onWaitPreloading");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).j("wait_preload", "start_time", String.valueOf(SystemClock.uptimeMillis()));
            this.a.p.m();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
            tt5.a.h(this.a.a, "onRenderByWaitPreload");
            if (((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a() == true) goto L5;
            return;
        L5:
            if (com.bytedance.ee.util.ui.j.a(this.a.g) == false) goto L9;
            com.bytedance.ee.util.ui.j.e(this.a.g);
            com.bytedance.ee.util.ui.j.d(this.a.g, DocOpenConfig.d());
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
            tt5.a.h(this.a.a, "onWaitDownloadFullResource");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).j("wait_download_resource", "start_time", String.valueOf(SystemClock.uptimeMillis()));
            this.a.p.l();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            tt5.a.h(this.a.a, "onRendering");
            x3 r0 = this.a;
            if (r0.p.a != DocLoadingState.WAITING_PRELOAD) goto L5;
            r0.c.o();
        L5:
            this.a.p.k();
        }

        public a(x3 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r11) {
            tt5.a.h(this.a.a, "onRenderSuccess");
            com.bytedance.ee.util.ui.j.e(this.a.g);
            this.a.p.finish(true);
            x3 r0 = this.a;
            if (r0.p.a != DocLoadingState.SUCCESS) goto L11;
            Pair<Integer, String> r1 = r0.d();
            x3 r2 = this.a;
            s1 r3 = r2.c;
            boolean r5 = r2.p.c;
            int r7 = ((Integer) r1.first).intValue();
            String r8 = (String) r1.second;
            DocumentPluginHost r4 = this.a.b;
            if (r4 != null) goto L7;
        L9:
            boolean r9 = false;
        L10:
            r3.l(r11, r5, "direct", r7, r8, r9);
            com.bytedance.ee.bear.document.reloadwebview.a.f();
            goto L11
        L7:
            if (ForsetiHelper.s(r4.getHostFragment()) == false) goto L9;
            r9 = true;
        L11:
            final x3 r6 = this.a;
            final BearUrl r10 = r6.f();
            Boolean r12 = w25.c.a;
            Intrinsics.checkNotNullParameter(r10, "bearUrl");
            w25.c.e = r10;
            Disposable r13 = Flowable.timer(1, TimeUnit.SECONDS).subscribeOn(fo5.d.a()).subscribe(new c3(r6, r10), new d3(r6));
            r6.t.add(r13);
            DocumentPluginHost r14 = this.a.b;
            String r16 = "";
            if (r14 != null) goto L14;
        L16:
            String r17 = "";
        L17:
            if (r11 == null) goto L19;
            r16 = r11.get("total_block_count");
        L19:
            a05.d.a(r17, "block_num", r16);
            return;
        L14:
            if (r14.a() == null) goto L16;
            r17 = this.a.b.a().getToken();
            goto L17
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(final DocException r4, final Map r5) {
            tt5.a.e(this.a.a, "onRenderFail", r4, false);
            com.bytedance.ee.util.ui.j.c(new w3(this, r4, r5));
        }
    }

    public static class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r1, String r2, Bitmap r3) {
            super.onPageStarted(r1, r2, r3);
            rcb.c.d(r1);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView r2, WebResourceRequest r3, WebResourceResponse r4) {
            super.onReceivedHttpError(r2, r3, r4);
            tt5.a.h("WebViewFragment#WebStatus", "onReceivedHttpError()... url = " + du5.b.g(r3.getUrl().toString()) + ", err rsp:" + r4);
        }
    }

    @Override // com.bytedance.ee.bear.document.y4
    public final void B() {
        tt5.a.h(this.a, "dispatchLoadSuccess");
        com.bytedance.ee.util.ui.j.e(this.g);
        List<x2.b> r0 = this.f;
        if (r0 == null) goto L8;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((x2.b) r1.next()).onLoadSuccess();
    L8:
        p35.e.d(false);
    }

    public final void a() {
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).a(this.b.c());
        vv4.k r0 = this.b.getWeb();
        if ((r0 instanceof z4) == false) goto L5;
        ((z4) r0).s(false, Integer.valueOf(hashCode()));
    L5:
        i().T(this.e);
    }

    public final Pair<Integer, String> d() {
        if (this.q == false) goto L7;
        this.b.a().getToken();
        return new Pair(1, this.b.a().getEditionId());
    L7:
        return new Pair(0, null);
    }

    public BearUrl f() {
        return this.b.a().getBearUrl();
    }

    public final DocBridgeWebViewV2 h() throws Exception {
        b5 r0 = this.n;
        if (r0 == null) goto L9;
        if (r0.getWebView() == null) goto L9;
        return (DocBridgeWebViewV2) this.b.getWeb().getWebView();
    L9:
        throw new Exception("Require web view when not attached");
    }

    public final DocBridgeWebViewV2 i() {
        return (DocBridgeWebViewV2) this.b.getWeb().getWebView();
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View, android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2] */
    @Override // com.bytedance.ee.bear.document.x2
    public void load() {
        if (com.bytedance.ee.bear.document.reloadwebview.a.j == true) goto L5;
    L7:
        boolean r0 = true;
        p35.e.d(true);
        bi(false);
        tt5.a.h(this.a, "Load");
        u1 r2 = this.p;
        r2.getClass();
        r2.a = DocLoadingState.INIT;
        r2.b = RenderStage.RENDERING;
        r2.c = false;
        tt5.a.h(this.a, "setupWebView");
        if (this.n.isAttached() == true) goto L10;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).f(this.b.c());
    L10:
        DocBridgeWebViewV2 r3 = i();
        WebFragment r4 = this.b.c();
        if ((r4 instanceof WebViewFragment) == false) goto L13;
        String r5 = ((WebViewFragment) r4).ba0();
    L14:
        l7 r6 = y7.j;
        DocBridgeWebViewV2 r7 = y7.a.a.t(r5);
        if (r3 == null) goto L18;
        if (r7 == r3) goto L18;
        r3.S(this.d);
        r4.getLifecycle();
        this.b.setWeb(new SafeReuseDocumentWebV2("WebViewFragment#" + r5, r7));
        i().C(this.d);
        this.p = i().getDocStateTracker();
    L18:
        ?? r8 = i();
        vv4.k r9 = this.b.getWeb();
        if ((r9 instanceof z4) == false) goto L21;
        ((z4) r9).s(true, Integer.valueOf(hashCode()));
    L21:
        r8.W2.a(this.e);
        p35.e.e(false);
        r8.clearHistory();
        tt5.a.h(this.a, "webview clearView");
        if (((dn4.a) this.b.getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.webview_clear_view_v2") == true) goto L24;
    L26:
        r8.clearView();
    L27:
        s1.B = 0;
        ?? r10 = i();
        String r11 = r10.getUrl();
        if (r11 != null) goto L30;
    L32:
        r0 = false;
    L33:
        if (r0 == false) goto L35;
        iu5.d.a(this.a, new RuntimeException("webview has jumped to upgrade page!"));
        Flowable<Boolean> r1 = r10.R();
    L36:
        this.m = r1.flatMap(new v3(this)).flatMap(new z2(this)).flatMap(new a3(this)).flatMap(new b3(this)).doOnCancel(new q3(this)).observeOn(fo5.d.d()).subscribe(new r3(), new s3(this), new t3(this), new u3(this));
        return;
    L35:
        r1 = Flowable.just(Boolean.TRUE);
        goto L36
    L30:
        if (r11.contains("/space/app/upgrade/") == false) goto L32;
    L24:
        if (r8.getUsedCount() <= 0) goto L26;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        OneShotPreDrawListener.add(r8, new n45.e(r8, r8));
        goto L27
    L13:
        r5 = Integer.toHexString(r4.hashCode());
        goto L14
    L5:
        if (com.bytedance.ee.bear.document.reloadwebview.a.i == false) goto L7;
        tt5.a.h("JsThreadChecker", "kill when open doc");
        com.bytedance.ee.bear.document.reloadwebview.a.b();
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onDestroy() {
        if (km4.a.a == false) goto L5;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).c("start_open");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).c("render_cache");
    L5:
        vv4.k r0 = this.b.getWeb();
        if ((r0 instanceof z4) == false) goto L9;
        ((z4) r0).onDestroy();
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onPause() {
        com.bytedance.ee.util.ui.j.e(this.g);
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.document.y2] */
    public x3(DocumentPluginHost r7) {
        this.a = "DocumentLoaderImpl";
        this.g = new y2(this);
        this.k = "unknown";
        this.l = "unknown";
        this.q = false;
        this.t = new CompositeDisposable();
        this.b = r7;
        this.f = new CopyOnWriteArrayList();
        this.e = new b();
        this.d = new a(this);
        this.c = new s1(com.bytedance.ee.bear.contract.j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).e());
        this.p = i().getDocStateTracker();
        this.r = new z05.d();
        this.u = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.ee.bear.document.d5
    public final void C(b5 r3) {
        tt5.a.h(this.a, "onDestroyView");
        bi(false);
        a();
        r3.b(this.o);
        i().S(this.d);
        this.t.clear();
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S(x2.b r2) {
        List<x2.b> r0 = this.f;
        if (r0 == null) goto L6;
        ((CopyOnWriteArrayList) r0).remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S3(x2.b r2) {
        if (((CopyOnWriteArrayList) this.f).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.f).add(r2);
        return;
    }

    public k25.m0 b(BearUrl r4) {
        String r0 = r4.b;
        if (this.q == false) goto L8;
        z05.g r1 = this.s;
        if (r1 == null) goto L8;
        r0 = r1.a;
    L8:
        if (this.b.a() != null) goto L10;
    L12:
        AccountService$Account r2 = this.h;
        String r5 = r4.getType();
        FetchClientVarExecutor r3 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
        return k25.e0.m().n(n35.a.a(r2, r5), r0);
    L10:
        if (this.b.a().isSyncBlock() == false) goto L12;
        r0 = this.b.a().getOriginBearUrl().b;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2] */
    @Override // com.bytedance.ee.bear.document.x2
    public final void bi(boolean r12) {
        Disposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
        this.m = null;
    L5:
        boolean r1 = com.bytedance.ee.util.ui.j.a(this.g);
        if (r1 == false) goto L8;
        com.bytedance.ee.util.ui.j.e(this.g);
    L8:
        tt5.a.h(this.a, "cancelLoad cancelByUser: " + r12 + "   hasCallback: " + r1);
        if (r12 == false) goto L38;
        if (r1 == false) goto L39;
        u1 r13 = this.p;
        DocLoadingState r2 = r13.a;
        r13.i();
        if (this.p.a != DocLoadingState.CANCELED) goto L40;
        Pair<Integer, String> r14 = d();
        s1 r3 = this.c;
        u1 r4 = this.p;
        r3.getClass();
        int r5 = s1.g(r2, r4);
        s1 r6 = this.c;
        boolean r7 = this.p.c;
        int r8 = ((Integer) r14.first).intValue();
        String r9 = (String) r14.second;
        DocBridgeWebViewV2 r10 = i();
        DocumentPluginHost r16 = this.b;
        boolean r11 = false;
        if (r16 != null) goto L16;
    L18:
        boolean r17 = false;
    L19:
        r6.h(r5, r7, "direct", r8, r9, r10, r17);
        int r18 = s1.b.a;
        if (r5 != 100) goto L22;
        com.bytedance.ee.bear.document.reloadwebview.a.c();
    L22:
        DocumentPluginHost r19 = this.b;
        if (r19 != null) goto L25;
    L29:
        ?? r110 = i();
        if (r11 == true) goto L41;
        if (r110 != 0) goto L33;
        return;
    L33:
        if (r110.M() == false) goto L35;
        return;
    L35:
        if ((System.currentTimeMillis() - r110.getmLoadHtmlStartTime()) <= 60000) goto L44;
        Disposable r111 = ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).d(r110).subscribe(new o3(this), new p3(this));
        tt5.a.h(this.a, "disposable = " + r111);
        return;
    L44:
        return;
    L41:
        return;
    L25:
        if (r19.a() == null) goto L29;
        if (this.b.a().getOpenSource() != DocsOpenSource.vc) goto L29;
        r11 = true;
        goto L29
    L16:
        if (ForsetiHelper.s(r16.getHostFragment()) == false) goto L18;
        r17 = true;
        goto L19
    L40:
        return;
    L39:
        return;
    }

    public k25.m0 e(BearUrl r4) {
        DocViewModel r0 = this.b.a();
        if (r0 != null) goto L5;
    L8:
        String r1 = r4.b;
        if (this.q == false) goto L14;
        z05.g r2 = this.s;
        if (r2 == null) goto L14;
        r1 = r2.a;
    L14:
        return com.bytedance.ee.bear.document.offline.sync.opendoc.k.d(this.h, r4.a, r1, r4.d);
    L5:
        if (r0.isSyncBlock() == false) goto L8;
        return new k25.m0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.document.b5$a, com.bytedance.ee.bear.document.j3] */
    @Override // com.bytedance.ee.bear.document.d5
    public final void g(b5 r3) {
        tt5.a.h(this.a, "onCreateView");
        this.n = r3;
        i().C(this.d);
        ?? r0 = new j3(this);
        this.o = r0;
        r3.c(r0);
    }

    @Override // com.bytedance.ee.bear.document.y4
    public final void n(String r4) {
        List<x2.b> r0 = this.f;
        if (r0 == null) goto L10;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        x2.b r2 = (x2.b) r1.next();
        if ((r2 instanceof x2.a) == false) goto L6;
        ((x2.a) r2).a(r4);
        goto L6
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.document.y4
    public final void c(int r4, Throwable r5) {
        if (this.q == true) goto L5;
    L11:
        tt5.a.e(this.a, "dispatchLoadFail:" + r4, r5, false);
        com.bytedance.ee.util.ui.j.e(this.g);
        List<x2.b> r0 = this.f;
        if (r0 == null) goto L17;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        ((x2.b) r1.next()).onLoadFail(r4, r5);
    L17:
        p35.e.d(false);
        return;
    L5:
        if (r4 != (-55)) goto L11;
        com.bytedance.ee.bear.k r6 = (com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class);
        if (this.b.a() == null) goto L9;
        int r2 = this.b.a().getDocumentTypeValue();
    L10:
        r6.r(r2);
        r4 = -57;
        goto L11
    L9:
        r2 = -1;
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.y4
    public void k(Throwable r11, Map<String, String> r12) {
        if (r12 != null) goto L4;
        r12 = new HashMap();
    L4:
        Map<String, String> r1 = r12;
        tt5.a.d(this.a, "dealFail map:" + r1 + "err:" + r11);
        com.bytedance.ee.util.ui.j.e(this.g);
        if ((r11 instanceof DocException) == false) goto L7;
        int r13 = ((DocException) r11).getCode();
    L9:
        if (this.q == true) goto L11;
    L23:
        this.p.finish(false);
        if (this.p.a != DocLoadingState.FAIL) goto L36;
        if (r1.size() > 0) goto L28;
        r1.put("docs_result_code", String.valueOf(r13));
        r1.put("docs_result_key", "native");
    L28:
        Pair<Integer, String> r0 = d();
        s1 r3 = this.c;
        boolean r4 = this.p.c;
        int r6 = ((Integer) r0.first).intValue();
        String r7 = (String) r0.second;
        DocBridgeWebViewV2 r8 = i();
        DocumentPluginHost r2 = this.b;
        if (r2 != null) goto L31;
    L33:
        boolean r9 = false;
    L34:
        r3.j(r1, r4, "direct", r6, r7, r8, r9);
        goto L36
    L31:
        if (ForsetiHelper.s(r2.getHostFragment()) == false) goto L33;
        r9 = true;
    L36:
        if (r13 != 4) goto L38;
        return;
    L38:
        if (r13 != 1002) goto L40;
        return;
    L40:
        if (r13 != 3) goto L42;
        return;
    L42:
        if (r13 != (-1)) goto L44;
        return;
    L44:
        if (r13 != (-2)) goto L46;
        return;
    L46:
        if (r13 != (-3)) goto L48;
        return;
    L48:
        if (r13 != 5) goto L50;
        this.c.i(r13);
        o.a();
    L50:
        c(r13, r11);
        return;
    L11:
        if ((r11 instanceof NetService.ServerErrorException) == false) goto L23;
        int r5 = ((NetService.ServerErrorException) r11).getCode();
        if (r5 != 528032012) goto L16;
        r13 = -57;
        goto L23
    L16:
        if (r5 != 528021002) goto L18;
    L21:
        this.q = false;
        this.b.a().setUrl(z05.i.c(this.b.a().getUrl()));
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).e(null);
        load();
        return;
    L18:
        if (r5 == 528032011) goto L21;
        if (r5 != 528010000) goto L23;
    L7:
        r13 = -52;
        goto L9
    }
}
