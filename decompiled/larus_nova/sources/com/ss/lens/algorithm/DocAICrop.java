package com.ss.lens.algorithm;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class DocAICrop {
    private static boolean isLibLoaded;
    private static LibLoaderListener mLoaderListener;
    private static long mNativePtr;

    public interface LibLoaderListener {
        boolean onLoader(String r100);
    }

    public DocAICrop() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native Bitmap nativeDocAICrop(long r100, Bitmap r101, float[] r102);

    private static native long nativeDocAIInitCrop();

    private static native void nativeDocAIReleaseCrop(long r100);

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:36:0x0029). Please report as a decompilation issue!!! */
    public static synchronized boolean DocAIInitCrop() {
        monitor-enter(DocAICrop.class);
    L33:
        th = move-exception;
        throw th;
    L6:
        if (isLibLoaded == false) goto L37;
    L26:
        long r100 = nativeDocAIInitCrop();     // Catch: Throwable -> L33
        mNativePtr = r100;     // Catch: Throwable -> L33
        if (r100 != 0) goto L31;
        monitor-exit(DocAICrop.class);
        return false;
    L31:
        monitor-exit(DocAICrop.class);
        return true;
    L37:
        LibLoaderListener r101 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        if (r101 == null) goto L10;
        r101.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L36:
        LibLoaderListener r102 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
        if (r102 != null) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_DocAICrop_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L22 Throwable -> L33
    L21:
        isLibLoaded = true;     // Catch: Throwable -> L33
        goto L26
    L17:
        if (r102.onLoader("lens") == true) goto L21;
        monitor-exit(DocAICrop.class);
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        return false;
    L10:
        INVOKESTATIC_com_ss_lens_algorithm_DocAICrop_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
        INVOKESTATIC_com_ss_lens_algorithm_DocAICrop_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L33
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        goto L36
    }

    public static void DocAIReleaseCrop() {
        long r100 = mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeDocAIReleaseCrop(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_DocAICrop_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void setOutLoader(LibLoaderListener r100) {
        monitor-enter(DocAICrop.class);
        mLoaderListener = r100;     // Catch: Throwable -> L7
        monitor-exit(DocAICrop.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Bitmap DocAICrop(Bitmap r100, float[] r101) {
        long r102 = mNativePtr;
        if (r102 != 0) goto L7;
        return null;
    L7:
        return nativeDocAICrop(r102, r100, r101);
    }
}
