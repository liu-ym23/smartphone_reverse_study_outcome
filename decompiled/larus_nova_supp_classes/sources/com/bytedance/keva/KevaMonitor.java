package com.bytedance.keva;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public void logDebug(String r1) {
    }

    public void reportEvent(HashMap<String, Object> r1) {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public void loadLibrary(String r1) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r1);
    }

    public void onLoadRepo(String r1, int r2) {
    }

    public void reportThrowable(int r1, String r2, String r3, Object r4, Throwable r5) {
        Objects.toString(r4);
        r5.getMessage();
    }

    public void reportWarning(int r1, String r2, String r3, Object r4, String r5) {
        Objects.toString(r4);
    }
}
