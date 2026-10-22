package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f449751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f449752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<a> f449753c = null;

    public interface a {
        void a(j r100, j r101);
    }

    static {
        f449753c = new ArrayList();
    }

    public static void a(a r100) {
        List<a> r101 = f449753c;
        monitor-enter(r101);
        ((ArrayList) r101).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static j b(Context r110) {
        if (f449752b == true) goto L11;
        j r100 = null;
        String r111 = r110.getSharedPreferences("bd_account_sec_time", 0).getString("sec_time_struct", null);
        if (r111 == null) goto L9;
        int r101 = j.f449754h;
        JSONObject r102 = new JSONObject(r111);     // Catch: Exception -> L12
        r100 = new j(r102.optString("secTime", ""), r102.optLong("serverTime", 0), r102.optLong("systemTime", 0), r102.optLong("elapsedRealTimeMs", 0), r102.optInt("rebootTimes", 0), null, null);
    L9:
        f449751a = r100;
        f449752b = true;
    L11:
        return f449751a;
    }

    public static void c(String r100, String r101, String r102) {
        Context r103 = com.ss.android.account.k.c();
        if (r103 != null) goto L5;
        j r104 = null;
    L6:
        if (r104 != null) goto L8;
        long r105 = -1;
    L9:
        int r106 = 0;
        Pair[] r107 = {TuplesKt.to("host", r100), TuplesKt.to("path", r101), TuplesKt.to(CronetDataStorageAccess.LOGID, r102), TuplesKt.to("sec_ts_age", Long.valueOf(r105)), TuplesKt.to("is_in_foreground", Integer.valueOf(com.bytedance.sdk.account.utils.d.d() ? 1 : 0))};
        JSONObject r108 = new JSONObject();
    L10:
        if (r106 >= 5) goto L12;
        Pair r109 = r107[r106];
        r108.putOpt((String) r109.getFirst(), r109.getSecond());
        r106 = r106 + 1;
        goto L10
    L12:
        com.bytedance.sdk.account.monitor.a.a("bd_ticket_guard_sec_ts_not_found", r108);
        return;
    L8:
        r105 = System.currentTimeMillis() - r104.f449757c;
        goto L9
    L5:
        r104 = b(r103);
        goto L6
    }

    public static boolean d(Context r210, String r211, String r212, long r213, long r214, long r215, String r310) {
        j r100 = f449751a;
        long r110 = 0;
        if (r100 == null) goto L5;
        long r101 = r100.f449756b;
    L7:
        if (r100 != null) goto L9;
    L12:
        int r111 = com.bytedance.sdk.account.time.e.a(r210);
        j r102 = new j(r212, r213, r215, r214, r111, r211, r310);
        f449751a = r102;
        SharedPreferences.Editor r103 = r210.getSharedPreferences("bd_account_sec_time", 0).edit();
        Pair[] r104 = {TuplesKt.to("secTime", r212), TuplesKt.to("serverTime", Long.valueOf(r213)), TuplesKt.to("systemTime", Long.valueOf(r215)), TuplesKt.to("elapsedRealTimeMs", Long.valueOf(r214)), TuplesKt.to("rebootTimes", Integer.valueOf(r111))};
        JSONObject r105 = new JSONObject();
        int r112 = 0;
    L13:
        if (r112 >= 5) goto L15;
        Pair r113 = r104[r112];
        r105.putOpt((String) r113.getFirst(), r113.getSecond());
        r112 = r112 + 1;
        goto L13
    L15:
        r103.putString("sec_time_struct", r105.toString()).apply();
        tb7.a.d("SecTimeManager", "updateSecTime, serverTimeMs: " + r213 + ", elapsedRealTime: " + r214 + ", systemTime: " + r215 + ", secTime: " + r212);
        if (r211 == null) goto L18;
        String r106 = r211;
    L19:
        String r107 = "";
        String r108 = r102.f449755a;
        long r114 = r102.f449756b;
        long r115 = r102.f449757c;
        long r109 = r102.f449758d;
        if (r100 == null) goto L24;
        String r116 = r100.f449755a;
        if (r116 == null) goto L24;
        r107 = r116;
    L24:
        if (r100 == null) goto L26;
        long r117 = r100.f449756b;
    L27:
        if (r100 == null) goto L29;
        long r118 = r100.f449757c;
    L30:
        if (r100 == null) goto L32;
        r110 = r100.f449758d;
    L32:
        Pair[] r119 = {TuplesKt.to("server_sec_ts", r108), TuplesKt.to("server_origin_ts", Long.valueOf(r114)), TuplesKt.to("local_ts", Long.valueOf(r115)), TuplesKt.to("local_system_run_ts", Long.valueOf(r109)), TuplesKt.to("last_server_sec_ts", r107), TuplesKt.to("last_server_origin_ts", Long.valueOf(r117)), TuplesKt.to("last_local_ts", Long.valueOf(r118)), TuplesKt.to("last_local_system_run_ts", Long.valueOf(r110)), TuplesKt.to("scene", "interceptor"), TuplesKt.to(CronetDataStorageAccess.LOGID, null), TuplesKt.to("path", r106)};
        JSONObject r120 = new JSONObject();
        int r121 = 0;
    L33:
        if (r121 >= 11) goto L35;
        Pair r122 = r119[r121];
        r120.put((String) r122.getFirst(), r122.getSecond());
        r121 = r121 + 1;
        goto L33
    L35:
        com.bytedance.sdk.account.monitor.a.a("bd_ticket_guard_sec_ts_update", r120);
        List<a> r123 = f449753c;
        monitor-enter(r123);
        Iterator r124 = ((ArrayList) r123).iterator();     // Catch: Throwable -> L45
    L39:
        if (r124.hasNext() == false) goto L41;
        ((a) r124.next()).a(r102, r100);     // Catch: Throwable -> L45
        goto L39
    L41:
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r123);
        return true;
    L45:
        th = move-exception;
        throw th;
    L29:
        r118 = 0;
        goto L30
    L26:
        r117 = 0;
        goto L27
    L18:
        r106 = "";
        goto L19
    L9:
        if (r213 > r101) goto L12;
        tb7.a.e("SecTimeManager", "updateSecTime aborted because server time recedes, serverTimeMs: " + r213 + ", lastServerTime: " + r101 + ", elapsedRealTime: " + r214 + ", systemTime: " + r215 + ", secTime: " + r212);
        return false;
    L5:
        r101 = 0;
        goto L7
    }
}
