package com.bytedance.awemeopen.infra.base.monitor;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.monitor.AoMonitorService;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Function0<Unit> {
    public a() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        monitor-enter(AoMonitor.class);
    L41:
        th = move-exception;
        throw th;
    L5:
        if (AoMonitor.b() == false) goto L8;
        monitor-exit(AoMonitor.class);
        return null;
    L8:
        AoHostService r100 = (AoHostService) j64.a.a(AoHostService.class);     // Catch: Throwable -> L41
        if (r100 != null) goto L13;
        AoLogger.i(new Object[]{"BdpInfoService is null "});     // Catch: Throwable -> L41
        monitor-exit(AoMonitor.class);
        return null;
    L13:
        String r101 = "";
        String r102 = "";
        r101 = r100.getDeviceId();     // Catch: Throwable -> L16
        r102 = AoEnv.f198595b.invoke();     // Catch: Throwable -> L16
    L18:
        if (TextUtils.equals(r101, "null") == true) goto L24;
        if (TextUtils.isEmpty(r101) == true) goto L24;
        if (TextUtils.equals(r101, "0") == true) goto L24;
    L30:
        String r103 = String.valueOf(313526);     // Catch: Throwable -> L41
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L41
        r104.put("device_id", r101);     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("bd_device_id", r102);     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("channel", r100.getHostChannel());     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("host_aid", r100.getHostAid());     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("app_version", r100.getHostVersionName());     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("update_version_code", r100.getHostVersionCode());     // Catch: JSONException -> L33 Throwable -> L41
        r104.put("sdk_version", "3.7.3");     // Catch: JSONException -> L33 Throwable -> L41
    L35:
        AoMonitor.f198648a = ((AoMonitorService) j64.a.a(AoMonitorService.class)).Z(r100.getHostApplication(), r103, r104, Arrays.asList(d.f198668a));     // Catch: Throwable -> L41
        AoPool.f(new b());     // Catch: Throwable -> L41
        monitor-exit(AoMonitor.class);
        return null;
    L33:
        e = move-exception;
        AoLogger.c("AoAppMonitor", new Object[]{e.getMessage()});     // Catch: Throwable -> L41
    L24:
        if (TextUtils.equals(r102, "null") == false) goto L26;
    L38:
        monitor-exit(AoMonitor.class);
        return null;
    L26:
        if (TextUtils.isEmpty(r102) == true) goto L38;
        if (TextUtils.equals(r102, "0") == false) goto L30;
    L16:
        AoLogger.c("AoAppMonitor", new Object[]{"Get error deviceId."});     // Catch: Throwable -> L41
        goto L18
    }
}
