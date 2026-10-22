package com.bytedance.timonbase.config;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.cache.TMCacheService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f270812a = null;

    static {
        f270812a = new LinkedHashMap();
    }

    public static void b() {
        Iterator r100 = ServiceManager.get().getServices(ITMLifecycleService.class).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ITMLifecycleService) r100.next()).e();
        goto L4
    L6:
        JsonObject r101 = a.a("monitor");
        if (r101 == null) goto L11;
        JsonElement r102 = r101.get("enable");
        if (r102 == null) goto L11;
        a("init.monitor.enable", r102.getAsBoolean());
    L11:
        JsonObject r103 = a.a("rule_engine_config");
        if (r103 == null) goto L16;
        JsonElement r104 = r103.get("enable");
        if (r104 == null) goto L16;
        a("init.rule_engine_config.enable", r104.getAsBoolean());
    L16:
        JsonObject r105 = a.a(LBSLightLocationTraceLogger.BPEA);
        if (r105 == null) goto L21;
        JsonElement r106 = r105.get("enable");
        if (r106 == null) goto L21;
        a("init.bpea.enable", r106.getAsBoolean());
    L21:
        JsonObject r107 = a.a("bpea_pipeline");
        if (r107 == null) goto L26;
        JsonElement r108 = r107.get("enable");
        if (r108 == null) goto L26;
        a("init.bpea_pipline.enable", r108.getAsBoolean());
    L26:
        JsonObject r109 = a.a("timon_shield");
        if (r109 == null) goto L31;
        JsonElement r110 = r109.get("enable");
        if (r110 == null) goto L31;
        a("init.timon_shield.enable", r110.getAsBoolean());
    L31:
        JsonObject r111 = a.a("timon_cache");
        if (r111 == null) goto L36;
        JsonElement r112 = r111.get("enable");
        if (r112 == null) goto L36;
        a("init.timon_cache.enable", r112.getAsBoolean());
    L36:
        JsonObject r113 = a.a("location_permission_keeper");
        if (r113 == null) goto L41;
        JsonElement r114 = r113.get("enable");
        if (r114 == null) goto L41;
        a("init.permission_keeper_location.enable", r114.getAsBoolean());
    L41:
        JsonObject r115 = a.a("anti_survival_switch");
        if (r115 == null) goto L46;
        JsonElement r116 = r115.get("enable");
        if (r116 == null) goto L46;
        a("init.anti_survival_switch.enable", r116.getAsBoolean());
    L46:
        if (r115 == null) goto L50;
        JsonElement r117 = r115.get("monitor_enable");
        if (r117 == null) goto L50;
        a("anti_survival.monitor_enable", r117.getAsBoolean());
    L50:
        if (r115 == null) goto L54;
        JsonElement r118 = r115.get("forbidden_job_scheduler");
        if (r118 == null) goto L54;
        a("anti_survival.forbidden_job_scheduler", r118.getAsBoolean());
    L54:
        if (r115 == null) goto L58;
        JsonElement r119 = r115.get("forbidden_alarm_service");
        if (r119 == null) goto L58;
        a("anti_survival.forbidden_alarm_service", r119.getAsBoolean());
    L58:
        if (r115 == null) goto L103;
        JsonElement r120 = r115.get("close_push_service_proxy");
        if (r120 == null) goto L103;
        a("anti_survival.close_push_service_proxy", r120.getAsBoolean());
    L103:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L68
        JsonObject r122 = a.a("network_control_config");     // Catch: Throwable -> L68
        if (r122 != null) goto L66;
        r122 = new JsonObject();     // Catch: Throwable -> L68
    L66:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L68
    L71:
        if (Result.m9456isSuccessimpl(r123) == false) goto L75;
        JsonElement r124 = ((JsonObject) r123).get("enable");
        if (r124 == null) goto L75;
        a("init.network_control_config.enable", r124.getAsBoolean());
    L75:
        JsonObject r125 = a.a(com.baidu.bbalbscesium.j.b.f30211c);
        if (r125 == null) goto L101;
        JsonElement r126 = r125.get("enable");
        if (r126 == null) goto L101;
        a("init.upc.enable", r126.getAsBoolean());
    L101:
        JsonObject r127 = a.a("scene_config");     // Catch: Throwable -> L94
        if (r127 != null) goto L83;
        com.bytedance.timonbase.b.c("TMInitConfigService", "未拉取到场景检测配置");     // Catch: Throwable -> L94
    L83:
        if (r127 == null) goto L87;
        JsonElement r128 = r127.get("silent_scene_enable");     // Catch: Throwable -> L94
        if (r128 == null) goto L87;
        a("scene_config.silent_mode", r128.getAsBoolean());     // Catch: Throwable -> L94
    L87:
        if (r127 == null) goto L91;
        JsonElement r129 = r127.get("silent_scene_threshold");     // Catch: Throwable -> L94
        if (r129 == null) goto L91;
        long r130 = r129.getAsLong();     // Catch: Throwable -> L94
        TMCacheService.b().putLong("silent_mode_duration", r130);     // Catch: Throwable -> L94
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L94
    L92:
        Object r132 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L94
    L96:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);
        if (r133 == null) goto L99;
        com.bytedance.timonbase.b.d("TMInitConfigService", "拉取配置失败", r133);
    L99:
        Result.m9455isFailureimpl(r132);
        a("init.is_update_config_successfully", true);
        return;
    L91:
        r131 = null;
    L94:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L68:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    }

    public static void a(String r100, boolean r101) {
        TMCacheService.b().putBoolean(r100, r101);
    }
}
