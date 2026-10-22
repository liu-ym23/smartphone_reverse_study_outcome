package com.bytedance.mira.plugin.trip.opt;

import android.os.Build;

/* JADX INFO: loaded from: classes21.dex */
public class RegisterDexFileOpt {
    private static volatile boolean sResult;
    private static volatile boolean sState;

    public RegisterDexFileOpt() {
    }

    private static native boolean native_opt_register_dex_file();

    public static boolean optRegisterDexFile() {
        if (sState == true) goto L15;
        monitor-enter(RegisterDexFileOpt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sState == true) goto L9;
        sResult = optRegisterDexFileWithLock();     // Catch: Throwable -> L11
        sState = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(RegisterDexFileOpt.class);     // Catch: Throwable -> L11
    L15:
        return sResult;
    }

    private static boolean optRegisterDexFileWithLock() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 34) goto L5;
        return false;
    L5:
        if (r100 <= 35) goto L8;
        return false;
    L8:
        return native_opt_register_dex_file();
    }
}
