package com.bytedance.mira.util;

import android.util.Base64;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptUtils {
    private static final String AES_Algorithm = "AES";
    public static String AES_Transformation = "AES/ECB/NoPadding";
    private static final String DES_Algorithm = "DES";
    public static String DES_Transformation = "DES/ECB/NoPadding";
    private static final char[] HEX_CHARS = null;
    private static final String TripleDES_Algorithm = "DESede";
    public static String TripleDES_Transformation = "DESede/ECB/NoPadding";
    private static final char[] hexDigits = null;

    static {
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private EncryptUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static byte[] base64Decode(byte[] r100) {
        return Base64.decode(r100, 2);
    }

    private static byte[] base64Encode(byte[] r100) {
        return Base64.encode(r100, 2);
    }

    private static String bytes2HexString(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        if (r101 > 0) goto L8;
        return null;
    L8:
        char[] r102 = new char[r101 << 1];
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r101) goto L12;
        int r105 = r104 + 1;
        char[] r106 = hexDigits;
        byte r107 = r100[r103];
        r102[r104] = r106[(r107 >>> 4) & 15];
        r104 = r105 + 1;
        r102[r105] = r106[r107 & 15];
        r103 = r103 + 1;
        goto L9
    L12:
        return new String(r102);
    }

    public static byte[] encryptMD5(byte[] r100) {
        return hashTemplate(r100, "MD5");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:16777276), block:B:26:0x003c */
    public static byte[] encryptMD5File(File r100) {
        Closeable r101 = null;
        if (r100 != null) goto L32;
        return null;
    L32:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L16 IOException -> L18 NoSuchAlgorithmException -> L20
        DigestInputStream r103 = new DigestInputStream(r102, MessageDigest.getInstance("MD5"));     // Catch: IOException -> L12 NoSuchAlgorithmException -> L14 Throwable -> L25
    L8:
        if (r103.read(new byte[262144]) > 0) goto L8;
        byte[] r104 = r103.getMessageDigest().digest();     // Catch: IOException -> L12 NoSuchAlgorithmException -> L14 Throwable -> L25
        IOUtils.closeSilently(r102);
        return r104;
    L12:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L25
        IOUtils.closeSilently(r102);
        return null;
    L14:
        e = e;
        goto L22
    L18:
        e = e;
    L21:
        r102 = null;
    L20:
        e = e;
    L16:
        th = th;
    L27:
        IOUtils.closeSilently(r101);
        throw th;
    L25:
        th = th;
        r101 = r1;
        goto L27
    }

    public static String encryptMD5File2String(String r100) {
        if (isSpace(r100) == false) goto L5;
        PolarisFileWrapper r101 = null;
    L7:
        return encryptMD5File2String(r101);
    L5:
        r101 = new PolarisFileWrapper(r100);
        goto L7
    }

    public static String encryptMD5ToString(String r100) {
        return encryptMD5ToString(r100.getBytes());
    }

    public static byte[] encryptSHA1(byte[] r100) {
        return hashTemplate(r100, "SHA1");
    }

    public static String encryptSHA1ToString(String r100) {
        return encryptSHA1ToString(r100.getBytes());
    }

    public static byte[] encryptSHA224(byte[] r100) {
        return hashTemplate(r100, "SHA224");
    }

    public static String encryptSHA224ToString(String r100) {
        return encryptSHA224ToString(r100.getBytes());
    }

    public static byte[] encryptSHA256(byte[] r100) {
        return hashTemplate(r100, "SHA256");
    }

    public static String encryptSHA256ToString(String r100) {
        return encryptSHA256ToString(r100.getBytes());
    }

    public static byte[] encryptSHA384(byte[] r100) {
        return hashTemplate(r100, "SHA384");
    }

    public static String encryptSHA384ToString(String r100) {
        return encryptSHA384ToString(r100.getBytes());
    }

    public static byte[] encryptSHA512(byte[] r100) {
        return hashTemplate(r100, "SHA512");
    }

    public static String encryptSHA512ToString(String r100) {
        return encryptSHA512ToString(r100.getBytes());
    }

    public static String getFileSHA256(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L16 Exception -> L18
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L12 Exception -> L14
        MessageDigest r104 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L12 Exception -> L14
    L6:
        int r105 = r102.read(r103);     // Catch: Throwable -> L12 Exception -> L14
        if (r105 <= 0) goto L9;
        r104.update(r103, 0, r105);     // Catch: Throwable -> L12 Exception -> L14
        goto L6
    L9:
        r102.close();     // Catch: Throwable -> L12 Exception -> L14
        String r106 = toHexString(r104.digest());     // Catch: Throwable -> L12 Exception -> L14
        r102.close();     // Catch: IOException -> L27
    L11:
        return r106;
    L14:
        e = e;
        r101 = r102;
    L19:
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r101 == null) goto L43;
        r101.close();     // Catch: IOException -> L29
        return "";
    L44:
        return "";
    L43:
        return "";
    L12:
        th = th;
        r101 = r102;
    L24:
        if (r101 != null) goto L35;
    L26:
        throw th;
    L35:
        r101.close();     // Catch: IOException -> L28
    L16:
        th = th;
    L18:
        e = e;
        goto L19
    }

    private static int hex2Dec(char r100) {
        if (r100 < '0') goto L9;
        if (r100 > '9') goto L9;
        return r100 - '0';
    L9:
        if (r100 < 'A') goto L15;
        if (r100 > 'F') goto L15;
        return (r100 - 'A') + 10;
    L15:
        throw new IllegalArgumentException();
    }

    private static byte[] hexString2Bytes(String r100) {
        if (isSpace(r100) == false) goto L6;
        return null;
    L6:
        int r101 = r100.length();
        if ((r101 % 2) == 0) goto L9;
        r100 = "0".concat(r100);
        r101 = r101 + 1;
    L9:
        char[] r102 = r100.toUpperCase().toCharArray();
        byte[] r103 = new byte[r101 >> 1];
        int r104 = 0;
    L10:
        if (r104 >= r101) goto L12;
        r103[r104 >> 1] = (byte) ((hex2Dec(r102[r104]) << 4) | hex2Dec(r102[r104 + 1]));
        r104 = r104 + 2;
        goto L10
    L12:
        return r103;
    }

    private static boolean isSpace(String r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = r100.length();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (Character.isWhitespace(r100.charAt(r102)) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static String toHexString(byte[] r100) {
        return toHexString(r100, 0, r100.length);
    }

    public static byte[] encryptMD5File(String r100) {
        if (isSpace(r100) == false) goto L5;
        PolarisFileWrapper r101 = null;
    L7:
        return encryptMD5File(r101);
    L5:
        r101 = new PolarisFileWrapper(r100);
        goto L7
    }

    public static String encryptMD5File2String(File r100) {
        return bytes2HexString(encryptMD5File(r100));
    }

    public static String encryptMD5ToString(byte[] r100) {
        return bytes2HexString(encryptMD5(r100));
    }

    public static String encryptSHA1ToString(byte[] r100) {
        return bytes2HexString(encryptSHA1(r100));
    }

    public static String encryptSHA224ToString(byte[] r100) {
        return bytes2HexString(encryptSHA224(r100));
    }

    public static String encryptSHA256ToString(byte[] r100) {
        return bytes2HexString(encryptSHA256(r100));
    }

    public static String encryptSHA384ToString(byte[] r100) {
        return bytes2HexString(encryptSHA384(r100));
    }

    public static String encryptSHA512ToString(byte[] r100) {
        return bytes2HexString(encryptSHA512(r100));
    }

    public static byte[] decrypt3DES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, TripleDES_Algorithm, TripleDES_Transformation, false);
    }

    public static byte[] decryptAES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, "AES", AES_Transformation, false);
    }

    public static byte[] decryptBase64AES(byte[] r100, byte[] r101) {
        return decryptAES(base64Decode(r100), r101);
    }

    public static byte[] decryptBase64DES(byte[] r100, byte[] r101) {
        return decryptDES(base64Decode(r100), r101);
    }

    public static byte[] decryptBase64_3DES(byte[] r100, byte[] r101) {
        return decrypt3DES(base64Decode(r100), r101);
    }

    public static byte[] decryptDES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, DES_Algorithm, DES_Transformation, false);
    }

    public static byte[] decryptHexString3DES(String r100, byte[] r101) {
        return decrypt3DES(hexString2Bytes(r100), r101);
    }

    public static byte[] decryptHexStringAES(String r100, byte[] r101) {
        return decryptAES(hexString2Bytes(r100), r101);
    }

    public static byte[] decryptHexStringDES(String r100, byte[] r101) {
        return decryptDES(hexString2Bytes(r100), r101);
    }

    public static byte[] encrypt3DES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, TripleDES_Algorithm, TripleDES_Transformation, true);
    }

    public static byte[] encrypt3DES2Base64(byte[] r100, byte[] r101) {
        return base64Encode(encrypt3DES(r100, r101));
    }

    public static String encrypt3DES2HexString(byte[] r100, byte[] r101) {
        return bytes2HexString(encrypt3DES(r100, r101));
    }

    public static byte[] encryptAES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, "AES", AES_Transformation, true);
    }

    public static byte[] encryptAES2Base64(byte[] r100, byte[] r101) {
        return base64Encode(encryptAES(r100, r101));
    }

    public static String encryptAES2HexString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptAES(r100, r101));
    }

    public static byte[] encryptDES(byte[] r100, byte[] r101) {
        return desTemplate(r100, r101, DES_Algorithm, DES_Transformation, true);
    }

    public static byte[] encryptDES2Base64(byte[] r100, byte[] r101) {
        return base64Encode(encryptDES(r100, r101));
    }

    public static String encryptDES2HexString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptDES(r100, r101));
    }

    public static byte[] encryptHmacMD5(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacMD5");
    }

    public static String encryptHmacMD5ToString(String r100, String r101) {
        return encryptHmacMD5ToString(r100.getBytes(), r101.getBytes());
    }

    public static byte[] encryptHmacSHA1(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacSHA1");
    }

    public static String encryptHmacSHA1ToString(String r100, String r101) {
        return encryptHmacSHA1ToString(r100.getBytes(), r101.getBytes());
    }

    public static byte[] encryptHmacSHA224(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacSHA224");
    }

    public static String encryptHmacSHA224ToString(String r100, String r101) {
        return encryptHmacSHA224ToString(r100.getBytes(), r101.getBytes());
    }

    public static byte[] encryptHmacSHA256(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacSHA256");
    }

    public static String encryptHmacSHA256ToString(String r100, String r101) {
        return encryptHmacSHA256ToString(r100.getBytes(), r101.getBytes());
    }

    public static byte[] encryptHmacSHA384(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacSHA384");
    }

    public static String encryptHmacSHA384ToString(String r100, String r101) {
        return encryptHmacSHA384ToString(r100.getBytes(), r101.getBytes());
    }

    public static byte[] encryptHmacSHA512(byte[] r100, byte[] r101) {
        return hmacTemplate(r100, r101, "HmacSHA512");
    }

    public static String encryptHmacSHA512ToString(String r100, String r101) {
        return encryptHmacSHA512ToString(r100.getBytes(), r101.getBytes());
    }

    public static String encryptMD5ToString(byte[] r100, byte[] r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return bytes2HexString(encryptMD5(r102));
    L9:
        return null;
    L7:
        return null;
    }

    private static byte[] hashTemplate(byte[] r100, String r101) {
        if (r100 != null) goto L5;
    L11:
        return null;
    L5:
        if (r100.length <= 0) goto L11;
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: NoSuchAlgorithmException -> L9
        r102.update(r100);     // Catch: NoSuchAlgorithmException -> L9
        return r102.digest();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String encryptHmacMD5ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacMD5(r100, r101));
    }

    public static String encryptHmacSHA1ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacSHA1(r100, r101));
    }

    public static String encryptHmacSHA224ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacSHA224(r100, r101));
    }

    public static String encryptHmacSHA256ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacSHA256(r100, r101));
    }

    public static String encryptHmacSHA384ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacSHA384(r100, r101));
    }

    public static String encryptHmacSHA512ToString(byte[] r100, byte[] r101) {
        return bytes2HexString(encryptHmacSHA512(r100, r101));
    }

    public static String encryptMD5ToString(String r100, String r101) {
        return bytes2HexString(encryptMD5((r100 + r101).getBytes()));
    }

    private static byte[] hmacTemplate(byte[] r100, byte[] r101, String r102) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (r100.length == 0) goto L16;
        if (r101 == null) goto L16;
        if (r101.length == 0) goto L16;
        SecretKeySpec r103 = new SecretKeySpec(r101, r102);     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        Mac r104 = Mac.getInstance(r102);     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        r104.init(r103);     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        return r104.doFinal(r100);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private static String toHexString(byte[] r100, int r110, int r111) {
        if (r110 < 0) goto L11;
        if ((r110 + r111) > r100.length) goto L11;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r111) goto L9;
        int r105 = r100[r110 + r103] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return String.valueOf(r102, 0, r101);
    L11:
        throw new IndexOutOfBoundsException();
    }

    public static byte[] desTemplate(byte[] r100, byte[] r101, String r102, String r103, boolean r104) {
        if (r100 != null) goto L5;
    L18:
        return null;
    L5:
        if (r100.length == 0) goto L18;
        if (r101 == null) goto L18;
        if (r101.length == 0) goto L18;
        SecretKeySpec r105 = new SecretKeySpec(r101, r102);     // Catch: Throwable -> L16
        Cipher r106 = Cipher.getInstance(r103);     // Catch: Throwable -> L16
        SecureRandom r107 = new SecureRandom();     // Catch: Throwable -> L16
        if (r104 == false) goto L13;
        int r108 = 1;
    L14:
        r106.init(r108, r105, r107);     // Catch: Throwable -> L16
        return r106.doFinal(r100);
    L13:
        r108 = 2;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
