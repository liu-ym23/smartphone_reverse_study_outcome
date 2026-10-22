package com.bytedance.ee.bear.document;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c2 implements Runnable {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ Ref.IntRef b;

    public final void a() {
        long r0 = b2.a(this.a);
        this.a.getClass();
        long r2 = eu5.g.b(Process.myPid());
        ((CopyOnWriteArrayList) this.a.b).add(Long.valueOf(r0));
        ((CopyOnWriteArrayList) this.a.c).add(Long.valueOf(r2));
        tt5.a.h("DocWebPerfMonitor", "record memory info, sandboxMemoryRss: " + r0 + ", mainMemoryRss: " + r2 + ", times: " + this.b.element);
        Ref.IntRef r1 = this.b;
        int r3 = r1.element + 1;
        r1.element = r3;
        if (r3 <= 12) goto L6;
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

    public c2(b2 r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
