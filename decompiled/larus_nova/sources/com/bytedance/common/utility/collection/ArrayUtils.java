package com.bytedance.common.utility.collection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class ArrayUtils {
    public static List<Long> toList(long[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101.add(Long.valueOf(r100[r103]));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    public static long[] toLongArray(List<Long> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        long[] r101 = new long[r100.size()];
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L9;
        r101[r102] = ((Long) ListProtector.get(r100, r102)).longValue();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static <T> T[] insert(T[] r100, int r101, T r102) {
        T[] r103 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r100.length + 1));
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L11;
        if (r104 >= r101) goto L7;
        T r105 = r100[r104];
    L10:
        r103[r104] = r105;
        r104 = r104 + 1;
        goto L4
    L7:
        if (r104 != r101) goto L9;
        r105 = r102;
        goto L10
    L9:
        r105 = r100[r104 - 1];
        goto L10
    L11:
        return r103;
    }
}
