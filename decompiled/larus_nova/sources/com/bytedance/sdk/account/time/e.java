package com.bytedance.sdk.account.time;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f269517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f269518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f269519c;

    static {
        f269519c = -1;
    }

    public static int a(Context r100) {
        if (f269519c < 0) goto L16;
        return f269519c;
    L16:
    L13:
        th = move-exception;
        tb7.a.c("SystemInfoManager", "getSystemBootTimes throws exception", th);
        return -1;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        int r101 = Settings.Global.getInt(r100.getContentResolver(), "boot_count");     // Catch: Throwable -> L13
    L11:
        f269519c = r101;     // Catch: Throwable -> L13
        return r101;
    L10:
        r101 = -1;
        goto L11
    }

    public static boolean b(Context r100, long r101) {
        if (f269517a > 0) goto L5;
    L19:
        boolean r102 = true;
        if (Settings.Global.getInt(r100.getContentResolver(), "auto_time") == 1) goto L17;
    L16:
        r102 = false;
    L17:
        f269517a = r101;
        f269518b = r102;
        return r102;
    L14:
        th = move-exception;
        tb7.a.c("SystemInfoManager", "isSystemTimeSyncWithNetwork throws exception", th);
        goto L16
    L5:
        if (r101 <= f269517a) goto L19;
        if ((r101 - f269517a) > 1800000) goto L19;
        return f269518b;
    }
}
