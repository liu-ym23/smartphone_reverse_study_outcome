package com.ss.android.ugc.effectmanager.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static List<String> convertListObjToStr(List<?> r100) {
        if (isListEmpty(r100) == false) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<?> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (r103 == null) goto L12;
        String r104 = r103.toString();
    L13:
        r101.add(r104);
        goto L8
    L12:
        r104 = "";
        goto L13
    L14:
        return r101;
    }

    public static List<?> convertObjectToList(Object r100) {
        ArrayList r101 = new ArrayList();
        if (r100.getClass().isArray() == false) goto L6;
        return Arrays.asList((Object[]) r100);
    L6:
        if ((r100 instanceof Collection) == true) goto L8;
        return r101;
    L8:
        return new ArrayList((Collection) r100);
    }

    public static <T> boolean isArrayEmpty(T[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static boolean isCollection(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getClass().isArray() == false) goto L8;
    L9:
        return true;
    L8:
        if ((r100 instanceof Collection) == true) goto L9;
        return false;
    }

    public static <T> boolean isListEmpty(List<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isMapEmpty(Map r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
