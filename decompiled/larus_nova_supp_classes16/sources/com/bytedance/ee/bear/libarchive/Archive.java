package com.bytedance.ee.bear.libarchive;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Archive {
    public Archive() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native int extractAll(String r0, String r1, String r2, int r3) throws IOException;

    public static native int extractEntry(String r0, String r1, String r2, String r3, int r4) throws IOException;

    public static native String extractEntryToString(String r0, String r1, String r2) throws IOException;

    public static native List<ArchiveEntry> getFileList(String r0) throws IOException;

    public static native boolean isEncrypted(String r0) throws IOException;

    static {
        INVOKESTATIC_com_bytedance_ee_bear_libarchive_Archive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("archive");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_ee_bear_libarchive_Archive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
