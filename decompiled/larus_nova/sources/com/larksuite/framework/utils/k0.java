package com.larksuite.framework.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes24.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f286040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f286041b = 0;

    public k0() {
    }

    static {
        String[] r100 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");
        f286040a = r100;
        f286041b = (short) r100.length;
    }

    public static String a(short r100) {
        return b(r100, f286041b);
    }

    public static String b(short r100, short r101) {
        short r102 = f286041b;
        if (r101 <= r102) goto L5;
        r101 = r102;
    L5:
        if (r101 < 0) goto L8;
        r102 = r101;
    L8:
        Random r103 = new Random();
        if (r100 <= 0) goto L14;
        StringBuilder r104 = new StringBuilder();
        short r105 = 0;
    L11:
        if (r105 >= r100) goto L17;
        short r106 = (short) r103.nextInt(r102);
        r104.append(f286040a[r106]);
        r105 = (short) (r105 + 1);
        goto L11
    L17:
        return r104.toString();
    L14:
        return null;
    }
}
