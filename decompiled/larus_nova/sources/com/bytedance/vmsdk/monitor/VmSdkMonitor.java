package com.bytedance.vmsdk.monitor;

import com.bytedance.dataplatform.o;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.vmsdk.log.VLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import up7.a;

/* JADX INFO: loaded from: classes3.dex */
public class VmSdkMonitor {
    public VmSdkMonitor() {
    }

    public static void a() {
        monitor-enter(VmSdkMonitor.class);
        VLog.init();     // Catch: Throwable -> L6
        SDKMonitorUtils.setConfigUrl("8398", a.f551059a);     // Catch: Throwable -> L6
        SDKMonitorUtils.setDefaultReportUrl("8398", a.f551060b);     // Catch: Throwable -> L6
        new JSONObject();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private static int getSettingsFlag() {
        wp7.a r100 = wp7.a.b();
        monitor-enter(r100);
        r100.f560602c = r100.d();     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        wp7.a r101 = wp7.a.b();
        r101.getClass();
        int r102 = 0;
        Integer r103 = 0;
        Object r104 = o.d("VMSDK", r103.getClass(), r103, false, true, null);     // Catch: Throwable -> L12
        if (r104 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L12
    L10:
        int r105 = ((Integer) r104).intValue();     // Catch: Throwable -> L12
    L14:
        if (r105 != 0) goto L26;
        HashMap<String, Object> r106 = r101.f560602c;
        if (r106 == null) goto L28;
        Map r107 = (Map) r106.get("vmsdk_common");     // Catch: Throwable -> L24
        if (r107 == null) goto L26;
        Object r108 = r107.get("VMSDK");     // Catch: Throwable -> L24
        Objects.toString(r108);     // Catch: Throwable -> L24
        if (r108 == null) goto L26;
        r102 = ((Integer) r108).intValue();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.toString();
    L28:
        return r102;
    L26:
        r102 = r105;
    L12:
        th = move-exception;
        th.toString();
        r105 = 0;
    L29:
        th = move-exception;
        throw th;
    }

    private static boolean getSettings(String r100) {
        wp7.a r101 = wp7.a.b();
        monitor-enter(r101);
        r101.f560602c = r101.d();     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return wp7.a.b().a(r100);
    L8:
        th = move-exception;
        throw th;
    }

    private static void monitorEvent(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L5
        r104.put(MapMonitorConst.BIZ_NAME, r101);     // Catch: Throwable -> L5
        r104.put(r102, r103);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        th.getMessage();
    }
}
