package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public final class AesGcm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277945a = "security:";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277946b = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277947c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277948d = "GCM";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f277949e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f277950f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f277951g = 12;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f277952h = 2;

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }

    private AesGcm() {
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (r100.length() >= 24) goto L8;
        return "";
    L8:
        return r100.substring(24);
    }

    private static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        b.b(f277948d, "IV is invalid.");
        return "";
    L5:
        if (r100.length() < 24) goto L9;
        return r100.substring(0, 24);
    }

    private static byte[] c(byte[] r100) {
        if (r100 != null) goto L5;
    L9:
        b.b(f277948d, "getIV error: bt length less than 12 bytes.");
        return new byte[0];
    L5:
        if (r100.length < 12) goto L9;
        byte[] r101 = new byte[12];
        System.arraycopy(r100, 0, r101, 0, 12);
        return r101;
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] r100) {
        return new GCMParameterSpec(128, r100);
    }

    private static int a(byte[] r100) {
        if (r100[12] != 58) goto L5;
        return 12;
    L5:
        return -1;
    }

    private static byte[] b(byte[] r100) {
        byte[] r101 = new byte[r100.length - 12];
        System.arraycopy(r100, 12, r101, 0, r100.length - 12);
        return r101;
    }

    private static byte[] a(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static String decrypt(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277948d, "decrypt 2 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277948d, "decrypt 2 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L14;
        b.b(f277948d, "decrypt 2 key error: 2 key length less than 16 bytes.");
        return "";
    L14:
        if (isBuildVersionHigherThan19() == true) goto L34;
        b.b(f277948d, "decrypt 2 build version not higher than 19");
        return "";
    L34:
        SecretKeySpec r102 = new SecretKeySpec(r101, "AES");     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        Cipher r103 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        String r104 = b(r100);     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        String r105 = a(r100);     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        if (TextUtils.isEmpty(r104) == false) goto L22;
        b.b(f277948d, "decrypt 2 iv is null");     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        return "";
    L22:
        if (TextUtils.isEmpty(r105) == false) goto L25;
        b.b(f277948d, "decrypt 2 encrypt content is null");     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        return "";
    L25:
        r103.init(2, r102, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(r104)));     // Catch: UnsupportedEncodingException -> L27 Throwable -> L29 NullPointerException -> L31
        return new String(r103.doFinal(HexUtil.hexStr2ByteArray(r105)), "UTF-8");
    L29:
        e = move-exception;
        b.b(f277948d, "GCM decrypt data exception: " + e.getMessage());
        return "";
    }

    public static String decryptWithCryptHead(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (r101 == null) goto L16;
        if (r101.length < 16) goto L16;
        String r102 = AesCbc.c(r100);
        if ("".equals(r102) == false) goto L11;
        return "";
    L11:
        int r103 = r102.indexOf(58);
        if (r103 < 0) goto L15;
        byte[] r104 = HexUtil.hexStr2ByteArray(r102.substring(0, r103));
        return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(r102.substring(r103 + 1))), r101, r104);
    L15:
        b.b(f277948d, " gcm cipherText data missing colon");
    L16:
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] r100, byte[] r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r101.length < 16) goto L19;
        byte[] r102 = AesCbc.d(r100);
        if (r102.length == 0) goto L11;
        int r103 = a(r102);
        if (r103 < 0) goto L16;
        byte[] r104 = Arrays.copyOf(r102, r103);
        int r105 = (r102.length - r104.length) - 1;
        byte[] r106 = new byte[r105];
        System.arraycopy(r102, r103 + 1, r106, 0, r105);
        return decrypt(r106, r101, r104);
    L16:
        b.b(f277948d, " gcm cipherText data missing colon");
        return new byte[0];
    L11:
        return new byte[0];
    L19:
        return new byte[0];
    }

    public static String encrypt(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277948d, "encrypt 2 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277948d, "encrypt 2 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L14;
        b.b(f277948d, "encrypt 2 key error: 2 key length less than 16 bytes.");
        return "";
    L14:
        if (isBuildVersionHigherThan19() == true) goto L17;
        b.b(f277948d, "encrypt 2 build version not higher than 19");
        return "";
    L17:
        byte[] r102 = EncryptUtil.generateSecureRandom(12);
        byte[] r103 = a(r100, r101, r102);
        if (r103 != null) goto L20;
    L24:
        return "";
    L20:
        if (r103.length == 0) goto L24;
        return HexUtil.byteArray2HexStr(r102) + HexUtil.byteArray2HexStr(r103);
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277948d, "decrypt 1 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277948d, "decrypt 1 key is null");
        return "";
    L11:
        if (isBuildVersionHigherThan19() == true) goto L14;
        b.b(f277948d, "decrypt 1 build version not higher than 19");
        return "";
    L14:
        byte[] r102 = HexUtil.hexStr2ByteArray(r101);
        if (r102.length >= 16) goto L19;
        b.b(f277948d, "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    L19:
        return decrypt(r100, r102);
    }

    public static String decryptWithCryptHead(byte[] r100, byte[] r101) {
        return new String(decryptWithCryptHeadReturnByte(r100, r101), "UTF-8");
    L4:
        b.b(f277948d, "UnsupportedEncodingException");
        return "";
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277948d, "encrypt 1 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277948d, "encrypt 1 key is null");
        return "";
    L11:
        if (isBuildVersionHigherThan19() == true) goto L14;
        b.b(f277948d, "encrypt 1 build version not higher than 19");
        return "";
    L14:
        byte[] r102 = HexUtil.hexStr2ByteArray(r101);
        if (r102.length >= 16) goto L19;
        b.b(f277948d, "encrypt key error: key length less than 16 bytes.");
        return "";
    L19:
        return encrypt(r100, r102);
    }

    public static byte[] decrypt(byte[] r100, byte[] r101) {
        byte[] r102 = c(r100);
        if (r102.length >= 12) goto L7;
        b.b(f277948d, "get iv from content error.");
        return new byte[0];
    L7:
        return decrypt(b(r100), r101, r102);
    }

    public static byte[] encrypt(byte[] r100, byte[] r101) {
        byte[] r102 = EncryptUtil.generateSecureRandom(12);
        return a(r102, encrypt(r100, r101, r102));
    }

    private static byte[] a(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277948d, "encrypt 5 content is null");
        return new byte[0];
    L6:
        if (r101 != null) goto L10;
        b.b(f277948d, "encrypt 5 key is null");
        return new byte[0];
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277948d, "encrypt 5 key error: 5 key length less than 16 bytes.");
        return new byte[0];
    L13:
        if (r102 != null) goto L17;
        b.b(f277948d, "encrypt 5 iv is null");
        return new byte[0];
    L17:
        if (r102.length >= 12) goto L21;
        b.b(f277948d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
        return new byte[0];
    L21:
        if (isBuildVersionHigherThan19() == true) goto L29;
        b.b(f277948d, "encrypt 5 build version not higher than 19");
        return new byte[0];
    L29:
        return encrypt(r100.getBytes("UTF-8"), r101, r102);
    L26:
        e = move-exception;
        b.b(f277948d, "GCM encrypt data error" + e.getMessage());
        return new byte[0];
    }

    public static byte[] decrypt(byte[] r100, byte[] r101, byte[] r102) {
        if (r100 != null) goto L7;
        b.b(f277948d, "decrypt 6 content is null");
        return new byte[0];
    L7:
        if (r100.length != 0) goto L10;
        b.b(f277948d, "decrypt 6 content length is 0");
        return new byte[0];
    L10:
        if (r101 != null) goto L14;
        b.b(f277948d, "decrypt 6 key is null");
        return new byte[0];
    L14:
        if (r101.length >= 16) goto L17;
        b.b(f277948d, "decrypt 6 key error: 6 key length less than 16 bytes.");
        return new byte[0];
    L17:
        if (r102 != null) goto L21;
        b.b(f277948d, "decrypt 6 iv is null");
        return new byte[0];
    L21:
        if (r102.length >= 12) goto L25;
        b.b(f277948d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
        return new byte[0];
    L25:
        if (isBuildVersionHigherThan19() == true) goto L33;
        b.b(f277948d, "decrypt 6 build version not higher than 19");
        return new byte[0];
    L33:
        SecretKeySpec r103 = new SecretKeySpec(r101, "AES");     // Catch: GeneralSecurityException -> L30
        Cipher r104 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: GeneralSecurityException -> L30
        r104.init(2, r103, getGcmAlgorithmParams(r102));     // Catch: GeneralSecurityException -> L30
        return r104.doFinal(r100);
    L30:
        e = move-exception;
        b.b(f277948d, "GCM decrypt data exception: " + e.getMessage());
        return new byte[0];
    }

    public static byte[] encrypt(byte[] r100, byte[] r101, byte[] r102) {
        if (r100 != null) goto L7;
        b.b(f277948d, "encrypt 6 content is null");
        return new byte[0];
    L7:
        if (r100.length != 0) goto L10;
        b.b(f277948d, "encrypt 6 content length is 0");
        return new byte[0];
    L10:
        if (r101 != null) goto L14;
        b.b(f277948d, "encrypt 6 key is null");
        return new byte[0];
    L14:
        if (r101.length >= 16) goto L17;
        b.b(f277948d, "encrypt 6 key error: 6 key length less than 16 bytes.");
        return new byte[0];
    L17:
        if (r102 != null) goto L21;
        b.b(f277948d, "encrypt 6 iv is null");
        return new byte[0];
    L21:
        if (r102.length >= 12) goto L25;
        b.b(f277948d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
        return new byte[0];
    L25:
        if (isBuildVersionHigherThan19() == true) goto L36;
        b.b(f277948d, "encrypt 6 build version not higher than 19");
        return new byte[0];
    L36:
        SecretKeySpec r103 = new SecretKeySpec(r101, "AES");     // Catch: NullPointerException -> L30 GeneralSecurityException -> L32
        Cipher r104 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: NullPointerException -> L30 GeneralSecurityException -> L32
        r104.init(1, r103, getGcmAlgorithmParams(r102));     // Catch: NullPointerException -> L30 GeneralSecurityException -> L32
        return r104.doFinal(r100);
    L30:
        e = move-exception;
        b.b(f277948d, "GCM encrypt data error" + e.getMessage());
    L35:
        return new byte[0];
    L32:
        e = move-exception;
        b.b(f277948d, "GCM encrypt data error" + e.getMessage());
        goto L35
    }

    public static String decrypt(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277948d, "decrypt 4 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277948d, "decrypt 4 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277948d, "decrypt 4 key error: 4 key length less than 16 bytes.");
        return "";
    L13:
        if (r102 != null) goto L17;
        b.b(f277948d, "decrypt 4 iv is null");
        return "";
    L17:
        if (r102.length >= 12) goto L21;
        b.b(f277948d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
        return "";
    L21:
        if (isBuildVersionHigherThan19() == true) goto L29;
        b.b(f277948d, "decrypt 4 build version not higher than 19");
        return "";
    L29:
        return new String(decrypt(HexUtil.hexStr2ByteArray(r100), r101, r102), "UTF-8");
    L26:
        e = move-exception;
        b.b(f277948d, "GCM decrypt data exception: " + e.getMessage());
        return "";
    }

    public static String encrypt(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277948d, "encrypt 3 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277948d, "encrypt 3 key is null");
        return "";
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        b.b(f277948d, "encrypt 3 iv is null");
        return "";
    L15:
        if (isBuildVersionHigherThan19() == true) goto L18;
        b.b(f277948d, "encrypt 3 build version not higher than 19");
        return "";
    L18:
        byte[] r103 = HexUtil.hexStr2ByteArray(r101);
        byte[] r104 = HexUtil.hexStr2ByteArray(r102);
        if (r103.length >= 16) goto L23;
        b.b(f277948d, "encrypt 3 key error: 3 key length less than 16 bytes.");
        return "";
    L23:
        if (r104.length >= 12) goto L27;
        b.b(f277948d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
        return "";
    L27:
        return encrypt(r100, r103, r104);
    }

    public static String decrypt(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277948d, "decrypt 3 content is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        b.b(f277948d, "decrypt 3 key is null");
        return "";
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        b.b(f277948d, "decrypt 3 iv is null");
        return "";
    L15:
        if (isBuildVersionHigherThan19() == true) goto L18;
        b.b(f277948d, "decrypt 3 build version not higher than 19");
        return "";
    L18:
        byte[] r103 = HexUtil.hexStr2ByteArray(r101);
        byte[] r104 = HexUtil.hexStr2ByteArray(r102);
        if (r103.length >= 16) goto L23;
        b.b(f277948d, "decrypt 3 key error: 3 key length less than 16 bytes.");
        return "";
    L23:
        if (r104.length >= 12) goto L27;
        b.b(f277948d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
        return "";
    L27:
        return decrypt(r100, r103, r104);
    }

    public static String encrypt(String r100, byte[] r101, byte[] r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        b.b(f277948d, "encrypt 4 content is null");
        return "";
    L6:
        if (r101 != null) goto L10;
        b.b(f277948d, "encrypt 4 key is null");
        return "";
    L10:
        if (r101.length >= 16) goto L13;
        b.b(f277948d, "encrypt 4 key error: 3 key length less than 16 bytes.");
        return "";
    L13:
        if (r102 != null) goto L17;
        b.b(f277948d, "encrypt 4 iv is null");
        return "";
    L17:
        if (r102.length >= 12) goto L21;
        b.b(f277948d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
        return "";
    L21:
        if (isBuildVersionHigherThan19() == true) goto L25;
        b.b(f277948d, "encrypt 4 build version not higher than 19");
        return "";
    L25:
        return HexUtil.byteArray2HexStr(a(r100, r101, r102));
    }
}
