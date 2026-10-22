package cc4;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$a implements Runnable {
    public final String a;
    public final int b;

    public final void a() {
        ConcurrentHashMap r0 = (ConcurrentHashMap) g.k;
        if (((c) r0.get(this.a)) != null) goto L5;
        c r1 = new c(this.a, r0.size());
        g.d().getClass();
        g.l(r1);
    L5:
        List r2 = g.h;
        LinkedList r3 = (LinkedList) r2;
        if (r3.size() < 60) goto L8;
        ListProtector.remove(r2, 0);
    L8:
        d r4 = new d(this.a);
        r4.b = System.currentTimeMillis();
        int r5 = r3.lastIndexOf(r4);
        if (r5 >= 0) goto L11;
        r3.add(r4);
        return;
    L11:
        if (((d) ListProtector.get(r2, r5)).c <= 0) goto L15;
        r3.add(r4);
        return;
    }

    public final void b() {
        d r0 = new d(this.a);
        List r1 = g.h;
        int r2 = ((LinkedList) r1).lastIndexOf(r0);
        if (r2 < 0) goto L19;
        d r3 = (d) ListProtector.get(r1, r2);
        r3.c = System.currentTimeMillis();
        Map r4 = g.k;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        c r6 = (c) r5.get(this.a);
        if (r6 == null) goto L20;
        h r7 = r6.f;
        if (r7 == null) goto L9;
        r3.d = r7.a();
    L9:
        h r8 = r6.g;
        if (r8 == null) goto L12;
        r3.e = r8.a();
    L12:
        h r9 = r6.h;
        if (r9 == null) goto L15;
        r3.f = r9.a();
    L15:
        h r10 = r6.i;
        if (r10 == null) goto L21;
        r3.g = r10.a();
        return;
    L21:
        return;
    L20:
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:22:0x001e */
    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;     // Catch: Throwable -> L10 Exception -> L12
        if (r0 != 2) goto L5;
        b();     // Catch: Throwable -> L10 Exception -> L12
    L19:
        return;
    L5:
        if (r0 != 4) goto L19;
        a();     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L19
    }

    public g$a(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
