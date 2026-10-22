package com.bytedance.mira.plugin.trip.opt;

import android.os.Build;

/* JADX INFO: loaded from: classes21.dex */
public class Crc32Opt {
    private static volatile boolean sResult;
    private static volatile boolean sState;

    public Crc32Opt() {
    }

    private static native boolean opt_crc32_native();

    public static boolean optZipExtraCrc32() {
        if (sState == true) goto L15;
        monitor-enter(Crc32Opt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sState == true) goto L9;
        sResult = safeRealOptZipExtraCrc32();     // Catch: Throwable -> L11
        sState = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(Crc32Opt.class);     // Catch: Throwable -> L11
    L15:
        return sResult;
    }

    private static boolean realOptZipExtraCrc32() {
        if (Build.VERSION.SDK_INT == 29) goto L7;
        return false;
    L7:
        return opt_crc32_native();
    }

    private static boolean safeRealOptZipExtraCrc32() {
        return realOptZipExtraCrc32();
    L4:
        return false;
    }
}
