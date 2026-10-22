package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public class dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Vector<Pair<String, Long>> f463419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f469a;

    static {
        f463419a = new Vector();
        f469a = new ConcurrentHashMap();
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        Vector<Pair<String, Long>> r101 = f463419a;
        monitor-enter(r101);
        int r102 = 0;
    L18:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (r102 >= f463419a.size()) goto L11;
        Pair<String, Long> r103 = f463419a.elementAt(r102);     // Catch: Throwable -> L15
        r100.append((String) r103.first);     // Catch: Throwable -> L15
        r100.append(":");     // Catch: Throwable -> L15
        r100.append(r103.second);     // Catch: Throwable -> L15
        if (r102 >= (f463419a.size() - 1)) goto L10;
        r100.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L15
    L10:
        r102 = r102 + 1;     // Catch: Throwable -> L15
        goto L18
    L11:
        f463419a.clear();     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r100.toString();
    }
}
