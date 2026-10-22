package com.larus.navigation.api;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f359687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f359688b;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "detail");
        long r102 = f359687a;
        if (r102 != 0) goto L5;
        return;
    L5:
        long r103 = SystemClock.elapsedRealtime() - r102;
        int r104 = c.f359656a;
        c.d("nav_launch_perf", "[" + r100 + "] key=" + f359688b + " elapsed=" + r103 + "ms " + r101);
    }
}
