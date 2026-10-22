package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableOpenFileReportShareRecordMonitor {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void a(String r1, long r2, final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Lazy r0 = tu4.b.a;
        tu4.b.l(r1, r2, new BitableOpenFileReportShareRecordMonitor$reportOpenShareRecordTTV$1(r4));
    }
}
