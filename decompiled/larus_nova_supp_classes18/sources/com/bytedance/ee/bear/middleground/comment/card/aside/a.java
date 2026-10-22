package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ kotlinx.coroutines.i<Unit> a;

    public a(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.isActive() == true) goto L5;
        return;
    L5:
        if (this.a.isCancelled() == true) goto L15;
        kotlinx.coroutines.i<Unit> r0 = this.a;     // Catch: Throwable -> L8
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));     // Catch: Throwable -> L8
        return;
    }
}
