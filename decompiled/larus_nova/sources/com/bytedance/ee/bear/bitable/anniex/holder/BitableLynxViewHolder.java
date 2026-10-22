package com.bytedance.ee.bear.bitable.anniex.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.bitable.anniex.env.BitableLynxEnv;
import com.bytedance.ee.bear.bitable.anniex.util.h;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.q1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableLynxViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo4.a f206722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ILarkLynxContainer f206723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public XBridgeLynxKitRuntime f206724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f206725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f206726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitableLynxHolderState f206727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f206728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Function1<XBridgeLynxKitRuntime, Unit>> f206729h;

    public static final class a extends q1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<q1> f206730a;

        @Override // com.lynx.tasm.q1
        public final void onFirstScreen() {
            Iterator<T> r100 = this.f206730a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((q1) r100.next()).onFirstScreen();
            goto L4
        }

        @Override // com.lynx.tasm.q1
        public final void onLoadSuccess() {
            Iterator<T> r100 = this.f206730a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((q1) r100.next()).onLoadSuccess();
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends q1> r100) {
            Intrinsics.checkNotNullParameter(r100, "clients");
            this.f206730a = r100;
        }

        @Override // com.lynx.tasm.q1
        public final void onLoadFailed(String r100) {
            Iterator<T> r101 = this.f206730a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((q1) r101.next()).onLoadFailed(r100);
            goto L4
        }

        @Override // com.lynx.tasm.q1
        public final void onPageStart(String r100) {
            Iterator<T> r101 = this.f206730a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((q1) r101.next()).onPageStart(r100);
            goto L4
        }

        @Override // com.lynx.tasm.q1, com.lynx.tasm.p
        public final void onReceivedError(LynxError r100) {
            Iterator<T> r101 = this.f206730a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((q1) r101.next()).onReceivedError(r100);
            goto L4
        }
    }

    public static final class b implements ILynxContainerContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f206731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f206732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f206733c;

        @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
        public final Map<String, Object> getBizExtra() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to(BytedCertConstant.IntentKey.VIEW_TYPE, Integer.valueOf(this.f206731a)), TuplesKt.to("template_path", this.f206732b)});
        }

        @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
        public final String getContainerType() {
            return this.f206733c;
        }

        public b(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "templatePath");
            this.f206731a = r100;
            this.f206732b = r101;
            this.f206733c = "bitable_common_lynx";
        }
    }

    public static final class c {
    }

    public static final class d implements com.ss.android.lark.lynxkit.initializer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxGroup f206734a;

        public d(LynxGroup r100) {
            this.f206734a = r100;
        }

        @Override // com.ss.android.lark.lynxkit.initializer.a
        public final LynxGroup a() {
            return this.f206734a;
        }
    }

    public static final class e implements ILarkLynxBridgeRuntimeFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f206735a = null;

        static {
            f206735a = new e();
        }

        public e() {
        }

        @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory
        public final ILarkLynxBridgeRuntime create(LarkLynxBridgeProtocolBuilderContext r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return new XBridgeLynxKitRuntime("BitableBridge");
        }
    }

    public static final class f implements sqb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f206736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableLynxViewHolder f206737b;

        @Override // sqb.a
        public final void onSuccess() {
            h.d(this.f206736a, "forest_loader");
        }

        @Override // sqb.a
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            String r101 = r100.getMessage();
            if (r101 != null) goto L5;
            r101 = "template load failed";
        L5:
            h.c(this.f206736a, "forest_loader", r101, null, 12);
            this.f206737b.g(r101);
        }

        public f(h r100, BitableLynxViewHolder r101) {
            this.f206736a = r100;
            this.f206737b = r101;
        }
    }

    static {
    }

    public final void b() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        if (this.f206727f.b(new BitableLynxViewHolder$destroy$markedDestroyed$1(r100, this)) == true) goto L5;
        return;
    L5:
        Object r101 = this.f206728g;
        monitor-enter(r101);
        ((ArrayList) this.f206729h).clear();     // Catch: Throwable -> L13
        this.f206724c = null;     // Catch: Throwable -> L13
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        ILarkLynxContainer r103 = (ILarkLynxContainer) r100.element;
        if (r103 == null) goto L18;
        r103.destroy();
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f206723b == null) goto L5;
        return;
    L5:
        if (this.f206727f.a() == true) goto L86;
        return;
    L86:
        XBridgeLynxKitRuntime r100 = null;
        String r101 = ((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).b().a(this.f206722a.f478117b);     // Catch: Throwable -> L14
        if (r101 != null) goto L11;
    L16:
        boolean r102 = true;
    L17:
        if (r102 == false) goto L20;
        g("viewType=" + this.f206722a.f478117b + " is not available in current host");     // Catch: Throwable -> L14
        return;
    L20:
        Object r103 = BitableLynxEnv.f206706a;     // Catch: Throwable -> L14
        BitableLynxEnv.a(this.f206722a.getContext());     // Catch: Throwable -> L14
        com.bytedance.ee.bear.bitable.anniex.host.c r104 = (com.bytedance.ee.bear.bitable.anniex.host.c) org.koin.java.a.c(com.bytedance.ee.bear.bitable.anniex.host.c.class, null, null, 6);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r104, "runtimeHost");     // Catch: Throwable -> L14
        Context r105 = this.f206722a.getContext();     // Catch: Throwable -> L14
        fo4.a r106 = this.f206722a;     // Catch: Throwable -> L14
        int r107 = r106.f478117b;     // Catch: Throwable -> L14
        Map<String, ? extends Object> r108 = r106.f478118c;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r108, "overrides");     // Catch: Throwable -> L14
        com.bytedance.ee.bear.bitable.anniex.host.d r109 = r104.c(r107);     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r109, com.bytedance.ee.bear.bitable.anniex.host.d.a.f206744a) == false) goto L24;
        com.bytedance.ee.bear.bitable.anniex.host.a<Map<String, Object>> r110 = r104.a(r105, r108);     // Catch: Throwable -> L14
    L27:
        if ((r110 instanceof com.bytedance.ee.bear.bitable.anniex.host.a.b) == false) goto L64;
        Map<String, ? extends Object> r111 = (Map) ((com.bytedance.ee.bear.bitable.anniex.host.a.b) r110).f206740a;     // Catch: Throwable -> L14
        this.f206725d = r101;     // Catch: Throwable -> L14
        h r112 = new h(this.f206722a.f478117b, r101);     // Catch: Throwable -> L14
        this.f206726e = r112;     // Catch: Throwable -> L14
        LarkLynxContainerBuilder r113 = new LarkLynxContainerBuilder(this.f206722a.getContext()).containerContext(new b(this.f206722a.f478117b, r101)).tagForCustomComponent("BitableBiz").tagForTemplateLoader("BitableBiz").tagForBridgeProtocol("BitableBridge").bridgeRuntimeFactory(e.f206735a).imageLoader(new com.bytedance.ee.bear.bitable.anniex.util.a());     // Catch: Throwable -> L14
        fo4.a r114 = this.f206722a;     // Catch: Throwable -> L14
        LarkLynxContainerBuilder r115 = r113.lynxViewLifeCycle(new a(CollectionsKt.listOfNotNull(new q1[]{r114.f478120e, new ho4.a(r114.f478117b, r101)}))).templateLoadListener(new f(r112, this));     // Catch: Throwable -> L14
        LynxGroup r116 = this.f206722a.f478122g;     // Catch: Throwable -> L14
        if (r116 == null) goto L31;
        LarkLynxKitInitializer.Companion.getClass();     // Catch: Throwable -> L14
        LarkLynxKitInitializer.b.a().registerLynxGroup(r116.getID(), new d(r116));     // Catch: Throwable -> L14
        r115.tagForJsContext(r116.getID());     // Catch: Throwable -> L14
    L31:
        k7a.a r117 = this.f206722a.f478123h;     // Catch: Throwable -> L14
        if (r117 == null) goto L34;
        r115.setDynamicComponentFetcher(r117);     // Catch: Throwable -> L14
    L34:
        final ILarkLynxContainer r118 = r115.build();     // Catch: Throwable -> L14
        r118.updateGlobalData(r111);     // Catch: Throwable -> L14
        View r119 = r118.getLynxView();     // Catch: Throwable -> L14
        if ((r119 instanceof LynxView) == false) goto L37;
        LynxView r120 = (LynxView) r119;     // Catch: Throwable -> L14
    L38:
        if (r120 == null) goto L42;
        LynxContext r121 = r120.getLynxContext();     // Catch: Throwable -> L14
        if (r121 == null) goto L42;
        r121.setForceImageAsyncRequest(true);     // Catch: Throwable -> L14
    L42:
        final Ref.BooleanRef r122 = new Ref.BooleanRef();     // Catch: Throwable -> L14
        BitableLynxHolderState r123 = this.f206727f;     // Catch: Throwable -> L14
        Function0<Unit> r124 = new BitableLynxViewHolder$initView$3(this, r118, r122);     // Catch: Throwable -> L14
        r123.getClass();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r124, "action");     // Catch: Throwable -> L14
        Object r125 = r123.f206718a;     // Catch: Throwable -> L14
        monitor-enter(r125);     // Catch: Throwable -> L14
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L45:
        if (r123.f206719b != BitableLynxHolderState.State.ACTIVE) goto L48;
        r124.invoke();     // Catch: Throwable -> L60
    L48:
        monitor-exit(r125);     // Catch: Throwable -> L14
        if (r122.element == true) goto L53;
        r118.destroy();     // Catch: Throwable -> L14
        return;
    L53:
        ILarkLynxBridgeProtocolHandle r126 = r118.getBridgeProtocolHandle();     // Catch: Throwable -> L14
        if ((r126 instanceof XBridgeLynxKitRuntime) == false) goto L56;
        r100 = (XBridgeLynxKitRuntime) r126;     // Catch: Throwable -> L14
    L56:
        if (r100 == null) goto L58;
        a(r100);     // Catch: Throwable -> L14
    L59:
        tt5.a.h("BitableLynxViewHolder", "initView success, viewType=" + this.f206722a.f478117b + ", bundlePath=" + r101);     // Catch: Throwable -> L14
        return;
    L58:
        tt5.a.d("BitableLynxViewHolder", "bridge runtime handle is null");     // Catch: Throwable -> L14
        goto L59
    L37:
        r120 = null;
        goto L38
    L64:
        if ((r110 instanceof com.bytedance.ee.bear.bitable.anniex.host.a.d) == false) goto L68;
        g(((com.bytedance.ee.bear.bitable.anniex.host.a.d) r110).f206741a);     // Catch: Throwable -> L14
        return;
    L68:
        if ((r110 instanceof com.bytedance.ee.bear.bitable.anniex.host.a.c) == false) goto L72;
        ((com.bytedance.ee.bear.bitable.anniex.host.a.c) r110).getClass();     // Catch: Throwable -> L14
        g(null);     // Catch: Throwable -> L14
        return;
    L72:
        if ((r110 instanceof com.bytedance.ee.bear.bitable.anniex.host.a.C2983a) == false) goto L76;
        g(((com.bytedance.ee.bear.bitable.anniex.host.a.C2983a) r110).f206738a);     // Catch: Throwable -> L14
        return;
    L76:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    L24:
        if ((r109 instanceof com.bytedance.ee.bear.bitable.anniex.host.d.b) == false) goto L78;
        r110 = new com.bytedance.ee.bear.bitable.anniex.host.a.d(((com.bytedance.ee.bear.bitable.anniex.host.d.b) r109).f206745a);     // Catch: Throwable -> L14
        goto L27
    L78:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    L11:
        if (r101.length() == 0) goto L16;
        r102 = false;
    L14:
        th = move-exception;
        tt5.a.e("BitableLynxViewHolder", "initView failed", th, false);
        String r127 = th.getMessage();
        if (r127 != null) goto L82;
        r127 = "initView failed";
    L82:
        g(r127);
    }

    public final boolean e() {
        BitableLynxHolderState r100 = this.f206727f;
        Object r101 = r100.f206718a;
        monitor-enter(r101);
        if (r100.f206719b != BitableLynxHolderState.State.DESTROYED) goto L7;
        boolean r102 = true;
    L8:
        monitor-exit(r101);
        return r102;
    L7:
        r102 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f() {
        if (this.f206727f.a() == true) goto L6;
        return;
    L6:
        if (this.f206723b != null) goto L8;
        d();
    L8:
        ILarkLynxContainer r100 = this.f206723b;
        if (r100 != null) goto L11;
        return;
    L11:
        String r101 = this.f206725d;
        if (r101 != null) goto L15;
        r101 = ((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).b().a(this.f206722a.f478117b);
    L15:
        if (r101 != null) goto L17;
    L20:
        boolean r102 = true;
    L21:
        if (r102 == false) goto L25;
        g("bundle path is empty, viewType=" + this.f206722a.f478117b);
        return;
    L25:
        if (eu5.c.c() == false) goto L32;
        ml5.b r103 = new ml5.b("debug_config");
        if (((Boolean) r103.a("lynx_bitable_enable_proxy", Boolean.FALSE)).booleanValue() == false) goto L32;
        String r104 = (String) r103.a("lynx_bitable_proxy_ip", "");
        if (TextUtils.isEmpty(r104) == true) goto L32;
        String r105 = "http://" + r104 + '/' + StringsKt.trimStart(r101, new char[]{'/'});
    L57:
        if (r105 == null) goto L36;
        r100.renderWithTemplateData(r105, this.f206722a.f478121f, null);     // Catch: Throwable -> L39
        return;
    L36:
        h r106 = this.f206726e;     // Catch: Throwable -> L39
        if (r106 == null) goto L41;
        int r107 = h.f206758d;     // Catch: Throwable -> L39
        r106.f206761c = System.currentTimeMillis();     // Catch: Throwable -> L39
    L41:
        r100.renderByTemplateLoaderWithTemplateData(r101, this.f206722a.f478121f, null);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        String r108 = "load failed";
        tt5.a.e("BitableLynxViewHolder", "load failed", th, false);
        if (r105 != null) goto L51;
        h r109 = this.f206726e;
        if (r109 == null) goto L51;
        String r110 = th.getMessage();
        if (r110 != null) goto L50;
        r110 = "load failed";
    L50:
        h.c(r109, "forest_loader", r110, null, 12);
    L51:
        String r111 = th.getMessage();
        if (r111 == null) goto L55;
        r108 = r111;
    L55:
        g(r108);
        return;
    L32:
        r105 = null;
        goto L57
    L17:
        if (r101.length() == 0) goto L20;
        r102 = false;
        goto L21
    }

    public BitableLynxViewHolder(fo4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f206722a = r100;
        this.f206727f = new BitableLynxHolderState();
        this.f206728g = new Object();
        this.f206729h = new ArrayList();
    }

    public final void a(XBridgeLynxKitRuntime r100) {
        Object r101 = this.f206728g;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f206727f.a() == true) goto L8;
        monitor-exit(r101);
        return;
    L8:
        this.f206724c = r100;     // Catch: Throwable -> L15
        List r102 = CollectionsKt.toList(this.f206729h);     // Catch: Throwable -> L15
        ((ArrayList) this.f206729h).clear();     // Catch: Throwable -> L15
        monitor-exit(r101);
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((Function1) r103.next()).invoke(r100);
        goto L12
    }

    public final View c(boolean r100) {
        if (this.f206723b == null) goto L5;
    L11:
        ILarkLynxContainer r101 = this.f206723b;
        if (r101 != null) goto L16;
        return null;
    L16:
        return r101.getLynxView();
    L5:
        if (this.f206727f.a() == false) goto L11;
        d();
        if (r100 == false) goto L11;
        if (this.f206727f.a() == false) goto L11;
        f();
        goto L11
    }

    public final void g(String r100) {
        if (this.f206727f.c() == true) goto L5;
        return;
    L5:
        Object r101 = this.f206728g;
        monitor-enter(r101);
        ((ArrayList) this.f206729h).clear();     // Catch: Throwable -> L16
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        tt5.a.d("BitableLynxViewHolder", "notifyLoadFailed: " + r100);
        q1 r103 = this.f206722a.f478120e;
        if (r103 == null) goto L12;
        r103.onLoadFailed(r100);
    L12:
        zm4.a r104 = this.f206722a.f478119d;
        if (r104 == null) goto L21;
        r104.a(r100);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void h(final XCoreBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        j(new BitableLynxViewHolder$registerLynxMethod$1(r100));
    }

    public final void j(Function1<? super XBridgeLynxKitRuntime, Unit> r100) {
        Object r101 = this.f206728g;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.f206727f.a() == true) goto L8;
        monitor-exit(r101);
        return;
    L8:
        XBridgeLynxKitRuntime r102 = this.f206724c;     // Catch: Throwable -> L16
        if (r102 != null) goto L12;
        ((ArrayList) this.f206729h).add(r100);     // Catch: Throwable -> L16
        r102 = null;
    L12:
        monitor-exit(r101);
        if (r102 == null) goto L21;
        r100.invoke(r102);
        return;
    }

    public final void l(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ILarkLynxContainer r101 = this.f206723b;
        if (r101 == null) goto L6;
        r101.updateData(r100, null);
        return;
    }

    public final <T> void i(final Class<T> r100, final T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        j(new BitableLynxViewHolder$registerService$1(r100, r101));
    }

    public final void k(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ILarkLynxContainer r102 = this.f206723b;
        if (r102 == null) goto L12;
        if (r101 != null) goto L7;
        List<? extends Object> r103 = CollectionsKt.emptyList();
    L10:
        r102.sendGlobalEventToJS(r100, r103);
        return;
    L7:
        if ((r101 instanceof List) == false) goto L9;
        r103 = CollectionsKt.filterNotNull((Iterable) r101);
        goto L10
    L9:
        r103 = CollectionsKt.listOf(r101);
        goto L10
    }
}
