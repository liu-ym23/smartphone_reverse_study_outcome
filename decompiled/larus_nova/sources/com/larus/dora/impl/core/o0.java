package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.voice.ProtocolAbility;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile sk4.e f332223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Map<String, sk4.e> f332224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f332225c;

    public o0() {
    }

    static {
        f332224b = new LinkedHashMap();
    }

    public static Object f() {
        boolean r100 = c(ProtocolAbility.FEATURE_WIFI_SILENCE_OTA);
        g49.d.d("DoraProtocol", "isSupportWifiSilentOTA: " + r100);
        return Boxing.boxBoolean(r100);
    }

    public static Object g() {
        boolean r100 = c("wakeupGestureUnify");
        g49.d.d("DoraProtocol", "isWakeupGestureUnityAbility: " + r100);
        return Boxing.boxBoolean(r100);
    }

    public static sk4.e a(String r100) {
        sk4.e r101 = f332223a;
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return null;
    L14:
        sk4.e r103 = (sk4.e) ((LinkedHashMap) f332224b).get(r100);
        if (r103 != null) goto L17;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        r103 = com.larus.dora.impl.util.b0.n(r100);
    L17:
        Map<String, sk4.e> r104 = f332224b;
        if (r103 != null) goto L20;
        return null;
    L20:
        r104.put(r100, r103);
        return r103;
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L12
    }

    public static boolean b(DoraDevice r100) {
        if (ObricFeatureServiceDelegate.f387839b.b() == true) goto L5;
        return false;
    L5:
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L15;
        DeviceService r102 = r101.device();
        if (r102 == null) goto L18;
        if (r100 != null) goto L12;
        return false;
    L12:
        if (r102.c0(Integer.valueOf(r100.productId)) != true) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    L15:
        return false;
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        g49.d.d("DoraProtocol", "isSupportAbility: false featureKey=" + r100);
        return false;
    L13:
        sk4.e r102 = f332223a;
        if (r102 == null) goto L17;
        g49.d.d("DoraProtocol", "isSupportAbility: featureKey=" + r100 + ", cachedProtocolInfo=" + r102);
        return r102.b(r100);
    L17:
        DoraDevice r103 = kj4.a.g().c();
        if (r103 == null) goto L20;
        String r104 = r103.f204390sn;
    L21:
        sk4.e r105 = kj4.a.g().requestProtocolInfo();
        g49.d.d("DoraProtocol", "isSupportAbility: [NEW] featureKey=" + r100 + ", protocolInfo=" + r105);
        if (r105 == null) goto L28;
        Job r106 = f332225c;
        if (r106 == null) goto L26;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L26:
        f332223a = r105;
        h(r104, r105);
        return r105.b(r100);
    L28:
        return false;
    L20:
        r104 = null;
        goto L21
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "featureKey");
        g49.d.d("DoraProtocol", "isSupportAbilityByCache: featureKey=" + r100 + ", cachedProtocolInfo=" + f332223a);
        sk4.e r101 = f332223a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.b(r100) != true) goto L7;
        return true;
    }

    public static boolean e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "featureKey");
        if (f332223a != null) goto L20;
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return false;
    L13:
        if (((LinkedHashMap) f332224b).get(r100) == null) goto L15;
        sk4.e r103 = (sk4.e) ((LinkedHashMap) f332224b).get(r100);
    L16:
        if (r103 != null) goto L18;
        return false;
    L18:
        f332224b.put(r100, r103);
        return r103.b(r101);
    L15:
        com.larus.dora.impl.util.b0.f338123a.getClass();
        r103 = com.larus.dora.impl.util.b0.n(r100);
        goto L16
    L6:
        if (r100.length() == 0) goto L9;
        r102 = false;
        goto L10
    L20:
        sk4.e r104 = f332223a;
        if (r104 != null) goto L23;
        return false;
    L23:
        return r104.b(r101);
    }

    public static void h(String r100, sk4.e r101) {
        if (com.larus.utils.o0.d(r100) == false) goto L13;
        if (r100 == null) goto L14;
        f332224b.put(r100, r101);
        com.larus.dora.impl.util.b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r100, "sn");
        Intrinsics.checkNotNullParameter(r101, "info");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        com.larus.dora.impl.util.b0.j().storeString("dora_device_protocol_info".concat(r100), com.larus.dora.impl.util.b0.h().toJson(r101));     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L14:
        return;
    }
}
