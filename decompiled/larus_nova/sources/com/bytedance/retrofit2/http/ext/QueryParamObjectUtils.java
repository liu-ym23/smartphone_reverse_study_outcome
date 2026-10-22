package com.bytedance.retrofit2.http.ext;

import com.alipay.sdk.m.n.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes21.dex */
public class QueryParamObjectUtils {
    private QueryParamObjectUtils() {
    }

    public static void addQuery(StringBuilder r100, String r101, String r102) {
        if (r101 == null) goto L19;
        if (r100.length() <= 0) goto L7;
        char r103 = Typography.amp;
    L8:
        r100.append(r103);     // Catch: UnsupportedEncodingException -> L16
        String r104 = URLEncoder.encode(r101, "UTF-8");     // Catch: UnsupportedEncodingException -> L16
        String r105 = URLEncoder.encode(r102, "UTF-8");     // Catch: UnsupportedEncodingException -> L16
        if (r105 != null) goto L11;
    L14:
        r100.append(r104);     // Catch: UnsupportedEncodingException -> L16
        return;
    L11:
        if (r105.isEmpty() == true) goto L14;
        r100.append(r104);     // Catch: UnsupportedEncodingException -> L16
        r100.append(a.f25612h);     // Catch: UnsupportedEncodingException -> L16
        r100.append(r105);     // Catch: UnsupportedEncodingException -> L16
        return;
    L7:
        r103 = '?';
        goto L8
    L19:
        throw new IllegalArgumentException("Query param name must not be null.");     // Catch: UnsupportedEncodingException -> L16
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r101 + "\" value to UTF-8: " + r102, e);
    }
}
