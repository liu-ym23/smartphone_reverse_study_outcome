package com.larus.ui.arch.vm.internal;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements Closeable, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f375246a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        JobKt.cancel$default(this.f375246a, null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f375246a;
    }

    public a(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f375246a = r100;
    }
}
