package com.ss.mediakit.vcnlib;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class VcnlibloadWrapper {
    private static boolean isVcnload;
    private static boolean isVcnverifyLiteload;
    private static boolean isVcnverifyload;

    public VcnlibloadWrapper() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static boolean tryLoadVcnlib() {
        monitor-enter(VcnlibloadWrapper.class);
        boolean r100 = true;
        if (isVcnload == false) goto L18;
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L15
        return true;
    L18:
        INVOKESTATIC_com_ss_mediakit_vcnlib_VcnlibloadWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("vcn");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        isVcnload = r100;     // Catch: Throwable -> L15
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L15
        return r100;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L15
        r100 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean tryLoadVcnverifyLitelib() {
        monitor-enter(VcnlibloadWrapper.class);
        boolean r100 = true;
        if (isVcnverifyLiteload == false) goto L18;
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L15
        return true;
    L18:
        INVOKESTATIC_com_ss_mediakit_vcnlib_VcnlibloadWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("vcnverifylite");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
        CustomVerify.init();     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        isVcnverifyLiteload = r100;     // Catch: Throwable -> L15
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L15
        return r100;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L15
        r100 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean tryLoadVcnverifylib() {
        monitor-enter(VcnlibloadWrapper.class);
        boolean r100 = true;
        if (isVcnverifyload == false) goto L24;
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L21
        return true;
    L24:
        INVOKESTATIC_com_ss_mediakit_vcnlib_VcnlibloadWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("vcnverify");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L21
        boolean r101 = true;
    L13:
        isVcnverifyload = r101;     // Catch: Throwable -> L21
        if (r101 == false) goto L16;
    L19:
        monitor-exit(VcnlibloadWrapper.class);     // Catch: Throwable -> L21
        return r100;
    L16:
        if (tryLoadVcnverifyLitelib() == true) goto L19;
        r100 = false;
        goto L19
    L11:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L21
        r101 = false;
    L21:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_mediakit_vcnlib_VcnlibloadWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
