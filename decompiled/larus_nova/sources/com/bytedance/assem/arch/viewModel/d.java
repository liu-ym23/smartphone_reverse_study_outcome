package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.extensions.HostInjector;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Lazy<CoroutineScope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f193083a;

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return true;
    }

    @Override // kotlin.Lazy
    public final CoroutineScope getValue() {
        c r100 = this.f193083a;
        if (r100 != null) goto L6;
        Lazy r101 = HostInjector.f192919a;
        Executor r102 = HostInjector.a();
        c r103 = new c(SupervisorKt.m10961SupervisorJob$default(null, 1, null).plus(ExecutorsKt.from(r102)));
        this.f193083a = r103;
        return r103;
    L6:
        return r100;
    }

    public d(boolean r100) {
    }
}
