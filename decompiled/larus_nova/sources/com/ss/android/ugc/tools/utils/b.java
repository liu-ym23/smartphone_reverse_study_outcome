package com.ss.android.ugc.tools.utils;

import java.util.Collection;

/* JADX INFO: loaded from: classes40.dex */
public final class b {
    public static <T> boolean a(Collection<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
