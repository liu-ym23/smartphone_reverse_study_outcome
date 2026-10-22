package okio;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f524073d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f524074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f524075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f524076c;

    public static final class a extends j0 {
        @Override // okio.j0
        public final j0 e(long r100) {
            return this;
        }

        @Override // okio.j0
        public final void g() {
        }

        @Override // okio.j0
        public final j0 h(long r100, TimeUnit r101) {
            Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
            return this;
        }

        public a() {
        }
    }

    public static final class b {
    }

    public j0() {
    }

    public j0 b() {
        this.f524074a = false;
        return this;
    }

    static {
        f524073d = new a();
    }

    public j0 c() {
        this.f524076c = 0;
        return this;
    }

    public long d() {
        if (this.f524074a == false) goto L7;
        return this.f524075b;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public void g() throws IOException {
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L13;
        if (this.f524074a == true) goto L7;
        return;
    L7:
        if ((this.f524075b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    L13:
        throw new InterruptedIOException("interrupted");
    }

    public boolean f() {
        return this.f524074a;
    }

    public long i() {
        return this.f524076c;
    }

    public void a(Condition r110) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(r110, "condition");
        boolean r100 = f();     // Catch: InterruptedException -> L25
        long r101 = i();     // Catch: InterruptedException -> L25
        if (r100 == false) goto L6;
    L9:
        if (r100 == true) goto L11;
    L13:
        if (r100 == true) goto L15;
    L17:
        if (r101 <= 0) goto L24;
        if (r110.awaitNanos(r101) <= 0) goto L22;
        return;
    L22:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L25
    L24:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L25
    L15:
        r101 = d() - System.nanoTime();
        goto L17
    L11:
        if (r101 == 0) goto L13;
        r101 = Math.min(r101, d() - System.nanoTime());     // Catch: InterruptedException -> L25
        goto L17
    L6:
        if (r101 != 0) goto L9;
        r110.await();     // Catch: InterruptedException -> L25
        return;
    L25:
        ThreadMethodProxy.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public j0 e(long r100) {
        this.f524074a = true;
        this.f524075b = r100;
        return this;
    }

    public j0 h(long r100, TimeUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.f524076c = r101.toNanos(r100);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }
}
