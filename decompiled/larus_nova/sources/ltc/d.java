package ltc;

import com.bytedance.bmmt.video.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f510763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f510764e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Boolean f510765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Runnable> f510766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f510767c;

    static {
        d r100 = new d();
        r100.e();
        f510763d = r100;
        d r101 = new d();
        r101.a();
        f510764e = r101;
    }

    public final void a() {
        Object r100 = this.f510767c;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f510765a != null) goto L10;
        this.f510765a = Boolean.FALSE;     // Catch: Throwable -> L12
        Iterator r101 = ((ArrayList) this.f510766b).iterator();     // Catch: Throwable -> L12
    L8:
        if (r101.hasNext() == false) goto L10;
        ((Runnable) r101.next()).run();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public final boolean b() {
        Object r100 = this.f510767c;
        monitor-enter(r100);
        Boolean r101 = this.f510765a;     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (r101.booleanValue() == false) goto L9;
        r102 = true;
    L12:
        th = move-exception;
        throw th;
    }

    public final void e() {
        Object r100 = this.f510767c;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f510765a != null) goto L10;
        this.f510765a = Boolean.TRUE;     // Catch: Throwable -> L12
        Iterator r101 = ((ArrayList) this.f510766b).iterator();     // Catch: Throwable -> L12
    L8:
        if (r101.hasNext() == false) goto L10;
        ((Runnable) r101.next()).run();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public d() {
        this.f510765a = null;
        this.f510766b = new ArrayList();
        this.f510767c = new Object();
    }

    public static d d(Collection<d> r100) {
        if (r100.isEmpty() == true) goto L5;
        final d r101 = new d();
        final AtomicInteger r102 = new AtomicInteger(r100.size());
        final AtomicBoolean r103 = new AtomicBoolean();
        Iterator<d> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        final d r105 = r104.next();
        r105.f(new c(r105, r103, r102, r101));
        goto L8
    L10:
        return r101;
    L5:
        return f510763d;
    }

    public final void c(TimeUnit r100) {
        Object r101 = this.f510767c;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.f510765a == null) goto L7;
        boolean r102 = true;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (r102 == false) goto L11;
        return;
    L11:
        CountDownLatch r103 = new CountDownLatch(1);
        f(new m(r103));
        r103.await(10, r100);     // Catch: InterruptedException -> L14
        return;
    L14:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void f(Runnable r100) {
        Object r101 = this.f510767c;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f510765a == null) goto L7;
        boolean r102 = true;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L12
        if (r102 == false) goto L17;
        r100.run();
        return;
    L17:
        return;
    L7:
        ((ArrayList) this.f510766b).add(r100);     // Catch: Throwable -> L12
        r102 = false;
        goto L8
    }
}
