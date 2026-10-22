package com.ss.android.lark.todo.impl.features.detail.assignee.add.mvvm;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAddFragment f442623a;

    public h(TodoAssigneeAddFragment r100) {
        this.f442623a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        TodoAssigneeAddFragment.S90(this.f442623a);
        return;
    }
}
