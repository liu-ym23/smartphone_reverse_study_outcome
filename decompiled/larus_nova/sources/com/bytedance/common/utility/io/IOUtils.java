package com.bytedance.common.utility.io;

import android.os.StatFs;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static boolean canWrite(File r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.exists() == false) goto L13;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "." + System.currentTimeMillis());
        boolean r102 = r101.mkdir();
        if (r102 == true) goto L9;
        return r102;
    L9:
        return r101.delete();
    L13:
        return false;
    }

    public static void clearPath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.isDirectory() == false) goto L24;
        String[] r102 = r101.list();
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L25;
        String r105 = r102[r104];
        String r106 = File.separator;
        if (r100.endsWith(r106) == false) goto L12;
        String r107 = r100 + r105;
    L13:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
        if (r108.isFile() == false) goto L17;
        r108.delete();
    L17:
        if (r108.isDirectory() == false) goto L19;
        deletePath(r107);
    L19:
        r104 = r104 + 1;
        goto L8
    L12:
        r107 = r100 + r106 + r105;
        goto L13
    L25:
        return;
    }

    public static void close(Closeable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static void deleteFile(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return;
    L8:
        if (r101.isFile() == false) goto L13;
        r101.delete();
        return;
    }

    public static void deletePath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L6;
        return;
    L6:
        if (r101.isFile() == false) goto L9;
        r101.delete();
        return;
    L9:
        String[] r102 = r101.list();
        if (r102 != null) goto L12;
        return;
    L12:
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L28;
        String r105 = r102[r104];
        if (r105 == null) goto L27;
        String r106 = File.separator;
        if (r100.endsWith(r106) == false) goto L20;
        String r107 = r100.concat(r105);
    L21:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
        if (r108.isFile() == false) goto L25;
        r108.delete();
    L25:
        if (r108.isDirectory() == false) goto L27;
        deletePath(r107);
        goto L27
    L20:
        r107 = r100 + r106 + r105;
    L27:
        r104 = r104 + 1;
        goto L13
    L28:
        r101.delete();
    }

    public static boolean exists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r100).exists();
    }

    public static long getAllBytes(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return 0;
    L15:
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return 0;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (new PolarisFileWrapper(r100).exists() == false) goto L14;
        StatFs r101 = new StatFs(r100);     // Catch: Exception -> L12
        return ((long) r101.getBlockSize()) * r101.getBlockCount();
    }

    public static long getAvailableBytes(String r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L16;
        StatFs r101 = new StatFs(r100);     // Catch: Exception -> L9
        return ((long) r101.getBlockSize()) * r101.getAvailableBlocks();
    L16:
        return 0;
    }

    public static String getFileExtension(String r100) {
        int r101 = r100.lastIndexOf(".");
        if (r101 >= 0) goto L5;
        return "";
    L5:
        if (r101 < (r100.length() - 1)) goto L7;
        return "";
    L7:
        return r100.substring(r101 + 1).toUpperCase(Locale.getDefault());
    }

    public static String getFileName(String r100) {
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L5;
        r100 = r100.substring(0, r100.length() - 1);
    L5:
        int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        if (r101 > 0) goto L8;
        return r100;
    L8:
        if (r101 < (r100.length() - 1)) goto L10;
        return r100;
    L10:
        return r100.substring(r101 + 1);
    }

    public static String getFileNameWithoutExtension(String r100) {
        String r101 = getFileName(r100);
        if (r101 != null) goto L5;
        return r101;
    L5:
        if (r101.length() <= 0) goto L11;
        int r102 = r101.lastIndexOf(46);
        if (r102 > 0) goto L9;
        return r101;
    L9:
        return r101.substring(0, r102);
    L11:
        return r101;
    }

    public static long getFileSize(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return 0;
    L8:
        long r102 = r101.length();
        if (r101.isDirectory() == false) goto L23;
        File[] r103 = r101.listFiles();
        if (r103 == null) goto L23;
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L23;
        r102 = r102 + getFileSize(r103[r105].getAbsolutePath());
        r105 = r105 + 1;
        goto L13
    L17:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L20:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L23:
        return r102;
    }

    public static String getParentFilePath(String r100) {
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L5;
        r100 = r100.substring(0, r100.length() - 1);
    L5:
        int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        if (r101 >= 0) goto L8;
        return null;
    L8:
        return r100.substring(0, r101);
    }

    public static boolean mkdir(String r100) {
        return new PolarisFileWrapper(r100).mkdirs();
    }

    public static String readFileFirstLine(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L13 Exception -> L28
        goto L16
    L37:
        String r103 = r102.readLine();     // Catch: Throwable -> L10 Exception -> L12
        r102.close();     // Catch: Throwable -> L10 Exception -> L12
        r102.close();     // Catch: IOException -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        r101 = r102;
    L10:
        th = th;
        r101 = r102;
    L22:
        if (r101 != null) goto L31;
    L27:
        throw th;
    L31:
        r101.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L13:
        th = th;
    L16:
        if (r101 != null) goto L29;
    L21:
        return "";
    L29:
        r101.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public static void close(ZipFile r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static boolean copyFile(File r100, File r101) {
        if (r100.exists() == true) goto L5;
    L22:
        return false;
    L5:
        if (r100.isFile() == false) goto L22;
        if (r101.isDirectory() == false) goto L10;
        return false;
    L10:
        if (r101.exists() == false) goto L23;
        r101.delete();
    L23:
        byte[] r102 = new byte[2048];     // Catch: IOException -> L20
        BufferedInputStream r103 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: IOException -> L20
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: IOException -> L20
    L14:
        int r105 = r103.read(r102);     // Catch: IOException -> L20
        if (r105 == (-1)) goto L16;
        r104.write(r102, 0, r105);     // Catch: IOException -> L20
        goto L14
    L16:
        r103.close();     // Catch: IOException -> L20
        r104.flush();     // Catch: IOException -> L20
        r104.close();     // Catch: IOException -> L20
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static boolean renameFile(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L7;
        return false;
    L7:
        return r102.renameTo(r103);
    }

    public static void setPermissions(String r100, int r101) {
        JavaCalls.callStaticMethod("android.os.FileUtils", r100, new Object[]{Integer.valueOf(r101), -1, -1});
    }

    public static boolean copyFile(String r100, String r101) {
        return copyFile(new PolarisFileWrapper(r100), new PolarisFileWrapper(r101));
    }

    public static void write(String r100, String r101, boolean r102) {
        PolarisFileWriterWrapper r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L14 IOException -> L19
        if (r104.exists() == true) goto L6;
        r104.getParentFile().mkdirs();     // Catch: Throwable -> L14 IOException -> L19
        r104.createNewFile();     // Catch: Throwable -> L14 IOException -> L19
    L6:
        PolarisFileWriterWrapper r105 = new PolarisFileWriterWrapper(r100, r102);     // Catch: Throwable -> L14 IOException -> L19
        r105.write(r101);     // Catch: Throwable -> L10 IOException -> L12
        r105.close();     // Catch: Exception -> L28
    L32:
    L35:
        return;
    L12:
        e = e;
        r103 = r105;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r103 == null) goto L35;
    L17:
        r103.close();     // Catch: Exception -> L28
    L10:
        th = th;
        r103 = r105;
    L15:
        th.printStackTrace();     // Catch: Throwable -> L24
        if (r103 == null) goto L35;
    L19:
        e = e;
    L14:
        th = th;
    L41:
        return;
    L24:
        th = move-exception;
        if (r103 != null) goto L30;
    L27:
        throw th;
    L30:
        r103.close();     // Catch: Exception -> L29
        goto L27
    }
}
