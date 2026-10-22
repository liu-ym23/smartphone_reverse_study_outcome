package com.bytedance.sysoptimizer;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class SysOptimizer {
    private static final String TAG = "SYSOPTIMIZER";
    private static boolean mHookRefreshed;
    private static ArrayList<UnsatisfiedLinkError> mLoadError;
    private static volatile boolean mOptimzerLibLoaded;

    public SysOptimizer() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native void refreshHook();

    private static native void reservedForJniOffset();

    static {
        mLoadError = new ArrayList();
        mHookRefreshed = false;
    }

    public static synchronized void hookOptimizerEnable() {
        monitor-enter(SysOptimizer.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (mOptimzerLibLoaded == true) goto L7;
    L12:
        monitor-exit(SysOptimizer.class);
        return;
    L7:
        if (mHookRefreshed == true) goto L12;
        refreshHook();     // Catch: UnsatisfiedLinkError -> L17 Throwable -> L14
        mHookRefreshed = true;     // Catch: UnsatisfiedLinkError -> L17 Throwable -> L14
    L10:
        monitor-exit(SysOptimizer.class);
    }

    public static ArrayList<UnsatisfiedLinkError> getLoadLibraryError() {
        return mLoadError;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_sysoptimizer_SysOptimizer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean activeMethod(Method r100) {
        if ((r100.getModifiers() & 8) != 0) goto L11;
    L8:
        return true;
    L11:
        if (r100.getParameterCount() != 0) goto L7;
        r100.setAccessible(true);     // Catch: Throwable -> L9
        r100.invoke(null, new Object[]{0});     // Catch: Throwable -> L9
    L10:
        goto L8
    L7:
        r100.setAccessible(true);     // Catch: Throwable -> L9
        r100.invoke(null, new Object[0]);     // Catch: Throwable -> L9
        goto L10
    }

    public static boolean loadOptimizerLibrary(Context r100) {
        if (mOptimzerLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizer.class);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (mOptimzerLibLoaded == false) goto L28;
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L24
        return true;
    L28:
        if (r100 != null) goto L14;
        INVOKESTATIC_com_bytedance_sysoptimizer_SysOptimizer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sysoptimizer");     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L20 Throwable -> L24
    L15:
        reservedForJniOffset();     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L20 Throwable -> L24
        mOptimzerLibLoaded = true;     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L20 Throwable -> L24
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L24
        return true;
        goto L19
    L14:
        com.bytedance.librarian.a.d("sysoptimizer", r100);     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L20 Throwable -> L24
    L20:
        e = move-exception;
        mLoadError.add(e);     // Catch: Throwable -> L24
        return false;
    L19:
        return false;
    }
}
