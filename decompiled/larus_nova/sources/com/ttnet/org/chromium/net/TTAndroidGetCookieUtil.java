package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class TTAndroidGetCookieUtil {
    public TTAndroidGetCookieUtil() {
    }

    public static String getCookieHeader(String r100) {
        HashMap r101 = new HashMap();
        StringBuilder r102 = new StringBuilder();
        CookieHandler r103 = CookieHandler.getDefault();     // Catch: Exception -> L27
        if (r103 == null) goto L7;
        Map<String, List<String>> r104 = r103.get(new URI(r100), r101);     // Catch: Exception -> L27
    L8:
        if (r104 == null) goto L26;
        if (r104.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r105 = r104.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r106 = r105.next();
        if ("Cookie".equalsIgnoreCase(r106.getKey()) == false) goto L13;
        if (r106.getValue().isEmpty() == true) goto L13;
        Iterator<String> r107 = r106.getValue().iterator();
        int r108 = 0;
    L20:
        if (r107.hasNext() == false) goto L13;
        String r109 = r107.next();
        if (r108 <= 0) goto L24;
        r102.append("; ");
    L24:
        r102.append(r109);
        r108 = r108 + 1;
    L26:
        return r102.toString();
    L7:
        r104 = null;
    L28:
        return r102.toString();
    }
}
