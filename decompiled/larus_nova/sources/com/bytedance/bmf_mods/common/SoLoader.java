package com.bytedance.bmf_mods.common;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class SoLoader {
    private static final SoLoader INSTANCE = null;
    private static boolean sIsSoInitialized;
    private Context appContext;

    private SoLoader() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INSTANCE = new SoLoader();
        INVOKESTATIC_com_bytedance_bmf_mods_common_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("hmp");     // Catch: Throwable -> L5
        INVOKESTATIC_com_bytedance_bmf_mods_common_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bmf_module_sdk");     // Catch: Throwable -> L5
        INVOKESTATIC_com_bytedance_bmf_mods_common_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bmf_hydra");     // Catch: Throwable -> L5
        sIsSoInitialized = true;     // Catch: Throwable -> L5
        Logging.d("Bmf so libraries are initialized. version = 2.52.1");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logging.e("Bmf so libraries are NOT initialized. version = 2.52.1 error msg = " + th.getMessage());
        sIsSoInitialized = false;
    }

    public static SoLoader getInstance() {
        return INSTANCE;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public boolean isSoInitialized() {
        return sIsSoInitialized;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bmf_mods_common_SoLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public void setContext(Context r100) {
        this.appContext = r100.getApplicationContext();
    }
}
