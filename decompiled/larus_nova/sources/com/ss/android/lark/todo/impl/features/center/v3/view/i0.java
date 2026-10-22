package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;

/* JADX INFO: loaded from: classes38.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442042b;

    public i0(TaskItemViewHolder r100, TaskItem r101) {
        this.f442041a = r100;
        this.f442042b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t r100 = this.f442041a.f441925b;     // Catch: Throwable -> L4
        TaskItem r101 = this.f442042b;     // Catch: Throwable -> L4
        r100.j(r101.f441483a, r101.f441500r, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
