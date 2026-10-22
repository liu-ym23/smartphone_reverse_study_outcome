package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListAdapter f442133a;

    public w0(TaskListAdapter r100) {
        this.f442133a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskListAdapter r100 = this.f442133a;     // Catch: Throwable -> L4
        r100.f441950e = TaskListAdapter.A2(r100.f441951f, r100.f441952g, r100.f441953h);     // Catch: Throwable -> L4
        TaskListAdapter r101 = this.f442133a;     // Catch: Throwable -> L4
        r101.f441949d.submitList(r101.f441950e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
