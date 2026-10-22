package vr3;

import bs3.l;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f556838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f556839b;

    public final void a() {
        Object r100 = b.C;
        monitor-enter(r100);
    L18:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "stopSceneMonitor");     // Catch: Throwable -> L22
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L5:
        if (((ArrayList) this.f556839b.f556823t).contains(this.f556838a) == false) goto L15;
        if (com.bytedance.apm.d.j() == false) goto L9;
        ps3.b.a(new String[]{"stop monitor battery:" + this.f556838a});     // Catch: Throwable -> L18
    L9:
        boolean r101 = this.f556839b.l(false);     // Catch: Throwable -> L18
        Iterator r102 = ((ConcurrentHashMap) this.f556839b.f556810g).values().iterator();     // Catch: Throwable -> L18
    L11:
        if (r102.hasNext() == false) goto L13;
        ((l) r102.next()).d(r101);     // Catch: Throwable -> L18
        goto L11
    L13:
        ((ArrayList) this.f556839b.f556823t).remove(this.f556838a);     // Catch: Throwable -> L18
        b.j(this.f556839b);     // Catch: Throwable -> L18
        goto L20
    L15:
        if (com.bytedance.apm.d.j() == false) goto L20;
        ps3.b.a(new String[]{this.f556838a + "is already stopped"});     // Catch: Throwable -> L18
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

    public d(b r100, String r101) {
        this.f556839b = r100;
        this.f556838a = r101;
    }
}
