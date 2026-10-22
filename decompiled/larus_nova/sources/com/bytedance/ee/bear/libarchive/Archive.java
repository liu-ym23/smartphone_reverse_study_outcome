package com.bytedance.ee.bear.libarchive;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class Archive {
    public Archive() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native int extractAll(String r100, String r101, String r102, int r103) throws IOException;

    public static native int extractEntry(String r100, String r101, String r102, String r103, int r104) throws IOException;

    public static native String extractEntryToString(String r100, String r101, String r102) throws IOException;

    public static native List<ArchiveEntry> getFileList(String r100) throws IOException;

    public static native boolean isEncrypted(String r100) throws IOException;

    static {
        INVOKESTATIC_com_bytedance_ee_bear_libarchive_Archive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("archive");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_ee_bear_libarchive_Archive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
