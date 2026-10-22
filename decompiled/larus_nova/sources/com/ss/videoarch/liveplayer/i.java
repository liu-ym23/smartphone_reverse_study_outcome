package com.ss.videoarch.liveplayer;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f458852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f458853b;

    public interface a {
        void loadLibrary(String r100) throws Exception;

        void loadLibraryFromPath(String r100) throws Exception;

        boolean loadPlayerLibrary(String r100);

        boolean loadPluginLibrary(String r100, String r101) throws Exception;
    }

    public i() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        f458852a = i.class.getSimpleName();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_videoarch_liveplayer_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void loadLibrary(String r100) throws Exception {
        a r101 = f458853b;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L6;
        com.ss.videoarch.liveplayer.log.c.d(f458852a, "Loading [" + r100 + "] with external loader " + r101);
        r101.loadLibrary(r100);
        return;
    L6:
        INVOKESTATIC_com_ss_videoarch_liveplayer_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        return;
    L9:
        throw new Exception("Invalid library name.");
    }

    public static void loadLibraryFromPath(String r100) throws Exception {
        a r101 = f458853b;
        if (TextUtils.isEmpty(r100) == true) goto L13;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L11;
        if (r101 == null) goto L8;
        com.ss.videoarch.liveplayer.log.c.d(f458852a, "Loading [" + r102.getAbsolutePath() + "] with external loader " + r101);
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

    public static boolean loadPlayerLibrary(String r100) {
        a r101 = f458853b;
        boolean r102 = TextUtils.isEmpty(r100);
        String r103 = f458852a;
        if (r102 == false) goto L6;
        com.ss.videoarch.liveplayer.log.c.d(r103, "Invalid library name.");
        return false;
    L6:
        if (r101 == null) goto L15;
        com.ss.videoarch.liveplayer.log.c.d(r103, "Loading [" + r100 + "] with external loader " + r101);
        return r101.loadPlayerLibrary(r100);
    L15:
        INVOKESTATIC_com_ss_videoarch_liveplayer_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static void setupLibraryLoader(a r100) {
        f458853b = r100;
    }

    public static boolean loadPluginLibrary(String r100, String r101) throws Exception {
        a r102 = f458853b;
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r102 == null) goto L7;
        com.ss.videoarch.liveplayer.log.c.d(f458852a, "Loading [" + r100 + "] with external loader " + r102);
        return r102.loadPluginLibrary(r100, r101);
    L7:
        INVOKESTATIC_com_ss_videoarch_liveplayer_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        return true;
    L10:
        throw new Exception("Invalid library name.");
    }
}
