package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoFollowerAdapter.ViewHolder f442737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.i f442738b;

    public n(TodoFollowerAdapter.ViewHolder r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.i r101) {
        this.f442737a = r100;
        this.f442738b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoDependencyHolder.a().messengerModuleDependency().a(this.f442737a.f442692a.getContext(), this.f442738b.f443883a);
    }
}
