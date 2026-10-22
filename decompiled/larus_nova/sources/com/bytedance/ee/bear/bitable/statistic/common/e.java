package com.bytedance.ee.bear.bitable.statistic.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215628a = 0;

    static {
    }

    public static HashMap b(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "timeStamps");
        Intrinsics.checkNotNullParameter(r101, "startKey");
        HashMap r102 = new HashMap();
        HashMap r103 = (HashMap) r100;
        Serializable r104 = (Serializable) r103.get(r101);
        if ((r104 instanceof Long) == true) goto L6;
        c("BitableStatisticExtend", "StageDuration startTime is invalid: " + r101 + ' ' + r104);
        return r102;
    L6:
        Iterator r105 = r103.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L14;
        Map.Entry r106 = (Map.Entry) r105.next();
        Serializable r107 = (Serializable) r106.getValue();
        if (Intrinsics.areEqual(r106.getKey(), r101) == true) goto L8;
        if ((r107 instanceof Long) == false) goto L8;
        r102.put(r106.getKey(), Long.valueOf(((Number) r107).longValue() - ((Number) r104).longValue()));
        goto L8
    L14:
        return r102;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        tt5.a.d("BitableStatistic", r100 + ' ' + r101);
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        tt5.a.k("BitableStatistic", r100 + ' ' + r101);
    }

    public static Long a(Map r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "timeStamps");
        Intrinsics.checkNotNullParameter(r101, "startKey");
        Intrinsics.checkNotNullParameter(r102, "endKey");
        HashMap r103 = (HashMap) r100;
        Serializable r104 = (Serializable) r103.get(r101);
        Serializable r105 = (Serializable) r103.get(r102);
        if ((r104 instanceof Long) == true) goto L5;
        return null;
    L5:
        if ((r105 instanceof Long) == false) goto L12;
        long r106 = ((Number) r105).longValue() - ((Number) r104).longValue();
        if (r106 > 0) goto L9;
        return null;
    L9:
        return Long.valueOf(r106);
    L12:
        return null;
    }

    public static void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "tr");
        tt5.a.d("BitableStatistic", r100 + ' ' + r101 + ": " + ExceptionsKt.stackTraceToString(r102));
    }
}
