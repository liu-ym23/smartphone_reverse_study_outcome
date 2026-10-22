package fe5;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.lynx.impl.xbridge.XBridgeRegistryHelper;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements CCMLynxCardView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f476572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ILarkLynxContainer f476573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CCMLynxCardView.b f476574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f476575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f476576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f476577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f476578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final XBridgeRegistryHelper f476579h;

    /* JADX INFO: renamed from: fe5.a$a, reason: collision with other inner class name */
    public static final class C5885a implements ILynxContainerContext {
        @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
        public final String getContainerType() {
            return "ccm_common_lynx";
        }

        @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
        public final Map<String, Object> getBizExtra() {
            return MapsKt.emptyMap();
        }

        public C5885a() {
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476580a;

        public c(a r100) {
            this.f476580a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            int r109 = r103 - r101;
            if (r109 == (r107 - r105)) goto L6;
            int r110 = this.f476580a.l(r109);
            a r111 = this.f476580a;
            Resources r112 = r111.f476572a.getResources();
            int r113 = r111.l(WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).heightPixels);
            tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "on layout change, width: " + r110 + ", height: " + r113);
            this.f476580a.k(r110, r113);
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f476582b;

        public d(a r100, Map<String, ? extends Object> r101) {
            this.f476581a = r100;
            this.f476582b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ILarkLynxContainer r100 = this.f476581a.f476573b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.updateData(this.f476582b, null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void b() {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onConfigurationChanged");
        boolean r100 = true;
        if (ForsetiHelper.p() == false) goto L20;
        ILarkLynxContainer r101 = this.f476573b;
        if (r101 == null) goto L17;
        View r102 = r101.getLynxView();
        if (r102 == null) goto L17;
        Integer r103 = Integer.valueOf(r102.getWidth());
        if (r103.intValue() > 0) goto L12;
        r100 = false;
    L12:
        if (r100 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        int r104 = r103.intValue();
    L18:
        k(l(r104), l(m()));
        return;
    L17:
        r104 = m();
        goto L18
    L20:
        int r105 = l(m());
        Resources r106 = this.f476572a.getResources();
        sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r105)), TuplesKt.to("pageHeight", Integer.valueOf(l(WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels)))})));
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void destroy() {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", MapMonitorConst.EVENT_DESTROY);
        CompositeDisposable r100 = this.f476578g;
        if (r100.isDisposed() == false) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        ILarkLynxContainer r101 = this.f476573b;
        if (r101 == null) goto L11;
        r101.destroy();
    L11:
        this.f476573b = null;
        XBridgeRegistryHelper r102 = this.f476579h;
        r102.getClass();
        tt5.a.h("ccm-lynx: XBridgeRegistryHelper", "unRegisterXBridges");
        Object r103 = r102.f229909c;
        monitor-enter(r103);
        ((ArrayList) r102.f229911e).clear();     // Catch: Throwable -> L17
        r102.f229910d = null;     // Catch: Throwable -> L17
        r102.f229912f = false;     // Catch: Throwable -> L17
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r103);
        this.f476579h.d();
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final int m() {
        Resources r100 = this.f476572a.getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final CCMLynxCardView.b e() {
        return this.f476574c;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "activityContext");
        this.f476572a = r100;
        this.f476577f = new AtomicBoolean(false);
        this.f476578g = new CompositeDisposable();
        this.f476579h = new XBridgeRegistryHelper();
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void c(i5 r100) {
        this.f476579h.f229908b = r100;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void f(CCMLynxCardView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "lst");
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "setLynxContainerEventListener");
        this.f476574c = r100;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void g(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "updateContent");
        if (this.f476575d == false) goto L7;
        ILarkLynxContainer r101 = this.f476573b;
        if (r101 == null) goto L9;
        r101.updateData(r100, null);
        return;
    L9:
        return;
    L7:
        this.f476576e = new d(this, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(String r100) {
        if (this.f476577f.compareAndSet(false, true) == false) goto L75;
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "initLynxKitView");
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(eu5.b.f474075a);
        if (r100 == null) goto L8;
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerLynxGroup(r100, new fe5.c(r100));
    L8:
        if (this.f476572a.getResources() == null) goto L10;
        Float r101 = Float.valueOf(zz7.b.d().getMultiplier());
    L11:
        LarkLynxContainerBuilder r102 = new LarkLynxContainerBuilder(this.f476572a).containerContext(new C5885a()).tagForCustomComponent("ccm-lynx-bid").tagForTemplateLoader("ccm-lynx-bid").tagForBridgeProtocol("ccm-bridge").bridgeProtocolContainerId(this.f476579h.f229907a.f229932a).bridgeRuntimeFactory(fe5.d.f476592a).imageLoader(new fe5.b(this)).lynxViewLifeCycle(new e(this));
        if (r100 == null) goto L14;
        r102.tagForJsContext(r100);
    L14:
        if (r101 == null) goto L16;
        r102.fontScale(r101.floatValue());
    L16:
        ILarkLynxContainer r103 = r102.build();
        Context r104 = this.f476572a.getApplicationContext();
        if (r104 != null) goto L19;
        r104 = this.f476572a;
    L19:
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());
        r105.put("statusBarHeight", Integer.valueOf(l(k.e(r104))));
        int r106 = ie5.k.f489487a;
        String r107 = ((b0) ie5.k.a.a(b0.class)).getDeviceModel();
        String r108 = "";
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        r105.put("deviceModel", r107);
        String r109 = Build.VERSION.RELEASE;
        if (r109 == null) goto L26;
        r108 = r109;
    L26:
        r105.put("osVersion", r108);
        r105.put("isPad", Integer.valueOf(ku5.c.k(r104) ? 1 : 0));
        String r110 = "true";
        if (eu5.c.a() == false) goto L29;
        Object[] r111 = "true";
    L30:
        r105.put("appIsDebug", r111);
        if (h18.f.a(this.f476572a) == false) goto L33;
        String r112 = "dark";
    L34:
        r105.put("brightness", r112);
        r105.put("containerId", this.f476579h.f229907a.f229932a);
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == false) goto L37;
        Object[] r113 = "true";
    L38:
        r105.put("isFeishuBrand", r113);
        r105.put("domain", jcb.b.c().a("help_center"));
        if (((b0) ie5.k.a.a(b0.class)).s() == true) goto L42;
        r110 = "false";
    L42:
        r105.put("isUSPackage", r110);
        r105.put("screenWidth", Integer.valueOf(l(m())));
        Resources r114 = this.f476572a.getResources();
        r105.put("screenHeight", Integer.valueOf(l(WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).heightPixels)));
        i0 r115 = (i0) ie5.k.a.a(i0.class);
        r105.put("language", ou5.b.a(r115.c().getCountry(), r115.a()));
        r105.put("os", "Android");
        r105.put("isMempope", AppInfoUtils.e());
        if (r100 == null) goto L45;
        r105.put("shareContextID", r100);
    L45:
        r103.updateGlobalData(r105);
        this.f476573b = r103;
        ILarkLynxBridgeProtocolHandle r116 = r103.getBridgeProtocolHandle();
        if ((r116 instanceof XBridgeLynxKitRuntime) == false) goto L48;
        XBridgeLynxKitRuntime r117 = (XBridgeLynxKitRuntime) r116;
    L49:
        if (r117 == null) goto L61;
        XBridgeRegistryHelper r118 = this.f476579h;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r117, "runtime");
        Object r119 = r118.f229909c;
        monitor-enter(r119);
        r118.f229910d = r117;     // Catch: Throwable -> L58
        ArrayList r120 = new ArrayList(r118.f229911e);     // Catch: Throwable -> L58
        ((ArrayList) r118.f229911e).clear();     // Catch: Throwable -> L58
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r119);
        Iterator r122 = r120.iterator();
    L56:
        if (r122.hasNext() == false) goto L63;
        ((Function1) r122.next()).invoke(r117);
    L63:
        if (eu5.c.a() == false) goto L70;
        View r123 = r103.getLynxView();
        if ((r123 instanceof LynxView) == false) goto L67;
        LynxView r124 = (LynxView) r123;
    L68:
        if (r124 == null) goto L70;
        com.bytedance.ee.bear.lynx.impl.b.f229863b.put(r124, null);
        goto L70
    L67:
        r124 = null;
    L70:
        Map<String, WeakReference<CCMLynxCardView>> r125 = h.f476596a;
        String r126 = this.f476579h.f229907a.f229932a;
        Intrinsics.checkNotNullParameter(r126, "containerId");
        Intrinsics.checkNotNullParameter(this, "ccmLynxCardView");
        tt5.a.h("ccm-lynx: CCMLynxViewRecord", "set containerId: " + r126);
        Map<String, WeakReference<CCMLynxCardView>> r127 = h.f476596a;
        r127.remove(r126);
        r127.put(r126, new WeakReference(this));
        return;
    L58:
        th = move-exception;
        throw th;
    L61:
        tt5.a.d("ccm-lynx: CCMLynxCardViewImpl", "bridge runtime handle is null");
        goto L63
    L48:
        r117 = null;
        goto L49
    L37:
        r113 = "false";
        goto L38
    L33:
        r112 = "light";
        goto L34
    L29:
        r111 = "false";
        goto L30
    L10:
        r101 = null;
        goto L11
    }

    public final int l(float r100) {
        Resources r101 = this.f476572a.getResources();
        return (int) ((r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void h(String r100, XBridgeMethod r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "bridgeMethod");
        this.f476579h.a(r100, r101);
    }

    public final void k(int r100, int r101) {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "notifyPageSizeChange, width: " + r100 + ", height: " + r101);
        sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r100)), TuplesKt.to("pageHeight", Integer.valueOf(r101))})));
        ILarkLynxContainer r102 = this.f476573b;
        if (r102 == null) goto L6;
        r102.updateGlobalData(MapsKt.mapOf(new Pair[]{TuplesKt.to("screenWidth", Integer.valueOf(r100)), TuplesKt.to("screenHeight", Integer.valueOf(r101))}));
        return;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final <T> void registerWeakHolder(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f476579h.b(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void sendEvent(String r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        ILarkLynxContainer r102 = this.f476573b;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        r102.sendGlobalEventToJS(r100, r101);
        return;
    }

    public static final String i(a r100, Uri r101, String r102) {
        r100.getClass();
        return UriProtector.getQueryParameter(r101, r102);
    L5:
        e = move-exception;
        tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "getQueryParameter error, key: ".concat(r102), e, false);
        return null;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void a(ViewGroup r110, String r111, Map<String, ? extends Object> r210, ViewGroup.LayoutParams r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "viewContainer");
        Intrinsics.checkNotNullParameter(r111, "templateUrl");
        j(r212);     // Catch: Throwable -> L37
        ILarkLynxContainer r100 = this.f476573b;     // Catch: Throwable -> L37
        if (r100 != null) goto L6;
        return;
    L6:
        View r101 = r100.getLynxView();     // Catch: Throwable -> L37
        if (r211 != null) goto L9;
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-2, -2);     // Catch: Throwable -> L37
    L10:
        r110.addView(r101, r102);     // Catch: Throwable -> L37
        this.f476579h.c(this.f476572a, r101);     // Catch: Throwable -> L37
        Map<Integer, String> r103 = com.bytedance.ee.bear.lynx.impl.route.d.f229903a;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r111, "templateUrl");     // Catch: Throwable -> L37
        Uri r104 = UriProtector.parse(r111);     // Catch: Throwable -> L37
        String r105 = UriProtector.getQueryParameter(r104, "surl");     // Catch: Throwable -> L37
        if (r105 != null) goto L13;
    L20:
        r105 = r111;
    L21:
        int r112 = StringsKt.indexOf$default(r105, "docs_lynx_channel/", 0, false, 6, null);     // Catch: Throwable -> L37
        if (r112 < 0) goto L24;
        String r106 = r105.substring(r112 + 18);     // Catch: Throwable -> L37
    L29:
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "showCardAtContainer render templatePath: " + r106 + ", templateUrl: " + r111);     // Catch: Throwable -> L37
        if (r210 == null) goto L32;
        TemplateData r107 = TemplateData.fromMap(r210);     // Catch: Throwable -> L37
    L33:
        r100.renderByTemplateLoaderWithTemplateData(r106, r107, null);     // Catch: Throwable -> L37
        if (ForsetiHelper.p() == false) goto L42;
        r101.addOnLayoutChangeListener(new c(this));     // Catch: Throwable -> L37
        return;
    L42:
        return;
    L32:
        r107 = null;
        goto L33
    L24:
        String r108 = r104.getPath();     // Catch: Throwable -> L37
        if (r108 == null) goto L28;
        r106 = StringsKt.trimStart(r108, new char[]{'/'});     // Catch: Throwable -> L37
        if (r106 != null) goto L29;
    L28:
        r106 = "";
        goto L29
    L13:
        if (r105.length() <= 0) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == true) goto L19;
        r105 = null;
    L19:
        if (r105 != null) goto L21;
    L15:
        r113 = false;
        goto L16
    L9:
        r102 = r211;
    L37:
        th = move-exception;
        tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "showCardAtContainer error", th, false);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void d(ViewGroup r100, int r101, Map<String, ? extends Object> r110, ViewGroup.LayoutParams r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "viewContainer");
        String r102 = com.bytedance.ee.bear.lynx.impl.route.d.f229903a.get(Integer.valueOf(r101));
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        a(r100, com.bytedance.ee.bear.lynx.impl.route.d.a(r102, false), r110, r111, r112);
    }
}
