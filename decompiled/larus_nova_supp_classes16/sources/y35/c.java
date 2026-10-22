package y35;

import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ BearUrl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public c(BearUrl r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        tt5.a.h("SyncBlockResolver", "insert...");
        m0 r0 = new m0();
        r0.k = this.a.b;
        r0.b = this.b;
        r0.c = this.c;
        e0.m().w(r0);
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
