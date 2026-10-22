package lx3;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile l f511165g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f511166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f511167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f511168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<Runnable> f511169f;

    public l() {
        super("TeaThread");
        this.f511167d = new Object();
        this.f511168e = false;
        this.f511169f = new LinkedList();
    }

    public static l d() {
        if (f511165g != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f511165g != null) goto L9;
        f511165g = new l();     // Catch: Throwable -> L11
        ThreadMethodProxy.start(f511165g);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f511165g;
    }

    public final Handler e() {
        if (this.f511166c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f511166c != null) goto L8;
        this.f511166c = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f511166c;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        Object r100 = this.f511167d;
        monitor-enter(r100);
        this.f511168e = true;     // Catch: Throwable -> L15
        ArrayList r101 = new ArrayList(this.f511169f);     // Catch: Throwable -> L15
        this.f511169f.clear();     // Catch: Throwable -> L15
        if (r101.isEmpty() == true) goto L13;
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L15
    L9:
        if (r102.hasNext() == false) goto L13;
        Runnable r103 = (Runnable) r102.next();     // Catch: Throwable -> L15
        if (r103 == null) goto L9;
        e().post(r103);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void b(Runnable r100) {
        if (this.f511168e == false) goto L5;
        e().postDelayed(r100, 0);
        return;
    L5:
        Object r101 = this.f511167d;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.f511168e == false) goto L11;
        e().postDelayed(r100, 0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L11:
        if (this.f511169f.size() <= 1000) goto L13;
        this.f511169f.poll();     // Catch: Throwable -> L16
    L13:
        this.f511169f.add(r100);     // Catch: Throwable -> L16
        goto L14
    }

    public final void f(Runnable r100) {
        e().removeCallbacks(r100);
    }
}
