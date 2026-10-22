package com.bytedance.ee.bear.document.print;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p implements Runnable {
    public final /* synthetic */ PrintMinutesOptionSelector a;
    public final /* synthetic */ long b;
    public final /* synthetic */ oj5.c c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ Function1<String, Unit> e;
    public final /* synthetic */ Function0<Unit> f;
    public final /* synthetic */ Function0<Unit> g;

    /* JADX WARN: Multi-variable type inference failed */
    public p(PrintMinutesOptionSelector r1, long r2, oj5.c r4, Boolean r5, Function1<? super String, Unit> r6, Function0<Unit> r7, Function0<Unit> r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrintMinutesOptionSelector r0 = this.a;     // Catch: Throwable -> L7
        long r1 = this.b;     // Catch: Throwable -> L7
        int r3 = PrintMinutesOptionSelector.e;     // Catch: Throwable -> L7
        if (r0.f(r1) == false) goto L10;
        this.a.h(this.b, this.c, Intrinsics.areEqual(this.d, Boolean.TRUE), this.e, this.f, this.g);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
