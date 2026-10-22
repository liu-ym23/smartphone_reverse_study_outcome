package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends com.larus.dora.impl.util.r0 {
    public m() {
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void a1(DoraDevice r100, mj4.b r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r101, "state");
        int r102 = r101.f514221a;
        int r103 = o.f332220a.getAndSet(r102);
        if (r103 == r102) goto L6;
        g49.d.d("DoraBtStatusManager", "onIdleStateChanged: bt state updated from " + r103 + " to " + r102);
        o.a(r103, r102);
        return;
    }
}
