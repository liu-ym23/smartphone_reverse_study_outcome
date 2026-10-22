package com.bytedance.mt.protector.impl;

import android.net.Uri;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class UriProtector extends a<String> {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.URI;
    }

    public UriProtector() {
    }

    public static Set<String> getQueryParameterNames(Uri r100) {
        if (c.b() == false) goto L13;
        return r100.getQueryParameterNames();
    L6:
        th = move-exception;
        String r101 = (String) a.tryProtect(protectorType, th, String.class);
        if (r101 == null) goto L11;
        HashSet r102 = new HashSet();
        r102.add(r101);
        return r102;
    L11:
        throw th;
    L13:
        return r100.getQueryParameterNames();
    }

    public static Uri parse(String r100) {
        if (c.b() == false) goto L13;
        return Uri.parse(r100);
    L6:
        th = move-exception;
        String r101 = (String) a.tryProtect(protectorType, th, String.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return Uri.parse(r101);
    L13:
        return Uri.parse(r100);
    }

    public static String getQueryParameter(Uri r100, String r101) {
        if (c.b() == false) goto L12;
        return r100.getQueryParameter(r101);
    L6:
        th = move-exception;
        String r102 = (String) a.tryProtect(protectorType, th, String.class);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw th;
    L12:
        return r100.getQueryParameter(r101);
    }

    public static List<String> getQueryParameters(Uri r100, String r101) {
        if (c.b() == false) goto L13;
        return r100.getQueryParameters(r101);
    L6:
        th = move-exception;
        String r102 = (String) a.tryProtect(protectorType, th, String.class);
        if (r102 == null) goto L11;
        ArrayList r103 = new ArrayList();
        r103.add(r102);
        return r103;
    L11:
        throw th;
    L13:
        return r100.getQueryParameters(r101);
    }
}
