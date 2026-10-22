package com.bytedance.scene.group;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.f f268711a;

    @Override // java.lang.Runnable
    public final void run() {
        b.f r100 = this.f268711a;     // Catch: Throwable -> L4
        b.a(r100.f268693j, r100.f268694a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(b.f r100) {
        this.f268711a = r100;
    }
}
