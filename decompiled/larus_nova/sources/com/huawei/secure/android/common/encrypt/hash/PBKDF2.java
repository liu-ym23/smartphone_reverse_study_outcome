package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public abstract class PBKDF2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277976a = "PBKDF2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277977b = "PBKDF2WithHmacSHA1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277978c = "PBKDF2WithHmacSHA256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277979d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f277980e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f277981f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f277982g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f277983h = 10000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f277984i = 1000;

    public PBKDF2() {
    }

    public static String pbkdf2Encrypt(String r100) {
        return pbkdf2Encrypt(r100, 10000);
    }

    public static String pbkdf2EncryptNew(String r100) {
        return pbkdf2EncryptNew(r100, 10000);
    }

    private static boolean a(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L19;
        int r102 = r100.length ^ r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r100.length) goto L12;
        if (r103 >= r101.length) goto L12;
        r102 = r102 | (r100[r103] ^ r101[r103]);
        r103 = r103 + 1;
    L12:
        if (r102 != 0) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L17:
        return false;
    }

    public static String pbkdf2Encrypt(String r100, int r101) {
        return pbkdf2Encrypt(r100, EncryptUtil.generateSecureRandom(8), r101, 32);
    }

    public static String pbkdf2EncryptNew(String r100, int r101) {
        return pbkdf2EncryptNew(r100, EncryptUtil.generateSecureRandom(16), r101, 32);
    }

    public static boolean validatePassword(String r100, String r101) {
        return validatePassword(r100, r101, 10000);
    }

    public static boolean validatePasswordNew(String r100, String r101) {
        return validatePasswordNew(r100, r101, 10000);
    }

    public static boolean validatePassword(String r100, String r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.length() <= 16) goto L11;
        String r103 = r101.substring(0, 16);
        String r104 = r101.substring(16);
        return a(pbkdf2(r100.toCharArray(), HexUtil.hexStr2ByteArray(r103), r102, 256), HexUtil.hexStr2ByteArray(r104));
    }

    public static boolean validatePasswordNew(String r100, String r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L20:
        b.b(f277976a, "password or encryptPassword is null.");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        if (r101.length() > 32) goto L12;
        b.b(f277976a, "encryptPassword length is must be more than (salt len * 2).");
        return false;
    L12:
        if (r102 >= 10000) goto L14;
        b.b(f277976a, "iterations times is not enough, Iterations must be performed for at least 10000 times, It is recommended that you perform iterations for at least 10000 times.");
    L14:
        String r103 = r101.substring(0, 32);
        String r104 = r101.substring(32);
        if (Build.VERSION.SDK_INT >= 26) goto L17;
        byte[] r105 = pbkdf2(r100.toCharArray(), HexUtil.hexStr2ByteArray(r103), r102, 256);
    L19:
        return a(r105, HexUtil.hexStr2ByteArray(r104));
    L17:
        r105 = pbkdf2SHA256(r100.toCharArray(), HexUtil.hexStr2ByteArray(r103), r102, 256);
        goto L19
    }

    public static byte[] pbkdf2(char[] r100, byte[] r101, int r102, int r103) {
        return a(r100, r101, r102, r103, false);
    }

    public static String pbkdf2Encrypt(String r100, byte[] r101, int r102, int r103) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277976a, "pwd is null.");
        return "";
    L7:
        if (r102 >= 1000) goto L10;
        b.b(f277976a, "iterations times is not enough.");
        return "";
    L10:
        if (r101 != null) goto L12;
    L20:
        b.b(f277976a, "salt parameter is null or length is not enough");
        return "";
    L12:
        if (r101.length < 8) goto L20;
        if (r103 >= 32) goto L19;
        b.b(f277976a, "cipherLen length is not enough");
        return "";
    L19:
        return HexUtil.byteArray2HexStr(r101) + HexUtil.byteArray2HexStr(pbkdf2(r100.toCharArray(), r101, r102, r103 * 8));
    }

    public static String pbkdf2EncryptNew(String r100, byte[] r101, int r102, int r103) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        b.b(f277976a, "pwd is null.");
        return "";
    L7:
        if (r102 >= 1000) goto L10;
        b.b(f277976a, "iterations times is not enough.");
        return "";
    L10:
        if (r101 != null) goto L12;
    L24:
        b.b(f277976a, "salt parameter is null or length is not enough");
        return "";
    L12:
        if (r101.length < 16) goto L24;
        if (r103 >= 32) goto L19;
        b.b(f277976a, "cipherLen length is not enough");
        return "";
    L19:
        if (Build.VERSION.SDK_INT >= 26) goto L21;
        b.c(f277976a, "sha 1");
        byte[] r104 = pbkdf2(r100.toCharArray(), r101, r102, r103 * 8);
    L23:
        return HexUtil.byteArray2HexStr(r101) + HexUtil.byteArray2HexStr(r104);
    L21:
        b.c(f277976a, "sha 256");
        r104 = pbkdf2SHA256(r100.toCharArray(), r101, r102, r103 * 8);
        goto L23
    }

    public static byte[] pbkdf2SHA256(char[] r100, byte[] r101, int r102, int r103) {
        byte[] r104 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        b.b(f277976a, "system version not high than 26");
        return r104;
    L7:
        return a(r100, r101, r102, r103, true);
    }

    private static byte[] a(char[] r100, byte[] r101, int r102, int r103, boolean r104) {
        if (r100 != null) goto L5;
    L27:
        b.b(f277976a, "pbkdf password is empty.");
        return new byte[0];
    L5:
        if (r100.length <= 0) goto L27;
        if (r101 != null) goto L9;
    L25:
        b.b(f277976a, "pbkdf salt is empty.");
        return new byte[0];
    L9:
        if (r101.length <= 0) goto L25;
        if (r101.length >= 16) goto L16;
        b.b(f277976a, "pbkdf salt parameter length is not enough, length must be more than 16.");
        return new byte[0];
    L16:
        if (r102 >= 1000) goto L20;
        b.b(f277976a, "pbkdf iterations parameter count is less than 1000.");
        return new byte[0];
    L20:
        if (r103 >= 256) goto L24;
        b.b(f277976a, "pbkdf bytes parameter count is less than 256.");
        return new byte[0];
    L24:
        return pbkdfBottom(r100, r101, r102, r103, r104);
    }

    public static byte[] pbkdfBottom(char[] r100, byte[] r101, int r102, int r103, boolean r104) {
        PBEKeySpec r105 = new PBEKeySpec(r100, r101, r102, r103);     // Catch: InvalidKeySpecException -> L8 Throwable -> L10
        if (r104 == false) goto L5;
        SecretKeyFactory r106 = SecretKeyFactory.getInstance(f277978c);     // Catch: InvalidKeySpecException -> L8 Throwable -> L10
    L6:
        return r106.generateSecret(r105).getEncoded();
    L5:
        r106 = SecretKeyFactory.getInstance(f277977b);     // Catch: InvalidKeySpecException -> L8 Throwable -> L10
    L10:
        e = move-exception;
        b.b(f277976a, "pbkdf exception : " + e.getMessage());
        return new byte[0];
    }
}
