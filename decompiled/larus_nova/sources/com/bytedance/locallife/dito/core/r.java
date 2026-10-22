package com.bytedance.locallife.dito.core;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f257971a;

    public r(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f257971a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f257971a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
