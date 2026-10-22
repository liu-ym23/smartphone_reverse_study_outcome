package com.ss.android.lark.todo.impl.features.detail.dependent;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskDependentSearchFragment f443086a;

    public f(TaskDependentSearchFragment r100) {
        this.f443086a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TaskDependentSearchFragment r102 = this.f443086a;
        int r103 = TaskDependentSearchFragment.f443049j;
        r102.X90(false);
    }
}
