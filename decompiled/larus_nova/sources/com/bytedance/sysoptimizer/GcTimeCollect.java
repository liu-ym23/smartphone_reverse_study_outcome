package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class GcTimeCollect {
    private static final String TAG = "GcTimeCollect";
    private static boolean sInited;
    private static final Object sMutex = null;

    public GcTimeCollect() {
    }

    private static native int startCollect(boolean r100);

    static {
        sMutex = new Object();
    }

    private static boolean isTargetOSVersion() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 33) goto L7;
        return true;
    }

    public static boolean GcTimeCollectHook(Context r100) {
        Object r101 = sMutex;
        monitor-enter(r101);
        boolean r102 = false;
        if (sInited == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L24
        return false;
    L9:
        if (isTargetOSVersion() == true) goto L28;
        monitor-exit(r101);     // Catch: Throwable -> L24
        return false;
    L28:
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L24
        return r102;
    L13:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L15;
        ShadowHook.access$000();     // Catch: Exception -> L20 Throwable -> L24
        ShadowHook.access$100();     // Catch: Exception -> L20 Throwable -> L24
        int r103 = ShadowHook.Mode.SHARED.getValue();     // Catch: Exception -> L20 Throwable -> L24
        ShadowHook.b r104 = new ShadowHook.b();     // Catch: Exception -> L20 Throwable -> L24
        r104.f270294a = r103;     // Catch: Exception -> L20 Throwable -> L24
        r104.f270295b = true;     // Catch: Exception -> L20 Throwable -> L24
        r104.f270296c = false;     // Catch: Exception -> L20 Throwable -> L24
        r104.f270297d = false;     // Catch: Exception -> L20 Throwable -> L24
        ShadowHook.init(r104);     // Catch: Exception -> L20 Throwable -> L24
        sInited = true;     // Catch: Exception -> L20 Throwable -> L24
        boolean r105 = true;
    L16:
        if (startCollect(true) != 0) goto L22;
        r102 = r105;
        goto L22
    L15:
        r105 = false;
    L24:
        th = move-exception;
        throw th;
    }
}
