package com.bytedance.tailor;

import android.os.Debug;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class Tailor {
    public Tailor() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native void closeTailor();

    private static native void openTailor(String r100, boolean r101);

    public static native void tailorHprof(String r100, String r101);

    static {
        INVOKESTATIC_com_bytedance_tailor_Tailor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("tailor");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_tailor_Tailor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean isHprofValid(String r100) {
        boolean r101 = false;
        RandomAccessFile r102 = null;
        RandomAccessFile r103 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L11
        r103.seek(r103.length() - 9);     // Catch: Throwable -> L10
        if (r103.readByte() != 44) goto L23;
        r101 = true;
    L23:
        r103.close();     // Catch: Throwable -> L15
    L9:
        return r101;
    L10:
        r102 = r103;
    L12:
        if (r102 != null) goto L21;
    L14:
        return false;
    L21:
        r102.close();     // Catch: Throwable -> L16
        goto L14
    }

    public static void dumpHprofData(String r100, boolean r101) throws IOException {
        openTailor(r100, r101);
        Debug.dumpHprofData(r100);
        closeTailor();
    }
}
