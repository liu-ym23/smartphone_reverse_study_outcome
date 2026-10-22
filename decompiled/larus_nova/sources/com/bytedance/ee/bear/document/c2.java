package com.bytedance.ee.bear.document;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class c2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f219179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f219180b;

    public final void a() {
        long r100 = b2.a(this.f219179a);
        this.f219179a.getClass();
        long r101 = eu5.g.b(Process.myPid());
        ((CopyOnWriteArrayList) this.f219179a.f219145b).add(Long.valueOf(r100));
        ((CopyOnWriteArrayList) this.f219179a.f219146c).add(Long.valueOf(r101));
        tt5.a.h("DocWebPerfMonitor", "record memory info, sandboxMemoryRss: " + r100 + ", mainMemoryRss: " + r101 + ", times: " + this.f219180b.element);
        Ref.IntRef r102 = this.f219180b;
        int r103 = r102.element + 1;
        r102.element = r103;
        if (r103 <= 12) goto L6;
        this.f219179a.b();
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

    public c2(b2 r100, Ref.IntRef r101) {
        this.f219179a = r100;
        this.f219180b = r101;
    }
}
