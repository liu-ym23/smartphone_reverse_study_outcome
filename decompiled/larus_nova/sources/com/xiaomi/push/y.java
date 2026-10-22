package com.xiaomi.push;

import java.util.Collection;

/* JADX INFO: loaded from: classes41.dex */
public class y {
    public static <T> boolean a(Collection<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
