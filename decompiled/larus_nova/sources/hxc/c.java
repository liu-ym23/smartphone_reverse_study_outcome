package hxc;

import android.content.Context;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import exc.e;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f487584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f487585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f487586c;

    public abstract void a();

    public abstract void b(ErrorStatus r100);

    public final void c() {
        e.c("AIDLTask", "finishTask");
        a r100 = a.a(this.f487586c);
        if (r100 == null) goto L14;
        e.c("AIDLClientInvokeManager", "sendTaskFinishMsg");
        Queue<c> r101 = r100.f487576c;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f487572j.decrementAndGet() != 0) goto L9;
        r100.f487581h.sendEmptyMessage(3004);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L14:
        this.f487584a.countDown();
        this.f487585b.set(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L14
    L10:
        e.c("AIDLTask", "execute await InterruptedException");     // Catch: Throwable -> L14
        if (this.f487585b.get() == true) goto L19;
        this.f487585b.set(true);     // Catch: Throwable -> L14
        b(null);     // Catch: Throwable -> L14
        c();     // Catch: Throwable -> L14
    L19:
        return;
    L5:
        if (this.f487584a.await(12000, TimeUnit.MILLISECONDS) == true) goto L19;
        if (this.f487585b.get() == true) goto L19;
        this.f487585b.set(true);     // Catch: InterruptedException -> L10 Throwable -> L14
        b(null);     // Catch: InterruptedException -> L10 Throwable -> L14
        c();     // Catch: InterruptedException -> L10 Throwable -> L14
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    }

    public c(Context r100) {
        this.f487584a = new CountDownLatch(1);
        this.f487585b = new AtomicBoolean(false);
        this.f487586c = r100;
    }
}
