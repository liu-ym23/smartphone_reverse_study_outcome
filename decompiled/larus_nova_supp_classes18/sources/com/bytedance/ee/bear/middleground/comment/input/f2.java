package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f2 implements Runnable {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Action c;

    public f2(b2 r1, String r2, Action r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a.d;     // Catch: Throwable -> L4
        String r1 = this.b;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        r0.w(r1, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
