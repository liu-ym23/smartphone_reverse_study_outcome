package com.lynx.base;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.base.log.LynxLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseEnv {
    private static LynxBaseEnv sInstance;
    private volatile boolean mIsNativeLibraryLoaded;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static LynxBaseEnv inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxBaseEnv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxBaseEnv();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxBaseEnv.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private LynxBaseEnv() {
        this.mIsNativeLibraryLoaded = false;
    }

    public boolean isNativeLibraryLoaded() {
        return this.mIsNativeLibraryLoaded;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_base_LynxBaseEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public synchronized boolean loadNativeTraceLibrary(IBaseNativeLibraryLoader r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsNativeLibraryLoaded == false) goto L20;
        boolean r101 = this.mIsNativeLibraryLoaded;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r101;
    L20:
        if (r100 == null) goto L10;
        r100.loadLibrary("lynxbase");     // Catch: Exception -> L14 Throwable -> L17
    L11:
        monitor-exit(this);
        return true;
    L10:
        INVOKESTATIC_com_lynx_base_LynxBaseEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxbase");     // Catch: Exception -> L14 Throwable -> L17
    L15:
        return false;
    }

    public boolean init(IBaseNativeLibraryLoader r100, boolean r101) {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        this.mIsNativeLibraryLoaded = loadNativeTraceLibrary(r100);
    L5:
        LynxLog.initLynxLog(r101);
        LynxBaseTrace.init();
        return true;
    }
}
