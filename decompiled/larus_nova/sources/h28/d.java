package h28;

import android.content.Context;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j28.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j28.d f483631a;

    public final void b() {
        j28.d r100 = this.f483631a;
        if (r100.f497025b != null) goto L5;
        r100.f497025b = ThreadMethodProxy.currentThread();
    L5:
        e r101 = r100.f497028e;
        monitor-enter(r101);
        ConcurrentHashMap r102 = new ConcurrentHashMap();     // Catch: Throwable -> L26
        Iterator r103 = ((HashMap) r101.f497036f).values().iterator();     // Catch: Throwable -> L26
    L9:
        if (r103.hasNext() == false) goto L14;
        ILaunchTask r104 = (ILaunchTask) r103.next();     // Catch: Throwable -> L26
        if (r104.g() == true) goto L9;
        r102.put(r104, e.f497030g);     // Catch: Throwable -> L26
        goto L9
    L14:
        r102.remove(r101.f497031a);     // Catch: Throwable -> L26
        monitor-exit(r101);
        r100.f497027d = r102;
        Context r105 = r100.f497024a;
    L17:
        r100.a(r105, null);
        if (((ConcurrentHashMap) r100.f497027d).isEmpty() == true) goto L19;
        ILaunchTask r106 = r100.f497029f.take();     // Catch: InterruptedException -> L24
        if (r106 == null) goto L17;
        r100.b(r105, r106);     // Catch: InterruptedException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final void a(ILaunchTask r100) {
        e r101 = this.f483631a.f497028e;
        monitor-enter(r101);
        r101.b(r100, r100.e());     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public d(Context r100, i28.b r101) {
        this.f483631a = new j28.d(r100, r101);
    }
}
