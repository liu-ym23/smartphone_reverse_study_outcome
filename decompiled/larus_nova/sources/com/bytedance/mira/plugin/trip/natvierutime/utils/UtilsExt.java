package com.bytedance.mira.plugin.trip.natvierutime.utils;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class UtilsExt {
    private static final String TAG = "UtilsExt";
    private static volatile boolean sInit;

    public UtilsExt() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native boolean native_access(String r100, int r101);

    private static native boolean native_mkdir(String r100, int r101);

    private static native boolean native_symlink_exists(String r100);

    public static boolean init() {
        if (sInit == true) goto L15;
        monitor-enter(UtilsExt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInit == true) goto L9;
        sInit = initInternal();     // Catch: Throwable -> L11
    L9:
        monitor-exit(UtilsExt.class);     // Catch: Throwable -> L11
    L15:
        return sInit;
    }

    private static boolean initInternal() {
        INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_utils_UtilsExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("utils_ext");     // Catch: Throwable -> L4
        return true;
    L4:
        return false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_mira_plugin_trip_natvierutime_utils_UtilsExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean symlinkExists(String r100) {
        return native_symlink_exists(r100);
    }

    public static boolean access(String r100, int r101) {
        if (sInit == true) goto L7;
        return false;
    L7:
        return native_access(r100, r101);
    }

    public static boolean mkdir(String r100, int r101) {
        return native_mkdir(r100, r101);
    }
}
