package hsa;

import com.larus.utils.logger.FLogger;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class a {
    private static String failedReason;
    private static boolean loadSuccess;

    public a() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static void setLoadSuccess() {
        loadSuccess = true;
    }

    static {
        INVOKESTATIC_com_ss_android_bytedcert_cvlibrary_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("smash");     // Catch: Throwable -> L4
        System.err.println("FaceLivess: library load!");     // Catch: Throwable -> L4
        loadSuccess = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        System.err.println("WARNING: FaceLivess Could not load library!");
        th.printStackTrace();
        StringWriter r100 = new StringWriter();
        r100.append(a.class.getClassLoader().toString()).append("\n");
        PrintWriter r101 = new PrintWriter(r100);
        th.printStackTrace(r101);
        failedReason = r100.toString();
        r101.close();
    }

    public static String getFailedReason() {
        return failedReason;
    }

    public static boolean isLoadSuccess() {
        return loadSuccess;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_android_bytedcert_cvlibrary_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
