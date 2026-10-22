package com.larksuite.framework.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes24.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f286044a = null;

    static {
        f286044a = PatternProtector.compile("^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)([\\w.]+\\/?)\\S*");
    }

    public static String b(String r100) {
        URL r101 = new URL(r100);     // Catch: MalformedURLException -> L5
        String r102 = r101.getHost();     // Catch: MalformedURLException -> L5
        Log.d("UrlUtil", "url:" + r101 + "host:" + r102);     // Catch: MalformedURLException -> L5
        return r102;
    L5:
        e = move-exception;
        Log.e("UrlUtil", e.getMessage(), e);
        return null;
    }

    public static boolean c(String r100) {
        if (r100 == null) goto L11;
        Uri r101 = UriProtector.parse(r100);
        if (r101.getScheme() != null) goto L6;
        return false;
    L6:
        if (r101.getScheme().equals("http") == false) goto L8;
        return true;
    L8:
        if (r101.getScheme().equals("https") == false) goto L15;
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    public static String a(String r110, String r111) {
        if (UriProtector.getQueryParameter(UriProtector.parse(r110), r111) != null) goto L5;
        return r110;
    L5:
        int r100 = r110.indexOf("?");     // Catch: Exception -> L29
        int r101 = r100 + 1;     // Catch: Exception -> L29
        int r102 = r110.indexOf("#", r101);     // Catch: Exception -> L29
        if (r102 <= r100) goto L8;
        String r103 = r110.substring(r101, r102);     // Catch: Exception -> L29
    L9:
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L29
        int r105 = 0;
        boolean r106 = false;
    L10:
        int r107 = r103.indexOf(38, r105);     // Catch: Exception -> L29
        if (r107 != (-1)) goto L13;
        r107 = r103.length();     // Catch: Exception -> L29
    L13:
        int r112 = r103.indexOf(61, r105);     // Catch: Exception -> L29
        if (r112 > r107) goto L16;
        if (r112 == (-1)) goto L16;
    L18:
        if (r103.substring(r105, r112).equals(r111) == true) goto L22;
        if (r106 == false) goto L21;
        r104.append("&");     // Catch: Exception -> L29
    L21:
        r104.append(r103.substring(r105, r107));     // Catch: Exception -> L29
        r106 = true;
    L22:
        r105 = r107 + 1;     // Catch: Exception -> L29
        if (r105 < r103.length()) goto L10;
        if (r102 <= r100) goto L28;
        return r110.substring(0, r101) + r104.toString() + r110.substring(r102);
    L28:
        return r110.substring(0, r101) + r104.toString();
    L16:
        r112 = r107;
        goto L18
    L8:
        r103 = r110.substring(r101);     // Catch: Exception -> L29
        goto L9
    L33:
        return r110;
    }
}
