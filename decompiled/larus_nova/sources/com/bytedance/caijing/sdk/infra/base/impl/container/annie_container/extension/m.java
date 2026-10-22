package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f202421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f202422b;

    @Override // java.lang.Runnable
    public final void run() {
        monitor-enter(this);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L4:
        if (this.f202422b.getAndSet(true) == true) goto L6;
        this.f202421a.run();     // Catch: Throwable -> L9
    L6:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }

    public m(LoaderProxy.b r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f202421a = r100;
        this.f202422b = new AtomicBoolean(false);
    }
}
