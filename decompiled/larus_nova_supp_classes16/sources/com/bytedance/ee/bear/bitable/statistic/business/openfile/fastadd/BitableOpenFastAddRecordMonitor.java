package com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableOpenFastAddRecordMonitor {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void a(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_START", r8, false, 12);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void d(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_RETURN_META", r8, false, 12);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void b(String r7, long r8, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_FAIL", r8, false, 12);
        r9.addExtras(r10);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void c(String r7, long r8, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_SUCCESS", r8, false, 12);
        r9.addExtras(r10);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void e(String r1, long r2, final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Lazy r0 = tu4.b.a;
        tu4.b.k(r1, r2, new BitableOpenFastAddRecordMonitor$reportTTU$1(r4));
    }

    @JvmStatic
    public static final void f(String r1, long r2, final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Lazy r0 = tu4.b.a;
        tu4.b.l(r1, r2, new BitableOpenFastAddRecordMonitor$reportTTV$1(r4));
    }
}
