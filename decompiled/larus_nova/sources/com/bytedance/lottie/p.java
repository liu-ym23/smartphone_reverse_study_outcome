package com.bytedance.lottie;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f264580a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.f264580a.f264587f != null) goto L5;
        return;
    L5:
        if (this.f264580a.f264586e.isCancelled() == true) goto L23;
        o<T> r100 = this.f264580a.f264587f;
        V r101 = r100.f264578a;
        if (r101 == 0) goto L13;
        q r102 = this.f264580a;
        r102.getClass();
        Iterator r103 = new ArrayList(r102.f264583b).iterator();
    L11:
        if (r103.hasNext() == false) goto L25;
        ((l) r103.next()).onResult(r101);
        goto L11
    L25:
        return;
    L13:
        q r104 = this.f264580a;
        Throwable r105 = r100.f264579b;
        r104.getClass();
        ArrayList r106 = new ArrayList(r104.f264584c);
        if (r106.isEmpty() == true) goto L24;
        Iterator r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L26;
        ((l) r107.next()).onResult(r105);
        goto L18
    L26:
        return;
    L24:
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

    public p(q r100) {
        this.f264580a = r100;
    }
}
