package com.larus.im.internal.audio;

import android.os.SystemClock;
import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.r0;
import com.larus.im.internal.jni.bean.OMNIAVRTCTokenRequest;
import com.larus.im.internal.jni.ktx.OmniTokenServiceKtxKt;
import com.larus.im.internal.jni.service.OmniTokenServiceKt;
import com.larus.im.internal.rtcsdk.impl.j0;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.bytertc.engine.RTCEngine;
import gd9.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements qf9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f347169a = null;

    static {
        f347169a = new a();
    }

    public a() {
    }

    @Override // qf9.d
    public final int a(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return -1;
    }

    @Override // qf9.d
    public final void b(List<String> r210) {
        Intrinsics.checkNotNullParameter(r210, "rtcAppIds");
        boolean r100 = false;
        boolean r101 = sf9.a.a((d0) com.larus.im.internal.delegate.w.f348282r.getValue(), "enable_token_preload_optimize", false);
        if (r101 == true) goto L9;
        if (r0.f348258b.a() == false) goto L63;
        OmniTokenServiceKt.prefetchTokens(OmniTokenServiceKtxKt.getOmniTokenService(), new OMNIAVRTCTokenRequest(r210, 0, "cold-boot-" + UUID.randomUUID(), 2, null));
        return;
    L63:
        return;
    L9:
        if (r0.f348258b.a() == true) goto L12;
        fe9.c.f476624a.e("AndroidFlowAVLinkRuntime", "[ConnectOpt][tokenPreload] skip disabled, enableTokenPreloadOptimize=" + r101);
        return;
    L12:
        int r102 = x.f347507a;
        Intrinsics.checkNotNullParameter(r210, "rtcAppIds");
        List<String> r103 = r210;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(StringsKt.trim((String) r105.next()).toString());
        goto L14
    L16:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r104.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if ((true ^ StringsKt.isBlank((String) r108)) == false) goto L18;
        r106.add(r108);
        goto L18
    L22:
        List r109 = CollectionsKt.sorted(CollectionsKt.distinct(r106));
        if (r109.isEmpty() == false) goto L26;
        fe9.c.f476624a.e("AndroidFlowAVLinkRuntime", "[ConnectOpt][tokenPreload] skip empty rtcAppIds, enableTokenPreloadOptimize=" + r101);
        return;
    L26:
        com.larus.im.internal.delegate.w.b r110 = com.larus.im.internal.delegate.w.j().f348359d;
        if (r110 == null) goto L29;
        int r111 = r110.f348326o;
    L31:
        if (r0.f348258b.i() == false) goto L33;
        String r112 = EffectConstants.CHANNEL_TEST;
    L34:
        ConcurrentHashMap<String, Long> r113 = com.larus.im.internal.network.link.impl.rtc.strategy.c.f349429a;
        Intrinsics.checkNotNullParameter(r112, "env");
        Intrinsics.checkNotNullParameter(r109, "rtcAppIds");
        String r114 = r112 + '|' + r111 + '|' + CollectionsKt.joinToString$default(r109, ",", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter(r114, "key");
        Intrinsics.checkNotNullParameter("media_service", "trigger");
        long r115 = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, Long>> r116 = com.larus.im.internal.network.link.impl.rtc.strategy.c.f349429a.entrySet().iterator();
    L36:
        if (r116.hasNext() == false) goto L40;
        Map.Entry<String, Long> r117 = r116.next();
        String r118 = r117.getKey();
        long r119 = r117.getValue().longValue();
        if ((r115 - r119) < 5000) goto L36;
        com.larus.im.internal.network.link.impl.rtc.strategy.c.f349429a.remove(r118, Long.valueOf(r119));
        goto L36
    L40:
        ConcurrentHashMap<String, Long> r120 = com.larus.im.internal.network.link.impl.rtc.strategy.c.f349429a;
        Long r121 = r120.putIfAbsent(r114, Long.valueOf(r115));
        if (r121 != null) goto L43;
        fe9.a.f476620a.e("RTCTokenPreloadDedupeState", "[ConnectOpt][tokenPreload] acquire, trigger: media_service, key: " + r114);
    L47:
        r100 = true;
    L48:
        if (r100 == true) goto L50;
        return;
    L50:
        com.larus.im.internal.network.link.impl.rtc.strategy.c.a(r114);
        String r122 = "token-preload-opt-" + UUID.randomUUID();
        fe9.c.f476624a.e("AndroidFlowAVLinkRuntime", "[ConnectOpt][tokenPreload] enqueue, trigger: media_service, traceId: " + r122 + ", tokenNum: " + r111 + ", rtcAppIds: " + r109 + ", enableTokenPreloadOptimize: " + r101);
        OmniTokenServiceKt.prefetchTokens(OmniTokenServiceKtxKt.getOmniTokenService(), new OMNIAVRTCTokenRequest(r109, 0, r122, 2, null));
        return;
    L43:
        long r123 = r115 - r121.longValue();
        if (r123 >= 5000) goto L46;
        fe9.a.f476620a.e("RTCTokenPreloadDedupeState", "[ConnectOpt][tokenPreload] skip in-flight, trigger: media_service, key: " + r114 + ", ageMs: " + r123);
        goto L48
    L46:
        r120.put(r114, Long.valueOf(r115));
        fe9.a.f476620a.e("RTCTokenPreloadDedupeState", "[ConnectOpt][tokenPreload] acquire expired, trigger: media_service, key: " + r114 + ", ageMs: " + r123);
        goto L47
    L33:
        r112 = "prod";
        goto L34
    L29:
        r111 = 5;
        goto L31
    }

    @Override // qf9.d
    public final void c(cf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = com.larus.im.internal.network.link.impl.rtc.c.f349293a;
        Intrinsics.checkNotNullParameter(r100, "config");
        ff9.u.f476776a.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        AtomicInteger r102 = j0.f349903m;
        Intrinsics.checkNotNullParameter(r100, "config");
        com.larus.im.internal.rtcsdk.impl.v r103 = com.larus.im.internal.rtcsdk.impl.v.f350031a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        com.larus.im.internal.rtcsdk.impl.v.f();
        Object r104 = com.larus.im.internal.rtcsdk.impl.v.f350032b;
        monitor-enter(r104);
        RTCEngine r105 = com.larus.im.internal.rtcsdk.impl.v.f350041k;     // Catch: Throwable -> L12
        if (r105 != null) goto L7;
    L9:
        com.larus.im.internal.rtcsdk.impl.v.f350039i = r100;     // Catch: Throwable -> L12
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L12
        r106.put("app_id", r100.f23542a);     // Catch: Throwable -> L12
        c1 r107 = c1.f348202a;     // Catch: Throwable -> L12
        z.a.c("flow_av_rtc_engine_config", r106.toString());     // Catch: Throwable -> L12
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r104);
        return;
    L7:
        if (Intrinsics.areEqual(r100, r103.d()) == true) goto L9;
        r105.setBusinessId(r100.f23543b);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // qf9.d
    public final int d(com.larus.im.service.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return -1;
    }
}
