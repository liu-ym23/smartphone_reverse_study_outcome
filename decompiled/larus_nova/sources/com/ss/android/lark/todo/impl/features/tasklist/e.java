package com.ss.android.lark.todo.impl.features.tasklist;

import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444020a;

    public e(TaskListNameFragment r100) {
        this.f444020a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        this.f444020a.f444012i.dismiss();
        TaskListNameFragment r102 = this.f444020a;
        r102.f444013j = false;
        OperationToastHelper r103 = OperationToastHelper.f442443a;
        OperationToastHelper.b(r102.getContext(), 0, r101, null, null, 56);
    }
}
