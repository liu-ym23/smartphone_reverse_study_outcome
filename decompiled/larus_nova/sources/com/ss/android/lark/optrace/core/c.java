package com.ss.android.lark.optrace.core;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes37.dex */
@Deprecated(message = "This Container is deprecated,Use TracingServiceImpl Instead!")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile jyb.a f437607a;

    static {
        if (jyb.a.f501069a == null) goto L5;
    L14:
        f437607a = jyb.a.f501069a;
        return;
    L5:
        monitor-enter(jyb.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (jyb.a.f501069a != null) goto L9;
        jyb.a.f501069a = new jyb.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(jyb.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
