package gl5;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f481587d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f481588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f481589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f481590c;

    public static b a() {
        if (f481587d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f481587d != null) goto L9;
        f481587d = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f481587d;
    }

    public b() {
        this.f481588a = false;
        this.f481590c = new CopyOnWriteArrayList();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(b.class.getName());
        ThreadMethodProxy.start(r100);
        this.f481589b = new Handler(r100.getLooper());
    }

    public final synchronized void b(h r100, long r101) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f481588a == true) goto L9;
        tt5.a.h("OperationUploadManager", "postTask failed by upload enable is false");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L9:
        if (this.f481590c.isEmpty() == true) goto L14;
        tt5.a.h("OperationUploadManager", "postTask repeatedly and ignore task");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L14:
        if (this.f481589b != null) goto L18;
        tt5.a.h("OperationUploadManager", "uploadHandler is not init");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L18:
        r100.f481586a = this;     // Catch: Throwable -> L21
        this.f481590c.add(r100);     // Catch: Throwable -> L21
        this.f481589b.postDelayed(r100, r101);     // Catch: Throwable -> L21
        monitor-exit(this);
    }
}
