package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277262a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f277263b = null;

    static {
        f277263b = PatternProtector.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    public static String a(String r100) {
        return a(r100, "SHA-256");
    }

    private static String a(String r100, String r101) {
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L9
        return a(MessageDigest.getInstance(r101).digest(r102));
    L6:
        String r103 = f277262a;
        String r104 = "encrypt NoSuchAlgorithmException";
    L7:
        Logger.w(r103, r104);
        return null;
    L9:
        r103 = f277262a;
        r104 = "encrypt UnsupportedEncodingException";
        goto L7
    }

    private static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L8;
        r101.append("0");
    L8:
        r101.append(r103);
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = 1;
        if (r100.length() != 1) goto L8;
        return "*";
    L8:
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L10:
        if (r103 >= r100.length()) goto L19;
        String r104 = r100.charAt(r103) + "";
        if (f277263b.matcher(r104).matches() == false) goto L17;
        if ((r101 % 2) != 0) goto L16;
        r104 = "*";
    L16:
        r101 = r101 + 1;
    L17:
        r102.append(r104);
        r103 = r103 + 1;
        goto L10
    L19:
        return r102.toString();
    }
}
