package com.bytedance.timonbase.report;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.b;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TMDataCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function0<? extends Map<String, Object>> f270824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270825b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<Function0<Unit>> f270826c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, JsonObject> f270827d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TMDataCollector f270828e = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/timonbase/report/TMDataCollector$a;", "", "", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "c", "()Ljava/util/List;", "", "", "sampleRate", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "priority", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("priority")
        private final Map<String, Integer> priority;

        @SerializedName(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
        private final Map<String, Integer> sampleRate;

        @SerializedName(PromotionProductPrivilegesStruct.TAGS)
        private final List<String> tags;

        public a() {
            List<String> r100 = CollectionsKt.emptyList();
            Map<String, Integer> r101 = MapsKt.emptyMap();
            Map<String, Integer> r102 = MapsKt.emptyMap();
            this.tags = r100;
            this.sampleRate = r101;
            this.priority = r102;
        }

        public final Map<String, Integer> a() {
            return this.priority;
        }

        public final Map<String, Integer> b() {
            return this.sampleRate;
        }

        public final List<String> c() {
            return this.tags;
        }
    }

    public TMDataCollector() {
    }

    static {
        f270828e = new TMDataCollector();
        f270824a = TMDataCollector$extraParamsBuilder$1.INSTANCE;
        f270825b = LazyKt.lazy(TMDataCollector$isMainProcess$2.INSTANCE);
        f270826c = new ConcurrentLinkedQueue();
        Pair[] r100 = new Pair[9];
        JsonObject r101 = new JsonObject();
        JsonObject r102 = new JsonObject();
        r102.addProperty("default", 1);
        r101.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r102);
        r100[0] = TuplesKt.to("timon_action_log", r101);
        JsonObject r103 = new JsonObject();
        JsonObject r104 = new JsonObject();
        r104.addProperty("default", 1);
        r103.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r104);
        r100[1] = TuplesKt.to("timon_permission_dialog", r103);
        JsonObject r105 = new JsonObject();
        JsonObject r106 = new JsonObject();
        r106.addProperty("default", 1);
        r105.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r106);
        r100[2] = TuplesKt.to("timon_permission_manager", r105);
        JsonObject r107 = new JsonObject();
        JsonObject r108 = new JsonObject();
        r108.addProperty("default", 1);
        r107.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r108);
        r100[3] = TuplesKt.to("timon_dye_mark", r107);
        JsonObject r109 = new JsonObject();
        JsonObject r110 = new JsonObject();
        r110.addProperty("default", 1);
        r109.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r110);
        r100[4] = TuplesKt.to("timon_effective_read_pasteboard_feedback", r109);
        JsonObject r111 = new JsonObject();
        JsonObject r112 = new JsonObject();
        r112.addProperty("default", 1);
        r111.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r112);
        r100[5] = TuplesKt.to("timon_read_pasteboard_event", r111);
        JsonObject r113 = new JsonObject();
        JsonObject r114 = new JsonObject();
        r114.addProperty("default", 1);
        r113.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r114);
        r100[6] = TuplesKt.to("timon_calendar_event", r113);
        JsonObject r115 = new JsonObject();
        JsonObject r116 = new JsonObject();
        boolean r117 = TMEnv.f270767a;
        if (TMEnv.f270767a == false) goto L5;
        r116.addProperty("default", 1);
    L6:
        r115.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r116);
        r100[7] = TuplesKt.to("timon_process_killer", r115);
        JsonObject r118 = new JsonObject();
        JsonObject r119 = new JsonObject();
        if (TMEnv.f270767a == false) goto L9;
        r119.addProperty("default", 1);
    L10:
        r118.add(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r119);
        r100[8] = TuplesKt.to("timon_process_report", r118);
        f270827d = MapsKt.mutableMapOf(r100);
        return;
    L9:
        r119.addProperty("default", 10);
        goto L10
    L5:
        r116.addProperty("default", 100);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.bytedance.timonbase.report.TMDataCollector$selectRateKeyAndItemRateByPriority$1] */
    public static Triple c(JSONObject r110, JsonObject r210) {
        JsonObject r100 = r210.getAsJsonObject(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT);
        String r101 = "default";
        if (r100 == null) goto L7;
        JsonElement r102 = r100.get("default");
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getAsInt());
    L8:
        boolean r104 = true;
        if (r210.has(PromotionProductPrivilegesStruct.TAGS) == false) goto L71;
        a r105 = (a) GsonProtectorUtils.fromJson(TMInjection.a(), r210, a.class);
        if (r105 == null) goto L15;
        List<String> r106 = r105.c();
        if (r106 == null) goto L15;
    L16:
        ArrayList r111 = new ArrayList();
        Iterator<T> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L27;
        Object r112 = r107.next();
        String r113 = (String) r112;
        if (r110 != null) goto L22;
    L24:
        boolean r114 = false;
    L25:
        if (r114 == false) goto L18;
        r111.add(r112);
        goto L18
    L22:
        if (r110.has(r113) != true) goto L24;
        r114 = true;
        goto L25
    L27:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r115 = r111.iterator();
    L29:
        if (r115.hasNext() == false) goto L35;
        String r116 = (String) r115.next();
        StringBuilder r117 = new StringBuilder();
        r117.append(r116);
        r117.append(com.alipay.sdk.m.n.a.f25612h);
        if (r110 == null) goto L33;
        Object r118 = r110.opt(r116);
    L34:
        r117.append(r118);
        r108.add(r117.toString());
        goto L29
    L33:
        r118 = null;
        goto L34
    L35:
        List r109 = CollectionsKt.toMutableList(r108);
        if (r106.size() <= 1) goto L38;
        r109.add(((StringBuilder) CollectionsKt.joinTo$default(r109, new StringBuilder(), "&", null, null, 0, null, TMDataCollector$selectRateKeyAndItemRateByPriority$allCondition$1.INSTANCE, 60, null)).toString());
    L38:
        final Ref.IntRef r119 = new Ref.IntRef();
        if (r105 == null) goto L45;
        Map<String, Integer> r120 = r105.b();
        if (r120 == null) goto L45;
        Integer r121 = r120.get("default");
        if (r121 == null) goto L45;
        int r122 = r121.intValue();
    L46:
        r119.element = r122;
        final Ref.ObjectRef r123 = new Ref.ObjectRef();
        r123.element = "default";
        final Ref.IntRef r124 = new Ref.IntRef();
        r124.element = 0;
        ?? r125 = new TMDataCollector$selectRateKeyAndItemRateByPriority$1(r123, r119, r124);
        if (r105 == null) goto L70;
        Iterator r126 = r109.iterator();
    L50:
        if (r126.hasNext() == false) goto L70;
        String r127 = (String) r126.next();
        Integer r128 = r105.a().get(r127);
        if (r128 == null) goto L54;
        int r129 = r128.intValue();
    L55:
        Integer r130 = r105.b().get(r127);
        if (r130 == null) goto L50;
        int r131 = r124.element;
        if (r129 > r131) goto L59;
        if (r129 != r131) goto L50;
        if (Intrinsics.areEqual((String) r123.element, "default") == true) goto L63;
        if (r130.intValue() == 0) goto L69;
        int r132 = r130.intValue();
        int r133 = r119.element;
        if (r132 <= r133) goto L50;
        if (r133 == 0) goto L50;
    L69:
        r125.invoke(r127, r130.intValue(), r129);
        goto L50
    L63:
        r125.invoke(r127, r130.intValue(), r129);
        goto L50
    L59:
        r125.invoke(r127, r130.intValue(), r129);
        goto L50
    L54:
        r129 = 0;
    L70:
        r101 = (String) r123.element;
        int r134 = Math.max(Integer.MIN_VALUE, r119.element);
    L72:
        if (r134 != Integer.MIN_VALUE) goto L77;
        if (r103 == null) goto L76;
        r134 = r103.intValue();
        goto L77
    L76:
        return new Triple(Boolean.FALSE, 0, r101);
    L77:
        if (r134 != 0) goto L81;
        return new Triple(Boolean.FALSE, 0, r101);
    L81:
        if (Random.Default.nextDouble(AudioStats.AUDIO_AMPLITUDE_NONE, r134) <= 1.0d) goto L85;
        r104 = false;
    L85:
        return new Triple(Boolean.valueOf(r104), Integer.valueOf(r134), r101);
    L45:
        r122 = 0;
    L15:
        r106 = CollectionsKt.emptyList();
        goto L16
    L71:
        r134 = Integer.MIN_VALUE;
    L7:
        r103 = null;
        goto L8
    }

    public static boolean d(final String r100, final JSONObject r101, boolean r102, Map r103) {
        return a("app_log", r100, r101, r102, r103, new TMDataCollector$reportAppLog$1(r101, r100));
    }

    public static /* synthetic */ void e(String r100, JSONObject r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        d(r100, r101, r102, null);
    }

    public static void h(final String r100, final JSONObject r110, final JSONObject r111, JSONObject r112, int r113) {
        TMDataCollector r101 = f270828e;
        if ((r113 & 8) == 0) goto L5;
        r112 = null;
    L5:
        final JSONObject r102 = r112;
        final int r103 = 0;
        JSONObject r114 = new JSONObject();
        if (r110 == null) goto L12;
        Iterator<String> r104 = r110.keys();
        if (r104 == null) goto L12;
    L10:
        if (r104.hasNext() == false) goto L12;
        String r105 = r104.next();
        r114.put(r105, r110.opt(r105));
    L12:
        if (r111 == null) goto L18;
        Iterator<String> r106 = r111.keys();
        if (r106 == null) goto L18;
    L16:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();
        r114.put(r107, r111.opt(r107));
    L18:
        if (r102 == null) goto L24;
        Iterator<String> r108 = r102.keys();
        if (r108 == null) goto L24;
    L22:
        if (r108.hasNext() == false) goto L24;
        String r109 = r108.next();
        r114.put(r109, r102.opt(r109));
    L24:
        b(r101, "monitor", r100, r114, false, new TMDataCollector$reportMonitorEvent$4(r102, r100, r103, r110, r111));
    }

    public final boolean g(String r100, final Throwable r101, final String r102, final Map<String, String> r110, boolean r111) {
        return b(this, "user_exception", r100, new JSONObject(r110), r111, new TMDataCollector$reportException$1(r110, r101, r102));
    }

    public static boolean a(String r100, String r101, JSONObject r102, boolean r110, Map r111, Function1 r112) {
        String r103 = "null";
        JsonObject r104 = com.bytedance.timonbase.config.a.a("data_collect_config");     // Catch: Exception -> L62
        JsonObject r105 = null;
        if (r104 == null) goto L6;
        JsonObject r106 = r104.getAsJsonObject(r100);     // Catch: Exception -> L62
    L7:
        if (r106 == null) goto L10;
        r105 = r106.getAsJsonObject(r101);     // Catch: Exception -> L62
    L10:
        if (r105 != null) goto L17;
        if (Intrinsics.areEqual(r100, "app_log") == false) goto L17;
        Map<String, JsonObject> r107 = f270827d;     // Catch: Exception -> L62
        if (r107.containsKey(r101) == false) goto L17;
        r105 = r107.get(r101);     // Catch: Exception -> L62
    L17:
        if (r105 == null) goto L19;
        if (r111 != null) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == true) goto L34;
        r102 = new JSONObject(r111);     // Catch: Exception -> L62
    L34:
        Triple r109 = c(r102, r105);     // Catch: Exception -> L62
        if (((Boolean) r109.getFirst()).booleanValue() == true) goto L37;
        return false;
    L37:
        int r113 = ((Number) r109.getSecond()).intValue();     // Catch: Exception -> L62
        r103 = (String) r109.getThird();     // Catch: Exception -> L62
        int r114 = r113;
    L38:
        Pair[] r115 = new Pair[10];     // Catch: Exception -> L62
        r115[0] = TuplesKt.to("extra_timon_sample_rate", String.valueOf(r114));     // Catch: Exception -> L62
        r115[1] = TuplesKt.to("sample_rate_strategy", r103);     // Catch: Exception -> L62
        r115[2] = TuplesKt.to("extra_timon_version", "4.0.1-rc.5-doubao");     // Catch: Exception -> L62
        r115[3] = TuplesKt.to("extra_host_version_name", TMEnv.f270772f);     // Catch: Exception -> L62
        r115[4] = TuplesKt.to("extra_host_version_code", String.valueOf(TMEnv.f270773g));     // Catch: Exception -> L62
        r115[5] = TuplesKt.to("extra_host_update_version_code", String.valueOf(TMEnv.f270774h));     // Catch: Exception -> L62
        if (((Boolean) f270825b.getValue()).booleanValue() == false) goto L42;
        Object r116 = "1";
    L43:
        r115[6] = TuplesKt.to("extra_main_process", r116);     // Catch: Exception -> L62
        r115[7] = TuplesKt.to("extra_host_app_id", String.valueOf(TMEnv.f270770d));     // Catch: Exception -> L62
        r115[8] = TuplesKt.to("extra_timon_timestamp", String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L62
        r115[9] = TuplesKt.to("extra_mark", TMEnv.f270783q);     // Catch: Exception -> L62
        Map r117 = MapsKt.mutableMapOf(r115);     // Catch: Exception -> L62
        if (r110 == false) goto L60;
        Map<String, Object> r118 = f270824a.invoke();     // Catch: Exception -> L62
        r117.put("rule_engine_params", TMInjection.a().toJson(r118));     // Catch: Exception -> L62
        Iterator<Map.Entry<String, Object>> r119 = r118.entrySet().iterator();     // Catch: Exception -> L62
    L47:
        if (r119.hasNext() == false) goto L60;
        Map.Entry<String, Object> r120 = r119.next();     // Catch: Exception -> L62
        if ((r120.getValue() instanceof Boolean) == false) goto L58;
        Object r121 = r120.getValue();     // Catch: Exception -> L62
        if (r121 == null) goto L57;
        if (((Boolean) r121).booleanValue() == false) goto L55;
        String r122 = "1";
    L59:
        r117.put("rule_engine_param_" + r120.getKey(), r122);     // Catch: Exception -> L62
        goto L47
    L55:
        r122 = "0";
        goto L59
    L57:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L62
    L58:
        r122 = r120.getValue().toString();     // Catch: Exception -> L62
    L60:
        r112.invoke(r117);     // Catch: Exception -> L62
        return true;
    L42:
        r116 = "0";
        goto L43
    L27:
        if (r111.isEmpty() == true) goto L30;
        r108 = false;
        goto L31
    L19:
        if (Intrinsics.areEqual(r100, "app_log") == false) goto L22;
        return false;
    L22:
        if (com.bytedance.timonbase.config.a.a("data_collect_config") != null) goto L24;
        return false;
    L24:
        r114 = -1;
        goto L38
    L6:
        r106 = null;
    L62:
        e = move-exception;
        b.d("TMDataCollector", "sampler call failed.", e);
        return false;
    }

    public static /* synthetic */ boolean b(TMDataCollector r100, String r101, String r102, JSONObject r103, boolean r110, Function1 r111) {
        r100.getClass();
        return a(r101, r102, r103, r110, null, r111);
    }

    public final boolean f(String r110, final String r111, final String r112, final String r113, final String r114, final boolean r115, final Map r116, final Map r210, boolean r211) {
        final String r100 = "EnsureNotReachHere";
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(r116);
        r101.putAll(r210);
        return b(this, "user_exception", r110, new JSONObject(MapsKt.toMap(r101)), r211, new TMDataCollector$reportException$2(r116, r111, r112, r113, r100, r114, r115, r210));
    }
}
