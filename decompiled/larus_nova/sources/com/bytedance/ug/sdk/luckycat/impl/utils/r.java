package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class r {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        return "sslocal://luckycat2021/fake_url?" + r100;
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return false;
    L5:
        if (UriProtector.parse(r100) == null) goto L14;
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        List<String> r103 = r101.getPathSegments();
        if ("polaris".equals(r102) == false) goto L14;
        if (r103 == null) goto L14;
        if (r103.isEmpty() == true) goto L14;
        return "proxy".equalsIgnoreCase((String) ListProtector.get(r103, 0));
    }

    public static String c(String r100, String r101) {
        a.a("ProxySchemaUtil", "origin url : " + r100);
        a.a("ProxySchemaUtil", "targe url " + r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L29:
        return r101;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        Uri r102 = UriProtector.parse(r100);
        Uri r103 = UriProtector.parse(r101);
        Uri.Builder r104 = r102.buildUpon();
        r104.scheme(r103.getScheme());
        r104.authority(r103.getAuthority());
        r104.path(r103.getPath());
        Set<String> r105 = UriProtector.getQueryParameterNames(r103);
        if (r105 == null) goto L28;
        if (r105.size() <= 0) goto L28;
        Iterator<String> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L25;
        String r107 = r106.next();
        if (TextUtils.isEmpty(r107) == true) goto L14;
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r102, r107)) == false) goto L14;
        String r108 = UriProtector.getQueryParameter(r103, r107);
        a.a("ProxySchemaUtil", "add query param : name : " + r107 + "  value : " + r108);
        if (TextUtils.isEmpty(r108) == true) goto L14;
        r104.appendQueryParameter(r107, r108);
        goto L14
    L25:
        a.a("ProxySchemaUtil", "final url : " + r104.build().toString());
        return r104.build().toString();
    L28:
        return r104.build().toString();
    }
}
