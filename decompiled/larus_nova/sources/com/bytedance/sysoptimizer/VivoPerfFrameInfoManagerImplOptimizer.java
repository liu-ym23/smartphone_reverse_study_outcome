package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;

/* JADX INFO: loaded from: classes22.dex */
public class VivoPerfFrameInfoManagerImplOptimizer {
    private static final String TAG = "VivoPerfDebugDump";
    private static boolean sOptimized;

    public VivoPerfFrameInfoManagerImplOptimizer() {
    }

    private static native boolean optimize();

    public static synchronized void fix(Context r100) {
        monitor-enter(VivoPerfFrameInfoManagerImplOptimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == false) goto L8;
        monitor-exit(VivoPerfFrameInfoManagerImplOptimizer.class);
        return;
    L8:
        String r101 = Build.MODEL.toLowerCase().trim();     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT >= 27) goto L11;
    L17:
        monitor-exit(VivoPerfFrameInfoManagerImplOptimizer.class);
        return;
    L11:
        if (r101.contains(DimLocationCheckUtil.VIVO) == true) goto L15;
        if (r101.contains(AppConstants.CHANNEL_OPPO) == false) goto L17;
    L15:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L17;
        optimize();     // Catch: Throwable -> L22 Throwable -> L19
        sOptimized = true;     // Catch: Throwable -> L22 Throwable -> L19
        goto L17
    }
}
