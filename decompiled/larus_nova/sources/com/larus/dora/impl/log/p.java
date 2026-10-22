package com.larus.dora.impl.log;

import com.larus.dora.impl.DoraBuryPointManager;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f336142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f336143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f336144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f336145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f336146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f336147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f336148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f336149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f336150i;

    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return "assert";
    L5:
        if (r100 != 2) goto L7;
        return "point";
    L7:
        if (r100 == 3) goto L9;
        return "unknown";
    L9:
        return "key";
    }

    static {
        f336143b = "";
        f336144c = "";
    }

    public static void c(int r100) {
        DoraBuryPointManager r101 = DoraBuryPointManager.f331862a;
        Pair[] r102 = new Pair[5];
        r102[0] = TuplesKt.to("result", Integer.valueOf(r100));
        r102[1] = TuplesKt.to("type", a(f336147f));
        if (f336145d != 0) goto L5;
        String r103 = "R";
    L6:
        r102[2] = TuplesKt.to("side", r103);
        r102[3] = TuplesKt.to("total_size", Integer.valueOf(f336146e));
        r102[4] = TuplesKt.to("offset_size", Long.valueOf(f336149h));
        DoraBuryPointManager.J(r101, "log_get_log_info_result", MapsKt.mapOf(r102), false, 12);
        return;
    L5:
        r103 = "L";
        goto L6
    }

    public static void e(int r100) {
        if (f336150i == true) goto L5;
        return;
    L5:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_switch_buds_role_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("switch_type", f336144c)}), false, 12);
        f336150i = false;
    }

    public static void d(int r100, int r110) {
        long r101 = System.currentTimeMillis() - f336142a;     // Catch: Exception -> L8
        long r102 = ((long) f336148g) - f336149h;     // Catch: Exception -> L8
        String r103 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((Math.abs(r102) * ((double) 1000)) / r101) / ((double) 1024))}, 1));     // Catch: Exception -> L8
        Pair[] r104 = new Pair[11];     // Catch: Exception -> L8
        r104[0] = TuplesKt.to("result", Integer.valueOf(r100));     // Catch: Exception -> L8
        r104[1] = TuplesKt.to("type", a(f336147f));     // Catch: Exception -> L8
        if (f336145d != 0) goto L5;
        String r105 = "R";
    L6:
        r104[2] = TuplesKt.to("side", r105);     // Catch: Exception -> L8
        r104[3] = TuplesKt.to("trigger_type", f336143b);     // Catch: Exception -> L8
        r104[4] = TuplesKt.to("duration", Long.valueOf(r101));     // Catch: Exception -> L8
        r104[5] = TuplesKt.to("total_size", Integer.valueOf(f336146e));     // Catch: Exception -> L8
        r104[6] = TuplesKt.to("get_size", Integer.valueOf(f336148g));     // Catch: Exception -> L8
        r104[7] = TuplesKt.to(EventConstant.Value.RETRY, Integer.valueOf(r110));     // Catch: Exception -> L8
        r104[8] = TuplesKt.to("offset_size", Long.valueOf(f336149h));     // Catch: Exception -> L8
        r104[9] = TuplesKt.to("append_size", Long.valueOf(r102));     // Catch: Exception -> L8
        r104[10] = TuplesKt.to("pull_rate", r103);     // Catch: Exception -> L8
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_get_result", MapsKt.mapOf(r104), false, 12);     // Catch: Exception -> L8
        return;
    L5:
        r105 = "L";
    L8:
        e = move-exception;
        g49.d.b("LogEventReporter", "onGetLogResult error " + e);
    }

    public static void b(int r100, int r101, int r102) {
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_clear_log_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("side", Integer.valueOf(r101)), TuplesKt.to("type", a(r102))}), false, 12);
    }

    public static void f(int r100, int r101, long r102) {
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_upload_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("size", Integer.valueOf(r101)), TuplesKt.to("duration", Long.valueOf(r102))}), false, 12);
    }
}
