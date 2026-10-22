package com.bytedance.awemeopen.apps.framework.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class o0 {
    public static String a(String r100, Map<String, String> r101) {
        Uri r102 = UriProtector.parse(r100);
        if (r102.isHierarchical() == true) goto L5;
        return r100;
    L5:
        if (com.bytedance.awemeopen.infra.util.d.a(r101.keySet()) == true) goto L51;
        String r103 = r102.getQuery();
        Iterator<String> r104 = r101.keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L27;
        String r105 = r104.next();
        String r106 = URLEncoder.encode(r101.get(r105), "UTF-8");     // Catch: Exception -> L25
        String r107 = "\\b" + r105 + "=.*?(&|$)";     // Catch: Exception -> L25
        if (PatternProtector.compile(r107).matcher(r103).find() == false) goto L15;
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (r106.isEmpty() == true) goto L22;
        r103 = r103.replaceFirst(r107, r105 + ContainerUtils.KEY_VALUE_DELIMITER + r106 + "$1");     // Catch: Exception -> L25
        goto L9
    L22:
        r103 = r103.replaceFirst(r107, "");     // Catch: Exception -> L25
        goto L9
    L15:
        if (TextUtils.isEmpty(r103) == true) goto L16;
        r103 = r103 + "&" + r105 + ContainerUtils.KEY_VALUE_DELIMITER + r106;     // Catch: Exception -> L25
        goto L9
    L16:
        r103 = r105 + ContainerUtils.KEY_VALUE_DELIMITER + r106;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L27:
        StringBuilder r108 = new StringBuilder();
        r108.append(r102.getScheme());
        r108.append("://");
        r108.append(r102.getAuthority());
        r108.append(r102.getPath());
        r108.append("?");
        r108.append(r103);
        if (TextUtils.isEmpty(r102.getFragment()) == true) goto L31;
        r108.append("#");
        r108.append(r102.getFragment());
    L31:
        return r108.toString();
    L51:
        return r100;
    }
}
