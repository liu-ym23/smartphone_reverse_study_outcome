package com.bytedance.sysoptimizer;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class SysOptimizerEarly {
    private static final String TAG = "SysOptimizerEarly";
    private static volatile boolean mOptimizerEarlyLibLoaded;

    public SysOptimizerEarly() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_sysoptimizer_SysOptimizerEarly_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean loadOptimizerLibrary(Context r100) {
        if (mOptimizerEarlyLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizerEarly.class);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (mOptimizerEarlyLibLoaded == false) goto L23;
        monitor-exit(SysOptimizerEarly.class);     // Catch: Throwable -> L20
        return true;
    L23:
        if (r100 != null) goto L13;
        INVOKESTATIC_com_bytedance_sysoptimizer_SysOptimizerEarly_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sysoptimizer_early");     // Catch: Throwable -> L17
    L14:
        mOptimizerEarlyLibLoaded = true;     // Catch: Throwable -> L17
        monitor-exit(SysOptimizerEarly.class);     // Catch: Throwable -> L20
        return true;
        goto L18
    L13:
        com.bytedance.librarian.a.d("sysoptimizer_early", r100);     // Catch: Throwable -> L17
    L18:
        return false;
    }
}
