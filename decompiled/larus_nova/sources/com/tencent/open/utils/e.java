package com.tencent.open.utils;

import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.tencent.open.log.SLog;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes35.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f461843a = null;

    static {
        f461843a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L10;
        byte r103 = r100[r102];
        int r104 = r102 * 2;
        char[] r105 = f461843a;
        r101[r104 + 1] = r105[r103 & 15];
        r101[r104] = r105[((byte) (r103 >>> 4)) & 15];
        r102 = r102 + 1;
        goto L7
    L10:
        return new String(r101);
    L14:
        return "";
    }

    public static byte[] a(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L4
        r101.update(r100.getBytes());     // Catch: Exception -> L4
        return r101.digest();
    L4:
        e = move-exception;
        SLog.e("DESUtils", "encryptSha", e);
        return null;
    }

    public static String a(String r100, String r101, byte[] r102) {
        IvParameterSpec r103 = new IvParameterSpec(r102);     // Catch: Exception -> L4
        SecretKeySpec r104 = new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L4
        Cipher r105 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L4
        r105.init(1, r104, r103);     // Catch: Exception -> L4
        return Base64.encodeToString(r105.doFinal(r100.getBytes()), 0);
    L4:
        e = move-exception;
        SLog.e("DESUtils", "encryptAES", e);
        return null;
    }
}
