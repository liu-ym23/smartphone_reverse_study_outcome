package com.bytedance.common.utility;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Lists {
    public static <T> boolean isEmpty(List<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.size() == 0) goto L7;
        return false;
    }

    public static <T> boolean notEmpty(List<T> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.size() <= 0) goto L6;
        return true;
    }

    public static <T> boolean deepEquals(List<T> r100, List<T> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r100.size() != r101.size()) goto L19;
        int r102 = 0;
    L13:
        if (r102 >= r100.size()) goto L18;
        if (ListProtector.get(r100, r102).equals(ListProtector.get(r101, r102)) == false) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L19:
        return false;
    }
}
