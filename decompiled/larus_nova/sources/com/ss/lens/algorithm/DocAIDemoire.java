package com.ss.lens.algorithm;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class DocAIDemoire {
    private static boolean isLibLoaded;
    private static LibLoaderListener mLoaderListener;
    private static long mNativePtr;

    public interface LibLoaderListener {
        boolean onLoader(String r100);
    }

    public DocAIDemoire() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native Bitmap nativeDocAIDemoire(long r100, Bitmap r101);

    private static native long nativeDocAIInitDemoire(String r100, String r101);

    private static native void nativeDocAIReleaseDemoire(long r100);

    public static void DocAIReleaseDemoire() {
        long r100 = mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeDocAIReleaseDemoire(r100);
    }

    public static Bitmap DocAIDemoire(Bitmap r100) {
        long r101 = mNativePtr;
        if (r101 != 0) goto L7;
        return null;
    L7:
        return nativeDocAIDemoire(r101, r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_DocAIDemoire_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void setOutLoader(LibLoaderListener r100) {
        monitor-enter(DocAIDemoire.class);
        mLoaderListener = r100;     // Catch: Throwable -> L7
        monitor-exit(DocAIDemoire.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:36:0x0029). Please report as a decompilation issue!!! */
    public static synchronized boolean DocAIInitDemoire(String r100, String r101) {
        monitor-enter(DocAIDemoire.class);
    L33:
        th = move-exception;
        throw th;
    L6:
        if (isLibLoaded == false) goto L37;
    L26:
        long r102 = nativeDocAIInitDemoire(r100, r101);     // Catch: Throwable -> L33
        mNativePtr = r102;     // Catch: Throwable -> L33
        if (r102 != 0) goto L31;
        monitor-exit(DocAIDemoire.class);
        return false;
    L31:
        monitor-exit(DocAIDemoire.class);
        return true;
    L37:
        LibLoaderListener r103 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        if (r103 == null) goto L10;
        r103.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L36:
        LibLoaderListener r104 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
        if (r104 != null) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_DocAIDemoire_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
    L21:
        isLibLoaded = true;     // Catch: Throwable -> L33
        goto L26
    L17:
        if (r104.onLoader("lens") == true) goto L21;
        monitor-exit(DocAIDemoire.class);
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        return false;
    L10:
        INVOKESTATIC_com_ss_lens_algorithm_DocAIDemoire_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        INVOKESTATIC_com_ss_lens_algorithm_DocAIDemoire_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        goto L36
    }
}
