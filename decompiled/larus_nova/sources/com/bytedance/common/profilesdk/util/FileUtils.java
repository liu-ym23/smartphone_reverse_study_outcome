package com.bytedance.common.profilesdk.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public class FileUtils {
    private static byte[] ZIP_HEADER_1;
    private static byte[] ZIP_HEADER_2;

    static {
        ZIP_HEADER_1 = new byte[]{80, 75, 3, 4};
        ZIP_HEADER_2 = new byte[]{80, 75, 5, 6};
    }

    public static boolean createIfNotExist(File r100) {
        if (r100.exists() == false) goto L11;
        return true;
    L11:
        r100.getParentFile().mkdirs();     // Catch: Exception -> L8
        return r100.createNewFile();
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean deleteFile(File r100) {
        boolean r101 = true;
        if (r100.exists() == true) goto L6;
        return true;
    L6:
        if (r100.canWrite() == true) goto L9;
        return false;
    L9:
        if (r100.isFile() == false) goto L13;
        return r100.delete();
    L13:
        if (r100.isDirectory() == false) goto L33;
        File[] r102 = r100.listFiles();
        int r103 = 0;
    L15:
        if (r102 == null) goto L28;
        if (r103 >= r102.length) goto L28;
        if (r102[r103].isFile() == true) goto L21;
        boolean r104 = deleteFile(r102[r103]);
    L25:
        r101 = r101 & r104;
    L26:
        r103 = r103 + 1;
        goto L15
    L21:
        if (r102[r103].canWrite() == false) goto L23;
        r104 = r102[r103].delete();
        goto L25
    L23:
        r101 = false;
    L28:
        return r101 & r100.delete();
    L33:
        return true;
    }

    public static boolean fileExists(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (new PolarisFileWrapper(r100).exists() == false) goto L6;
        return true;
    }

    public static long getCreationTime(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        return Files.readAttributes(r101.toPath(), BasicFileAttributes.class, new LinkOption[0]).creationTime().toMillis();
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L14:
        return 0;
    }

    public static boolean isArchiveFile(File r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDirectory() == false) goto L8;
        return false;
    L8:
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L24 IOException -> L26
        byte[] r104 = new byte[4];     // Catch: Throwable -> L20 IOException -> L22
        if (r103.read(r104, 0, 4) == 4) goto L14;
    L18:
        r103.close();     // Catch: IOException -> L34
    L41:
        goto L30
    L14:
        if (Arrays.equals(ZIP_HEADER_1, r104) == true) goto L17;
        if (Arrays.equals(ZIP_HEADER_2, r104) == false) goto L18;
    L17:
        r101 = true;
    L22:
        e = e;
        r102 = r103;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r102 == null) goto L30;
        r102.close();     // Catch: IOException -> L34
    L20:
        th = th;
        r102 = r103;
    L31:
        if (r102 != null) goto L36;
    L33:
        throw th;
    L36:
        r102.close();     // Catch: IOException -> L35
    L26:
        e = e;
    L24:
        th = th;
    L30:
        return r101;
    }

    public static boolean isFileValid(File r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.exists() == true) goto L8;
        return false;
    L8:
        if (r100.length() == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static byte[] readAllBytes(File r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(1024);
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));
        byte[] r103 = new byte[512];     // Catch: Throwable -> L10
    L4:
        int r104 = r102.read(r103, 0, 512);     // Catch: Throwable -> L10
        if (r104 <= 0) goto L8;
        r101.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r102.close();
        return r101.toByteArray();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static String readFile(String r100) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return readFile(new PolarisFileWrapper(r100));
    }

    public static String readFile(File r100) throws IOException {
        return readFile(r100, "\n");
    }

    public static String readFile(File r100, String r101) throws IOException {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.exists() == false) goto L33;
        StringBuilder r102 = new StringBuilder();
        BufferedReader r103 = null;
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L20
    L25:
        String r105 = r104.readLine();     // Catch: Throwable -> L18
        if (r105 == null) goto L16;
        if (r102.length() == 0) goto L14;
        if (r101 == null) goto L14;
        r102.append(r101);     // Catch: Throwable -> L18
    L14:
        r102.append(r105);     // Catch: Throwable -> L18
        goto L25
    L16:
        IoUtil.close(r104);
        return r102.toString();
    L18:
        th = th;
        r103 = r104;
    L21:
        IoUtil.close(r103);
        throw th;
    L20:
        th = th;
        goto L21
    L33:
        return "";
    }

    public static void writeFile(File r100, String r101, boolean r102) throws IOException {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        r100.getParentFile().mkdirs();
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100, r102);     // Catch: Throwable -> L12
        r104.write(r101.getBytes());     // Catch: Throwable -> L10
        r104.flush();     // Catch: Throwable -> L10
        IoUtil.close(r104);
        return;
    L10:
        th = th;
        r103 = r104;
    L13:
        IoUtil.close(r103);
        throw th;
    L12:
        th = th;
        goto L13
    }
}
