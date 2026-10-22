package com.bytedance.vcloud.vctrace;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class JNILoader {
    private static final String TAG = "VCSTrace";
    public static volatile boolean isLibraryLoaded;

    public JNILoader() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_vcloud_vctrace_JNILoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void loadLibrary(Context r100) {
        monitor-enter(JNILoader.class);
    L8:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L12
    L10:
        monitor-exit(JNILoader.class);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isLibraryLoaded == true) goto L10;
        INVOKESTATIC_com_bytedance_vcloud_vctrace_JNILoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("vctrace");     // Catch: Throwable -> L8
        isLibraryLoaded = true;     // Catch: Throwable -> L8
        goto L10
    }
}
