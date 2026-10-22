package com.larus.dora.impl.ota.g;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes27.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f337564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IntRange f337565b = null;

    static {
        f337564a = new IntRange(140, 159);
        f337565b = new IntRange(180, 189);
    }

    public static boolean a(int r100) {
        if (r100 == 134) goto L19;
        IntRange r101 = f337564a;
        int r102 = r101.getFirst();
        if (r100 > r101.getLast()) goto L8;
        if (r102 > r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L20;
        IntRange r104 = f337565b;
        int r105 = r104.getFirst();
        if (r100 > r104.getLast()) goto L14;
        if (r105 > r100) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L21;
        return false;
    L21:
        return true;
    L14:
        r106 = false;
        goto L15
    L20:
        return true;
    L8:
        r103 = false;
        goto L9
    L19:
        return true;
    }
}
