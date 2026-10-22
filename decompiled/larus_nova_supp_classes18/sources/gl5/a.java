package gl5;

import com.bytedance.ee.bear.operation.net.OperationUploadRequester;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements Runnable {
    public b a;

    public a() {
    }

    public final void a() {
        final b r0 = this.a;
        final h r1 = (h) this;
        Flowable r2 = Flowable.just(100).subscribeOn(fo5.d.c()).map(new c()).filter(new d(r1));
        final OperationUploadRequester r3 = r1.b;
        Objects.requireNonNull(r3);
        r1.c = r2.flatMap(new e(r3)).observeOn(fo5.d.c()).subscribe(new f(r1, r0), new g(r1));
    }

    public final void b() {
        b r0 = this.a;
        monitor-enter(r0);
        CopyOnWriteArrayList<a> r2 = r0.c;     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        tt5.a.h("OperationUploadManager", "removeTask: " + r2.remove(this));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
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
