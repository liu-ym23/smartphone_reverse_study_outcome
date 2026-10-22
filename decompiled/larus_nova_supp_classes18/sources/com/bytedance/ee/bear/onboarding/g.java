package com.bytedance.ee.bear.onboarding;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ i b;

    public final void a() {
        if (Intrinsics.areEqual((k) ((LinkedList) this.a.a).peekFirst(), this.b) == false) goto L6;
        StringBuilder r0 = new StringBuilder("[");
        String r1 = f.h;
        r0.append(f.h);
        r0.append("]Pending Task out of date : ");
        r0.append(this.b.b);
        tt5.a.b("OnBoardingManager", r0.toString());
        ((LinkedList) this.a.a).removeFirst();
        this.a.b();
        return;
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

    public g(f r1, i r2) {
        this.a = r1;
        this.b = r2;
    }
}
