package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HMACSHA256 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277972a = "HMACSHA256";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277973b = "HmacSHA256";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277974c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f277975d = 32;

    public HMACSHA256() {
    }

    public static byte[] hmacEncrypt(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (r101.length >= 32) goto L19;
        b.b(f277972a, "hmac key length is not right");
        return new byte[0];
    L19:
        SecretKeySpec r102 = new SecretKeySpec(r101, f277973b);     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        Mac r103 = Mac.getInstance(r102.getAlgorithm());     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        r103.init(r102);     // Catch: NoSuchAlgorithmException -> L12 Throwable -> L14
        return r103.doFinal(r100);
    L14:
        e = move-exception;
        b.b(f277972a, "hmacsha256 encrypt exception" + e.getMessage());
        return new byte[0];
    L17:
        b.b(f277972a, "content or key is null.");
        return new byte[0];
    }

    public static String hmacSHA256Encrypt(String r100, byte[] r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (r101 == null) goto L16;
        if (r101.length >= 32) goto L17;
        b.b(f277972a, "hmac key length is not right");
        return "";
    L17:
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L12
    L15:
        return HexUtil.byteArray2HexStr(hmacEncrypt(r102, r101));
    L12:
        e = move-exception;
        b.b(f277972a, "hmacsha256 encrypt exception" + e.getMessage());
        r102 = new byte[0];
    L16:
        return "";
    }

    public static String hmacSHA256Encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return "";
    L8:
        return hmacSHA256Encrypt(r100, HexUtil.hexStr2ByteArray(r101));
    }
}
