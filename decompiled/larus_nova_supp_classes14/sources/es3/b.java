package es3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import et3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;

    public final void a() {
        e.a r0 = this.b.d;
        long r1 = this.a;
        r0.a++;
        r0.b += r1;
        int r2 = 0;
    L4:
        if (r2 >= this.b.b.size()) goto L6;
        h r3 = (h) ListProtector.get(this.b.b, r2);
        long r4 = this.a;
        e.a r5 = r3.c;
        r5.a++;
        r5.b += r4;
        r2 = r2 + 1;
        goto L4
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

    public b(e r1, long r2, boolean r4) {
        this.b = r1;
        this.a = r2;
    }
}
