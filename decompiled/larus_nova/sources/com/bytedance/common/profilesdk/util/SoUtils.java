package com.bytedance.common.profilesdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.DexImageLoader;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes15.dex */
public class SoUtils {
    private static HashMap<String, String> sSoVersions;

    private static void checkSoList() {
        if (sSoVersions == null) goto L5;
        return;
    L5:
        sSoVersions = new HashMap();
        PolarisFileWrapper r100 = new PolarisFileWrapper(AppContext.getApplicationContext().getFilesDir(), "/jato_lib/");
        String[] r101 = r100.list();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L19;
        String r104 = r101[r103];
        if (r104.endsWith(".ver") == false) goto L16;
        String r105 = r104.substring(0, r104.length() - 4);
        sSoVersions.put(r105, FileUtils.readFile(r100.getAbsolutePath() + HTTP.URL_DEFAULT + r104));     // Catch: Throwable -> L20
    L18:
        r103 = r103 + 1;
        goto L9
    L16:
        if (r104.endsWith(".so") == true) goto L18;
        FileUtils.deleteFile(new PolarisFileWrapper(r100, r104));
        goto L18
    }

    public static File getAppSo(String r100) {
        String r101 = AppContext.getContext().getApplicationInfo().nativeLibraryDir + File.separator + System.mapLibraryName(r100);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L5;
        return r102;
    L5:
        Logger.d("SoUtils: " + r101 + " dont exist, search in classloader");
        ClassLoader r103 = DexImageLoader.class.getClassLoader();     // Catch: Throwable -> L24
    L8:
        if ((r103 instanceof BaseDexClassLoader) == true) goto L13;
        if (r103.getParent() == null) goto L13;
        r103 = r103.getParent();     // Catch: Throwable -> L24
    L13:
        if ((r103 instanceof BaseDexClassLoader) == false) goto L26;
        Field r104 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Throwable -> L24
        r104.setAccessible(true);     // Catch: Throwable -> L24
        Object r105 = r104.get(r103);     // Catch: Throwable -> L24
        Field r106 = r105.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Throwable -> L24
        r106.setAccessible(true);     // Catch: Throwable -> L24
        Iterator r107 = ((List) r106.get(r105)).iterator();     // Catch: Throwable -> L24
    L15:
        if (r107.hasNext() == false) goto L26;
        PolarisFileWrapper r108 = new PolarisFileWrapper((File) r107.next(), System.mapLibraryName(r100));     // Catch: Throwable -> L24
        if (r108.exists() == true) goto L20;
        r102 = r108;
        goto L15
    L20:
        r102 = r108;
    L22:
        th = th;
        r102 = r108;
    L25:
        Logger.e("Failed to get library path, " + r100, th);
    L26:
        Logger.d("SoUtils: lib " + r100 + " not found");
        return r102;
    L24:
        th = th;
        goto L25
    }

    private static String getSoVersionPath(String r100) {
        return AppContext.getApplicationContext().getFilesDir() + "/jato_lib/" + r100 + ".ver";
    }

    public static String getUnpackedSoPath(String r100) {
        return AppContext.getApplicationContext().getFilesDir() + "/jato_lib/lib" + r100 + ".so";
    }

    public static void checkAndUnpackSo(String r100, String r101) {
        checkSoList();
        if (checkSoAvailable(r100, r101) == true) goto L15;
        PolarisFileWrapper r102 = new PolarisFileWrapper(getUnpackedSoPath(r100));
        r102.getParentFile().mkdirs();
        if (r102.exists() == false) goto L7;
        r102.delete();
    L7:
        Logger.d("doUnpackLibrary: " + r102);
        if (unpackLibrary(AppContext.getApplicationContext(), r100, r102) != null) goto L16;
        sSoVersions.put(r102.getName(), r101);
        FileUtils.writeFile(new PolarisFileWrapper(getSoVersionPath(r100)), r101, false);     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L16:
        return;
    }

    private static boolean checkSoAvailable(String r100, String r101) {
        if (r101.equals(sSoVersions.get(r100)) == true) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(getUnpackedSoPath(r100)).exists();
    }

    private static String unpackLibrary(String r100, String r110, File r111) {
        PolarisFileOutputStreamWrapper r101 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100), 1);     // Catch: Throwable -> L33
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
        IoUtil.close(null);
        IoUtil.close(null);
    L14:
        IoUtil.close(r102);
        return r109;
    L16:
        r105 = r112;
    L17:
        r111.createNewFile();     // Catch: Throwable -> L31
        InputStream r113 = r102.getInputStream(r105);     // Catch: Throwable -> L31
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L29
        byte[] r115 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r116 = r113.read(r115);     // Catch: Throwable -> L27
        if (r116 <= 0) goto L25;
        r114.write(r115, 0, r116);     // Catch: Throwable -> L27
        goto L21
    L25:
        IoUtil.close(r114);
        IoUtil.close(r113);
        IoUtil.close(r102);
        return null;
    L27:
        th = move-exception;
        r101 = r114;
        InputStream r117 = r113;
        th = th;
    L41:
        r109 = th.getMessage();     // Catch: Throwable -> L37
        IoUtil.close(r101);
        IoUtil.close(r117);
    L37:
        th = move-exception;
        IoUtil.close(r101);
        IoUtil.close(r117);
        IoUtil.close(r102);
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

    private static String unpackLibrary(Context r100, String r101, File r102) {
        ApplicationInfo r103 = r100.getApplicationInfo();
        String r104 = unpackLibrary(r103.sourceDir, r101, r102);
        if (r104 != null) goto L5;
        return null;
    L5:
        String[] r105 = r103.splitSourceDirs;
        if (r105 == null) goto L13;
        int r106 = r105.length;
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L13;
        r104 = unpackLibrary(r105[r107], r101, r102);
        if (r104 == null) goto L11;
        r107 = r107 + 1;
        goto L8
    L11:
        return null;
    L13:
        return r104;
    }
}
