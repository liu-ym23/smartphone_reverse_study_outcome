package com.ss.android.ugc.effectmanager;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public interface DownloadableModelSupportLibraryLoader {

    public static class SystemLoader implements DownloadableModelSupportLibraryLoader {
        public SystemLoader() {
        }

        public static /* synthetic */ void access$000(String r100) {
            System.loadLibrary(r100);
        }

        @JvmStatic
        public static void INVOKESTATIC_com_ss_android_ugc_effectmanager_DownloadableModelSupportLibraryLoader$SystemLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.ss.android.ugc.effectmanager.DownloadableModelSupportLibraryLoader
        public void loadLibrary(String r100) {
            INVOKESTATIC_com_ss_android_ugc_effectmanager_DownloadableModelSupportLibraryLoader$SystemLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        }
    }

    void loadLibrary(String r100);
}
