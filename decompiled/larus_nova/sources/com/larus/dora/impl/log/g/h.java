package com.larus.dora.impl.log.g;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends r0 {
    public h() {
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void a1(DoraDevice r100, mj4.b r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r101, "state");
        g49.d.d("DoraGLogManager", "onIdleStateChanged device " + r100 + ", state " + r101.f514221a);
    }
}
