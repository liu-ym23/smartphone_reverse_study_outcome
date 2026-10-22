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
import com.bytedance.ee.docsdk.impl.document.service.ContainerThemeWebService;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements CCMLynxCardView {
    public final Context a;
    public ILarkLynxContainer b;
    public CCMLynxCardView.b c;
    public boolean d;
    public d e;
    public final AtomicBoolean f;
    public final CompositeDisposable g;
    public final XBridgeRegistryHelper h;

    /* JADX INFO: renamed from: fe5.a$a, reason: collision with other inner class name */
    public static final class C0227a implements ILynxContainerContext {
        public final String getContainerType() {
            return "ccm_common_lynx";
        }

        public final Map<String, Object> getBizExtra() {
            return MapsKt.emptyMap();
        }

        public C0227a() {
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            if (r10 == (r8 - r6)) goto L6;
            int r11 = this.a.l(r10);
            a r12 = this.a;
            Resources r13 = r12.a.getResources();
            int r14 = r12.l(WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).heightPixels);
            tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "on layout change, width: " + r11 + ", height: " + r14);
            this.a.k(r11, r14);
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Map<String, Object> b;

        public d(a r1, Map<String, ? extends Object> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ILarkLynxContainer r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.updateData(this.b, null);     // Catch: Throwable -> L6
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
        boolean r1 = true;
        if (ForsetiHelper.p() == false) goto L20;
        ILarkLynxContainer r0 = this.b;
        if (r0 == null) goto L17;
        View r2 = r0.getLynxView();
        if (r2 == null) goto L17;
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (r3.intValue() > 0) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L17;
        int r4 = r3.intValue();
    L18:
        k(l(r4), l(m()));
        return;
    L17:
        r4 = m();
        goto L18
    L20:
        int r5 = l(m());
        Resources r6 = this.a.getResources();
        sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r5)), TuplesKt.to("pageHeight", Integer.valueOf(l(WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).heightPixels)))})));
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void destroy() {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "destroy");
        CompositeDisposable r0 = this.g;
        if (r0.isDisposed() == false) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        ILarkLynxContainer r1 = this.b;
        if (r1 == null) goto L11;
        r1.destroy();
    L11:
        this.b = null;
        XBridgeRegistryHelper r2 = this.h;
        r2.getClass();
        tt5.a.h("ccm-lynx: XBridgeRegistryHelper", "unRegisterXBridges");
        Object r3 = r2.c;
        monitor-enter(r3);
        ((ArrayList) r2.e).clear();     // Catch: Throwable -> L17
        r2.d = null;     // Catch: Throwable -> L17
        r2.f = false;     // Catch: Throwable -> L17
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r3);
        this.h.d();
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final int m() {
        Resources r0 = this.a.getResources();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final CCMLynxCardView.b e() {
        return this.c;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "activityContext");
        this.a = r2;
        this.f = new AtomicBoolean(false);
        this.g = new CompositeDisposable();
        this.h = new XBridgeRegistryHelper();
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void c(i5 r2) {
        this.h.b = r2;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void f(CCMLynxCardView.b r3) {
        Intrinsics.checkNotNullParameter(r3, "lst");
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "setLynxContainerEventListener");
        this.c = r3;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void g(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "templateData");
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "updateContent");
        if (this.d == false) goto L7;
        ILarkLynxContainer r0 = this.b;
        if (r0 == null) goto L9;
        r0.updateData(r3, null);
        return;
    L9:
        return;
    L7:
        this.e = new d(this, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(String r9) {
        if (this.f.compareAndSet(false, true) == false) goto L75;
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "initLynxKitView");
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(eu5.b.a);
        if (r9 == null) goto L8;
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerLynxGroup(r9, new fe5.c(r9));
    L8:
        if (this.a.getResources() == null) goto L10;
        Float r0 = Float.valueOf(zz7.b.d().getMultiplier());
    L11:
        LarkLynxContainerBuilder r3 = new LarkLynxContainerBuilder(this.a).containerContext(new C0227a()).tagForCustomComponent("ccm-lynx-bid").tagForTemplateLoader("ccm-lynx-bid").tagForBridgeProtocol("ccm-bridge").bridgeProtocolContainerId(this.h.a.a).bridgeRuntimeFactory(fe5.d.a).imageLoader(new fe5.b(this)).lynxViewLifeCycle(new e(this));
        if (r9 == null) goto L14;
        r3.tagForJsContext(r9);
    L14:
        if (r0 == null) goto L16;
        r3.fontScale(r0.floatValue());
    L16:
        ILarkLynxContainer r1 = r3.build();
        Context r4 = this.a.getApplicationContext();
        if (r4 != null) goto L19;
        r4 = this.a;
    L19:
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());
        r5.put("statusBarHeight", Integer.valueOf(l(k.e(r4))));
        int r6 = ie5.k.a;
        String r7 = ((b0) ie5.k.a.a(b0.class)).getDeviceModel();
        String r8 = "";
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r5.put("deviceModel", r7);
        String r10 = Build.VERSION.RELEASE;
        if (r10 == null) goto L26;
        r8 = r10;
    L26:
        r5.put("osVersion", r8);
        r5.put("isPad", Integer.valueOf(ku5.c.k(r4) ? 1 : 0));
        String r11 = "true";
        if (eu5.c.a() == false) goto L29;
        Object[] r12 = "true";
    L30:
        r5.put("appIsDebug", r12);
        if (h18.f.a(this.a) == false) goto L33;
        String r13 = ContainerThemeWebService.THEME_CONFIG_VALUE_DARK;
    L34:
        r5.put("brightness", r13);
        r5.put("containerId", this.h.a.a);
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == false) goto L37;
        Object[] r2 = "true";
    L38:
        r5.put("isFeishuBrand", r2);
        r5.put("domain", jcb.b.c().a("help_center"));
        if (((b0) ie5.k.a.a(b0.class)).s() == true) goto L42;
        r11 = "false";
    L42:
        r5.put("isUSPackage", r11);
        r5.put("screenWidth", Integer.valueOf(l(m())));
        Resources r14 = this.a.getResources();
        r5.put("screenHeight", Integer.valueOf(l(WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).heightPixels)));
        i0 r15 = (i0) ie5.k.a.a(i0.class);
        r5.put("language", ou5.b.a(r15.c().getCountry(), r15.a()));
        r5.put("os", "Android");
        r5.put("isMempope", AppInfoUtils.e());
        if (r9 == null) goto L45;
        r5.put("shareContextID", r9);
    L45:
        r1.updateGlobalData(r5);
        this.b = r1;
        XBridgeLynxKitRuntime r16 = r1.getBridgeProtocolHandle();
        if ((r16 instanceof XBridgeLynxKitRuntime) == false) goto L48;
        XBridgeLynxKitRuntime r17 = r16;
    L49:
        if (r17 == null) goto L61;
        XBridgeRegistryHelper r18 = this.h;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "runtime");
        Object r19 = r18.c;
        monitor-enter(r19);
        r18.d = r17;     // Catch: Throwable -> L58
        ArrayList r20 = new ArrayList(r18.e);     // Catch: Throwable -> L58
        ((ArrayList) r18.e).clear();     // Catch: Throwable -> L58
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r19);
        Iterator r22 = r20.iterator();
    L56:
        if (r22.hasNext() == false) goto L63;
        ((Function1) r22.next()).invoke(r17);
    L63:
        if (eu5.c.a() == false) goto L70;
        LynxView r23 = r1.getLynxView();
        if ((r23 instanceof LynxView) == false) goto L67;
        LynxView r24 = r23;
    L68:
        if (r24 == null) goto L70;
        com.bytedance.ee.bear.lynx.impl.b.b.put(r24, null);
        goto L70
    L67:
        r24 = null;
    L70:
        Map<String, WeakReference<CCMLynxCardView>> r25 = h.a;
        String r26 = this.h.a.a;
        Intrinsics.checkNotNullParameter(r26, "containerId");
        Intrinsics.checkNotNullParameter(this, "ccmLynxCardView");
        tt5.a.h("ccm-lynx: CCMLynxViewRecord", "set containerId: " + r26);
        Map<String, WeakReference<CCMLynxCardView>> r27 = h.a;
        r27.remove(r26);
        r27.put(r26, new WeakReference(this));
        return;
    L58:
        th = move-exception;
        throw th;
    L61:
        tt5.a.d("ccm-lynx: CCMLynxCardViewImpl", "bridge runtime handle is null");
        goto L63
    L48:
        r17 = null;
        goto L49
    L37:
        r2 = "false";
        goto L38
    L33:
        r13 = ContainerThemeWebService.THEME_CONFIG_VALUE_LIGHT;
        goto L34
    L29:
        r12 = "false";
        goto L30
    L10:
        r0 = null;
        goto L11
    }

    public final int l(float r3) {
        Resources r0 = this.a.getResources();
        return (int) ((r3 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void h(String r2, XBridgeMethod r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "bridgeMethod");
        this.h.a(r2, r3);
    }

    public final void k(int r6, int r7) {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "notifyPageSizeChange, width: " + r6 + ", height: " + r7);
        sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r6)), TuplesKt.to("pageHeight", Integer.valueOf(r7))})));
        ILarkLynxContainer r1 = this.b;
        if (r1 == null) goto L6;
        r1.updateGlobalData(MapsKt.mapOf(new Pair[]{TuplesKt.to("screenWidth", Integer.valueOf(r6)), TuplesKt.to("screenHeight", Integer.valueOf(r7))}));
        return;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final <T> void registerWeakHolder(Class<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        this.h.b(r2, r3);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void sendEvent(String r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        ILarkLynxContainer r0 = this.b;
        if (r0 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        r0.sendGlobalEventToJS(r2, r3);
        return;
    }

    public static final String i(a r1, Uri r2, String r3) {
        r1.getClass();
        return UriProtector.getQueryParameter(r2, r3);
    L5:
        e = move-exception;
        tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "getQueryParameter error, key: ".concat(r3), e, false);
        return null;
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void a(ViewGroup r18, String r19, Map<String, ? extends Object> r20, ViewGroup.LayoutParams r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "viewContainer");
        Intrinsics.checkNotNullParameter(r19, "templateUrl");
        j(r22);     // Catch: Throwable -> L37
        ILarkLynxContainer r7 = this.b;     // Catch: Throwable -> L37
        if (r7 != null) goto L6;
        return;
    L6:
        View r8 = r7.getLynxView();     // Catch: Throwable -> L37
        if (r21 != null) goto L9;
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(-2, -2);     // Catch: Throwable -> L37
    L10:
        r18.addView(r8, r9);     // Catch: Throwable -> L37
        this.h.c(this.a, r8);     // Catch: Throwable -> L37
        Map<Integer, String> r0 = com.bytedance.ee.bear.lynx.impl.route.d.a;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r19, "templateUrl");     // Catch: Throwable -> L37
        Uri r1 = UriProtector.parse(r19);     // Catch: Throwable -> L37
        String r5 = UriProtector.getQueryParameter(r1, "surl");     // Catch: Throwable -> L37
        if (r5 != null) goto L13;
    L20:
        r5 = r19;
    L21:
        int r11 = StringsKt.indexOf$default(r5, "docs_lynx_channel/", 0, false, 6, null);     // Catch: Throwable -> L37
        if (r11 < 0) goto L24;
        String r2 = r5.substring(r11 + 18);     // Catch: Throwable -> L37
    L29:
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "showCardAtContainer render templatePath: " + r2 + ", templateUrl: " + r19);     // Catch: Throwable -> L37
        if (r20 == null) goto L32;
        TemplateData r3 = TemplateData.fromMap(r20);     // Catch: Throwable -> L37
    L33:
        r7.renderByTemplateLoaderWithTemplateData(r2, r3, null);     // Catch: Throwable -> L37
        if (ForsetiHelper.p() == false) goto L42;
        r8.addOnLayoutChangeListener(new c(this));     // Catch: Throwable -> L37
        return;
    L42:
        return;
    L32:
        r3 = null;
        goto L33
    L24:
        String r4 = r1.getPath();     // Catch: Throwable -> L37
        if (r4 == null) goto L28;
        r2 = StringsKt.trimStart(r4, new char[]{'/'});     // Catch: Throwable -> L37
        if (r2 != null) goto L29;
    L28:
        r2 = "";
        goto L29
    L13:
        if (r5.length() <= 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L19;
        r5 = null;
    L19:
        if (r5 != null) goto L21;
    L15:
        r12 = false;
        goto L16
    L9:
        r9 = r21;
    L37:
        th = move-exception;
        tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "showCardAtContainer error", th, false);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView
    public final void d(ViewGroup r8, int r9, Map<String, ? extends Object> r10, ViewGroup.LayoutParams r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "viewContainer");
        String r13 = com.bytedance.ee.bear.lynx.impl.route.d.a.get(Integer.valueOf(r9));
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        a(r8, com.bytedance.ee.bear.lynx.impl.route.d.a(r13, false), r10, r11, r12);
    }
}
