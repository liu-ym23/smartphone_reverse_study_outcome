package com.larus.dora.obric.device_management.device_home;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f339221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f339222b;

    public static final class a {
    }

    static {
    }

    public f2() {
        this.f339221a = new Object();
        this.f339222b = new LinkedHashMap();
    }

    public final boolean a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceMac");
        Object r102 = this.f339221a;
        monitor-enter(r102);
        Long r103 = (Long) ((LinkedHashMap) this.f339222b).get(r100);     // Catch: Throwable -> L14
        if (r103 != null) goto L8;
    L9:
        boolean r104 = false;
    L12:
        monitor-exit(r102);
        return r104;
    L8:
        if (r103.longValue() != r101) goto L9;
        this.f339222b.remove(r100);     // Catch: Throwable -> L14
        r104 = true;
    L14:
        th = move-exception;
        throw th;
    }
}
