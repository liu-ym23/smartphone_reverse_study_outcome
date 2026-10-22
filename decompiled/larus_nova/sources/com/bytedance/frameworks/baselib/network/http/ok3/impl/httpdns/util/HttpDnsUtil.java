package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class HttpDnsUtil {
    private static final String TAG = null;

    public HttpDnsUtil() {
    }

    static {
        TAG = "HttpDnsUtil";
    }

    public static boolean isValidHost(String r100) {
        if (r100 == null) goto L31;
        char[] r101 = r100.toCharArray();
        if (r101.length <= 0) goto L31;
        if (r101.length > 255) goto L31;
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L29;
        char r104 = r101[r103];
        if (r104 < 'A') goto L16;
        if (r104 > 'Z') goto L16;
    L28:
        r103 = r103 + 1;
    L16:
        if (r104 < 'a') goto L20;
        if (r104 <= 'z') goto L28;
    L20:
        if (r104 < '0') goto L24;
        if (r104 <= '9') goto L28;
    L24:
        if (r104 == '.') goto L28;
        if (r104 == '-') goto L28;
        return false;
    L29:
        return true;
    L31:
        return false;
    }

    public static String transHostList2String(List<String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L13;
        r101.append((String) ListProtector.get(r100, r102));
        if (r102 == (r100.size() - 1)) goto L11;
        r101.append(',');
    L11:
        r102 = r102 + 1;
        goto L7
    L13:
        return r101.toString();
    }
}
