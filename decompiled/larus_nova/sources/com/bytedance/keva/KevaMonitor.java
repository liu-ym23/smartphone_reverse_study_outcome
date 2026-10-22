package com.bytedance.keva;

import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public void logDebug(String r100) {
    }

    public void reportEvent(HashMap<String, Object> r100) {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public void loadLibrary(String r100) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
    }

    public void onLoadRepo(String r100, int r101) {
    }

    public void reportThrowable(int r100, String r101, String r102, Object r103, Throwable r104) {
        Objects.toString(r103);
        r104.getMessage();
    }

    public void reportWarning(int r100, String r101, String r102, Object r103, String r104) {
        Objects.toString(r103);
    }
}
