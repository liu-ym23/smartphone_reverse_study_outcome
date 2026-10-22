package com.ss.android.lark.todo.impl.features.tasklist;

import androidx.lifecycle.Observer;
import com.suite.lark.emm.design.edittext.SCUDEditText;

/* JADX INFO: loaded from: classes38.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444018a;

    public c(TaskListNameFragment r100) {
        this.f444018a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SCUDEditText r101 = this.f444018a.T90();
        r101.setText((String) r100);
        r101.post(new b(r101));
    }
}
