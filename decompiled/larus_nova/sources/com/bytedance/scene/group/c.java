package com.bytedance.scene.group;

import com.bytedance.scene.Scene;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Scene f268705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f268706b;

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f268706b, this.f268705a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, Scene r101) {
        this.f268706b = r100;
        this.f268705a = r101;
    }
}
