package com.larus.dora.impl.log.g;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f336120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f336121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f336122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f336123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f336124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f336125f;

    static {
    }

    public static void a(int r100) {
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_stop_fetch", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("type", Integer.valueOf(f336120a))}), false, 12);
    }

    public static void b(int r100, long r101) {
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_upload_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("size", Long.valueOf(f336121b)), TuplesKt.to("duration", Long.valueOf(r101))}), false, 12);
    }
}
