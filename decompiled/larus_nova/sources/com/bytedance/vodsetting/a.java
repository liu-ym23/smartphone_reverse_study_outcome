package com.bytedance.vodsetting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f272551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f272552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f272553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f272554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<String, Object> f272555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<String, Object> f272556f;

    public a() {
    }

    public static Map<String, String> a(Map<String, Object> r100) {
        if (r100 != null) goto L4;
    L11:
        return null;
    L4:
        if (r100.size() <= 0) goto L11;
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, Object> r103 = r102.next();
        if (r103.getValue() == null) goto L7;
        r101.put(r103.getKey(), r103.getValue().toString());
        goto L7
    L18:
        return r101;
    }
}
