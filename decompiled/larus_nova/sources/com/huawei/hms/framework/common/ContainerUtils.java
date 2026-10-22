package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public ContainerUtils() {
    }

    public static <K, V> int hashCode(Map<K, V> r100) {
        return toString(r100).hashCode();
    }

    public static <K, V> String toString(Map<K, V> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<K, V> r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 <= 0) goto L11;
        r101.append("&");
    L11:
        r101.append(r104.getKey().toString());
        r101.append(KEY_VALUE_DELIMITER);
        r101.append(r104.getValue().toString());
        r103 = r105;
        goto L7
    L13:
        return r101.toString();
    }

    public static <K> String toString(List<K> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        Iterator<K> r102 = r100.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L13;
        K r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 <= 0) goto L11;
        r101.append("&");
    L11:
        r101.append(r104.toString());
        r103 = r105;
        goto L7
    L13:
        return r101.toString();
    }

    public static <K> String toString(Set<K> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        Iterator<K> r102 = r100.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L13;
        K r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 <= 0) goto L11;
        r101.append("&");
    L11:
        r101.append(r104.toString());
        r103 = r105;
        goto L7
    L13:
        return r101.toString();
    }

    public static <K, V> boolean equals(Map<K, V> r100, Map<K, V> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r100.size() != r101.size()) goto L19;
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<K, V> r103 = r102.next();
        if (r101.get(r103.getKey()) == r103.getValue()) goto L12;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L19;
        return true;
    L16:
        r104 = false;
    L19:
        return false;
    }
}
