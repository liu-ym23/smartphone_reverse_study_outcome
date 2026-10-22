package com.larksuite.framework.utils;

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

/* JADX INFO: loaded from: classes24.dex */
public class CollectionUtils {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class a<K, V> implements Comparator<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((Comparable) ((Map.Entry) r100).getValue()).compareTo(((Map.Entry) r101).getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class b<K, V> implements Comparator<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((Comparable) ((Map.Entry) r101).getValue()).compareTo(((Map.Entry) r100).getValue());
        }
    }

    public CollectionUtils() {
    }

    public static <T> List<T> asList(T[] r100) {
        return asList(0, r100);
    }

    public static <T> List<T> checkListNull(List<T> r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return new ArrayList();
    }

    public static String generateAttributes(List<String> r100) {
        if (r100.size() != 0) goto L7;
        return "";
    L7:
        if (r100.size() == 1) goto L9;
        Iterator<String> r101 = r100.iterator();
        String r102 = "(";
    L12:
        if (r101.hasNext() == false) goto L15;
        r102 = r102 + "'" + r101.next() + "',";
        goto L12
    L15:
        return r102.substring(0, r102.length() - 1) + ")";
    L9:
        return "('" + ((String) ListProtector.get(r100, 0)) + "')";
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> getAscSortMapByValue(Map<K, V> r100) {
        return getSortMap(new HashMap(r100), new a());
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> getDescSortMapByValue(Map<K, V> r100) {
        return getSortMap(new HashMap(r100), new b());
    }

    public static boolean isEmpty(Collection r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Collection r100) {
        return !isEmpty(r100);
    }

    public static <T> List<T> iterableToList(Iterable<T> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next());
        goto L7
    L9:
        return r101;
    }

    public static boolean isEmpty(Map r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Map r100) {
        return !isEmpty(r100);
    }

    public static <T> List<T> asList(int r100, T[] r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r100 >= r101.length) goto L7;
        r102.add(r101[r100]);
        r100 = r100 + 1;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V extends Comparable<? super V>> Map<K, V> getSortMap(Map<K, V> r100, Comparator<Map.Entry<K, V>> r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        LinkedList r103 = new LinkedList(r100.entrySet());
        Collections.sort(r103, r101);
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r102.put(r105.getKey(), (Comparable) r105.getValue());
    L10:
        return r102;
    }

    public static <T> boolean isListSame(List<T> r100, List<T> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        if (ListProtector.get(r100, r102).equals(ListProtector.get(r101, r102)) == false) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static <T> void resetToList(List<? super T> r100, List<? extends T> r101) {
        if (r100 == null) goto L8;
        r100.clear();
        if (r101 == null) goto L9;
        r100.addAll(r101);
        return;
    L9:
        return;
    L8:
        throw null;
    }

    public static List[] split(List r100, int r101) {
        if (isNotEmpty(r100) == false) goto L15;
        if (r101 <= 0) goto L15;
        int r102 = 0;
        if ((r100.size() % r101) != 0) goto L8;
        int r103 = 0;
    L9:
        int r104 = (r100.size() / r101) + r103;
        ArrayList[] r105 = new ArrayList[r104];
    L10:
        if (r102 >= r104) goto L20;
        int r106 = r101 * r102;
        int r107 = r102 + 1;
        int r108 = r101 * r107;
        if (r107 != r104) goto L14;
        r108 = r100.size();
    L14:
        r105[r102] = new ArrayList(r100.subList(r106, r108));
        r102 = r107;
        goto L10
    L20:
        return r105;
    L8:
        r103 = 1;
    L15:
        return null;
    }
}
