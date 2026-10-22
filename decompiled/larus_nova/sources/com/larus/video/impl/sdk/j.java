package com.larus.video.impl.sdk;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements com.larus.platform.api.b {
    public j() {
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Lazy r101 = q3.f365794a;
        z3 r102 = q3.a();
        if (r102 == null) goto L6;
        r102.n(null);
        return;
    }
}
