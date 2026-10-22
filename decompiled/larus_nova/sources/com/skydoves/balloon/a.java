package com.skydoves.balloon;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Balloon f406131a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f406131a.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(Balloon r100) {
        Intrinsics.checkNotNullParameter(r100, "balloon");
        this.f406131a = r100;
    }
}
