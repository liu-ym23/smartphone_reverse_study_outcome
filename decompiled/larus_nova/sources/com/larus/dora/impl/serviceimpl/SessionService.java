package com.larus.dora.impl.serviceimpl;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.util.b0;
import com.larus.settings.value.e10;
import com.larus.settings.value.rf;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionService implements IDoraService.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f337979e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile long f337980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<HandlerThread> f337981g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<Handler> f337982h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f337983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<f49.b, q> f337984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f337985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f337986d;

    public static final class a {
        public a() {
        }

        public static final String a(int r100) {
            a r101 = SessionService.f337979e;
            if (r100 != 1) goto L5;
            return "VOICE";
        L5:
            if (r100 != 2) goto L7;
            return "RADIO";
        L7:
            if (r100 != 3) goto L9;
            return "KEY";
        L9:
            if (r100 != 6) goto L11;
            return "LIVE_AI_VOICE";
        L11:
            if (r100 != 7) goto L13;
            return "LIVE_AI_TOUCH";
        L13:
            if (r100 != 11) goto L15;
            return "ENV_OBSERVE";
        L15:
            if (r100 == 32) goto L17;
            return "UNKNOWN";
        L17:
            return "LIVE_AI_VIDEO_STREAM";
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f337987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f337988b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f337987a == r101.f337987a) goto L12;
            return false;
        L12:
            if (this.f337988b == r101.f337988b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f337987a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f337988b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "P2PRTCDecision(useP2PRTC=" + this.f337987a + ", systemWifiEnabled=" + this.f337988b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f337987a = r100;
            this.f337988b = r101;
        }
    }

    static {
        f337979e = new a();
        f337981g = LazyKt.lazy(new w());
        f337982h = LazyKt.lazy(new x());
    }

    public final int c() {
        g49.d.d("DoraTrace", "disableVUI");
        this.f337983a = true;
        return kj4.a.g().syncVUIEvent(sk4.g.f542409h);
    }

    public final Deferred<Integer> d() {
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$disableVUIAsync$1(this, null), 3, null);
    }

    public final int e() {
        g49.d.d("DoraTrace", "enableVUI");
        if (kj4.a.g().getDoraState() != 2) goto L5;
        g49.d.d("ProactiveSummaryRecords", "consume proactive summary cache in isVUIDisabled is false");
        DoraAVLinkDelegate.f291640b.u();
    L5:
        this.f337983a = false;
        return kj4.a.g().syncVUIEvent(sk4.g.f542411j);
    }

    public final Deferred<Integer> f() {
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$enableVUIAsync$1(this, null), 3, null);
    }

    public final int j() {
        return kj4.a.g().setConversationMode(22, 1, 60, 1, 5);
    }

    public SessionService() {
        this.f337984b = new LinkedHashMap();
        this.f337985c = -1;
        this.f337986d = -1;
    }

    public final int n() {
        return kj4.a.g().startVUI(3, 30);
    }

    @Override // com.larus.dora.api.IDoraService.h
    public final int a() {
        return this.f337985c;
    }

    public static boolean k(b r100) {
        if (r100.f337987a == true) goto L5;
        return false;
    L5:
        if (r100.f337988b == true) goto L7;
        return false;
    L7:
        if (((Keva) y39.b.f565905a.getValue()).getBoolean("mock_p2p_rtc_start_failed", false) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final String g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L5;
        DeviceService r102 = r101.device();
    L6:
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L15;
        if (r102 != null) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == true) goto L25;
        if (r102 != null) goto L30;
    L32:
        boolean r106 = false;
    L33:
        if (r106 == true) goto L35;
        if (r102 != null) goto L40;
    L42:
        if (r103 == false) goto L48;
        if (Intrinsics.areEqual(r100, "dora_half_duplex") == false) goto L46;
        return "wjniI7WRchbdX0rm";
    L46:
        return "MGdLITXH7b6Y2Yx5";
    L48:
        if (Intrinsics.areEqual(r100, "dora_half_duplex") == false) goto L50;
        return "HmRdheYWOw";
    L50:
        return "VWkAjHuAlm";
    L40:
        if (r102.f() != true) goto L42;
        r103 = true;
        goto L42
    L35:
        if (Intrinsics.areEqual(r100, "dora_half_duplex") == false) goto L37;
        return "qoZHsKsRzH";
    L37:
        return "HqxgWPsgLv";
    L30:
        if (r102.L() != true) goto L32;
        r106 = true;
        goto L33
    L25:
        if (Intrinsics.areEqual(r100, "dora_half_duplex") == false) goto L27;
        return "HgZBnrFyOUeW9eWN";
    L27:
        return "Wd4coUDTJ8zmVZ0T";
    L20:
        if (r102.N() != true) goto L22;
        r105 = true;
        goto L23
    L15:
        if (Intrinsics.areEqual(r100, "dora_half_duplex") == false) goto L17;
        return "phiDZKCcuhc6srv1";
    L17:
        return "8WXv2rMtrmQ6QeJd";
    L9:
        if (r102.O() != true) goto L11;
        r104 = true;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public final void i(f49.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        q r101 = new q(r100);
        this.f337984b.put(r100, r101);
        kj4.a.g().registerDoraVoiceCallback(r101);
    }

    public final int m(int r100) {
        DoraBuryPointManager.f331862a.I("start", r100, -1);
        return kj4.a.g().startConversationMode(60, r100);
    }

    public final int p(int r100) {
        DoraBuryPointManager.f331862a.I("end", r100, -1);
        return kj4.a.g().stopConversationMode(r100);
    }

    public final int q(int r100) {
        return kj4.a.g().stopVUI(3, r100);
    }

    public final int w(int r100) {
        return kj4.a.g().syncVUIPreWakeUp(r100);
    }

    public final void x(f49.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        q r101 = this.f337984b.remove(r100);
        if (r101 == null) goto L6;
        kj4.a.g().unRegisterDoraVoiceCallback(r101);
        return;
    }

    public static void h(b r100, String r101) {
        if (r100.f337987a == true) goto L5;
    L11:
        FLogger.f375446a.i("DoraOTA", "skip P2P RTC failure prompt: source=" + r101 + ", useP2PRTC=" + r100.f337987a + ", systemWifiEnabled=" + r100.f337988b);
        return;
    L5:
        if (r100.f337988b == false) goto L11;
        FLogger.f375446a.i("DoraOTA", "play P2P RTC failure prompt: source=" + r101);
        IDoraAVLinkService r102 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r102 == null) goto L13;
        r102.f("无法进入视频通话，请检查后重试");
        return;
    }

    public final int l(int r100, boolean r101) {
        if (r100 != 18) goto L16;
        if (r101 == false) goto L16;
        sk4.e r102 = kj4.a.g().requestProtocolInfo();
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L14;
        return o(30, r100);
    L14:
        return o(30, 1);
    L9:
        if (r102.b("ota3p5") != true) goto L11;
        r103 = true;
    L16:
        return o(30, r100);
    }

    public final int o(int r110, int r111) {
        FLogger r100 = FLogger.f375446a;
        r100.i("DoraOTA", "startVUI request: timeout=" + r110 + ", wakeMode=" + r111 + '(' + a.a(r111) + ')');
        String r101 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        b0.f338123a.getClass();
        boolean r102 = b0.p(r101);
        boolean r103 = b0.u(r101);
        if (r102 == false) goto L9;
        if (r103 == false) goto L9;
        boolean r104 = true;
    L10:
        DoraWifiLinkWrapper.f332292a.getClass();
        DoraWifiLinkWrapper.a r105 = DoraWifiLinkWrapper.n();
        boolean r112 = r105.a();
        boolean r113 = DoraWifiLinkWrapper.k();
        if (r111 != 32) goto L22;
        IDoraService r114 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r114 == null) goto L19;
        AbilityService r115 = r114.o0();
        if (r115 == null) goto L19;
        if (r115.j() != true) goto L19;
        boolean r116 = true;
    L20:
        if (r116 == false) goto L22;
        boolean r117 = true;
    L23:
        if (r117 == false) goto L25;
    L28:
        boolean r118 = true;
    L29:
        com.larus.dora.impl.core.settingsconfig.c.f332267a.getClass();
        DoraXLinkTransportMode r119 = com.larus.dora.impl.core.settingsconfig.c.e(r102, r103, r112, r118);
        String r106 = com.larus.dora.impl.core.settingsconfig.c.a();
        if (r111 == 32) goto L32;
    L35:
        boolean r120 = false;
    L36:
        r100.i("DoraOTA", "P2P RTC decision: wakeMode=" + r111 + '(' + a.a(r111) + "), bluetooth=" + r102 + ", p2p=" + r103 + ", effective=" + r104 + ", hasPermissions=" + r105.f332301a + ", hasAbility=" + r105.f332302b + ", runtimeSupported=" + r112 + ", systemWifiEnabled=" + r113 + ", videoCallWifiEffective=" + r118 + ", reusePrepared=" + r117 + ", linkMode=" + r119 + ", useP2PRTC=" + r120 + ", xLinkConfig=[" + r106 + ']');
        b r107 = new b(r120, r113);
        int r108 = u.f338017a;
        if (DoraWifiLinkWrapper.g() == true) goto L39;
    L41:
        boolean r109 = false;
    L42:
        if (r109 == true) goto L44;
    L46:
        boolean r121 = false;
    L47:
        if (r120 == false) goto L50;
        if (r121 == true) goto L50;
        boolean r122 = true;
    L51:
        if (r120 == false) goto L63;
        if (r122 == true) goto L63;
        IDoraService r123 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r123 == null) goto L60;
        AbilityService r124 = r123.o0();
        if (r124 == null) goto L60;
        if (r124.j() != true) goto L60;
        boolean r125 = true;
    L61:
        if (r125 == false) goto L63;
        boolean r126 = true;
    L65:
        if (r122 == false) goto L91;
        if (k(r107) == true) goto L78;
        IDoraService r127 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r127 == null) goto L75;
        AbilityService r128 = r127.o0();
        if (r128 == null) goto L75;
        if (r128.b() != true) goto L75;
        boolean r129 = true;
    L76:
        if (r129 == false) goto L78;
        boolean r130 = true;
    L79:
        if (r130 == true) goto L91;
        r100.e("DoraOTA", "startVUI legacy P2P prepare failed");
        IDoraService r131 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r131 == null) goto L85;
        AbilityService r132 = r131.o0();
        if (r132 == null) goto L85;
        r132.a();
    L85:
        IDoraService r133 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r133 == null) goto L88;
        r133.h1(198, true);
    L88:
        h(r107, "prepare_failed");
        return -1;
    L75:
        r129 = false;
    L78:
        r130 = false;
    L91:
        if (r126 == false) goto L93;
        DoraByteCastManagerDelegate.f331705b.b(true);
    L93:
        int r134 = kj4.a.g().startVUI(3, 30, r111);
        if (r120 == false) goto L123;
        if (r122 == true) goto L123;
        boolean r135 = k(r107);
        if (r135 == false) goto L99;
        r100.i("DoraOTA", "startVUI mock prepare failed");
    L99:
        if (r135 == true) goto L110;
        IDoraService r136 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r136 == null) goto L107;
        AbilityService r137 = r136.o0();
        if (r137 == null) goto L107;
        if (r137.b() != true) goto L107;
        boolean r138 = true;
    L108:
        if (r138 == false) goto L110;
        boolean r139 = true;
    L111:
        if (r139 == true) goto L122;
        r100.e("DoraOTA", "startVUI failed: prepare P2P RTC failed");
        IDoraService r140 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r140 == null) goto L117;
        AbilityService r141 = r140.o0();
        if (r141 == null) goto L117;
        r141.a();
    L117:
        IDoraService r142 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r142 == null) goto L120;
        r142.h1(198, true);
    L120:
        h(r107, "prepare_failed");
        return -1;
    L122:
        r100.i("DoraOTA", "startVUI use P2P RTC with wakeMode=" + r111);
    L107:
        r138 = false;
    L110:
        r139 = false;
    L123:
        if (r120 == true) goto L125;
    L127:
        if (r120 == false) goto L138;
        if (r134 == 0) goto L138;
        r100.e("DoraOTA", "startVUI failed: ret=" + r134 + ", rollback P2P RTC config and release");
        jk4.d r143 = jk4.d.b.f499499a;
        r143.getClass();
        r143.q(new jk4.d.c((byte) 0, 0));
        IDoraService r144 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r144 == null) goto L134;
        AbilityService r145 = r144.o0();
        if (r145 == null) goto L134;
        r145.a();
    L134:
        IDoraService r146 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r146 == null) goto L137;
        r146.h1(198, true);
    L137:
        h(r107, "start_vui_failed_" + r134);
    L138:
        return r134;
    L125:
        if (r134 != (-3)) goto L127;
        r100.w("DoraOTA", "startVUI timeout for P2P RTC, keep prepared link");
    L60:
        r125 = false;
    L63:
        r126 = false;
    L50:
        r122 = false;
        goto L51
    L44:
        if (DoraWifiLinkWrapper.f() == false) goto L46;
        r121 = true;
        goto L47
    L39:
        if (o0.d("p2p_rtc") == false) goto L41;
        r109 = true;
        goto L42
    L32:
        if (r119 != DoraXLinkTransportMode.WIFI) goto L35;
        if (r112 == false) goto L35;
        r120 = true;
        goto L36
    L25:
        if (DoraWifiLinkWrapper.l() == true) goto L28;
        r118 = false;
    L19:
        r116 = false;
    L22:
        r117 = false;
    L9:
        r104 = false;
        goto L10
    }

    public final Deferred<Integer> r(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$syncVUIErrorAsync$1(this, r100, r101, null), 3, null);
    }

    public final int t(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "RESET") == false) goto L6;
        g49.d.d("DoraTimerPlugin", "syncVUIEvent: " + r100 + ", content=content");
    L6:
        switch(r100.hashCode()) {
            case -1982756138: goto L30;
            case -1949140315: goto L27;
            case -1722007898: goto L24;
            case -336206429: goto L21;
            case -274702257: goto L18;
            case 13044316: goto L15;
            case 77866287: goto L12;
            case 1097398238: goto L9;
            default: goto L35;
        };
    L9:
        if (r100.equals("SPEECH_END") == false) goto L35;
        sk4.g r102 = sk4.g.f542413l;
    L33:
        return kj4.a.g().syncVUIEvent(r102);
    L12:
        if (r100.equals("RESET") == false) goto L35;
        r102 = sk4.g.f542410i;
        goto L33
    L15:
        if (r100.equals("ASR_END") == false) goto L35;
        r102 = sk4.g.a(r101);
        goto L33
    L18:
        if (r100.equals("TTS_END") == false) goto L35;
        r102 = sk4.g.b(r101);
        goto L33
    L21:
        if (r100.equals("ASR_START") == false) goto L35;
        r102 = sk4.g.f542408g;
        goto L33
    L24:
        if (r100.equals("DATA_END") == false) goto L35;
        r102 = sk4.g.f542407f;
        goto L33
    L27:
        if (r100.equals("SPEECH_START") == false) goto L35;
        r102 = sk4.g.f542412k;
        goto L33
    L30:
        if (r100.equals("TTS_START") == false) goto L35;
        r102 = sk4.g.f542406e;
    L35:
        throw new IllegalAccessException("args invalid");
    }

    public final Deferred<Integer> v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$syncVUIEventAsync$1(this, r100, r101, null), 3, null);
    }

    @Override // com.larus.dora.api.IDoraService.h
    public final int b(int r100, int r101, boolean r102) {
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        if (((Boolean) l0.a(Boolean.TRUE, new rf())).booleanValue() == false) goto L12;
        if (r102 == false) goto L10;
        FLogger.f375446a.i("DoraOTA", "hit setting and skipWakeUp, just stop session not notify device in " + r100 + ", code is " + r101);
        IDoraService r105 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r105 == null) goto L17;
        r105.I0(r100);
        return -1;
    L17:
        return -1;
    L10:
        FLogger.f375446a.i("DoraOTA", "hit setting updateVUIState>>>> state is " + r100 + ", code is " + r101);
        return kj4.a.g().updateVUIState(r100, r101);
    L12:
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L15;
        r106.I0(r100);
    L15:
        FLogger.f375446a.i("DoraOTA", "updateVUIState>>>> state is " + r100 + ", code is " + r101);
        return kj4.a.g().updateVUIState(r100, r101);
    }

    public final Deferred<Integer> s(int r110, Map<String, ? extends Object> r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "maps");
        Intrinsics.checkNotNullParameter(r112, "source");
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$syncVUIErrorAsync$2(this, r110, r111, r112, null), 3, null);
    }

    public final void u(final String r100, final byte[] r101, final Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        f337982h.getValue().post(new v(r100, r101, r102));
    }

    public final Deferred<Integer> y(int r110, int r111, boolean r112) {
        IDoraService.B1.getClass();
        return BuildersKt.async$default(IDoraService.b.f331727b, null, null, new SessionService$updateVUIStateAsync$1(this, r110, r111, r112, null), 3, null);
    }
}
