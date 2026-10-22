package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f276412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f276413b = "Y29tLm5lYXJtZS5tY3M=";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f276414c = "";

    public b() {
    }

    private static String a() {
        if (TextUtils.isEmpty(f276414c) == false) goto L5;
        f276414c = new String(com.heytap.mcssdk.a.a.b(f276413b));
    L5:
        byte[] r100 = a(a(f276414c));
        if (r100 != null) goto L10;
        return "";
    L10:
        return new String(r100, Charset.forName("UTF-8"));
    }

    public static byte[] a(String r100) {
        if (r100 == null) goto L5;
        return r100.getBytes("UTF-8");
    L9:
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static byte[] a(byte[] r100) {
        if ((r100.length % 2) != 0) goto L5;
        int r101 = r100.length;
    L6:
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        byte r103 = r100[r102];
        int r104 = r102 + 1;
        r100[r102] = r100[r104];
        r100[r104] = r103;
        r102 = r102 + 2;
        goto L7
    L9:
        return r100;
    L5:
        r101 = r100.length - 1;
        goto L6
    }

    public static String b(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L23;
        boolean r102 = false;
        r101 = c.a(r100, a());     // Catch: Exception -> L7
        d.b("sdkDecrypt desDecrypt des data " + r101);     // Catch: Exception -> L7
        boolean r103 = true;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        r102 = r103;
    L13:
        if (r102 == true) goto L24;
        r101 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, r100);     // Catch: Exception -> L16
        f276412a = CryptoConst.ALGORITHM_AES;     // Catch: Exception -> L16
        e.c().a(f276412a);     // Catch: Exception -> L16
        d.b("sdkDecrypt desDecrypt aes data " + r101);     // Catch: Exception -> L16
        return r101;
    L16:
        e = move-exception;
        d.b("sdkDecrypt AES excepiton " + e.toString());
        return r101;
    L24:
        return r101;
    L7:
        e = move-exception;
        d.b("sdkDecrypt DES excepiton " + e.toString());
        r103 = false;
        goto L10
    L23:
        return "";
    }

    public static String c(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L23;
        boolean r102 = false;
        r101 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, r100);     // Catch: Exception -> L7
        d.b("sdkDecrypt aesDecrypt aes data " + r101);     // Catch: Exception -> L7
        boolean r103 = true;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        r102 = r103;
    L13:
        if (r102 == true) goto L24;
        r101 = c.a(r100, a());     // Catch: Exception -> L16
        f276412a = "DES";     // Catch: Exception -> L16
        e.c().a(f276412a);     // Catch: Exception -> L16
        d.b("sdkDecrypt aesDecrypt des data " + r101);     // Catch: Exception -> L16
        return r101;
    L16:
        e = move-exception;
        d.b("sdkDecrypt DES excepiton " + e.toString());
        return r101;
    L24:
        return r101;
    L7:
        e = move-exception;
        d.b("sdkDecrypt AES excepiton " + e.toString());
        r103 = false;
        goto L10
    L23:
        return "";
    }

    public static String d(String r100) {
        d.b("sdkDecrypt start data " + r100);
        if (TextUtils.isEmpty(f276412a) == false) goto L6;
        f276412a = e.c().b();
    L6:
        if ("DES".equals(f276412a) == false) goto L8;
        d.b("sdkDecrypt start DES");
        return b(r100);
    L8:
        d.b("sdkDecrypt start AES");
        return c(r100);
    }
}
