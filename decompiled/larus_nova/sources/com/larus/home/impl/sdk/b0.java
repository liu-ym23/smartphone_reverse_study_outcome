package com.larus.home.impl.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.ies.xelement.LynxLottieView;
import com.bytedance.ies.xelement.LynxPullRefreshView;
import com.bytedance.ies.xelement.LynxRefreshFooter;
import com.bytedance.ies.xelement.LynxRefreshHeader;
import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import com.bytedance.ies.xelement.audiott.LynxAudioTTView;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.bytedance.ies.xelement.overlay.LynxOverlayViewProxy;
import com.bytedance.ies.xelement.overlay.ng.LynxOverlayViewProxyNG;
import com.bytedance.ies.xelement.overlay.ng.OverlayShadowNodeNG;
import com.bytedance.ies.xelement.video.pro.LynxVideoUI;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldHeader;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlot;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlotDrag;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.bytedance.ies.xelement.viewpager.foldview.LynxFoldViewNG;
import com.bytedance.locallife.ILocalLifeService;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.larus.bmhome.chat.layout.item.u4;
import com.larus.common.apphost.AppHost;
import com.larus.ivykit.IvyKitInitializer;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.platform.api.e4;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 implements com.larus.platform.api.u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f346140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f346141b = null;

    public static final class a implements e4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kx7.b f346142a;

        @Override // com.larus.platform.api.e4
        public final void destroy() {
            kx7.b r100 = this.f346142a;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // com.larus.platform.api.e4
        public final String getContainerId() {
            kx7.b r100 = this.f346142a;
            if (r100 == null) goto L6;
            String r101 = r100.b();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.platform.api.e4
        public final View getView() {
            kx7.b r100 = this.f346142a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.c();
        }

        public a(kx7.b r100) {
            this.f346142a = r100;
        }

        @Override // com.larus.platform.api.e4
        public final void updateData(String r100) {
            Intrinsics.checkNotNullParameter(r100, "renderData");
            kx7.b r101 = this.f346142a;
            if (r101 == null) goto L6;
            r101.d(r100, new com.ivy.ivykit.api.plugin.d());
            return;
        }
    }

    public static final class b implements ix7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f4 f346143a;

        @Override // ix7.d
        public final void a() {
            f4 r100 = this.f346143a;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // ix7.d
        public final void f() {
            f4 r100 = this.f346143a;
            if (r100 == null) goto L6;
            r100.f();
            return;
        }

        @Override // ix7.d
        public final void onLoadStart() {
            f4 r100 = this.f346143a;
            if (r100 == null) goto L6;
            r100.onLoadStart();
            return;
        }

        public b(f4 r100) {
            this.f346143a = r100;
        }

        @Override // ix7.d
        public final void b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            f4 r101 = this.f346143a;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // ix7.d
        public final void c(BulletContainerView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            f4 r101 = this.f346143a;
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        @Override // ix7.d
        public final void d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            f4 r101 = this.f346143a;
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }

        @Override // ix7.d
        public final void e(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            f4 r101 = this.f346143a;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // ix7.d
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            f4 r101 = this.f346143a;
            if (r101 == null) goto L6;
            r101.onLoadSuccess(r100);
            return;
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-refresh-footer");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxRefreshFooter(r100);
        }
    }

    public static final class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("lottie-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxBytedLottieView(r100, "");
        }
    }

    public static final class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("x-alpha-video");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxAlphaVideo(r100);
        }
    }

    public static final class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("lottie");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxLottieView(r100);
        }
    }

    public static final class g extends com.lynx.tasm.behavior.a {
        public g() {
            super("x-lottie");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxLottieView(r100);
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("inline-truncation");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new InlineTruncationShadowNode();
        }
    }

    public static final class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("x-overlay-ng");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            int r100 = com.larus.bmhome.t.f314193a;
            return new OverlayShadowNodeNG();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r101 = com.larus.bmhome.t.f314193a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxOverlayViewProxyNG(r100, null);
        }
    }

    public static final class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("x-overlay");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxOverlayViewProxy(r100);
        }
    }

    public static final class k extends com.lynx.tasm.behavior.a {
        public k() {
            super("x-audio-tt");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxAudioTTView(r100);
        }
    }

    public static final class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("x-video-pro");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r101 = com.larus.bmhome.t.f314193a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            LynxVideoUI r102 = new LynxVideoUI(r100);
            r102.T(new sic.a());
            return r102;
        }
    }

    public static final class m extends com.lynx.tasm.behavior.a {
        public m() {
            super("x-foldview-ng", false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxFoldViewNG(r100, null);
        }
    }

    public static final class n extends com.lynx.tasm.behavior.a {
        public n() {
            super("x-foldview-header-ng", false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxFoldHeader(r100);
        }
    }

    public static final class o extends com.lynx.tasm.behavior.a {
        public o() {
            super("x-foldview-slot-ng", false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxFoldSlot(r100);
        }
    }

    public static final class p extends com.lynx.tasm.behavior.a {
        public p() {
            super("x-foldview-slot-drag-ng", false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxFoldSlotDrag(r100);
        }
    }

    public static final class q extends com.lynx.tasm.behavior.a {
        public q() {
            super("x-foldview-toolbar-ng", false);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxFoldToolbar(r100);
        }
    }

    public static final class r extends com.lynx.tasm.behavior.a {
        public r() {
            super("x-refresh-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxPullRefreshView(r100, null);
        }
    }

    public static final class s extends com.lynx.tasm.behavior.a {
        public s() {
            super("x-refresh-header");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxRefreshHeader(r100);
        }
    }

    public b0() {
    }

    static {
        f346140a = new b0();
        f346141b = LazyKt.lazy(new a0());
    }

    @Override // com.larus.platform.api.u2
    public final List<Object> a() {
        Object[] r100 = new Object[18];
        r100[0] = new k();
        r100[1] = new l();
        r100[2] = new m();
        r100[3] = new n();
        r100[4] = new o();
        r100[5] = new p();
        r100[6] = new q();
        r100[7] = new r();
        r100[8] = new s();
        r100[9] = new c();
        r100[10] = new d();
        r100[11] = new e();
        r100[12] = new f();
        r100[13] = new g();
        r100[14] = new h();
        r100[15] = new i();
        r100[16] = new j();
        ILocalLifeService r101 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r101 == null) goto L5;
        gl6.c r102 = r101.d();
    L6:
        r100[17] = r102;
        return CollectionsKt.listOfNotNull(r100);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.platform.api.u2
    public final boolean d() {
        IvyKitInitializer r100 = IvyKitInitializer.f351614a;
        return IvyKitInitializer.c();
    }

    @Override // com.larus.platform.api.u2
    public final void f() {
        if (ObricLazyInitSettingsServiceDelegate.f392888a.e() == true) goto L6;
        IvyKitInitializer.f351614a.b(AppHost.f326268a.getApplication(), new d0());
        return;
    L6:
        IvyKitInitializer r100 = IvyKitInitializer.f351614a;
        if (IvyKitInitializer.c() == true) goto L9;
        r100.b(AppHost.f326268a.getApplication(), new d0());
    L9:
        IXBridgeApi.Companion r101 = IXBridgeApi.f379669a;
        r101.init();
        r101.a();
    }

    @Override // com.larus.platform.api.u2
    public final String b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "channel");
        IFlowForestService r103 = (IFlowForestService) f346141b.getValue();
        if (r103 == null) goto L6;
        String r104 = r103.b(r100, r101, r102);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.u2
    public final View c(Context r110, String r111, com.larus.bmhome.chat.layout.widget.handler.h r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "headerTransform");
        if (ObricLazyInitSettingsServiceDelegate.f392888a.e() == false) goto L5;
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=IvyKit, trigger=first_use");
        f();
    L5:
        String r100 = com.larus.ivykit.c.a();
        IIvyWebService.Companion r101 = IIvyWebService.f278339a;
        lx7.a r102 = IIvyWebService.a.a(r101, r100, "", new c0(r112), null, null, null, null, null, 504);
        Intrinsics.checkNotNull(r102);
        kx7.c r103 = r101.b("", r102, r110);
        if (r103 == null) goto L9;
        r103.d(r111);
    L9:
        if (r103 == null) goto L30;
        WebView r104 = r103.j();
        if (r104 == null) goto L17;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L16;
        r105.width = -1;
        r105.height = (int) (((double) com.larus.utils.m0.b(r110)) * 0.75d);
        r104.setLayoutParams(r105);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        BulletContainerView r106 = r103.f();
        if (r106 == null) goto L24;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L23;
        r107.width = -1;
        r107.height = (int) (((double) com.larus.utils.m0.b(r110)) * 0.75d);
        r106.setLayoutParams(r107);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L24:
        BulletContainerView r108 = r103.f();
        if (r108 == null) goto L27;
        r108.setOnClickListener(null);
    L27:
        WebView r109 = r103.j();
        if (r109 == null) goto L30;
        r109.setOnClickListener(null);
    L30:
        if (r103 != null) goto L32;
        return null;
    L32:
        return r103.f();
    }

    @Override // com.larus.platform.api.u2
    public final void e(String r100, String r101, u4 r102) {
        Intrinsics.checkNotNullParameter(r100, "bundleOrUrl");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r102, "onFinish");
        IFlowForestService r103 = (IFlowForestService) f346141b.getValue();
        if (r103 == null) goto L6;
        r103.d(r100, r101, false, r102);
        return;
    }

    @Override // com.larus.platform.api.u2
    public final e4 g(Context r110, String r111, String r112, f4 r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "templateUrl");
        if (ObricLazyInitSettingsServiceDelegate.f392888a.e() == false) goto L6;
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=IvyKit, trigger=first_use");
        f();
    L6:
        return new a(IvyPluginService.a.a(IvyPluginService.f278342a, r110, r111, null, new b(r113), r112, 4));
    }
}
