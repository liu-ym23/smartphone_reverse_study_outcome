package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraPreCheckResult;
import com.larus.dora.api.model.FlowDoraWifiConnectResult;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.dora.impl.assistant.AssistantWifiService;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnetuploader.uploader.request_protocol.UploaderRequestLan;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public final class WifiService implements IDoraService.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<DoraWifiScene> f337995a = null;

    public static final class a {
    }

    static {
        f337995a = SetsKt.setOf(new DoraWifiScene[]{DoraWifiScene.ALBUM, DoraWifiScene.ALBUM_SILENT});
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final Map<String, String> f() {
        ak4.a r100 = vk4.f.f555491c;
        vk4.f r101 = vk4.f.a.f555494a;
        r101.getClass();
        HashMap r102 = new HashMap();
        String r103 = r101.f555492a.f555501g;
        if (r103 == null) goto L8;
        if (r103.isEmpty() == true) goto L8;
        r102.put(UploaderRequestLan.LAN_SN, r101.f555492a.f555501g);
    L8:
        if (AppHost.f326268a.isTestChannel() == false) goto L13;
        Iterator r104 = r102.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        String r107 = (String) r105.getValue();
        FLogger.f375446a.i("WifiService", "getHttpHeaders: key=" + r106 + ", value=" + r107);
    L13:
        return r102;
    }

    @Override // com.larus.dora.api.IDoraService.j
    @FlowDoraPreCheckResult
    public final Object g() {
        DoraWifiLinkWrapper.f332292a.getClass();
        x39.a r100 = DoraWifiLinkWrapper.o();
        if ((r100 instanceof x39.a.e) == false) goto L6;
        return "P2P_FAILED_DUE_TO_WIFI_DISABLED";
    L6:
        if ((r100 instanceof x39.a.b) == false) goto L9;
        return "P2P_FAILED_DUE_TO_HOTSPOT_ENABLED";
    L9:
        if ((r100 instanceof x39.a.C8191a) == false) goto L12;
        return "P2P_FAILED_DUE_TO_GPS_CLOSED";
    L12:
        if ((r100 instanceof x39.a.d) == false) goto L14;
        return "P2P_FAILED_DUE_TO_VPN_ENABLED";
    L14:
        return "SUCCESS";
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final String getHost() {
        String r100 = vk4.e.d.f555490a.c();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final boolean h() {
        DoraWifiLinkWrapper.f332292a.getClass();
        return vk4.e.d.f555490a.e();
    }

    public WifiService() {
        kj4.a.g().registerDoraLinkCallback(new a0(this));
    }

    public static Boolean j(DoraWifiScene r100) {
        AssistantWifiService r101 = (AssistantWifiService) ServiceManager.get().getService(AssistantWifiService.class);
        if (r101 == null) goto L13;
        com.larus.dora.impl.assistant.c r102 = r101.b();
        if (r102 == null) goto L13;
        if (r102.f332039a == true) goto L12;
        FLogger.f375446a.w("WifiService", "queryAssistantWifiEnabledForScene failed, scene=" + r100 + ", errorCode=" + r102.f332041c);
        return null;
    L12:
        return Boolean.valueOf(r102.f332040b);
    L13:
        return null;
    }

    public static void k(DoraWifiScene r100) {
        if (com.larus.dora.impl.util.s.a() == true) goto L5;
        return;
    L5:
        if (f337995a.contains(r100) == false) goto L19;
        String r101 = "WifiService:" + r100;
        AssistantWifiService r102 = (AssistantWifiService) ServiceManager.get().getService(AssistantWifiService.class);
        if (r102 == null) goto L17;
        com.larus.dora.impl.assistant.b r103 = r102.c(r101);
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.f332036a == true) goto L18;
        FLogger.f375446a.w("WifiService", "releaseAssistantWifiForScene failed, scene=" + r100 + ", owner=" + r101 + ", errorCode=" + r103.f332037b);
        return;
    L18:
        return;
    L17:
        return;
    }

    public static boolean l(DoraWifiScene r100) {
        String r101 = "WifiService:" + r100;
        AssistantWifiService r102 = (AssistantWifiService) ServiceManager.get().getService(AssistantWifiService.class);
        if (r102 == null) goto L12;
        com.larus.dora.impl.assistant.b r103 = r102.a(r101);
        if (r103 != null) goto L8;
        return false;
    L8:
        if (r103.f332036a == true) goto L11;
        FLogger.f375446a.w("WifiService", "requestAssistantWifiForScene failed, scene=" + r100 + ", owner=" + r101 + ", errorCode=" + r103.f332037b);
    L11:
        return r103.f332036a;
    L12:
        return false;
    }

    public static DoraWifiScene m(String r100) {
        switch(r100.hashCode()) {
            case -1885362529: goto L30;
            case -811788219: goto L26;
            case -215860903: goto L22;
            case 78588: goto L18;
            case 85354: goto L14;
            case 2571410: goto L10;
            case 62359119: goto L6;
            default: goto L34;
        };
    L6:
        if (r100.equals(FlowDoraWifiScene.ALBUM) == false) goto L34;
        return DoraWifiScene.ALBUM;
    L10:
        if (r100.equals(FlowDoraWifiScene.TEST) == false) goto L34;
        return DoraWifiScene.TEST;
    L14:
        if (r100.equals(FlowDoraWifiScene.VUI) == false) goto L34;
        return DoraWifiScene.VUI;
    L18:
        if (r100.equals(FlowDoraWifiScene.OTA) == false) goto L34;
        return DoraWifiScene.OTA;
    L22:
        if (r100.equals(FlowDoraWifiScene.LOG_FROM_DEBUG) == false) goto L34;
        return DoraWifiScene.LOG_FROM_DEBUG;
    L26:
        if (r100.equals(FlowDoraWifiScene.ALBUM_SILENT) == false) goto L34;
        return DoraWifiScene.ALBUM_SILENT;
    L30:
        if (r100.equals(FlowDoraWifiScene.LOG_FROM_FEEDBACK) == false) goto L34;
        return DoraWifiScene.LOG_FROM_FEEDBACK;
    L34:
        return DoraWifiScene.OTHER;
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final void c(h49.i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<h49.i> r101 = t69.s.f544697a;
        if (r100 == null) goto L7;
        t69.s.f544697a.remove(r100);
        return;
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return vk4.e.d.f555490a.d(m(r100));
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final Unit disconnect(@FlowDoraWifiScene String r100) {
        DoraWifiScene r101 = m(r100);
        DoraWifiLinkWrapper.f332292a.getClass();
        Intrinsics.checkNotNullParameter(r101, "scene");
        DoraWifiLinkWrapper.d(r101, null);
        k(r101);
        return Unit.INSTANCE;
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final void e(h49.i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<h49.i> r101 = t69.s.f544697a;
        if (r100 == null) goto L10;
        CopyOnWriteArraySet<h49.i> r102 = t69.s.f544697a;
        if (r102.contains(r100) == true) goto L9;
        r102.add(r100);
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.api.IDoraService.j
    @FlowDoraWifiConnectResult
    public final Object a(@FlowDoraWifiScene String r100, Continuation<? super String> r101) {
        if ((r101 instanceof WifiService$connect$1) == false) goto L7;
        WifiService$connect$1 r102 = (WifiService$connect$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L49:
        x39.b r107 = (x39.b) r104;
        if ((r107 instanceof x39.b.f) == false) goto L53;
        return "SUCCESS";
    L53:
        if ((r107 instanceof x39.b.a) == false) goto L56;
        return "FAILED";
    L56:
        if ((r107 instanceof x39.b.h) == false) goto L59;
        return "P2P_FAILED_DUE_TO_WIFI_DISABLED";
    L59:
        if ((r107 instanceof x39.b.c) == false) goto L62;
        return "P2P_FAILED_DUE_TO_HOTSPOT_ENABLED";
    L62:
        if ((r107 instanceof x39.b.C8192b) == false) goto L65;
        return "P2P_FAILED_DUE_TO_GPS_CLOSED";
    L65:
        if ((r107 instanceof x39.b.g) == false) goto L68;
        return "P2P_FAILED_DUE_TO_VPN_ENABLED";
    L68:
        if ((r107 instanceof x39.b.e) == false) goto L71;
        return FlowDoraWifiConnectResult.P2P_FAILED_NEARBY_PERMISSION_DENIED;
    L71:
        if ((r107 instanceof x39.b.d) == false) goto L75;
        return FlowDoraWifiConnectResult.P2P_FAILED_LOCATION_PERMISSION_DENIED;
    L75:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        switch(r100.hashCode()) {
            case -1885362529: goto L42;
            case -811788219: goto L38;
            case -215860903: goto L34;
            case 78588: goto L30;
            case 85354: goto L26;
            case 2571410: goto L22;
            case 62359119: goto L18;
            default: goto L45;
        };
    L45:
        DoraWifiScene r108 = DoraWifiScene.OTHER;
    L46:
        r102.label = 1;
        r104 = i(r108, null, r102);
        if (r104 != r105) goto L49;
        return r105;
    L18:
        if (r100.equals(FlowDoraWifiScene.ALBUM) == false) goto L45;
        r108 = DoraWifiScene.ALBUM;
        goto L46
    L22:
        if (r100.equals(FlowDoraWifiScene.TEST) == false) goto L45;
        r108 = DoraWifiScene.TEST;
        goto L46
    L26:
        if (r100.equals(FlowDoraWifiScene.VUI) == false) goto L45;
        r108 = DoraWifiScene.VUI;
        goto L46
    L30:
        if (r100.equals(FlowDoraWifiScene.OTA) == false) goto L45;
        r108 = DoraWifiScene.OTA;
        goto L46
    L34:
        if (r100.equals(FlowDoraWifiScene.LOG_FROM_DEBUG) == false) goto L45;
        r108 = DoraWifiScene.LOG_FROM_DEBUG;
        goto L46
    L38:
        if (r100.equals(FlowDoraWifiScene.ALBUM_SILENT) == false) goto L45;
        r108 = DoraWifiScene.ALBUM_SILENT;
        goto L46
    L42:
        if (r100.equals(FlowDoraWifiScene.LOG_FROM_FEEDBACK) == false) goto L45;
        r108 = DoraWifiScene.LOG_FROM_FEEDBACK;
    L7:
        r102 = new WifiService$connect$1(this, r101);
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService.j
    public final <T> Object b(Request r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Response r102 = yk4.b.a(r100);     // Catch: Exception -> L12
        if (r102.isSuccessful() == false) goto L10;
        ResponseBody r103 = r102.body();     // Catch: Exception -> L12
        if (r103 == null) goto L8;
        String r104 = r103.string();     // Catch: Exception -> L12
    L16:
        return Result.m9449constructorimpl(new Gson().fromJson(r104, r101));
    L8:
        r104 = null;
        goto L16
    L10:
        Result.Companion r105 = Result.Companion;     // Catch: Exception -> L12
        return Result.m9449constructorimpl(ResultKt.createFailure(new IOException("HTTP Error: " + r102.code())));
    L12:
        e = move-exception;
        Result.Companion r106 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0086 -> B:24:0x0087). Please report as a decompilation issue!!! */
    public final Object n(DoraWifiScene r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof WifiService$waitAssistantWifiEnabledForScene$1) == false) goto L7;
        WifiService$waitAssistantWifiEnabledForScene$1 r100 = (WifiService$waitAssistantWifiEnabledForScene$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r113 = r100.I$2;
        int r104 = r100.I$1;
        int r105 = r100.I$0;
        DoraWifiScene r106 = (DoraWifiScene) r100.L$0;
        ResultKt.throwOnFailure(r112);
        DoraWifiScene r114 = r106;
    L25:
        if (Intrinsics.areEqual(j(r114), Boxing.boxBoolean(true)) == false) goto L28;
        FLogger.f375446a.i("WifiService", "assistant wifi enabled, scene=" + r114 + ", attempt=" + (r113 + 1));
        return Boxing.boxBoolean(true);
    L28:
        r113 = r104 + 1;
    L19:
        if (r113 >= r105) goto L29;
        r100.L$0 = r114;
        r100.I$0 = r105;
        r100.I$1 = r113;
        r100.I$2 = r113;
        r100.label = 1;
        if (DelayKt.delay(500, r100) != r102) goto L23;
        return r102;
    L23:
        r104 = r113;
        goto L25
    L29:
        FLogger.f375446a.w("WifiService", "assistant wifi not enabled after wait, scene=" + r114);
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (Intrinsics.areEqual(j(r110), Boxing.boxBoolean(true)) == false) goto L18;
        FLogger.f375446a.i("WifiService", "assistant wifi enabled, scene=" + r110 + ", attempt=0");
        return Boxing.boxBoolean(true);
    L18:
        r114 = r110;
        r113 = 0;
        r105 = 6;
    L7:
        r100 = new WifiService$waitAssistantWifiEnabledForScene$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.larus.dora.impl.serviceimpl.WifiService] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final Object i(DoraWifiScene r110, DoraWifiLinkStrategy r111, Continuation<? super x39.b> r210) {
        DoraWifiScene r100 = r110;
        if ((r210 instanceof WifiService$connectWithAssistantWifiCheck$1) == false) goto L7;
        WifiService$connectWithAssistantWifiCheck$1 r101 = (WifiService$connectWithAssistantWifiCheck$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L21;
        if (r104 == 1) goto L20;
        if (r104 == 2) goto L19;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        int r105 = r101.I$0;
        x39.b r106 = (x39.b) r101.L$1;
        DoraWifiScene r107 = (DoraWifiScene) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L60:
        x39.b r108 = (x39.b) r103;
        if ((r108 instanceof x39.b.h) == true) goto L63;
        return r108;
    L63:
        FLogger.f375446a.i("WifiService", "connect retry still WifiDisabled in obric mode, scene=" + r107);
        DoraWifiScene r109 = r107;
        x39.b r113 = r106;
        int r114 = r105;
    L65:
        if (r114 != 0) goto L67;
    L70:
        return r113;
    L67:
        if ((r113 instanceof x39.b.h) == false) goto L70;
        FLogger.f375446a.i("WifiService", "connect ignore WifiDisabled in obric mode, scene=" + r109);
        return new x39.b.a(r113.f562395a);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r105 = r101.I$0;
        x39.b r115 = (x39.b) r101.L$2;
        DoraWifiLinkStrategy r116 = (DoraWifiLinkStrategy) r101.L$1;
        DoraWifiScene r117 = (DoraWifiScene) r101.L$0;
        ResultKt.throwOnFailure(r103);
        x39.b r118 = r115;
        DoraWifiScene r119 = r117;
    L18:
        DoraWifiLinkStrategy r120 = r116;
        if (((Boolean) r103).booleanValue() == false) goto L64;
        DoraWifiLinkWrapper r121 = DoraWifiLinkWrapper.f332292a;
        r101.L$0 = r119;
        r101.L$1 = r118;
        r101.L$2 = null;
        r101.I$0 = r105;
        r101.label = 4;
        r103 = r121.b(r119, r120, true, null, null, r101);
        if (r103 != r112) goto L59;
        return r112;
    L59:
        r107 = r119;
        r106 = r118;
        goto L60
    L64:
        r114 = r105;
        r109 = r119;
        r113 = r118;
        goto L65
    L19:
        int r122 = r101.I$1;
        r114 = r101.I$0;
        r116 = (DoraWifiLinkStrategy) r101.L$1;
        r109 = (DoraWifiScene) r101.L$0;
        ResultKt.throwOnFailure(r103);
        ?? r123 = r122;
    L42:
        r113 = (x39.b) r103;
        if (r114 == 0) goto L65;
        if ((r113 instanceof x39.b.h) == false) goto L65;
        FLogger.f375446a.i("WifiService", "connect hit WifiDisabled after assistant wifi check, retry once, scene=" + r109);
        ?? r124 = r123;
        if (r123 != 0) goto L49;
        r124 = l(r109);
    L49:
        if (r124 == 0) goto L65;
        r101.L$0 = r109;
        r101.L$1 = r116;
        r101.L$2 = r113;
        r101.I$0 = r114;
        r101.label = 3;
        Object r125 = n(r109, r101);
        if (r125 != r112) goto L53;
        return r112;
    L53:
        r118 = r113;
        r119 = r109;
        r103 = r125;
        r105 = r114;
        goto L18
    L20:
        boolean r126 = r101.Z$0;
        int r127 = r101.I$0;
        DoraWifiLinkStrategy r128 = (DoraWifiLinkStrategy) r101.L$1;
        DoraWifiScene r129 = (DoraWifiScene) r101.L$0;
        ResultKt.throwOnFailure(r103);
        ?? r130 = r126;
        int r131 = r127;
        DoraWifiLinkStrategy r132 = r128;
        r100 = r129;
    L38:
        DoraWifiLinkWrapper r133 = DoraWifiLinkWrapper.f332292a;
        r101.L$0 = r100;
        r101.L$1 = r132;
        r101.I$0 = r131;
        r101.I$1 = r130;
        r101.label = 2;
        int r134 = r131;
        Object r135 = r133.b(r100, r132, true, null, null, r101);
        if (r135 != r112) goto L41;
        return r112;
    L41:
        r109 = r100;
        r116 = r132;
        r103 = r135;
        r123 = r130;
        r114 = r134;
        goto L42
    L21:
        ResultKt.throwOnFailure(r103);
        if (com.larus.dora.impl.util.s.a() == true) goto L24;
    L26:
        int r136 = 0;
    L27:
        if (r136 != 0) goto L29;
    L37:
        r131 = r136;
        r132 = r111;
        r130 = 0;
        goto L38
    L29:
        if (Intrinsics.areEqual(j(r110), Boxing.boxBoolean(true)) == true) goto L37;
        boolean r137 = l(r110);
        if (r137 == false) goto L35;
        r101.L$0 = r100;
        DoraWifiLinkStrategy r138 = r111;
        r101.L$1 = r138;
        r101.I$0 = r136;
        r101.Z$0 = r137;
        r101.label = 1;
        if (n(r100, r101) != r112) goto L36;
        return r112;
    L36:
        r131 = r136;
        r130 = r137;
        r132 = r138;
        goto L38
    L35:
        r138 = r111;
        goto L36
    L24:
        if (f337995a.contains(r100) == false) goto L26;
        r136 = 1;
    L7:
        r101 = new WifiService$connectWithAssistantWifiCheck$1(this, r210);
        goto L8
    }
}
