package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public final class AesCbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277938a = "security:";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277939b = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277940c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277941d = "CBC";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f277942e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f277943f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f277944g = 16;

    private AesCbc() {
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return r100.substring(0, 6) + r100.substring(12, 16) + r100.substring(26, 32) + r100.substring(48);
    L7:
        e = move-exception;
        b.b(f277941d, "get encryptword exception : " + e.getMessage());
        return "";
    }

    private static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return r100.substring(6, 12) + r100.substring(16, 26) + r100.substring(32, 48);
    L7:
        e = move-exception;
        b.b(f277941d, "getIv exception : " + e.getMessage());
        return "";
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        if (r100.indexOf(f277938a) != (-1)) goto L9;
        return "";
    L9:
        return r100.substring(9);
    }

    public static byte[] d(byte[] r100) {
        String r101 = new String(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L4
    L7:
        if (r101.startsWith(f277938a) == true) goto L11;
        return new byte[0];
    L11:
        if (r100.length <= 9) goto L15;
        int r102 = r100.length - 9;
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, 9, r103, 0, r102);
        return r103;
    L15:
        return new byte[0];
    L4:
        e = move-exception;
        b.b(f277941d, "stripCryptHead: exception : " + e.getMessage());
        r101 = "";
        goto L7
    }

    private static int a(byte[] r100) {
        if (r100[16] != 58) goto L5;
        return 16;
    L5:
        return -1;
    }

    private static byte[] b(byte[] r100) {
        if (r100 != null) goto L5;
    L9:
        b.b(f277941d, "get content error, because bt length is less than 16");
        return new byte[0];
    L5:
        if (r100.length <= 16) goto L9;
        byte[] r101 = new byte[r100.length - 16];
        System.arraycopy(r100, 16, r101, 0, r100.length - 16);
        return r101;
    }

    private static byte[] c(byte[] r100) {
        if (r100 != null) goto L5;
    L9:
        b.b(f277941d, "get iv error, because bt length is less than 16");
        return new byte[0];
    L5:
        if (r100.length <= 16) goto L9;
        byte[] r101 = new byte[16];
        System.arraycopy(r100, 0, r101, 0, 16);
        return r101;
    }

    private static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r101.substring(0, 6) + r100.substring(0, 6) + r101.substring(6, 10) + r100.substring(6, 16) + r101.substring(10, 16) + r100.substring(16) + r101.substring(16);
    L9:
        e = move-exception;
        b.b(f277941d, "mix exception: " + e.getMessage());
        goto L11
    }

    public static String decrypt(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277941d, "decrypt 2 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277941d, "decrypt 2 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277941d, "decrypt 2 key error: 2 key length less than 16 bytes.");
        return "";
    L13:
        String r102 = b(r100);
        String r103 = a(r100);
        if (TextUtils.isEmpty(r102) == false) goto L18;
        b.b(f277941d, "decrypt 2 iv is null");
        return "";
    L18:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        b.b(f277941d, "decrypt 2 encrypt content is null");
        return "";
    L22:
        return decrypt(r103, r101, HexUtil.hexStr2ByteArray(r102));
    }

    public static String decryptWithCryptHead(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (r101 == null) goto L16;
        if (r101.length < 16) goto L16;
        String r102 = c(r100);
        if ("".equals(r102) == false) goto L11;
        return "";
    L11:
        int r103 = r102.indexOf(58);
        if (r103 < 0) goto L15;
        byte[] r104 = HexUtil.hexStr2ByteArray(r102.substring(0, r103));
        return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(r102.substring(r103 + 1))), r101, r104);
    L15:
        b.b(f277941d, " cbc cipherText data missing colon");
    L16:
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] r100, byte[] r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r101.length < 16) goto L19;
        byte[] r102 = d(r100);
        if (r102.length == 0) goto L11;
        int r103 = a(r102);
        if (r103 < 0) goto L16;
        byte[] r104 = Arrays.copyOf(r102, r103);
        int r105 = (r102.length - r104.length) - 1;
        byte[] r106 = new byte[r105];
        System.arraycopy(r102, r103 + 1, r106, 0, r105);
        return decrypt(r106, r101, r104);
    L16:
        b.b(f277941d, " cbc cipherText data missing colon");
        return new byte[0];
    L11:
        return new byte[0];
    L19:
        return new byte[0];
    }

    public static String encrypt(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277941d, "encrypt 2 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277941d, "encrypt 2 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277941d, "encrypt 2 key error: 2 key length less than 16 bytes.");
        return "";
    L13:
        byte[] r102 = EncryptUtil.generateSecureRandom(16);
        byte[] r103 = a(r100, r101, r102);
        if (r103 != null) goto L16;
    L20:
        return "";
    L16:
        if (r103.length == 0) goto L20;
        return a(HexUtil.byteArray2HexStr(r102), HexUtil.byteArray2HexStr(r103));
    }

    private static byte[] a(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277941d, "decrypt 1 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        b.b(f277941d, "decrypt 1 key is null");
        return "";
    L10:
        byte[] r102 = HexUtil.hexStr2ByteArray(r101);
        if (r102.length >= 16) goto L15;
        b.b(f277941d, "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    L15:
        return decrypt(r100, r102);
    }

    public static String decryptWithCryptHead(byte[] r100, byte[] r101) {
        return new String(decryptWithCryptHeadReturnByte(r100, r101), "UTF-8");
    L4:
        b.b(f277941d, "decryptWithCryptHead UnsupportedEncodingException ");
        return "";
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277941d, "encrypt 1 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        b.b(f277941d, "encrypt 1 key is null");
        return "";
    L10:
        byte[] r102 = HexUtil.hexStr2ByteArray(r101);
        if (r102.length >= 16) goto L15;
        b.b(f277941d, "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    L15:
        return encrypt(r100, r102);
    }

    public static byte[] decrypt(byte[] r100, byte[] r101) {
        byte[] r102 = c(r100);
        return decrypt(b(r100), r101, r102);
    }

    public static byte[] encrypt(byte[] r100, byte[] r101) {
        byte[] r102 = EncryptUtil.generateSecureRandom(16);
        byte[] r103 = encrypt(r100, r101, r102);
        if (Arrays.equals(r103, new byte[0]) == false) goto L7;
        b.b(f277941d, "encrypt encryptContent is null");
        return new byte[0];
    L7:
        return a(r102, r103);
    }

    private static byte[] a(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277941d, "encrypt 5 content is null");
        return new byte[0];
    L6:
        if (r101 != null) goto L10;
        b.b(f277941d, "encrypt 5 key is null");
        return new byte[0];
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277941d, "encrypt 5 key error: 5 key length less than 16 bytes.");
        return new byte[0];
    L13:
        if (r102 != null) goto L17;
        b.b(f277941d, "encrypt 5 iv is null");
        return new byte[0];
    L17:
        if (r102.length >= 16) goto L25;
        b.b(f277941d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
        return new byte[0];
    L25:
        return encrypt(r100.getBytes("UTF-8"), r101, r102);
    L22:
        e = move-exception;
        b.b(f277941d, " cbc encrypt data error" + e.getMessage());
        return new byte[0];
    }

    public static byte[] decrypt(byte[] r100, byte[] r101, byte[] r102) {
        if (r100 != null) goto L7;
        b.b(f277941d, "decrypt 6 content is null");
        return new byte[0];
    L7:
        if (r100.length != 0) goto L10;
        b.b(f277941d, "decrypt 6 content length is 0");
        return new byte[0];
    L10:
        if (r101 != null) goto L14;
        b.b(f277941d, "decrypt 6 key is null");
        return new byte[0];
    L14:
        if (r101.length >= 16) goto L17;
        b.b(f277941d, "decrypt 6 key error: 6 key length less than 16 bytes.");
        return new byte[0];
    L17:
        if (r102 != null) goto L21;
        b.b(f277941d, "decrypt 6 iv is null");
        return new byte[0];
    L21:
        if (r102.length >= 16) goto L24;
        b.b(f277941d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
        return new byte[0];
    L24:
        SecretKeySpec r103 = new SecretKeySpec(r101, "AES");
        Cipher r104 = Cipher.getInstance(f277939b);     // Catch: NullPointerException -> L27 BadPaddingException -> L29 IllegalBlockSizeException -> L31 InvalidAlgorithmParameterException -> L33 InvalidKeyException -> L35 NoSuchPaddingException -> L37 NoSuchAlgorithmException -> L39
        r104.init(2, r103, new IvParameterSpec(r102));     // Catch: NullPointerException -> L27 BadPaddingException -> L29 IllegalBlockSizeException -> L31 InvalidAlgorithmParameterException -> L33 InvalidKeyException -> L35 NoSuchPaddingException -> L37 NoSuchAlgorithmException -> L39
        return r104.doFinal(r100);
    L27:
        e = move-exception;
        b.b(f277941d, "NullPointerException: " + e.getMessage());
    L42:
        return new byte[0];
    L33:
        e = move-exception;
        b.b(f277941d, "InvalidAlgorithmParameterException: " + e.getMessage());
    L35:
        e = move-exception;
        b.b(f277941d, "InvalidKeyException: " + e.getMessage());
    L39:
        e = move-exception;
        b.b(f277941d, "NoSuchAlgorithmException: " + e.getMessage());
    L29:
        e = move-exception;
        b.b(f277941d, "BadPaddingException: " + e.getMessage());
        b.b(f277941d, "key is not right");
    L31:
        e = move-exception;
        b.b(f277941d, "IllegalBlockSizeException: " + e.getMessage());
    L37:
        e = move-exception;
        b.b(f277941d, "NoSuchPaddingException: " + e.getMessage());
        goto L42
    }

    public static byte[] encrypt(byte[] r100, byte[] r101, byte[] r102) {
        if (r100 != null) goto L7;
        b.b(f277941d, "encrypt 6 content is null");
        return new byte[0];
    L7:
        if (r100.length != 0) goto L10;
        b.b(f277941d, "encrypt 6 content length is 0");
        return new byte[0];
    L10:
        if (r101 != null) goto L14;
        b.b(f277941d, "encrypt 6 key is null");
        return new byte[0];
    L14:
        if (r101.length >= 16) goto L17;
        b.b(f277941d, "encrypt 6 key error: 6 key length less than 16 bytes.");
        return new byte[0];
    L17:
        if (r102 != null) goto L21;
        b.b(f277941d, "encrypt 6 iv is null");
        return new byte[0];
    L21:
        if (r102.length >= 16) goto L24;
        b.b(f277941d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
        return new byte[0];
    L24:
        SecretKeySpec r103 = new SecretKeySpec(r101, "AES");
        Cipher r104 = Cipher.getInstance(f277939b);     // Catch: NullPointerException -> L27 BadPaddingException -> L29 IllegalBlockSizeException -> L31 InvalidAlgorithmParameterException -> L33 InvalidKeyException -> L35 NoSuchPaddingException -> L37 NoSuchAlgorithmException -> L39
        r104.init(1, r103, new IvParameterSpec(r102));     // Catch: NullPointerException -> L27 BadPaddingException -> L29 IllegalBlockSizeException -> L31 InvalidAlgorithmParameterException -> L33 InvalidKeyException -> L35 NoSuchPaddingException -> L37 NoSuchAlgorithmException -> L39
        return r104.doFinal(r100);
    L27:
        e = move-exception;
        b.b(f277941d, "NullPointerException: " + e.getMessage());
    L42:
        return new byte[0];
    L33:
        e = move-exception;
        b.b(f277941d, "InvalidAlgorithmParameterException: " + e.getMessage());
    L35:
        e = move-exception;
        b.b(f277941d, "InvalidKeyException: " + e.getMessage());
    L39:
        e = move-exception;
        b.b(f277941d, "NoSuchAlgorithmException: " + e.getMessage());
    L29:
        e = move-exception;
        b.b(f277941d, "BadPaddingException: " + e.getMessage());
    L31:
        e = move-exception;
        b.b(f277941d, "IllegalBlockSizeException: " + e.getMessage());
    L37:
        e = move-exception;
        b.b(f277941d, "NoSuchPaddingException: " + e.getMessage());
        goto L42
    }

    public static String decrypt(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277941d, "decrypt 4 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277941d, "decrypt 4 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277941d, "decrypt 4 key error: 4 key length less than 16 bytes.");
        return "";
    L13:
        if (r102 != null) goto L17;
        b.b(f277941d, "decrypt 4 iv is null");
        return "";
    L17:
        if (r102.length >= 16) goto L25;
        b.b(f277941d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
        return "";
    L25:
        return new String(decrypt(HexUtil.hexStr2ByteArray(r100), r101, r102), "UTF-8");
    L22:
        e = move-exception;
        b.b(f277941d, " cbc decrypt data error" + e.getMessage());
        return "";
    }

    public static String encrypt(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277941d, "encrypt 3 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277941d, "encrypt 3 key is null");
        return "";
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        b.b(f277941d, "encrypt 3 iv is null");
        return "";
    L14:
        byte[] r103 = HexUtil.hexStr2ByteArray(r101);
        byte[] r104 = HexUtil.hexStr2ByteArray(r102);
        if (r103.length >= 16) goto L19;
        b.b(f277941d, "encrypt 3 key error: 3 key length less than 16 bytes.");
        return "";
    L19:
        if (r104.length >= 16) goto L23;
        b.b(f277941d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
        return "";
    L23:
        return encrypt(r100, r103, r104);
    }

    public static String decrypt(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277941d, "decrypt 3 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277941d, "decrypt 3 key is null");
        return "";
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        b.b(f277941d, "decrypt 3 iv is null");
        return "";
    L14:
        byte[] r103 = HexUtil.hexStr2ByteArray(r101);
        byte[] r104 = HexUtil.hexStr2ByteArray(r102);
        if (r103.length >= 16) goto L19;
        b.b(f277941d, "decrypt 3 key error: 3 key length less than 16 bytes.");
        return "";
    L19:
        if (r104.length >= 16) goto L23;
        b.b(f277941d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
        return "";
    L23:
        return decrypt(r100, r103, r104);
    }

    public static String encrypt(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277941d, "encrypt 4 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277941d, "encrypt 4 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277941d, "encrypt 4 key error: 4 key length less than 16 bytes.");
        return "";
    L13:
        if (r102 != null) goto L17;
        b.b(f277941d, "encrypt 4 iv is null");
        return "";
    L17:
        if (r102.length >= 16) goto L21;
        b.b(f277941d, "encrypt 4 iv error: 4 iv length less than 16 bytes.");
        return "";
    L21:
        return HexUtil.byteArray2HexStr(a(r100, r101, r102));
    }
}
