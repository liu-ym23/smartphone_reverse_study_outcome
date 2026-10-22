package com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableOpenFastAddRecordMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f215602a = null;

    static {
        f215602a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_START", r101, false, 12);
        ((m) f215602a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_RETURN_META", r101, false, 12);
        ((m) f215602a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void b(String r100, long r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_FAIL", r101, false, 12);
        r102.addExtras(r110);
        ((m) f215602a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void c(String r100, long r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_META_SUCCESS", r101, false, 12);
        r102.addExtras(r110);
        ((m) f215602a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void e(String r100, long r101, final Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Lazy r103 = tu4.b.f547622a;
        tu4.b.k(r100, r101, new BitableOpenFastAddRecordMonitor$reportTTU$1(r102));
    }

    @JvmStatic
    public static final void f(String r100, long r101, final Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Lazy r103 = tu4.b.f547622a;
        tu4.b.l(r100, r101, new BitableOpenFastAddRecordMonitor$reportTTV$1(r102));
    }
}
