package com.bytedance.locallife.biz.monitor.param;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskType f256765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f256766b;

    public final void a() {
        long r100 = System.currentTimeMillis();
        this.f256766b.invoke();     // Catch: Exception -> L5
        com.bytedance.locallife.biz.common.utils.c.d("LifePageParamTrace", "Task " + this.f256765a.name() + " completed in " + (System.currentTimeMillis() - r100) + "ms");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.locallife.biz.common.utils.c.c("LifePageParamTrace", "Error executing task " + this.f256765a.name() + " (" + (System.currentTimeMillis() - r100) + "ms): " + e.getMessage(), e);
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

    public i(TaskType r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "taskType");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        this.f256765a = r100;
        this.f256766b = r101;
    }
}
