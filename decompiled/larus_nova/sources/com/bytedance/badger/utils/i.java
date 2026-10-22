package com.bytedance.badger.utils;

import com.bytedance.badger.monitor.TriggerStage;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f199262a = null;

    static {
        f199262a = new i();
    }

    public i() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.badger.C.b r100 = x64.b.f562608a;     // Catch: Throwable -> L4
        x64.b.a(new x64.l(TriggerStage.periodic_first, 23, true, null, null, null, 56), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
