package com.larus.bmhome.auth;

import androidx.core.os.BundleKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f295746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f295747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f295748c;

    public b1() {
    }

    static {
        f295747b = "";
        f295748c = true;
    }

    public static void c(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r102 & 4) == 0) goto L8;
        String r103 = "";
    L9:
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r103, "error");
        a(f295747b, r100, r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static void a(String r100, String r101, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r111, "error");
        if (f295748c == true) goto L5;
    L9:
        f295747b = r100;
        com.larus.platform.service.o.f365780a.b("rd_frontier_connection_stages", BundleKt.bundleOf(new Pair[]{TuplesKt.to("type", r100), TuplesKt.to("stage", r101), TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - f295746a)), TuplesKt.to("success", Integer.valueOf(r110 ? 1 : 0)), TuplesKt.to("type", r100), TuplesKt.to("error", r111)}));
        return;
    L5:
        if (Intrinsics.areEqual("connect_start", r101) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual("connect_end", r101) == false) goto L9;
    }

    public static /* synthetic */ void b(String r100, String r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r103 & 8) == 0) goto L8;
        String r104 = "";
    L9:
        a(r100, r101, r102, r104);
        return;
    L8:
        r104 = null;
        goto L9
    }
}
