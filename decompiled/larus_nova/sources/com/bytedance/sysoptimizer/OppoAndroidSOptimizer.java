package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public class OppoAndroidSOptimizer {
    private static final String TAG = "OppoAndroidSOptimizer";
    private static boolean sOptimized;

    public OppoAndroidSOptimizer() {
    }

    private static native void optimizeConfigOplusVppType();

    private static native void optimizeInitAudioSchedBoost();

    public static synchronized void fix(Context r100, boolean r101, boolean r102) {
        monitor-enter(OppoAndroidSOptimizer.class);
        if (r101 == true) goto L44;
        if (r102 == true) goto L44;
        monitor-exit(OppoAndroidSOptimizer.class);
        return;
    L44:
    L40:
        th = move-exception;
        throw th;
    L9:
        if (sOptimized == false) goto L12;
        monitor-exit(OppoAndroidSOptimizer.class);
        return;
    L12:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L40
        if (r103 != 31) goto L16;
    L19:
        String r104 = Build.BRAND.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L40
        if (r104.contains(AppConstants.CHANNEL_OPPO) == true) goto L26;
        if (r104.contains("realme") == true) goto L26;
        monitor-exit(OppoAndroidSOptimizer.class);
        return;
    L26:
        if (r103 < 23) goto L32;
        if (Process.is64Bit() == true) goto L32;
        monitor-exit(OppoAndroidSOptimizer.class);
        return;
    L32:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L38;
        if (r101 == true) goto L46;
    L35:
        if (r102 == false) goto L37;
        optimizeConfigOplusVppType();     // Catch: Throwable -> L43 Throwable -> L40
    L37:
        sOptimized = true;     // Catch: Throwable -> L43 Throwable -> L40
        goto L38
    L46:
        optimizeInitAudioSchedBoost();     // Catch: Throwable -> L43 Throwable -> L40
    L38:
        monitor-exit(OppoAndroidSOptimizer.class);
        return;
    L16:
        if (r103 == 32) goto L19;
        monitor-exit(OppoAndroidSOptimizer.class);
    }
}
