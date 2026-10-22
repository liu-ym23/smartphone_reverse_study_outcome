package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final ConcurrentHashMap<Long, f> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static f a(long r1) {
        return a.get(Long.valueOf(r1));
    }

    public static void c(long r1) {
        a.remove(Long.valueOf(r1));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere("ECWindowLifecycleManager.remove:" + e);
    }

    public static long b(long r4, boolean r6) {
        Intrinsics.checkNotNullParameter("javaClass", "name");
        long r2 = System.currentTimeMillis();
        ConcurrentHashMap<Long, f> r0 = a;
        f r5 = r0.get(Long.valueOf(r4));
        if (r5 == null) goto L5;
        f r7 = r5.w(r6);
    L6:
        WindowPrefMonitorLifecycle r8 = new WindowPrefMonitorLifecycle("javaClass");
        Intrinsics.checkNotNullParameter(r8, "lifeCycle");
        r7.a.add(r8);
        if (ECSettingKeys.c0() != 1) goto L9;
        h r9 = new h();
        Intrinsics.checkNotNullParameter(r9, "lifeCycle");
        r7.a.add(r9);
    L9:
        Intrinsics.checkNotNullParameter(r7, "windowLifecycleMonitor");
        r0.put(Long.valueOf(r2), r7);
        return r2;
    L5:
        r7 = new f(0);
        goto L6
    }
}
