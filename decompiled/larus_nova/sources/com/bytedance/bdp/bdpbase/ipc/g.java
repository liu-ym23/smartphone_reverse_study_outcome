package com.bytedance.bdp.bdpbase.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f201172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f201173b;

    public final void a() {
        if (this.f201172a.f201223f.get() == true) goto L9;
        ITransfer r100 = this.f201173b.f201145j;
        v r101 = this.f201172a;
        StringBuilder r102 = new StringBuilder("connected=");
        if (r100 == null) goto L7;
        boolean r103 = true;
    L8:
        r102.append(r103);
        r102.append("-bindCount=");
        r102.append(this.f201173b.f201148m);
        r102.append("-alive=");
        r102.append(this.f201173b.e());
        String r104 = r102.toString();
        r101.getClass();
        r101.f201238u = System.nanoTime() - r101.f201236s;
        String r105 = "execute request " + r101.f201228k.b() + " fail, wait Binder overtime";
        g94.b.b("IPC_RemoteCall", new Object[]{r105});
        r101.c("remote_call_wait_overtime", r105, r104);
        goto L9
    L7:
        r103 = false;
    L9:
        Object r106 = this.f201173b.f201159x;
        monitor-enter(r106);
        this.f201173b.f201158w.remove(this.f201172a);     // Catch: Throwable -> L14
        monitor-exit(r106);     // Catch: Throwable -> L14
        return;
    L14:
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

    public g(e r100, v r101) {
        this.f201173b = r100;
        this.f201172a = r101;
    }
}
