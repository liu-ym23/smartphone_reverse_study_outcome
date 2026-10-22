package yg2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ xg2.b b;

    public b(a r1, xg2.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = this.a.c(this.b);
        if (r0 != null) goto L5;
        return;
    L5:
        xg2.b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r1.a = r0;
        xg2.b r2 = this.b;
        System.currentTimeMillis();
        r2.getClass();
        LinkedList r3 = (LinkedList) ((ConcurrentHashMap) this.a.b).get(r0);
        if (r3 == null) goto L9;
        r3.add(this.b);
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
}
