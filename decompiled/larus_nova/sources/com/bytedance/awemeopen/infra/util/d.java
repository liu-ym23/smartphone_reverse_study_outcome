package com.bytedance.awemeopen.infra.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes46.dex */
public final class d {
    public static <T> boolean a(Collection<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
