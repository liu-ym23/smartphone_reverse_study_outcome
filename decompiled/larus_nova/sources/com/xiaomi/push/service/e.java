package com.xiaomi.push.service;

import com.xiaomi.push.eq;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e {
    public static boolean a(eq r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.a() != 10) goto L8;
        if (r100.m9066b() == false) goto L8;
        return true;
    }

    public static boolean b(eq r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.a() != 5) goto L8;
        if (r100.m9066b() == false) goto L8;
        return true;
    }
}
