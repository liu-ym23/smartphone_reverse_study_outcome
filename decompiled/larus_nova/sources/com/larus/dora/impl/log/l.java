package com.larus.dora.impl.log;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends r0 {
    public l() {
    }

    @Override // com.larus.dora.impl.util.r0, mj4.h
    public final void a1(DoraDevice r100, mj4.b r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        g49.d.d("DoraLogManager", "onIdleStateChanged state: " + r101);
        if (r101.f514221a != 0) goto L5;
        DoraLogManager.f336063s = DoraLogManager.f336062r.schedule(new k(), 30000, TimeUnit.MILLISECONDS);
        return;
    L5:
        ScheduledFuture<?> r102 = DoraLogManager.f336063s;
        if (r102 == null) goto L8;
        r102.cancel(true);
    L8:
        DoraLogManager.f336063s = null;
        DoraLogManager.f336061q.set(true);
    }
}
