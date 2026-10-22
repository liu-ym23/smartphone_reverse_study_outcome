package com.bytedance.ee.bear.bitable.superagent;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ BitableSuperAgentBasePanel a;
    public final /* synthetic */ FrameLayout b;

    public a(BitableSuperAgentBasePanel r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        FrameLayout r0 = this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r0);     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        BitableSuperAgentBasePanel r3 = this.a;
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L13;
        tt5.a.l(r3.fa0(), "addWatermark failed", r4);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
