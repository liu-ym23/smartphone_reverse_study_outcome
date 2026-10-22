package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes23.dex */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = null;
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public CreateFileUtil() {
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static String byteArrayToHex(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r105 = r100[r103];
        int r106 = r104 + 1;
        char[] r107 = HEX_DIGITS;
        r101[r104] = r107[(r105 >>> 4) & 15];
        r104 = r106 + 1;
        r101[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L3
    L6:
        return new String(r101);
    }

    public static void deleteSecure(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.delete() == true) goto L11;
        Logger.w(TAG, "deleteSecure exception");
        return;
    }

    public static String getCacheDirPath(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return ContextCompat.getProtectedStorageContext(r100).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String r100) {
    L16:
        return newFile(r100).getCanonicalPath();
    L9:
        e = move-exception;
        Logger.w(TAG, "the canonicalPath has IOException", e);
        return r100;
    L7:
        e = move-exception;
        Logger.w(TAG, "the canonicalPath has securityException", e);
        return r100;
    L5:
        e = move-exception;
        Logger.w(TAG, "the canonicalPath has other Exception", e);
        return r100;
    }

    public static File newFile(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (EmuiUtil.isUpPVersion() == false) goto L12;
        if (ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME) == false) goto L12;
        return new ExternalStorageFile(r100);
    L12:
        return new PolarisFileWrapper(r100);
    }

    public static FileInputStream newFileInputStream(String r100) throws FileNotFoundException {
        if (r100 != null) goto L4;
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    L4:
        if (EmuiUtil.isUpPVersion() == false) goto L10;
        if (ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME) == false) goto L10;
        return new ExternalStorageFileInputStream(r100);
    L10:
        return new PolarisFileInputStreamWrapper(r100);
    }

    public static FileOutputStream newFileOutputStream(File r100) throws FileNotFoundException {
        if (r100 != null) goto L4;
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    L4:
        if (EmuiUtil.isUpPVersion() == false) goto L10;
        if (ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME) == false) goto L10;
        return new ExternalStorageFileOutputStream(r100);
    L10:
        return new PolarisFileOutputStreamWrapper(r100);
    }

    public static File newSafeFile(String r100) {
        if (r100 != null) goto L14;
        return null;
    L14:
        File r101 = newFile(r100);     // Catch: Throwable -> L10 RuntimeException -> L11
        if (r101.exists() == true) goto L16;
        return new PolarisFileWrapper(r100);
    L16:
        return r101;
    L11:
        Logger.w(TAG, "newFile is runtimeException");
    L13:
        return new PolarisFileWrapper(r100);
    L10:
        Logger.w(TAG, "newFile is Throwable");
        goto L13
    }

    public static FileInputStream newSafeFileInputStream(String r100) throws FileNotFoundException {
        return newFileInputStream(r100);
    L7:
        Logger.w(TAG, "newFileInputStream is fileNotFoundException");
    L9:
        return new PolarisFileInputStreamWrapper(r100);
    L6:
        Logger.w(TAG, "newFileInputStream is runtimeException");
    L5:
        Logger.w(TAG, "newFileInputStream is Throwable");
        goto L9
    }

    public static FileOutputStream newSafeFileOutputStream(File r100) throws FileNotFoundException {
        return newFileOutputStream(r100);
    L7:
        Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
    L9:
        return new PolarisFileOutputStreamWrapper(r100);
    L6:
        Logger.w(TAG, "newFileOutputStream is runtimeException");
    L5:
        Logger.w(TAG, "newFileOutputStream is Throwable");
        goto L9
    }

    public static void deleteSecure(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        deleteSecure(newFile(r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static String getFileHashData(String r110, String r111) {
        ?? r100 = 0;
        String r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        MessageDigest r112 = MessageDigest.getInstance(r111);     // Catch: Throwable -> L27 IndexOutOfBoundsException -> L29 IllegalArgumentException -> L34 IOException -> L39 FileNotFoundException -> L44 NoSuchAlgorithmException -> L49
        FileInputStream r113 = newSafeFileInputStream(r110);     // Catch: Throwable -> L27 IndexOutOfBoundsException -> L29 IllegalArgumentException -> L34 IOException -> L39 FileNotFoundException -> L44 NoSuchAlgorithmException -> L49
    L65:
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L15 IndexOutOfBoundsException -> L17 IllegalArgumentException -> L19 IOException -> L21 FileNotFoundException -> L23 NoSuchAlgorithmException -> L25
        long r103 = 0;
    L6:
        int r104 = r113.read(r102);     // Catch: Throwable -> L15 IndexOutOfBoundsException -> L17 IllegalArgumentException -> L19 IOException -> L21 FileNotFoundException -> L23 NoSuchAlgorithmException -> L25
        if (r104 == (-1)) goto L10;
        r112.update(r102, 0, r104);     // Catch: Throwable -> L15 IndexOutOfBoundsException -> L17 IllegalArgumentException -> L19 IOException -> L21 FileNotFoundException -> L23 NoSuchAlgorithmException -> L25
        r103 = r103 + ((long) r104);     // Catch: Throwable -> L15 IndexOutOfBoundsException -> L17 IllegalArgumentException -> L19 IOException -> L21 FileNotFoundException -> L23 NoSuchAlgorithmException -> L25
        goto L6
    L10:
        if (r103 <= 0) goto L60;
        r101 = byteArrayToHex(r112.digest());     // Catch: Throwable -> L15 IndexOutOfBoundsException -> L17 IllegalArgumentException -> L19 IOException -> L21 FileNotFoundException -> L23 NoSuchAlgorithmException -> L25
    L60:
        r113.close();     // Catch: IOException -> L14
    L54:
        return r101;
    L14:
        Logger.e(TAG, "Close FileInputStream failed!");
    L23:
        e = e;
    L46:
        Logger.e(TAG, "getFileHashData FileNotFoundException", e);     // Catch: Throwable -> L15
        if (r113 == null) goto L54;
    L21:
        e = e;
    L41:
        Logger.e(TAG, "getFileHashData IOException", e);     // Catch: Throwable -> L15
        if (r113 == null) goto L54;
    L19:
        e = e;
    L36:
        Logger.e(TAG, "getFileHashData IllegalArgumentException", e);     // Catch: Throwable -> L15
        if (r113 == null) goto L54;
    L17:
        e = e;
    L31:
        Logger.e(TAG, "getFileHashData IndexOutOfBoundsException", e);     // Catch: Throwable -> L15
        if (r113 == null) goto L54;
    L25:
        e = e;
    L51:
        Logger.e(TAG, "getFileHashData NoSuchAlgorithmException", e);     // Catch: Throwable -> L15
        if (r113 == null) goto L54;
    L15:
        th = th;
        r100 = r110;
    L55:
        if (r100 != 0) goto L63;
    L59:
        throw th;
    L63:
        r100.close();     // Catch: IOException -> L58
    L58:
        Logger.e(TAG, "Close FileInputStream failed!");
    L44:
        e = e;
        r113 = null;
    L39:
        e = e;
        r113 = null;
    L34:
        e = e;
        r113 = null;
    L29:
        e = e;
        r113 = null;
    L49:
        e = e;
        r113 = null;
    L27:
        th = th;
        goto L55
    }

    public static RandomAccessFile newRandomAccessFile(String r100, String r101) throws FileNotFoundException {
        if (r100 != null) goto L4;
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    L4:
        if (EmuiUtil.isUpPVersion() == false) goto L10;
        if (ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME) == false) goto L10;
        return new ExternalStorageRandomAccessFile(r100, r101);
    L10:
        return new RandomAccessFile(r100, r101);
    }

    public static RandomAccessFile newSafeRandomAccessFile(String r100, String r101) throws FileNotFoundException {
        if (r100 != null) goto L13;
        Logger.w(TAG, "newRandomAccessFile  file is null");
        throw new FileNotFoundException("file is null");
    L13:
        return newRandomAccessFile(r100, r101);
    L8:
        Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
    L10:
        return new RandomAccessFile(r100, r101);
    L7:
        Logger.w(TAG, "newRandomAccessFile is runtimeException");
    L6:
        Logger.w(TAG, "newRandomAccessFile is Throwable");
        goto L10
    }
}
