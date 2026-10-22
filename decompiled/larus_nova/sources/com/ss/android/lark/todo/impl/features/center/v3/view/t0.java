package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListAdapter f442095a;

    public t0(TaskListAdapter r100) {
        this.f442095a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r100 = this.f442095a.f441950e.iterator();     // Catch: Throwable -> L9
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L19;
        int r102 = r101 + 1;     // Catch: Throwable -> L9
        if ((((com.ss.android.lark.todo.impl.features.center.v3.data.a) r100.next()) instanceof SectionHeaderItem) == false) goto L8;
        this.f442095a.notifyItemChanged(r101);     // Catch: Throwable -> L9
    L8:
        r101 = r102;
        goto L4
    L19:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
