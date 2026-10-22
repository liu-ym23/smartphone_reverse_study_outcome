package com.xiaomi.push;

import android.content.Context;
import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f463103a = null;

    static {
        f463103a = "0123456789ABCDEF".toCharArray();
    }

    public static boolean a(Context r100) {
        return z.f464371a;
    }

    public static String a(byte[] r100, int r101, int r102) {
        StringBuilder r103 = new StringBuilder(r102 * 2);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L6;
        int r105 = r100[r101 + r104] & UByte.MAX_VALUE;
        char[] r106 = f463103a;
        r103.append(r106[r105 >> 4]);
        r103.append(r106[r105 & 15]);
        r104 = r104 + 1;
        goto L3
    L6:
        return r103.toString();
    }
}
