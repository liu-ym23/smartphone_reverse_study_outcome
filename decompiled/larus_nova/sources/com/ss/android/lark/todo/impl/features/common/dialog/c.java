package com.ss.android.lark.todo.impl.features.common.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements TaskListSectionSortAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$1 f442432a;

    public c(ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$1 r100) {
        this.f442432a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.common.dialog.TaskListSectionSortAdapter.b
    public final void a(TaskListSectionSortAdapter.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        this.f442432a.startDrag(r100);
    }
}
