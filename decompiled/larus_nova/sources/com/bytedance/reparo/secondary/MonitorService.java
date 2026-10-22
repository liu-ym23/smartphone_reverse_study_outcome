package com.bytedance.reparo.secondary;

import android.app.Application;
import android.os.Build;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.core.o;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MonitorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SDKMonitor f267465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f267466b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f267467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IReparoConfig f267468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Application f267469e;

    public MonitorService() {
    }

    static {
        f267466b = new AnonymousClass1();
        f267467c = false;
        f267468d = null;
        f267469e = null;
    }

    public static void a() {
        if (f267467c == false) goto L5;
        return;
    L5:
        if (f267469e == null) goto L22;
        IReparoConfig r100 = f267468d;
        if (r100 != null) goto L10;
        return;
    L10:
        if (b.a(r100.getDeviceId()) == true) goto L12;
        return;
    L12:
        f267467c = true;
        Application r101 = f267469e;
        String r102 = f267468d.getDeviceId();
        String r103 = f267468d.getAppId();
        f267468d.getChannel();
        String r104 = f267468d.getUpdateVersionCode();
        JSONObject r105 = new JSONObject();
        r105.put("device_id", r102);     // Catch: JSONException -> L15
        r105.put("host_aid", r103);     // Catch: JSONException -> L15
        r105.put("channel", "release");     // Catch: JSONException -> L15
        r105.put("app_version", "0.0.4-rc.56");     // Catch: JSONException -> L15
        r105.put("update_version_code", r104);     // Catch: JSONException -> L15
        r105.put("package_name", r101.getPackageName());     // Catch: JSONException -> L15
    L17:
        SDKMonitorUtils.setConfigUrl("7506", Collections.singletonList("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));
        SDKMonitorUtils.setDefaultReportUrl("7506", Collections.singletonList(ReportConstant.DEFAULT_URL_REPORT));
        SDKMonitorUtils.initMonitor(r101, "7506", r105, new g());
        Logger.c();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static SDKMonitor c() {
        if (f267465a == null) goto L5;
    L14:
        a();
        return f267465a;
    L5:
        monitor-enter(MonitorService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267465a != null) goto L9;
        f267465a = SDKMonitorUtils.getInstance("7506");     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorService.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static JSONObject b(JSONObject r100) {
        if (h97.a.f484331b != (-1)) goto L6;
        h97.a.f484331b = h97.a.a().contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;     // Catch: Throwable -> L18
    L6:
        boolean r101 = false;
        if (h97.a.f484331b != 1) goto L9;
        boolean r102 = true;
    L10:
        r100.put("is_64_device", r102);     // Catch: Throwable -> L18
        if (h97.a.f484332c != (-1)) goto L14;
        h97.a.f484332c = h97.a.a().contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE) ? 1 : 0;     // Catch: Throwable -> L18
    L14:
        if (h97.a.f484332c != 1) goto L16;
        r101 = true;
    L16:
        r100.put("is_x86_device", r101);     // Catch: Throwable -> L18
        r100.put("api_level", Build.VERSION.SDK_INT);     // Catch: Throwable -> L18
        r100.put("sdk_channel", "release");     // Catch: Throwable -> L18
        o r103 = o.c();     // Catch: Throwable -> L18
        r103.a();     // Catch: Throwable -> L18
        r100.put("is_64_runtime", ((c97.b) r103.f267412b).b().contains(BDLocationException.ERROR_RESTRICTED_MODE_ON));     // Catch: Throwable -> L18
        goto L17
    L9:
        r102 = false;
    L17:
        return r100;
    }
}
