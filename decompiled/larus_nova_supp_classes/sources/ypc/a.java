package ypc;

import com.larus.apm.impl.protector.RunnableProtector;
import dqc.e;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final CountDownLatch a;
    public Throwable b;

    /* JADX INFO: renamed from: ypc.a$a, reason: collision with other inner class name */
    public class RunnableC0016a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ a b;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
        L6:
            this.b.a.countDown();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L4:
            th = move-exception;
            this.b.b = th;     // Catch: Throwable -> L8
            goto L6
        }

        public RunnableC0016a(a r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
        void run() throws Throwable;
    }

    public a(b[] r5) {
        this.a = new CountDownLatch(r5.length);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        e.b(new RunnableC0016a(this, r5[r1]));
        r1 = r1 + 1;
        goto L3
    }

    public static void a(b... r1) throws Throwable {
        a r0 = new a(r1);
        r0.a.await();     // Catch: InterruptedException -> L8
        Throwable r2 = r0.b;
        if (r2 != null) goto L7;
        return;
    L7:
        throw r2;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
