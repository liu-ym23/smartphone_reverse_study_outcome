package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    public static m b() {
        return (m) a.getValue();
    }

    @JvmStatic
    public static final void d(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "traceId");
        Lazy r1 = tu4.b.a;
        Intrinsics.checkNotNullParameter(r8, "traceId");
        BitableStatisticEventModel$NormalPointModel r10 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_AFTER_CLIENTVARS_LOADED_AND_SWITCH", r9, false, 12);
        tu4.b.c().addNormalPoint(r8, r10);
    }

    public static void a(String r1, String r2, Serializable r3) {
        if (r3 == null) goto L5;
        b().addTraceExtra(r1, r2, r3);
        return;
    }

    public static void c(String r1, long r2, String r4, final boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = false;
    L8:
        Intrinsics.checkNotNullParameter(r1, "traceId");
        a(r1, "docx_clientvar_from", r4);
        Lazy r7 = tu4.b.a;
        tu4.b.l(r1, r2, new BitableOpenFileReportMainMonitor$reportOpenDocInBaseTTV$1(r5));
    }
}
