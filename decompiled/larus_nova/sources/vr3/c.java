package vr3;

import bs3.l;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f556836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f556837b;

    public final void a() {
        Object r100 = b.C;
        monitor-enter(r100);
    L18:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "startSceneMonitor");     // Catch: Throwable -> L22
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L5:
        if (((ArrayList) this.f556837b.f556823t).contains(this.f556836a) == false) goto L10;
        if (com.bytedance.apm.d.j() == false) goto L20;
        ps3.b.a(new String[]{this.f556836a + " is already monitoring"});     // Catch: Throwable -> L18
        goto L20
    L10:
        if (com.bytedance.apm.d.j() == false) goto L12;
        ps3.b.a(new String[]{"start monitor battery:" + this.f556836a});     // Catch: Throwable -> L18
    L12:
        boolean r101 = this.f556837b.l(false);     // Catch: Throwable -> L18
        Iterator r102 = ((ConcurrentHashMap) this.f556837b.f556810g).values().iterator();     // Catch: Throwable -> L18
    L14:
        if (r102.hasNext() == false) goto L16;
        ((l) r102.next()).i(r101);     // Catch: Throwable -> L18
        goto L14
    L16:
        ((ArrayList) this.f556837b.f556823t).add(this.f556836a);     // Catch: Throwable -> L18
        b.j(this.f556837b);     // Catch: Throwable -> L18
    L22:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, String r101) {
        this.f556837b = r100;
        this.f556836a = r101;
    }
}
