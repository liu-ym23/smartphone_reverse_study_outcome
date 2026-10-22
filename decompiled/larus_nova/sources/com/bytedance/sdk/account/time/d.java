package com.bytedance.sdk.account.time;

import android.os.SystemClock;
import com.bytedance.sdk.account.monitor.IAccountSdkMonitorService;
import com.bytedance.sdk.account.monitor.MonitorProcessor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f269516a = null;

    public d() {
    }

    static {
        f269516a = new ConcurrentHashMap();
    }

    public static final JSONObject a(Pair... r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L6
        int r102 = r100.length;     // Catch: JSONException -> L6
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Pair r104 = r100[r103];     // Catch: JSONException -> L6
        r101.put((String) r104.getFirst(), r104.getSecond());     // Catch: JSONException -> L6
        r103 = r103 + 1;
        goto L3
    L11:
        return r101;
    L7:
        return new JSONObject();
    }

    public static void b(final long r100) {
        final String r101 = "TokenFactory";
        c("passport_time_request_takes_too_long", 600000, new RealTimeMonitor$monitorRequestTakesTooLong$1(r100, r101));
    }

    public static void c(String r100, long r101, Function0 r110) {
        long r102 = SystemClock.elapsedRealtime();
        ConcurrentHashMap r103 = (ConcurrentHashMap) f269516a;
        Long r104 = (Long) r103.get(r100);
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L7:
        if (r101 > 0) goto L9;
    L13:
        if (r101 <= 0) goto L20;
        r103.put(r100, Long.valueOf(r102));
    L20:
        com.bytedance.sdk.account.monitor.a r106 = com.bytedance.sdk.account.monitor.a.f269190c;     // Catch: JSONException -> L17
        r106.getClass();     // Catch: JSONException -> L17
        IAccountSdkMonitorService r107 = (IAccountSdkMonitorService) com.bytedance.sdk.account.monitor.a.f269189b.getValue(r106, com.bytedance.sdk.account.monitor.a.f269188a[0]);     // Catch: JSONException -> L17
        MonitorProcessor.f269179d.getClass();     // Catch: JSONException -> L17
        MonitorProcessor.b(r100, r107, r110);     // Catch: JSONException -> L17
        return;
    L17:
        e = move-exception;
        tb7.a.c("RealTimeMonitor", "Error assembling report params", e);
        return;
    L9:
        if (r102 <= r105) goto L13;
        if ((r102 - r105) >= r101) goto L13;
        return;
    L5:
        r105 = 0;
        goto L7
    }
}
