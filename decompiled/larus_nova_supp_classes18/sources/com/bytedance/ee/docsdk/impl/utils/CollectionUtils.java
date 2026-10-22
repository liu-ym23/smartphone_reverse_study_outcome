package com.bytedance.ee.docsdk.impl.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static <T> List<T> asList(T[] r1) {
        return asList(0, r1);
    }

    public static <T> List<T> checkListNull(List<T> r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return new ArrayList();
    }

    public static String generateAttributes(List<String> r5) {
        if (r5.size() != 0) goto L7;
        return "";
    L7:
        if (r5.size() == 1) goto L9;
        Iterator<String> r6 = r5.iterator();
        String r0 = "(";
    L12:
        if (r6.hasNext() == false) goto L15;
        r0 = r0 + "'" + r6.next() + "',";
        goto L12
    L15:
        return r0.substring(0, r0.length() - 1) + ")";
    L9:
        return "('" + ((String) ListProtector.get(r5, 0)) + "')";
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> getAscSortMapByValue(Map<K, V> r1) {
        return getSortMap(new HashMap(r1), new AnonymousClass1());
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> getDescSortMapByValue(Map<K, V> r1) {
        return getSortMap(new HashMap(r1), new AnonymousClass2());
    }

    public static boolean isEmpty(Collection r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Collection r0) {
        return !isEmpty(r0);
    }

    public static <T> List<T> iterableToList(Iterable<T> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next());
        goto L7
    L9:
        return r0;
    }

    public static boolean isEmpty(Map r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Map r0) {
        return !isEmpty(r0);
    }

    public static <T> List<T> asList(int r2, T[] r3) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r2 >= r3.length) goto L7;
        r0.add(r3[r2]);
        r2 = r2 + 1;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V extends Comparable<? super V>> Map<K, V> getSortMap(Map<K, V> r2, Comparator<Map.Entry<K, V>> r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == null) goto L10;
        if (r3 == null) goto L10;
        LinkedList r1 = new LinkedList(r2.entrySet());
        Collections.sort(r1, r3);
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r5 = (Map.Entry) r4.next();
        r0.put(r5.getKey(), (Comparable) r5.getValue());
    L10:
        return r0;
    }

    public static <T> boolean isListSame(List<T> r4, List<T> r5) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.size()) goto L12;
        if (ListProtector.get(r4, r0).equals(ListProtector.get(r5, r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static <T> void resetToList(List<? super T> r0, List<? extends T> r1) {
        if (r0 == null) goto L8;
        r0.clear();
        if (r1 == null) goto L9;
        r0.addAll(r1);
        return;
    L9:
        return;
    L8:
        throw null;
    }

    public static List[] split(List r7, int r8) {
        if (isNotEmpty(r7) == false) goto L15;
        if (r8 <= 0) goto L15;
        int r1 = 0;
        if ((r7.size() % r8) != 0) goto L8;
        int r0 = 0;
    L9:
        int r2 = (r7.size() / r8) + r0;
        ArrayList[] r3 = new ArrayList[r2];
    L10:
        if (r1 >= r2) goto L20;
        int r4 = r8 * r1;
        int r5 = r1 + 1;
        int r6 = r8 * r5;
        if (r5 != r2) goto L14;
        r6 = r7.size();
    L14:
        r3[r1] = new ArrayList(r7.subList(r4, r6));
        r1 = r5;
        goto L10
    L20:
        return r3;
    L8:
        r0 = 1;
    L15:
        return null;
    }
}
