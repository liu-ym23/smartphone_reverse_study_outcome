package com.bytedance.ee.util.io;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.component.storage.ext.content.FileProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f243146a = null;

    static {
        f243146a = PatternProtector.compile("^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][iI][lL][eE]:/*)([\\w.]+\\/?)\\S*");
    }

    public static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (f243146a.matcher(r100).matches() == false) goto L7;
        return true;
    }

    public static Uri b(Context r100, VFSPath r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L12;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".suite.provider", r101.toFile());
    L9:
        e = move-exception;
        tt5.a.f("UriUtils", e, false);
        return null;
    L12:
        return Uri.fromFile(r101.toFile());
    }

    public static String a(String r100, String r101, String r102) {
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L26
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);     // Catch: Throwable -> L26
        if (r104.contains(r101) == true) goto L8;
        tt5.a.h("UriUtils", "append query directly");     // Catch: Throwable -> L26
        return r103.buildUpon().appendQueryParameter(r101, r102).toString();
    L8:
        if (TextUtils.equals(UriProtector.getQueryParameter(r103, r101), r102) == false) goto L11;
        tt5.a.h("UriUtils", "query equals, return origin url");     // Catch: Throwable -> L26
        return r100;
    L11:
        tt5.a.h("UriUtils", "query:" + r103.getQuery());     // Catch: Throwable -> L26
        HashMap r105 = new HashMap();     // Catch: Throwable -> L26
        Iterator<String> r106 = r104.iterator();     // Catch: Throwable -> L26
    L13:
        if (r106.hasNext() == false) goto L20;
        String r107 = r106.next();     // Catch: Throwable -> L26
        if (TextUtils.equals(r107, r101) == true) goto L13;
        String r108 = UriProtector.getQueryParameter(r103, r107);     // Catch: Throwable -> L26
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r105.put(r107, r108);     // Catch: Throwable -> L26
        goto L13
    L20:
        Uri.Builder r109 = UriProtector.parse(r103.buildUpon().clearQuery().toString()).buildUpon();     // Catch: Throwable -> L26
        Iterator r110 = r105.entrySet().iterator();     // Catch: Throwable -> L26
    L22:
        if (r110.hasNext() == false) goto L24;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L26
        r109.appendQueryParameter((String) r111.getKey(), (String) r111.getValue());     // Catch: Throwable -> L26
        goto L22
    L24:
        r109.appendQueryParameter(r101, r102);     // Catch: Throwable -> L26
        return r109.build().toString();
    L26:
        th = move-exception;
        tt5.a.e("UriUtils", "append or replace query error, return origin url:", th, false);
        return r100;
    }
}
