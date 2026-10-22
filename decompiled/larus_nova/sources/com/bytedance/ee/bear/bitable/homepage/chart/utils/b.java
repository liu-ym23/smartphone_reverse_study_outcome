package com.bytedance.ee.bear.bitable.homepage.chart.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f212635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f212636b = 0;

    static {
        f212635a = -1;
    }

    public static long a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r101 = f212635a;
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        ActivityManager.MemoryInfo r102 = new ActivityManager.MemoryInfo();
        Object r103 = r100.getSystemService("activity");
        if ((r103 instanceof ActivityManager) == false) goto L8;
        ActivityManager r104 = (ActivityManager) r103;
    L9:
        if (r104 != null) goto L11;
        return -1;
    L11:
        r104.getMemoryInfo(r102);
        f212635a = r102.totalMem;
        tt5.a.h("ChartMemoryUtil", "total mem is " + f212635a);
        return f212635a;
    L8:
        r104 = null;
        goto L9
    }
}
