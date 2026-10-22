package com.bytedance.ee.bear.bitable.statistic.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap b(Map r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "timeStamps");
        Intrinsics.checkNotNullParameter(r8, "startKey");
        HashMap r0 = new HashMap();
        HashMap r9 = (HashMap) r7;
        Serializable r1 = (Serializable) r9.get(r8);
        if ((r1 instanceof Long) == true) goto L6;
        c("BitableStatisticExtend", "StageDuration startTime is invalid: " + r8 + ' ' + r1);
        return r0;
    L6:
        Iterator r10 = r9.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r10.next();
        Serializable r3 = (Serializable) r2.getValue();
        if (Intrinsics.areEqual(r2.getKey(), r8) == true) goto L8;
        if ((r3 instanceof Long) == false) goto L8;
        r0.put(r2.getKey(), Long.valueOf(((Number) r3).longValue() - ((Number) r1).longValue()));
        goto L8
    L14:
        return r0;
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        tt5.a.d("BitableStatistic", r1 + ' ' + r2);
    }

    public static void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        tt5.a.k("BitableStatistic", r1 + ' ' + r2);
    }

    public static Long a(Map r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "timeStamps");
        Intrinsics.checkNotNullParameter(r3, "startKey");
        Intrinsics.checkNotNullParameter(r4, "endKey");
        HashMap r5 = (HashMap) r2;
        Serializable r6 = (Serializable) r5.get(r3);
        Serializable r7 = (Serializable) r5.get(r4);
        if ((r6 instanceof Long) == true) goto L5;
        return null;
    L5:
        if ((r7 instanceof Long) == false) goto L12;
        long r0 = ((Number) r7).longValue() - ((Number) r6).longValue();
        if (r0 > 0) goto L9;
        return null;
    L9:
        return Long.valueOf(r0);
    L12:
        return null;
    }

    public static void d(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "tr");
        tt5.a.d("BitableStatistic", r1 + ' ' + r2 + ": " + ExceptionsKt.stackTraceToString(r3));
    }
}
