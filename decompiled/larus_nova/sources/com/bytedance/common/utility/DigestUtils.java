package com.bytedance.common.utility;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class DigestUtils {
    private static final int BYTE_RANGE = 8192;
    static final char[] HEX_CHARS = null;
    private static final int MAX_STRING = 4;
    private static final int RADIX = 16;
    private static final int RADIX_OFFSET = 4;
    private static final int STRING_MASK_F = 15;
    private static final int STRING_MASK_FF = 255;

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private DigestUtils() {
    }

    public static byte[] hexStringToBytes(String r100) throws IllegalArgumentException {
        if (r100 == null) goto L10;
        if ((r100.length() % 2) == 1) goto L10;
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        byte[] r103 = new byte[r102 / 2];
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L8;
        r103[r104 / 2] = (byte) ((Character.digit(r101[r104], 16) << 4) + Character.digit(r101[r104 + 1], 16));
        r104 = r104 + 2;
        goto L6
    L8:
        return r103;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r100);
    }

    public static String md5Hex(File r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        if (r101 != null) goto L6;
        return null;
    L6:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L12
        byte[] r103 = new byte[8192];     // Catch: Exception -> L12
    L7:
        int r104 = r102.read(r103, 0, 8192);     // Catch: Exception -> L12
        if (r104 <= 0) goto L10;
        r101.update(r103, 0, r104);     // Catch: Exception -> L12
        goto L7
    L10:
        r102.close();     // Catch: Exception -> L12
        return toHexString(r101.digest());
    L12:
        return null;
    }

    public static String toHexString(byte[] r100) {
        if (r100 == null) goto L6;
        return toHexString(r100, 0, r100.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String md5Hex(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r101.digest());
    }

    public static String md5Hex(byte[] r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100);     // Catch: Exception -> L10
        return toHexString(r101.digest());
    }

    public static String md5Hex(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L12;
        if (r101 < 0) goto L12;
        if (r102 <= 0) goto L12;
        if ((r101 + r102) > r100.length) goto L12;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L13
        r103.update(r100, r101, r102);     // Catch: Exception -> L13
        return toHexString(r103.digest());
    L12:
        return null;
    }

    public static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L14;
        if (r110 < 0) goto L12;
        if ((r110 + r111) > r100.length) goto L12;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r111) goto L10;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return new String(r102, 0, r101);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
