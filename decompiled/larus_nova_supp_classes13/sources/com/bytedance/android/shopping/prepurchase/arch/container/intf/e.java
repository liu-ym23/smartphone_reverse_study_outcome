package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements i {
    public e() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.i
    public final void ensureNotReachHere(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        ECExceptionMonitor.e(r2);
    }
}
