package com.bytedance.ee.bear.bitable.load;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.bitable.BitableDocumentPluginHost;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.b5;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.u1;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BitableLoadContext extends com.bytedance.ee.bear.document.b implements e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f214448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f214449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f214450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f214451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u1 f214452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Pair<String, Boolean>> f214453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Class<?>, Object> f214454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.preload.util.b f214455n;

    public static final class a {
    }

    public final class b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLoadContext f214456a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
            tu4.b.g(this.f214456a.getTraceId(), "BITABLE_NATIVE_CALL_JS_RENDER", s1.f221480x);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
            tt5.a.h("BitableLoadContext", "onDownloadFullResource");
            BitableLoadContext r100 = this.f214456a;
            if (r100.f214452k.f222434a != DocLoadingState.WAITING_DOWNLOAD) goto L5;
            r100.f219140f.n();
        L5:
            f();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
            tt5.a.h("BitableLoadContext", "onDocGoBack");
            com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            if (r100.e("start_open", ILoadStallMonitor.START_TIME) != null) goto L6;
            r100.j("start_open", ILoadStallMonitor.START_TIME, String.valueOf(System.currentTimeMillis()));
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
            tt5.a.h("BitableLoadContext", "onWaitPreloading");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j("wait_preload", ILoadStallMonitor.START_TIME, String.valueOf(SystemClock.uptimeMillis()));
            this.f214456a.f214452k.m();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
            tt5.a.h("BitableLoadContext", "onRenderByWaitPreload");
            Iterator r100 = ((LinkedHashMap) ((com.bytedance.ee.bear.bitable.load.d) this.f214456a).f214480p).values().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((AbsLoadWork) r100.next()).j();
            goto L4
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
            tt5.a.h("BitableLoadContext", "onWaitDownloadFullResource");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j("wait_download_resource", ILoadStallMonitor.START_TIME, String.valueOf(SystemClock.uptimeMillis()));
            this.f214456a.f214452k.l();
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            tt5.a.h("BitableLoadContext", "onRendering");
            BitableLoadContext r100 = this.f214456a;
            if (r100.f214452k.f222434a != DocLoadingState.WAITING_PRELOAD) goto L5;
            r100.f219140f.o();
        L5:
            this.f214456a.f214452k.k();
        }

        public b(com.bytedance.ee.bear.bitable.load.d r100) {
            this.f214456a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r110) {
            tt5.a.h("BitableLoadContext", "onRenderSuccess");
            BitableLoadContext r100 = this.f214456a;
            if (r110 != null) goto L5;
            Map<String, String> r101 = MapsKt.emptyMap();
        L6:
            com.bytedance.ee.bear.bitable.load.d r102 = (com.bytedance.ee.bear.bitable.load.d) r100;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r101, "data");
            Iterator r103 = ((LinkedHashMap) r102.f214480p).values().iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            ((AbsLoadWork) r103.next()).k();
            goto L8
        L10:
            this.f214456a.f214452k.finish(true);
            BitableLoadContext r104 = this.f214456a;
            u1 r105 = r104.f214452k;
            if (r105.f222434a != DocLoadingState.SUCCESS) goto L17;
            s1 r106 = r104.f219140f;
            boolean r107 = r105.f222436c;
            String r108 = r104.f214450i;
            DocumentPluginHost r109 = r104.f219135a;
            if (r109 == null) goto L15;
            Fragment r111 = r109.getHostFragment();
        L16:
            r106.l(r110, r107, r108, 0, null, ForsetiHelper.s(r111));
            com.bytedance.ee.bear.document.reloadwebview.a.f();
            goto L17
        L15:
            r111 = null;
        L17:
            DocumentPluginHost r112 = this.f214456a.f219135a;
            String r113 = "";
            if (r112 != null) goto L20;
        L22:
            String r114 = "";
        L23:
            if (r110 == null) goto L25;
            r113 = r110.get("total_block_count");
        L25:
            a05.d.a(r114, "block_num", r113);
            return;
        L20:
            if (r112.a() == null) goto L22;
            r114 = this.f214456a.f219135a.a().getToken();
            goto L23
        L5:
            r101 = r110;
            goto L6
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r100, Map r101) {
            tt5.a.e("BitableLoadContext", "onRenderFail", r100, false);
            j.c(new com.bytedance.ee.bear.bitable.load.a(this.f214456a, r100, r101));
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLoadContext f214457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f214458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean f214459c;

        public c(BitableLoadContext r100, String r101, Boolean r102) {
            this.f214457a = r100;
            this.f214458b = r101;
            this.f214459c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<Pair<String, Boolean>> r100 = this.f214457a.f214453l;     // Catch: Throwable -> L4
            ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
            r101.add(new Pair(this.f214458b, this.f214459c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f214460a;

        public d(Function0<Unit> r100) {
            this.f214460a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f214460a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.y4
    public abstract void k(Throwable r100, Map<String, String> r101);

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final String getTraceId() {
        String r100 = tu4.b.b(this.f219135a.a());
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.document.b, com.bytedance.ee.bear.bitable.load.e
    public final DocBridgeWebViewV2 i() {
        return (DocBridgeWebViewV2) this.f219135a.getWeb().getWebView();
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final String l() {
        CharSequence r100 = this.f219135a.a().getTitle().getValue();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final BitableSceneType o() {
        DocumentPluginHost r100 = this.f219135a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.BitableDocumentPluginHost");
        return ((BitableDocumentPluginHost) r100).e();
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final DocBridgeWebViewV2 s() {
        b5 r100 = this.f219139e;
        if (r100 == null) goto L9;
        if (r100.getWebView() == null) goto L9;
        return (DocBridgeWebViewV2) this.f219135a.getWeb().getWebView();
    L9:
        throw new Exception("Require web view when not attached");
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final BearUrl u() {
        BearUrl r100 = this.f219135a.a().getOriginBearUrl();
        if (fx4.a.g(r100) == false) goto L11;
        BearUrl r101 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r100.f222564e);
        WikiInfo r102 = ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).h(this.f219135a);
        if (r102 == null) goto L9;
        String r103 = r102.getObjTypeString();
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r101.f222560a = r103;
    L9:
        return r101;
    L11:
        return this.f219135a.a().getBearUrl();
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final void z() {
        this.f214452k = i().getDocStateTracker();
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final s1 b() {
        return this.f219140f;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final com.bytedance.ee.bear.bitable.preload.util.b f() {
        return this.f214455n;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final DocumentPluginHost getPluginHost() {
        return this.f219135a;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final com.bytedance.ee.bear.document.b.a j() {
        return this.f219136b;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final b p() {
        return this.f214449h;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final b5 q() {
        return this.f219139e;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final u1 r() {
        return this.f214452k;
    }

    public BitableLoadContext(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        super(r100);
        this.f214448g = org.koin.java.a.d(com.bytedance.ee.bear.contract.d.class);
        this.f214450i = "direct";
        this.f214451j = ((Boolean) new ml5.b("debug_config").a("bitable_loader_chache_toast_enable", Boolean.FALSE)).booleanValue();
        this.f214453l = new ArrayList();
        this.f214454m = new LinkedHashMap();
        this.f214455n = new com.bytedance.ee.bear.bitable.preload.util.b();
        this.f214452k = i().getDocStateTracker();
        this.f214449h = new b((com.bytedance.ee.bear.bitable.load.d) this);
    }

    public final void E(Function0<Unit> r100) {
        if (getTraceId().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        j.c(new d(r100));
        return;
    L8:
        r100.invoke();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final <T extends zt4.a> T e(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = ((LinkedHashMap) this.f214454m).get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof zt4.a) == true) goto L8;
        return null;
    L8:
        return (T) r101;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final void A(final String r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        E(new BitableLoadContext$reportNativeTraceKey$1(this, r100, r101));
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final <T extends zt4.a> void d(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "loader");
        this.f214454m.put(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final void h(final String r100, final Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        E(new BitableLoadContext$reportStageValue$1(this, r100, r101));
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final void t(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (this.f214451j == true) goto L5;
        return;
    L5:
        if (eu5.c.d() == false) goto L9;
        j.c(new c(this, r100, r101));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.load.e
    public final void v(final String r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        E(new BitableLoadContext$reportStageTrace$1(this, r100, r101));
    }
}
