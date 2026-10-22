package com.ss.videoarch.strategy.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class LibraryLoader {
    private static final String DEBUG_LIB_DIR = "live_strategy";
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String r100) throws Exception;

        void loadLibraryFromPath(String r100) throws Exception;
    }

    public LibraryLoader() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static boolean loadDebugLib(String r100, Context r101) {
        return false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_videoarch_strategy_utils_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void loadLibrary(String r100) throws Exception {
        Loader r101 = sLoader;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L6;
        r101.toString();
        r101.loadLibrary(r100);
        return;
    L6:
        INVOKESTATIC_com_ss_videoarch_strategy_utils_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        return;
    L9:
        throw new Exception("Invalid library name.");
    }

    public static void loadLibraryFromPath(String r100) throws Exception {
        Loader r101 = sLoader;
        if (TextUtils.isEmpty(r100) == true) goto L13;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L11;
        if (r101 == null) goto L8;
        r102.getAbsolutePath();
        r101.toString();
        r101.loadLibraryFromPath(r102.getAbsolutePath());
        return;
    L8:
        System.load(r102.getAbsolutePath());
        return;
    L11:
        throw new Exception("Not found library '" + r100 + "' file.");
    L13:
        throw new Exception("Invalid library name.");
    }

    public static void setupLibraryLoader(Loader r100) {
        sLoader = r100;
    }

    public static void loadLibrary(String r100, Context r101) throws Exception {
        Loader r102 = sLoader;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r102 == null) goto L6;
        r102.toString();
        r102.loadLibrary(r100);
        return;
    L6:
        INVOKESTATIC_com_ss_videoarch_strategy_utils_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        return;
    L9:
        throw new Exception("Invalid library name.");
    }
}
