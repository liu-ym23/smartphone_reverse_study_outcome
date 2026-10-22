package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAdapter.ViewHolder f442694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AssigneeBean f442695b;

    public a(TodoAssigneeAdapter.ViewHolder r100, AssigneeBean r101) {
        this.f442694a = r100;
        this.f442695b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoDependencyHolder.a().messengerModuleDependency().a(this.f442694a.f442673a.getContext(), this.f442695b.getId());
    }
}
