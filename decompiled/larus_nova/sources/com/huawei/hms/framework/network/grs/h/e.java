package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes23.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277268a = "e";

    public static boolean a(Long r100) {
        if (r100 != null) goto L14;
        Logger.v(f277268a, "Method isTimeExpire input param expireTime is null.");
        return true;
    L14:
        long r101 = System.currentTimeMillis();     // Catch: NumberFormatException -> L12
        if ((r100.longValue() - r101) < 0) goto L10;
        Logger.i(f277268a, "isSpExpire false.");     // Catch: NumberFormatException -> L12
        return false;
    L10:
        Logger.i(f277268a, "isSpExpire true.");     // Catch: NumberFormatException -> L12
    L13:
        return true;
    L12:
        Logger.v(f277268a, "isSpExpire spValue NumberFormatException.");
        goto L13
    }

    public static boolean a(Long r100, long r101) {
        if (r100 != null) goto L13;
        Logger.v(f277268a, "Method isTimeWillExpire input param expireTime is null.");
        return true;
    L13:
        long r102 = System.currentTimeMillis();     // Catch: NumberFormatException -> L11
        if ((r100.longValue() - (r102 + r101)) < 0) goto L12;
        Logger.v(f277268a, "isSpExpire false.");     // Catch: NumberFormatException -> L11
        return false;
    L12:
        return true;
    L11:
        Logger.v(f277268a, "isSpExpire spValue NumberFormatException.");
        goto L12
    }
}
