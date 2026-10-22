package com.larus.ui.arch.vm.internal;

import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
public final class m implements Lazy<CoroutineScope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f375263a;

    public m() {
    }

    @Override // kotlin.Lazy
    public final CoroutineScope getValue() {
        a r100 = this.f375263a;
        if (r100 != null) goto L6;
        a r101 = new a(SupervisorKt.SupervisorJob$default(null, 1, null).plus(ExecutorsKt.from((Executor) j.f375253a.getValue())));
        this.f375263a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f375263a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
