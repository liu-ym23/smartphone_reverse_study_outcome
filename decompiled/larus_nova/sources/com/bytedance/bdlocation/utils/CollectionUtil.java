package com.bytedance.bdlocation.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean isEmpty(Collection r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean containsIgnoreCase(List<String> r100, String r101) {
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.size() < 1) goto L13;
        Iterator<String> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (r102.next().equalsIgnoreCase(r101) == false) goto L9;
        return true;
    }
}
