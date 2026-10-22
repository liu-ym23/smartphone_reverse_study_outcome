package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
public final class e {
    public static void a(Object[] r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r100[r102] == null) goto L8;
        r102 = r102 + 1;
        goto L3
    L8:
        throw new NullPointerException("at index " + r102);
    }
}
