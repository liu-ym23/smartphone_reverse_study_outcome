package com.bytedance.byted_bach_sdk.finder;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BachResourceFinder {
    public boolean isDestroyed;
    public long m_nativePtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public abstract void destroy();

    static {
        INVOKESTATIC_com_bytedance_byted_bach_sdk_finder_BachResourceFinder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bach-sdk-jni");
    }

    public BachResourceFinder() {
        this.m_nativePtr = 0;
        this.isDestroyed = false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_byted_bach_sdk_finder_BachResourceFinder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
