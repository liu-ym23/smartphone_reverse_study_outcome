package com.bytedance.ee.bear.drive.core.fragment;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ k b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Runnable e;

    public p(View r1, k r2, Object r3, long r4, Runnable r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void a() {
        k r0 = this.b;
        if (r0.n == false) goto L5;
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout skipped: released before action");
        return;
    L5:
        Long r1 = r0.s.get(this.c);
        long r3 = this.d;
        if (r1 != null) goto L9;
    L10:
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout skipped: stale action");
        return;
    L9:
        if (r1.longValue() != r3) goto L10;
        this.b.s.remove(this.c);
        this.e.run();
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout success: deferred");
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
