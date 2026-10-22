package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class UPUtils {
    public UPUtils() {
    }

    public static String b(String r100) {
        byte[] r101 = r100.getBytes();     // Catch: Throwable -> L4
        MessageDigest r102 = MessageDigest.getInstance("SHA-1");     // Catch: Throwable -> L4
        r102.reset();     // Catch: Throwable -> L4
        r102.update(r101);     // Catch: Throwable -> L4
        return a.a(r102.digest());
    L4:
        return null;
    }

    public static String c(byte[] r100) {
        if (r100 == null) goto L10;
        return new String(r100, XML.CHARSET_UTF8);
    L11:
        return "";
    L10:
        return "";
    }

    public static String e(int r100, String r101) {
        return c(forWap(r100, r101));
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static native synchronized byte[] forCallingAppUrl(int r100, boolean r101);

    public static native synchronized byte[] forConfig(int r100, String r101);

    public static native synchronized byte[] forDirectAppsUrl(int r100, boolean r101);

    public static native synchronized byte[] forScanUrl(int r100, boolean r101);

    public static native synchronized byte[] forUrl(int r100, boolean r101);

    public static native synchronized byte[] forWap(int r100, String r101);

    public static native synchronized String getIssuer(int r100);

    public static native synchronized String getSubject(int r100);

    public static native synchronized String getTalkingDataIdForAssist(int r100);

    public static String a(Context r100, String r101) {
        if (r100 != null) goto L16;
        return null;
    L16:
        String r102 = new String(d.a(0, a.b("0000000023456789abcdef12123456786789abcd".substring(0, 32)), a.b(r100.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(r101, ""))), XML.CHARSET_UTF8).trim();     // Catch: Throwable -> L6
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        if (r102.endsWith("00000000") == true) goto L13;
        return "";
    L13:
        return r102.substring(0, r102.length() - 8);
    L6:
        r102 = "";
        goto L7
    }

    public static void d(Context r100, String r101, String r102) {
        String r103 = "";
        if (r100 == null) goto L15;
        String r104 = "0000000023456789abcdef12123456786789abcd".substring(0, 32);
        String r105 = a.a(d.a(1, a.b(r104), (r101 + "00000000").getBytes(XML.CHARSET_UTF8)));     // Catch: Throwable -> L7
    L8:
        if (r105 == null) goto L11;
        r103 = r105;
    L11:
        SharedPreferences.Editor r106 = r100.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        r106.putString(r102, r103);
        r106.commit();
        return;
    L7:
        r105 = "";
        goto L8
    }
}
