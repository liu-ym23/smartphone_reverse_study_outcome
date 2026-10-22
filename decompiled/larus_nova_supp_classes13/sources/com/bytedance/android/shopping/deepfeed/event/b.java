package com.bytedance.android.shopping.deepfeed.event;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ long b;

    public b(a r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L12
        r0.k = null;     // Catch: Throwable -> L12
        a.d r1 = r0.c;     // Catch: Throwable -> L12
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.a == this.b) goto L7;
        return;
    L7:
        if (r1.m == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r1.n, "switch_image") == false) goto L21;
        this.a.e(r1, "switch_image");     // Catch: Throwable -> L12
        return;
    L21:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
