package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class z {
    public static String a(List r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L23;
        Pair r103 = (Pair) r102.next();
        String r104 = URLEncoder.encode((String) r103.first, "UTF-8");     // Catch: UnsupportedEncodingException -> L19
        String r105 = (String) r103.second;
        if (r105 != null) goto L24;
        String r106 = "";
    L16:
        if (r101.length() <= 0) goto L18;
        r101.append("&");
    L18:
        r101.append(r104);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r106);
        goto L4
    L24:
        r106 = URLEncoder.encode(r105, "UTF-8");     // Catch: UnsupportedEncodingException -> L11
    L11:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L19:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L23:
        return r101.toString();
    }

    public static String c(String r100) {
        if (com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271345m == true) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        Uri r101 = UriProtector.parse(r100.trim());     // Catch: Throwable -> L11
        Uri.Builder r102 = new Uri.Builder();     // Catch: Throwable -> L11
        r102.scheme("http");     // Catch: Throwable -> L11
        r102.encodedPath(r101.getPath());     // Catch: Throwable -> L11
        r102.encodedAuthority("boe.i.snssdk.com");     // Catch: Throwable -> L11
        r102.encodedQuery(r101.getEncodedQuery());     // Catch: Throwable -> L11
        return r102.build().toString();
    L14:
        return r100;
    }

    public static String b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty("aid") == false) goto L7;
        return r100;
    L7:
        return r100.replaceAll("(aid=[^&]*)", "aid=" + r101);
    }
}
