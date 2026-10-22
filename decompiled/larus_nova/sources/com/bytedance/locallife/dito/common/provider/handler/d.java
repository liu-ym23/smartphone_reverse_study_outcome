package com.bytedance.locallife.dito.common.provider.handler;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f257646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f257647b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f257647b == true) goto L10;
        this.f257647b = true;     // Catch: Throwable -> L7
        this.f257646a.invoke();     // Catch: Throwable -> L7
        return;
    }

    public d(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f257646a = r100;
    }
}
