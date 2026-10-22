package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeDisplayAdapter f442652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserBean f442653b;

    public a(TodoAssigneeDisplayAdapter r100, UserBean r101) {
        this.f442652a = r100;
        this.f442653b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f442652a.f442630b.a(this.f442653b.getId());
    }
}
