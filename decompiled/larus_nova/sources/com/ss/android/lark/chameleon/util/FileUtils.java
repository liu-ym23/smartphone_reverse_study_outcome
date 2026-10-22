package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes35.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public FileUtils() {
    }

    public static void cleanDirectory(File r100) throws IOException {
        File[] r101 = verifiedListFiles(r100);
        int r102 = r101.length;
        IOException e100 = null;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        forceDelete(r101[r103]);     // Catch: IOException -> L7
    L8:
        r103 = r103 + 1;
    L7:
        e100 = e;
        goto L8
    L9:
        if (e100 != null) goto L11;
        return;
    L11:
        throw e100;
    }

    public static void closeSilently(Closeable... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L23;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L24;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L15;
        r103.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Log.e(TAG, th.toString());
    L15:
        r102 = r102 + 1;
        goto L7
    L24:
        return;
    }

    public static void deleteDirectory(File r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        cleanDirectory(r100);
        if (r100.delete() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to delete directory " + r100 + ".");
    }

    public static void deleteFile(File r100) throws IOException {
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L9;
        deleteDirectory(r100);
        return;
    L9:
        if (r100.isFile() == false) goto L13;
        forceDelete(r100);
        return;
    }

    public static void forceDelete(File r100) throws IOException {
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L8;
        deleteDirectory(r100);
        return;
    L8:
        boolean r101 = r100.exists();
        if (r100.delete() == true) goto L16;
        if (r101 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r100);
    L14:
        throw new IOException("Unable to delete file: " + r100);
    }

    private static File[] verifiedListFiles(File r100) throws IOException {
        if (r100.exists() == false) goto L14;
        if (r100.isDirectory() == false) goto L12;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw new IOException("Failed to list contents of " + r100);
    L12:
        throw new IllegalArgumentException(r100 + " is not a directory");
    L14:
        throw new IllegalArgumentException(r100 + " does not exist");
    }

    public static void safeDeleteFile(Context r100, File r101) throws IOException {
        String r102 = AppInfoUtils.getPackageName(r100);
        if (r101.getPath().contains(r102) == false) goto L5;
        deleteFile(r101);
        return;
    L5:
        Log.w(TAG, "safeDeleteFile, not allow to delete user files");
    }

    public static boolean copyAssets(Context r110, String r111, String r112) {
        InputStream r100 = null;
        String[] r101 = r110.getAssets().list(r111);     // Catch: Throwable -> L30 Exception -> L32
        if (r101 != null) goto L6;
    L11:
        InputStream r113 = r110.getAssets().open(r111);     // Catch: Throwable -> L30 Exception -> L32
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r112));     // Catch: Throwable -> L26 Exception -> L28
    L44:
        byte[] r115 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L15:
        int r102 = r113.read(r115);     // Catch: Throwable -> L22 Exception -> L24
        if (r102 == (-1)) goto L18;
        r114.write(r115, 0, r102);     // Catch: Throwable -> L22 Exception -> L24
        goto L15
    L18:
        r114.flush();     // Catch: Throwable -> L22 Exception -> L24
        r113.close();     // Catch: Throwable -> L22 Exception -> L24
        r114.close();     // Catch: Throwable -> L22 Exception -> L24
        r100 = r113;
    L20:
        closeSilently(new Closeable[]{r100, r114});
        return true;
    L24:
        e = move-exception;
        r100 = r113;
        e = e;
    L40:
        Log.e(TAG, e.toString());     // Catch: Throwable -> L37
        closeSilently(new Closeable[]{r100, r114});
        return false;
    L37:
        th = th;
    L38:
        closeSilently(new Closeable[]{r100, r114});
        throw th;
    L22:
        th = move-exception;
        r100 = r113;
        th = th;
    L28:
        e = move-exception;
        r100 = r113;
        e = e;
        r114 = null;
    L26:
        th = move-exception;
        r100 = r113;
        th = th;
        r114 = null;
        goto L38
    L6:
        if (r101.length <= 0) goto L11;
        new PolarisFileWrapper(r112).mkdirs();     // Catch: Throwable -> L30 Exception -> L32
        int r103 = r101.length;     // Catch: Throwable -> L30 Exception -> L32
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        String r105 = r101[r104];     // Catch: Throwable -> L30 Exception -> L32
        copyAssets(r110, r111 + HTTP.URL_DEFAULT + r105, r112 + HTTP.URL_DEFAULT + r105);     // Catch: Throwable -> L30 Exception -> L32
        r104 = r104 + 1;     // Catch: Throwable -> L30 Exception -> L32
        goto L8
    L10:
        r114 = null;
    L32:
        e = e;
        r114 = null;
    L30:
        th = th;
        r114 = null;
        goto L38
    }
}
