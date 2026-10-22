package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public class MTKArcDispatcherOptimizer {
    private static final String TAG = "OppoMTKArcDispatcher";
    private static boolean sOptimized;

    public MTKArcDispatcherOptimizer() {
    }

    private static native void banMTKArcDispatcher();

    public static void fix(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 == 28) goto L6;
        return;
    L6:
        if (sOptimized == false) goto L9;
        return;
    L9:
        if (Build.BRAND.toLowerCase(Locale.ROOT).contains(AppConstants.CHANNEL_OPPO) == true) goto L12;
        return;
    L12:
        if (r101 >= 23) goto L14;
        return;
    L14:
        if (Process.is64Bit() == true) goto L17;
        return;
    L17:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L24;
        banMTKArcDispatcher();     // Catch: Throwable -> L20
        sOptimized = true;     // Catch: Throwable -> L20
        return;
    L25:
        return;
    }
}
