package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ EntryController.k a;
    public final /* synthetic */ vd.b b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function1 d;

    public m(EntryController.k r1, te.a r2, Function0 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
