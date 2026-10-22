package com.bytedance.mt.protector.impl;

import android.net.Uri;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class UriProtector extends a<String> {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.URI;
    }

    public UriProtector() {
    }

    public static Set<String> getQueryParameterNames(Uri r2) {
        if (c.b() == false) goto L13;
        return r2.getQueryParameterNames();
    L6:
        th = move-exception;
        String r0 = (String) a.tryProtect(protectorType, th, String.class);
        if (r0 == null) goto L11;
        HashSet r3 = new HashSet();
        r3.add(r0);
        return r3;
    L11:
        throw th;
    L13:
        return r2.getQueryParameterNames();
    }

    public static Uri parse(String r2) {
        if (c.b() == false) goto L13;
        return Uri.parse(r2);
    L6:
        th = move-exception;
        String r0 = (String) a.tryProtect(protectorType, th, String.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return Uri.parse(r0);
    L13:
        return Uri.parse(r2);
    }

    public static String getQueryParameter(Uri r1, String r2) {
        if (c.b() == false) goto L12;
        return r1.getQueryParameter(r2);
    L6:
        th = move-exception;
        String r3 = (String) a.tryProtect(protectorType, th, String.class);
        if (r3 == null) goto L10;
        return r3;
    L10:
        throw th;
    L12:
        return r1.getQueryParameter(r2);
    }

    public static List<String> getQueryParameters(Uri r1, String r2) {
        if (c.b() == false) goto L13;
        return r1.getQueryParameters(r2);
    L6:
        th = move-exception;
        String r3 = (String) a.tryProtect(protectorType, th, String.class);
        if (r3 == null) goto L11;
        ArrayList r4 = new ArrayList();
        r4.add(r3);
        return r4;
    L11:
        throw th;
    L13:
        return r1.getQueryParameters(r2);
    }
}
