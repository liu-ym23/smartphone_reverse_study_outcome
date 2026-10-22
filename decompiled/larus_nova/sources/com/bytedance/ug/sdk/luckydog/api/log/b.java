package com.bytedance.ug.sdk.luckydog.api.log;

import android.app.Application;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ug.sdk.luckydog.api.eventsample.LuckyEventSampleManager;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import il7.i;
import java.util.Set;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void a(String r100, JSONObject r101) {
        LuckyEventSampleManager.f271572g.getClass();     // Catch: Exception -> L16
        if (LuckyEventSampleManager.a.a().a(r100) == false) goto L23;
        b(r100, r101);     // Catch: Exception -> L16
        if (m.f538357k == true) goto L8;
        return;
    L8:
        if (r101 != null) goto L19;
        String r102 = "";
    L11:
        d.a("LuckyDogAppLog_event:".concat(r100), ", data: " + r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.b("LuckyDogAppLog", th.getMessage());     // Catch: Exception -> L16
        return;
    L25:
        return;
    L19:
        r102 = r101.toString();     // Catch: Throwable -> L13
        goto L11
    L23:
        return;
    L16:
        e = move-exception;
        d.b("LuckyDogAppLog", e.getMessage());
    }

    public static void b(String r100, JSONObject r101) {
        Application r102 = m.f538347a;
        ik7.d r103 = m.f538354h;
        if (r103 == null) goto L38;
        if (r101 == null) goto L36;
    L6:
        r101.put("luckydog_api_verison", "8.75.0-rc.12-db");     // Catch: Throwable -> L29
        r101.put("luckydog_sdk_verison", il7.h.c());     // Catch: Throwable -> L29
        m.p();     // Catch: Throwable -> L29
        String r104 = "0";
        r101.put("is_teen_mode", "0");     // Catch: Throwable -> L29
        r101.put("params_for_special", "luckydog_sdk");     // Catch: Throwable -> L29
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r105 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: Throwable -> L29
        r101.put("static_settings_version", com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.STATIC));     // Catch: Throwable -> L29
        r101.put("dynamic_settings_version", com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.DYNAMIC));     // Catch: Throwable -> L29
        r101.put("poll_settings_version", com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.POLL));     // Catch: Throwable -> L29
        r101.put("event_time_ms", hl7.b.b().a());     // Catch: Throwable -> L29
        r101.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L29
        if (rk7.c.a().contains(r100) == false) goto L31;
        Set<String> r106 = to7.a.f546943k;     // Catch: Throwable -> L29
        boolean r107 = false;
        if (to7.a.d.f546961a.f546947d != 1) goto L14;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L18;
        Object r109 = "0";
    L19:
        r101.put("startup_type", r109);     // Catch: Throwable -> L29
        int r110 = i.f490333a;     // Catch: Throwable -> L29
        if (il7.m.a().c("lucky_new_install", 0) == 2) goto L23;
        r107 = true;
    L23:
        if (r107 == false) goto L25;
        r104 = "1";
    L25:
        r101.put("first_open_app", r104);     // Catch: Throwable -> L29
        r101.put("device_score", il7.b.a());     // Catch: Throwable -> L29
        r101.put("network_quality_info", TTNetInit.getEffectiveConnectionType());     // Catch: Throwable -> L29
        zl7.d r111 = (zl7.d) hn7.d.b(zl7.d.class);     // Catch: Throwable -> L29
        if (r111 == null) goto L31;
        r101.put("lucky_session_id", r111.n());     // Catch: Throwable -> L29
        r101.put("lucky_session_id_time", r111.U());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        d.b("LuckyDogAppLog", th.getLocalizedMessage());
        goto L31
    L18:
        r109 = "1";
        goto L19
    L14:
        r108 = false;
    L31:
        int r112 = rk7.b.f538321a;
        if (rk7.b.d(r100, r101) == false) goto L34;
        return;
    L34:
        r103.onAppLogEvent(r100, r101);
        return;
    L36:
        r101 = new JSONObject();     // Catch: Throwable -> L29
        goto L6
    }
}
