package gl5;

import com.bytedance.ee.bear.operation.net.OperationUploadRequester;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f481586a;

    public a() {
    }

    public final void a() {
        final b r100 = this.f481586a;
        final h r101 = (h) this;
        Flowable r102 = Flowable.just(100).subscribeOn(fo5.d.c()).map(new c()).filter(new d(r101));
        final OperationUploadRequester r103 = r101.f481596b;
        Objects.requireNonNull(r103);
        r101.f481597c = r102.flatMap(new e(r103)).observeOn(fo5.d.c()).subscribe(new f(r101, r100), new g(r101));
    }

    public final void b() {
        b r100 = this.f481586a;
        monitor-enter(r100);
        CopyOnWriteArrayList<a> r101 = r100.f481590c;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        tt5.a.h("OperationUploadManager", "removeTask: " + r101.remove(this));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);
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
