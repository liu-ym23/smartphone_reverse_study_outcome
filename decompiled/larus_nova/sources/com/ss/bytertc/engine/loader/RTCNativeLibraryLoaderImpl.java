package com.ss.bytertc.engine.loader;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class RTCNativeLibraryLoaderImpl implements RTCNativeLibraryLoader {
    private static final String TAG = "RtcNativeLibraryLoaderImpl";

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public RTCNativeLibraryLoaderImpl() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_bytertc_engine_loader_RTCNativeLibraryLoaderImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoader
    public boolean load(String r100) {
        INVOKESTATIC_com_ss_bytertc_engine_loader_RTCNativeLibraryLoaderImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L7:
        return false;
    }
}
