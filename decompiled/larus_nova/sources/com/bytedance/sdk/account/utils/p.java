package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f269554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f269555b;

    public final String toString() {
        if (this.f269554a.isEmpty() == true) goto L45;
        Map<String, String> r100 = this.f269554a;
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L28;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = URLEncoder.encode((String) r103.getKey(), "UTF-8");     // Catch: UnsupportedEncodingException -> L25
        String r105 = (String) r103.getValue();
        if (r105 != null) goto L38;
        String r106 = "";
    L19:
        if (TextUtils.isEmpty(r106) == true) goto L22;
        r106 = r106.replace(Marker.ANY_NON_NULL_MARKER, "%20");
    L22:
        if (r101.length() <= 0) goto L24;
        r101.append("&");
    L24:
        r101.append(r104);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r106);
        goto L7
    L38:
        r106 = URLEncoder.encode(r105, "UTF-8");     // Catch: UnsupportedEncodingException -> L14
    L14:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L25:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L28:
        String r107 = r101.toString();
        String r108 = this.f269555b;
        if (r108 != null) goto L31;
        return r107;
    L31:
        if (r108.length() != 0) goto L34;
        return r107;
    L34:
        if (this.f269555b.indexOf(63) < 0) goto L37;
        return this.f269555b + "&" + r107;
    L37:
        return this.f269555b + "?" + r107;
    L45:
        return this.f269555b;
    }

    public p(String r100) {
        this.f269554a = new LinkedHashMap();
        this.f269555b = r100;
    }
}
