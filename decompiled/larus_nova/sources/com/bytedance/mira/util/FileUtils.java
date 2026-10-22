package com.bytedance.mira.util;

import android.os.StatFs;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes21.dex */
public class FileUtils {
    private FileUtils() {
    }

    public static void deleteDir(String r100) {
        deleteFile(new PolarisFileWrapper(r100));
    }

    public static void deleteFile(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L7;
        return;
    L7:
        if (r100.isDirectory() == false) goto L14;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L14;
        int r102 = 0;
    L12:
        if (r102 >= r101.length) goto L14;
        deleteFile(r101[r102]);
        r102 = r102 + 1;
    L14:
        r100.delete();
    }

    public static long getFileAvailableSize(File r100) {
        StatFs r101 = new StatFs(r100.getPath());
        return ((long) r101.getAvailableBlocks()) * r101.getBlockSize();
    }

    public static String readText(File r100) throws IOException {
        FileChannel r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L9
        r101 = r102.getChannel();     // Catch: Throwable -> L7
        String r103 = Charset.defaultCharset().newDecoder().decode(r101.map(FileChannel.MapMode.READ_ONLY, 0, r101.size()).asReadOnlyBuffer()).toString();     // Catch: Throwable -> L7
        IOUtils.closeSilently(r101);
        IOUtils.closeSilently(r102);
        return r103;
    L7:
        th = th;
    L11:
        IOUtils.closeSilently(r101);
        IOUtils.closeSilently(r102);
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public static File renameFile(File r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r100.renameTo(r102) == false) goto L5;
        return r102;
    L5:
        return null;
    }

    public static boolean safeCopy(String r100, String r101) {
        IOUtils.copyFile(r100, r101);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean safeCopyFolder(String r100, String r101) {
        IOUtils.copyFolder(r100, r101);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean safeMove(String r100, String r101) {
        if (safeRename(r100, r101) == false) goto L7;
        return true;
    L7:
        return safeCopy(r100, r101);
    }

    public static boolean safeRename(String r100, String r101) {
        return safeRename(new PolarisFileWrapper(r100), new PolarisFileWrapper(r101));
    }

    public static boolean safeRename(File r100, File r101) {
        return r100.renameTo(r101);
    L4:
        return false;
    }

    public static boolean writeText(String r100, File r101, StringBuilder r102) {
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: IOException -> L5
        FileChannel r104 = r103.getChannel();     // Catch: IOException -> L5
        r104.write(ByteBuffer.wrap(r100.getBytes()));     // Catch: IOException -> L5
        r104.close();     // Catch: IOException -> L5
        r103.close();     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        r102.append(e.getMessage());
        return false;
    }
}
