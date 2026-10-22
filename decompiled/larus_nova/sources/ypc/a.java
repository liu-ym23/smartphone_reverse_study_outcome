package ypc;

import com.larus.apm.impl.protector.RunnableProtector;
import dqc.e;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f568734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f568735b;

    /* JADX INFO: renamed from: ypc.a$a, reason: collision with other inner class name */
    public class RunnableC8371a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f568737b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f568736a.run();     // Catch: Throwable -> L4
        L6:
            this.f568737b.f568734a.countDown();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L4:
            th = move-exception;
            this.f568737b.f568735b = th;     // Catch: Throwable -> L8
            goto L6
        }

        public RunnableC8371a(a r100, b r101) {
            this.f568737b = r100;
            this.f568736a = r101;
        }
    }

    public interface b {
        void run() throws Throwable;
    }

    public a(b[] r100) {
        this.f568734a = new CountDownLatch(r100.length);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        e.b(new RunnableC8371a(this, r100[r102]));
        r102 = r102 + 1;
        goto L3
    }

    public static void a(b... r100) throws Throwable {
        a r101 = new a(r100);
        r101.f568734a.await();     // Catch: InterruptedException -> L8
        Throwable r102 = r101.f568735b;
        if (r102 != null) goto L7;
        return;
    L7:
        throw r102;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
