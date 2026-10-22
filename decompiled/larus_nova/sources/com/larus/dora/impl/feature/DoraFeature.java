package com.larus.dora.impl.feature;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.settingsconfig.c;
import com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.util.b0;
import com.larus.network.http.y;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d59.f;
import d59.i;
import g49.d;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraFeature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraFeature f335550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f335551b = null;

    public DoraFeature() {
    }

    static {
        f335550a = new DoraFeature();
        f335551b = LazyKt.lazy(new a());
    }

    public final Object a(Continuation<? super Unit> r310) {
        if ((r310 instanceof DoraFeature$handlerFeature$1) == false) goto L7;
        DoraFeature$handlerFeature$1 r100 = (DoraFeature$handlerFeature$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r111 = r100.label;
        if (r111 == 0) goto L18;
        if (r111 == 1) goto L17;
        if (r111 != 2) goto L16;
        int r112 = r100.I$1;
        int r113 = r100.I$0;
        boolean r114 = r100.Z$2;
        boolean r115 = r100.Z$1;
        boolean r103 = r100.Z$0;
        String r104 = (String) r100.L$2;
        DoraXLinkTransportMode r105 = (DoraXLinkTransportMode) r100.L$1;
        DoraWifiLinkWrapper.a r106 = (DoraWifiLinkWrapper.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L175
        String r210 = ", xLinkConfig=[";
        String r211 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        String r212 = "doInit: syncP2PRTCEnabled: effective=";
        String r116 = "doInit: syncEffectiveP2PRTCEnabled failed, keep local P2P config, oldP2PRTC=";
        DoraXLinkTransportMode r107 = r105;
        boolean r108 = r103;
        String r117 = "doInit: sync disable effective P2P RTC failed, keep local P2P config, oldP2PRTC=";
        String r109 = r104;
    L67:
        if (((Boolean) r102).booleanValue() != true) goto L69;
        boolean r118 = true;
    L70:
        boolean r119 = r118;
        boolean r120 = r108;
        int r121 = r112;
        DoraWifiLinkWrapper.a r122 = r106;
    L72:
        if (r119 == false) goto L75;
        d.d("DoraFeature", "doInit: initByteCastManagerAfterAbilityNegotiation");     // Catch: Throwable -> L175
        DoraByteCastManagerDelegate.f331705b.d();     // Catch: Throwable -> L175
    L75:
        kj4.a r123 = kj4.a.g();     // Catch: Throwable -> L175
        if (r113 == 0) goto L78;
        boolean r124 = true;
    L79:
        ak4.a r125 = r123.f503708c.f514229d;     // Catch: Throwable -> L175
        byte[] r126 = new byte[3];     // Catch: Throwable -> L175
        r126[0] = 35;     // Catch: Throwable -> L175
        r126[1] = 1;     // Catch: Throwable -> L175
        if (r124 == false) goto L82;
        int r127 = 2;
    L83:
        r126[2] = (byte) r127;     // Catch: Throwable -> L175
        int r128 = r125.j(1, 4, r126, AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);     // Catch: Throwable -> L175
        StringBuilder r129 = new StringBuilder("doInit: syncBluetoothRTCEnabled: effective=");     // Catch: Throwable -> L175
        if (r113 == 0) goto L86;
        boolean r130 = true;
    L87:
        r129.append(r130);     // Catch: Throwable -> L175
        r129.append(", userBluetooth=");     // Catch: Throwable -> L175
        if (r120 == false) goto L90;
        boolean r131 = true;
    L91:
        r129.append(r131);     // Catch: Throwable -> L175
        r129.append(", linkMode=");     // Catch: Throwable -> L175
        r129.append(r107);     // Catch: Throwable -> L175
        r129.append(", ret=");     // Catch: Throwable -> L175
        r129.append(r128);     // Catch: Throwable -> L175
        String r132 = r210;
        r129.append(r132);     // Catch: Throwable -> L175
        r129.append(r109);     // Catch: Throwable -> L175
        r129.append(']');     // Catch: Throwable -> L175
        d.d("DoraFeature", r129.toString());     // Catch: Throwable -> L175
        if (r128 != (-3)) goto L96;
        d.b("DoraFeature", "doInit: syncBluetoothRTCEnabled timeout, state unknown, continue syncing P2P RTC switch");     // Catch: Throwable -> L175
    L116:
        CoroutineScope r133 = DoraP2pRtcSwitchSync.f332286a;     // Catch: Throwable -> L175
        if (r121 == 0) goto L119;
        boolean r134 = true;
    L120:
        int r135 = DoraP2pRtcSwitchSync.g(r134, Boxing.boxLong(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME));     // Catch: Throwable -> L175
        StringBuilder r136 = new StringBuilder(r212);     // Catch: Throwable -> L175
        if (r121 == 0) goto L123;
        boolean r137 = true;
    L124:
        r136.append(r137);     // Catch: Throwable -> L175
        r136.append(", userP2P=");     // Catch: Throwable -> L175
        if (r115 == false) goto L127;
        boolean r138 = true;
    L128:
        r136.append(r138);     // Catch: Throwable -> L175
        r136.append(", hasPermissions=");     // Catch: Throwable -> L175
        r136.append(r122.f332301a);     // Catch: Throwable -> L175
        r136.append(", hasAbility=");     // Catch: Throwable -> L175
        r136.append(r122.f332302b);     // Catch: Throwable -> L175
        r136.append(", runtimeSupported=");     // Catch: Throwable -> L175
        if (r114 == false) goto L131;
        boolean r139 = true;
    L132:
        r136.append(r139);     // Catch: Throwable -> L175
        r136.append(", linkMode=");     // Catch: Throwable -> L175
        r136.append(r107);     // Catch: Throwable -> L175
        r136.append(", ret=");     // Catch: Throwable -> L175
        r136.append(r135);     // Catch: Throwable -> L175
        r136.append(r132);     // Catch: Throwable -> L175
        r136.append(r109);     // Catch: Throwable -> L175
        r136.append(']');     // Catch: Throwable -> L175
        d.d("DoraFeature", r136.toString());     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.d();     // Catch: Throwable -> L175
        if (r135 != 0) goto L135;
    L173:
        DoraP2pRtcSwitchSync.b();
        return Unit.INSTANCE;
    L135:
        if (r135 != (-3)) goto L139;
        d.b("DoraFeature", "doInit: syncP2PRTCEnabled timeout, state unknown, skip rollback");     // Catch: Throwable -> L175
        Unit r140 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r140;
    L139:
        if (r121 != 0) goto L157;
        StringBuilder r141 = new StringBuilder(r117);     // Catch: Throwable -> L175
        if (r115 == false) goto L143;
        boolean r142 = true;
    L144:
        r141.append(r142);     // Catch: Throwable -> L175
        r141.append(", ret=");     // Catch: Throwable -> L175
        r141.append(r135);     // Catch: Throwable -> L175
        d.b("DoraFeature", r141.toString());     // Catch: Throwable -> L175
        IDoraService r143 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r143 == null) goto L149;
        AbilityService r144 = r143.o0();     // Catch: Throwable -> L175
        if (r144 == null) goto L149;
        r144.a();     // Catch: Throwable -> L175
    L149:
        IDoraService r145 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r145 == null) goto L154;
        AbilityService r146 = r145.o0();     // Catch: Throwable -> L175
        if (r146 == null) goto L154;
        r146.m();     // Catch: Throwable -> L175
        Boxing.boxBoolean(true);     // Catch: Throwable -> L175
    L154:
        Unit r147 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r147;
    L143:
        r142 = false;
        goto L144
    L157:
        boolean r148 = false;
        int r149 = DoraP2pRtcSwitchSync.g(false, null);     // Catch: Throwable -> L175
        IDoraService r150 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r150 == null) goto L163;
        AbilityService r151 = r150.o0();     // Catch: Throwable -> L175
        if (r151 == null) goto L163;
        r151.a();     // Catch: Throwable -> L175
    L163:
        StringBuilder r152 = new StringBuilder(r116);     // Catch: Throwable -> L175
        if (r115 == false) goto L166;
        r148 = true;
    L166:
        r152.append(r148);     // Catch: Throwable -> L175
        r152.append(", ret=");     // Catch: Throwable -> L175
        r152.append(r135);     // Catch: Throwable -> L175
        r152.append(", rollbackRet=");     // Catch: Throwable -> L175
        r152.append(r149);     // Catch: Throwable -> L175
        d.b("DoraFeature", r152.toString());     // Catch: Throwable -> L175
        if (r115 == false) goto L173;
        IDoraService r153 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r153 == null) goto L173;
        AbilityService r154 = r153.o0();     // Catch: Throwable -> L175
        if (r154 == null) goto L173;
        r154.m();     // Catch: Throwable -> L175
        Boxing.boxBoolean(true);     // Catch: Throwable -> L175
        goto L173
    L131:
        r139 = false;
        goto L132
    L127:
        r138 = false;
        goto L128
    L123:
        r137 = false;
        goto L124
    L119:
        r134 = false;
        goto L120
    L96:
        if (r128 == 0) goto L111;
        if (r113 == 0) goto L111;
        int r155 = DoraP2pRtcSwitchSync.g(false, null);     // Catch: Throwable -> L175
        IDoraService r156 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r156 == null) goto L104;
        AbilityService r157 = r156.o0();     // Catch: Throwable -> L175
        if (r157 == null) goto L104;
        r157.a();     // Catch: Throwable -> L175
    L104:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "d_bluetooth_rtc_switch_status", MapsKt.mapOf(TuplesKt.to(EventConstants.ExtraJson.SWITCH_STATUS, Boxing.boxInt(1))), false, 12);     // Catch: Throwable -> L175
        StringBuilder r158 = new StringBuilder(r211);     // Catch: Throwable -> L175
        if (r115 == false) goto L107;
        boolean r159 = true;
    L108:
        r158.append(r159);     // Catch: Throwable -> L175
        r158.append(", rollbackP2PRTCRet=");     // Catch: Throwable -> L175
        r158.append(r155);     // Catch: Throwable -> L175
        d.b("DoraFeature", r158.toString());     // Catch: Throwable -> L175
        Unit r160 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r160;
    L107:
        r159 = false;
    L111:
        DoraBuryPointManager r161 = DoraBuryPointManager.f331862a;     // Catch: Throwable -> L175
        if (r113 == 0) goto L114;
        int r162 = 2;
    L115:
        DoraBuryPointManager.J(r161, "d_bluetooth_rtc_switch_status", MapsKt.mapOf(TuplesKt.to(EventConstants.ExtraJson.SWITCH_STATUS, Boxing.boxInt(r162))), false, 12);     // Catch: Throwable -> L175
        goto L116
    L114:
        r162 = 1;
        goto L115
    L90:
        r131 = false;
        goto L91
    L86:
        r130 = false;
        goto L87
    L82:
        r127 = 1;
        goto L83
    L78:
        r124 = false;
        goto L79
    L69:
        r118 = false;
        goto L70
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r163 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L45:
        b0.f338123a.getClass();     // Catch: Throwable -> L175
        r120 = b0.p(r163);     // Catch: Throwable -> L175
        r115 = b0.u(r163);     // Catch: Throwable -> L175
        DoraWifiLinkWrapper.f332292a.getClass();     // Catch: Throwable -> L175
        r122 = DoraWifiLinkWrapper.n();     // Catch: Throwable -> L175
        r114 = r122.a();     // Catch: Throwable -> L175
        c r164 = c.f332267a;     // Catch: Throwable -> L175
        r116 = "doInit: syncEffectiveP2PRTCEnabled failed, keep local P2P config, oldP2PRTC=";
        if (r114 == false) goto L48;
        boolean r165 = true;
    L49:
        r117 = "doInit: sync disable effective P2P RTC failed, keep local P2P config, oldP2PRTC=";
        boolean r166 = DoraWifiLinkWrapper.j();     // Catch: Throwable -> L175
        r164.getClass();     // Catch: Throwable -> L175
        r107 = c.e(r120, r115, r165, r166);     // Catch: Throwable -> L175
        r109 = c.a();     // Catch: Throwable -> L175
        r212 = "doInit: syncP2PRTCEnabled: effective=";
        if (r107 == DoraXLinkTransportMode.OFF) goto L52;
        r113 = 1;
    L54:
        if (r107 != DoraXLinkTransportMode.WIFI) goto L56;
        r121 = 1;
    L57:
        if (r113 == 0) goto L74;
        r211 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        r210 = ", xLinkConfig=[";
        IDoraService r167 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r167 == null) goto L71;
        AbilityService r168 = r167.o0();     // Catch: Throwable -> L175
        if (r168 == null) goto L71;
        r100.L$0 = r122;     // Catch: Throwable -> L175
        r100.L$1 = r107;     // Catch: Throwable -> L175
        r100.L$2 = r109;     // Catch: Throwable -> L175
        r100.Z$0 = r120;     // Catch: Throwable -> L175
        r100.Z$1 = r115;     // Catch: Throwable -> L175
        r100.Z$2 = r114;     // Catch: Throwable -> L175
        r100.I$0 = r113;     // Catch: Throwable -> L175
        r100.I$1 = r121;     // Catch: Throwable -> L175
        r100.label = 2;     // Catch: Throwable -> L175
        r102 = r168.i("rtc");     // Catch: Throwable -> L175
        if (r102 != r110) goto L65;
        return r110;
    L65:
        r112 = r121;
        r106 = r122;
        r108 = r120;
    L71:
        r120 = r120;
        r119 = false;
        goto L72
    L74:
        r210 = ", xLinkConfig=[";
        r211 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        goto L75
    L56:
        r121 = 0;
        goto L57
    L52:
        r113 = 0;
        goto L54
    L48:
        r165 = false;
        goto L49
    L18:
        ResultKt.throwOnFailure(r102);
        String r169 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (r169 != null) goto L21;
        r169 = "";
    L21:
        r163 = r169;
        f r170 = ((g59.c) f335551b.getValue()).a();
        if (r170 == null) goto L26;
        Map<String, i> r171 = r170.a();
        if (r171 == null) goto L26;
        Set<String> r172 = r171.keySet();
    L27:
        if (r172 != null) goto L29;
        r172 = SetsKt.emptySet();
    L29:
        b0.f338123a.getClass();
        if (b0.w() == true) goto L32;
    L34:
        boolean r173 = b0.w();
        d.d("DoraFeature", "doInit: syncQuickContinuousConversationSwitch: " + r173 + ", ret=" + kj4.a.g().v(r173));
        DoraDevice r174 = kj4.a.g().f503708c.a(false);
        if (r174 != null) goto L37;
    L178:
        d.d("DoraFeature", "doInit: skip RTC sync for non-G device");
        return Unit.INSTANCE;
    L37:
        if (ProductNameType.isDoraGSeriesType(r174.type) == false) goto L178;
        CoroutineScope r175 = DoraP2pRtcSwitchSync.f332286a;
        r100.L$0 = r163;
        r100.label = 1;
        Object r176 = DoraP2pRtcSwitchSync.f332288c.a(null, r100);
        if (r176 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r176 = Unit.INSTANCE;
    L43:
        if (r176 != r110) goto L45;
        return r110;
    L32:
        if (r172.contains("fuzzy_wakeup") == true) goto L34;
        b0.M(false);
    L26:
        r172 = null;
    L175:
        th = move-exception;
        DoraP2pRtcSwitchSync.b();
        throw th;
    L7:
        r100 = new DoraFeature$handlerFeature$1(this, r310);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraFeature$requestFeature$1) == false) goto L7;
        DoraFeature$requestFeature$1 r100 = (DoraFeature$requestFeature$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L17;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L15;
        Throwable r105 = (Throwable) r100.L$0;
        ResultKt.throwOnFailure(r111);
        throw r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r106 = r100.I$0;
        ResultKt.throwOnFailure(r111);
    L42:
        if (r106 != 0) goto L46;
        r104 = false;
    L46:
        return Boxing.boxBoolean(r104);
    L18:
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L27
    L24:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;     // Catch: Throwable -> L27
        if ((r112 instanceof y) == false) goto L30;
        f r113 = (f) ((y) r112).f360135b;     // Catch: Throwable -> L27
        d.d("DoraFeature", "loadLabSettingConfig success, config: " + r113);     // Catch: Throwable -> L27
        ((g59.c) f335551b.getValue()).b(r113);     // Catch: Throwable -> L27
        int r114 = 1;
    L33:
        r100.I$0 = r114;
        r100.label = 2;
        if (a(r100) != r102) goto L36;
        return r102;
    L36:
        r106 = r114;
        goto L42
    L30:
        if ((r112 instanceof com.larus.network.http.f) == false) goto L32;
        d.c("DoraFeature", "loadLabSettingConfig failed", ((com.larus.network.http.f) r112).f360157d);     // Catch: Throwable -> L27
    L32:
        r114 = 0;
        goto L33
    L20:
        ResultKt.throwOnFailure(r111);
        d.d("DoraFeature", "start request feature");     // Catch: Throwable -> L27
        com.larus.dora.api.network.a r115 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L27
        Map r116 = MapsKt.emptyMap();     // Catch: Throwable -> L27
        r100.label = 1;     // Catch: Throwable -> L27
        r111 = com.larus.dora.api.network.a.b(r115, f.class, "/alice/w/starweave/feature-visibility/matched", r116, r100);     // Catch: Throwable -> L27
        if (r111 != r102) goto L24;
        return r102;
    L27:
        th = move-exception;
        d.c("DoraFeature", "request feature err:", th);     // Catch: Throwable -> L47
        r100.I$0 = 0;
        r100.label = 3;
        if (a(r100) != r102) goto L41;
        return r102;
    L41:
        r106 = 0;
    L47:
        th = move-exception;
        r100.L$0 = th;
        r100.label = 4;
        if (a(r100) != r102) goto L55;
        return r102;
    L55:
        throw th;
    L7:
        r100 = new DoraFeature$requestFeature$1(this, r110);
        goto L8
    }
}
