package nu3;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d> f520602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<e> f520603b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BlockingQueue<c> f520604c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f520605d;

    static {
        f520602a = new CopyOnWriteArrayList();
        f520603b = new CopyOnWriteArrayList();
        f520604c = new LinkedTransferQueue();
        f520605d = false;
    }

    public static void a(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((LinkedTransferQueue) f520604c).offer(r100);
        if (f520605d == false) goto L7;
        return;
    L7:
        monitor-enter(b.class);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (f520605d == false) goto L13;
        monitor-exit(b.class);
        return;
    L13:
        f520605d = true;     // Catch: Throwable -> L16
        ThreadMethodProxy.start(new PthreadThreadV2(new a(), "APM-Monitor"));     // Catch: Throwable -> L16
        monitor-exit(b.class);
    }
}
