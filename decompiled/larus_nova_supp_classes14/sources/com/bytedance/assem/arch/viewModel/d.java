package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.extensions.HostInjector;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Lazy<CoroutineScope> {
    public c a;

    public final boolean isInitialized() {
        return true;
    }

    public final Object getValue() {
        c r0 = this.a;
        if (r0 != null) goto L6;
        Lazy r1 = HostInjector.a;
        Executor r2 = HostInjector.a();
        c r3 = new c(SupervisorKt.SupervisorJob$default(null, 1, null).plus(ExecutorsKt.from(r2)));
        this.a = r3;
        return r3;
    L6:
        return r0;
    }

    public d(boolean r1) {
    }
}
