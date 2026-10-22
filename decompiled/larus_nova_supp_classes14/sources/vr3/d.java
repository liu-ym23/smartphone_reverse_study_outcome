package vr3;

import bs3.l;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public final void a() {
        Object r1 = b.C;
        monitor-enter(r1);
    L18:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "stopSceneMonitor");     // Catch: Throwable -> L22
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L5:
        if (((ArrayList) this.b.t).contains(this.a) == false) goto L15;
        if (com.bytedance.apm.d.j() == false) goto L9;
        b.a(new String[]{"stop monitor battery:" + this.a});     // Catch: Throwable -> L18
    L9:
        boolean r0 = this.b.l(false);     // Catch: Throwable -> L18
        Iterator r2 = ((ConcurrentHashMap) this.b.g).values().iterator();     // Catch: Throwable -> L18
    L11:
        if (r2.hasNext() == false) goto L13;
        ((l) r2.next()).d(r0);     // Catch: Throwable -> L18
        goto L11
    L13:
        ((ArrayList) this.b.t).remove(this.a);     // Catch: Throwable -> L18
        b.j(this.b);     // Catch: Throwable -> L18
        goto L20
    L15:
        if (com.bytedance.apm.d.j() == false) goto L20;
        b.a(new String[]{this.a + "is already stopped"});     // Catch: Throwable -> L18
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

    public d(b r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
