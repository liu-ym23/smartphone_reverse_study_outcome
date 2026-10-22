package j28;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.ee.bear.basesdk.apisupport.u;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f497024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f497025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i28.b f497026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<ILaunchTask, Object> f497027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f497028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedBlockingDeque<ILaunchTask> f497029f;

    public d(Context r100, i28.b r101) {
        this.f497029f = new LinkedBlockingDeque();
        this.f497024a = r100;
        this.f497026c = r101;
        this.f497028e = new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [j28.b, java.lang.Runnable] */
    public final void a(final Context r100, final Period r101) {
        e r102 = this.f497028e;
        monitor-enter(r102);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (f28.a.a(r102.f497034d) == false) goto L8;
        r102.c(r102.f497031a);     // Catch: Throwable -> L39
    L8:
        if (f28.a.a(r102.f497034d) == false) goto L11;
        monitor-exit(r102);
        ArrayList r103 = null;
    L23:
        if (f28.a.a(r103) == false) goto L25;
        return;
    L25:
        Iterator r104 = r103.iterator();
    L27:
        if (r104.hasNext() == false) goto L38;
        final ILaunchTask r105 = (ILaunchTask) r104.next();
        if (r105.g() == true) goto L30;
        this.f497029f.add(r105);
        goto L27
    L30:
        ?? r106 = new b(this, r100, r105, r101);
        if (r105.c() > 0) goto L32;
        this.f497026c.f488059c.execute(r106);
        goto L27
    L32:
        ExecutorService r107 = this.f497026c.f488059c;
        if ((r107 instanceof ScheduledExecutorService) == true) goto L34;
        f28.b.f475225a.schedule(new c(this, r106), r105.c(), TimeUnit.SECONDS);
        goto L27
    L34:
        ((ScheduledExecutorService) r107).schedule(r106, r105.c(), TimeUnit.SECONDS);
        goto L27
    L38:
        return;
    L11:
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L39
        Iterator r109 = ((ArrayList) r102.f497034d).iterator();     // Catch: Throwable -> L39
    L12:
        if (r109.hasNext() == false) goto L20;
        ILaunchTask r110 = (ILaunchTask) r109.next();     // Catch: Throwable -> L39
        if (r101 == null) goto L18;
        if (r110.d().getValue() > r101.getValue()) goto L12;
    L18:
        r108.add(r110);     // Catch: Throwable -> L39
        r109.remove();     // Catch: Throwable -> L39
        goto L12
    L20:
        monitor-exit(r102);
        r103 = r108;
        goto L23
    }

    public final void b(Context r100, ILaunchTask r101) {
        long r102 = SystemClock.uptimeMillis();
        r101.a(r100);     // Catch: Throwable -> L5
    L8:
        c(r101, SystemClock.uptimeMillis() - r102);
        return;
    L5:
        th = move-exception;
        g28.b.f479742a.e("[" + r101.f() + "]" + th.getMessage(), th);     // Catch: Throwable -> L11
        if (this.f497026c.f488057a == true) goto L8;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c(r101, SystemClock.uptimeMillis() - r102);
        throw th;
    }

    public final void c(ILaunchTask r100, long r101) {
        this.f497028e.c(r100);
        if (r100.g() == true) goto L5;
        this.f497027d.remove(r100);
    L5:
        h28.c r102 = this.f497026c.f488058b;
        if (r102 == null) goto L9;
        Class<?> r103 = r100.getClass();
        Map<String, String> r104 = ((u) r102).f206576a.f206583c;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r103.getSimpleName(), String.valueOf(r101));
        return;
    }
}
