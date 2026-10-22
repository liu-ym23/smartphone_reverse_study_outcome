package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListsManageView f442121a;

    public e(TaskListsManageView r100) {
        this.f442121a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.LayoutManager r100 = ((RecyclerView) this.f442121a.f442101a.findViewById(R.id.task_list_manage_lists)).getLayoutManager();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.scrollToPosition(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
