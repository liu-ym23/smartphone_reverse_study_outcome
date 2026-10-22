package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import com.bytedance.ug.sdk.luckycat.impl.lynx.Statistics;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f271276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f271277b;

    public j(i r100, AtomicBoolean r101) {
        this.f271276a = r100;
        this.f271277b = r101;
    }

    public final void a() {
        if (this.f271277b.compareAndSet(false, true) == false) goto L11;
        this.f271276a.f271268b.set(false);
        this.f271276a.c(Statistics.Action.SUCCESS);
        Iterator r100 = this.f271276a.f271273g.iterator();
    L6:
        if (r100.hasNext() == false) goto L15;
        Function1 r101 = (Function1) r100.next();
        T r102 = this.f271276a.f271270d;
        if (r102 != 0) goto L10;
        Intrinsics.throwNpe();
    L10:
        r101.invoke(r102);
        goto L6
    L15:
        return;
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
}
