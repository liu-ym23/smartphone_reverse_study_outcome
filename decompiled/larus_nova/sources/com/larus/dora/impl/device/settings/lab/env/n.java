package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.wear.WearState;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveWearState;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n implements uk4.c {
    public n() {
    }

    @Override // uk4.c
    public final void a(DoraDevice r110, WearState r111, WearState r112) {
        DoraEnvObserveManager r100 = DoraEnvObserveManager.f334593a;
        r100.getClass();
        String r113 = r110.f204389mac;
        if (r113 != null) goto L5;
        r100.getClass();
        r113 = DoraEnvObserveManager.e();
    L5:
        if (r113 == null) goto L38;
        r49.d r101 = DoraEnvObserveManager.f();
        r49.d.b r102 = null;
        if (r111 == null) goto L9;
        Integer r114 = Integer.valueOf(r111.ordinal());
    L10:
        if (r112 == null) goto L12;
        Integer r115 = Integer.valueOf(r112.ordinal());
    L13:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r113, "mac");
        int r103 = r49.d.f536102j;
        EnvObserveWearState r116 = r49.d.a.a(r114, r115);
        Object r117 = r101.f536108f;
        monitor-enter(r117);
        r101.f536110h.put(r113, r116);     // Catch: Throwable -> L35
        r49.d.b r104 = (r49.d.b) ((LinkedHashMap) r101.f536109g).get(r113);     // Catch: Throwable -> L35
        if (r104 == null) goto L32;
        EnvObserveWearState r105 = EnvObserveWearState.UNWORN;     // Catch: Throwable -> L35
        if (r116 == r105) goto L21;
    L23:
        if (r116 != r105) goto L26;
        Long r118 = r104.f536113b;     // Catch: Throwable -> L35
    L25:
        Long r106 = r118;
    L28:
        if (Intrinsics.areEqual(r106, r104.f536113b) == true) goto L32;
        r49.d.b r119 = new r49.d.b(r104.f536112a, r106, r104.f536114c, r101.e(r113));     // Catch: Throwable -> L35
        r101.f536109g.put(r113, r119);     // Catch: Throwable -> L35
        r102 = r119;
        goto L32
    L26:
        r106 = null;
        goto L28
    L21:
        if (r104.f536113b != null) goto L23;
        r118 = r101.f536103a.invoke();     // Catch: Throwable -> L35
    L32:
        monitor-exit(r117);
        if (r102 == null) goto L41;
        r101.f(r113, r102);
        return;
    L41:
        return;
    L35:
        th = move-exception;
        throw th;
    L12:
        r115 = null;
        goto L13
    L9:
        r114 = null;
        goto L10
    }
}
