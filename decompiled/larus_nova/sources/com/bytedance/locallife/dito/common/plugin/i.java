package com.bytedance.locallife.dito.common.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f257585a;

    public i(Function0<Boolean> r100) {
        this.f257585a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f257585a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
