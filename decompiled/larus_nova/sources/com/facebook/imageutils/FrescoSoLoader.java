package com.facebook.imageutils;

import android.content.Context;
import com.bytedance.librarian.a;
import com.facebook.common.logging.FLog;
import com.facebook.soloader.SoLoader;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class FrescoSoLoader {
    private static final Class<?> TAG = null;
    private static volatile boolean sInitialized;
    private static SoLoaderHandler sSoLoaderHandler;

    public interface SoLoaderHandler {
        void loadLibrary(String r100);
    }

    public FrescoSoLoader() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        TAG = FrescoSoLoader.class;
        sInitialized = false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_facebook_imageutils_FrescoSoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void initSoLoader(Context r100) {
        if (sSoLoaderHandler == null) goto L12;
        sInitialized = true;
        return;
    L12:
        SoLoader.init(r100, 0);     // Catch: Throwable -> L9
        sInitialized = true;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLog.w(TAG, th, "Could not initialize SoLoader", new Object[0]);
    }

    public static void loadLibrary(String r100) {
        if (sInitialized == true) goto L13;
    L11:
        INVOKESTATIC_com_facebook_imageutils_FrescoSoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        return;
    L13:
        SoLoaderHandler r101 = sSoLoaderHandler;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.loadLibrary(r100);     // Catch: Throwable -> L9
        return;
    L7:
        SoLoader.loadLibrary(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLog.w(TAG, th, "loadLibrary fail", new Object[0]);
        goto L11
    }

    public static void setSoLoaderHandler(SoLoaderHandler r100) {
        sSoLoaderHandler = r100;
    }
}
