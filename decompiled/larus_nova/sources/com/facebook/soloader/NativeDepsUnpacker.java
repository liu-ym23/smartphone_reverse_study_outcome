package com.facebook.soloader;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class NativeDepsUnpacker {
    private static final String APK_IDENTIFIER_FILE_NAME = "apk_id";
    private static final String LOCK_FILE_NAME = "lock";
    private static final String NATIVE_DEPS_DIR_NAME = "native_deps";
    private static final String NATIVE_DEPS_FILE_APK_PATH = "assets/native_deps.txt";
    private static final String NATIVE_DEPS_FILE_NAME = "deps";
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "state";

    private NativeDepsUnpacker() {
    }

    private static boolean ensureDirExists(File r100) {
        if (r100.exists() == false) goto L8;
        if (r100.isDirectory() == true) goto L8;
        r100.delete();
    L8:
        if (r100.exists() == true) goto L11;
        r100.mkdir();
    L11:
        if (r100.isDirectory() == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static void ensureNativeDepsAvailable(Context r100) throws IOException {
        File r101 = getNativeDepsDir(r100);
        if (ensureDirExists(r101) == true) goto L5;
        return;
    L5:
        FileLocker r102 = SysUtil.getOrCreateLockOnDir(r101, new PolarisFileWrapper(r101, LOCK_FILE_NAME), true);
        byte r103 = readState(r101);     // Catch: Throwable -> L19
        if (r103 == 1) goto L9;
    L11:
        if (r103 != 1) goto L15;
        if (r102 == null) goto L30;
        r102.close();
        return;
    L30:
        return;
    L15:
        writeState(r101, (byte) 0);     // Catch: Throwable -> L19
        extractNativeDeps(r100);     // Catch: Throwable -> L19
        writeApkIdentifier(r100, r101);     // Catch: Throwable -> L19
        SysUtil.fsyncRecursive(r101);     // Catch: Throwable -> L19
        writeState(r101, (byte) 1);     // Catch: Throwable -> L19
        if (r102 == null) goto L31;
        r102.close();
        return;
    L31:
        return;
    L9:
        if (apkChanged(r100, r101) == false) goto L11;
        r103 = 0;
    L19:
        th = move-exception;
        if (r102 != null) goto L28;
    L25:
        throw th;
    L28:
        r102.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    private static void extractNativeDeps(Context r100) throws IOException {
        byte[] r101 = readNativeDepsFromApk(r100);
        byte[] r102 = getApkIdentifier(r100);
        int r103 = r101.length;
        RandomAccessFile r104 = new RandomAccessFile(getNativeDepsFilePath(r100), "rw");
        r104.write(r102);     // Catch: Throwable -> L6
        r104.writeInt(r103);     // Catch: Throwable -> L6
        r104.write(r101);     // Catch: Throwable -> L6
        r104.setLength(r104.getFilePointer());     // Catch: Throwable -> L6
        r104.close();
        return;
    L6:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static byte[] getApkIdentifier(Context r100) throws IOException {
        return SysUtil.makeApkDepBlock(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir), r100);
    }

    public static File getNativeDepsDir(Context r100) {
        return new PolarisFileWrapper(r100.getApplicationInfo().dataDir, NATIVE_DEPS_DIR_NAME);
    }

    public static File getNativeDepsFilePath(Context r100) {
        return new PolarisFileWrapper(getNativeDepsDir(r100), NATIVE_DEPS_FILE_NAME);
    }

    public static byte[] readNativeDepsFromApk(Context r100) throws IOException {
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir));
        ZipEntry r102 = r101.getEntry(NATIVE_DEPS_FILE_APK_PATH);     // Catch: Throwable -> L23
        if (r102 == null) goto L22;
        InputStream r103 = r101.getInputStream(r102);     // Catch: Throwable -> L23
        if (r103 == null) goto L14;
        byte[] r104 = readAllBytes(r103, (int) r102.getSize());     // Catch: Throwable -> L11
        r103.close();     // Catch: Throwable -> L23
        r101.close();
        return r104;
    L14:
        throw new FileNotFoundException("Failed to read native_deps file from APK");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r103 != null) goto L32;
    L20:
        throw th;     // Catch: Throwable -> L23
    L32:
        r103.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
        goto L20
    L22:
        throw new FileNotFoundException("Could not find native_deps file in APK");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L26
    L28:
        throw th;
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    public static byte[] readNativeDepsFromDisk(Context r100) throws IOException {
        File r101 = getNativeDepsFilePath(r100);
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);
        byte[] r103 = readAllBytes(r102, (int) r101.length());     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static byte readState(File r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(new PolarisFileWrapper(r100, "state"), "rw");
        byte r102 = 0;
        byte r103 = r101.readByte();     // Catch: Throwable -> L8 EOFException -> L16
        goto L14
    L5:
        if (r103 != 1) goto L14;
        r102 = r103;
    L8:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
    L14:
        r101.close();
        return r102;
    }

    private static boolean apkChanged(Context r100, File r101) throws IOException {
        byte[] r102 = getExistingApkIdentifier(r100, r101);
        byte[] r103 = getApkIdentifier(r100);
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        if (r102.length == r103.length) goto L10;
        return true;
    L10:
        return !Arrays.equals(r102, r103);
    L11:
        return true;
    }

    @Nullable
    private static byte[] getExistingApkIdentifier(Context r100, File r101) throws IOException {
        RandomAccessFile r102 = new RandomAccessFile(new PolarisFileWrapper(r101, APK_IDENTIFIER_FILE_NAME), "rw");
        int r103 = (int) r102.length();     // Catch: Throwable -> L9
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L9
        if (r102.read(r104) == r103) goto L7;
        r102.close();
        return null;
    L7:
        r102.close();
        return r104;
    L9:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    public static byte[] readAllBytes(InputStream r100, int r101) throws IOException {
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L13;
        int r104 = r100.read(r102, r103, r101 - r103);
        if (r104 == (-1)) goto L12;
        r103 = r103 + r104;
        if (r103 <= r101) goto L3;
        throw new IllegalStateException("Read more bytes than expected");
    L12:
        throw new EOFException("EOF found unexpectedly");
    L13:
        return r102;
    }

    private static void writeApkIdentifier(Context r100, File r101) throws IOException {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, APK_IDENTIFIER_FILE_NAME);
        byte[] r103 = getApkIdentifier(r100);
        RandomAccessFile r104 = new RandomAccessFile(r102, "rw");
        r104.write(r103);     // Catch: Throwable -> L6
        r104.setLength(r104.getFilePointer());     // Catch: Throwable -> L6
        r104.close();
        return;
    L6:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static void writeState(File r100, byte r101) throws IOException {
        RandomAccessFile r102 = new RandomAccessFile(new PolarisFileWrapper(r100, "state"), "rw");
        r102.seek(0);     // Catch: Throwable -> L6
        r102.write(r101);     // Catch: Throwable -> L6
        r102.setLength(r102.getFilePointer());     // Catch: Throwable -> L6
        r102.getFD().sync();     // Catch: Throwable -> L6
        r102.close();
        return;
    L6:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }
}
