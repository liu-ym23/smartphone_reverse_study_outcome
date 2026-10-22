package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f197726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f197727b;

    static {
    }

    public static void a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = r100.getString(r101);
        long r103 = System.currentTimeMillis();
        if (Intrinsics.areEqual(r102, f197727b) == true) goto L5;
    L7:
        new zx3.a(r100, r102).d();
        f197727b = r102;
        f197726a = r103;
        return;
    L5:
        if ((r103 - f197726a) > 2000) goto L7;
    }
}
