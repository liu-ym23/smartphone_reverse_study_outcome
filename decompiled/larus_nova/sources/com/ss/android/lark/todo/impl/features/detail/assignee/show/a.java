package com.ss.android.lark.todo.impl.features.detail.assignee.show;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import g7c.o;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeShowAdapter.ViewHolder f442754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f442755b;

    public a(TodoAssigneeShowAdapter.ViewHolder r100, d r101) {
        this.f442754a = r100;
        this.f442755b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        o r101 = TodoDependencyHolder.a().messengerModuleDependency();
        Context r102 = this.f442754a.f442741a.getContext();
        this.f442755b.getClass();
        r101.a(r102, null);
    }
}
