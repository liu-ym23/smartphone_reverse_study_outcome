package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends TaskBaseQuickAdapter {
    @Override // com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = super.getItemViewType(r100);
        if (r101 != 4) goto L8;
        MultiItemEntity r102 = (MultiItemEntity) ListProtector.get(this.f441366d, r100);
        if ((r102 instanceof TaskListDisplayItem) == false) goto L8;
        return ((TaskListDisplayItem) r102).getTaskListGuid().hashCode();
    L8:
        return r101;
    }

    public d(TaskListsManageView$taskListsManageAdapter$2.AnonymousClass1 r100, TaskListsManageView$taskListsManageAdapter$2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "differCallback");
        Intrinsics.checkNotNullParameter(r101, "itemProvider");
        super(r100, r101);
    }
}
