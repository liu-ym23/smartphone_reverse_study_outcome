package com.larus.dora.impl.ota;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f337772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f337773b;

    public k() {
        StateFlowImpl r100 = j1.a(new ConcurrentHashMap());
        this.f337772a = r100;
        this.f337773b = r100;
    }

    public final synchronized void a(String r100, d49.a r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r101, "value");     // Catch: Throwable -> L8
        Map r102 = (Map) this.f337772a.getValue();     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(r102.get(r100), r101) == true) goto L6;
        Map r103 = MapsKt.toMutableMap(r102);     // Catch: Throwable -> L8
        r103.put(r100, r101);     // Catch: Throwable -> L8
        this.f337772a.setValue(r103);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
