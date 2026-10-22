package com.obric.assistant.performance;

import android.os.Bundle;
import com.larus.apm.api.IApmTrace;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.systemopt.SysPowerKit;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f391046a = null;

    static {
        f391046a = LazyKt.lazy(new j());
    }

    public static void a(int r110, int r111, Bundle r112) {
        String r100 = AccountService.f365697a.getUserId();
        String r101 = o.f365780a.getDeviceId();
        if (r112 == null) goto L5;
        String r102 = r112.getString(SysPowerKit.PWR_OVERUSE_PACKAGE_NAME, "_UNKNOWN");
    L7:
        if (r112 == null) goto L9;
        Integer r103 = Integer.valueOf(r112.getInt(SysPowerKit.PWR_OVERUSE_UID, -1));
    L10:
        if (r112 == null) goto L12;
        Integer r104 = Integer.valueOf(r112.getInt(SysPowerKit.PWR_OVERUSE_PID, -1));
    L14:
        if (r112 == null) goto L16;
        Long r105 = Long.valueOf(r112.getLong(SysPowerKit.PWR_OVERUSE_STAT_TIME, -1));
    L17:
        if (r112 == null) goto L19;
        Long r106 = Long.valueOf(r112.getLong(SysPowerKit.PWR_OVERUSE_THRESHOLD, -1));
    L20:
        if (r112 == null) goto L22;
        String r107 = r112.getString(SysPowerKit.PWR_OVERUSE_ACTION_NAME, "_UNKNOWN");
    L23:
        if (r112 == null) goto L25;
        Boolean r113 = Boolean.valueOf(r112.getBoolean(SysPowerKit.PWR_OVERUSE_COLLECT_APPLOG, false));
    L26:
        JSONObject r108 = new JSONObject();
        r108.put("a_uid", r100);
        r108.put("a_did", r101);
        r108.put("ou_main_type", r110);
        r108.put("ou_sub_type", r111);
        r108.put("pkg_name", r102);
        r108.put("s_uid", r103);
        r108.put("s_pid", r104);
        r108.put("ou_stat_time_s", r105);
        r108.put("ou_threshold", r106);
        r108.put("ou_action_name", r107);
        r108.put("collect_app_log", r113);
        IApmTrace.Companion r114 = IApmTrace.f286937a;
        r114.c("obric_sys_power_overusing_event", r108);
        r114.f("obric_sys_power_overusing_event", new JSONObject(), r108, null);
        FLogger.f375446a.e("ObricSysPowerOveruseMonitor", "[SYS_POWER_OVERUSE_" + r111 + "] error info: " + r108);
        return;
    L25:
        r113 = null;
        goto L26
    L22:
        r107 = null;
        goto L23
    L19:
        r106 = null;
        goto L20
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
