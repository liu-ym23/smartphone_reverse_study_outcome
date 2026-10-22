package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y {
    public static final WeakHashMap<View, Long> a = null;

    static {
        a = new WeakHashMap();
    }

    public static boolean a(View r2) {
        return b(r2, 1200);
    }

    public static boolean b(View r7, long r8) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        WeakHashMap<View, Long> r1 = a;
        Long r2 = r1.get(r7);
        long r3 = System.nanoTime() / 1000000;
        if (r2 != null) goto L10;
        r1.put(r7, Long.valueOf(r3));
        return false;
    L10:
        if ((r3 - r2.longValue()) > r8) goto L12;
        r0 = true;
    L12:
        if (r0 == true) goto L14;
        r1.put(r7, Long.valueOf(r3));
    L14:
        return r0;
    }
}
