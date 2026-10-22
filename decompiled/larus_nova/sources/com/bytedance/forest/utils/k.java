package com.bytedance.forest.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainThreadExecutor f244577a;

    public k(MainThreadExecutor r100) {
        this.f244577a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        this.f244577a.f244489b.remove().run();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
