package com.volcengine.zeus.dex;

import android.os.Build;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public class DirectDex {
    public DirectDex() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native boolean native_init(int r100);

    public static native Object native_load_direct_dex(String r100);

    static {
        INVOKESTATIC_com_volcengine_zeus_dex_DirectDex_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("zeus_direct_dex");
        native_init(Build.VERSION.SDK_INT);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_volcengine_zeus_dex_DirectDex_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
