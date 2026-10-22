package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.shopping.store.tabkit.ssr.interfaces.SSRFetchCallbackDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ Runnable a;

    public c(SSRFetchCallbackDelegate.C02001.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        this.a.run();     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
