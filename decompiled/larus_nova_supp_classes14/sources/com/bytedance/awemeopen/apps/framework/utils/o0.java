package com.bytedance.awemeopen.apps.framework.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o0 {
    public static String a(String r7, Map<String, String> r8) {
        Uri r0 = UriProtector.parse(r7);
        if (r0.isHierarchical() == true) goto L5;
        return r7;
    L5:
        if (com.bytedance.awemeopen.infra.util.d.a(r8.keySet()) == true) goto L51;
        String r9 = r0.getQuery();
        Iterator<String> r1 = r8.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L27;
        String r2 = r1.next();
        String r3 = URLEncoder.encode(r8.get(r2), "UTF-8");     // Catch: Exception -> L25
        String r4 = "\\b" + r2 + "=.*?(&|$)";     // Catch: Exception -> L25
        if (PatternProtector.compile(r4).matcher(r9).find() == false) goto L15;
        if (TextUtils.isEmpty(r9) == true) goto L9;
        if (r3.isEmpty() == true) goto L22;
        r9 = r9.replaceFirst(r4, r2 + "=" + r3 + "$1");     // Catch: Exception -> L25
        goto L9
    L22:
        r9 = r9.replaceFirst(r4, "");     // Catch: Exception -> L25
        goto L9
    L15:
        if (TextUtils.isEmpty(r9) == true) goto L16;
        r9 = r9 + "&" + r2 + "=" + r3;     // Catch: Exception -> L25
        goto L9
    L16:
        r9 = r2 + "=" + r3;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L27:
        StringBuilder r10 = new StringBuilder();
        r10.append(r0.getScheme());
        r10.append("://");
        r10.append(r0.getAuthority());
        r10.append(r0.getPath());
        r10.append("?");
        r10.append(r9);
        if (TextUtils.isEmpty(r0.getFragment()) == true) goto L31;
        r10.append("#");
        r10.append(r0.getFragment());
    L31:
        return r10.toString();
    L51:
        return r7;
    }
}
