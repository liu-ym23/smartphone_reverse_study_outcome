package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = null;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<okhttp3.internal.connection.d> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final okhttp3.internal.connection.e routeDatabase;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConnectionPool f523775a;

        @Override // java.lang.Runnable
        public final void run() {
        L25:
            long r100 = this.f523775a.cleanup(System.nanoTime());     // Catch: Throwable -> L19
            if (r100 == (-1)) goto L22;
            if (r100 <= 0) goto L25;
            long r101 = r100 / 1000000;     // Catch: Throwable -> L19
            Long.signum(r101);
            long r102 = r100 - (1000000 * r101);
            ConnectionPool r103 = this.f523775a;     // Catch: Throwable -> L19
            monitor-enter(r103);     // Catch: Throwable -> L19
            this.f523775a.wait(r101, (int) r102);     // Catch: Throwable -> L13 InterruptedException -> L24
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L15:
            monitor-exit(r103);     // Catch: Throwable -> L13
            goto L25
        L22:
            return;
        L19:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L34;
            throw th;
        }

        public a(ConnectionPool r100) {
            this.f523775a = r100;
        }
    }

    public synchronized int connectionCount() {
        monitor-enter(this);
        int r100 = this.connections.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int idleConnectionCount() {
        monitor-enter(this);
        Iterator<okhttp3.internal.connection.d> r100 = this.connections.iterator();     // Catch: Throwable -> L11
        int r101 = 0;
    L5:
        if (r100.hasNext() == false) goto L9;
        if (((ArrayList) r100.next().f523894n).isEmpty() == false) goto L5;
        r101 = r101 + 1;
        goto L5
    L9:
        monitor-exit(this);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    static {
        TimeUnit r100 = TimeUnit.SECONDS;
        SynchronousQueue r101 = new SynchronousQueue();
        byte[] r102 = cvc.c.f465513a;
        executor = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r100, r101, new cvc.d("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public void evictAll() {
        ArrayList r100 = new ArrayList();
        monitor-enter(this);
        Iterator<okhttp3.internal.connection.d> r101 = this.connections.iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L10;
        okhttp3.internal.connection.d r102 = r101.next();     // Catch: Throwable -> L16
        if (((ArrayList) r102.f523894n).isEmpty() == false) goto L6;
        r102.f523891k = true;     // Catch: Throwable -> L16
        r100.add(r102);     // Catch: Throwable -> L16
        r101.remove();     // Catch: Throwable -> L16
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L16
        Iterator r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        cvc.c.f(((okhttp3.internal.connection.d) r103.next()).f523885e);
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public long cleanup(long r110) {
        monitor-enter(this);
        Iterator<okhttp3.internal.connection.d> r100 = this.connections.iterator();     // Catch: Throwable -> L32
        okhttp3.internal.connection.d r101 = null;
        long r102 = Long.MIN_VALUE;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r100.hasNext() == false) goto L12;
        okhttp3.internal.connection.d r105 = r100.next();     // Catch: Throwable -> L32
        if (pruneAndGetAllocationCount(r105, r110) > 0) goto L8;
        r103 = r103 + 1;     // Catch: Throwable -> L32
        long r106 = r110 - r105.f523895o;     // Catch: Throwable -> L32
        if (r106 <= r102) goto L5;
        r101 = r105;
        r102 = r106;
        goto L5
    L8:
        r104 = r104 + 1;     // Catch: Throwable -> L32
        goto L5
    L12:
        long r111 = this.keepAliveDurationNs;     // Catch: Throwable -> L32
        if (r102 < r111) goto L15;
    L28:
        this.connections.remove(r101);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        cvc.c.f(r101.f523885e);
        return 0;
    L15:
        if (r103 > this.maxIdleConnections) goto L28;
        if (r103 <= 0) goto L21;
        long r112 = r111 - r102;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return r112;
    L21:
        if (r104 <= 0) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L32
        return r111;
    L24:
        this.cleanupRunning = false;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return -1;
    L32:
        th = move-exception;
        throw th;
    }

    public boolean connectionBecameIdle(okhttp3.internal.connection.d r100) {
        if (r100.f523891k == false) goto L5;
    L9:
        this.connections.remove(r100);
        return true;
    L5:
        if (this.maxIdleConnections == 0) goto L9;
        notifyAll();
        return false;
    }

    public void put(okhttp3.internal.connection.d r100) {
        if (this.cleanupRunning == true) goto L5;
        this.cleanupRunning = true;
        executor.execute(this.cleanupRunnable);
    L5:
        this.connections.add(r100);
    }

    private int pruneAndGetAllocationCount(okhttp3.internal.connection.d r100, long r101) {
        List<Reference<StreamAllocation>> r102 = r100.f523894n;
        int r103 = 0;
    L3:
        ArrayList r104 = (ArrayList) r102;
        if (r103 >= r104.size()) goto L13;
        Reference r105 = (Reference) ListProtector.get(r104, r103);
        if (r105.get() != null) goto L7;
        hvc.g.f487396a.n("A connection to " + r100.f523883c.address().f523801a + " was leaked. Did you forget to close a response body?", ((StreamAllocation.a) r105).f523875a);
        ListProtector.remove(r104, r103);
        r100.f523891k = true;
        if (r104.isEmpty() == false) goto L3;
        r100.f523895o = r101 - this.keepAliveDurationNs;
        return 0;
    L7:
        r103 = r103 + 1;
        goto L3
    L13:
        return r104.size();
    }

    @Nullable
    public Socket deduplicate(okhttp3.a r100, StreamAllocation r101) {
        Iterator<okhttp3.internal.connection.d> r102 = this.connections.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        okhttp3.internal.connection.d r103 = r102.next();
        if (r103.g(r100, null) == false) goto L4;
        if (r103.f523888h == null) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L4;
        if (r103 == r101.connection()) goto L4;
        return r101.releaseAndAcquire(r103);
    L10:
        r104 = false;
        goto L11
    L16:
        return null;
    }

    public ConnectionPool(int r100, long r101, TimeUnit r102) {
        this.cleanupRunnable = new a(this);
        this.connections = new ArrayDeque();
        this.routeDatabase = new okhttp3.internal.connection.e();
        this.maxIdleConnections = r100;
        this.keepAliveDurationNs = r102.toNanos(r101);
        if (r101 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + r101);
    }

    @Nullable
    public okhttp3.internal.connection.d get(okhttp3.a r100, StreamAllocation r101, Route r102) {
        Iterator<okhttp3.internal.connection.d> r103 = this.connections.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        okhttp3.internal.connection.d r104 = r103.next();
        if (r104.g(r100, r102) == false) goto L4;
        r101.acquire(r104, true);
        return r104;
    L9:
        return null;
    }
}
