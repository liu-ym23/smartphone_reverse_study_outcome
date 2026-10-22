package com.bytedance.mira.plugin.classloader;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class NativeClassLoaderHelper {
    public static final int TYPE_HOST_CLASSLOADER = 4098;
    public static final int TYPE_MIRA_CLASSLOADER = 4097;
    public static final int TYPE_PLUGIN_CLASSLOADER = 4099;

    public NativeClassLoaderHelper() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native boolean initPluginSize(int r100);

    public static native boolean registerClassLoader(Object r100, int r101, int r102);

    public static native boolean startHook();

    public static native boolean stopHook();

    static {
        INVOKESTATIC_com_bytedance_mira_plugin_classloader_NativeClassLoaderHelper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("native_classloader");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_mira_plugin_classloader_NativeClassLoaderHelper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
