package com.bytedance.scene.navigation;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qa7.c f268812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f268813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.i f268814c;

    @Override // java.lang.Runnable
    public final void run() {
        e.d r100 = this.f268814c.f268801c.f268783g;     // Catch: Throwable -> L4
        qa7.c r101 = this.f268812a;     // Catch: Throwable -> L4
        ((ArrayList) r100.f268792a).remove(r101);     // Catch: Throwable -> L4
        this.f268813b.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(e.i r100, qa7.c r101) {
        e.b r102 = e.f268776m;
        this.f268814c = r100;
        this.f268812a = r101;
        this.f268813b = r102;
    }
}
