package com.larus.dora.impl.core;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class u0 implements com.larus.platform.api.b {
    public u0() {
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        CoroutineScope r101 = DoraSyncManager.f332165a;
        DoraSyncManager.c("3");
    }
}
