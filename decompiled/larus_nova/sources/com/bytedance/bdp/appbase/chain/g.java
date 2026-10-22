package com.bytedance.bdp.appbase.chain;

import java.util.HashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Object, h> f200735a = null;

    static {
        f200735a = new HashMap();
    }

    @JvmStatic
    public static final f0<Object> a(Object r100, int r101) {
        HashMap<Object, h> r102 = f200735a;
        monitor-enter(r102);
        h r103 = r102.get(r100);     // Catch: Throwable -> L23
        if (r103 != null) goto L10;
        monitor-exit(r102);
        return null;
    L10:
        if (r103.f200737a.removeFirstOccurrence(Integer.valueOf(r101)) == true) goto L13;
        monitor-exit(r102);
        return null;
    L13:
        f0<Object> r104 = r103.f200738b.pollFirst();     // Catch: Throwable -> L23
        if (r104 == null) goto L17;
        r103.f200737a.addLast(Integer.valueOf(r104.f200729k.f200695a));     // Catch: Throwable -> L23
    L17:
        if (r103.f200737a.size() == 0) goto L19;
    L21:
        monitor-exit(r102);
        return r104;
    L19:
        if (r103.f200738b.size() != 0) goto L21;
        r102.remove(r100);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
