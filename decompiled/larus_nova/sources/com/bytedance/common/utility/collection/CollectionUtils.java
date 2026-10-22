package com.bytedance.common.utility.collection;

import com.bytedance.common.utility.reflect.JavaCalls;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static void clear(Object r100) {
        JavaCalls.callMethod(r100, "clear", new Object[0]);
    }

    public static <T> boolean isEmpty(Collection<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
