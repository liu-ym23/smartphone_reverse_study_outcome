package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.librarian.a;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class QAPEBooster {
    private static boolean sInited = false;
    private static volatile QAPEBooster sInstance = null;
    private static int sTargetFPS = 60;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native void boost_cpu(int r100);

    private native void boost_gpu(int r100);

    private native void common_cmd_set(int r100, int r101);

    private native int init(int r100);

    private native void start_scenario(String r100);

    private native void stop_scenario(String r100);

    private QAPEBooster(Context r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        if (Process.is64Bit() == true) goto L8;
        return;
    L8:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L17;
        INVOKESTATIC_com_bytedance_sysoptimizer_perflock_QAPEBooster_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sysoptimizer_qape");     // Catch: Exception -> L13
        if (init(sTargetFPS) <= (-1)) goto L18;
        sInited = true;     // Catch: Exception -> L13
        return;
    L18:
        return;
    L20:
        return;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_sysoptimizer_perflock_QAPEBooster_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static QAPEBooster getInstance(Context r100) {
        if (sInstance != null) goto L13;
        monitor-enter(QAPEBooster.class);
        sInstance = new QAPEBooster(r100);     // Catch: Throwable -> L9
        monitor-exit(QAPEBooster.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    public void boostCPU(int r100) {
        if (sInited == false) goto L6;
        boost_cpu(r100);
        return;
    }

    public void boostGPU(int r100) {
        if (sInited == false) goto L6;
        boost_gpu(r100);
        return;
    }

    public void startScenario(String r100) {
        if (sInited == false) goto L6;
        start_scenario(r100);
        return;
    }

    public void stopScenario(String r100) {
        if (sInited == false) goto L6;
        stop_scenario(r100);
        return;
    }

    public void commonCommandSet(int r100, int r101) {
        if (sInited == false) goto L6;
        common_cmd_set(r100, r101);
        return;
    }
}
