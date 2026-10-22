package com.larus.dora.impl.sysinfo;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import com.larus.dora.impl.core.settingsconfig.DoraMultiDeviceConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.b1;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.r0;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiList;
import com.larus.dora.impl.wlan.wifi.DoraWifiResponse;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import yj4.f;
import yj4.g;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraSystemInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraSystemInfoManager f338056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int[] f338057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int[] f338058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int[] f338059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Integer f338060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Integer f338061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f338062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Integer f338063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Integer f338064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f338065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Integer f338066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Integer f338067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Integer f338068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Integer f338069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Integer f338070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f338071p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f338072q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final LinkedBlockingQueue<List<Pair<String, Object>>> f338073r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static DoraDevice f338074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static List<Pair<String, Object>> f338075t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f338076u = null;

    public static final class a extends r0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.r0, mj4.h
        public final void N0(DoraDevice r100, int[] r101) {
            g49.d.d("DoraSystemInfoManager", "onDiskSpaceChanged, diskSpace: " + Arrays.toString(r101));
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length < 3) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L11;
            r101 = null;
        L11:
            if (r101 == null) goto L15;
            DoraSystemInfoManager.f338059d = r101;
            List r103 = CollectionsKt.listOf(new Pair[]{new Pair("disk_total", String.valueOf(r101[0])), new Pair("disk_available", String.valueOf(r101[1])), new Pair("album_used", String.valueOf(r101[2]))});
            DoraSystemInfoManager r104 = DoraSystemInfoManager.f338056a;
            DoraSystemInfoManager.f(r103);
            return;
        L15:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.larus.dora.impl.util.r0, mj4.h
        public final void a0(DoraDevice r100, int[] r101) {
            g49.d.d("DoraSystemInfoManager", "onVolumeChanged, volume: " + Arrays.toString(r101));
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length < 3) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L11;
            r101 = null;
        L11:
            if (r101 == null) goto L15;
            DoraSystemInfoManager.f338058c = r101;
            List r103 = CollectionsKt.listOf(new Pair[]{new Pair("tip_volume", String.valueOf(r101[0])), new Pair("music_volume", String.valueOf(r101[1])), new Pair("call_volume", String.valueOf(r101[2]))});
            DoraSystemInfoManager r104 = DoraSystemInfoManager.f338056a;
            DoraSystemInfoManager.f(r103);
            return;
        L15:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.larus.dora.impl.util.r0, mj4.h
        public final void b0(DoraDevice r100, int[] r101) {
            g49.d.d("DoraSystemInfoManager", "onBatteryChanged, battery: " + Arrays.toString(r101));
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length < 3) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == false) goto L10;
            int[] r103 = r101;
        L11:
            if (r103 == null) goto L15;
            DoraSystemInfoManager.f338057b = r101;
            List r104 = CollectionsKt.listOf(new Pair[]{new Pair(Scraps.BATTERY, String.valueOf(r103[0])), new Pair("case_battery", String.valueOf(r103[2]))});
            DoraSystemInfoManager r105 = DoraSystemInfoManager.f338056a;
            DoraSystemInfoManager.f(r104);
            return;
        L15:
            return;
        L10:
            r103 = null;
            goto L11
        L7:
            r102 = false;
            goto L8
        }
    }

    public DoraSystemInfoManager() {
    }

    static {
        f338056a = new DoraSystemInfoManager();
        f338071p = LazyKt.lazy(new com.larus.dora.impl.sysinfo.a());
        f338072q = LazyKt.lazy(new b());
        f338073r = new LinkedBlockingQueue();
        f338076u = LazyKt.lazy(new c());
    }

    public static final void c() {
        String r100 = f338065j;
        if (r100 != null) goto L5;
        r100 = "[]";
    L5:
        List r101 = CollectionsKt.listOf(new Pair("wifi_settings", r100));
        g49.d.d("DoraSystemInfoManager", "wifiSettings: " + f338065j);
        f(r101);
    }

    public static void d() {
        g49.d.d("DoraSystemInfoManager", "DoraSystemInfoManager, init");
        BuildersKt.launch$default((CoroutineScope) f338072q.getValue(), null, null, new DoraSystemInfoManager$start$1(null), 3, null);
        kj4.a r100 = kj4.a.g();
        if (r100 == null) goto L5;
        r100.k(new a());
        r100.registerDoraLinkCallback(new DoraSystemInfoManager$init$1$2());
    L5:
        ConnectivityManager r101 = (ConnectivityManager) ContextCompat.getSystemService(AppHost.f326268a.getApplication(), ConnectivityManager.class);
        NetworkRequest r102 = new NetworkRequest.Builder().addCapability(12).build();
        g49.d.d("DoraSystemInfoManager", "registerNetworkCallback");
        if (r101 == null) goto L13;
        r101.registerNetworkCallback(r102, new DoraSystemInfoManager$init$2());     // Catch: Exception -> L9
        return;
    L9:
        g49.d.d("DoraSystemInfoManager", "registerNetworkCallback failed!");
        return;
    }

    public static void e() {
        BuildersKt.launch$default((CoroutineScope) f338071p.getValue(), null, null, new DoraSystemInfoManager$refreshAndUploadWifiSettings$1(null), 3, null);
    }

    public static void f(List r100) {
        Intrinsics.checkNotNullParameter(r100, "sysInfoList");
        g49.d.d("DoraSystemInfoManager", "uploadSysInfo, sysInfoList: " + r100);
        DoraDevice r101 = f338074s;
        if (r101 != null) goto L7;
        g49.d.d("DoraSystemInfoManager", "uploadSysInfo, device is null");
        return;
    L7:
        if (o59.a.o(Integer.valueOf(r101.productId)) == true) goto L10;
        g49.d.d("DoraSystemInfoManager", "uploadSysInfo, productId is not Dora G series");
        return;
    L10:
        f338073r.offer(r100);
    }

    public static void g(int r100) {
        g49.d.d("DoraSystemInfoManager", "uploadVideoRecordDuration, duration: " + r100);
        f338068m = Integer.valueOf(r100);
        f(CollectionsKt.listOf(new Pair("single_recording_duration", String.valueOf(r100))));
    }

    public static void h(int r100) {
        g49.d.d("DoraSystemInfoManager", "uploadVideoRecordRatio, ratio: " + r100);
        f338069n = Integer.valueOf(r100);
        f(CollectionsKt.listOf(new Pair("recording_video_aspect_ratio", String.valueOf(r100))));
    }

    public static void i(int r100) {
        g49.d.d("DoraSystemInfoManager", "uploadVideoRecordResolution, resolution: " + r100);
        f338070o = Integer.valueOf(r100);
        f(CollectionsKt.listOf(new Pair("recording_video_resolution", String.valueOf(r100))));
    }

    public static final Object a(DoraSystemInfoManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DoraSystemInfoManager$fetchWifiSettings$1) == false) goto L7;
        DoraSystemInfoManager$fetchWifiSettings$1 r100 = (DoraSystemInfoManager$fetchWifiSettings$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        w39.a r105 = (w39.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L51
    L21:
        com.larus.dora.impl.core.request.v2.a r106 = (com.larus.dora.impl.core.request.v2.a) r102;     // Catch: Exception -> L51
        if ((r106 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L56;
        g49.d.b("DoraRequestXV2", "request<T>: failed, " + r106);     // Catch: Exception -> L51
        Result.Companion r107 = Result.Companion;     // Catch: Exception -> L51
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("Request failed: " + r106)));     // Catch: Exception -> L51
    L33:
        if (Result.m9456isSuccessimpl(r108) == false) goto L48;
        DoraWifiList r109 = (DoraWifiList) ((DoraWifiResponse) r108).getData();     // Catch: Exception -> L51
        if (r109 == null) goto L37;
        List<DoraWifiEntity> r112 = r109.getWifiList();     // Catch: Exception -> L51
    L38:
        if (r112 != null) goto L40;
        r112 = CollectionsKt.emptyList();     // Catch: Exception -> L51
    L40:
        List r113 = CollectionsKt.filterNotNull(r112);     // Catch: Exception -> L51
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L51
        Iterator r115 = r113.iterator();     // Catch: Exception -> L51
    L42:
        if (r115.hasNext() == false) goto L46;
        DoraWifiEntity r116 = (DoraWifiEntity) r115.next();     // Catch: Exception -> L51
        if (r116 == null) goto L42;
        r114.add(r116);     // Catch: Exception -> L51
        goto L42
    L46:
        g49.d.d("DoraSystemInfoManager", "fetchWifiSettings: " + r114);     // Catch: Exception -> L51
        f338065j = '[' + CollectionsKt.joinToString$default(r114, ",", null, null, 0, null, null, 62, null) + ']';     // Catch: Exception -> L51
        goto L48
    L37:
        r112 = null;
    L48:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L54;
        g49.d.d("DoraSystemInfoManager", "fetchWifiSettings Failed");     // Catch: Exception -> L51
        f338065j = "[]";     // Catch: Exception -> L51
    L54:
        return Unit.INSTANCE;
    L56:
        Type r117 = new d().getType();     // Catch: Throwable -> L29
        byte[] r118 = ((com.larus.dora.impl.core.request.v2.a.b) r106).f332256a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L29
        Object r119 = r105.a(r118, r117);     // Catch: Throwable -> L29
        if (r119 != null) goto L27;
        g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L29
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L29
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L29
    L55:
    L27:
        r108 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        g49.d.c("DoraRequestXV2", "request<T>: parse error", th);     // Catch: Exception -> L51
        Result.Companion r121 = Result.Companion;     // Catch: Exception -> L51
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L51
        goto L33
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        g49.d.d("DoraSystemInfoManager", "fetchWifiSettings: start");
        DoraRequestXV2 r122 = DoraRequestXV2.f332240a;     // Catch: Exception -> L51
        bl4.c r123 = new bl4.c();     // Catch: Exception -> L51
        Lazy<w39.d> r124 = w39.d.f558188b;     // Catch: Exception -> L51
        w39.d r125 = w39.d.a.a();     // Catch: Exception -> L51
        r100.L$0 = r125;     // Catch: Exception -> L51
        r100.label = 1;     // Catch: Exception -> L51
        r102 = r122.a(r123, 5000, r100);     // Catch: Exception -> L51
        if (r102 == r103) goto L65;
        r105 = r125;
        goto L21
    L65:
        return r103;
    L51:
        e = move-exception;
        g49.d.c("DoraSystemInfoManager", "fetchWifiSettings: failed", e);
        f338065j = "[]";
    L7:
        r100 = new DoraSystemInfoManager$fetchWifiSettings$1(r110, r111);
        goto L8
    }

    public static final Object b(DoraSystemInfoManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DoraSystemInfoManager$fullUploadSysInfo$1) == false) goto L7;
        DoraSystemInfoManager$fullUploadSysInfo$1 r100 = (DoraSystemInfoManager$fullUploadSysInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        List r114 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L165:
        int r115 = ((Number) r112).intValue();
        if (r115 < 0) goto L168;
        r114.add(new Pair("adaptive_ambient_sound", String.valueOf(r115)));
    L168:
        int r116 = kj4.a.g().h();
        if (r116 < 0) goto L171;
        r114.add(new Pair("anti_sound_leak_mode", String.valueOf(r116)));
    L171:
        b0.f338123a.getClass();
        String r103 = "1";
        if (b0.s() == false) goto L174;
        Object r104 = "1";
    L175:
        r114.add(new Pair("enhanced_location_accuracy", r104));
        if (b0.y() == true) goto L179;
        r103 = "0";
    L179:
        r114.add(new Pair("allow_save_to_phone_album", r103));
        f(r114);
        return Unit.INSTANCE;
    L174:
        r104 = "0";
        goto L175
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        ArrayList r117 = new ArrayList();
        int[] r105 = f338057b;
        Integer r106 = null;
        int r107 = 2;
        if (r105 != null) goto L17;
    L25:
        int[] r108 = f338058c;
        if (r108 != null) goto L28;
    L36:
        int[] r109 = f338059d;
        if (r109 != null) goto L39;
    L47:
        IDoraService r118 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r118 != null) goto L50;
    L52:
        boolean r119 = false;
    L53:
        if (r119 == false) goto L55;
        Integer r120 = Boxing.boxInt(1);
    L56:
        f338063h = r120;
        kj4.a r121 = kj4.a.g();
        if (r121 == null) goto L59;
        Integer r122 = Boxing.boxInt(r121.f503710e.b());
    L60:
        f338060e = r122;
        int r123 = g.f568093a;
        f r124 = f.a.f568092a;
        if (r124 == null) goto L63;
        Integer r125 = Boxing.boxInt(r124.f568089e);
    L64:
        f338061f = r125;
        kj4.a r126 = kj4.a.g();
        if (r126 == null) goto L69;
        DoraDevice r127 = r126.c();
        if (r127 == null) goto L69;
        String r128 = o59.a.e(r127);
    L70:
        f338062g = r128;
        Integer r129 = f338063h;
        if (r129 == null) goto L73;
        Boxing.boxBoolean(r117.add(new Pair("has_new_firmware_available", String.valueOf(r129.intValue()))));
    L73:
        Integer r130 = f338060e;
        if (r130 == null) goto L76;
        Boxing.boxBoolean(r117.add(new Pair("wear_detection_switch", String.valueOf(r130.intValue()))));
    L76:
        Integer r131 = f338061f;
        if (r131 == null) goto L79;
        Boxing.boxBoolean(r117.add(new Pair("album_auto_sync_switch", String.valueOf(r131.intValue()))));
    L79:
        String r132 = f338062g;
        if (r132 == null) goto L82;
        Boxing.boxBoolean(r117.add(new Pair("fw_version", r132)));
    L82:
        DoraSetting.f338023a.getClass();
        DoraMultiDeviceConfig r133 = (DoraMultiDeviceConfig) l0.a(null, new b1());
        if (r133 == null) goto L108;
        DoraDevice r134 = kj4.a.g().c();
        if (r134 == null) goto L88;
        r106 = Integer.valueOf(r134.type);
    L88:
        if (o59.a.n(r106) == false) goto L92;
        Boolean r135 = r133.getDoraG();
        if (r135 == null) goto L108;
        boolean r136 = r135.booleanValue();
    L110:
        if (r136 == false) goto L116;
        mj4.f r137 = kj4.a.g().f503708c;
        int r138 = r137.f514239n;
        if (r138 != (-1)) goto L114;
        r138 = r137.h();
    L114:
        f338064i = Boxing.boxInt(r138);
    L116:
        if (DoraAdapterExtKt.p(kj4.a.g()) == false) goto L118;
        Integer r139 = Boxing.boxInt(1);
    L119:
        f338066k = r139;
        if (((Boolean) f338076u.getValue()).booleanValue() == false) goto L122;
        b0.f338123a.getClass();
        f338067l = Boxing.boxInt(b0.c());
    L122:
        Integer r140 = f338064i;
        if (r140 == null) goto L125;
        Boxing.boxBoolean(r117.add(new Pair("multi_device_connection_switch", String.valueOf(r140.intValue()))));
    L125:
        String r141 = f338065j;
        if (r141 == null) goto L128;
        Boxing.boxBoolean(r117.add(new Pair("wifi_settings", r141)));
    L128:
        Integer r142 = f338066k;
        if (r142 == null) goto L131;
        Boxing.boxBoolean(r117.add(new Pair("doubao_voice_wakeup", String.valueOf(r142.intValue()))));
    L131:
        Integer r143 = f338067l;
        if (r143 == null) goto L134;
        Boxing.boxBoolean(r117.add(new Pair("doubao_auto_hangup_timeout", String.valueOf(r143.intValue()))));
    L134:
        List<Pair<String, Object>> r144 = f338075t;
        if (r144 == null) goto L137;
        Boxing.boxBoolean(r117.addAll(r144));
    L137:
        Integer r145 = f338068m;
        if (r145 == null) goto L140;
        Boxing.boxBoolean(r117.add(new Pair("single_recording_duration", String.valueOf(r145.intValue()))));
    L140:
        Integer r146 = f338069n;
        if (r146 == null) goto L143;
        Boxing.boxBoolean(r117.add(new Pair("recording_video_aspect_ratio", String.valueOf(r146.intValue()))));
    L143:
        Integer r147 = f338070o;
        if (r147 == null) goto L146;
        Boxing.boxBoolean(r117.add(new Pair("recording_video_resolution", String.valueOf(r147.intValue()))));
    L146:
        int r148 = kj4.a.g().z() & UByte.MAX_VALUE;
        switch(r148) {
            case 0: goto L158;
            case 1: goto L157;
            case 2: goto L156;
            case 3: goto L155;
            case 4: goto L154;
            case 5: goto L153;
            case 6: goto L152;
            case 7: goto L151;
            case 8: goto L150;
            default: goto L148;
        };
    L148:
        switch(r148) {
            case 253: goto L160;
            case 254: goto L159;
            case 255: goto L161;
            default: goto L149;
        };
    L149:
        r107 = -1;
        goto L161
    L159:
        r107 = 1;
        goto L161
    L160:
        r107 = 0;
    L161:
        r117.add(new Pair("prompt_tone_volume_level", String.valueOf(r107 + 1)));
        kj4.a r149 = kj4.a.g();
        r100.L$0 = r117;
        r100.label = 1;
        Object r150 = DoraAdapterExtKt.l(r149);
        if (r150 == r113) goto L181;
        r114 = r117;
        r112 = r150;
        goto L165
    L181:
        return r113;
    L150:
        r107 = 11;
        goto L161
    L151:
        r107 = 10;
        goto L161
    L152:
        r107 = 9;
        goto L161
    L153:
        r107 = 8;
        goto L161
    L154:
        r107 = 7;
        goto L161
    L155:
        r107 = 6;
        goto L161
    L156:
        r107 = 5;
        goto L161
    L157:
        r107 = 4;
        goto L161
    L158:
        r107 = 3;
        goto L161
    L118:
        r139 = Boxing.boxInt(0);
        goto L119
    L92:
        int r151 = ProductNameType.DORA_E.deviceType;
        if (r106 != null) goto L96;
    L100:
        int r152 = ProductNameType.DORA_LITE.deviceType;
        if (r106 == null) goto L108;
        if (r106.intValue() != r152) goto L108;
        Boolean r153 = r133.getDora();
        if (r153 == null) goto L108;
        r136 = r153.booleanValue();
        goto L110
    L96:
        if (r106.intValue() != r151) goto L100;
        Boolean r154 = r133.getDoraE();
        if (r154 == null) goto L108;
        r136 = r154.booleanValue();
    L108:
        r136 = true;
    L69:
        r128 = null;
        goto L70
    L63:
        r125 = null;
        goto L64
    L59:
        r122 = null;
        goto L60
    L55:
        r120 = Boxing.boxInt(0);
        goto L56
    L50:
        if (r118.j() != true) goto L52;
        r119 = true;
        goto L53
    L39:
        if (r109.length < 3) goto L41;
        boolean r155 = true;
    L42:
        if (r155 == true) goto L45;
        r109 = null;
    L45:
        if (r109 == null) goto L47;
        r117.add(new Pair("disk_total", String.valueOf(r109[0])));
        r117.add(new Pair("disk_available", String.valueOf(r109[1])));
        Boxing.boxBoolean(r117.add(new Pair("album_used", String.valueOf(r109[2]))));
        goto L47
    L41:
        r155 = false;
        goto L42
    L28:
        if (r108.length < 3) goto L30;
        boolean r156 = true;
    L31:
        if (r156 == true) goto L34;
        r108 = null;
    L34:
        if (r108 == null) goto L36;
        r117.add(new Pair("tip_volume", String.valueOf(r108[0])));
        r117.add(new Pair("music_volume", String.valueOf(r108[1])));
        Boxing.boxBoolean(r117.add(new Pair("call_volume", String.valueOf(r108[2]))));
        goto L36
    L30:
        r156 = false;
        goto L31
    L17:
        if (r105.length < 3) goto L19;
        boolean r157 = true;
    L20:
        if (r157 == true) goto L23;
        r105 = null;
    L23:
        if (r105 == null) goto L25;
        r117.add(new Pair(Scraps.BATTERY, String.valueOf(r105[0])));
        Boxing.boxBoolean(r117.add(new Pair("case_battery", String.valueOf(r105[2]))));
        goto L25
    L19:
        r157 = false;
    L7:
        r100 = new DoraSystemInfoManager$fullUploadSysInfo$1(r110, r111);
        goto L8
    }
}
