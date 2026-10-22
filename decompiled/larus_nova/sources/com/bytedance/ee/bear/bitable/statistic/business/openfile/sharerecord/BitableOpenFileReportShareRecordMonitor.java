package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableOpenFileReportShareRecordMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f215604a = null;

    static {
        f215604a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void a(String r100, long r101, final Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Lazy r103 = tu4.b.f547622a;
        tu4.b.l(r100, r101, new BitableOpenFileReportShareRecordMonitor$reportOpenShareRecordTTV$1(r102));
    }
}
