package com.bytedance.mira.util;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class IOUtils {
    private static final int BUFFER_SIZE = 16384;

    /* JADX INFO: loaded from: classes21.dex */
    public interface IProgress {
        void onProgress(long r100, long r101);
    }

    private IOUtils() {
    }

    public static void closeSilently(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static byte[] readFromFile(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L14 IOException -> L17
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L14 IOException -> L17
    L21:
        byte[] r104 = new byte[16384];     // Catch: Throwable -> L12 IOException -> L20
    L6:
        int r105 = r103.read(r104);     // Catch: Throwable -> L12 IOException -> L20
        if (r105 == (-1)) goto L9;
        r102.write(r104, 0, r105);     // Catch: Throwable -> L12 IOException -> L20
        goto L6
    L9:
        byte[] r106 = r102.toByteArray();     // Catch: Throwable -> L12 IOException -> L20
        r102.close();     // Catch: Throwable -> L12 IOException -> L20
        closeSilently(r103);
        return r106;
    L12:
        th = th;
        r101 = r103;
    L15:
        closeSilently(r101);
        throw th;
    L18:
        closeSilently(r103);
        return null;
    L17:
        r103 = null;
    L14:
        th = th;
        goto L15
    }

    public static void closeSilently(ZipFile r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void copyFile(String r100, String r101) throws Exception {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L42;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L10;
        return;
    L10:
        if (r102.isFile() == true) goto L12;
        return;
    L12:
        if (r102.canRead() == true) goto L15;
        return;
    L15:
        if (r103.getParentFile() != null) goto L17;
    L19:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r101);
        FileLock r106 = null;
        r106 = new RandomAccessFile(r102, "rw").getChannel().lock();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
        copyStream(r104, r105, r102.length());     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
        if (r106 == null) goto L39;
        r106.release();
        return;
    L39:
        return;
    L24:
        th = move-exception;
        if (r106 == null) goto L35;
        r106.release();
    L35:
        throw th;
    L28:
        e = move-exception;
        if (r103.exists() == false) goto L32;
        r103.delete();     // Catch: Throwable -> L24
    L32:
        throw e;     // Catch: Throwable -> L24
    L26:
        e = move-exception;
        throw e;     // Catch: Throwable -> L24
    L17:
        if (r103.getParentFile().exists() == true) goto L19;
        r103.getParentFile().mkdirs();
        goto L19
    }

    public static void copyFolder(String r100, String r101) throws Exception {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L36;
        if (r102.isDirectory() == false) goto L34;
        if (r103.exists() == true) goto L10;
        r103.mkdirs();
    L10:
        if (r103.isDirectory() == false) goto L32;
        File[] r104 = r102.listFiles();
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.length == 0) goto L42;
        int r105 = r104.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L43;
        File r107 = r104[r106];
        String r108 = r103 + File.separator + r107.getName();
        if (r107.isDirectory() == false) goto L22;
        copyFolder(r107.getAbsolutePath(), r108);
    L29:
        r106 = r106 + 1;
        goto L17
    L22:
        if (new PolarisFileWrapper(r108).exists() == true) goto L29;
        BufferedInputStream r109 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r107));
        BufferedOutputStream r110 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r108));
        byte[] r111 = new byte[16384];
    L25:
        int r112 = r109.read(r111);
        if (r112 == (-1)) goto L28;
        r110.write(r111, 0, r112);
        goto L25
    L28:
        r110.close();
        r109.close();
        goto L29
    L43:
        return;
    L42:
        return;
    L32:
        throw new Exception("目标文件夹不是目录");
    L34:
        throw new Exception("源文件夹不是目录");
    L36:
        throw new Exception("文件夹不存在");
    }

    public static void copyStream(InputStream r100, OutputStream r101) throws IOException {
        copyStream(r100, r101, 0);
    }

    public static boolean renameFile(String r100, String r101) {
        return new PolarisFileWrapper(r100).renameTo(new PolarisFileWrapper(r101));
    }

    public static void writeToFile(File r100, byte[] r101) {
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L9 IOException -> L14
        r103.write(r101);     // Catch: Throwable -> L6 IOException -> L8
        r103.flush();     // Catch: Throwable -> L6 IOException -> L8
        closeSilently(r103);
        return;
    L8:
        r102 = r103;
    L6:
        th = th;
        r102 = r103;
    L10:
        closeSilently(r102);
        throw th;
    L9:
        th = th;
    L12:
        closeSilently(r102);
    }

    public static void copyFile(ZipFile r100, ZipEntry r110, File r111) throws IOException {
        boolean r101 = false;
        PolarisFileOutputStreamWrapper r102 = null;
        IOException r103 = null;
        PolarisFileOutputStreamWrapper r104 = null;
        r102 = null;
        r104 = null;
        InputStream r105 = r100.getInputStream(r110);     // Catch: Throwable -> L24 IOException -> L30
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L20 IOException -> L22
        long r107 = r110.getSize();     // Catch: Throwable -> L16 IOException -> L18
        byte[] r112 = new byte[16384];     // Catch: Throwable -> L16 IOException -> L18
        int r108 = 0;
    L6:
        int r109 = r105.read(r112);     // Catch: Throwable -> L16 IOException -> L18
        if (r109 == (-1)) goto L10;
        r106.write(r112, 0, r109);     // Catch: Throwable -> L16 IOException -> L18
        r108 = r108 + r109;     // Catch: Throwable -> L16 IOException -> L18
        goto L6
    L10:
        if (r108 == r107) goto L12;
        r103 = new IOException("文件未复制完成");     // Catch: Throwable -> L16 IOException -> L18
        boolean r113 = false;
    L13:
        if (r113 == false) goto L15;
        r106.flush();     // Catch: Throwable -> L16 IOException -> L18
    L15:
        r100.close();
        closeSilently(r105);
        closeSilently(r106);
        r101 = r113;
    L35:
        if (r101 == false) goto L37;
        return;
    L37:
        r111.delete();
        throw r103;
    L12:
        r113 = true;
    L18:
        e = e;
        r104 = r106;
    L32:
        if (r100 == null) goto L34;
        r100.close();
    L34:
        closeSilently(r105);
        closeSilently(r104);
        r103 = e;
    L16:
        th = th;
        r102 = r106;
    L26:
        if (r100 == null) goto L28;
        r100.close();
    L28:
        closeSilently(r105);
        closeSilently(r102);
        throw th;
    L22:
        e = e;
    L20:
        th = th;
        goto L26
    L30:
        e = e;
        r105 = null;
    L24:
        th = th;
        r105 = null;
        goto L26
    }

    public static void copyStream(InputStream r100, OutputStream r101, long r102) throws IOException {
        copyStream(r100, r101, r102, null);
    }

    public static void copyStream(InputStream r100, OutputStream r101, long r102, IProgress r103) throws IOException {
        if (r100 == null) goto L24;
        if (r101 == null) goto L28;
        BufferedInputStream r104 = new BufferedInputStream(r100);
        BufferedOutputStream r105 = new BufferedOutputStream(r101);
        byte[] r106 = new byte[16384];     // Catch: Throwable -> L21
        int r107 = 0;
    L7:
        int r108 = r104.read(r106);     // Catch: Throwable -> L21
        if (r108 == (-1)) goto L10;
        r105.write(r106, 0, r108);     // Catch: Throwable -> L21
        r107 = r107 + r108;     // Catch: Throwable -> L21
        goto L7
    L10:
        if (r103 == null) goto L12;
        r103.onProgress(r107, r102);     // Catch: Throwable -> L21
    L12:
        r105.flush();     // Catch: Throwable -> L21
        if (r102 > 0) goto L15;
    L19:
        r104.close();
        r105.close();
        return;
    L15:
        if (r107 == r102) goto L19;
        throw new IOException("copy is not completed");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r104.close();
        r105.close();
        throw th;
    L28:
        return;
    }
}
