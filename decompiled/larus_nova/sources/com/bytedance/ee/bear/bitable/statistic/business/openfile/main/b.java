package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f215603a = null;

    static {
        f215603a = org.koin.java.a.d(m.class);
    }

    public static m b() {
        return (m) f215603a.getValue();
    }

    @JvmStatic
    public static final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Lazy r102 = tu4.b.f547622a;
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_AFTER_CLIENTVARS_LOADED_AND_SWITCH", r101, false, 12);
        tu4.b.c().addNormalPoint(r100, r103);
    }

    public static void a(String r100, String r101, Serializable r102) {
        if (r102 == null) goto L5;
        b().addTraceExtra(r100, r101, r102);
        return;
    }

    public static void c(String r100, long r101, String r102, final boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "traceId");
        a(r100, "docx_clientvar_from", r102);
        Lazy r105 = tu4.b.f547622a;
        tu4.b.l(r100, r101, new BitableOpenFileReportMainMonitor$reportOpenDocInBaseTTV$1(r103));
    }
}
