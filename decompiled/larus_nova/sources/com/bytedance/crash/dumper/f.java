package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.m0;
import com.bytedance.crash.util.ListMap;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f203157a = true;

    public static void a(File r100, CrashType r101) {
        com.bytedance.crash.monitor.a r102 = com.bytedance.crash.monitor.j.f203315a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (f203157a == false) goto L25;
        m0 r103 = r102.f203291c;     // Catch: Throwable -> L20
        ListMap<CrashType, com.bytedance.crash.b> r104 = r103.f203243f;     // Catch: Throwable -> L20
        monitor-enter(r104);     // Catch: Throwable -> L20
        List<com.bytedance.crash.b> r105 = r103.f203243f.getList(r101);     // Catch: Throwable -> L16
        monitor-exit(r104);     // Catch: Throwable -> L16
        Iterator<com.bytedance.crash.b> r106 = r105.iterator();     // Catch: Throwable -> L20
    L13:
        if (r106.hasNext() == false) goto L27;
        r106.next().a(r101);     // Catch: Throwable -> L20
        goto L13
    L27:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L26:
        return;
    }
}
