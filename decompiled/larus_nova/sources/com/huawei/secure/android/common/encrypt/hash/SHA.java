package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes23.dex */
public final class SHA {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277985a = "SHA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277986b = "SHA-256";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277987c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f277988d = null;

    static {
        f277988d = new String[]{"SHA-256", McElieceCCA2KeyGenParameterSpec.SHA384, "SHA-512"};
    }

    private SHA() {
    }

    private static boolean a(String r100) {
        String[] r101 = f277988d;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103].equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static String sha256Encrypt(String r100) {
        return shaEncrypt(r100, "SHA-256");
    }

    public static String shaEncrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L16:
        b.b(f277985a, "content or algorithm is null.");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (a(r101) == true) goto L18;
        b.b(f277985a, "algorithm is not safe or legal");
        return "";
    L18:
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L13
    L15:
        return HexUtil.byteArray2HexStr(shaEncryptByte(r102, r101));
    L13:
        r102 = new byte[0];
        b.b(f277985a, "Error in generate SHA UnsupportedEncodingException");
        goto L15
    }

    public static byte[] shaEncryptByte(byte[] r100, String r101) {
        if (r100 != null) goto L5;
    L15:
        b.b(f277985a, "content or algorithm is null.");
        return new byte[0];
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (a(r101) == true) goto L17;
        b.b(f277985a, "algorithm is not safe or legal");
        return new byte[0];
    L17:
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: NoSuchAlgorithmException -> L13
        r102.update(r100);     // Catch: NoSuchAlgorithmException -> L13
        return r102.digest();
    L13:
        b.b(f277985a, "Error in generate SHA NoSuchAlgorithmException");
        return new byte[0];
    }

    public static boolean validateSHA256(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        return r101.equals(sha256Encrypt(r100));
    }

    public static boolean validateSHA(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return false;
    L10:
        return r101.equals(shaEncrypt(r100, r102));
    }
}
