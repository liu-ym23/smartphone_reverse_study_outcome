package com.bytedance.ug.sdk.luckydog.api.log;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rk7.m;
import tk7.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<i> f271583a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f271584b;

    static {
        f271583a = new CopyOnWriteArrayList();
        f271584b = false;
    }

    public static void b(i r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Application r100 = m.f538347a;
        if (m.f538357k == true) goto L53;
    L24:
        String r101 = r110.f546573a;
        JSONObject r102 = r110.f546574b;
        JSONObject r103 = r110.f546575c;
        JSONObject r111 = r110.f546577e;
        SDKMonitor r104 = h.f271586a;
        Context r105 = m.f538361o.e();
        if (r105 != null) goto L27;
        return;
    L27:
        if (h.f271587b == true) goto L41;
        h.f271587b = true;
        Npth.registerSdk(CastIntegerProtector.parseInt("290983"), "8.75.0-rc.12-db");
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L38
        r106.put("device_id", m.h());     // Catch: Exception -> L38
        r106.put("host_aid", String.valueOf(m.f()));     // Catch: Exception -> L38
        r106.put("sdk_version", "8.75.0-rc.12-db");     // Catch: Exception -> L38
        ik7.b r107 = m.f538351e;     // Catch: Exception -> L38
        if (r107 == null) goto L35;
        bn7.a r108 = ((dn7.b) r107).f469365b;     // Catch: Exception -> L38
        if (r108 == null) goto L35;
        int r109 = r108.getUpdateVersionCode();     // Catch: Exception -> L38
    L36:
        r106.put("update_version_code", String.valueOf(r109));     // Catch: Exception -> L38
        SDKMonitorUtils.setDefaultReportUrl("290983", CollectionsKt.listOf(ReportConstant.DEFAULT_URL_REPORT));     // Catch: Exception -> L38
        SDKMonitorUtils.setConfigUrl("290983", CollectionsKt.listOf("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));     // Catch: Exception -> L38
        SDKMonitorUtils.initMonitor(r105, "290983", r106, new g());     // Catch: Exception -> L38
        h.f271586a = SDKMonitorUtils.getInstance("290983");     // Catch: Exception -> L38
    L35:
        r109 = 0;
    L38:
        e = move-exception;
        d.b("SDKMonitorUtil", e.getMessage());
        h.f271587b = false;
    L41:
        if (h.f271587b == true) goto L43;
        return;
    L43:
        if (h.f271586a == null) goto L57;
        d.a("SDKMonitorUtil", "[Monitor] " + r101 + ", " + r102 + ", " + r103 + ", " + r111);
        if (TextUtils.isEmpty(r101) == true) goto L58;
        SDKMonitor r112 = h.f271586a;
        if (r112 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        r112.monitorEvent(r101, r102, r103, r111);
        return;
    L58:
        return;
    L57:
        return;
    L53:
        String r113 = r110.f546573a;     // Catch: Throwable -> L22
        int r114 = r110.f546576d;     // Catch: Throwable -> L22
        JSONObject r115 = r110.f546578f;     // Catch: Throwable -> L22
        JSONObject r116 = r110.f546574b;     // Catch: Throwable -> L22
        JSONObject r117 = r110.f546575c;     // Catch: Throwable -> L22
        JSONObject r118 = r110.f546577e;     // Catch: Throwable -> L22
        String r119 = "empty";
        if (r116 == null) goto L11;
        String r120 = r116.toString();     // Catch: Throwable -> L22
    L12:
        if (r117 == null) goto L14;
        String r121 = r117.toString();     // Catch: Throwable -> L22
    L15:
        if (r115 == null) goto L17;
        String r122 = r115.toString();     // Catch: Throwable -> L22
    L18:
        if (r118 == null) goto L20;
        r119 = r118.toString();     // Catch: Throwable -> L22
    L20:
        String r123 = "LuckyDogMonitor_" + r113;     // Catch: Throwable -> L22
        d.a(r123, "status: " + r114 + ", category: " + r120 + ", metric: " + r121 + ", duration: " + r122 + ", logExtra: " + r119 + ", did : " + m.h());     // Catch: Throwable -> L22
        goto L24
    L17:
        r122 = "empty";
        goto L18
    L14:
        r121 = "empty";
        goto L15
    L11:
        r120 = "empty";
    L22:
        th = move-exception;
        d.a("LuckyDogMonitor", th.getMessage());
        goto L24
    }

    public static void a(String r100, JSONObject r101, JSONObject r102) {
        i r103 = new i();
        r103.f546573a = r100;
        r103.f546576d = 0;
        r103.f546574b = r101;
        r103.f546578f = null;
        r103.f546577e = r102;
        r103.f546575c = null;
        Application r104 = m.f538347a;
        if (TextUtils.isEmpty(m.h()) == false) goto L5;
        d.a("LuckyDogMonitor", "add cache monitor event");
        f271583a.add(r103);
        f271584b = true;
        return;
    L5:
        b(r103);
        if (f271584b == false) goto L32;
        d.a("LuckyDogMonitor", "flushCacheMonitorEvent");
        CopyOnWriteArrayList<i> r105 = f271583a;
        monitor-enter(r105);
        f271584b = false;     // Catch: Throwable -> L24
        if (r105.size() > 0) goto L14;
        monitor-exit(r105);     // Catch: Throwable -> L24
        return;
    L14:
        Iterator<i> r106 = r105.iterator();     // Catch: Throwable -> L24
        if (r106 != null) goto L19;
        monitor-exit(r105);     // Catch: Throwable -> L24
        return;
    L19:
        if (r106.hasNext() == false) goto L21;
        b(r106.next());     // Catch: Throwable -> L24
        goto L19
    L21:
        f271583a.clear();     // Catch: Throwable -> L24
        d.a("LuckyDogMonitor", "flush cache monitor end");     // Catch: Throwable -> L24
        monitor-exit(r105);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
