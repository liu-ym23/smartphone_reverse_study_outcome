package com.larksuite.framework.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes24.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f285946a = null;

    static {
        f285946a = new Random();
    }

    public static int a(int r100) {
        boolean r101 = true;
        if (Integer.MAX_VALUE < r100) goto L5;
        boolean r102 = true;
    L6:
        Object[] r103 = new Object[0];
        if (r102 == false) goto L20;
        if (r100 >= 0) goto L11;
        r101 = false;
    L11:
        Object[] r104 = new Object[0];
        if (r101 == false) goto L18;
        if (r100 != Integer.MAX_VALUE) goto L16;
        return r100;
    L16:
        return r100 + f285946a.nextInt(Integer.MAX_VALUE - r100);
    L18:
        throw new IllegalArgumentException(String.format("Both range values must be non-negative.", r104));
    L20:
        throw new IllegalArgumentException(String.format("Start value must be smaller or equal to end value.", r103));
    L5:
        r102 = false;
        goto L6
    }
}
