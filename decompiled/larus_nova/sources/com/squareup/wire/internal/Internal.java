package com.squareup.wire.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Internal {
    public static int countNonNull(Object r100, Object r101) {
        int r102 = 1;
        if (r100 == null) goto L5;
        int r103 = 1;
    L6:
        if (r101 != null) goto L10;
        r102 = 0;
    L10:
        return r103 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public static int countNonNull(Object r100, Object r101, Object r102) {
        int r103 = 1;
        if (r100 == null) goto L5;
        int r104 = 1;
    L6:
        if (r101 == null) goto L8;
        int r105 = 1;
    L9:
        int r106 = r104 + r105;
        if (r102 != null) goto L14;
        r103 = 0;
    L14:
        return r106 + r103;
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = 0;
        goto L6
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    private Internal() {
    }

    public static void checkElementsNotNull(Map<?, ?> r100) {
        if (r100 == null) goto L17;
        Iterator<Map.Entry<?, ?>> r101 = r100.entrySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        Map.Entry<?, ?> r102 = r101.next();
        if (r102.getKey() == null) goto L14;
        if (r102.getValue() != null) goto L5;
        throw new NullPointerException("Value for key " + r102.getKey() + " is null");
    L14:
        throw new NullPointerException("map.containsKey(null)");
    L15:
        return;
    L17:
        throw new NullPointerException("map == null");
    }

    public static IllegalStateException missingRequiredFields(Object... r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        String r103 = "";
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        if (r100[r104] != null) goto L10;
        if (r101.length() <= 0) goto L9;
        r103 = "s";
    L9:
        r101.append("\n  ");
        r101.append(r100[r104 + 1]);
    L10:
        r104 = r104 + 2;
        goto L3
    L12:
        throw new IllegalStateException("Required field" + r103 + " not set:" + r101);
    }

    public static void checkElementsNotNull(List<?> r100) {
        if (r100 == null) goto L12;
        int r101 = r100.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L10;
        if (ListProtector.get(r100, r102) == null) goto L9;
        r102 = r102 + 1;
        goto L4
    L9:
        throw new NullPointerException("Element at index " + r102 + " is null");
    L10:
        return;
    L12:
        throw new NullPointerException("list == null");
    }

    public static <T> List<T> copyOf(String r100, List<T> r101) {
        if (r101 == null) goto L13;
        if (r101 == Collections.emptyList()) goto L11;
        if ((r101 instanceof ImmutableList) == true) goto L11;
        return new ArrayList(r101);
    L11:
        return new MutableOnWriteList(r101);
    L13:
        throw new NullPointerException(r100 + " == null");
    }

    public static boolean equals(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static <K, V> Map<K, V> immutableCopyOf(String r100, Map<K, V> r101) {
        if (r101 == null) goto L18;
        if (r101.isEmpty() == true) goto L6;
        LinkedHashMap r102 = new LinkedHashMap(r101);
        if (r102.containsKey(null) == true) goto L16;
        if (r102.containsValue(null) == true) goto L14;
        return Collections.unmodifiableMap(r102);
    L14:
        throw new IllegalArgumentException(r100 + ".containsValue(null)");
    L16:
        throw new IllegalArgumentException(r100 + ".containsKey(null)");
    L6:
        return Collections.emptyMap();
    L18:
        throw new NullPointerException(r100 + " == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> r100, ProtoAdapter<T> r101) {
        Iterator<Map.Entry<?, T>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = r102.next();
        r103.setValue(r101.redact(r103.getValue()));
        goto L4
    }

    public static <K, V> Map<K, V> copyOf(String r100, Map<K, V> r101) {
        if (r101 == null) goto L6;
        return new LinkedHashMap(r101);
    L6:
        throw new NullPointerException(r100 + " == null");
    }

    public static <T> List<T> immutableCopyOf(String r100, List<T> r101) {
        if (r101 == null) goto L18;
        if ((r101 instanceof MutableOnWriteList) == false) goto L7;
        r101 = ((MutableOnWriteList) r101).mutableList;
    L7:
        if (r101 != Collections.emptyList()) goto L9;
    L16:
        return r101;
    L9:
        if ((r101 instanceof ImmutableList) == true) goto L16;
        ImmutableList r102 = new ImmutableList(r101);
        if (r102.contains(null) == true) goto L15;
        return r102;
    L15:
        throw new IllegalArgumentException(r100 + ".contains(null)");
    L18:
        throw new NullPointerException(r100 + " == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(List<T> r100, ProtoAdapter<T> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ListProtector.set(r100, r103, r101.redact(ListProtector.get(r100, r103)));
        r103 = r103 + 1;
        goto L3
    }

    public static int countNonNull(Object r100, Object r101, Object r102, Object r103, Object... r104) {
        int r105 = 0;
        if (r100 == null) goto L5;
        int r106 = 1;
    L6:
        if (r101 == null) goto L8;
        r106 = r106 + 1;
    L8:
        if (r102 == null) goto L10;
        r106 = r106 + 1;
    L10:
        if (r103 == null) goto L12;
        r106 = r106 + 1;
    L12:
        int r107 = r104.length;
    L13:
        if (r105 >= r107) goto L18;
        if (r104[r105] == null) goto L17;
        r106 = r106 + 1;
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        return r106;
    L5:
        r106 = 0;
        goto L6
    }
}
