package gl5;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static volatile b d;
    public volatile boolean a;
    public Handler b;
    public final CopyOnWriteArrayList<a> c;

    public static b a() {
        if (d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public b() {
        this.a = false;
        this.c = new CopyOnWriteArrayList();
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2(b.class.getName());
        ThreadMethodProxy.start(r1);
        this.b = new Handler(r1.getLooper());
    }

    public final synchronized void b(h r2, long r3) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.a == true) goto L9;
        tt5.a.h("OperationUploadManager", "postTask failed by upload enable is false");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L9:
        if (this.c.isEmpty() == true) goto L14;
        tt5.a.h("OperationUploadManager", "postTask repeatedly and ignore task");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L14:
        if (this.b != null) goto L18;
        tt5.a.h("OperationUploadManager", "uploadHandler is not init");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L18:
        r2.a = this;     // Catch: Throwable -> L21
        this.c.add(r2);     // Catch: Throwable -> L21
        this.b.postDelayed(r2, r3);     // Catch: Throwable -> L21
        monitor-exit(this);
    }
}
