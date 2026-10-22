package okio;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class c extends j0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f523975h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Condition f523976i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f523977j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f523978k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static c f523979l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f523980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f523981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f523982g;

    public static final class a {
        public static c b() throws InterruptedException {
            c r100 = c.f523979l;
            Intrinsics.checkNotNull(r100);
            c r101 = r100.f523981f;
            if (r101 != null) goto L10;
            long r102 = System.nanoTime();
            c.f523976i.await(c.f523977j, TimeUnit.MILLISECONDS);
            c r103 = c.f523979l;
            Intrinsics.checkNotNull(r103);
            if (r103.f523981f == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r102) >= c.f523978k) goto L9;
            return null;
        L9:
            return c.f523979l;
        L10:
            long r104 = System.nanoTime();
            long r105 = r101.f523982g - r104;
            if (r105 <= 0) goto L14;
            c.f523976i.await(r105, TimeUnit.NANOSECONDS);
            return null;
        L14:
            c r106 = c.f523979l;
            Intrinsics.checkNotNull(r106);
            r106.f523981f = r101.f523981f;
            r101.f523981f = null;
            r101.f523980e = 2;
            return r101;
        }

        public a() {
        }

        public static final void a(c r100, long r101, boolean r102) {
            ReentrantLock r103 = c.f523975h;
            if (c.f523979l != null) goto L5;
            c.f523979l = new c();
            ThreadMethodProxy.start(new b());
        L5:
            long r104 = System.nanoTime();
            if (r101 == 0) goto L9;
            if (r102 == false) goto L9;
            r100.f523982g = Math.min(r101, r100.d() - r104) + r104;
        L13:
            long r105 = r100.f523982g - r104;
            c r106 = c.f523979l;
            Intrinsics.checkNotNull(r106);
        L14:
            c r107 = r106.f523981f;
            if (r107 == null) goto L20;
            Intrinsics.checkNotNull(r107);
            if (r105 < (r107.f523982g - r104)) goto L20;
            r106 = r106.f523981f;
            Intrinsics.checkNotNull(r106);
        L20:
            r100.f523981f = r106.f523981f;
            r106.f523981f = r100;
            if (r106 != c.f523979l) goto L28;
            c.f523976i.signal();
            return;
        L28:
            return;
        L9:
            if (r101 == 0) goto L11;
            r100.f523982g = r101 + r104;
            goto L13
        L11:
            if (r102 == false) goto L25;
            r100.f523982g = r100.d();
            goto L13
        L25:
            throw new AssertionError();
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class b extends PthreadThreadV2 {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L23:
            ReentrantLock r100 = c.f523975h;     // Catch: InterruptedException -> L20 Throwable -> L15
            ReentrantLock r101 = c.f523975h;     // Catch: InterruptedException -> L20 Throwable -> L15
            r101.lock();     // Catch: InterruptedException -> L20 Throwable -> L15
            c r102 = a.b();     // Catch: Throwable -> L12
            if (r102 == c.f523979l) goto L5;
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r101.unlock();     // Catch: InterruptedException -> L20 Throwable -> L15
            if (r102 == null) goto L23;
            r102.m();     // Catch: InterruptedException -> L20 Throwable -> L15
            goto L23
        L5:
            c.f523979l = null;     // Catch: Throwable -> L12
            r101.unlock();     // Catch: InterruptedException -> L20 Throwable -> L15
            return;
        L12:
            th = move-exception;
            r101.unlock();     // Catch: InterruptedException -> L20 Throwable -> L15
            throw th;     // Catch: InterruptedException -> L20 Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L19;
            return;
        L19:
            throw th;
        }
    }

    public void m() {
    }

    static {
        new a();
        ReentrantLock r100 = new ReentrantLock();
        f523975h = r100;
        f523976i = r100.newCondition();
        long r101 = TimeUnit.SECONDS.toMillis(60);
        f523977j = r101;
        f523978k = TimeUnit.MILLISECONDS.toNanos(r101);
    }

    public final void j() {
        long r100 = this.f524076c;
        boolean r101 = this.f524074a;
        if (r100 != 0) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        ReentrantLock r102 = f523975h;
        r102.lock();
    L17:
        th = move-exception;
        r102.unlock();
        throw th;
    L8:
        if (this.f523980e != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L16;
        this.f523980e = 1;     // Catch: Throwable -> L17
        a.a(this, r100, r101);     // Catch: Throwable -> L17
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r102.unlock();
        return;
    L16:
        throw new IllegalStateException("Unbalanced enter/exit".toString());     // Catch: Throwable -> L17
    L10:
        r103 = false;
        goto L11
    }

    public final boolean k() {
        ReentrantLock r100 = f523975h;
        r100.lock();
        int r101 = this.f523980e;     // Catch: Throwable -> L20
        boolean r102 = false;
        this.f523980e = 0;     // Catch: Throwable -> L20
        if (r101 != 1) goto L16;
        c r103 = f523979l;     // Catch: Throwable -> L20
    L6:
        if (r103 == null) goto L14;
        c r104 = r103.f523981f;     // Catch: Throwable -> L20
        if (r104 == this) goto L9;
        r103 = r104;
        goto L6
    L9:
        r103.f523981f = this.f523981f;     // Catch: Throwable -> L20
        this.f523981f = null;     // Catch: Throwable -> L20
        r100.unlock();
        return false;
    L14:
        throw new IllegalStateException("node was not found in the queue".toString());     // Catch: Throwable -> L20
    L16:
        if (r101 != 2) goto L18;
        r102 = true;
    L18:
        r100.unlock();
        return r102;
    L20:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public c() {
    }

    public IOException l(IOException r100) {
        InterruptedIOException r101 = new InterruptedIOException("timeout");
        if (r100 == null) goto L5;
        r101.initCause(r100);
    L5:
        return r101;
    }
}
