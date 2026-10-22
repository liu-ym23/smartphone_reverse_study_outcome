package com.lynx.textra;

import android.graphics.Paint;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class TTText {
    public static JavaFontManager mFontManager;
    public static Paint mPainter;
    private static boolean sInitialized;
    private static boolean sSelfRenderingPreloaded;

    public TTText() {
    }

    public static void Initial() {
        Initial(false);
    }

    public static boolean PreloadSelfRendering() {
        return PreloadSelfRendering(false);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native JavaFontManager nativeGetDefaultFontManager();

    private static native void nativeInitialCache();

    private static native boolean nativePreloadSelfRendering();

    static {
        mPainter = new Paint();
        mFontManager = null;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_textra_TTText_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void Initial(boolean r100) {
        monitor-enter(TTText.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sInitialized == false) goto L8;
        monitor-exit(TTText.class);
        return;
    L8:
        if (r100 == false) goto L10;
        INVOKESTATIC_com_lynx_textra_TTText_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("tttext_lite");     // Catch: Throwable -> L13
    L10:
        nativeInitialCache();     // Catch: Throwable -> L13
        mFontManager = nativeGetDefaultFontManager();     // Catch: Throwable -> L13
        sInitialized = true;     // Catch: Throwable -> L13
        monitor-exit(TTText.class);
    }

    public static synchronized boolean PreloadSelfRendering(boolean r100) {
        monitor-enter(TTText.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sSelfRenderingPreloaded == false) goto L9;
        monitor-exit(TTText.class);
        return true;
    L9:
        if (r100 == false) goto L11;
        INVOKESTATIC_com_lynx_textra_TTText_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("tttext_lite");     // Catch: Throwable -> L14
    L11:
        boolean r101 = nativePreloadSelfRendering();     // Catch: Throwable -> L14
        sSelfRenderingPreloaded = r101;     // Catch: Throwable -> L14
        monitor-exit(TTText.class);
        return r101;
    }
}
