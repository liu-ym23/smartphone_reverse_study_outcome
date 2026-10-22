package com.ss.android.lark.todo.impl.features.common.dialog;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListSectionSortAdapter f442433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListSectionSortAdapter.ViewHolder f442434b;

    public d(TaskListSectionSortAdapter r100, TaskListSectionSortAdapter.ViewHolder r101) {
        this.f442433a = r100;
        this.f442434b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f442433a.f442419b.a(this.f442434b);
        return true;
    }
}
