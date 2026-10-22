package com.bytedance.common.utility.tools;

import android.content.Context;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class SafelyLibraryLoader {
    private static List<String> sLoadedLibs;

    static {
        sLoadedLibs = new ArrayList();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_common_utility_tools_SafelyLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static File getLibraryFolder(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getFilesDir() == null) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "libso");
        if (r101.exists() == true) goto L9;
        IOUtils.mkdir(r101.getAbsolutePath());
    L9:
        return r101;
    L12:
        return null;
    }

    private static File getLibraryFile(Context r100, String r101) {
        String r102 = System.mapLibraryName(r101);
        File r103 = getLibraryFolder(r100);
        if (r103 != null) goto L5;
        return null;
    L5:
        return new PolarisFileWrapper(r103, r102);
    }

    public static synchronized boolean loadLibrary(Context r100, String r101) {
        monitor-enter(SafelyLibraryLoader.class);
    L36:
        th = move-exception;
        throw th;
    L6:
        if (sLoadedLibs.contains(r101) == false) goto L42;
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L42:
        INVOKESTATIC_com_bytedance_common_utility_tools_SafelyLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r101);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L16
        sLoadedLibs.add(r101);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L16
    L30:
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L16:
        e = move-exception;
        File r102 = getLibraryFile(r100, r101);     // Catch: Throwable -> L36
        e.getStackTrace().toString();     // Catch: Throwable -> L36
        if (r102 != null) goto L22;
        return false;
    L22:
        if (r102.exists() == false) goto L25;
        r102.delete();     // Catch: Throwable -> L36
    L25:
        if (unpackLibrary(r100, r101, r102) == null) goto L40;
        e.getMessage();     // Catch: Throwable -> L36
        return false;
    L40:
        System.load(r102.getAbsolutePath());     // Catch: Throwable -> L32
        sLoadedLibs.add(r101);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.getStackTrace().toString();     // Catch: Throwable -> L36
        return false;
    L12:
        th = move-exception;
        th.getStackTrace().toString();     // Catch: Throwable -> L36
        return false;
    }

    private static String unpackLibrary(Context r100, String r110, File r111) {
        PolarisFileOutputStreamWrapper r101 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r103 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        String r104 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r103.append(r104);     // Catch: Throwable -> L31
        r103.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r103.append(System.mapLibraryName(r110));     // Catch: Throwable -> L31
        ZipEntry r105 = r102.getEntry(r103.toString());     // Catch: Throwable -> L31
        if (r105 != null) goto L17;
        int r106 = r104.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r107 = new StringBuilder("lib/");     // Catch: Throwable -> L31
        if (r106 > 0) goto L10;
        r106 = r104.length();     // Catch: Throwable -> L31
    L10:
        r107.append(r104.substring(0, r106));     // Catch: Throwable -> L31
        r107.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L31
        r107.append(System.mapLibraryName(r110));     // Catch: Throwable -> L31
        String r108 = r107.toString();     // Catch: Throwable -> L31
        ZipEntry r112 = r102.getEntry(r108);     // Catch: Throwable -> L31
        if (r112 != null) goto L16;
        String r109 = "Library entry not found:" + r108;     // Catch: Throwable -> L31
        IOUtils.close(null);
        IOUtils.close(null);
    L14:
        IOUtils.close(r102);
        return r109;
    L16:
        r105 = r112;
    L17:
        r111.createNewFile();     // Catch: Throwable -> L31
        InputStream r113 = r102.getInputStream(r105);     // Catch: Throwable -> L31
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L29
        byte[] r115 = new byte[16384];     // Catch: Throwable -> L27
    L21:
        int r116 = r113.read(r115);     // Catch: Throwable -> L27
        if (r116 <= 0) goto L24;
        r114.write(r115, 0, r116);     // Catch: Throwable -> L27
        goto L21
    L24:
        IOUtils.setPermissions(r111.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        IOUtils.close(r114);
        IOUtils.close(r113);
        IOUtils.close(r102);
        return null;
    L27:
        th = move-exception;
        r101 = r114;
        InputStream r117 = r113;
        th = th;
    L41:
        r109 = th.getMessage();     // Catch: Throwable -> L37
        IOUtils.close(r101);
        IOUtils.close(r117);
    L37:
        th = move-exception;
        IOUtils.close(r101);
        IOUtils.close(r117);
        IOUtils.close(r102);
        throw th;
    L29:
        th = move-exception;
        r117 = r113;
        th = th;
    L31:
        th = th;
        r117 = null;
    L33:
        th = th;
        r117 = null;
        r102 = null;
        goto L41
    }
}
