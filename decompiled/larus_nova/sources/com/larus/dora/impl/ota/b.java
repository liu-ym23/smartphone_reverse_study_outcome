package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f337423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f337424b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b1 f337425c = null;

    public b() {
    }

    static {
        f337423a = new b();
        StateFlowImpl r100 = j1.a(MapsKt.emptyMap());
        f337424b = r100;
        f337425c = kotlinx.coroutines.flow.e.b(r100);
    }

    public static String a(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        String r101 = (String) ((Map) f337425c.getValue()).get(r100.f204390sn);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public final synchronized void b(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "sn");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "version");     // Catch: Throwable -> L7
        g49.d.d("DoraOTACompat", "notifyNewVersionChanged: sn=" + r100 + ", version=" + r101);     // Catch: Throwable -> L7
        StateFlowImpl r102 = f337424b;     // Catch: Throwable -> L7
        Map r103 = MapsKt.toMutableMap((Map) r102.getValue());     // Catch: Throwable -> L7
        r103.put(r100, r101);     // Catch: Throwable -> L7
        r102.setValue(r103);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
