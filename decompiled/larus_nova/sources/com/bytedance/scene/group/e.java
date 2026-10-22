package com.bytedance.scene.group;

import com.bytedance.scene.Scene;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Scene f268709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f268710b;

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f268710b, this.f268709a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(b r100, Scene r101) {
        this.f268710b = r100;
        this.f268709a = r101;
    }
}
