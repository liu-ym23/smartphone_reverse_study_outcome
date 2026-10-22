package com.larus.home.impl.sdk;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.ai.api.AppletService;
import com.bytedance.router.SmartRouter;
import com.google.gson.JsonObject;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.bmhome.chat.component.thirdpart.ThirdPartLogicComponent$doraAudioStateObserver$1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.model.DoraBuryPointSource;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements com.larus.platform.api.j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f346231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f346232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f346233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<com.larus.platform.api.o, h49.k> f346234d;

    public static final class a implements h49.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.platform.api.o f346235a;

        public a(com.larus.platform.api.o r100) {
            this.f346235a = r100;
        }

        @Override // h49.k
        public final void a(int r100) {
            this.f346235a.a(r100);
        }

        @Override // h49.k
        public final void onStateChange(int r100) {
            this.f346235a.onStateChange(r100);
        }
    }

    public final IDoraService B() {
        return (IDoraService) this.f346231a.getValue();
    }

    public final IDoraAVLinkService v() {
        return (IDoraAVLinkService) this.f346232b.getValue();
    }

    public s() {
        this.f346231a = LazyKt.lazy(new p());
        this.f346232b = LazyKt.lazy(new q());
        this.f346233c = LazyKt.lazy(new r());
        this.f346234d = new ConcurrentHashMap();
    }

    public final Boolean D() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.hasDoraDevice());
    }

    public final Boolean E() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.h0());
    }

    public final Boolean F() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.E();
    L7:
        return null;
    }

    public final boolean G() {
        IDoraService r100 = B();
        if (r100 == null) goto L9;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L9;
        if (r101.V() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean H() {
        IDoraService r100 = B();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean J() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        com.larus.dora.impl.serviceimpl.h r101 = r100.debug();
        if (r101 == null) goto L7;
        return r101.g();
    L7:
        return false;
    }

    public final boolean K() {
        IDoraAVLinkService r100 = v();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isRecording() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean L() {
        IDoraAVLinkService r100 = v();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.s();
    }

    public final void O() {
        IDoraAVLinkService r100 = v();
        if (r100 == null) goto L6;
        r100.D();
        return;
    }

    public final String Q() {
        IDoraAVLinkService r100 = v();
        if (r100 == null) goto L6;
        String r101 = r100.postProcessorVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void S() {
        IDoraService r100 = B();
        if (r100 == null) goto L6;
        r100.h1(172, false);
        return;
    }

    public final void T() {
        IDoraService r100 = B();
        if (r100 == null) goto L6;
        r100.h1(171, false);
        return;
    }

    public final String W() {
        IDoraAVLinkService r100 = v();
        if (r100 == null) goto L6;
        String r101 = r100.videoStabilizerVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.j2
    public final boolean b() {
        IDoraAVLinkService r100 = v();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.j2
    public final boolean c() {
        IDoraService r100 = B();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.j2
    public final Deferred<Integer> g() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        SessionService r101 = r100.d();
        if (r101 == null) goto L7;
        return r101.d();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.j2
    public final int getProductId() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.y();
    L7:
        return 0;
    }

    @Override // com.larus.platform.api.j2
    public final Integer h() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.h());
    }

    @Override // com.larus.platform.api.j2
    public final boolean isDoraConnected() {
        IDoraService r100 = B();
        if (r100 == null) goto L9;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L9;
        if (r101.J() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.j2
    public final Deferred<Integer> j() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        SessionService r101 = r100.d();
        if (r101 == null) goto L7;
        return r101.f();
    L7:
        return null;
    }

    @Override // com.larus.platform.api.j2
    public final Integer l() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getLinkState());
    }

    @Override // com.larus.platform.api.j2
    public final void m() {
        IDoraService r100 = B();
        if (r100 == null) goto L6;
        r100.h1(163, false);
        return;
    }

    public final Map<String, String> p() {
        IDoraService r100 = B();
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.f0();
        if (r101 == null) goto L6;
    L7:
        FLogger.f375446a.i("DoraServiceImpl", "doraparam1: " + r101);
        return r101;
    L6:
        r101 = MapsKt.emptyMap();
        goto L7
    }

    @Override // com.larus.platform.api.j2
    public final Integer q() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.q());
    }

    @Override // com.larus.platform.api.j2
    public final Integer r() {
        IDoraService r100 = B();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.r());
    }

    public final void s() {
        IDoraAVLinkService r100 = v();
        if (r100 == null) goto L6;
        r100.J0(0);
        return;
    }

    public final String t() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.x();
    L7:
        return "";
    }

    public final boolean u() {
        IDoraAVLinkService r100 = v();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.E1(0) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String w() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.l();
    L7:
        return null;
    }

    public final String x() {
        IDoraAVLinkService r100 = v();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.u0();
    }

    public final String y() {
        IDoraService r100 = B();
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.m();
    L7:
        return null;
    }

    public final int z() {
        IDoraService r100 = B();
        if (r100 == null) goto L5;
        r100.F0();
        return R.string.larus_dora_device_list_title_cn;
    L5:
        return R.string.larus_dora_entry_settings_item_title;
    }

    public final String A(Integer r100) {
        IDoraAVLinkService r101 = v();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.u1(r100);
    }

    public final void C(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cmdValue");
        IDoraService r101 = B();
        if (r101 == null) goto L6;
        r101.n0(r100);
        return;
    }

    public final boolean I(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        IDoraAVLinkService r101 = v();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.o1(r100) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void N(by7.e r100) {
        M(AppHost.f326268a.getApplication(), r100);
    }

    public final void R(JsonObject r100) {
        Intrinsics.checkNotNullParameter("applet.recordASRContentChanged", "name");
        Intrinsics.checkNotNullParameter(r100, "params");
        AppletService r101 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r101 == null) goto L6;
        r101.a("applet.recordASRContentChanged", r100);
        return;
    }

    public final void U(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        IDoraAVLinkService r101 = v();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void V(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        IDoraService r101 = B();
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final void a(int r100) {
        IDoraGuideService r101 = (IDoraGuideService) this.f346233c.getValue();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final void f(com.larus.platform.api.o r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ConcurrentHashMap<com.larus.platform.api.o, h49.k> r101 = this.f346234d;
        h49.k r102 = r101.get(r100);
        if (r102 != null) goto L8;
        r102 = new a(r100);
        h49.k r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        h49.k r104 = r102;
        IDoraService r105 = B();
        if (r105 == null) goto L12;
        Intrinsics.checkNotNull(r104);
        r105.L0(r104);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final void i(boolean r100) {
        IDoraAVLinkService r101 = v();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final void k(ThirdPartLogicComponent$doraAudioStateObserver$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        h49.k r101 = this.f346234d.remove(r100);
        if (r101 == null) goto L8;
        IDoraService r102 = B();
        if (r102 == null) goto L9;
        r102.x(r101);
        return;
    L9:
        return;
    }

    @Override // com.larus.platform.api.j2
    public final void n(FragmentManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        IDoraService r101 = B();
        if (r101 == null) goto L6;
        r101.n(r100);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final Integer o(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        IDoraService r101 = B();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.o(r100);
    }

    public final void M(Context r110, by7.e r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        IDoraAVLinkService r100 = v();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        Integer r104 = null;
        if (r103 == null) goto L11;
        t39.d r105 = r103.L();
    L12:
        if (r102 == true) goto L63;
        IDoraService r106 = B();
        if (r106 == null) goto L63;
        DeviceService r107 = r106.device();
        if (r107 == null) goto L63;
        List<t39.d> r108 = r107.j();
        if (r108.isEmpty() == true) goto L28;
        Iterator<T> r109 = r108.iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        if (r107.Q(((t39.d) r109.next()).f544461b) == false) goto L24;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L63;
        if (r105 == null) goto L33;
        String r113 = r105.f544461b;
    L34:
        if (r113 != null) goto L36;
    L39:
        boolean r114 = true;
    L40:
        if (r114 == false) goto L42;
    L44:
        Iterator<T> r115 = r108.iterator();
    L46:
        if (r115.hasNext() == false) goto L61;
        Object r116 = r115.next();
        t39.d r117 = (t39.d) r116;
        String r118 = r117.f544461b;
        if (r118 != null) goto L50;
    L53:
        boolean r119 = true;
    L54:
        if (r119 == false) goto L56;
    L58:
        boolean r120 = false;
    L59:
        if (r120 == false) goto L46;
    L62:
        r105 = (t39.d) r116;
        goto L63
    L56:
        if (r107.Q(r117.f544461b) == true) goto L58;
        r120 = true;
        goto L59
    L50:
        if (r118.length() == 0) goto L53;
        r119 = false;
        goto L54
    L61:
        r116 = null;
        goto L62
    L42:
        if (r107.Q(r113) == true) goto L44;
    L36:
        if (r113.length() == 0) goto L39;
        r114 = false;
        goto L40
    L33:
        r113 = null;
    L28:
        r112 = false;
    L63:
        Serializable r121 = "";
        if (r105 == null) goto L67;
        String r122 = r105.f544461b;
        if (r122 == null) goto L67;
    L68:
        IDoraService r123 = B();
        if (r123 != null) goto L71;
    L73:
        boolean r124 = false;
    L74:
        if (r124 == false) goto L77;
        String r125 = "//flow/dora/obric_device_home";
    L96:
        com.bytedance.router.i r126 = SmartRouter.buildRoute(r110, r125);
        r126.f267555d = R.anim.larus_router_slide_in_right;
        r126.f267556e = R.anim.larus_router_no_anim;
        Bundle r127 = BundleKt.bundleOf();
        if (r111 == null) goto L99;
        by7.h.k(r127, r111);
    L99:
        r126.f267554c.putExtras(r127);
        r126.f267554c.addFlags(603979776);
        if (r105 == null) goto L105;
        Integer r128 = r105.f544462c;
        if (r128 == null) goto L105;
        r121 = r128;
    L105:
        r126.f267554c.putExtra("product_id", r121);
        r126.f267554c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r122);
        if (r122.length() <= 0) goto L108;
        r101 = true;
    L108:
        if (r101 == false) goto L110;
        String r129 = "device_manage_v3";
    L111:
        r126.f267554c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, r129);
        r126.d();
        return;
    L110:
        r129 = "device_list_v2";
        goto L111
    L77:
        if (r122.length() <= 0) goto L79;
        boolean r130 = true;
    L80:
        if (r130 == false) goto L95;
        if (r102 == false) goto L94;
        IDoraService r131 = B();
        if (r131 != null) goto L85;
    L91:
        boolean r132 = false;
    L92:
        if (r132 == false) goto L94;
        r125 = "//dora_g_device_management";
        goto L96
    L85:
        if (r131.device() == null) goto L91;
        if (r105 == null) goto L89;
        r104 = r105.f544462c;
    L89:
        if (o59.a.o(r104) != true) goto L91;
        r132 = true;
    L94:
        r125 = "//dora_dynamic_list";
        goto L96
    L95:
        r125 = "//flow/dora/device_list";
        goto L96
    L79:
        r130 = false;
        goto L80
    L71:
        if (r123.l() != true) goto L73;
        r124 = true;
    L67:
        r122 = "";
        goto L68
    L11:
        r105 = null;
        goto L12
    L5:
        if (r100.P0() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void P(String r100, String r101) {
        IDoraAVLinkService r102 = v();
        if (r102 == null) goto L6;
        r102.v(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.j2
    public final int e(Context r100, List r101, LifecycleCoroutineScope r102, com.larus.bmhome.chat.component.thirdpart.d r110) {
        Intrinsics.checkNotNullParameter(DoraBuryPointSource.MAIN_BOT_PAGE, "page");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "guideFilterList");
        Intrinsics.checkNotNullParameter(r102, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r110, "guideListener");
        IDoraGuideService r103 = (IDoraGuideService) this.f346233c.getValue();
        if (r103 != null) goto L7;
        return -1;
    L7:
        return r103.e(DoraBuryPointSource.MAIN_BOT_PAGE, r100, r101, r102, r110);
    }

    @Override // com.larus.platform.api.j2
    public final void d(int r100, int r101, Fragment r110, View r111, LifecycleCoroutineScope r112) {
        Intrinsics.checkNotNullParameter(r112, "lifeCycleScope");
        IDoraGuideService r102 = (IDoraGuideService) this.f346233c.getValue();
        if (r102 == null) goto L6;
        r102.d(r100, r101, r110, r111, r112);
        return;
    }
}
