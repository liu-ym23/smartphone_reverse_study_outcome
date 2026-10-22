package com.xiaomi.push.service;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes41.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static RSAPublicKey f464280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f1069a = null;

    static {
        byte[] r100 = {48, -127, -97, 48, HTTP.CR, 6, 9, 42, -122, 72, -122, -9, HTTP.CR, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, 16, 70, -90, 113, -30, 36, 85, -3, -43, 123, Base64.padSymbol, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, 49, HTTP.CR, 16, 50, -27, -82, 18, -28, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, 49, 28, 117, -74, 114, -122, -29, -84, 82, 22, -122, 42, -40, -79, 18, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        f1069a = r100;
        f464280a = (RSAPublicKey) KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: Throwable -> L5
        return;
    L5:
        com.xiaomi.channel.commonutils.logger.b.d("rsa key pair init failure!!!");
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        Cipher r101 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Throwable -> L7
        r101.init(1, f464280a);     // Catch: Throwable -> L7
        return android.util.Base64.encodeToString(a(r101, 1, r100.getBytes("UTF-8"), f464280a.getModulus().bitLength()), 2);
    L10:
        return null;
    }

    private static byte[] a(Cipher r100, int r101, byte[] r102, int r103) {
        if (r100 == null) goto L22;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r101 != 2) goto L8;
        int r104 = r103 / 8;
    L24:
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Exception -> L19
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r102.length <= r106) goto L17;
        if ((r102.length - r106) <= r104) goto L15;
        byte[] r108 = r100.doFinal(r102, r106, r104);     // Catch: Exception -> L19
    L16:
        r105.write(r108, 0, r108.length);     // Catch: Exception -> L19
        r107 = r107 + 1;     // Catch: Exception -> L19
        r106 = r107 * r104;     // Catch: Exception -> L19
        goto L11
    L15:
        r108 = r100.doFinal(r102, r106, r102.length - r106);     // Catch: Exception -> L19
        goto L16
    L17:
        return r105.toByteArray();
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        r104 = (r103 / 8) - 11;
        goto L24
    L22:
        return null;
    }
}
