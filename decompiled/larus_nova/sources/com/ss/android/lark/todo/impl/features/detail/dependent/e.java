package com.ss.android.lark.todo.impl.features.detail.dependent;

import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskDependentSearchFragment f443085a;

    public e(TaskDependentSearchFragment r100) {
        this.f443085a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        TaskDependentSearchViewModel.Companion.TaskDependentType r101 = (TaskDependentSearchViewModel.Companion.TaskDependentType) r100;
        com.ss.android.lark.todo.impl.utils.i r102 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r101 != TaskDependentSearchViewModel.Companion.TaskDependentType.NEXT) goto L5;
        int r103 = R.string.Todo_GanttView_Blocking_MenuItem;
    L6:
        String r104 = r102.g(r103);
        this.f443085a.U90().setTitle(r104);
        return;
    L5:
        r103 = R.string.Todo_GanttView_BlockedBy_MenuItem;
        goto L6
    }
}
