package com.bytedance.badger.monitor;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.d;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import com.bytedance.badger.network.l0;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.badger.v.h;
import com.bytedance.badger.v.l;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import z64.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f199044c = null;

    static {
        f199042a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "samplerRandom", "getSamplerRandom()Ljava/util/Random;"))};
        f199044c = new c();
        f199043b = LazyKt.lazy(a.f199040a);
    }

    public c() {
    }

    public static void d(String r100, Map r101) {
        d r102 = e.f199030a;     // Catch: Throwable -> L4
        e.d(r100, new JSONObject(r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e.c("BadgerMonitor", "Failed to parse event params: " + th.getMessage(), th);
    }

    public static void e() {
        com.bytedance.badger.v.d.f199322f0.getClass();
        h r100 = com.bytedance.badger.v.d.f199337u;
        KProperty r101 = com.bytedance.badger.v.d.f199311a[21];
        int r102 = ((Number) r100.a()).intValue();
        if (r102 > 0) goto L6;
        e.g("BadgerMonitor", "BadgerReport sample rate is not positive");
        return;
    L6:
        Lazy r103 = f199043b;
        KProperty r104 = f199042a[0];
        if (((Random) r103.getValue()).nextInt(r102) != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        e.b("BadgerMonitor", "BadgerReport sampler miss");
        return;
    L13:
        e.f("BadgerMonitor", "BadgerReport sampler hit");
        List r106 = CollectionsKt.emptyList();
        r106 = com.bytedance.badger.t.a.a(2022117834, null, null, 6).d(b.f199041a);     // Catch: Throwable -> L16
    L18:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L20:
        if (r108.hasNext() == false) goto L42;
        c74.a r109 = (c74.a) r108.next();
        f199044c.getClass();
        BadgerCore.Companion.getClass();
        r107.add(TuplesKt.to("badger_detector_feature_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("last_scn_id", Integer.valueOf(j.a().getLastUpdateScene())), TuplesKt.to("is_login", Integer.valueOf(j.a().isLogin() ? 1 : 0)), TuplesKt.to("f_id", Integer.valueOf(r109.f22640a)), TuplesKt.to("duration", Long.valueOf(r109.f22641b)), TuplesKt.to("queue_wait_time_ms", Long.valueOf(r109.f22642c)), TuplesKt.to("collect_time_ms", Long.valueOf(r109.f22643d)), TuplesKt.to("has_error", Integer.valueOf(r109.f22644e ? 1 : 0)), TuplesKt.to("is_from_store", Integer.valueOf(r109.f22645f ? 1 : 0)), TuplesKt.to("is_from_async", Integer.valueOf(r109.f22646g ? 1 : 0))})));
        goto L20
    L42:
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L39
        r110.append("onEventBatch: ");     // Catch: Throwable -> L39
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));     // Catch: Throwable -> L39
        Iterator r112 = r107.iterator();     // Catch: Throwable -> L39
    L24:
        if (r112.hasNext() == false) goto L26;
        r111.add((String) ((Pair) r112.next()).getFirst());     // Catch: Throwable -> L39
        goto L24
    L26:
        r110.append(r111);     // Catch: Throwable -> L39
        e.f("BadgerMonitor", r110.toString());     // Catch: Throwable -> L39
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));     // Catch: Throwable -> L39
        Iterator r114 = r107.iterator();     // Catch: Throwable -> L39
    L28:
        if (r114.hasNext() == false) goto L30;
        Pair r115 = (Pair) r114.next();     // Catch: Throwable -> L39
        r113.add(TuplesKt.to((String) r115.component1(), new JSONObject((Map) r115.component2())));     // Catch: Throwable -> L39
        goto L28
    L30:
        d r116 = e.f199030a;     // Catch: Throwable -> L39
        if (r116 == null) goto L33;
        r116.b(r113);     // Catch: Throwable -> L39
        return;
    L33:
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));     // Catch: Throwable -> L39
        Iterator r118 = r113.iterator();     // Catch: Throwable -> L39
    L35:
        if (r118.hasNext() == false) goto L37;
        r117.add((String) ((Pair) r118.next()).getFirst());     // Catch: Throwable -> L39
        goto L35
    L37:
        r117.toString();     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        e.c("BadgerMonitor", "Failed to parse event params: " + th.getMessage(), th);
        return;
    L16:
        th = move-exception;
        e.c("BadgerMonitor", "Failed to get badger metrics: " + th.getMessage(), th);
        goto L18
    L9:
        r105 = false;
        goto L10
    }

    public static void b(c r310, TriggerStage r311, Throwable r312, int r313, String r314, int r315, long r410, long r411, z64.c r412, l0 r413, boolean r414, long r415, com.bytedance.badger.C.a r416, z64.h r510, int r511) {
        if ((r511 & 4) == 0) goto L5;
        int r110 = 0;
    L7:
        if ((r511 & 8) == 0) goto L9;
        String r111 = "";
    L11:
        if ((r511 & 16) == 0) goto L13;
        int r100 = 0;
    L15:
        if ((r511 & 32) == 0) goto L17;
        long r112 = 0;
    L19:
        if ((r511 & 64) == 0) goto L21;
        long r113 = 0;
    L23:
        if ((r511 & 128) == 0) goto L25;
        z64.c r101 = null;
    L27:
        if ((r511 & 256) == 0) goto L29;
        l0 r102 = null;
    L31:
        if ((r511 & 512) == 0) goto L33;
        boolean r114 = false;
    L35:
        if ((r511 & 1024) == 0) goto L37;
        long r115 = 0;
    L39:
        if ((r511 & 2048) == 0) goto L41;
        com.bytedance.badger.C.a r210 = com.bytedance.badger.C.a.f199018b;
    L43:
        if ((r511 & 4096) == 0) goto L45;
        z64.h r211 = null;
    L46:
        r310.getClass();
        boolean r103 = r312 instanceof C10462c;
        if (r103 == false) goto L49;
        int r104 = ((C10462c) r312).c();
    L50:
        if (r103 == false) goto L52;
        String r105 = ((C10462c) r312).d();
    L53:
        String r212 = r105;
        if (r103 == false) goto L56;
        CollectStage r106 = ((C10462c) r312).b();
    L57:
        if (r103 == false) goto L61;
        String r107 = ((C10462c) r312).a();
        if (r107 == null) goto L61;
        String r213 = r107;
    L62:
        boolean r108 = r101 instanceof f;
        if (r108 == false) goto L65;
        String r109 = r101.a();
    L66:
        String r214 = r311.name();
        String r116 = r106.name();
        if (r102 == null) goto L69;
        int r215 = com.bm.badgervi.b.b(r102);
    L70:
        if (r108 == false) goto L72;
        String r117 = ((f) r101).f570470f;
    L74:
        if (r101 == null) goto L76;
        int r118 = r101.getSceneId();
    L77:
        if (r114 == true) goto L79;
    L83:
        long r316 = 0;
    L84:
        c(r310, r109, r214, r116, false, r100, r112, r113, false, null, r117, r104, r110, r111, r212, r215, r118, false, r213, r316, r210, 0, r211, 1114368);
        return;
    L79:
        if (r115 == 0) goto L83;
        if (r115 == 0) goto L83;
        r316 = SystemClock.elapsedRealtime() - r115;
        goto L84
    L76:
        r118 = 0;
        goto L77
    L72:
        r117 = "";
        goto L74
    L69:
        r215 = 0;
        goto L70
    L65:
        r109 = "";
    L61:
        r213 = "";
        goto L62
    L56:
        r106 = CollectStage.collect_pre;
        goto L57
    L52:
        r105 = r312.toString();
        goto L53
    L49:
        r104 = -1000;
        goto L50
    L45:
        r211 = r510;
        goto L46
    L41:
        r210 = r416;
        goto L43
    L37:
        r115 = r415;
        goto L39
    L33:
        r114 = r414;
        goto L35
    L29:
        r102 = r413;
        goto L31
    L25:
        r101 = r412;
        goto L27
    L21:
        r113 = r411;
        goto L23
    L17:
        r112 = r410;
        goto L19
    L13:
        r100 = r315;
        goto L15
    L9:
        r111 = r314;
        goto L11
    L5:
        r110 = r313;
        goto L7
    }

    public static void a(c r310, TriggerStage r311, CollectStage r312, z64.c r313, z64.b r314, int r315, long r316, long r410, String r411, l0 r412, boolean r413, long r414, com.bytedance.badger.C.a r415, int r416, z64.h r417, int r510) {
        int r100 = 0;
        if ((r510 & 16) == 0) goto L5;
        int r110 = 0;
    L6:
        long r101 = 0;
        if ((r510 & 32) == 0) goto L9;
        long r111 = 0;
    L11:
        if ((r510 & 64) == 0) goto L13;
        long r112 = 0;
    L15:
        if ((r510 & 128) == 0) goto L17;
        String r113 = "";
    L19:
        if ((r510 & 256) == 0) goto L21;
        l0 r102 = null;
    L23:
        if ((r510 & 512) == 0) goto L25;
        boolean r210 = false;
    L27:
        if ((r510 & 1024) == 0) goto L29;
        long r114 = 0;
    L31:
        if ((r510 & 2048) == 0) goto L33;
        com.bytedance.badger.C.a r211 = com.bytedance.badger.C.a.f199018b;
    L35:
        if ((r510 & 4096) == 0) goto L37;
        int r212 = 0;
    L39:
        if ((r510 & 8192) == 0) goto L41;
        z64.h r317 = null;
    L42:
        r310.getClass();
        boolean r103 = r313 instanceof f;
        if (r103 == false) goto L45;
        String r104 = r313.a();
    L46:
        String r105 = r311.name();
        String r115 = r312.name();
        if (r102 == null) goto L49;
        int r213 = com.bm.badgervi.b.b(r102);
    L50:
        if (r314 == null) goto L52;
        boolean r106 = r314.f570457c;
    L54:
        if (r103 == false) goto L56;
        String r107 = ((f) r313).f570470f;
    L58:
        if (r313 == null) goto L61;
        r100 = r313.getSceneId();
    L61:
        if (r210 == true) goto L63;
    L67:
        c(r310, r104, r105, r115, true, r110, r111, r112, r106, r113, r107, 0, 0, null, "", r213, r100, r210, null, r101, r211, r212, r317, 137216);
        return;
    L63:
        if (r114 == 0) goto L67;
        if (r114 == 0) goto L67;
        r101 = SystemClock.elapsedRealtime() - r114;
        goto L67
    L56:
        r107 = "";
        goto L58
    L52:
        r106 = false;
        goto L54
    L49:
        r213 = 0;
        goto L50
    L45:
        r104 = "";
        goto L46
    L41:
        r317 = r417;
        goto L42
    L37:
        r212 = r416;
        goto L39
    L33:
        r211 = r415;
        goto L35
    L29:
        r114 = r414;
        goto L31
    L25:
        r210 = r413;
        goto L27
    L21:
        r102 = r412;
        goto L23
    L17:
        r113 = r411;
        goto L19
    L13:
        r112 = r410;
        goto L15
    L9:
        r111 = r316;
        goto L11
    L5:
        r110 = r315;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.SpreadBuilder] */
    public static void c(c r210, String r211, String r212, String r213, boolean r214, int r215, long r310, long r311, boolean r312, String r313, String r314, int r315, int r316, String r317, String r410, int r411, int r412, boolean r413, String r414, long r415, com.bytedance.badger.C.a r416, int r417, z64.h r418, int r510) {
        if ((r510 & 64) == 0) goto L5;
        long r100 = 0;
    L6:
        String r101 = "";
        if ((r510 & 256) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r510 & 512) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r510 & 1024) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r510 & 2048) == 0) goto L21;
        int r110 = 0;
    L23:
        if ((r510 & 4096) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r510 & 8192) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r510 & 16384) == 0) goto L33;
        int r113 = 0;
    L35:
        if ((32768 & r510) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((65536 & r510) == 0) goto L41;
        ?? r115 = 0;
    L43:
        if ((r510 & 131072) != 0) goto L47;
        r101 = r414;
    L47:
        if ((r510 & 262144) == 0) goto L49;
        long r116 = 0;
    L51:
        if ((r510 & 524288) == 0) goto L53;
        com.bytedance.badger.C.a r117 = com.bytedance.badger.C.a.f199018b;
    L55:
        if ((r510 & 1048576) == 0) goto L57;
        int r118 = 0;
    L59:
        if ((r510 & 2097152) == 0) goto L61;
        z64.h r105 = null;
    L62:
        r210.getClass();
        com.bytedance.badger.v.d.f199322f0.getClass();
        h r216 = com.bytedance.badger.v.d.f199338v;
        KProperty[] r217 = com.bytedance.badger.v.d.f199311a;
        KProperty r218 = r217[22];
        int r106 = ((Number) r216.a()).intValue();
        if (r106 <= 0) goto L71;
        Lazy r219 = f199043b;
        KProperty r220 = f199042a[0];
        if (((Random) r219.getValue()).nextInt(r106) != 0) goto L68;
        boolean r107 = true;
    L69:
        if (r107 == true) goto L71;
        boolean r108 = false;
    L72:
        if (r108 == false) goto L111;
        ?? r109 = new SpreadBuilder(27);
        r109.add(TuplesKt.to("path", r211));
        r109.add(TuplesKt.to("trigger_stage", r212));
        r109.add(TuplesKt.to("collect_stage", r213));
        r109.add(TuplesKt.to("timeout", Integer.valueOf(r215)));
        r109.add(TuplesKt.to("collect_duration", Long.valueOf(r310)));
        r109.add(TuplesKt.to("uptime_duration", Long.valueOf(r100)));
        r109.add(TuplesKt.to(CronetDataStorageAccess.LOGID, r102));
        r109.add(TuplesKt.to("login_logid", r103));
        r109.add(TuplesKt.to("errCode", Integer.valueOf(r104)));
        r109.add(TuplesKt.to("serverErrorCode", Integer.valueOf(r110)));
        r109.add(TuplesKt.to("serverErrorMsg", r111));
        r109.add(TuplesKt.to("result", Integer.valueOf(r214 ? 1 : 0)));
        r109.add(TuplesKt.to(AuthorizeMonitorUtil.Param.ERROR_DESC, r112));
        r109.add(TuplesKt.to("is_full_finished", Integer.valueOf(r312 ? 1 : 0)));
        r109.add(TuplesKt.to("is_timeout_retry", Integer.valueOf(r115)));
        r109.add(TuplesKt.to("collect_err_message", r101));
        r109.add(TuplesKt.to("scn_id", Integer.valueOf(r114)));
        r109.add(TuplesKt.to("report_version", 1));
        r109.add(TuplesKt.to(com.heytap.mcssdk.constant.b.C, BuildConfig.SDK_VERSION_NAME));
        BadgerCore.Companion.getClass();
        r109.add(TuplesKt.to("is_login", Integer.valueOf(j.a().isLogin() ? 1 : 0)));
        r109.add(TuplesKt.to("retry_time", Integer.valueOf(r113)));
        l r119 = com.bytedance.badger.v.d.f199319e;
        KProperty r120 = r217[1];
        r109.add(TuplesKt.to("config_version", (String) r119.a()));
        r109.add(TuplesKt.to("not_full_duration", Long.valueOf(r116)));
        r109.add(TuplesKt.to("compensate_type", Integer.valueOf(r117.a())));
        r109.add(TuplesKt.to("size", Integer.valueOf(r118)));
        if ((r105 instanceof z64.h.d) == false) goto L78;
        int r121 = 1;
    L91:
        r109.add(TuplesKt.to("collect_mode", Integer.valueOf(r121)));
        z64.a r122 = j.a().getBadgerExtraParams();
        if (r122 == null) goto L106;
        Pair[] r123 = new Pair[3];
        long r124 = r122.f570452a;
        if (r124 != 0) goto L96;
        long r125 = 0;
    L97:
        r123[0] = TuplesKt.to("app_start_duration", Long.valueOf(r125));
        long r126 = r122.f570453b;
        if (r126 != 0) goto L100;
        long r127 = 0;
    L101:
        r123[1] = TuplesKt.to("account_setup_duration", Long.valueOf(r127));
        long r128 = r122.f570454c;
        long r129 = 0;
        if (r128 == 0) goto L105;
        r129 = System.currentTimeMillis() - r128;
    L105:
        r123[2] = TuplesKt.to("last_login_duration", Long.valueOf(r129));
    L107:
        r109.addSpread(r123);
        d("badger_detector_report", MapsKt.mapOf((Pair[]) r109.toArray(new Pair[r109.size()])));
        return;
    L100:
        r127 = System.currentTimeMillis() - r126;
        goto L101
    L96:
        r125 = System.currentTimeMillis() - r124;
        goto L97
    L106:
        r123 = new Pair[0];
        goto L107
    L78:
        if ((r105 instanceof z64.h.e) == false) goto L81;
        r121 = 2;
        goto L91
    L81:
        if ((r105 instanceof z64.h.a) == false) goto L84;
        r121 = 3;
        goto L91
    L84:
        if ((r105 instanceof z64.h.c) == false) goto L87;
        r121 = 4;
        goto L91
    L87:
        if ((r105 instanceof z64.h.b) == false) goto L89;
        r121 = 5;
        goto L91
    L89:
        if (r105 != null) goto L110;
        r121 = 0;
        goto L91
    L110:
        throw new NoWhenBranchMatchedException();
    L111:
        return;
    L68:
        r107 = false;
    L71:
        r108 = true;
        goto L72
    L61:
        r105 = r418;
        goto L62
    L57:
        r118 = r417;
        goto L59
    L53:
        r117 = r416;
        goto L55
    L49:
        r116 = r415;
        goto L51
    L41:
        r115 = r413;
        goto L43
    L37:
        r114 = r412;
        goto L39
    L33:
        r113 = r411;
        goto L35
    L29:
        r112 = r410;
        goto L31
    L25:
        r111 = r317;
        goto L27
    L21:
        r110 = r316;
        goto L23
    L17:
        r104 = r315;
        goto L19
    L13:
        r103 = r314;
        goto L15
    L9:
        r102 = r313;
        goto L11
    L5:
        r100 = r311;
        goto L6
    }
}
