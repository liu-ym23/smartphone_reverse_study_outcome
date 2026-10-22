package com.ss.android.ugc.effectmanager.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ugc.effectplatform.util.l;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes40.dex */
public class NetworkUtils {
    public NetworkUtils() {
    }

    public static boolean isNetworkAvailable(Context r100) {
        return l.a(r100);
    }

    public static <T> String toJson(List<T> r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
        if (r100 != null) goto L5;
    L13:
        r101.append("]");
        return r101.toString();
    L5:
        if (r100.isEmpty() == true) goto L13;
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        T r103 = r102.next();
        r101.append("\"");
        r101.append(r103.toString());
        r101.append("\",");
        goto L9
    L11:
        r101.deleteCharAt(r101.length() - 1);
        r101.append("]");
        return r101.toString();
    }

    public static String buildRequestUrl(Map<String, String> r100, String r101) {
        StringBuilder r102 = new StringBuilder(r101);
        if (r100.size() <= 0) goto L17;
        r102.append("?");
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, String> r105 = r103.next();
        String r106 = r105.getKey();
        String r107 = r105.getValue();
        if (TextUtils.isEmpty(r106) == true) goto L15;
        if (TextUtils.isEmpty(r107) == true) goto L15;
        if (r104 != 0) goto L14;
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        goto L15
    L14:
        r102.append("&");
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
    L15:
        r104 = r104 + 1;
    L17:
        return new String(r102);
    }

    public static String encodeParameters(Map<String, String> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();     // Catch: UnsupportedEncodingException -> L9
    L5:
        if (r103.hasNext() == false) goto L7;
        Map.Entry<String, String> r104 = r103.next();     // Catch: UnsupportedEncodingException -> L9
        r102.append(URLEncoder.encode(r104.getKey(), r101));     // Catch: UnsupportedEncodingException -> L9
        r102.append(a.f25612h);     // Catch: UnsupportedEncodingException -> L9
        r102.append(URLEncoder.encode(r104.getValue(), r101));     // Catch: UnsupportedEncodingException -> L9
        r102.append(Typography.amp);     // Catch: UnsupportedEncodingException -> L9
        goto L5
    L7:
        return r102.toString();
    L9:
        e = move-exception;
        throw new RuntimeException("Encoding not supported: " + r101, e);
    }

    public static String filterUrl(String r100, String r101) {
        Pattern r102 = PatternProtector.compile(".*(?=://)");
        Pattern r103 = PatternProtector.compile("(?<=://)([^/]*)");
        URI r104 = URI.create(r100);
        return r103.matcher(r102.matcher(r101).replaceFirst(r104.getScheme())).replaceFirst(r104.getHost());
    }
}
