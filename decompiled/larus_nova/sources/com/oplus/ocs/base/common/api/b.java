package com.oplus.ocs.base.common.api;

import android.content.Context;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.utils.ServiceCheck;

/* JADX INFO: loaded from: classes34.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f404199a;

    public static b a() {
        if (f404199a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f404199a != null) goto L9;
        f404199a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f404199a;
    }

    private b() {
    }

    public static e a(Context r100, InternalClient r101, IAuthenticationListener r102) {
        if (ServiceCheck.check(r100, "com.oplus.ocs") == false) goto L7;
        return new h(r100, r101, r102);
    L7:
        if (ServiceCheck.check(r100, "com.coloros.ocs.opencapabilityservice") == true) goto L9;
        return null;
    L9:
        return new f(r100, r101, r102);
    }

    public static e a(Context r100, String r101, c r102, k r103) {
        if (ServiceCheck.check(r100, "com.oplus.ocs") == false) goto L7;
        return new g(r100, r101, r102, r103);
    L7:
        if (ServiceCheck.check(r100, "com.coloros.ocs.opencapabilityservice") == true) goto L9;
        return null;
    L9:
        return new a(r100, r101, r102, r103);
    }
}
