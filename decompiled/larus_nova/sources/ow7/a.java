package ow7;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import exc.e;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.UByte;
import nw7.d;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L19;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L13;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L11;
        r101.append('0');
    L11:
        r101.append(r103);
        r102 = r102 + 1;
        goto L7
    L13:
        return r101.toString();
    L19:
        return "";
    }

    public static boolean b(HonorAccount r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100.f276558t) == true) goto L9;
        return true;
    L9:
        if (TextUtils.isEmpty(r100.f276542d) == false) goto L11;
    L18:
        e.c("BaseUtil", "addHonorAccount is invalid");
        return false;
    L11:
        if (TextUtils.isEmpty(r100.f276543e) == true) goto L18;
        if (TextUtils.isEmpty(r100.f276540b) == true) goto L18;
        if (TextUtils.isEmpty(r100.f276541c) == true) goto L18;
        return true;
    }

    public static byte[] c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        e.b("BaseUtil", "getUTF8Bytes, str is empty");
        return new byte[0];
    L10:
        return r100.getBytes("UTF-8");
    L8:
        e.b("BaseUtil", "getBytes error");
        return new byte[0];
    }

    public static String d(Context r100) {
        boolean r101 = false;
        String r102 = cxc.e.a(r100, 0);
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L26:
        e.c("BaseUtil", "TransID get imei is null");
        return null;
    L5:
        if ("NULL".equals(r102) == true) goto L26;
        String r103 = r102 + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
        String[] r104 = d.f521012a;
        if (TextUtils.isEmpty(r103) == false) goto L10;
    L23:
        e.e("SHA256", "content or algorithm is null.");
    L24:
        return "";
    L10:
        if (TextUtils.isEmpty("SHA-256") == true) goto L23;
        String[] r105 = d.f521012a;
        int r106 = r105.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L17;
        if (r105[r107].equals("SHA-256") == true) goto L15;
        r107 = r107 + 1;
        goto L12
    L15:
        r101 = true;
    L17:
        if (r101 == true) goto L28;
        e.e("SHA256", "algorithm is not safe or legal");
        goto L24
    L28:
        MessageDigest r108 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L21 UnsupportedEncodingException -> L22
        r108.update(r103.getBytes("UTF-8"));     // Catch: NoSuchAlgorithmException -> L21 UnsupportedEncodingException -> L22
    L32:
        return a(r108.digest());
    L22:
        e.e("SHA256", "Error in generate SHA UnsupportedEncodingException");
    L21:
        e.e("SHA256", "Error in generate SHA NoSuchAlgorithmException");
        goto L24
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L19;
        return false;
    L19:
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L16
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L24;
        int r103 = r101[r102] & UByte.MAX_VALUE;     // Catch: UnsupportedEncodingException -> L16
        if (r103 <= 31) goto L14;
        if (r103 >= 127) goto L14;
        r102 = r102 + 1;     // Catch: UnsupportedEncodingException -> L16
    L14:
        e.c("BaseUtil", "byte not printable");     // Catch: UnsupportedEncodingException -> L16
        return false;
    L24:
        return true;
    L16:
        e.c("BaseUtil", "UnsupportedEncodingException");
        return true;
    }
}
